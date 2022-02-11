import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ETypeComponent } from './e-type.component';

describe('ETypeComponent', () => {
  let component: ETypeComponent;
  let fixture: ComponentFixture<ETypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ETypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ETypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
