import { UserAuthorizationServer } from './../../e-share/data/user.authorization.code';
import { LOCAL_STORAGE } from './../../e-share/constants/common.const';
import { Utils } from 'src/app/e-share/util/utils.static';
import { Component, ElementRef, OnInit, ViewChild, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { AuthentcatiionService } from 'src/app/e-share/service/authentcatiion.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userName!: string;
  password!: string;

  registerForm!: FormGroup;
  submitted = false;

  @ViewChild("userName") inputUserName: any;
  @ViewChild("password") inputPassword: any;
  isFirstLogin = false;

  public formLogin: any;
  isValidLoading = false;
  userAuthorizationServer: UserAuthorizationServer[] = [];
  constructor(
    // private dataService: DataService,
    private authentcatiionService: AuthentcatiionService,
    private router: Router,
    private formBuilder: FormBuilder,
    private zone: NgZone,
    ) {
      this.formLogin as FormGroup;
      this.inputUserName as ElementRef;
      this.inputPassword as ElementRef;

      this.formLogin = this.formBuilder.group({
        userName: ['', Validators.required],
        password: ['', Validators.required]
      });
    }

  ngOnInit(): void {
    // this.formLogin.patchValue({
    //   userName: 'admin@gmail.com',
    //   password: 'admin123'
    // });

    this.registerForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
  });
  this.userName = 'admin';
  this.password = 'admin1234';
  }

  routors() {
    this.router.navigate(['/acc']);
  }

  isEmpty(value: string) {
    switch (value) {
      case 'u':
        this.formLogin.patchValue({
          userName: '',
        });
        break;
      case 'p':
        this.formLogin.patchValue({
          password: '',
        });
        break;
    }
  }

  onLogin() {
    this.submitted = true;
    if(this.userName && this.password) {
      const logInfo = {
        user_name: this.userName,
        password: this.password
      };
      this.authentcatiionService.login(logInfo).then((resp: any) => {
        if(resp) {
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
          this.zone.run(() =>  this.router.navigate(['/dashboard'], { replaceUrl: true }));
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


  changePassword(item: any) {
    // this.modalService.open(
    //   ChangePasswordComponent,
    //   {
    //     message: item,
    //     callback: _response => {

    //   }
    // });
  }

   // convenience getter for easy access to form fields
   get f() { return this.registerForm.controls; }

}



function MustMatch(arg0: string, arg1: string): any {
  throw new Error('Function not implemented.');
}

