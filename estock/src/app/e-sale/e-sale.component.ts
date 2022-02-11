import { Component, NgZone, OnInit } from '@angular/core';

@Component({
  selector: 'app-e-sale',
  templateUrl: './e-sale.component.html',
  styleUrls: ['./e-sale.component.css']
})
export class ESaleComponent implements OnInit {

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
