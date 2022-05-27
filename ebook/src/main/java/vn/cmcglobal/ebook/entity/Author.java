package vn.cmcglobal.ebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer yearOfBirth;

    @Column
    private String description;

    @Column
    private String website;

    @Column
    private String organization;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties(value = "author")
    private List<Ebook> ebooks;
}
