import { TokenInfo } from './../data/token.info';
import { LoadUser } from './../data/request/load.user';
import { Credentails } from './../data/credentail';

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { LOCAL_STORAGE, HTTPResponseCode } from '../constants/common.const';
import { DeviceDetectorService } from 'ngx-device-detector';
import * as moment from 'moment';
import { AuthService } from './auth.service';
import { ToastrService } from 'ngx-toastr';
import { Utils } from '../util/utils.static';
import {TemplateAPI} from "../constants/common.api";

@Injectable({
  providedIn: 'root'
})
export class AuthentcatiionService {
  private baseUrl: string = '';

  constructor(
    private httpClient: HttpClient,
    private translate: TranslateService,
    private router: Router,
    private toastr: ToastrService,
    private deviceService: DeviceDetectorService,
    private authService: AuthService
  ) {
    this.baseUrl = environment.bizServer.server;
  }

  public login(auth: Credentails, basicAuth?: BasicAuth): Promise<any> {
    return new Promise((resovle, reject) => {
      this.authService.setLastEventTime();
      this.accessTokenRequest(auth, basicAuth).then(response => {
        console.log('accessTokenRequest',response);
        if(response) {
          Utils.setSecureStorage(LOCAL_STORAGE.Authorization, response)
          resovle(response);
        } else {
          reject()
        }


        // if(response?.header?.result== false) {
        //   if (response.access_token) {
        //     Utils.setSecureStorage(LOCAL_STORAGE.Authorization, response);
        //     resovle(response.header);
        //   }
        // }
        // if (response.access_token) {
        //   Utils.setSecureStorage(LOCAL_STORAGE.Authorization, response);
        //   this.loadUserByUserName(auth.userName, response.access_token).then((result) => {
        //     console.log('loadUserByUserName',result);

        //     if (result) {
        //       Utils.setSecureStorage(LOCAL_STORAGE.USER_INFO, result);
        //       resovle(result);
        //     }
        //   }).catch((err) => {
        //     $('body').addClass('loaded');
        //     $('div.loading').addClass('none');
        //     console.log('err', err);
        //   });
        // }
      });
    });

  }

  public loadUserByUserName(loaduser: LoadUser, tokenInfo: TokenInfo): Promise<any> {
    return new Promise((resolve, reject) => {

      const lang = Utils.getSecureStorage(LOCAL_STORAGE.I18N);
      const httpOptionsObj = {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + tokenInfo.access_token
      };

      const date = moment().format('YYYYMMDD hh:mm:ss');
      const uri = this.baseUrl + '/api/load-user/index?lang=' + lang;
      // $('div.loading').removeClass('none');
      // $('body').removeClass('loaded');

      this.httpClient.post(uri, JSON.stringify(loaduser), {
        headers: new HttpHeaders(httpOptionsObj)
      }).subscribe( res => {
          // $('body').addClass('loaded');
          // $('div.loading').addClass('none');
          const responseData = res as any;
          console.log('responseData', responseData);

          if (responseData.resultCode ===  HTTPResponseCode.Success) {
            resolve(responseData.body);
            return;
          }
          if(responseData.resultCode && responseData.resultCode != HTTPResponseCode.Success) {
            alert(responseData.resultMessage);
          }
      }, error => {
        // $('body').addClass('loaded');
        // $('div.loading').addClass('none');
        console.log('error', error);
      });
    });
  }

  private accessTokenRequest(auth: Credentails, basicAuth?: BasicAuth): Promise<any> {
    return new Promise((resovle) => {
      // $('div.loading').removeClass('none');

      if (!auth.userName || auth.userName === null) {
        // this.modalService.alert(
        //   this.translate.instant('COMMON.MESSAGE.InValid_User_Name'),
        //   {
        //   btnText: this.translate.instant('COMMON.BUTTON.CONFIRME'),
        //   callback: (res) => {},
        // });
        return;
      }

      let credentail: BasicAuth;


      if (!basicAuth) {
        credentail = {
          User_name: 'spring-security-oauth2-read-write-client',
          password: 'spring-security-oauth2-read-write-client-password1234',
        };
      } else {
        credentail = basicAuth;
      }

      const api = '/oauth/token';
      const uri = this.baseUrl + api;
      const btoa = 'Basic ' + window.btoa(credentail.User_name + ':' + credentail.password);
      const httpOptionsObj = {
        Authorization: btoa
      };

      // const formData = new FormData();
      // formData.append('client_id', 'spring-security-oauth2-read-write-client');
      // formData.append('grant_type', 'password');
      // formData.append('username', auth.user_name);
      // formData.append('password', auth.password);

      // const data = this.deviceService.getDeviceInfo();

      const formData = new FormData();
      const username = auth.userName;//EncryptionUtil.encrypt(auth.user_name);
      const password = auth.password//;EncryptionUtil.encrypt(auth.password);

      // const cInfo = EncryptionUtil.encrypt(username.toString()+ '#'+password.toString()).toString();
      // console.log('cInfo', cInfo);


      // Utils.setSecureStorage('cInfo', cInfo);

      formData.append('client_id', 'spring-security-oauth2-read-write-client');
      formData.append('grant_type', 'password');
      formData.append('username', username);
      formData.append('password', password);
      const data = this.deviceService.getDeviceInfo();
      const date = moment().format('YYYYMMDD hh:mm:ss');
      const deviceInfo = {
        userAgent: data.userAgent,
        os: data.os,
        browser: data.browser,
        device: data.device,
        osVersion: data.os_version,
        browserVersion: data.browser_version,
        deviceType: data.deviceType,
        orientation: data.orientation,
        networkIP: Utils.getSecureStorage(LOCAL_STORAGE.NekWorkIP),
        date: date
      };

      // formData.append('deviceInfo', EncryptionUtil.encrypt(JSON.stringify(deviceInfo)));

      this.httpClient.post(uri, formData, {
          headers: new HttpHeaders(httpOptionsObj),
        }).subscribe((auth: any) => {
          console.log("auth", auth);
          if(auth && auth.resultCode) {
            alert(auth.resultMessage);
          } else {
            resovle(auth);
          }

        },error => {
          // $('body').addClass('loaded');
          // $('div.loading').addClass('none');
          console.log('error', error);
        });
    });
    }

    public revokeToken(): Promise<any> {
      return new Promise((resolve, reject) => {
        const userInfo = Utils.getSecureStorage(LOCAL_STORAGE.USER_INFO);
        const lang = Utils.getSecureStorage(LOCAL_STORAGE.I18N);
        const api  = "/api/oauth2/revoke-token";
        const uri = this.baseUrl + api + '?userId=' + userInfo.id + '&lang=' + lang;
        let authorization = Utils.getSecureStorage(LOCAL_STORAGE.Authorization);
        const access_token = authorization.access_token;
        const headers = {
          'Authorization': 'Bearer ' + access_token
        };

        this.httpClient.get(uri, {headers}).subscribe(rest => {
          const result = rest as any;
          if(result.body && result.body.responseCode === '200') {
            this.router.navigate(["/login"]);
            resolve(result.body);
          } else {
            reject();
          }
        });

      });
    }

    public hasSession(): boolean {

      if (!this.isEventTimeOver() ){
          if (Utils.getSecureStorage("USER_INFO")){
            return true;
          } else{
            return false;
          }
      } else {
        return false;
      }
    }

    public isEventTimeOver(time?: number): boolean {
      //const util = new Util();
      const lastEventTime = Number(Utils.getSecureStorage("lastEventTime"));

      if (lastEventTime) {
        return new Date().getTime() - lastEventTime > (time || environment.autoLogoutTime);
      } else {
        // throw new Error("'lastEventTime' is not defined.");
        return false;
      }
    }

    showErrMsg(msgKey: string, value?: any){
      let message = '';
      switch(msgKey) {
        case 'invalidUserName':
          message = this.translate.instant('serverResponseCode.label.serverError');
          break;
        case '500':
          message = this.translate.instant('serverResponseCode.label.serverError');
          break;
        default:
          message = this.translate.instant('serverResponseCode.label.unknown');
          break;
      }
      this.toastr.error(message, this.translate.instant('common.label.error'),{
        timeOut: 5000,
      });
    }

}

export interface BasicAuth {
  User_name: string;
  password: string;
}

export interface AuthentcatiionRequest {
  grant_type?: string;
  user_name: string;
  password: string;
  client_id?: string;
}
