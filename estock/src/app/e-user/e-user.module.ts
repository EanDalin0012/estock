import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { EUserComponent } from './e-user.component';
import {EUserRoutingModule} from "./e-user-routing.module";



@NgModule({
  declarations: [
    UserComponent,
    AddUserComponent,
    EditUserComponent,
    EUserComponent
  ],
  imports: [
    CommonModule,
    EUserRoutingModule
  ]
})
export class EUserModule { }
