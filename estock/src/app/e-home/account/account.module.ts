import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountComponent } from './account.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { EditAccountComponent } from './edit-account/edit-account.component';



@NgModule({
  declarations: [
    AccountComponent,
    CreateAccountComponent,
    EditAccountComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AccountModule { }
