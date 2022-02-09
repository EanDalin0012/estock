import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlanklayoutComponent } from './e-layout/blanklayout/blanklayout.component';
import { ELayoutComponent } from './e-layout/e-layout.component';

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
    path: '', component: ELayoutComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('./e-home/e-home.module').then(m => m.EHomeModule)
      }
    ]
  },

  {
    path: '', component: ELayoutComponent,
    children: [
      {
        path: 'user',
        loadChildren: () => import('./e-user/e-user.module').then(m => m.EUserModule)
      }
    ]
  },

  {
    path: '', component: ELayoutComponent,
    children: [
      {
        path: 'employee-request',
        loadChildren: () => import('./e-employee/e-employee.module').then(m => m.EEmployeeModule)
      }
    ]
  },

  // { path: 'announce/4error', component: Error4Component },
  // { path: 'error500', component: Error500Component },
  // { path: 'error403', component: Error403Component },
  // { path: '**', component: Error404Component },
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
