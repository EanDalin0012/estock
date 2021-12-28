import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EHomeComponent } from './e-home.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { ProductSaleTypeComponent } from './product-sale-type/product-sale-type.component';
import { MemberComponent } from './member/member.component';

@NgModule({
  declarations: [
    EHomeComponent,
    HomeComponent,
    ProductComponent,
    ProductSaleTypeComponent,
    MemberComponent,
  ],
  imports: [
    CommonModule
  ]
})
export class EHomeModule { }
