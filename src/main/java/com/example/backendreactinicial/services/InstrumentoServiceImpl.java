package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.Instrumento;
import com.example.backendreactinicial.repositories.BaseRepository;
import com.example.backendreactinicial.repositories.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentoServiceImpl extends BaseServiceImpl<Instrumento, Long> implements InstrumentoService{

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    public InstrumentoServiceImpl(BaseRepository<Instrumento, Long> baseRepository, InstrumentoRepository instrumentoRepository){
        super(baseRepository);
        this.instrumentoRepository = instrumentoRepository;
    }
}
