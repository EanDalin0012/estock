import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EEmployeeComponent } from './e-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { FormEmployeeComponent } from './form-employee/form-employee.component';
import { LeaveEmployeeComponent } from './leave-employee/leave-employee.component';
import { OtEmployeeComponent } from './ot-employee/ot-employee.component';

const routes: Routes = [
  {
    path: "",
    component: EEmployeeComponent,
    children: [
      { path: '', component: EmployeeComponent},
      { path: 'add', component: AddEmployeeComponent},
      { path: 'form', component: FormEmployeeComponent},
      { path: 'ot-form', component: OtEmployeeComponent},
      {path: 'leave', component: LeaveEmployeeComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EEmployeeRoutingModule { }
