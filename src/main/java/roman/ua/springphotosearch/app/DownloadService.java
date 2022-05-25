package roman.ua.springphotosearch.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import roman.ua.springphotosearch.domain.Photo;

@Service
public class DownloadService {
    private PhotoService photoService;

    @Autowired
    public DownloadService(PhotoService photoService) {
        this.photoService = photoService;
    }

    public ResponseEntity<byte[]> download(Integer id) {
        Photo photo = photoService.getPhotoById(id);

        if (photo == null) throw new
                ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.getData();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.valueOf(
                                                  photo.
                                                  getContentType()));

        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();

        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
