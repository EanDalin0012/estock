import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import {
  CheckboxSelectionCallbackParams,
  ColDef,
  GridReadyEvent,
  HeaderCheckboxSelectionCallbackParams,
  GridApi
} from 'ag-grid-community';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import { Role } from 'src/app/e-share/data/role';
import { DataService } from 'src/app/e-share/service/data.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {

  disabled = true;

  private gridApi!: GridApi;

  public columnDefs: ColDef[] = [
    {
      headerName: '#',
      field: 'id',
      minWidth: 40,
      checkboxSelection: checkboxSelection,
      headerCheckboxSelection: headerCheckboxSelection,
    },
    {
      headerName: 'Name',
      field: 'name',
      minWidth: 100,
    },
    {
      headerName: 'Description',
      field: 'desc',
      tooltipField: 'desc',
      tooltipComponentParams: { color: '#ececec' },
      minWidth: 300,
    }
  ];
  public autoGroupColumnDef: ColDef = {
    headerName: 'Group',
    minWidth: 170,
    field: 'athlete',
    valueGetter: function (params) {
      if (params.node!.group) {
        return params.node!.key;
      } else {
        return params.data[params.colDef.field!];
      }
    },
    headerCheckboxSelection: true,
    cellRenderer: 'agGroupCellRenderer',
    cellRendererParams: {
      checkbox: true,
    },
  };
  public defaultColDef: ColDef = {
    // editable: true,
    // enableRowGroup: true,
    // enablePivot: true,
    // enableValue: true,
    sortable: true,
    resizable: true,
    filter: true,
    flex: 1,
    minWidth: 100,
  };
  public rowSelection = 'single';
  public rowGroupPanelShow = 'always';
  public pivotPanelShow = 'always';
  public rowData!: any[];
  public tooltipShowDelay = 0;
  public tooltipHideDelay = 2000;

  itemSelectedGride: any;

  constructor(
    private dataService: DataService,
    private titleService: Title,
    private router: Router,
  ) {
    const url = (window.location.href).split('/');
    this.dataService.visitParamRouterChange(url[4]);
    this.titleService.setTitle('Employee Request');
  }
  ngOnInit(): void {
  }

  onGridReady(params: GridReadyEvent) {
    this.gridApi = params.api;
    // this.http
    //   .get<any[]>('https://www.ag-grid.com/example-assets/olympic-winners.json')
    //   .subscribe((data) => (this.rowData = data));
    this.rowData = stockDatas;
  }

  onBtnExport() {
    this.gridApi.exportDataAsCsv();
  }

  onSelectionChanged(event: any) {
    const selectedRows = this.gridApi.getSelectedRows();
    if(selectedRows.length === 0) {
      this.disabled = true;
    } else {
      this.disabled = false;
      this.itemSelectedGride = selectedRows[0];
    }

    // (document.querySelector('#selectedRows') as any).innerHTML =
    //   selectedRows.length === 1 ? selectedRows[0].athlete : '';
  }

  btnNew() {
    this.router.navigate(['/user/new-role']);
  }

  btnEdit() {
    this.router.navigate(['/user/edit-role']);
  }
  btnDelete() {
    if(this.disabled === false) {
      alert(JSON.stringify(this.itemSelectedGride));
    }

  }

}

var checkboxSelection = function (params: CheckboxSelectionCallbackParams) {
  // we put checkbox on the name if we are not doing grouping
  return params.columnApi.getRowGroupColumns().length === 0;
};
var headerCheckboxSelection = function (
  params: HeaderCheckboxSelectionCallbackParams
) {
  // we put checkbox on the name if we are not doing grouping
  return params.columnApi.getRowGroupColumns().length === 0;
};
export interface Data {
  id: number;
  warehouse: string;
  userName: string;
}

export const stockDatas: Role[] = [
  {
    id: 1,
    name: 'Admin',
    desc: 'Manage Page roles and settings,Edit the Page and add apps,Create and delete posts as the Page,Send messages as the Page,Respond to and delete comments and posts to the Page,Remove and ban people from the Page,Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page,Publish and manage jobs,Turn on job features for a post'
  },
  {
    id: 2,
    name: 'Editor',
    desc: 'Edit the Page and add apps,Create and delete posts as the Page,Send messages as the Page,Respond to and delete comments and posts to the Page,Remove and ban people from the Page,Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page,Publish and manage jobs,Turn on job features for a post'
  },
  {
    id: 3,
    name: 'Moderator',
    desc: 'Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page,Publish and manage jobs,Turn on job features for a post'
  },
  {
    id: 4,
    name: 'Advertiser',
    desc: 'Send messages as the Page,Respond to and delete comments and posts to the Page,Remove and ban people from the Page,Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page'
  },
  {
    id: 5,
    name: 'Analyst',
    desc: 'View other insights,View Page Quality tab,See who published as the Page'
  },

];
