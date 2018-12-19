package quytn.eas.common;

import java.time.LocalDate;
import java.time.YearMonth;

public final class DateUtil {

    public static CustomeDate prevMonth(String category, CustomeDate customeDate) {
        switch (category) {
            case "month":
                if (customeDate.getMonth() == 1) {
                    customeDate.setMonth(12);
                    customeDate.setYear(customeDate.getYear() - 1);
                } else {
                    customeDate.setMonth(customeDate.getMonth() - 1);
                }
                break;
            case "quarter":
                if (customeDate.getQuarter() == 1) {
                    customeDate.setQuarter(4);
                    customeDate.setYear(customeDate.getYear() - 1);
                } else {
                    customeDate.setQuarter(customeDate.getQuarter() - 1);
                }
                break;
            case "year":
                customeDate.setYear(customeDate.getYear() - 1);
                break;
        }
        return customeDate;
    }


    public static CustomeDate NextMonth(String category, CustomeDate customeDate) {
        switch (category) {
            case "month":
                if (customeDate.getMonth() == 12) {
                    customeDate.setMonth(1);
                    customeDate.setYear(customeDate.getYear() + 1);
                } else {
                    customeDate.setMonth(customeDate.getMonth() + 1);
                }
                break;
            case "quarter":
                if (customeDate.getQuarter() == 4) {
                    customeDate.setQuarter(1);
                    customeDate.setYear(customeDate.getYear() + 1);
                } else {
                    customeDate.setQuarter(customeDate.getQuarter() + 1);
                }
                break;
            case "year":
                customeDate.setYear(customeDate.getYear() + 1);
                break;
        }
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
                YearMonth yearMonth = YearMonth.of(customeDate.getYear(), (customeDate.getQuarter() - 1) * 3 + 1);
                localDate = localDate.withDayOfMonth(1).withMonth(yearMonth.getMonth().firstMonthOfQuarter().getValue()).withYear(customeDate.getYear());
                break;
            case "year":
                localDate = localDate.withYear(customeDate.getYear()).withMonth(1).withDayOfMonth(1);
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
                YearMonth yearMonth1 = YearMonth.of(customeDate.getYear(), customeDate.getQuarter() * 3);
                int lastMonthInQuarter = yearMonth1.getMonth().firstMonthOfQuarter().getValue() + 2;
                localDate = localDate.withYear(customeDate.getYear()).withMonth(lastMonthInQuarter).withDayOfMonth(YearMonth.of(customeDate.getYear(), lastMonthInQuarter).lengthOfMonth());
                break;
            case "year":
                localDate = localDate.withYear(customeDate.getYear()).withMonth(12).withDayOfMonth(31);
                break;
        }
        return localDate;
    }

    public static int getDayNumberBetween(LocalDate begin, LocalDate end){
        int result = 1;
        while (!begin.isEqual(end)){
            begin = begin.plusDays(1);
            result++;
        }
        return result;
    }
}
