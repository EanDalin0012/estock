import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EEmployeeComponent } from './e-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { FormEmployeeComponent } from './form-employee/form-employee.component';

const routes: Routes = [
  {
    path: "",
    component: EEmployeeComponent,
    children: [
      { path: '', component: EmployeeComponent},
      { path: 'add', component: AddEmployeeComponent},
      { path: 'form', component: FormEmployeeComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EEmployeeRoutingModule { }
