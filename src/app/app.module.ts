import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './paginas/signup/signup.component';
import { LoginComponent } from './paginas/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from "./componentes/navbar/navbar.component";
import { SidebarLeftComponent } from "./componentes/sidebar-left/sidebar-left.component";
import { FooterComponent } from "./componentes/footer/footer.component";
import { SidebarRightComponent } from "./componentes/sidebar-right/sidebar-right.component";

@NgModule({
    declarations: [
        AppComponent,
        SignupComponent,
        LoginComponent
    ],
    providers: [
        provideClientHydration()
    ],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        NavbarComponent,
        SidebarLeftComponent,
        FooterComponent,
        SidebarRightComponent
    ]
})
export class AppModule { }
