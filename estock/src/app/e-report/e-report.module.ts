import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllSaleInvoiceComponent } from './all-sale-invoice/all-sale-invoice.component';
import { EReportComponent } from './e-report.component';
import { EReportRoutingModule } from './e-report-routing.module';
import { EShareModule } from '../e-share/e-share.module';
import {AgGridModule} from "ag-grid-angular";


@NgModule({
  declarations: [
    AllSaleInvoiceComponent,
    EReportComponent
  ],
  imports: [
    CommonModule,
    EReportRoutingModule,
    EShareModule,
    AgGridModule.withComponents([]),
  ]
})
export class EReportModule { }
