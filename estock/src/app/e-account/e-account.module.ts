import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EAccountComponent } from './e-account.component';
import { AccountComponent } from './account/account.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { EditAccountComponent } from './edit-account/edit-account.component';



@NgModule({
  declarations: [
    EAccountComponent,
    AccountComponent,
    CreateAccountComponent,
    EditAccountComponent
  ],
  imports: [
    CommonModule
  ]
})
export class EAccountModule { }
