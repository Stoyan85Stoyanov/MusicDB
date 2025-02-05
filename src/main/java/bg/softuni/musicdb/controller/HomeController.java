package bg.softuni.musicdb.controller;

import bg.softuni.musicdb.config.UserSession;
import bg.softuni.musicdb.dto.AlbumInfoDto;
import bg.softuni.musicdb.entity.Album;
import bg.softuni.musicdb.enums.ArtistName;
import bg.softuni.musicdb.service.AlbumService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final UserSession userSession;
    private final AlbumService albumService;


    public HomeController(UserSession userSession, AlbumService albumService) {
        this.userSession = userSession;
        this.albumService = albumService;
    }


    @GetMapping("/")
    public String nonLoggedIndex() {

        if(userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    @Transactional
    public String loggedInIndex(Model model) {

        if(!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        List<AlbumInfoDto> allAlbums = albumService.listAlbums().stream().map(AlbumInfoDto::new).toList();

        model.addAttribute("allAlbums", allAlbums);

        int sum = 0;
        for (AlbumInfoDto album : allAlbums) {
            sum += album.getCopies();
        }

        model.addAttribute("sum", sum);
        return "home";
    }
    //        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        int sum = 0;
//        for (Integer number : numbers) {
//            sum += number;
//        }

}
