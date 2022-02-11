import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { EProductComponent } from './e-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  {
    path: '', component: EProductComponent,
    children: [
      {path: '', component: ProductComponent},
      {path: 'add-product', component: AddProductComponent},
      {path: 'edit-product', component: EditProductComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EProductRoutingModule { }
