import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAjoutCollaborateurComponent } from './form-ajout-collaborateur.component';

describe('FormAjoutCollaborateurComponent', () => {
  let component: FormAjoutCollaborateurComponent;
  let fixture: ComponentFixture<FormAjoutCollaborateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAjoutCollaborateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAjoutCollaborateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
