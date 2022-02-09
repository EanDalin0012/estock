import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/e-share/service/data.service';
import { HTTPService } from 'src/app/e-share/service/http.service';
import {AllCommunityModules} from "@ag-grid-community/all-modules";
import {ColDef} from "ag-grid-community";
import { TemplateAPI } from 'src/app/e-share/constants/common.api';
import { UserInfo } from 'src/app/e-share/data/user-inf';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  pagination = true;
  paginationPageSize = 20;
  gridApi:any;
  gridColumnApi :any;
  public modules: any[] = AllCommunityModules;
  frameworkComponents: any;
  defaultColDef: any;
  columnDefs: ColDef[] = [];
  rowData: any;
  rowSelection: any;
  isRowSelectable: any;

  pinnedTopRowData: any;
  pinnedBottomRowData: any;

  constructor(
    private hTTPService: HTTPService,
    private dataService: DataService,
  ) {
    const url = (window.location.href).split('/');
    console.log(url)
    this.dataService.visitParamRouterChange(url[3]);

  }

  ngOnInit(): void {
    this.inquiry();
    this.columnDefs = [
      {
        headerName: 'Request Type',
        field: 'id', minWidth: 50, width: 50
      },
      {
        headerName: 'Requester',
        field: 'firstName'
      },
      {
        headerName: 'Position',
        field: 'lastName',
        cellRenderer: 'status'
      },
      {
        headerName: 'Department',
        field: 'dateBirth'
      },
      {
        headerName: 'Purspose',
        field: 'phone'
      },
      {
        headerName: 'Status',
        field: 'gender'
      }
    ];

    this.defaultColDef = {
      editable: false,
      sortable: true,
      flex: 1,
      minWidth: 50,
      filter: true,
      resizable: true,
    };

    this.rowSelection = 'multiple';
    this.isRowSelectable = function (rowNode: any) {
      return rowNode.data;
    };
  }

  onSelectionChanged(event: any) {
    const selectedRows = this.gridApi.getSelectedRows();
  }


  onCellValueChanged(event:any) {
    console.log('data after changes is: ', event.data);
    const data = event.data as UserInfo;
    console.log(data);
    if(data) {
      this.hTTPService.Post(TemplateAPI.USER_INFO.UPDATE, data).then(response => {
        console.log(response);
        this.inquiry();
      });
    }
  }

  onCellDoubleClicked(event:any) {
    if(event) {
      // const jsonString = JSON.stringify(this.lstUser[event.rowIndex]);
      // const encryptString = EncryptionUtil.encrypt(jsonString.toString()).toString();
      // Utils.setSecureStorage(LOCAL_STORAGE.UserDetail, encryptString);
      // this.router.navigate(['account/user-detail']);
    }
  }

  onGridReady(params:any) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
    // this.inquiry();
  }

  inquiry() {
    const api = '/api/user-info';
    this.hTTPService.Get(TemplateAPI.USER_INFO.URL).then(response =>{
      console.log("response", response)
      this.rowData = response;
    });
  }
}
