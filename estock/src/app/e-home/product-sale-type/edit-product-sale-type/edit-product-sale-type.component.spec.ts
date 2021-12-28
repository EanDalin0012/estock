import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProductSaleTypeComponent } from './edit-product-sale-type.component';

describe('EditProductSaleTypeComponent', () => {
  let component: EditProductSaleTypeComponent;
  let fixture: ComponentFixture<EditProductSaleTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditProductSaleTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditProductSaleTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
