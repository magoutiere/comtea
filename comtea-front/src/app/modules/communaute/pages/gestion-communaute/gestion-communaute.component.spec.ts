import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionCommunauteComponent } from './gestion-communaute.component';

describe('PageAdminCommunauteComponent', () => {
  let component: GestionCommunauteComponent;
  let fixture: ComponentFixture<GestionCommunauteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionCommunauteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionCommunauteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
