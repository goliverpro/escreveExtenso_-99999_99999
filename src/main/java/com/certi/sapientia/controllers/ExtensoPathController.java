package com.certi.sapientia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.certi.sapientia.services.ExtensoPathService;

@RestController
public class ExtensoPathController {

    @Autowired
    private ExtensoPathService service;

    @GetMapping
    @RequestMapping(value ="/{valor}")
    public String retornaValorExtenso(@PathVariable Integer valor){

        return  service.retornaValorExtenso(valor);
    }
}
