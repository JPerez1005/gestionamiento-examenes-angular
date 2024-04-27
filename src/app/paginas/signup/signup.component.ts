import { Component } from '@angular/core';
import { UserService } from '../../servicios/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  public usuario={
    username:'',
    password:'',
    nombre:'',
    apellido:'',
    email:'',
    telefono:''
  }

  constructor(private userService: UserService){}

  ngOnInit():void{

  }

  formSubmit(){
    console.log(this.usuario);
    if (this.usuario.username=='' || this.usuario.username==null) {
      alert('el nombre de usuario es requerido');
      return;
    }

    this.userService.registrarUsuario(this.usuario).subscribe(
      (data)=>{
        console.log(data);
        alert('Usuario registrado con exito!');
      },(error)=>{
        console.log(error);
        alert('ha ocurrido un error en el sistema');
      }
    )
    
  }
}
