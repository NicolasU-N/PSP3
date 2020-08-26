import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductosComponent } from './productos/productos.component';
import { FormComponent } from './productos/form/form.component';


const routes: Routes = [
  { path: '', component: ProductosComponent },
  { path: 'formProducto', component: FormComponent },
  { path: 'productoComponent/formProducto/:id', component: FormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
