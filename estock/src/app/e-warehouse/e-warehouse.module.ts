import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EWarehouseComponent } from './e-warehouse.component';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { NewWarehouseComponent } from './new-warehouse/new-warehouse.component';
import { EWarehouseRoutingModule } from './e-warehouse-routing.module';
import { EShareModule } from '../e-share/e-share.module';
import {AgGridModule} from "ag-grid-angular";


@NgModule({
  declarations: [
    EWarehouseComponent,
    WarehouseComponent,
    NewWarehouseComponent
  ],
  imports: [
    CommonModule,
    EWarehouseRoutingModule,
    EShareModule,
    AgGridModule.withComponents([]),
  ]
})
export class EWarehouseModule { }
