import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContenidoPrincipalComponent } from './componentes/contenido-principal/contenido-principal.component';

const routes: Routes = [
  {path: '', component: ContenidoPrincipalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
