import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EWarehouseComponent } from './e-warehouse.component';
import { WarehouseComponent } from './warehouse/warehouse.component';

const routes: Routes = [
  {
    path: '', component: EWarehouseComponent,
    children: [
      {path: '', component: WarehouseComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EWarehouseRoutingModule { }
