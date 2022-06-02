package vn.cmcglobal.ebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Ebook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(unique = true,nullable = false)
    @NotBlank
    private String isbn;

    @Column
    private String description;




    @Column
    @Temporal(TemporalType.DATE)
    private Date publishedDate;

    @Column
    private Integer pages;

    @Column
    private Long price;

    @Column
    private Integer quantity;

    @Column
    private boolean deleted;



}
