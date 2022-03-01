import { Authorization_Server } from './../constants/common.const.authority';
import { Utils } from 'src/app/e-share/util/utils.static';
import { LOCAL_STORAGE } from './../constants/common.const';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  data: any[] =[];
  dataAuthorites: any[] = [];

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let checkReturn = false;
      console.log('route', route);
      console.log('state', state);
      console.log('state url', state.url);
      this.data = Utils.getSecureStorage(LOCAL_STORAGE.CONSTANT_AUTHORITY);
      console.log(this.data);

      if('/dashboard' === state.url) {
        checkReturn  = true;
      }
      if( this.data && this.data.length > 0 ) {
        let code = 'NA';
        Authorization_Server.forEach(element => {
           if(element.url === state.url) {
              code = element.authorizationServer;
           }
        });
        if(code != 'NA') {
          for (let index = 0; index < this.data.length; index++) {
            const element = this.data[index];
            if(code === element.name) {
              checkReturn = true;
            }
          }
        }
      }
      if(checkReturn === false) {
        alert("Your user don't have permission access this function. pls check with user administrator");
      }
      return checkReturn;
  }

}
