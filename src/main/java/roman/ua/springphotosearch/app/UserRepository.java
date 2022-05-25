package roman.ua.springphotosearch.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import roman.ua.springphotosearch.domain.Author;

@Repository
public interface UserRepository extends CrudRepository<Author, String> {
}
