package sample.models.directory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Measure {

    private StringProperty name;
    private StringProperty abbreviation;

    public Measure() {
        this(null, null);
    }

    public Measure(String name, String abbreviation) {
        this.name = new SimpleStringProperty(name);
        this.abbreviation = new SimpleStringProperty(abbreviation);
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

    public String getAbbreviation() {
        return abbreviation.get();
    }

    public StringProperty abbreviationProperty() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation.set(abbreviation);
    }
}
