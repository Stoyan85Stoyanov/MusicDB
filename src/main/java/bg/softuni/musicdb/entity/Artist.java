package bg.softuni.musicdb.entity;

import bg.softuni.musicdb.enums.ArtistName;
import jakarta.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArtistName name;

    @Column(name = "career_information", nullable = false, columnDefinition = "TEXT")
    private String careerInformation;


    public Artist() {
    }

    public Artist(ArtistName name, String s) {
        this.setName(name);
        this.setCareerInformation(s);
    }

    public ArtistName getName() {
        return name;
    }

    public void setName(ArtistName name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
