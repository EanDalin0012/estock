import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { DataService } from 'src/app/e-share/service/data.service';
import { HTTPService } from 'src/app/e-share/service/http.service';
import {AllCommunityModules} from "@ag-grid-community/all-modules";
import {ColDef, Context} from "ag-grid-community";
import { TemplateAPI } from 'src/app/e-share/constants/common.api';
import { UserInfo } from 'src/app/e-share/data/user-inf';
import { EmployeeRequest } from 'src/app/e-share/data/employee-request';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { SaleProductTypeDetail } from 'src/app/e-share/data/sale-product-type-dt';
import { SaleProductType } from 'src/app/e-share/data/sale-product-type';
import { SaleDetail } from 'src/app/e-share/data/sale-dt';
import { PipeUtil } from 'src/app/e-share/util/pipe-util';
import { Utils } from 'src/app/e-share/util/utils.static';

@Component({
  selector: 'app-sale-invoice',
  templateUrl: './sale-invoice.component.html',
  styleUrls: ['./sale-invoice.component.css']
})
export class SaleInvoiceComponent implements OnInit, OnDestroy {
  @ViewChild('htmlData') htmlData!:ElementRef;

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
  employeeRequests: EmployeeRequest[] = [];

  saleProductTypeDetails!: SaleProductTypeDetail[];
  saleProductTypes!: SaleProductType[];

  saleProductTypeDetail!: SaleProductTypeDetail;
  saleProductType!: SaleProductType;
  saleDetails: SaleDetail[] = [];

  total: number = 0;
  totalStr: string = '';
  newQty: number = 0;
  paidAmount: number = 0;

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
  ngOnDestroy(): void {
    Utils.removeSecureStorage('sale-info');
  }

  ngOnInit(): void {

    this.columnDefs = [
      {
        headerName: 'Product',
        field: 'productName'
      },
      {
        headerName: 'Sale Type Product',
        field: 'saleTypeProduct'
      },
      {
        headerName: 'Price',
        field: 'price'
      },
      {
        headerName: 'Total Qty',
        field: 'totalQty'
      },
      {
        headerName: 'Total',
        field: 'totalStr'
      }, {
        headerName: 'Paid Amount',
        field: 'paidAmountStr'
      }
    ];

    this.defaultColDef = {
      editable: false,
      sortable: true,
      flex: 1,
      // minWidth: 50,
      filter: true,
      resizable: true,
    };

    this.rowSelection = 'multiple';
    this.isRowSelectable = function (rowNode: any) {
      return rowNode.data;
    };
    const data =  Utils.getSecureStorage('sale-info');
    if(data) {
      this.saleDetails = data.saleDetails;
      console.log(this.saleDetails);

      this.rowData = this.saleDetails;
    }

    console.log('data', data);

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
    console.log('test');
    // this.rowData = this.saleDetails;
  }

  onNewRequest() {
    this.router.navigate(['/employee-request/form']);
  }

  onChangeProduct(event: any) {
    console.log(JSON.stringify( event.target.value));
    console.log(this.saleProductTypeDetail);
    this.saleProductTypes = this.saleProductTypeDetail.saleProductTypes;
  }

  onChangeSaleProductType(event: any) {
    this.total = this.saleProductType.total;
    this.totalStr =  PipeUtil.amount(this.total) + ' $';
  }

  inputQty(event: any) {
    if(event.target.value && Number(event.target.value > 0)) {
      this.newQty = Number(event.target.value);
      this.total = (Number(this.saleProductType.qty) +this.newQty ) * this.saleProductType.price;
      this.totalStr = PipeUtil.amount(this.total) + ' $';
    }
  }

  btnConfirm() {

  }

  btnBack() {
    this.router.navigate(['/sale']);
  }

  btnDownloadPDF1() {
    this.hTTPService.Get('/api/pdf-exporter/users/export/pdf').then(rest=> {
      console.log(rest);
    });
  }

  btnDownloadPDF() {
    // const DATA = document.getElementById('htmlData') as HTMLElement;
    // console.log('DATA', DATA);

    // html2canvas(DATA).then(canvas => {

    //     let fileWidth = 208;
    //     let fileHeight = canvas.height * fileWidth / canvas.width;

    //     const FILEURI = canvas.toDataURL('image/png')
    //     let PDF = new jsPDF('p', 'mm', 'a4');
    //     let position = 0;
    //     PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight)

    //     PDF.save('angular-demo.pdf');
    //   });
  }

}
