import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContenidoPrincipalComponent } from './componentes/contenido-principal/contenido-principal.component';
import { SignupComponent } from './paginas/signup/signup.component';
import { LoginComponent } from './paginas/login/login.component';

const routes: Routes = [
  { path: '', component: ContenidoPrincipalComponent},
  { path: 'ingreso', component: LoginComponent },
  { path: 'registro', component: SignupComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
