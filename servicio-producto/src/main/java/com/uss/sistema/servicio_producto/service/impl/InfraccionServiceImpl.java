package com.uss.sistema.servicio_producto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uss.sistema.servicio_producto.entity.Infraccion;
import com.uss.sistema.servicio_producto.repository.InfraccionRepository;
import com.uss.sistema.servicio_producto.service.InfraccionService;

@Service
public class InfraccionServiceImpl implements InfraccionService {

    @Autowired
    private InfraccionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Infraccion> getAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Infraccion get(int id) {
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Infraccion create(Infraccion infraccion) {
        try {
            return repository.save(infraccion);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Infraccion update(Infraccion infraccion) {
        try {
            Infraccion registro = get(infraccion.getId());
            if (registro == null) {
                return null;
            } else {
                registro.setDni(infraccion.getDni());
                registro.setFecha(infraccion.getFecha());
                registro.setTipoInfraccion(infraccion.getTipoInfraccion());
                registro.setUbicacion(infraccion.getUbicacion());
                registro.setDescripcion(infraccion.getDescripcion());
                registro.setMontoMulta(infraccion.getMontoMulta());
                registro.setEstado(infraccion.getEstado());
                repository.save(registro);
                return registro;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Infraccion delete(int id) {
        try {
            Infraccion registro = get(id);
            if (registro == null) {
                return null;
            } else {
                repository.delete(registro);
                return registro;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Infraccion anular(int id) {
        try {
            Infraccion registro = get(id);
            if (registro == null) {
                return null;
            } else {
                registro.setEstado("Anulada");
                return repository.save(registro);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
