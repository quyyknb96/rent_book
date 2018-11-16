package quytn.eas.common;

import java.time.LocalDate;
import java.time.YearMonth;

public class DateUtil {

    public static CustomeDate prevMonth(CustomeDate customeDate) {
        if (customeDate.getMonth() == 1) {
            customeDate.setMonth(12);
            customeDate.setYear(customeDate.getYear() - 1);
        } else {
            customeDate.setMonth(customeDate.getMonth() - 1);
        }
        return customeDate;
    }

    public static CustomeDate prevQuarter(CustomeDate customeDate) {
        if (customeDate.getQuarter() == 1) {
            customeDate.setQuarter(4);
            customeDate.setYear(customeDate.getYear() - 1);
        } else {
            customeDate.setQuarter(customeDate.getQuarter() - 1);
        }
        return customeDate;
    }

    public static CustomeDate prevYear(CustomeDate customeDate) {
        customeDate.setYear(customeDate.getYear() - 1);
        return customeDate;
    }

    public static boolean isBefore(CustomeDate target, CustomeDate source) {
        if (target.getYear() < source.getYear()) {
            return true;
        }
        if (target.getYear() == source.getYear() && target.getQuarter() < source.getQuarter()) {
            return true;
        }
        if (target.getYear() == source.getYear() && target.getQuarter() == source.getQuarter() && target.getMonth() < source.getMonth()) {
            return true;
        }
        return false;
    }

    public static CustomeDate getCustomeDateByLocalDate(LocalDate localDate) {
        CustomeDate customeDate = new CustomeDate();
        customeDate.setMonth(localDate.getMonthValue());
        customeDate.setYear(localDate.getYear());
        customeDate.setQuarter(localDate.getMonthValue() % 3 == 0 ? localDate.getMonthValue()/3 : localDate.getMonthValue()/3 + 1);
        return customeDate;
    }

    public static LocalDate getFirstDay(String category, CustomeDate customeDate) {
        LocalDate localDate = LocalDate.now();
        switch (category){
            case "month":
                localDate = localDate.withDayOfMonth(1).withMonth(customeDate.getMonth()).withYear(customeDate.getYear());
                break;
            case "quarter":
                YearMonth yearMonth = YearMonth.of(customeDate.getYear(), customeDate.getMonth());
                localDate = localDate.withDayOfMonth(1).withMonth(yearMonth.getMonth().firstMonthOfQuarter().getValue()).withYear(customeDate.getYear());
                break;
            case "year":
                localDate = localDate.withYear(customeDate.getYear()).withMonth(customeDate.getMonth()).withDayOfMonth(1);
                break;
        }
        return localDate;
    }

    public static LocalDate getLastDay(String category, CustomeDate customeDate) {
        LocalDate localDate = LocalDate.now();
        switch (category){
            case "month":
                localDate = localDate.withMonth(customeDate.getMonth()).withYear(customeDate.getYear());
                YearMonth yearMonth = YearMonth.of(customeDate.getYear(), customeDate.getMonth());
                localDate = localDate.withDayOfMonth(yearMonth.lengthOfMonth());
                break;
            case "quarter":
                YearMonth yearMonth1 = YearMonth.of(customeDate.getYear(), customeDate.getMonth());
                int lastMonthInQuarter = yearMonth1.getMonth().firstMonthOfQuarter().getValue() + 2;
                localDate = localDate.withYear(customeDate.getYear()).withMonth(lastMonthInQuarter).withDayOfMonth(YearMonth.of(customeDate.getYear(), lastMonthInQuarter).lengthOfMonth());
                break;
            case "year":
                localDate = localDate.withYear(customeDate.getYear()).withMonth(12).withDayOfMonth(31);
                break;
        }
        return localDate;
    }
}
