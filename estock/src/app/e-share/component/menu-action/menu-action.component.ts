import { Component, OnInit } from '@angular/core';
import { AgRendererComponent } from 'ag-grid-angular';
import { ICellRendererParams } from 'ag-grid-community';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-menu-action',
  templateUrl: './menu-action.component.html',
  styleUrls: ['./menu-action.component.css']
})
export class MenuActionComponent implements OnInit, AgRendererComponent {

  baseUrl: string = '';
  params: any;
  constructor() {
    this.baseUrl = environment.bizServer.server;
  }

  ngOnInit(): void {
  }

  refresh(params: ICellRendererParams): boolean {
    return false;
  }
  agInit(params: ICellRendererParams): void {
    this.params = params;
    // console.log('this.params', this.params)
  }
}
