import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProductSaleTypeComponent } from './create-product-sale-type.component';

describe('CreateProductSaleTypeComponent', () => {
  let component: CreateProductSaleTypeComponent;
  let fixture: ComponentFixture<CreateProductSaleTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateProductSaleTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateProductSaleTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
