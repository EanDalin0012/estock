import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { EShareModule } from '../e-share/e-share.module';
import { EDashboardComponent } from './e-dashboard/e-dashboard.component';
import { DashboardComponent } from './dashboard.component';



@NgModule({
  declarations: [
    // DashboardComponent
    DashboardComponent,
    EDashboardComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    EShareModule
  ]
})
export class DashboardModule { }
