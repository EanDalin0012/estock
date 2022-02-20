import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AllCommunityModules } from '@ag-grid-community/all-modules';
import { ColDef } from 'ag-grid-community';
import {SrcComponent} from "../../e-share/component/src/src.component";
import jsPDF from 'jspdf';
@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.css']
})
export class WarehouseComponent implements OnInit {

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


  @ViewChild('content')
  content!: ElementRef;
  name = '';

  constructor() { }

  ngOnInit(): void {
    this.inquiry();
    this.columnDefs = [
      {
        headerName: '#',
        field: 'id', minWidth: 50, width: 50
      },
      {
        headerName:'image',
        field: 'status',
        cellRenderer: 'srcImg',
        cellClass: 'text-center',
        sortable: false,
        filter: false,
      },
      {
        headerName: 'userName',
        field: 'userName'
      },
      {
        headerName: 'enable',
        field: 'enabled',
        cellRenderer: 'status'
      },
      {
        headerName: 'fullName',
        field: 'fullName'
      },
      {
        headerName: 'dateBirth',
        field: 'dateBirth'
      },
      {
        headerName: 'gender',
        field: 'gender'
      },
      {
        headerName: 'phoneNumber',
        field: 'phoneNumber',
        cellRenderer: 'phoneNumber',
      },
      {
        headerName: 'remark',
        field: 'remark',
      }
    ];
    this.frameworkComponents = {
      srcImg: SrcComponent
    };
    this.defaultColDef = {
      editable: false,
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
    const api = '/api/user/v0/read';
    const data: Data[] = [];
    for (let index = 0; index < 1000000; index++) {
      data.push({
        id: index,
        status: 'status-'+index,
        userName:'userName-'+index,
        enabled: 'enabled-'+index,
        fullName: 'fullName-'+index,
        dateBirth: 'dateBirth-'+index,
        gender: 'gender-'+index,
        phoneNumber: 'phoneNumber-'+index,
        remark: 'remark-'+index,
      });
    }
    this.rowData = data;
    // this.hTTPService.Get(api).then(response => {
    //   if(response.result.responseCode !== HTTPResponseCode.Success) {
    //     this.showErrMsg(response.result.responseMessage);
    //  }else {
    //     this.lstUser = response.body;
    //     this.rowData =this.lstUser;
    //   }
    // });
  }

  makePdf() {
    let doc = new jsPDF();
    doc.setTextColor(255, 0, 0);
    doc.text('Hello world!', 20, 20,{align: "center", baseline:'bottom'});
    // doc.addPage();
    doc.setDrawColor(255, 0, 0);
    doc.line(35, 30, 100, 30);
    doc.save('Test.pdf');
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
