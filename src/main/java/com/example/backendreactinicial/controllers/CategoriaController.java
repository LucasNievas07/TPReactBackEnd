package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.Categoria;
import com.example.backendreactinicial.services.CategoriaServiceImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/categoria")
public class CategoriaController extends BaseControllerImp<Categoria, CategoriaServiceImp>{
}