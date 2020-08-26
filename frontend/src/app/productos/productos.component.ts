import { Component, OnInit } from '@angular/core';
import { Producto } from './producto';
import { ProductoService } from './producto.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  productos: Producto[];

  flag: boolean = false;

  constructor(private productoService: ProductoService, private router: Router) { }

  ngOnInit(): void {
    this.productoService.getProductos().subscribe(
      (json: any) => this.productos = json.productos
    );
  }

  delete(producto: Producto): void {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: '¿Está seguro?',
      text: `¿Seguro que desea eliminar el producto ${producto.id}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        this.productoService.delete(producto.id).subscribe(
          () => {
            this.productos = this.productos.filter(pro => pro !== producto)
            Swal.fire({
              title: 'Producto Eliminado',
              text: `Producto ${producto.id} eliminado con éxito!`,
              icon: 'success',
              confirmButtonText: 'Cool'
            })
          }
        )
        swalWithBootstrapButtons.fire(
          'Eliminadio!',
          'Your file has been deleted.',
          'success'
        )
      }
    });
  }

}
