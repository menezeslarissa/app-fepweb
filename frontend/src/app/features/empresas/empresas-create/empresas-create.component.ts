import { EmpresasService } from './../../services/empresas.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { MatDialogRef, MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-empresas-create',
  templateUrl: './empresas-create.component.html',
  styleUrls: ['./empresas-create.component.css']
})
export class EmpresasCreateComponent implements OnInit {

  @ViewChild('myForm', { static: false }) public MyForm: NgForm;

  model = {} as any;

  empresa: Empresa;

  constructor(private _snackBar: MatSnackBar, private _empresaService: EmpresasService, public dialogRef: MatDialogRef<EmpresasCreateComponent>) { }

  // form: FormGroup = this.formBuilder.group({
  //   nome: [, { validators: [Validators.required], updateOn: "change" }],
  //   cnpj: [, { validators: [Validators.required], updateOn: "change" }]
  // });

  ngOnInit() {
  }


  public salvar() {
    if (this.MyForm.valid) {
      console.log(this.model);
      this._empresaService.salvar(this.model).subscribe({
        next: data => {
          console.log(data);
          this.empresa = data;
          this.dialogRef.close(this.empresa);
          this._snackBar.open("Empresa salva com sucesso", "", { duration: 1000 });
        },
        error: error => {
            console.error('[ERRO POST EMPRESA]:', error.message);
        }
    })
    } else {
      this._snackBar.open("Preencha todos os campos", "", { duration: 1000 });
    }

  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
