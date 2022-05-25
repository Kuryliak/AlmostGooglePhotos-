package roman.ua.springphotosearch.infrastructure.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roman.ua.springphotosearch.app.PhotoService;
import roman.ua.springphotosearch.domain.Photo;

import java.io.IOException;

@RestController
public class PhotoController {

    private PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/photosList")
    public Iterable<Photo> getPhotos() {
        return photoService
                .getPhotoList();
    }

    @GetMapping("/photosList/{id}")
    public Photo getPhotoById(@PathVariable Integer id) {
        return photoService
                .getPhotoById(id);
    }


    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        photoService
                .removePhoto(id);
    }


    @PostMapping("/photosList")
    public Photo createPhoto(@RequestPart("data") MultipartFile file)
            throws IOException {

        Photo photoModel = new Photo();
        photoModel.setFileName(file.getOriginalFilename());
        photoModel.setContentType(file.getContentType());
        photoModel.setData(file.getBytes());


        return photoService.savePhoto(photoModel.getFileName(),
                photoModel.getContentType(),
                photoModel.getData());

    }
}