package quytn.eas.common;

public class Stat {
    private String category;
    private CustomeDate customeDate;
    private String label;
    private Float totalCost;

    public Stat() {
    }

    public Stat(String category, CustomeDate customeDate, String label, Float totalCost) {
        this.category = category;
        this.customeDate = customeDate;
        this.label = label;
        this.totalCost = totalCost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CustomeDate getCustomeDate() {
        return customeDate;
    }

    public void setCustomeDate(CustomeDate customeDate) {
        this.customeDate = customeDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }
}
