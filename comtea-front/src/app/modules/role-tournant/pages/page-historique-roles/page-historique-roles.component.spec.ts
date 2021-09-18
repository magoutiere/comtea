import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageHistoriqueRolesComponent } from './page-historique-roles.component';

describe('PageHistoriqueRolesComponent', () => {
  let component: PageHistoriqueRolesComponent;
  let fixture: ComponentFixture<PageHistoriqueRolesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageHistoriqueRolesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageHistoriqueRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
