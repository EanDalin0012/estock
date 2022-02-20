import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportDtComponent } from './import-dt.component';

describe('ImportDtComponent', () => {
  let component: ImportDtComponent;
  let fixture: ComponentFixture<ImportDtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImportDtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportDtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
