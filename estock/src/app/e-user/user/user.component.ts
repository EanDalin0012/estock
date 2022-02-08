import { Component, OnInit } from '@angular/core';
import {HTTPService} from "../../e-share/service/http.service";
import {AllCommunityModules} from "@ag-grid-community/all-modules";
import {ColDef} from "ag-grid-community";
import {TemplateAPI} from "../../e-share/constants/common.api";
import {SrcComponent} from "../../e-share/component/src/src.component";
import {DataService} from "../../e-share/service/data.service";
import { MenuActionComponent } from 'src/app/e-share/component/menu-action/menu-action.component';

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
        field: 'firstName',
        cellRenderer: 'srcImg',
        cellClass: 'text-center',
        sortable: false,
        filter: false,
      },
      {
        headerName: 'userName',
        field: 'firstName'
      },
      {
        headerName: 'enable',
        field: 'lastName',
        cellRenderer: 'status'
      },
      {
        headerName: 'fullName',
        field: 'dateBirth'
      },
      {
        headerName: 'dateBirth',
        field: 'phone'
      },
      {
        headerName: 'gender',
        field: 'gender'
      },
      {
        headerName: 'remark',
        field: 'desc',
      },
      {
        headerName:'Action',
        field: 'desc',
        cellEditor: 'agSelectCellEditor',
        cellClass: 'text-center',
        sortable: false,
        filter: false,
        cellEditorParams: {
          values: ['English', 'Spanish', 'French', 'Portuguese', '(other)'],
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
      minWidth: 100,
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
    // this.selectedJson = selectedRows[0];
    // console.log(this.selectedJson);
    // if(this.selectedJson.enabled === false) {
    //   this.btnEnableTxt = this.translate.instant('users.label.enableUser');
    //   this.enable = true;
    // } else {
    //   this.btnEnableTxt = this.translate.instant('users.label.disableUser');
    //   this.enable = false;
    // }
    // if(selectedRows) {
    //   this.disabled = false;
    // }
  }


  onCellValueChanged(event:any) {
    console.log('data after changes is: ', event.data);
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
