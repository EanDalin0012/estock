import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StockComponent } from './stock/stock.component';
import { NewStockComponent } from './new-stock/new-stock.component';
import { EStockRoutingModule } from './e-stock-routing.module';
import { EShareModule } from '../e-share/e-share.module';
import {AgGridModule} from "ag-grid-angular";
import { EStockComponent } from './e-stock.component';


@NgModule({
  declarations: [
    StockComponent,
    NewStockComponent,
    EStockComponent
  ],
  imports: [
    CommonModule,
    EStockRoutingModule,
    EShareModule,
    AgGridModule.withComponents([]),
  ]
})
export class EStockModule { }
