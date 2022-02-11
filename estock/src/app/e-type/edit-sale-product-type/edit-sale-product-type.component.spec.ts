import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSaleProductTypeComponent } from './edit-sale-product-type.component';

describe('EditSaleProductTypeComponent', () => {
  let component: EditSaleProductTypeComponent;
  let fixture: ComponentFixture<EditSaleProductTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditSaleProductTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSaleProductTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
