import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-employee',
  templateUrl: './form-employee.component.html',
  styleUrls: ['./form-employee.component.css']
})
export class FormEmployeeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onClickOT() {
    this.router.navigate(['/employee-request/ot-form']);
  }

}
