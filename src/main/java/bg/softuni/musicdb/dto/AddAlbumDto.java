package bg.softuni.musicdb.dto;

import bg.softuni.musicdb.enums.ArtistName;
import bg.softuni.musicdb.enums.Genre;
import jakarta.validation.constraints.*;
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
public class AddAlbumDto {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 5)
    private String imageUrl;

    @NotBlank
    @Size(min = 5)
    private String description;

    @NotNull
    @Min(10)
    private Integer copies;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Past
    private LocalDate releaseDate;


    private String producer;

    @NotNull
    private Genre genre;

    @NotNull
    private ArtistName artist;

}
