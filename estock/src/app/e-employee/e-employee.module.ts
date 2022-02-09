import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EEmployeeComponent } from './e-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EditEmployeeComponent } from './edit-employee/edit-employee.component';
import { LeaveEmployeeComponent } from './leave-employee/leave-employee.component';
import { EEmployeeRoutingModule } from './e-employee-routing.module';
import { EShareModule } from '../e-share/e-share.module';



@NgModule({
  declarations: [
    EEmployeeComponent,
    EmployeeComponent,
    AddEmployeeComponent,
    EditEmployeeComponent,
    LeaveEmployeeComponent
  ],
  imports: [
    CommonModule,
    EEmployeeRoutingModule,
    EShareModule
  ]
})
export class EEmployeeModule { }
