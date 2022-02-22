import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { IDateAngularComp } from 'ag-grid-angular';
import { IDateParams } from 'ag-grid-community';
// we'll be using the globally provided flatpickr for our example
declare var flatpickr: any;
@Component({
  selector: 'app-custom-date-filter',
  templateUrl: './custom-date-filter.component.html',
  styleUrls: ['./custom-date-filter.component.css']
})
export class CustomDateFilterComponent implements OnInit, IDateAngularComp  {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  @ViewChild('flatpickrEl', { read: ElementRef }) flatpickrEl!: ElementRef;
  @ViewChild('eInput', { read: ElementRef }) eInput!: ElementRef;
  private date!: Date;
  private params!: IDateParams;
  private picker: any;

  agInit(params: IDateParams): void {
    this.params = params;
  }

  ngAfterViewInit(): void {
    this.picker = flatpickr(this.flatpickrEl.nativeElement, {
      onChange: this.onDateChanged.bind(this),
      wrap: true,
    });

    this.picker.calendarContainer.classList.add('ag-custom-component-popup');
  }

  ngOnDestroy() {
    console.log(`Destroying DateComponent`);
  }

  onDateChanged(selectedDates: any) {
    this.date = selectedDates[0] || null;
    this.params.onDateChanged();
  }

  getDate(): Date {
    return this.date;
  }

  setDate(date: Date): void {
    this.date = date || null;
    this.picker.setDate(date);
  }

  setInputPlaceholder(placeholder: string): void {
    this.eInput.nativeElement.setAttribute('placeholder', placeholder);
  }

  setInputAriaLabel(label: string): void {
    this.eInput.nativeElement.setAttribute('aria-label', label);
  }

}
