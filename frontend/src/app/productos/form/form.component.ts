import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  producto: Producto = new Producto();

  constructor(private activatedRouted: ActivatedRoute, private productoService: ProductoService, private router: Router) { }

  ngOnInit(): void {


    this.activatedRouted.params.subscribe(
      parametro => {
        let id = parametro['id'];
        if (id != null) {
          this.productoService.getProducto(id).subscribe(
            (json: any) => this.producto = json.producto
          )
        }

      }
    )

  }

  public create(): void {
    this.productoService.create(this.producto).subscribe(
      () => this.router.navigate(["/"])
    )
  }

  update(): void {
    this.productoService.update(this.producto).subscribe(
      (json: any) => {
        this.router.navigate(["/"])
        Swal.fire({
          title: 'Producto Actualizado',
          text: `Producto ${json.producto.id} actualizado con éxito!`,
          icon: 'success',
          confirmButtonText: 'Cool'
        })
      }
    )
  }

}
