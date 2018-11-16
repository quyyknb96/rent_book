package quytn.eas.common;

public class CustomeDate {
    private int month;
    private int quarter;
    private int year;

    public CustomeDate() {
    }

    public CustomeDate(int month, int quarter, int year) {
        this.month = month;
        this.quarter = quarter;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
