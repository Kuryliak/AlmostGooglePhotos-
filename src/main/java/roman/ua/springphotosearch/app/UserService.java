package roman.ua.springphotosearch.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.ua.springphotosearch.domain.Author;


@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Author> getAuthorList() {
        return userRepository.findAll();
    }
}

