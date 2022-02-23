import { Component, OnInit } from '@angular/core';
import {HTTPService} from "../../e-share/service/http.service";
import {AllCommunityModules} from "@ag-grid-community/all-modules";
import {ColDef} from "ag-grid-community";
import {TemplateAPI} from "../../e-share/constants/common.api";
import {SrcComponent} from "../../e-share/component/src/src.component";
import {DataService} from "../../e-share/service/data.service";
import { UserInfo } from 'src/app/e-share/data/user-inf';
import { WebSocketService } from 'src/app/e-share/service/web-socket.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

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
    // private webSocketService: WebSocketService
  ) {
    const url = (window.location.href).split('/');
    console.log(url)
    this.dataService.visitParamRouterChange(url[3]);

  }

  ngOnInit(): void {
    this.inquiry();
    this.columnDefs = [
      {
        headerName: '#',
        field: 'id', minWidth: 50, width: 50
      },
      {
        headerName:'image',
        field: 'resourceID',
        cellRenderer: 'srcImg',
        cellClass: 'text-center',
        sortable: false,
        filter: false,
      },
      {
        headerName: 'Firs Name',
        field: 'firstName'
      },
      {
        headerName: 'Last Name',
        field: 'lastName',
        cellRenderer: 'status'
      },
      {
        headerName: 'Date Birth',
        field: 'dateBirth'
      },
      {
        headerName: 'Phone',
        field: 'phone'
      },
      {
        headerName: 'Gender',
        field: 'gender'
      },
      {
        headerName: 'Description',
        field: 'desc',
      },
      {
        headerName:'status',
        field: 'status',
        cellEditor: 'agSelectCellEditor',
        cellClass: 'text-center',
        sortable: false,
        filter: false,
        cellEditorParams: {
          values: ['Enable', 'Disable'],
      },
      },
    ];

    this.frameworkComponents = {
      srcImg: SrcComponent
    };
    this.defaultColDef = {
      editable: true,
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

  onBtnExport() {
    this.gridApi.exportDataAsCsv();
  }




}

export interface Data {
  id: number
  status: string;
  userName:  string;
  enabled:  string;
  fullName:  string;
  dateBirth:  string;
  gender:  string;
  phoneNumber:  string;
  remark:  string;

}
