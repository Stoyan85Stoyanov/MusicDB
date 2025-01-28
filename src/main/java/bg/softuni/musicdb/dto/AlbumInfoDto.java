package bg.softuni.musicdb.dto;

import bg.softuni.musicdb.entity.Album;
import bg.softuni.musicdb.entity.Artist;
import bg.softuni.musicdb.enums.ArtistName;
import bg.softuni.musicdb.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistName getArtistName() {
        return artistName;
    }

    public void setArtistName(ArtistName artistName) {
        this.artistName = artistName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }


}
