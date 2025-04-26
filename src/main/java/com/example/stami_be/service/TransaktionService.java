//Die Logik
package com.example.stami_be.service;

import com.example.stami_be.model.Transaktion;
import com.example.stami_be.repository.TransaktionRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransaktionService {

    @Autowired
    private TransaktionRepository repository;

    public void saveFromExcel(MultipartFile file) throws Exception {
        List<Transaktion> transaktionen = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Kopfzeile überspringen

            //String datum = row.getCell(0).getStringCellValue();
            String kaufVerkauf = row.getCell(1).getStringCellValue();
            String ticker = row.getCell(2).getStringCellValue();
            int anzahl = (int) row.getCell(3).getNumericCellValue();
            double preis = row.getCell(4).getNumericCellValue();

            Transaktion t = new Transaktion(kaufVerkauf, ticker, anzahl, preis);
            transaktionen.add(t);
        }

        workbook.close();
        repository.saveAll(transaktionen);
    }

    public List<Transaktion> getAllTransaktionen() {
        return repository.findAll();
    }
}
