import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoriqueRolesComponent } from './historique-roles.component';

describe('PageHistoriqueRolesComponent', () => {
  let component: HistoriqueRolesComponent;
  let fixture: ComponentFixture<HistoriqueRolesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoriqueRolesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoriqueRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
