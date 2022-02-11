import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddSaleProductTypeComponent } from './add-sale-product-type/add-sale-product-type.component';
import { ETypeComponent } from './e-type.component';
import { EditSaleProductTypeComponent } from './edit-sale-product-type/edit-sale-product-type.component';
import { SaleProductTypeComponent } from './sale-product-type/sale-product-type.component';
import { SaleTypeComponent } from './sale-type/sale-type.component';

const routes: Routes = [
  {
    path: '', component: ETypeComponent,
    children: [
      {path: 'sale-type', component: SaleTypeComponent},
      {path: 'sale-product-type', component: SaleProductTypeComponent},
      {path: 'sale-product-type', component: SaleProductTypeComponent},
      {path: 'add-sale-product-type', component: AddSaleProductTypeComponent},
      {path: 'edit-sale-product-type', component: EditSaleProductTypeComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ETypeRoutingModule { }
