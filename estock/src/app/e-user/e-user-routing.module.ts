import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {EUserComponent} from "./e-user.component";

const routes: Routes = [
  {
    path: "",
    component: EUserComponent,
    children: [
      {
        path: '', component: UserComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EUserRoutingModule { }
