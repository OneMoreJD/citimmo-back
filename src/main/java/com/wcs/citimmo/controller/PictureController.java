package com.wcs.citimmo.controller;

import com.wcs.citimmo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PictureController {

   @Autowired
   PictureService pictureService;

   List<String> files = new ArrayList<String>();
   private final Path rootLocation = Paths.get("./src/main/resources/static/img");

   @PostMapping("/uploadFile")
   public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
      String message;
      System.out.println("nom fichier image : " + file.getResource().getFilename());
      try {
         try {
            Files.copy(file.getInputStream(),  this.rootLocation.resolve(file.getResource().getFilename()));
         } catch (Exception e) {
            throw new RuntimeException("FAIL!");
         }
         files.add(file.getOriginalFilename());

         message = "Successfully uploaded!";
         return ResponseEntity.status(HttpStatus.OK).body(message);
      } catch (Exception e) {
         message = "Failed to upload!";
         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
      }
   }
}
