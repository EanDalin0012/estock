import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ELayoutComponent } from './e-layout.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { SlidebarComponent } from './slidebar/slidebar.component';
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { EShareModule } from '../e-share/e-share.module';
import { BlanklayoutComponent } from './blanklayout/blanklayout.component';


@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    SlidebarComponent,
  ],
  imports: [
    CommonModule,
    PerfectScrollbarModule,
    EShareModule
  ],
  exports: [
    FooterComponent,
    HeaderComponent,
    SlidebarComponent,
  ]
})
export class ELayoutModule { }
