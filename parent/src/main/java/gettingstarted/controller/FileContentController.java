package gettingstarted.controller;

import child.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileContentController {
	@Autowired
	private FileService fileService;

	@PostMapping("/files")
	public ResponseEntity<File> createFile(@RequestBody File file) {
		return ResponseEntity.ok(fileService.create(file));
	}
	
	@RequestMapping(value="/files/{fileId}", method = RequestMethod.PUT)
	public ResponseEntity<File> setContent(@PathVariable("fileId") Long id, @RequestParam("file") MultipartFile file)
			throws IOException {
		return ResponseEntity.ok(fileService.saveContent(id, file.getContentType(), file.getInputStream()));
	}

	@RequestMapping(value="/files/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<?> getContent(@PathVariable("fileId") Long id) throws IOException {
		StreamInfo streamInfo = fileService.getContent(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentLength(streamInfo.getContentLength());
		headers.set("Content-Type", streamInfo.getContentType());
		return new ResponseEntity<Object>(streamInfo.getInputStreamResource().getInputStream(), headers, HttpStatus.OK);
	}
}