package bg.softuni.musicdb.controller;

import bg.softuni.musicdb.config.UserSession;
import bg.softuni.musicdb.dto.AddAlbumDto;
import bg.softuni.musicdb.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AlbumController {

    private final AlbumService albumService;
    private final UserSession userSession;

    public AlbumController(AlbumService albumService, UserSession userSession) {
        this.albumService = albumService;
        this.userSession = userSession;
    }

    @ModelAttribute("albumData")
    public AddAlbumDto AlbumData() {
        return new AddAlbumDto();
    }

    @GetMapping("/add-album")
    public String addAlbum() {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }
        return "add-album";
    }

    @PostMapping("/add-album")
    public String doAddAlbum(
            @Valid AddAlbumDto data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumData", bindingResult);

            return "redirect:/add-album";
        }

        boolean success = albumService.create(data);

        if (!success) {
            redirectAttributes.addFlashAttribute("albumData", data);

            return "redirect:/add-album";
        }
        return "redirect:/home";
    }
    // Delete button !!!
    @DeleteMapping("/albums/{id}")
    public String deleteAlbum(@PathVariable String id) {
        albumService.delete(id);
       return "redirect:/home";
    }

//    @GetMapping("/albums/{id}")
//    public String deleteAlbum(@PathVariable String id) {
//        albumService.delete(id);
//        return "redirect:/home";
//    }
}
