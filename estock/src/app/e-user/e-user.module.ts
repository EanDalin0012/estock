import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { EUserComponent } from './e-user.component';
import {EUserRoutingModule} from "./e-user-routing.module";
import {EShareModule} from "../e-share/e-share.module";
import {AgGridModule} from "ag-grid-angular";
import { RoleComponent } from './role/role.component';
import { NewRoleComponent } from './new-role/new-role.component';
import { EditRoleComponent } from './edit-role/edit-role.component';



@NgModule({
  declarations: [
    UserComponent,
    AddUserComponent,
    EditUserComponent,
    EUserComponent,
    RoleComponent,
    NewRoleComponent,
    EditRoleComponent
  ],
  imports: [
    CommonModule,
    AgGridModule.withComponents([]),
    EUserRoutingModule,
    EShareModule
  ]
})
export class EUserModule { }
