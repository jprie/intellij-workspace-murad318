import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Buylando {

    // Idee: Einlesen von Bestellungen

    public static void main(String[] args) {

        System.out.println(Path.of(".").toAbsolutePath());
        try {
            Set<Order> orders = Files.lines(Path.of("./e-buylando/Bestellungen.txt"))
                    .map(line -> line.split(";"))
                    .map(Order::fromArray)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toCollection(TreeSet::new));
//                    .forEach(System.out::println);

            orders.stream().filter(o -> o.getPaymentInfo().getStatus() == PaymentInfo.PaymentStatus.OPEN);

            orders.stream()
                    .filter(o -> o.getCustomer().getFirstName().equals("Martin"))
                    .filter(o -> o.getPaymentInfo().getStatus() == PaymentInfo.PaymentStatus.OPEN);

            orders.stream()
                    .map(Order::getProduct)
                    .sorted(Comparator.comparing(Product::getRating))
                    .limit(3);

            orders.stream()
                    .filter(o -> o.getDate().isAfter(LocalDate.ofYearDay(2022, 1)))
                    .peek(System.out::println)
                    .count();

            orders.stream()
                    .map(Order::getProduct)
                    .sorted(Comparator.comparing(Product::getPrice))
                    .limit(5);

            orders.stream()
                    .filter(o -> o.getDate().isAfter(LocalDate.now().minusWeeks(2)));

            orders.stream()
                    .map(Order::getProduct)
                    .filter(p -> p.getCategory() == Product.Category.KLEIDUNG)
                    .map(Product::getPrice)
                    .mapToDouble(BigDecimal::doubleValue)
                    .sum();

            double sumNike = orders.stream()
                    .map(Order::getProduct)
                    .filter(p -> p.getBrand().equals("Nike"))
                    .map(Product::getPrice)
                    .mapToDouble(BigDecimal::doubleValue)
                    .sum();

            double total = orders.stream()
                    .map(Order::getProduct)
                    .map(Product::getPrice)
                    .mapToDouble(BigDecimal::doubleValue)
                    .sum();

            double percentageNike = total / sumNike;
            System.out.println(total);
            System.out.println(sumNike);
            System.out.println(percentageNike);






        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
