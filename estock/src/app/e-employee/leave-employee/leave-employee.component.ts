import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/e-share/service/data.service';
import { HTTPService } from 'src/app/e-share/service/http.service';
import {AllCommunityModules} from "@ag-grid-community/all-modules";
import {ColDef} from "ag-grid-community";
import { TemplateAPI } from 'src/app/e-share/constants/common.api';
import { UserInfo } from 'src/app/e-share/data/user-inf';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { EmployeeOT } from 'src/app/e-share/data/employee-OT';
import { FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-leave-employee',
  templateUrl: './leave-employee.component.html',
  styleUrls: ['./leave-employee.component.css']
})
export class LeaveEmployeeComponent implements OnInit {
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
  employeeOTs: EmployeeOT[] = [];

  constructor(
    private hTTPService: HTTPService,
    private dataService: DataService,
    private titleService: Title,
    private router: Router,
  ) {
    const url = (window.location.href).split('/');
    console.log(url)
    this.dataService.visitParamRouterChange(url[3]);
    this.titleService.setTitle('Employee Request');
  }

  ngOnInit(): void {
    this.inquiry();
    this.columnDefs = [
      {
        headerName: 'Request ID',
        field: 'date', minWidth: 50, width: 50,
      },
      {
        headerName: 'Request Type',
        field: 'startTime'
      },
      {
        headerName: 'From Date',
        field: 'endTime',
      },
      {
        headerName: 'To Date',
        field: 'totalOT'
      },
      {
        headerName: 'Leave Taken',
        field: 'OTtype'
      },
      {
        headerName: 'Request Date',
        field: 'purspuse'
      },
      {
        headerName: 'Status',
        field: 'purspuse'
      },
      {
        headerName: 'Reason',
        field: 'purspuse'
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
  }

  inquiry() {
    this.employeeOTs = [
      {
        date: '',
        startTime: '',
        endTime: '',
        totalOT: '',
        OTtype: '',
        purspuse: '',
      }
    ];
    this.rowData = this.employeeOTs ;
    }
    // this.rowData = this.employeeRequests;

    // const api = '/api/user-info';
    // this.hTTPService.Get(TemplateAPI.USER_INFO.URL).then(response =>{
    //   console.log("response", response)
    //   this.rowData = response;
    // });
  // }

  onNewRequest() {
    this.router.navigate(['/employee-request/form']);
  }

}
