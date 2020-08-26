package com.project.Contabilidad.controllers;

import com.project.Contabilidad.models.entity.Producto;
import com.project.Contabilidad.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<Map<String, Object>> findAll() {

        Map<String, Object> response = new HashMap<>();

        response.put("productos", productoService.findAll());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        response.put("producto", productoService.findById(id));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/productos")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Producto producto) {


        Map<String, Object> response = new HashMap<>();
        response.put("producto", productoService.save(producto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Producto producto,
                                                      @PathVariable Long id) {

        Producto updateProducto = productoService.findById(id);

        Map<String, Object> response = new HashMap<>();

        if (updateProducto!= null) {

            //updateCartera.setId(cartera.getId());
            updateProducto.setDescripcion(producto.getDescripcion());
            updateProducto.setPrecio(producto.getPrecio());
            updateProducto.setCantidad(producto.getCantidad());

            response.put("producto", productoService.save(updateProducto));

            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        productoService.deleteById(id);

        response.put("message", "La cartera ha sido borrada con éxito");

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
