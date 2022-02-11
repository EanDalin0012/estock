import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ESaleComponent } from './e-sale.component';
import { SaleInvoiceComponent } from './sale-invoice/sale-invoice.component';
import { SaleComponent } from './sale/sale.component';

const routes: Routes = [
  {
    path: '', component: ESaleComponent,
    children: [
      {path: '', component: SaleComponent},
      {path: 'sale-invoice', component: SaleInvoiceComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ESaleRoutingModule { }
