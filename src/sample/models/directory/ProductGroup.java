package sample.models.directory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductGroup {

    private StringProperty number;
    private StringProperty name;
    private StringProperty parentGroup;

    public ProductGroup() {
        this(null, null, null);
    }

    public ProductGroup(String number, String name, String parentGroup) {
        this.number = new SimpleStringProperty(number);
        this.name = new SimpleStringProperty(name);
        this.parentGroup = new SimpleStringProperty(parentGroup);
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

    public String getParentGroup() {
        return parentGroup.get();
    }

    public StringProperty parentGroupProperty() {
        return parentGroup;
    }

    public void setParentGroup(String parentGroup) {
        this.parentGroup.set(parentGroup);
    }
}
