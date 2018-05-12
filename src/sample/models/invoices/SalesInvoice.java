package sample.models.invoices;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesInvoice {

    private StringProperty number;
    private StringProperty name;
    private StringProperty measure;
    private StringProperty amount;
    private StringProperty priceWithoutDiscount;
    private StringProperty discount;
    private StringProperty addedValueTax;
    private StringProperty sumAddedValueTax;
    private StringProperty totalPrice;
    private StringProperty date;

    public SalesInvoice() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public SalesInvoice(String number, String date, String name, String measure,
                        String amount, String withoutDiscountPrice, String discount, String addedValueTax,
                        String addedValueTaxSum, String totalPrice) {
        this.number = new SimpleStringProperty(number);
        this.date = new SimpleStringProperty(date);
        this.name = new SimpleStringProperty(name);
        this.measure = new SimpleStringProperty(measure);
        this.amount = new SimpleStringProperty(amount);
        this.priceWithoutDiscount = new SimpleStringProperty(withoutDiscountPrice);
        this.discount = new SimpleStringProperty(discount);
        this.addedValueTax = new SimpleStringProperty(addedValueTax);
        this.sumAddedValueTax = new SimpleStringProperty(addedValueTaxSum);
        this.totalPrice = new SimpleStringProperty(totalPrice);
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

    public String getPriceWithoutDiscount() {
        return priceWithoutDiscount.get();
    }

    public StringProperty priceWithoutDiscountProperty() {
        return priceWithoutDiscount;
    }

    public void setPriceWithoutDiscount(String priceWithoutDiscount) {
        this.priceWithoutDiscount.set(priceWithoutDiscount);
    }

    public String getDiscount() {
        return discount.get();
    }

    public StringProperty discountProperty() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }

    public String getAddedValueTax() {
        return addedValueTax.get();
    }

    public StringProperty addedValueTaxProperty() {
        return addedValueTax;
    }

    public void setAddedValueTax(String addedValueTax) {
        this.addedValueTax.set(addedValueTax);
    }

    public String getSumAddedValueTax() {
        return sumAddedValueTax.get();
    }

    public StringProperty sumAddedValueTaxProperty() {
        return sumAddedValueTax;
    }

    public void setSumAddedValueTax(String sumAddedValueTax) {
        this.sumAddedValueTax.set(sumAddedValueTax);
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

    public String getTotalPrice() {
        return totalPrice.get();
    }

    public StringProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice.set(totalPrice);
    }
}
