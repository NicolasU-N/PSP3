package com.project.Contabilidad.models.dao;

import com.project.Contabilidad.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto, Long> {

}
