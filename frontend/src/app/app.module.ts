import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductosComponent } from './productos/productos.component';
import { FormComponent } from './productos/form/form.component';
import { ProductoService } from './productos/producto.service';

@NgModule({
  declarations: [
    AppComponent,
    ProductosComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,


  ],
  providers: [ProductoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
