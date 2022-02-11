import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OtEmployeeComponent } from './ot-employee.component';

describe('OtEmployeeComponent', () => {
  let component: OtEmployeeComponent;
  let fixture: ComponentFixture<OtEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OtEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OtEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
