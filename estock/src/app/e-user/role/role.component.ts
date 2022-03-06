import { LOCAL_STORAGE } from './../../e-share/constants/common.const';
import { Utils } from 'src/app/e-share/util/utils.static';
import { UserRoleAuthorityDetail } from './../../e-share/data/user.role.authority.detail';
import { UserRoleAuthorityDetailResponse } from '../../e-share/data/response/user.role.authority.tetail.response';
import { HTTPService } from 'src/app/e-share/service/http.service';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import {
  CheckboxSelectionCallbackParams,
  ColDef,
  GridReadyEvent,
  HeaderCheckboxSelectionCallbackParams,
  GridApi
} from 'ag-grid-community';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import { Role } from 'src/app/e-share/data/role';
import { DataService } from 'src/app/e-share/service/data.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {

  disabled = true;

  private gridApi!: GridApi;

  public columnDefs: ColDef[] = [
    {
      headerName: '#',
      field: 'id',
      minWidth: 40,
      checkboxSelection: checkboxSelection,
      headerCheckboxSelection: headerCheckboxSelection,
    },
    {
      headerName: 'Role',
      field: 'role',
      minWidth: 100,
    },
    {
      headerName: 'Authorization',
      field: 'authorizationDisply',
      tooltipField: 'authorizationDisply',
      tooltipComponentParams: { color: '#ececec' },
      minWidth: 300,
    },
    {
      headerName: 'Description',
      field: 'desc',
      tooltipField: 'desc',
      tooltipComponentParams: { color: '#ececec' },
      minWidth: 300,
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
    minWidth: 100,
  };
  public rowSelection = 'single';
  public rowGroupPanelShow = 'always';
  public pivotPanelShow = 'always';
  public rowData!: any[];
  public tooltipShowDelay = 0;
  public tooltipHideDelay = 2000;


  userRoleAuthorityDetailResponse: UserRoleAuthorityDetailResponse[] = [];
  selectedUserRoleAuthorityDetailResponse!: UserRoleAuthorityDetailResponse;

  userRoleAuthorityDetail: UserRoleAuthorityDetail[] = [];
  constructor(
    private dataService: DataService,
    private titleService: Title,
    private router: Router,
    private httpService: HTTPService
  ) {
    const url = (window.location.href).split('/');
    this.dataService.visitParamRouterChange(url[4]);
    this.titleService.setTitle('Employee Request');
    this.selectedUserRoleAuthorityDetailResponse = {} as UserRoleAuthorityDetailResponse;
  }
  ngOnInit(): void {
  }

  onGridReady(params: GridReadyEvent) {
    this.gridApi = params.api;
    this.rowData = stockDatas;
    this.httpService.Get('/api/user-role-authority-detail/index').then(response=> {
      this.userRoleAuthorityDetailResponse = response;
      if(this.userRoleAuthorityDetailResponse.length > 0) {
        this.userRoleAuthorityDetailResponse.forEach((element,index )=> {
          this.userRoleAuthorityDetail.push(
            {
              id: element.id,
              role: element.role,
              desc: element.desc,
              authorizationDisply: ''
            }
          );
          if(element.authorities && element.authorities.length > 0) {
            element.authorities.forEach((elem,i) => {
              if(i === 0) {
                this.userRoleAuthorityDetail[index].authorizationDisply += elem.authorizationCode;
              } else {
                this.userRoleAuthorityDetail[index].authorizationDisply += ","+elem.authorizationCode;
              }
            });
          }
        });
        // console.log('userRoleAuthorityDetail',this.userRoleAuthorityDetail);
        this.rowData = this.userRoleAuthorityDetail;

      }
    });
  }

  onBtnExport() {
    this.gridApi.exportDataAsCsv();
  }

  onSelectionChanged(event: any) {
    const selectedRows = this.gridApi.getSelectedRows();
    if(selectedRows.length === 0) {
      this.disabled = true;
    } else {
      this.disabled = false;
      const itemSelectedGride = selectedRows[0];

      if (this.userRoleAuthorityDetailResponse.length > 0) {
        this.userRoleAuthorityDetailResponse.forEach(element => {
          if(itemSelectedGride.id === element.id) {
            this.selectedUserRoleAuthorityDetailResponse = element;
          }
        });
      }
    }

    console.log(this.selectedUserRoleAuthorityDetailResponse);

    // (document.querySelector('#selectedRows') as any).innerHTML =
    //   selectedRows.length === 1 ? selectedRows[0].athlete : '';
  }

  btnNew() {
    this.router.navigate(['/user/role/add']);
  }

  btnEdit() {
    if(this.selectedUserRoleAuthorityDetailResponse.id > 0) {
      Utils.setSecureStorage(LOCAL_STORAGE.Edit_Role, this.selectedUserRoleAuthorityDetailResponse);
      this.router.navigate(['/user/role/edit']);
    }

  }
  btnDelete() {
    if(this.disabled === false) {
      alert(JSON.stringify(this.selectedUserRoleAuthorityDetailResponse));
    }
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
  warehouse: string;
  userName: string;
}

export const stockDatas: Role[] = [
  {
    id: 1,
    role: 'Admin',
    desc: 'Manage Page roles and settings,Edit the Page and add apps,Create and delete posts as the Page,Send messages as the Page,Respond to and delete comments and posts to the Page,Remove and ban people from the Page,Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page,Publish and manage jobs,Turn on job features for a post',
    userID: 1,
    dateTime: '',
    status: ''
  },
  {
    id: 2,
    role: 'Editor',
    desc: 'Edit the Page and add apps,Create and delete posts as the Page,Send messages as the Page,Respond to and delete comments and posts to the Page,Remove and ban people from the Page,Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page,Publish and manage jobs,Turn on job features for a post',
    userID: 1,
    dateTime: '',
    status: ''
  },
  {
    id: 3,
    role: 'Moderator',
    desc: 'Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page,Publish and manage jobs,Turn on job features for a post',
    userID: 1,
    dateTime: '',
    status: ''
  },
  {
    id: 4,
    role: 'Advertiser',
    desc: 'Send messages as the Page,Respond to and delete comments and posts to the Page,Remove and ban people from the Page,Create ads, promotions or boosted posts,View earnings insights,View other insights,View Page Quality tab,See who published as the Page',
    userID: 1,
    dateTime: '',
    status: ''
  },
  {
    id: 5,
    role: 'Analyst',
    desc: 'View other insights,View Page Quality tab,See who published as the Page',
    userID: 1,
    dateTime: '',
    status: ''
  },

];
