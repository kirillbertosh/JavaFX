package sample.models.invoices;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CancellationAct {

    private StringProperty number;
    private StringProperty actDate;
    private StringProperty inputDate;
    private StringProperty cancellationDate;
    private StringProperty name;
    private StringProperty measure;
    private StringProperty amount;
    private StringProperty notes;

    public CancellationAct() {
        this(null, null, null, null, null, null, null, null);
    }

    public CancellationAct(String number, String actDate, String inputDate,
                           String cancellationDate, String name, String measure,
                           String amount, String notes) {
        this.number = new SimpleStringProperty(number);
        this.actDate = new SimpleStringProperty(actDate);
        this.inputDate = new SimpleStringProperty(inputDate);
        this.cancellationDate = new SimpleStringProperty(cancellationDate);
        this.name = new SimpleStringProperty(name);
        this.measure = new SimpleStringProperty(measure);
        this.amount = new SimpleStringProperty(amount);
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

    public String getActDate() {
        return actDate.get();
    }

    public StringProperty actDateProperty() {
        return actDate;
    }

    public void setActDate(String actDate) {
        this.actDate.set(actDate);
    }

    public String getInputDate() {
        return inputDate.get();
    }

    public StringProperty inputDateProperty() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate.set(inputDate);
    }

    public String getCancellationDate() {
        return cancellationDate.get();
    }

    public StringProperty cancellationDateProperty() {
        return cancellationDate;
    }

    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate.set(cancellationDate);
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
