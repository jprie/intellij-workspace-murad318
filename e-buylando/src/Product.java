import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    enum Category { KLEIDUNG, SCHMUCK, SCHUHE }

    private String productName;
    private String brand;
    private Category category;
    private BigDecimal price;
    private BigDecimal rating;

    public Product(String productName, String brand, Category category, BigDecimal price, BigDecimal rating) {
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) && Objects.equals(brand, product.brand) && category == product.category && Objects.equals(price, product.price) && Objects.equals(rating, product.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, brand, category, price, rating);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}
