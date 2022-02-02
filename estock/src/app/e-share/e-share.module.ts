import { NgModule,ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { AvatarModule } from 'ngx-avatar';
import { AgGridModule } from 'ag-grid-angular';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AgGridModule.withComponents([]),
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    TranslateModule,
    AvatarModule,
    
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
