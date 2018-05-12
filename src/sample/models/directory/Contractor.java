package sample.models.directory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contractor {

    private StringProperty number;
    private StringProperty name;
    private StringProperty phone;

    public Contractor() {
        this(null, null, null);
    }

    public Contractor(String number, String name, String phone) {
        this.number = new SimpleStringProperty(number);
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
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

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
}
