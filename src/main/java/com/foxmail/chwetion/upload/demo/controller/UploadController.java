package com.foxmail.chwetion.upload.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        long startTime = System.currentTimeMillis();
        if (file.isEmpty()) {
            return "empty";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println();
        System.out.println();
        return (file.getSize() / 1024) / ((endTime - startTime) / 1000.0) + "kb/s";
    }
}
