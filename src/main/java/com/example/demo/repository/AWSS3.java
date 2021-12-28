package com.example.demo.repository;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3 {
	
	void uploadFile(MultipartFile file);
	List<String> getObjectsFromS3();

}
