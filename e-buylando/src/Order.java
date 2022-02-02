import exception.OrderParsingException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Order implements Comparable<Order> {

    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int BRAND_INDEX = 1;
    private static final int CATEGORY_INDEX = 2;
    private static final int PRICE_INDEX = 3;
    private static final int RATING_INDEX = 4;
    private static final int FIRST_NAME_INDEX = 5;
    private static final int LAST_NAME_INDEX = 6;
    private static final int GENDER_INDEX = 7;
    private static final int DATE_INDEX = 8;
    private static final int PAYMENT_INFO_INDEX = 9;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Product product;
    private Customer customer;
    private LocalDate date;
    private PaymentInfo paymentInfo;

    public static Optional<Order> fromArray(String[] details) {
        Order order = null;
        try {
            validateOrderDetails(details);
            order = createOrder(details);

        } catch (OrderParsingException e) {

            System.err.println(e.getMessage());
        }
        return Optional.ofNullable(order);
    }

    private static Order createOrder(String[] details) throws OrderParsingException {

        String productName = details[PRODUCT_NAME_INDEX];
        String brandName = details[BRAND_INDEX];
        Product.Category category = Product.Category.valueOf(details[CATEGORY_INDEX].toUpperCase());
        BigDecimal price = new BigDecimal(details[PRICE_INDEX].replace(',', '.'));
        BigDecimal rating = new BigDecimal(details[RATING_INDEX].replace(',', '.'));

        Product product = new Product(productName, brandName, category, price, rating);

        String firstName = details[FIRST_NAME_INDEX];
        String lastName = details[LAST_NAME_INDEX];
        Customer.Gender gender = Customer.Gender.valueOf(details[GENDER_INDEX].toUpperCase());
        Customer customer = new Customer(firstName, lastName, gender);
        LocalDate date = LocalDate.parse(details[DATE_INDEX], formatter);
        PaymentInfo paymentInfo = PaymentInfo.of(details[PAYMENT_INFO_INDEX]);

        return new Order(product, customer, date,paymentInfo);

    }

    private static void validateOrderDetails(String[] details) throws OrderParsingException {

        ArrayList<Object> detailsList = new ArrayList<>();
        if (details.length == PAYMENT_INFO_INDEX +1) return;


        throw new OrderParsingException("Order with details: " + Arrays.toString(details) + " could not be parsed");
    }

    public Order(Product product, Customer customer, LocalDate date, PaymentInfo paymentInfo) {
        this.product = product;
        this.customer = customer;
        this.date = date;
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", customer=" + customer +
                ", date=" + date +
                ", paymentInfo=" + paymentInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(product, order.product) && Objects.equals(customer, order.customer) && Objects.equals(date, order.date) && Objects.equals(paymentInfo, order.paymentInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, customer, date, paymentInfo);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public int compareTo(Order o) {
        return product.getProductName().compareTo(o.getProduct().getProductName());
    }
}
