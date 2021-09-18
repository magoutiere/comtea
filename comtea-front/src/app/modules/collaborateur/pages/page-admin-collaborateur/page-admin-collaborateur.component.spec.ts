import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageAdminCollaborateurComponent } from './page-admin-collaborateur.component';

describe('AdminCollaborateurComponent', () => {
  let component: PageAdminCollaborateurComponent;
  let fixture: ComponentFixture<PageAdminCollaborateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageAdminCollaborateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageAdminCollaborateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
