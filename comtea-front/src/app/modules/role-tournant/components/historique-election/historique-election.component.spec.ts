import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoriqueElectionComponent } from './historique-election.component';

describe('HistoriqueElectionComponent', () => {
  let component: HistoriqueElectionComponent;
  let fixture: ComponentFixture<HistoriqueElectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoriqueElectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoriqueElectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
