package sample.models.reports;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExpenditureDynamicReport {

    private StringProperty number;
    private StringProperty name;
    private StringProperty measure;
    private StringProperty startMonthBalance;
    private StringProperty arrivedDuringMonth;
    private StringProperty departedDuringMonth;
    private StringProperty month;
    private StringProperty endMonthBalance;

    public ExpenditureDynamicReport() {
        this(null, null, null, null, null, null, null, null);
    }

    public ExpenditureDynamicReport(String number,
                                    String name,
                                    String measure,
                                    String startMonthBalance,
                                    String arrivedDuringMonth,
                                    String departedDuringMonth,
                                    String month,
                                    String endMonthBalance) {
        this.number = new SimpleStringProperty(number);
        this.name = new SimpleStringProperty(name);
        this.measure = new SimpleStringProperty(measure);
        this.startMonthBalance = new SimpleStringProperty(startMonthBalance);
        this.arrivedDuringMonth = new SimpleStringProperty(arrivedDuringMonth);
        this.departedDuringMonth = new SimpleStringProperty(departedDuringMonth);
        this.month = new SimpleStringProperty(month);
        this.endMonthBalance = new SimpleStringProperty(endMonthBalance);
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

    public String getStartMonthBalance() {
        return startMonthBalance.get();
    }

    public StringProperty startMonthBalanceProperty() {
        return startMonthBalance;
    }

    public void setStartMonthBalance(String startMonthBalance) {
        this.startMonthBalance.set(startMonthBalance);
    }

    public String getArrivedDuringMonth() {
        return arrivedDuringMonth.get();
    }

    public StringProperty arrivedDuringMonthProperty() {
        return arrivedDuringMonth;
    }

    public void setArrivedDuringMonth(String arrivedDuringMonth) {
        this.arrivedDuringMonth.set(arrivedDuringMonth);
    }

    public String getDepartedDuringMonth() {
        return departedDuringMonth.get();
    }

    public StringProperty departedDuringMonthProperty() {
        return departedDuringMonth;
    }

    public void setDepartedDuringMonth(String departedDuringMonth) {
        this.departedDuringMonth.set(departedDuringMonth);
    }

    public String getMonth() {
        return month.get();
    }

    public StringProperty monthProperty() {
        return month;
    }

    public void setMonth(String month) {
        this.month.set(month);
    }

    public String getEndMonthBalance() {
        return endMonthBalance.get();
    }

    public StringProperty endMonthBalanceProperty() {
        return endMonthBalance;
    }

    public void setEndMonthBalance(String endMonthBalance) {
        this.endMonthBalance.set(endMonthBalance);
    }
}
