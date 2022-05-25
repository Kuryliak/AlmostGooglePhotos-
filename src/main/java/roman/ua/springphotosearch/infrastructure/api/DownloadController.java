package roman.ua.springphotosearch.infrastructure.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import roman.ua.springphotosearch.app.DownloadService;

@RestController
public class DownloadController {

    private DownloadService downloadService;

    @Autowired
    public DownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        return downloadService.download(id);
    }
}