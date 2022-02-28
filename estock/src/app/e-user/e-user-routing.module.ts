import { EditUserComponent } from './edit-user/edit-user.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {EUserComponent} from "./e-user.component";
import { AddUserComponent } from './add-user/add-user.component';
import { RoleComponent } from './role/role.component';
import { NewRoleComponent } from './new-role/new-role.component';
import { EditRoleComponent } from './edit-role/edit-role.component';

const routes: Routes = [
  {
    path: '',
    component: EUserComponent,
    children: [
      { path: '',
        children: [
          {path: '', component: UserComponent},
          {path: 'add-new-user', component: AddUserComponent},
          {path: 'edit-user', component: EditUserComponent}
        ]
      },
      { path: 'add', component: AddUserComponent},
      { path: 'role',
        children: [
          {path: '', component: RoleComponent},
          {path: 'add-new-role', component: NewRoleComponent},
          {path: 'edit-role', component: EditRoleComponent}
        ]
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EUserRoutingModule { }
