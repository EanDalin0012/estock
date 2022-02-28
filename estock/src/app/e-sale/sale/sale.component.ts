import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/e-share/service/data.service';
import { HTTPService } from 'src/app/e-share/service/http.service';

import { EmployeeRequest } from 'src/app/e-share/data/employee-request';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { SaleProductTypeDetail } from 'src/app/e-share/data/sale-product-type-dt';
import { SaleProductType } from 'src/app/e-share/data/sale-product-type';
import { SaleDetail } from 'src/app/e-share/data/sale-dt';
import { PipeUtil } from 'src/app/e-share/util/pipe-util';
import { Utils } from 'src/app/e-share/util/utils.static';
declare const $: any;
import { ColDef, GridReadyEvent } from 'ag-grid-community';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {


  public columnDefs: ColDef[] = [
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
      },
      {
        headerName: 'Paid Amount',
        field: 'paidAmountStr'
      }

  ];

  public defaultColDef: ColDef = {
    resizable: true,
    sortable: true,
    filter: true,
  };
  public rowData!: any[];
  pagination = true;
  paginationPageSize = 20;
  gridApi:any

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

  isCustomer: boolean = true;
  discount: number =0;

  style: any = {
    width: '100%',
    height: '100%',
    flex: '1 1 auto'
  };

  constructor(
    private hTTPService: HTTPService,
    private dataService: DataService,
    private titleService: Title,
    private router: Router,
    private http: HttpClient
  ) {
    const url = (window.location.href).split('/');
    console.log(url)
    this.dataService.visitParamRouterChange(url[3]);
    this.titleService.setTitle('Employee Request');
  }

  ngOnInit(): void {
    this.inquiry();
  }

  onGridReady(params: GridReadyEvent) {
    this.gridApi = params.api;
    // this.http
    //   .get<any[]>('https://www.ag-grid.com/example-assets/olympic-winners.json')
    //   .subscribe((data) => (this.rowData = data));
      this.rowData = [
      {
        saleProductType: null,
        saleTypeProduct: '',
        proudct: {
          id: 0,
          productName: '',
          desc: '',
        },
        productName: '',
        newQty: 0,
        totalQty: null,
        total: 0
      }
    ]
  }

  // onSelectionChanged(event: any) {
  //   const selectedRows = this.gridApi.getSelectedRows();
  // }


  // onCellValueChanged(event:any) {
  //   console.log('data after changes is: ', event.data);
  //   const data = event.data as UserInfo;
  //   console.log(data);
  //   if(data) {
  //     this.hTTPService.Post(TemplateAPI.USER_INFO.UPDATE, data).then(response => {
  //       console.log(response);
  //       this.inquiry();
  //     });
  //   }
  // }

  // onCellDoubleClicked(event:any) {
  //   if(event) {
  //     // const jsonString = JSON.stringify(this.lstUser[event.rowIndex]);
  //     // const encryptString = EncryptionUtil.encrypt(jsonString.toString()).toString();
  //     // Utils.setSecureStorage(LOCAL_STORAGE.UserDetail, encryptString);
  //     // this.router.navigate(['account/user-detail']);
  //   }
  // // }

  // onGridReady(params:any) {
  //   this.gridApi = params.api;
  //   this.gridColumnApi = params.columnApi;
  //   this.inquiry();
  //   console.log('test');

  //   // this.rowData = this.saleDetails;
  // }

  inquiry() {
    this.saleProductTypeDetails = [{
      productId: 1,
      productName: 'P-White Milk Bath',
      desc: '',
      saleProductTypes: [
        {
          id: 1,
          saleProductType: 'Price',
          qty: 1,
          price: 15,
          total: 15
        },
        {
          id: 2,
          saleProductType: 'Silver',
          qty: 6,
          price: 10,
          total: 60
        },
        {
          id: 3,
          saleProductType: 'VIP Silver',
          qty: 15,
          price: 9.5,
          total: 142.5
        },
        {
          id: 4,
          saleProductType: 'Premuim',
          qty: 35,
          price: 9,
          total: 315
        },{
          id: 5,
          saleProductType: 'VIP Premuim',
          qty: 55,
          price: 8.5,
          total: 467.5
        },{
          id: 6,
          saleProductType: 'Gold',
          qty: 100,
          price: 8,
          total: 800
        },{
          id: 7,
          saleProductType: 'VIP Gold',
          qty: 200,
          price: 7.5,
          total: 1500
        },{
          id: 8,
          saleProductType: 'Diamond',
          qty: 400,
          price: 7,
          total: 2800
        },{
          id: 9,
          saleProductType: 'VIP Diamond',
          qty: 600,
          price: 6.5,
          total: 3900
        },{
          id: 10,
          saleProductType: 'Queen',
          qty: 1000,
          price: 6,
          total: 6000
        },{
          id: 11,
          saleProductType: 'VIP Queen',
          qty: 2000,
          price: 5.5,
          total: 11000
        },{
          id: 12,
          saleProductType: 'Super Queen',
          qty: 3000,
          price: 5,
          total: 15000
        },
      ]
    },{
      productId: 2,
      productName: 'P-White',
      desc: '',
      saleProductTypes: []
    },{
      productId: 3,
      productName: 'Tamarind Scrub',
      desc: '',
      saleProductTypes: [
        {
          id: 1,
          saleProductType: 'Price',
          qty: 1,
          price: 10,
          total: 10
        },{
          id: 2,
          saleProductType: 'Silver',
          qty: 6,
          price: 5.5,
          total: 33
        },{
          id: 3,
          saleProductType: 'VIP Silver',
          qty: 12,
          price: 5,
          total: 60
        },{
          id: 4,
          saleProductType: 'Premuin',
          qty: 60,
          price: 4.5,
          total: 270
        },{
          id: 5,
          saleProductType: 'VIP Premuin',
          qty: 144,
          price: 4,
          total: 576
        },{
          id: 6,
          saleProductType: 'Gold',
          qty: 600,
          price: 3.5,
          total: 2100
        },{
          id: 7,
          saleProductType: 'VIP Gold',
          qty: 1800,
          price: 3,
          total: 5400
        }
      ]
    }
    ];

    this.saleProductTypeDetail = this.saleProductTypeDetails[0];
    this.saleProductTypes = this.saleProductTypeDetail.saleProductTypes;
    this.saleProductType = this.saleProductTypes[0];
    this.total = this.saleProductType.total;
    this.totalStr = PipeUtil.amount(this.total) + ' $';
    // this.rowData = [
    //   {
    //     saleProductType: null,
    //     saleTypeProduct: '',
    //     proudct: {
    //       id: 0,
    //       productName: '',
    //       desc: '',
    //     },
    //     productName: '',
    //     newQty: 0,
    //     totalQty: null,
    //     total: 0
    //   }
    // ]

    const api = '/api/user-info';
    // this.hTTPService.Get(TemplateAPI.USER_INFO.URL).then(response =>{
    //   console.log("response", response)
    //   this.rowData = response;
    // });
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
    this.total = (this.newQty + this.saleProductType.qty) * this.saleProductType.price;
    this.totalStr =  PipeUtil.amount(this.total) + ' $';
    // if(this.discount > 0) {
    //   const discountRate = this.discount / 100;
    //   const discountedPrice = this.total - (this.total * discountRate) ;
    //   this.total = discountedPrice;
    //   this.totalStr = PipeUtil.amount(this.total) + ' $';
    // }

  }

  inputQty(event: any) {
    if(event.target.value && Number(event.target.value > 0)) {
      this.newQty = Number(event.target.value);
      this.total = (Number(this.saleProductType.qty) +this.newQty ) * this.saleProductType.price;
      this.totalStr = PipeUtil.amount(this.total) + ' $';
    }

    if (event.target.value && Number(event.target.value < 0)) {
      event.target.value = 0;
    }
  }

  inputDisCound(event: any) {
    console.log(event.target.value);
    if (event.target.value && Number(event.target.value < 0)) {
      event.target.value = '0 %';
    } else {
      this.discount =  Number(event.target.value );
    }
    // console.log(event.target.value );
    // if(event.target.value && Number(event.target.value > 0)) {
    //   this.total = (this.newQty + this.saleProductType.qty) * this.saleProductType.price;
    //   this.totalStr = PipeUtil.amount(this.total) + ' $';
    // }
  }

  calculateDiscount(discount: number, totalPrice:number): number {
    const discountRate = discount / 100;
    const discountedPrice = totalPrice - (totalPrice * discountRate) ;
    return discountedPrice;
  }

  btnAdd() {
      this.saleDetails.push({
        saleProductType: this.saleProductType,
        saleTypeProduct: this.saleProductType.saleProductType,
        proudct: {
          id: this.saleProductTypeDetail.productId,
          productName: this.saleProductTypeDetail.productName,
          desc: this.saleProductTypeDetail.desc,
        },
        productName: this.saleProductTypeDetail.productName,
        newQty: this.newQty ,
        totalQty: (this.newQty + this.saleProductType.qty),
        price:  PipeUtil.amount(this.saleProductType.price) + ' $',
        total: this.total,
        totalStr: PipeUtil.amount(this.total) + ' $',
        paidAmount: this.calculateDiscount(this.discount, this.total),
        paidAmountStr: PipeUtil.amount(this.calculateDiscount(this.discount, this.total)) + ' $',
        discount: this.discount
      });

      if(this.saleDetails.length > 0) {
        this.paidAmount = 0;
        this.saleDetails.forEach(element => {
          this.paidAmount += element.paidAmount;
        });
      }
      this.rowData = this.saleDetails;
      this.gridApi.setRowData(this.rowData);

      console.log(this.saleDetails);
  }

  isSelectCustomer(isCustomer: boolean) {
    this.isCustomer = isCustomer;
  }

  btnToDo() {
    $("#add_movie_type").modal("show");
  }

  btnConfirm() {
    $("#add_movie_type").modal("hide");
      const data = {
        isCustomer: this.isCustomer,
        saleDetails: this.saleDetails,
        customerInfo: {
          phone: '038983',
          customerName: 'Ean Dalin',
        },
        member: {
          name: '',
        }
      }
      Utils.setSecureStorage('sale-info', data);
      this.router.navigate(['/sale/sale-invoice']);
  }
}
