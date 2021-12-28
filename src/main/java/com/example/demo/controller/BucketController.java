package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.AWSS3;

@RestController
public class BucketController {

	@Autowired
	private AWSS3 awss3Service;
	
	@PostMapping(path="/save")
	public ResponseEntity<String> saveS3(@RequestPart(value="file") MultipartFile file) {
		awss3Service.uploadFile(file);
		String response = "El archivo "+file.getOriginalFilename()+" fue cargado correctamente a S3";
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<String>> listFiles() {
		return new ResponseEntity<List<String>>(awss3Service.getObjectsFromS3(), HttpStatus.OK);
	}
	
}
