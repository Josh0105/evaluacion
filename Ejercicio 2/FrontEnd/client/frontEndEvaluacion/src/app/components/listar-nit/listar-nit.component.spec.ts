import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarNitComponent } from './listar-nit.component';

describe('ListarNitComponent', () => {
  let component: ListarNitComponent;
  let fixture: ComponentFixture<ListarNitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarNitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarNitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
