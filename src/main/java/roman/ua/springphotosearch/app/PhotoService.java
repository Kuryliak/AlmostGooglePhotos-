package roman.ua.springphotosearch.app;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import roman.ua.springphotosearch.domain.Photo;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PhotoService {
    private HashMap<String, Photo> tempDb = new HashMap<>() {{
        put("1", new Photo("1", "cat neko"));
        put("2", new Photo("2", "ben dog"));
        put("3", new Photo("3", "egor cat"));
    }};

    public Collection<Photo> getPhotoList() {
        return tempDb.values();
    }

    public Photo getPhotoById(String id) {
        Photo photo = tempDb
            .get(id);

        if (photo == null) throw new
            ResponseStatusException
            (HttpStatus
                .NOT_FOUND);

        return photo;
    }

    public void removePhoto(String id) {
        Photo photo = tempDb.remove(id);
        if (photo == null) throw new
            ResponseStatusException
            (HttpStatus
                .NOT_FOUND);

    }

    public Photo savePhoto(String fileName,
                           String contentType,
                           byte[] data) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID
            .randomUUID()
            .toString());

        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);

        tempDb.put(photo.getId(), photo);

        return photo;
    }

}
