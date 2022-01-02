import { EShareModule } from './../../e-share/e-share.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateProductSaleTypeComponent } from './create-product-sale-type/create-product-sale-type.component';
import { EditProductSaleTypeComponent } from './edit-product-sale-type/edit-product-sale-type.component';
import { AgGridModule } from 'ag-grid-angular';
import { ProductSaleTypeRoutingModule } from './e-product-sale-type-routing.module';


@NgModule({
  declarations: [
    CreateProductSaleTypeComponent,
    EditProductSaleTypeComponent
  ],
  imports: [
    CommonModule,
    EShareModule,
    ProductSaleTypeRoutingModule,
    AgGridModule.withComponents([]),
  ]
})
export class ProductSaleTypeModule { }
