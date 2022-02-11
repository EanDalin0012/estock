import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EProductComponent } from './e-product.component';

describe('EProductComponent', () => {
  let component: EProductComponent;
  let fixture: ComponentFixture<EProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
