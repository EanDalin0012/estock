import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ESaleComponent } from './e-sale.component';
import { SaleComponent } from './sale/sale.component';
import { SaleInvoiceComponent } from './sale-invoice/sale-invoice.component';
import { ESaleRoutingModule } from './e-sale-routing.module';
import { EShareModule } from '../e-share/e-share.module';
import {AgGridModule} from "ag-grid-angular";

@NgModule({
  declarations: [
    ESaleComponent,
    SaleComponent,
    SaleInvoiceComponent
  ],
  imports: [
    CommonModule,
    ESaleRoutingModule,
    EShareModule,
    AgGridModule.withComponents([]),
  ]
})
export class ESaleModule { }
