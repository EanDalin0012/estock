import { Credentails } from './../e-share/data/credentail';
import { Component, ElementRef, OnInit, ViewChild, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-e-auth',
  templateUrl: './e-auth.component.html',
  styleUrls: ['./e-auth.component.css']
})
export class EAuthComponent implements OnInit {

  credentails!: Credentails;
  submitted = false;
  @ViewChild("userName") inputUserName: any;
  @ViewChild("password") inputPassword: any;
  isFirstLogin = false;

  public formLogin: any;
  isValidLoading = false;
  constructor(
    // private dataService: DataService,
    // private authentcatiionService: AuthentcatiionService,
    private router: Router,
    private formBuilder: FormBuilder,
    private zone: NgZone,
    ) {

      this.credentails = {} as Credentails;

      this.formLogin as FormGroup;
      this.inputUserName as ElementRef;
      this.inputPassword as ElementRef;

      this.formLogin = this.formBuilder.group({
        userName: ['', Validators.required],
        password: ['', Validators.required]
      });
    }

  ngOnInit(): void {
    this.formLogin.patchValue({
      userName: 'admin@gmail.com',
      password: 'admin123'
    });
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
    // if(this.f.userName.errors) {
    //   this.inputUserName.nativeElement.focus();
    // } else if (this.f.password.errors) {
    //   this.inputPassword.nativeElement.focus();
    // } else {
    //   this.isValidLoading = true;
    //   const formData = this.formLogin.getRawValue();
    //   const logInfo = {
    //     user_name: formData.userName,
    //     password: formData.password
    //   };
    //   this.authentcatiionService.login(logInfo).then((resp: any) => {
    //     if(resp) {
    //       if(resp.result === false) {
    //         this.isValidLoading = false;
    //       } else {
    //         this.isFirstLogin = resp.isFirstLogin;
    //         if(this.isFirstLogin == true) {
    //           this.zone.run(() =>  this.router.navigate(['/home'], { replaceUrl: true }));
    //         } else {
    //           this.zone.run(() =>  this.router.navigate(['/home'], { replaceUrl: true }));
    //         }
    //       }

    //     }
    //   }).catch((err: any) => {
    //       console.log(err);
    //   });
    // }
    // }
  }

  get f(): { [key: string]: AbstractControl } {
    return this.formLogin.controls;
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

}
