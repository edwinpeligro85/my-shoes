import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SerchResultsComponent } from './serch-results.component';

describe('SerchResultsComponent', () => {
  let component: SerchResultsComponent;
  let fixture: ComponentFixture<SerchResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SerchResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SerchResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
