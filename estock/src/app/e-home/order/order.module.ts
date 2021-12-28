import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateOrderComponent } from './create-order/create-order.component';
import { ConfirmOrderComponent } from './confirm-order/confirm-order.component';
import { SuccessOrderComponent } from './success-order/success-order.component';



@NgModule({
  declarations: [
    CreateOrderComponent,
    ConfirmOrderComponent,
    SuccessOrderComponent
  ],
  imports: [
    CommonModule
  ]
})
export class OrderModule { }
