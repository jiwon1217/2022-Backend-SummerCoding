package com.landvibe.summer.jpa.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ColumnDefault("0")
    private Integer count;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public void updateCount() {
        this.count = this.products.size();
    }

    public void addProduct(Product product) {
        this.getProducts().add(product);
    }

    public void deleteProduct(Product product) {
        this.getProducts().remove(product);
    }
}