import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionCollaborateurComponent } from './gestion-collaborateur.component';

describe('AdminCollaborateurComponent', () => {
  let component: GestionCollaborateurComponent;
  let fixture: ComponentFixture<GestionCollaborateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionCollaborateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionCollaborateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
