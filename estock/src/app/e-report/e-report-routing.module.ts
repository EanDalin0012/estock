import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllSaleInvoiceComponent } from './all-sale-invoice/all-sale-invoice.component';
import { EReportComponent } from './e-report.component';

const routes: Routes = [
  {
    path: '', component: EReportComponent,
    children: [
      {path: '', component: AllSaleInvoiceComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EReportRoutingModule { }
