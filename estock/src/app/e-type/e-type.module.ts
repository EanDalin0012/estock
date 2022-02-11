import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ETypeComponent } from './e-type.component';
import { SaleTypeComponent } from './sale-type/sale-type.component';
import { SaleProductTypeComponent } from './sale-product-type/sale-product-type.component';
import { ETypeRoutingModule } from './e-type-routing.module';
import { EShareModule } from '../e-share/e-share.module';
import {AgGridModule} from "ag-grid-angular";
import { AddSaleProductTypeComponent } from './add-sale-product-type/add-sale-product-type.component';
import { EditSaleProductTypeComponent } from './edit-sale-product-type/edit-sale-product-type.component';


@NgModule({
  declarations: [
    ETypeComponent,
    SaleTypeComponent,
    SaleProductTypeComponent,
    AddSaleProductTypeComponent,
    EditSaleProductTypeComponent
  ],
  imports: [
    CommonModule,
    ETypeRoutingModule,
    EShareModule,
    AgGridModule.withComponents([]),
  ]
})
export class ETypeModule { }
