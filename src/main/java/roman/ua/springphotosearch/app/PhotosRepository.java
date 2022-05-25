package roman.ua.springphotosearch.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import roman.ua.springphotosearch.domain.Photo;

@Repository
public interface PhotosRepository extends CrudRepository<Photo,Integer> {
}