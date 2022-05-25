package roman.ua.springphotosearch.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import roman.ua.springphotosearch.domain.Photo;

import java.util.Collection;

import static java.util.List.of;

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

    public Photo savePhoto(
            String fileName,
            String contentType,
            byte[] data) {

        Photo photoToDb = new Photo();

        photoToDb.setFileName(fileName);
        photoToDb.setContentType(contentType);
        photoToDb.setData(data);


        if (!ALLOWED_CONTENT_TYPE.contains(contentType)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Uploaded content should be an image!");
        }
        return photoToDb;
    }

    public static Collection<String> ALLOWED_CONTENT_TYPE = of("image/png", "image/jpeg");
}