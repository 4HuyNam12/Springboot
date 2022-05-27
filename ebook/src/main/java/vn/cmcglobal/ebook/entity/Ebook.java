package vn.cmcglobal.ebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column
    private String title;

    private String isbn;

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonIgnoreProperties(value = "ebooks")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    @JsonIgnoreProperties(value = "ebooks")
    private Publisher publisher;

    @Column
    private Date publishedDate;

    @Column
    private Integer pages;

    @Column
    private Long price;

    @Column
    private Integer quantity;

    @Column
    private boolean deleted;

    @OneToOne(mappedBy = "ebook", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "ebook")
    private OrderDetail orderDetail;
}
