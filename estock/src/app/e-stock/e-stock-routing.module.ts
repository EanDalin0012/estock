import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EStockComponent } from './e-stock.component';
import { StockComponent } from './stock/stock.component';

const routes: Routes = [
  {
    path: '', component: EStockComponent,
    children: [
      {path: '', component: StockComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EStockRoutingModule { }
