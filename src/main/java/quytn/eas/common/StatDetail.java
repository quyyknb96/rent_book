package quytn.eas.common;

import quytn.eas.entity.Users;

import java.time.LocalDate;
import java.util.Date;

public class StatDetail {

    private String userName;
    private Date invoiceDate;
    private int rentTotal;
    private float costTotal;

    public StatDetail() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(int rentTotal) {
        this.rentTotal = rentTotal;
    }

    public float getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(float costTotal) {
        this.costTotal = costTotal;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }
}
