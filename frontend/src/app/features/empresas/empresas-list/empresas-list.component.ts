import { EmpresasService } from './../../services/empresas.service';
import { EmpresasCreateComponent } from './../empresas-create/empresas-create.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { EmpresasEditComponent } from '../empresas-edit/empresas-edit.component';

@Component({
  selector: 'app-empresas-list',
  templateUrl: './empresas-list.component.html',
  styleUrls: ['./empresas-list.component.css']
})
export class EmpresasListComponent implements OnInit {

  empresas: Empresa[];

  displayedColumns: string[] = ['nome', 'cnpj', 'createdAt', 'actions'];


  typesOfShoes: string[] = ['Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];

  constructor(public dialog: MatDialog, private _empresaService: EmpresasService) { }

  ngOnInit() {
    this.listarEmpresas();
  }

  adicionarEmpresa() {
    let dialogRef = this.dialog.open(EmpresasCreateComponent, {

      height: '400px',
      width: '400px',

    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.empresas = [];
        this.listarEmpresas();
        console.log('[EMPRESA SALVA]');
      }
    });
  }

  atualizarEmpresa(empresa) {
    let dialogRef = this.dialog.open(EmpresasEditComponent, {
      data: empresa,
      height: '400px',
      width: '400px',

    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.empresas = [];
        this.listarEmpresas();
        console.log('[EMPRESA ATUALIZADA]');
      }
    });
  }

  listarEmpresas() {
    this._empresaService.getAll().subscribe({
      next: data => {
        this.empresas = data;
      },
      error: error => {
        console.error('[ERRO GET EMPRESAS]:', error.message);
      }
    })
  }

}
