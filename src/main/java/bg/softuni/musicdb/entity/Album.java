package bg.softuni.musicdb.entity;

import bg.softuni.musicdb.enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "albums")
public class Album extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer copies;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    private String producer;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Genre genre;

    @ManyToOne(optional = false)
    private Artist artist;

    @ManyToOne(optional = false)
    private User addedFrom;

}
