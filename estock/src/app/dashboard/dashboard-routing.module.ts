import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { EDashboardComponent } from './e-dashboard/e-dashboard.component';

const routes: Routes = [
  {
    path: '', component: DashboardComponent,
    children: [
      {path: '', component: EDashboardComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
