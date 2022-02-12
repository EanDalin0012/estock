import { NgModule,ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { AvatarModule } from 'ngx-avatar';
import { AgGridModule } from 'ag-grid-angular';
import { SrcComponent } from './component/src/src.component';
import { AmountPipe } from './pipe/amount.pipe';


@NgModule({
  declarations: [
    SrcComponent,
    AmountPipe,
  ],
  imports: [
    CommonModule,
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    TranslateModule,
    AvatarModule,
    AmountPipe
  ]
})
export class EShareModule {
  static forRoot(): ModuleWithProviders<EShareModule> {
    return {
      ngModule: EShareModule,
      providers: []
    };
  }
 }
