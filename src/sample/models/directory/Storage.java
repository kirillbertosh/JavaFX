package sample.models.directory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Storage {

    private StringProperty number;
    private StringProperty name;
    private StringProperty address;

    public Storage() {
        this(null, null, null);
    }

    public Storage(String number, String name, String address) {
        this.number = new SimpleStringProperty(number);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
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

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
