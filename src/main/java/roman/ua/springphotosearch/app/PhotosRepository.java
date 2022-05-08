package roman.ua.springphotosearch.app;

import org.springframework.data.repository.CrudRepository;
import roman.ua.springphotosearch.domain.Photo;

public interface PhotosRepository extends CrudRepository<Photo,Integer> {
}