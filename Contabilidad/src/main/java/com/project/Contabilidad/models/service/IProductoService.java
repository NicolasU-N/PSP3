package com.project.Contabilidad.models.service;

import com.project.Contabilidad.models.entity.Producto;
import java.util.List;

public interface IProductoService {

    List<Producto> findAll();

    Producto findById(Long id);

    Producto save(Producto authority);

    void deleteById(Long id);
}
