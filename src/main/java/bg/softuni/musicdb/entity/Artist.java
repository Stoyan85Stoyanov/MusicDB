package bg.softuni.musicdb.entity;

import bg.softuni.musicdb.enums.ArtistName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "artists")
public class Artist extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArtistName name;

    @Column(name = "career_information", nullable = false, columnDefinition = "TEXT")
    private String careerInformation;

    public Artist(ArtistName name, String s) {
        this.setName(name);
        this.setCareerInformation(s);
    }
}
