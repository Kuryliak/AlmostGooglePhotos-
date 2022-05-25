package roman.ua.springphotosearch.infrastructure.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import roman.ua.springphotosearch.app.UserService;
import roman.ua.springphotosearch.domain.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private UserService userService;

    @Autowired
    public AuthorController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<Author> getAuthors() {
        return userService.getAuthorList();
    }
}
