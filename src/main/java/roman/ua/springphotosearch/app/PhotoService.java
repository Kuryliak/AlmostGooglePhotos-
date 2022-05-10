package roman.ua.springphotosearch.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.ua.springphotosearch.domain.NotAllowedContentTypeException;
import roman.ua.springphotosearch.domain.Photo;

import java.util.Collection;
import java.util.List;

@Service
public class PhotoService {
    private PhotosRepository photosRepository;

    @Autowired
    public PhotoService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public Iterable<Photo> getPhotoList() {
        return photosRepository.findAll();
    }

    public Photo getPhotoById(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public void removePhoto(Integer id) {
        photosRepository.deleteById(id);

    }

    public Photo savePhoto(String fileName,
                           String contentType,
                           byte[] data) throws NotAllowedContentTypeException {

        Photo photo = new Photo();

        photo.setFileName(fileName);
        photo.setContentType(contentType);


        /// TODO: 5/10/22 parse this exception to front-end
        if (!ALLOWED_CONTENT_TYPE.contains(contentType)) {
            throw new NotAllowedContentTypeException(
                    contentType + " should be a " + ALLOWED_CONTENT_TYPE);
        }

        photo.setData(data);
        photosRepository.save(photo);

        return photo;
    }

    public static Collection<String> ALLOWED_CONTENT_TYPE = List.of("image/png", "image/jpeg");
}