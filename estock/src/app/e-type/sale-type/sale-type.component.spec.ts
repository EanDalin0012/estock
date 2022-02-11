import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaleTypeComponent } from './sale-type.component';

describe('SaleTypeComponent', () => {
  let component: SaleTypeComponent;
  let fixture: ComponentFixture<SaleTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaleTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SaleTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
