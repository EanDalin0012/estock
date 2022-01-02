import { EHomeComponent } from './e-home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home', component: EHomeComponent,
    children: [
      {
        path: 'product',
        loadChildren: () => import('../e-home/product/product.module').then(m => m.ProductModule)
      },
      {
        path: 'product-sale-type',
        loadChildren: () => import('../e-home/product-sale-type/product-sale-type.module').then(m => m.ProductSaleTypeModule)
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EHomeRoutingModule { }
