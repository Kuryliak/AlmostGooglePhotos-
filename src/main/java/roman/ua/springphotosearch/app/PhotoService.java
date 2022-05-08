package roman.ua.springphotosearch.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.ua.springphotosearch.domain.Photo;

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
                           byte[] data) {
        Photo photo = new Photo();

        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);

        photosRepository.save(photo);

        return photo;
    }
}