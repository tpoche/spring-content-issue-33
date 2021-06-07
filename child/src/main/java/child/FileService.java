package child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FileService {
    @Autowired
    private FileRepository filesRepo;

    @Autowired
    private FileContentStore contentStore;

    public File create(File f) {
        return filesRepo.save(f);
    }

    public File saveContent(Long id, String contentType, InputStream inputStream) {
        File f = filesRepo.getOne(id);
        f.setMimeType(contentType);

        contentStore.setContent(f, inputStream);

        // save updated content-related info
        return filesRepo.save(f);
    }

    public StreamInfo getContent(Long id) {
        File f = filesRepo.getOne(id);
        StreamInfo info = new StreamInfo();
        info.setContentLength(f.getContentLength());
        info.setContentType(f.getMimeType());
        info.setInputStreamResource(new InputStreamResource(contentStore.getContent(f)));
        return info;
    }
}
