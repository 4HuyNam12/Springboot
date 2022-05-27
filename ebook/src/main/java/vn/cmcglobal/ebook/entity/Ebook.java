package vn.cmcglobal.ebook.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="ebook")
public class Ebook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @NaturalId
    private String isbn;
    private String description;
    private Long authorId;
    private Long publisherId;

    @Temporal(TemporalType.DATE)
    @Column(name = "published_date")
    private Date publishedDate;
    private Integer pages;
    private Long price;
    private Integer quantity;
    private boolean deleted;
    @OneToMany(mappedBy ="ebook" )
    List<OrderDetail> orderDetails;
}
