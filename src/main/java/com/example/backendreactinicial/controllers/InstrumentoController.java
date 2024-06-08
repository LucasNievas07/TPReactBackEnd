package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.Instrumento;
import com.example.backendreactinicial.repositories.InstrumentoRepository;
import com.example.backendreactinicial.services.InstrumentoServiceImpl;
import com.example.backendreactinicial.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/instrumento")
public class InstrumentoController extends BaseControllerImpl<Instrumento, InstrumentoServiceImpl> {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> generatePdf(@PathVariable Long id) {
        Optional<Instrumento> instrumentoOptional = instrumentoRepository.findById(id);

        if (!instrumentoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Instrumento instrumento = instrumentoOptional.get();
        ByteArrayInputStream bis = pdfService.generateInstrumentoPdf(instrumento);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + instrumento.getInstrumento() + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
