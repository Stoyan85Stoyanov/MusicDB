package bg.softuni.musicdb.repository;

import bg.softuni.musicdb.entity.Album;
import bg.softuni.musicdb.entity.User;
import bg.softuni.musicdb.enums.ArtistName;
import bg.softuni.musicdb.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    Optional<Album> findByName(Genre genre);

     List<Album> findAllByArtist(ArtistName artist);

     @Query("SELECT a FROM Album a")
     List<Album> findAllAlbums();

    Optional<Album> findByIdAndAddedFrom(String id, User user);

}
