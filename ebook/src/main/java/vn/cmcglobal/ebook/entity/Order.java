package vn.cmcglobal.ebook.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long customerId;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createdDate = new Date();
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
