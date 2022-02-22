import { NgModule,ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { AvatarModule } from 'ngx-avatar';
import { AgGridModule } from 'ag-grid-angular';
import { SrcComponent } from './component/src/src.component';
import { AmountPipe } from './pipe/amount.pipe';
import { CustomDateFilterComponent } from './component/custom-date-filter/custom-date-filter.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    SrcComponent,
    AmountPipe,
    CustomDateFilterComponent
  ],
  imports: [
    CommonModule,
    AgGridModule.withComponents([CustomDateFilterComponent]),
    CKEditorModule,
    RouterModule
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    TranslateModule,
    AvatarModule,
    AmountPipe,
    AgGridModule,
    CKEditorModule
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
