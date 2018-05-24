package sample.models.journals;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CommonJournal {

    private StringProperty number;
    private StringProperty type;
    private StringProperty date;
    private StringProperty measure;
    private StringProperty name;
    private StringProperty amount;
    private StringProperty notes;

    public CommonJournal() {
        this(null, null,null, null, null, null, null);
    }

    public CommonJournal(String number, String type,String date, String measure, String name, String amount, String notes) {
        this.number = new SimpleStringProperty(number);
        this.type = new SimpleStringProperty(type);
        this.date = new SimpleStringProperty(date);
        this.measure = new SimpleStringProperty(measure);
        this.name = new SimpleStringProperty(name);
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

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
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

    public String getMeasure() {
        return measure.get();
    }

    public StringProperty measureProperty() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure.set(measure);
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
