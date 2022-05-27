package vn.cmcglobal.ebook.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private int quantity;
    @ManyToOne
    @JoinColumn(name = "ebook_id")
    private Ebook ebook;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
