import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewImportComponent } from './new-import.component';

describe('NewImportComponent', () => {
  let component: NewImportComponent;
  let fixture: ComponentFixture<NewImportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewImportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewImportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
