import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewMemeComponent } from './new-meme.component';

describe('NewMemeComponent', () => {
  let component: NewMemeComponent;
  let fixture: ComponentFixture<NewMemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewMemeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewMemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
