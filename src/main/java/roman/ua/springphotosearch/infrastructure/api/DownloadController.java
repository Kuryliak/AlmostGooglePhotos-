package roman.ua.springphotosearch.infrastructure.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import roman.ua.springphotosearch.app.PhotoService;
import roman.ua.springphotosearch.domain.Photo;

@RestController
public class DownloadController {
    PhotoService photoService;

    @Autowired
    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        Photo photo = photoService.getPhotoById(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.getData();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.valueOf(photo.getContentType()));

        ContentDisposition build = ContentDisposition
            .builder("attachment")
            .filename(photo.getFileName())
            .build();

        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
