import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EProductComponent } from './e-product.component';
import { ProductComponent } from './product/product.component';
import { AddProductComponent } from './add-product/add-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { EShareModule } from '../e-share/e-share.module';
import { EProductRoutingModule } from './e-product-routing.module';
import {AgGridModule} from "ag-grid-angular";
import { ImportComponent } from './import/import.component';
import { NewImportComponent } from './new-import/new-import.component';
import { ImportDtComponent } from './import-dt/import-dt.component';

@NgModule({
  declarations: [
    EProductComponent,
    ProductComponent,
    AddProductComponent,
    EditProductComponent,
    ImportComponent,
    NewImportComponent,
    ImportDtComponent
  ],
  imports: [
    CommonModule,
    EProductRoutingModule,
    EShareModule,
    AgGridModule.withComponents([]),
  ]
})
export class EProductModule { }
