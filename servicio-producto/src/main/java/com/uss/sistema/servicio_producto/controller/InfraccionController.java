package com.uss.sistema.servicio_producto.controller;

import com.uss.sistema.servicio_producto.entity.Infraccion;
import com.uss.sistema.servicio_producto.service.InfraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("infracciones")
public class InfraccionController {

    @Autowired
    private InfraccionService service;

    @GetMapping
    public ResponseEntity<List<Infraccion>> getAll() {
        List<Infraccion> infracciones = service.getAll();
        return new ResponseEntity<>(infracciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infraccion> get(@PathVariable("id") int id) {
        Infraccion infraccion = service.get(id);
        if (infraccion != null) {
            return new ResponseEntity<>(infraccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Infraccion> create(@RequestBody Infraccion infraccion) {
        Infraccion nuevaInfraccion = service.create(infraccion);
        return new ResponseEntity<>(nuevaInfraccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Infraccion> update(@PathVariable("id") int id, @RequestBody Infraccion infraccion) {
        infraccion.setId(id);
        Infraccion infraccionActualizada = service.update(infraccion);
        if (infraccionActualizada != null) {
            return new ResponseEntity<>(infraccionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Infraccion> delete(@PathVariable("id") int id) {
        Infraccion infraccion = service.delete(id);
        if (infraccion != null) {
            return new ResponseEntity<>(infraccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<Infraccion> anular(@PathVariable("id") int id) {
        Infraccion infraccionAnulada = service.anular(id);
        if (infraccionAnulada != null) {
            return new ResponseEntity<>(infraccionAnulada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

