import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateMemberComponent } from './create-member/create-member.component';
import { EditMemberComponent } from './edit-member/edit-member.component';



@NgModule({
  declarations: [
    CreateMemberComponent,
    EditMemberComponent
  ],
  imports: [
    CommonModule
  ]
})
export class MemberModule { }
