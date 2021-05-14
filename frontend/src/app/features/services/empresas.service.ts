import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  apiUrl = environment.apiUrl + "empresas";

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  salvar(empresa): Observable<Empresa> {
    return this.http.post<Empresa>(this.apiUrl, JSON.stringify(empresa), this.httpOptions);
  }

  getAll(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(this.apiUrl);
  }

  atualizar(empresa, id): Observable<Empresa> {
    return this.http.put<Empresa>(this.apiUrl + '/' + id, JSON.stringify(empresa), this.httpOptions);
  }

}
