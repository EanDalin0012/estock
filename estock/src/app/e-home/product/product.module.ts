import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditProductComponent } from './edit-product/edit-product.component';
import { CreateProductComponent } from './create-product/create-product.component';



@NgModule({
  declarations: [
    EditProductComponent,
    CreateProductComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ProductModule { }
