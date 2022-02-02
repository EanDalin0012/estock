import { EProductRoutingModule } from './e-product-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditProductComponent } from './edit-product/edit-product.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { EShareModule } from 'src/app/e-share/e-share.module';



@NgModule({
  declarations: [
    EditProductComponent,
    CreateProductComponent
  ],
  imports: [
    CommonModule,
    EProductRoutingModule,
    EShareModule
  ]
})
export class ProductModule {
  constructor() {
    console.log('ProductModule');
  }
}
