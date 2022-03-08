import { Router } from '@angular/router';
import { HTTPService } from './../../e-share/service/http.service';
import { AuthorizationCode } from './../../e-share/data/authorization';
import { AuthorizationCodeDataConstant } from './../../e-share/constants/commont.authorization.code';
import { Authority } from './../../e-share/data/authority';
import { NgForm } from '@angular/forms';
import { UserRoleRequest } from './../../e-share/data/request/user.role.request';
import { UserRoleAuthorityDetailResponse } from './../../e-share/data/response/user.role.authority.tetail.response';
import { LOCAL_STORAGE } from './../../e-share/constants/common.const';
import { Utils } from 'src/app/e-share/util/utils.static';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DataService } from 'src/app/e-share/service/data.service';

@Component({
  selector: 'app-edit-role',
  templateUrl: './edit-role.component.html',
  styleUrls: ['./edit-role.component.css']
})
export class EditRoleComponent implements OnInit, OnDestroy {

  userRoleAuthorityDetail!: UserRoleAuthorityDetailResponse;
  authorizations: number[] =[];
  userRole!: UserRoleRequest;
  authorities: Authority[] = [];

  checkReadUser: boolean = false;
  checkAddUser:boolean = false;
  checkEditUser:boolean = false;
  checkDeleteUser: boolean = false;
  checkExportUser: boolean = false;

  checkReadRole:boolean = false;
  checkAddRole: boolean = false;
  checkEditRole: boolean = false;
  checkDeleteRole: boolean = false;

  authorizationCodeDataConstant:AuthorizationCode[] = AuthorizationCodeDataConstant;

  constructor(
    private dataService: DataService,
    private titleService: Title,
    private httpService: HTTPService,
    private router: Router
  ) {
    const url = (window.location.href).split('/');
    this.dataService.visitParamRouterChange(url[4]);
    this.titleService.setTitle('Edit User Role');
    this.userRole = {} as UserRoleRequest;
    this.userRoleAuthorityDetail = {} as UserRoleAuthorityDetailResponse;
    this.userRoleAuthorityDetail = Utils.getSecureStorage(LOCAL_STORAGE.Edit_Role);
    if(this.userRoleAuthorityDetail) {
      this.authorities = this.userRoleAuthorityDetail.authorities;
      this.authorities.forEach(element => {
        this.authorizations.push(element.id);
        this.checkAuthorizationCode(element.authorizationCode);
      });
      this.userRole.id = this.userRoleAuthorityDetail.id;
      this.userRole.role = this.userRoleAuthorityDetail.role;
      this.userRole.desc = this.userRoleAuthorityDetail.desc;
    }
  }

  ngOnDestroy(): void {
    Utils.removeSecureStorage(LOCAL_STORAGE.Edit_Role);
  }

  ngOnInit(): void {

  }

  btnCheck(authorizationId: number, event: any) {
    const checked = event.target.checked;
    // console.log(this.authorizations);
    if(checked === false) {
      this.authorizations.forEach((element, index) => {
        if(element === authorizationId) {
          this.authorizations.splice(index,1);
        }
      });
    }

    if(checked === true){
      this.authorizations.push(authorizationId);
    }

    // this.authorizations.push(authorizationId);
    // console.log(event, event.target.checked);
    // if(this.authorizations.length > 0) {
    //   this.authorizations.forEach((element, index) => {
    //     console.log(element, this.authorizations.splice(index));

    //   });

    // }
    // console.log('authorizations', this.authorizations);

  }

  btnSave(form: NgForm) {
    if (form.invalid) {
      for (const control of Object.keys(form.controls)) {
        form.controls[control].markAsTouched();
      }
      return;
    } else {
      this.userRole.authorities = this.authorizations;
      this.httpService.Post('/api/user-role/edit', this.userRole).then(response => {
        if(response === true) {
            this.router.navigate(['/user/role']);
        }
      });
    }
  }

  checkAuthorizationCode(authorizationCode:string) {

    switch(authorizationCode) {
      case this.authorizationCodeDataConstant[0].authorizationCode:
        this.checkReadUser = true;
        break;
      case this.authorizationCodeDataConstant[1].authorizationCode:
        this.checkAddUser = true;
        break;
      case this.authorizationCodeDataConstant[2].authorizationCode:
        this.checkEditUser = true;
        break;
      case this.authorizationCodeDataConstant[3].authorizationCode:
        this.checkDeleteUser = true;
        break;
      case this.authorizationCodeDataConstant[4].authorizationCode:
        this.checkExportUser = true;
        break;

      case this.authorizationCodeDataConstant[5].authorizationCode:
        this.checkReadRole = true;
        break;
      case this.authorizationCodeDataConstant[6].authorizationCode:
        this.checkAddRole = true;
        break;
      case this.authorizationCodeDataConstant[7].authorizationCode:
        this.checkEditRole = true;
        break;
      case this.authorizationCodeDataConstant[8].authorizationCode:
        this.checkDeleteRole = true;
        break;
    }
  }

}
