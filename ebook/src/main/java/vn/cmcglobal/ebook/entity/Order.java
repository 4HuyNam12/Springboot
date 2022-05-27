package vn.cmcglobal.ebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private long id;
    private long customerId;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createdDate = new Date();
    @OneToOne()
    @JoinColumn(name = "orderdetail_id")
    OrderDetail orderDetails;
=======
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private Date createdDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties(value = "order")
    private List<OrderDetail> orderDetails;
>>>>>>> f67cd82e4aac1e09948f3ada9cf1874a4edd7c1b
}
