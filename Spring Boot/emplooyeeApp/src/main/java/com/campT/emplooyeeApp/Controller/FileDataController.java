package com.campT.emplooyeeApp.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.campT.emplooyeeApp.Entity.FileData;
import com.campT.emplooyeeApp.Repository.FileDataRepository;

@RestController @RequestMapping("/api")
public class FileDataController {

	@Autowired
	private FileDataRepository repo;
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file ) throws IOException
	{
		FileData f = new FileData();
		f.setFileName(file.getOriginalFilename());
		f.setFieldType(file.getContentType());
		f.setData(file.getBytes());
		
		FileData saved = repo.save(f);
		return "File Saved with id : "+saved.getId();
	}
	
	@GetMapping("download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable long id)
	{
		FileData file = repo.findById(id).orElseThrow(()-> new RuntimeException("File Not Found with id "+id));
		return ResponseEntity.ok()
				.header (HttpHeaders.CONTENT_DISPOSITION,
				"inline;filename=\"" + file.getFileName()) //inline,attachment
				.header (HttpHeaders.CONTENT_TYPE, file.getFieldType())
				.body(file.getData());
	}
}
