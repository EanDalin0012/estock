import { EShareModule } from './../e-share/e-share.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EHomeComponent } from './e-home.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { ProductSaleTypeComponent } from './product-sale-type/product-sale-type.component';
import { MemberComponent } from './member/member.component';
import { EHomeRoutingModule } from './e-home-routing.module';
import { AgGridModule } from 'ag-grid-angular';
import { ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CkeditorComponent } from './ckeditor/ckeditor.component';
import { WebsocketComponent } from './websocket/websocket.component';
@NgModule({
  declarations: [
    EHomeComponent,
    HomeComponent,
    ProductComponent,
    ProductSaleTypeComponent,
    MemberComponent,
    DashboardComponent,
    CkeditorComponent,
    WebsocketComponent,
  ],
  imports: [
    CommonModule,
    EHomeRoutingModule,
    EShareModule,
    ReactiveFormsModule,
    AgGridModule.withComponents([]),
  ]
})
export class EHomeModule {
  constructor() {
    console.log('EHomeModule');
  }
}
