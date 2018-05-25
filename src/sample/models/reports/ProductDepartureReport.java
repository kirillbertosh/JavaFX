package sample.models.reports;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductDepartureReport {

    private StringProperty number;
    private StringProperty name;
    private StringProperty measure;
    private StringProperty amount;
    private StringProperty price;
    private StringProperty date;
    private StringProperty total;
    private StringProperty notes;

    public ProductDepartureReport() {
        this(null, null, null, null, null, null, null, null);
    }

    public ProductDepartureReport(String number, String name, String measure, String amount,
                                  String price, String date, String total,String notes) {
        this.number = new SimpleStringProperty(number);
        this.name = new SimpleStringProperty(name);
        this.measure = new SimpleStringProperty(measure);
        this.amount = new SimpleStringProperty(amount);
        this.price = new SimpleStringProperty(price);
        this.date = new SimpleStringProperty(date);
        this.total = new SimpleStringProperty(total);
        this.notes = new SimpleStringProperty(notes);
    }

    public String getNumber() {
        return number.get();
    }

    public StringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getMeasure() {
        return measure.get();
    }

    public StringProperty measureProperty() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure.set(measure);
    }

    public String getAmount() {
        return amount.get();
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTotal() {
        return total.get();
    }

    public StringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set(total);
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }
}
