package jpatest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name="category")
@Data
@Entity(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(orphanRemoval = false,cascade=CascadeType.ALL,mappedBy="category")
    private List<Product> products;
}






