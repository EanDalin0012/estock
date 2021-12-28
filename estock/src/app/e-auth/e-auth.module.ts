import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EAuthComponent } from './e-auth.component';
import { LoginComponent } from './login/login.component';



@NgModule({
  declarations: [
    EAuthComponent,
    LoginComponent
  ],
  imports: [
    CommonModule
  ]
})
export class EAuthModule { }
