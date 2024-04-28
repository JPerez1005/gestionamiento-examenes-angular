import { Component, OnInit } from '@angular/core';
import { UserService } from '../../servicios/user.service';
import { FormControl, Validators } from '@angular/forms';
import { merge } from 'rxjs';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {
  email = new FormControl('', [Validators.required, Validators.email]);
  errorMessage = '';

  public usuario = {
    username: '',
    password: '',
    nombre: '',
    apellido: '',
    email: '',
    telefono: '',
  };
  

  constructor(
    private userService: UserService
  ) {
    merge(this.email.statusChanges, this.email.valueChanges)
      .pipe(takeUntilDestroyed())
      .subscribe(() => this.updateErrorMessage());
  }

  updateErrorMessage() {
    if (this.email.hasError('required')) {
      this.errorMessage = 'You must enter a value';
    } else if (this.email.hasError('email')) {
      this.errorMessage = 'Not a valid email';
    } else {
      this.errorMessage = '';
    }
  }

  formSubmit() {
    console.log(this.usuario);
    if (this.usuario.username === '' || this.usuario.username === null) {
      alert('El nombre de usuario es requerido');
      return;
    }

    this.userService.registrarUsuario(this.usuario).subscribe(
      (data) => {
        console.log(data);
        alert('Usuario registrado con éxito!');
      },
      (error) => {
        console.log(error);
        alert('Ha ocurrido un error en el sistema');
      }
    );
  }
}
