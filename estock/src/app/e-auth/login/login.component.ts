import { TokenInfo } from './../../e-share/data/token.info';
import { LoadUser } from './../../e-share/data/request/load.user';
import { HTTPService } from './../../e-share/service/http.service';
import { Credentails } from './../../e-share/data/credentail';
import { UserAuthorizationServer } from './../../e-share/data/user.authorization.code';
import { LOCAL_STORAGE } from './../../e-share/constants/common.const';
import { Utils } from 'src/app/e-share/util/utils.static';
import { Component, ElementRef, OnInit, ViewChild, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, AbstractControl, NgForm } from '@angular/forms';
import { AuthentcatiionService } from 'src/app/e-share/service/authentcatiion.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentails!: Credentails;
  loadUser!: LoadUser;
  tokenInfo!: TokenInfo;

  isFirstLogin = false;
  userAuthorizationServer: UserAuthorizationServer[] = [];
  constructor(
    private authentcatiionService: AuthentcatiionService,
    private router: Router,
    private zone: NgZone,
    private httpServer: HTTPService
    ) {
      this.credentails = {} as Credentails;
      this.loadUser = {} as LoadUser;
      this.tokenInfo = {} as TokenInfo;
    }

  ngOnInit(): void {
    this.credentails.userName = 'admin';
    this.credentails.password = 'admin1234';
  }

  routors() {
    this.router.navigate(['/acc']);
  }


  public btnLogin(form: NgForm): void {
    console.log(form.form.value, form.invalid);

    if (form.invalid) {
      for (const control of Object.keys(form.controls)) {
        form.controls[control].markAsTouched();
      }
      return;
    } else {
      this.authentcatiionService.login(this.credentails).then(resp => {
        console.log('resp', resp);
        this.tokenInfo = resp;
        if(this.tokenInfo) {
          this.loadUser.userName = this.credentails.userName;
          this.authentcatiionService.loadUserByUserName(this.loadUser, this.tokenInfo).then(response=> {
            console.log('response', response);

          });
          this.userAuthorizationServer = [
            {
              id: 1,
              userAuthorizationCode: 'SALE'
            },
            {
              id: 2,
              userAuthorizationCode: 'READ_USER'
            },
            {
              id: 3,
              userAuthorizationCode: 'ADD_USER'
            },
            {
              id: 4,
              userAuthorizationCode: 'EDIT_USER'
            },
            {
              id: 5,
              userAuthorizationCode: 'READ_ROLE'
            },
            {
              id: 6,
              userAuthorizationCode: 'ADD_ROLE'
            },
            {
              id: 6,
              userAuthorizationCode: 'EDIT_ROLE'
            }
          ];
          Utils.setSecureStorage(LOCAL_STORAGE.CONSTANT_AUTHORITY, this.userAuthorizationServer);
          // this.zone.run(() =>  this.router.navigate(['/dashboard'], { replaceUrl: true }));
          // if(resp.result === false) {
          //   this.isValidLoading = false;
          // } else {
          //   this.isFirstLogin = resp.isFirstLogin;
          //   if(this.isFirstLogin == true) {
          //     this.zone.run(() =>  this.router.navigate(['/home/product'], { replaceUrl: true }));
          //   } else {
          //     this.zone.run(() =>  this.router.navigate(['/home/product'], { replaceUrl: true }));
          //   }
          // }

        }
      }).catch((err: any) => {
          console.log(err);
      });
    }
  }

}



function MustMatch(arg0: string, arg1: string): any {
  throw new Error('Function not implemented.');
}

