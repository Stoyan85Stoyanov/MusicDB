package bg.softuni.musicdb.dto;

import bg.softuni.musicdb.entity.Album;
import bg.softuni.musicdb.enums.ArtistName;
import bg.softuni.musicdb.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumInfoDto {

    private String id;

    private String name;

    private ArtistName artistName;

    private Genre genre;

    private BigDecimal price;

    private LocalDate releaseDate;

    private Integer copies;

    private String imageUrl;

    public AlbumInfoDto(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.artistName = album.getArtist().getName();
        this.genre = album.getGenre();
        this.price = album.getPrice();
        this.releaseDate = album.getReleaseDate();
        this.copies = album.getCopies();
        this.imageUrl = album.getImageUrl();
    }
}
