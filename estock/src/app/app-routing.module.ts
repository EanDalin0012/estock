import { AuthGuard } from './e-share/service/auth.guard';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlanklayoutComponent } from './e-layout/blanklayout/blanklayout.component';
import { ELayoutComponent } from './e-layout/e-layout.component';
import { Error404Component } from './error/error404/error404.component';

const routes: Routes = [
  {
    path: '', component: BlanklayoutComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('./e-auth/e-auth.module').then(m => m.EAuthModule)
      }
    ]
  },
  {
    path: 'home', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./e-home/e-home.module').then(m => m.EHomeModule)
  },
  {
    path: 'user', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./e-user/e-user.module').then(m => m.EUserModule)
  },{
    path: 'employee-request', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./e-employee/e-employee.module').then(m => m.EEmployeeModule)
  },{
    path: 'product', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./e-product/e-product.module').then(m => m.EProductModule)
  },
  {
    path: 'type', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./e-type/e-type.module').then(m => m.ETypeModule)
  },
  {
    path: 'sale', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./e-sale/e-sale.module').then(m => m.ESaleModule)
  },
  {
    path: 'report', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./e-report/e-report.module').then(m => m.EReportModule)
  },
  {
    path: 'dashboard', canActivate: [ AuthGuard ], component: ELayoutComponent,
    loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule)
  },
  {
    path: 'warehouse', canActivate: [ AuthGuard ],component: ELayoutComponent,
    loadChildren: () => import('./e-warehouse/e-warehouse.module').then(m => m.EWarehouseModule)
  },
  {
    path: 'stock', canActivate: [ AuthGuard ],component: ELayoutComponent,
    loadChildren: () => import('./e-stock/e-stock.module').then(m => m.EStockModule)
  },
  // { path: 'announce/4error', component: Error4Component }, ETypeModule
  // { path: 'error500', component: Error500Component },
  // { path: 'error403', component: Error403Component },
  { path: '**', component: Error404Component },
  {
    path: '',
    redirectTo: '/home/product',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
