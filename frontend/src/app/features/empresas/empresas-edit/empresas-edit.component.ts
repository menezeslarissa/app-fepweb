import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { EmpresasService } from '../../services/empresas.service';
import { EmpresasCreateComponent } from '../empresas-create/empresas-create.component';

@Component({
  selector: 'app-empresas-edit',
  templateUrl: './empresas-edit.component.html',
  styleUrls: ['./empresas-edit.component.css']
})
export class EmpresasEditComponent implements OnInit {
  @ViewChild('myForm', { static: false }) public MyForm: NgForm;

  model = {} as any;

  empresa: Empresa;

  constructor(private _snackBar: MatSnackBar, private _empresaService: EmpresasService, public dialogRef: MatDialogRef<EmpresasEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.empresa = this.data;
    this.model.nome = this.data.nome;
  }

  atualizarNome() {
    this.empresa.nome = this.model.nome;
    if (this.MyForm.valid) {
      // console.log(this.empresa);
      this._empresaService.atualizar(this.empresa, this.empresa.id).subscribe({
        next: data => {
          // console.log(data);
          this.empresa = data;
          this.dialogRef.close(this.empresa);
          this._snackBar.open("Empresa atualizada com sucesso", "", { duration: 1000 });
        },
        error: error => {
            console.error('[ERRO PUT EMPRESA]:', error.message);
        }
    })
    } else {
      this._snackBar.open("Preencha todos os campos", "", { duration: 1000 });
    }
  }

}
