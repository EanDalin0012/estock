import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EAuthComponent } from './e-auth.component';

describe('EAuthComponent', () => {
  let component: EAuthComponent;
  let fixture: ComponentFixture<EAuthComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EAuthComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EAuthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
