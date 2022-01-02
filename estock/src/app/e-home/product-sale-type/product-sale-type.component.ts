import { AllDatas } from './../../../assets/all-modules-data/all-modules-data';
import {  Component, OnInit, ElementRef } from '@angular/core';
import { ViewChild } from "@angular/core";
import { ToastrService } from "ngx-toastr";
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
declare const $: any;
import { AllCommunityModules } from '@ag-grid-community/all-modules';
import { ColDef } from 'ag-grid-community';
import { DataService } from 'src/app/e-share/service/data.service';
import { HTTPService } from 'src/app/e-share/service/http.service';
import { AuthService } from 'src/app/e-share/service/auth.service';
@Component({
  selector: 'app-product-sale-type',
  templateUrl: './product-sale-type.component.html',
  styleUrls: ['./product-sale-type.component.css']
})
export class ProductSaleTypeComponent implements OnInit {


 // Add Modal
 submitted: boolean = false;
 public form: any;
 @ViewChild("movieType") inputMovieType: any;

 // Edit Modal
 editSubmitted: boolean = false;
 public formEdit: any;
 @ViewChild("editMovieType") inputEditMovieType: any;

 products: any[] = [];

 selectedJson: any;

 lstMovies: any[] = [];
 disabled = true;

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

 menueAccessAdd = false;
 menueAccessEdit = false;
 menueAccessDelete = false;

 flags = 'assets/img/flags/us.png';
 langText  = 'English';

 userInfo:any = {
  fullName: "Ean Dalin"
  };
  src = '';
 constructor(
   private formBuilder: FormBuilder,
  //  private toastr: ToastrService,
   private dataService: DataService,
   private router: Router,
  //  private hTTPService: HTTPService,
   private translate: TranslateService,
   private authService: AuthService
 ) {

   const url = (window.location.href).split('/');
   this.dataService.visitParamRouterChange(url[4]);

   this.form as FormGroup;
   this.formEdit as FormGroup;
   this.inputMovieType as ElementRef;
   this.inputEditMovieType as ElementRef;

   this.form = this.formBuilder.group({
     movieType: ['', [Validators.required]],
     remark: ['', [Validators.required]]
   });

   this.formEdit = this.formBuilder.group({
     editMovieType: ['', [Validators.required]],
     editRemark: ['', [Validators.required]]
   });

 }

 checked = false;

 ngOnInit() {

  this.inquiryProduct();
   this.inquiry();

   this.columnDefs = [
     {
       headerName: '#',
       field: 'id', minWidth: 50, width: 50},
     {
       headerName: 'Sale Type of Product',
       field: 'productSaleType' },
     {
       headerName: 'Qty',
       field: 'qty',
     },
     {
      headerName: 'Unit Price',
      field: 'unitPrice',
    },
    {
      headerName: 'Total Price',
      field: 'totalPrice',
    }
   ];

  //  this.frameworkComponents = {
  //    medalCellRenderer: ActionComponent
  //  };

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

   this.menueAccessAdd = this.authService.isTargetPath('home/seting-sub-movie-type-add');
   this.menueAccessEdit = this.authService.isTargetPath('home/seting-sub-movie-type-edit');
   this.menueAccessDelete = this.authService.isTargetPath('home/seting-sub-movie-type-delete');

   console.log('menueAccessAdd', this.menueAccessAdd);
   console.log('menueAccessEdit', this.menueAccessEdit);
   console.log('menueAccessDelete', this.menueAccessDelete);
 }

 onGridReady(params:any) {
   this.gridApi = params.api;
   this.gridColumnApi = params.columnApi;
   this.inquiry();
 }

 onSelectionChanged(event: any) {
   var selectedRows = this.gridApi.getSelectedRows();
   if(selectedRows) {
     this.disabled = false;
   }
 }

 onChangeLanguage(code: string) {
  // this.langCode = code;
  // if(code == 'en') {
  //   this.flags = 'assets/img/flags/us.png';
  //   this.langText = 'English';
  // } else if (code == 'kh') {
  //   this.flags = 'assets/img/flags/kh.png';
  //   this.langText = 'ខ្មែរ';
  // } else if (code == 'ch') {
  //   this.flags = 'assets/img/flags/cn.png';
  //   this.langText = '中文';
  // }
  // console.log(this.langCode, localStorage.I18N, code);
  // Utils.setSecureStorage(LOCAL_STORAGE.I18N, this.langCode );
  // this.translate.use( this.langCode );
}

 getSelectedRowData(note:string) {
   let selectedNodes = this.gridApi.getSelectedNodes();
   let selectedData = selectedNodes.map((node: { data: any; }) => node.data);
   this.selectedJson = selectedData[0];
   if(note === 'edit') {
     this.formEdit.patchValue({
       editMovieType: this.selectedJson.name,
       editRemark: this.selectedJson.remark
     });
     $("#edit_movie_type").modal("show");
   } else if (note === 'delete') {
     $("#delele").modal("show");
   }
   return selectedData;
 }

 onBtnExport() {
   this.gridApi.exportDataAsCsv();
 }


 addMovieType() {
   $("#add_movie_type").modal("show");
 }

 save() {
  //  this.submitted = true;
  //  if(this.f.movieType.errors) {
  //    this.inputMovieType.nativeElement.focus();
  //  } else {
  //    const data = this.form.getRawValue();
  //    const api = '/api/sub-movie-type/v0/create';
  //    const jsonData = {
  //      name: data.movieType,
  //      remark: data.remark
  //    };
  //    this.hTTPService.Post(api, jsonData).then(response => {
  //      console.log(response);

  //      if(response.result.responseCode === HTTPResponseCode.Success) {
  //        this.inquiry();
  //        this.toastr.info(this.translate.instant('movieType.message.added'), this.translate.instant('common.label.success'),{
  //          timeOut: 5000,
  //        });
  //        this.form = this.formBuilder.group({
  //          movieType: '',
  //          remark: ''
  //        });
  //        $("#add_movie_type").modal("hide");
  //      } else {
  //        this.showErrMsg(response.result.responseMessage);
  //      }
  //    });
  //  }
 }

 update() {
  //  this.editSubmitted = true;
  //  if(this.fEdit.editMovieType.errors) {
  //    this.inputEditMovieType.nativeElement.focus();
  //  } else if(!this.selectedJson.id) {
  //    this.showErrMsg('unSelectRow');
  //  } else {
  //    const data = this.formEdit.getRawValue();
  //    const api = '/api/sub-movie-type/v0/update';
  //    const jsonData = {
  //      id: this.selectedJson.id,
  //      name: data.editMovieType,
  //      remark: data.editRemark
  //    };
  //    this.hTTPService.Post(api, jsonData).then(response => {
  //      if(response.result.responseCode === HTTPResponseCode.Success) {
  //        this.inquiry();
  //        this.disabled = true;
  //        $("#edit_movie_type").modal("hide");
  //        this.toastr.info(this.translate.instant('movieType.message.udpated'), this.translate.instant('common.label.success'),{
  //          timeOut: 5000,
  //        });
  //        this.formEdit = this.formBuilder.group({
  //          editMovieType: '',
  //          editRemark: ''
  //        });

  //      } else {
  //        this.showErrMsg(response.result.responseMessage);
  //      }
  //    });
  //  }
 }

 delete() {
  //  if (this.selectedJson.id) {
  //    const api = '/api/sub-movie-type/v0/delete';
  //    const jsonData = {
  //      id: this.selectedJson.id
  //    };
  //    this.hTTPService.Post(api, jsonData).then(response => {
  //      if(response.result.responseCode === HTTPResponseCode.Success) {
  //        this.inquiry();
  //        this.disabled = true;
  //        $("#delele").modal("hide");
  //        this.toastr.info(this.translate.instant('movieType.message.deleted'), this.translate.instant('common.label.success'),{
  //          timeOut: 5000,
  //        });
  //      } else {
  //        this.showErrMsg(response.result.responseMessage);
  //      }
  //    });
  //  } else {
  //    this.showErrMsg('Invalid_Vd_ID');
  //  }

 }

 // Get Employee  Api Call
 inquiry() {
  //  const api = '/api/sub-movie-type/v0/read';
  //  this.hTTPService.Get(api).then(response => {
  //    if(response.result.responseCode !== HTTPResponseCode.Success) {
  //       this.showErrMsg(response.result.responseMessage);
  //    } else {
  //      this.lstMovies = response.body;
  //      this.rowData =this.lstMovies;
  //    }
  //  });

  this.lstMovies =AllDatas.productSaleTypes[0].datas;
  this.rowData =this.lstMovies;
  console.log(this.rowData);

 }

 ngOnDestroy(): void {
 }

 searchChange(event:any): void {
   if (event) {
    const search = this.lstMovies.filter( data => data.name.toLowerCase().includes(event.target.value));
    this.rowData = search;
   }
 }

 showErrMsg(msgKey: string, value?: any){
   let message = '';
   switch(msgKey) {
     case 'Invalid_Name':
       message = this.translate.instant('movieType.message.movieTypeRequired');
       break;
     case 'Invalid_SubVd_Id':
       message = this.translate.instant('serverResponseCode.label.inValidMovieTypeIdWithValue', {value: value});
       break;

     case 'Invalid_Vd_ID':
       message = this.translate.instant('serverResponseCode.label.inValidMovieTypeId');
       break;
     case 'unSelectRow':
       message = this.translate.instant('common.message.unSelectRow');
       break;
     case '500':
       message = this.translate.instant('serverResponseCode.label.serverError');
       break;
     default:
       message = this.translate.instant('serverResponseCode.label.unknown');
       break;
   }
  //  this.toastr.error(message, this.translate.instant('common.label.error'),{
  //    timeOut: 5000,
  //  });
 }

 get f(): { [key: string]: AbstractControl } {
   return this.form.controls;
 }

 get fEdit(): { [key: string]: AbstractControl } {
   return this.formEdit.controls;
 }

 // Inquiry Product API
  inquiryProduct() {
    this.products = AllDatas.products;
  }

  searchProduct(val:any) {
    console.log(val.target.value);
  }

}
