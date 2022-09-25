import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyMentionsComponent } from './my-mentions.component';

describe('MyMentionsComponent', () => {
  let component: MyMentionsComponent;
  let fixture: ComponentFixture<MyMentionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyMentionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyMentionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
