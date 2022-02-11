import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EReportComponent } from './e-report.component';

describe('EReportComponent', () => {
  let component: EReportComponent;
  let fixture: ComponentFixture<EReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
