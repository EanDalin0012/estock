import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EWarehouseComponent } from './e-warehouse.component';

describe('EWarehouseComponent', () => {
  let component: EWarehouseComponent;
  let fixture: ComponentFixture<EWarehouseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EWarehouseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EWarehouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
