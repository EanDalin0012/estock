import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateProductSaleTypeComponent } from './create-product-sale-type/create-product-sale-type.component';
import { EditProductSaleTypeComponent } from './edit-product-sale-type/edit-product-sale-type.component';



@NgModule({
  declarations: [
    CreateProductSaleTypeComponent,
    EditProductSaleTypeComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ProductSaleTypeModule { }
