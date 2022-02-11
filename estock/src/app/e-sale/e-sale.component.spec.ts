import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ESaleComponent } from './e-sale.component';

describe('ESaleComponent', () => {
  let component: ESaleComponent;
  let fixture: ComponentFixture<ESaleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ESaleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ESaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
