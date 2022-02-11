import { Component, NgZone, OnInit } from '@angular/core';

@Component({
  selector: 'app-e-type',
  templateUrl: './e-type.component.html',
  styleUrls: ['./e-type.component.css']
})
export class ETypeComponent implements OnInit {


  public innerHeight: any;
  getScreenHeight() {
    this.innerHeight = window.innerHeight + 'px';
  }

  constructor(private ngZone: NgZone) {
    window.onresize = (e) => {
      this.ngZone.run(() => {
        this.innerHeight = window.innerHeight + 'px';
      });
    };
    this.getScreenHeight();
  }

  ngOnInit(): void {
    console.log();
  }

  onResize(event: any) {
    this.innerHeight = event.target.innerHeight + 'px';
  }

}
