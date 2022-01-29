import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EAuthComponent } from './e-auth.component';
import { LoginComponent } from './login/login.component';
import { EAuthRoutingModule } from './e-auth-routing.module';
import { EShareModule } from '../e-share/e-share.module';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    EAuthComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    EAuthRoutingModule,
    EShareModule,
    ReactiveFormsModule
  ]
})
export class EAuthModule { }
