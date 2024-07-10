package com.uss.sistema.servicio_producto.service;

import com.uss.sistema.servicio_producto.entity.Infraccion;
import java.util.List;

public interface InfraccionService {

    List<Infraccion> getAll();

    Infraccion get(int id);

    Infraccion create(Infraccion infraccion);

    Infraccion update(Infraccion infraccion);

    Infraccion delete(int id);

    Infraccion anular(int id);
}
