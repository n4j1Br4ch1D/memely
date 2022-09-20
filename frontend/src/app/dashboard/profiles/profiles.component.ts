import { DecimalPipe } from '@angular/common';
import {
  Component,
  OnInit,
  Type,
  QueryList,
  ViewChildren,
  Input,
} from '@angular/core';
import { Observable } from 'rxjs';

import { Profile } from '../../_models/profile';
import { ProfileService } from './profiles.service';
import { NgbdSortableHeader, SortEvent } from './sortable.directive';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'ngbd-modal-confirm-autofocus',
  template: `
    <div class="modal-header">
      <h4 class="modal-title" id="modal-title">Profile deletion</h4>
      <button
        type="button"
        class="btn-close"
        aria-label="Close button"
        aria-describedby="modal-title"
        (click)="modal.dismiss('Cross click')"
      ></button>
    </div>
    <div class="modal-body">
      <p>
        <strong
          >Are you sure you want to delete
          <span class="text-primary">{{ profile.name }}</span> profile?</strong
        >
      </p>
      <p>
        All information associated to this user profile will be permanently
        deleted.
        <span class="text-danger">This operation can not be undone.</span>
      </p>
    </div>
    <div class="modal-footer">
      <button
        type="button"
        class="btn btn-outline-secondary"
        (click)="modal.dismiss('cancel click')"
      >
        Cancel
      </button>
      <button
        type="button"
        ngbAutofocus
        class="btn btn-danger"
        (click)="modal.close('Ok click')"
      >
        I Confirm
      </button>
    </div>
  `,
})
export class NgbdModalConfirmAutofocus implements OnInit {
  @Input() profile!: Profile;

  constructor(public modal: NgbActiveModal) {}

  ngOnInit() {}
}

const MODALS: { [name: string]: Type<any> } = {
  autofocus: NgbdModalConfirmAutofocus,
};

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.scss'],
  providers: [ProfileService, DecimalPipe],
})
export class ProfilesComponent implements OnInit {
  profiles$: Observable<Profile[]>;
  profile:Profile|null= null;
  total$: Observable<number>;

  @ViewChildren(NgbdSortableHeader)
  headers!: QueryList<NgbdSortableHeader>;

  constructor(public service: ProfileService, private _modalService: NgbModal) {
    this.profiles$ = service.profiles$;
    this.total$ = service.total$;
  }

  ngOnInit(): void {}

  delete(name: string, profile: Profile) {
    const modalRef = this._modalService.open(MODALS[name]);
    modalRef.componentInstance.profile = profile;
  }

  form(name: string, profile: Profile | null) {
  //  this.f.isCollapsed = false;
  this.profile = profile;

    // this.isCollapsed = this.isCollapsed;
    console.log(11110);
    
    // modalRef.componentInstance.profile = profile;
  }

  onSort({ column, direction }: SortEvent) {
    // resetting other headers
    this.headers.forEach((header) => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    this.service.sortColumn = column;
    this.service.sortDirection = direction;
  }

  public isCollapsed: boolean = true;
}
