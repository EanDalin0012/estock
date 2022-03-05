import { Role } from './../../e-share/data/role';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { DataService } from 'src/app/e-share/service/data.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-new-role',
  templateUrl: './new-role.component.html',
  styleUrls: ['./new-role.component.css']
})
export class NewRoleComponent implements OnInit {

  role!: Role;
  constructor(
    private dataService: DataService,
    private titleService: Title,
    private router: Router
  ) {
    const url = (window.location.href).split('/');
    console.log(url)
    this.dataService.visitParamRouterChange(url[4]);
    this.titleService.setTitle('Employee Request');

    this.role = {} as Role;
  }

  ngOnInit(): void {
  }

  btnRole(){
    this.router.navigate(['/user/role']);
  }

  btnSave(form: NgForm) {
    console.log(this.role);

    if (form.invalid) {
      for (const control of Object.keys(form.controls)) {
        form.controls[control].markAsTouched();
      }
      return;
    }
  }

}
