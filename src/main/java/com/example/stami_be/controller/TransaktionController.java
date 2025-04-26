package com.example.stami_be.controller;

import com.example.stami_be.model.Transaktion;
import com.example.stami_be.service.TransaktionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/transaktionen")
public class TransaktionController {

    @Autowired
    private TransaktionService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            service.saveFromExcel(file);
            return ResponseEntity.ok("Datei erfolgreich hochgeladen und gespeichert!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fehler beim Verarbeiten der Datei!");
        }
    }

    @GetMapping
    public ResponseEntity<List<Transaktion>> getAllTransaktionen() {
        List<Transaktion> transaktionen = service.getAllTransaktionen();
        return ResponseEntity.ok(transaktionen);
    }
}