package bg.softuni.musicdb.service;

import bg.softuni.musicdb.config.UserSession;
import bg.softuni.musicdb.dto.AddAlbumDto;
import bg.softuni.musicdb.dto.AlbumInfoDto;
import bg.softuni.musicdb.entity.Album;
import bg.softuni.musicdb.entity.Artist;
import bg.softuni.musicdb.entity.User;
import bg.softuni.musicdb.enums.ArtistName;
import bg.softuni.musicdb.repository.AlbumRepository;
import bg.softuni.musicdb.repository.ArtistRepository;
import bg.softuni.musicdb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final UserSession userSession;
    private final UserRepository userRepository;

    public AlbumService(AlbumRepository albumRepository, ArtistRepository artistRepository, UserSession userSession, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    public boolean create(AddAlbumDto data) {

        if (!userSession.isLoggedIn()) {
            return false;
        }

        Optional<User> byId = userRepository.findById(userSession.id());

        if (byId.isEmpty()) {
            return false;
        }

        Optional<Artist> byName = artistRepository.findByName(data.getArtist());

        if (byName.isEmpty()) {
            return false;
        }

        Album album = new Album();
        album.setName(data.getName());
        album.setImageUrl(data.getImageUrl());
        album.setPrice(data.getPrice());
        album.setCopies(data.getCopies());
        album.setReleaseDate(data.getReleaseDate());
        album.setProducer(data.getProducer());
        album.setArtist(byName.orElse(null));
        album.setGenre(data.getGenre());
        album.setDescription(data.getDescription());
        album.setAddedFrom(byId.get());

        albumRepository.save(album);

        return true;
    }

    public Map<ArtistName, List<Album>> findAllByArtist() {
        Map<ArtistName, List<Album>> result = new HashMap<>();

        List<Artist> allArtists = artistRepository.findAll();

        for (Artist artist : allArtists) {
            List<Album> albums = albumRepository.findAllByArtist(artist.getName());
            result.put(artist.getName(), albums);
        }

        return result;
    }

    public List<Album> listAlbums(){
        return albumRepository.findAllAlbums();
    }


    public void delete(String id) {

        albumRepository.deleteById(id);;
    }
}
