package sample.models.invoices;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ComingInvoice {

    private StringProperty number;
    private StringProperty date;
    private StringProperty contractor;
    private StringProperty name;
    private StringProperty measure;
    private StringProperty amount;
    private StringProperty withoutDiscountPrice;
    private StringProperty discount;
    private StringProperty addedValueTax;
    private StringProperty addedValueTaxSum;
    private StringProperty totalPrice;
    private StringProperty storageNumber;

    public ComingInvoice() {
        this(null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public ComingInvoice(String number, String date, String contractor, String name, String measure,
                         String amount, String withoutDiscountPrice, String discount, String addedValueTax,
                         String addedValueTaxSum, String totalPrice, String storageNumber) {
        this.number = new SimpleStringProperty(number);
        this.date = new SimpleStringProperty(date);
        this.contractor = new SimpleStringProperty(contractor);
        this.name = new SimpleStringProperty(name);
        this.measure = new SimpleStringProperty(measure);
        this.amount = new SimpleStringProperty(amount);
        this.withoutDiscountPrice = new SimpleStringProperty(withoutDiscountPrice);
        this.discount = new SimpleStringProperty(discount);
        this.addedValueTax = new SimpleStringProperty(addedValueTax);
        this.addedValueTaxSum = new SimpleStringProperty(addedValueTaxSum);
        this.totalPrice = new SimpleStringProperty(totalPrice);
        this.storageNumber = new SimpleStringProperty(storageNumber);
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

    public String getContractor() {
        return contractor.get();
    }

    public StringProperty contractorProperty() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor.set(contractor);
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

    public String getTotalPrice() {
        return totalPrice.get();
    }

    public StringProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public String getWithoutDiscountPrice() {
        return withoutDiscountPrice.get();
    }

    public StringProperty withoutDiscountPriceProperty() {
        return withoutDiscountPrice;
    }

    public void setWithoutDiscountPrice(String withoutDiscountPrice) {
        this.withoutDiscountPrice.set(withoutDiscountPrice);
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

    public String getAddedValueTaxSum() {
        return addedValueTaxSum.get();
    }

    public StringProperty addedValueTaxSumProperty() {
        return addedValueTaxSum;
    }

    public void setAddedValueTaxSum(String addedValueTaxSum) {
        this.addedValueTaxSum.set(addedValueTaxSum);
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

    public String getStorageNumber() {
        return storageNumber.get();
    }

    public StringProperty storageNumberProperty() {
        return storageNumber;
    }

    public void setStorageNumber(String storageNumber) {
        this.storageNumber.set(storageNumber);
    }
}
