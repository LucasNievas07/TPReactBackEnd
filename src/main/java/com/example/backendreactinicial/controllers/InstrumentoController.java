package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.Instrumento;
import com.example.backendreactinicial.services.InstrumentoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/instrumento")
public class InstrumentoController extends BaseControllerImpl<Instrumento, InstrumentoServiceImpl> {
}
