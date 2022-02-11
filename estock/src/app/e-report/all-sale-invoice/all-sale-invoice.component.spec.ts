import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllSaleInvoiceComponent } from './all-sale-invoice.component';

describe('AllSaleInvoiceComponent', () => {
  let component: AllSaleInvoiceComponent;
  let fixture: ComponentFixture<AllSaleInvoiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllSaleInvoiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllSaleInvoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
