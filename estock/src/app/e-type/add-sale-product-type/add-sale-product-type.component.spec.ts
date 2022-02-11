import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSaleProductTypeComponent } from './add-sale-product-type.component';

describe('AddSaleProductTypeComponent', () => {
  let component: AddSaleProductTypeComponent;
  let fixture: ComponentFixture<AddSaleProductTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSaleProductTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSaleProductTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
