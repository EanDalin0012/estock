import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-leave-employee',
  templateUrl: './leave-employee.component.html',
  styleUrls: ['./leave-employee.component.css']
})
export class LeaveEmployeeComponent implements OnInit {
  isSubmitted = false;
  constructor(public fb: FormBuilder) { }

  /*########### Form ###########*/
  registrationForm = this.fb.group({
    gender: ['male', [Validators.required]]
  })

  ngOnInit(): void {
  }

  // Submit Registration Form
  onSubmit() {
    this.isSubmitted = true;
    if(!this.registrationForm.valid) {
      return false;
    } else {
      alert(JSON.stringify(this.registrationForm.value))
    }
    return true;
  }

}
