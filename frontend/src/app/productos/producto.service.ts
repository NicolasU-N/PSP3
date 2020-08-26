import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Producto } from './producto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {



  private urlEndPoint: string = "http://localhost:8081/api/productos";

  private headerToken = new HttpHeaders({ 'Content-Type': 'application/json' });



  constructor(private http: HttpClient) { }


  getProductos(): Observable<any> {

    return this.http.get<any>(this.urlEndPoint, { headers: this.headerToken });

  }

  getProducto(id): Observable<any> {
    return this.http.get<any>(`${this.urlEndPoint}/${id}`, { headers: this.headerToken });
  }

  create(producto: Producto): Observable<any> {
    return this.http.post<any>(this.urlEndPoint, producto, { headers: this.headerToken });
  }

  update(producto: Producto): Observable<any> {
    console.log(producto)
    return this.http.put<any>(`${this.urlEndPoint}/${producto.id}`, producto, { headers: this.headerToken })
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.urlEndPoint}/${id}`, { headers: this.headerToken })
  }

}
