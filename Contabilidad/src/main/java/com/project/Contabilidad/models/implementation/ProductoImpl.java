package com.project.Contabilidad.models.implementation;

import com.project.Contabilidad.models.dao.IProductoDao;
import com.project.Contabilidad.models.entity.Producto;
import com.project.Contabilidad.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImpl implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto authority) {
        return productoDao.save(authority);
    }

    @Override
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }
}
