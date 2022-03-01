import { UserAuthorizationServer } from './../data/user.authorization.code';
import { authorizationServer } from './../constants/common.const.authority';

import { Utils } from 'src/app/e-share/util/utils.static';
import { LOCAL_STORAGE } from './../constants/common.const';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  userAuthorization: UserAuthorizationServer[] =[];
  dataAuthorites: any[] = [];

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let checkReturn = false;
      console.log('route', route);
      console.log('state', state);
      console.log('state url', state.url);
      this.userAuthorization = Utils.getSecureStorage(LOCAL_STORAGE.CONSTANT_AUTHORITY);
      console.log(this.userAuthorization);

      if('/dashboard' === state.url) {
        checkReturn  = true;
      }
      if( this.userAuthorization && this.userAuthorization.length > 0 ) {
        let code = 'NA';
        authorizationServer.forEach(element => {
           if(element.url === state.url) {
              code = element.authorizationCode;
              console.log(element);

           }
        });
        if(code != 'NA') {
          this.userAuthorization.forEach(itm => {
            if(code === itm.userAuthorizationCode) {
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
