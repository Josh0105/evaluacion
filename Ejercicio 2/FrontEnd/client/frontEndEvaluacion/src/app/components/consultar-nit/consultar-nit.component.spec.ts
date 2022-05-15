import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarNitComponent } from './consultar-nit.component';

describe('ConsultarNitComponent', () => {
  let component: ConsultarNitComponent;
  let fixture: ComponentFixture<ConsultarNitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultarNitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultarNitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
