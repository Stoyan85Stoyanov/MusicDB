package bg.softuni.musicdb.repository;

import bg.softuni.musicdb.entity.Artist;
import bg.softuni.musicdb.enums.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {

    Optional<Artist> findByName(ArtistName name);
}
