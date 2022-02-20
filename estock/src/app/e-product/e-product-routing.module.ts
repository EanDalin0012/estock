import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { EProductComponent } from './e-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { ImportDtComponent } from './import-dt/import-dt.component';
import { NewImportComponent } from './new-import/new-import.component';
import { ProductComponent } from './product/product.component';
import { ImportComponent } from './import/import.component';

const routes: Routes = [
  {
    path: '', component: EProductComponent,
    children: [
      {path: '', component: ProductComponent},
      {path: 'add-product', component: AddProductComponent},
      {path: 'edit-product', component: EditProductComponent},
      {path: 'import', component: ImportComponent},
      {path: 'new-import', component: NewImportComponent},
      {path: 'import-dt', component: ImportDtComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EProductRoutingModule { }
