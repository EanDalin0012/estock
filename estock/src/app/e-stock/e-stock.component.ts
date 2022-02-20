import { Component, NgZone, OnInit } from '@angular/core';

@Component({
  selector: 'app-e-stock',
  templateUrl: './e-stock.component.html',
  styleUrls: ['./e-stock.component.css']
})
export class EStockComponent implements OnInit {

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
