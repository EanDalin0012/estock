import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductSaleTypeComponent } from './product-sale-type.component';

describe('ProductSaleTypeComponent', () => {
  let component: ProductSaleTypeComponent;
  let fixture: ComponentFixture<ProductSaleTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductSaleTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductSaleTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
