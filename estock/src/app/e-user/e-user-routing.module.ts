import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {EUserComponent} from "./e-user.component";
import { AddUserComponent } from './add-user/add-user.component';
import { RoleComponent } from './role/role.component';

const routes: Routes = [
  {
    path: "",
    component: EUserComponent,
    children: [
      { path: '', component: UserComponent},
      { path: 'add', component: AddUserComponent},
      { path: 'role', component: RoleComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EUserRoutingModule { }
