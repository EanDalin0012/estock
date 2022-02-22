import { HttpClient } from '@angular/common/http';
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
import { CustomDateFilterComponent } from 'src/app/e-share/component/custom-date-filter/custom-date-filter.component';
import { DataService } from 'src/app/e-share/service/data.service';
@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  public columnDefs: ColDef[] = [
    {
      headerName: 'Date',
      field: 'date',
      filter: 'agDateColumnFilter',
      filterParams: filterParams,
      minWidth: 170,
      checkboxSelection: checkboxSelection,
      headerCheckboxSelection: headerCheckboxSelection,
    },
    {
      headerName: 'Warehouse',
      field: 'warehouse'
    },
    {
      headerName: 'Name',
      field: 'name'
    },
    {
      headerName: 'Unit',
      field: 'unit'
    },
    {
      headerName: 'Opening Stock',
      field: 'openingStock',
      minWidth: 150,
    },
    {
      headerName: 'Received',
      field: 'received',
      minWidth: 130,
     },
    {
      headerName: 'Total',
      field: 'total',
      minWidth: 100,
    },
    {
      headerName: 'Sales',
      field: 'sales',
      minWidth: 100,
    },
    {
      headerName: 'Closing Stock',
      field: 'closingStock',
      minWidth: 140,
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

  public components: {
    [p: string]: any;
  } = {
    agDateInput: CustomDateFilterComponent,
  };

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
    this.components = {
      agDateInput: CustomDateFilterComponent,
    };
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

var filterParams = {
  comparator: function (filterLocalDateAtMidnight: Date, cellValue: string) {
    const dateAsString = cellValue;
    const dateParts = dateAsString.split('/');
    const cellDate = new Date(
      Number(dateParts[2]),
      Number(dateParts[1]) - 1,
      Number(dateParts[0])
    );

    if (filterLocalDateAtMidnight.getTime() === cellDate.getTime()) {
      return 0;
    }

    if (cellDate < filterLocalDateAtMidnight) {
      return -1;
    }

    if (cellDate > filterLocalDateAtMidnight) {
      return 1;
    } else {
      return 0;
    }
  }
};



export interface Data {
  date: string;
  warehouse: string;
  name: string;
  unit: string;
  openingStock: number;
  received: number;
  total: number;
  sales: number;
  closingStock: number;
}

export const stockDatas: Data[] = [
  {
    date: '24/08/2008',
    warehouse: 'Warehouse 1',
    name: 'China Apple',
    unit: 'Kilogram (kg)',
    openingStock: 364,
    received: 450,
    total: 658,
    sales: 60,
    closingStock: 80,
  },
  {
    date: '24/08/2008',
    warehouse: 'Warehouse 2',
    name: 'Orange',
    unit: 'Kilogram (kg)',
    openingStock: 364,
    received: 450,
    total: 658,
    sales: 60,
    closingStock: 80,
  }
];

