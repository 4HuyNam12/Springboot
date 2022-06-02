package jpatest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name="product")
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne()
    private Category category;
    @ManyToMany()
    private List<Tag> tags;

}
