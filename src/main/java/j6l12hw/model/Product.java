package j6l12hw.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String name;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"),
            foreignKey = @ForeignKey(name = "fk_orders_products_orders")
    )
    List<Order> orders;

    public String getCustomers() {
        return orders.stream()
                .map(o -> o.getCustomer())
                .distinct()
                .map(c -> c.getName())
                .sorted()
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return name;
    }
}
