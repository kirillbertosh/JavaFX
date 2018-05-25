package sample.models.reports;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductBalanceReport {

    private StringProperty number;
    private StringProperty name;
    private StringProperty measure;
    private StringProperty amountInStorage;
    private StringProperty storage;
    private StringProperty notes;

    public ProductBalanceReport() {
        this(null, null, null, null, null, null);
    }

    public ProductBalanceReport(String number, String name, String measure,
                                String amountInStorage, String storage, String notes) {
        this.number = new SimpleStringProperty(number);
        this.name = new SimpleStringProperty(name);
        this.measure = new SimpleStringProperty(measure);
        this.amountInStorage = new SimpleStringProperty(amountInStorage);
        this.storage = new SimpleStringProperty(storage);
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

    public String getAmountInStorage() {
        return amountInStorage.get();
    }

    public StringProperty amountInStorageProperty() {
        return amountInStorage;
    }

    public void setAmountInStorage(String amountInStorage) {
        this.amountInStorage.set(amountInStorage);
    }

    public String getStorage() {
        return storage.get();
    }

    public StringProperty storageProperty() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage.set(storage);
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
