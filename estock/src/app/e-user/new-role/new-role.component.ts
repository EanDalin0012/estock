import { UserRoleRequest } from '../../e-share/data/request/user.role.request';
import { Role } from './../../e-share/data/role';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { DataService } from 'src/app/e-share/service/data.service';
import { NgForm } from '@angular/forms';
import { HTTPService } from 'src/app/e-share/service/http.service';

@Component({
  selector: 'app-new-role',
  templateUrl: './new-role.component.html',
  styleUrls: ['./new-role.component.css']
})
export class NewRoleComponent implements OnInit {

  authorizations: number[] =[];
  userRole!: UserRoleRequest;

  constructor(
    private dataService: DataService,
    private titleService: Title,
    private router: Router,
    private httpService: HTTPService
  ) {
    const url = (window.location.href).split('/');
    console.log(url)
    this.dataService.visitParamRouterChange(url[4]);
    this.titleService.setTitle('Employee Request');

    this.userRole = {} as UserRoleRequest;
  }

  ngOnInit(): void {
  }

  btnRole(){
    this.router.navigate(['/user/role']);
  }

  btnSave(form: NgForm) {
    if (form.invalid) {
      for (const control of Object.keys(form.controls)) {
        form.controls[control].markAsTouched();
      }
      return;
    } else {
      this.userRole.authorities = this.authorizations;
      console.log(this.userRole);

      // this.httpService.Post('/api/user-role/save', {}).then(response => {
      //   console.log('response', response);

      // });
    }
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

    console.log(this.authorizations);

    // this.authorizations.push(authorizationId);
    // console.log(event, event.target.checked);
    // if(this.authorizations.length > 0) {
    //   this.authorizations.forEach((element, index) => {
    //     console.log(element, this.authorizations.splice(index));

    //   });

    // }
    // console.log('authorizations', this.authorizations);

  }

}
