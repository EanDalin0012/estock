import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EEmployeeComponent } from './e-employee.component';

describe('EEmployeeComponent', () => {
  let component: EEmployeeComponent;
  let fixture: ComponentFixture<EEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
