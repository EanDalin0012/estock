import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import {
  CheckboxSelectionCallbackParams,
  ColDef,
  GridReadyEvent,
  HeaderCheckboxSelectionCallbackParams,
} from 'ag-grid-community';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import { DataService } from 'src/app/e-share/service/data.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  public columnDefs: ColDef[] = [
    {
      headerName: '#',
      field: 'id',
      minWidth: 10,
    },
    {
      headerName: 'Name',
      field: 'name',
      minWidth: 200,
    },
    {
      headerName: 'Description',
      field: 'desc',
      minWidth: 200,
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
    minWidth: 200,
  };
  public rowSelection = 'multiple';
  public rowGroupPanelShow = 'always';
  public pivotPanelShow = 'always';
  public rowData!: any[];

  constructor(
    private dataService: DataService,
    private titleService: Title,
  ) {
    const url = (window.location.href).split('/');
    console.log(url)
    this.dataService.visitParamRouterChange(url[3]);
    this.titleService.setTitle('Employee Request');
  }
  ngOnInit(): void {
  }

  onGridReady(params: GridReadyEvent) {
    // this.http
    //   .get<any[]>('https://www.ag-grid.com/example-assets/olympic-winners.json')
    //   .subscribe((data) => (this.rowData = data));
    this.rowData = stockDatas;
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
  name: string;
  desc: string;
}

export const stockDatas: Data[] = [
  {
    id: 1,
    name: 'Warehouse 1',
    desc: 'China Apple'
  },
  {
    id: 2,
    name: 'Warehouse 2',
    desc: 'Orange',
  }
];
