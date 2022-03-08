import { AuthorizationServer } from './../data/authorization.server';
import { Authority } from './../data/authority';

import { AuthorizationServerDataConstant } from './../constants/common.const.authority';

import { Utils } from 'src/app/e-share/util/utils.static';
import { LOCAL_STORAGE } from './../constants/common.const';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanActivateChild {
  authorities: Authority[] = [];

  authorizationServer: AuthorizationServer[] = [];
  constructor() {
    this.authorizationServer = AuthorizationServerDataConstant;

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let checkReturn = false;
      console.log(route);

      this.authorities = Utils.getSecureStorage(LOCAL_STORAGE.CONSTANT_AUTHORITY);
      if('/dashboard' === state.url) {
        checkReturn  = true;
      }
      if( this.authorities && this.authorities.length > 0 ) {
        let code = 'NA';
        this.authorizationServer.forEach(element => {
           if(element.url === state.url) {
              code = element.authorizationCode;
           }
        });
        if(code != 'NA') {
          this.authorities.forEach(itm => {
            if(code === itm.authorizationCode) {
              checkReturn = true;
            }
          });
        }
      }
      if(checkReturn === false) {
        alert("Your user don't have permission access this function. pls check with user administrator");
      }
      return checkReturn;
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    console.log('childRoute', childRoute);
    console.log('state', state.url);
    let checkReturn = false;

      this.authorities = Utils.getSecureStorage(LOCAL_STORAGE.CONSTANT_AUTHORITY);
      if('/dashboard' === state.url) {
        checkReturn  = true;
      }
      if( this.authorities && this.authorities.length > 0 ) {
        let code = 'NA';
        this.authorizationServer.forEach(element => {
           if(element.url === state.url) {
              code = element.authorizationCode;
           }
        });
        if(code != 'NA') {
          this.authorities.forEach(itm => {
            if(code === itm.authorizationCode) {
              checkReturn = true;
            }
          });
        }
      }
      if(checkReturn === false) {
        alert("Your user don't have permission access this function. pls check with user administrator");
      }
      return checkReturn;
 }

}
