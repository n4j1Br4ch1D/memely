import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContactService } from 'src/app/_services/contact.service';

@Component({
  selector: 'app-my-contacts',
  templateUrl: './my-contacts.component.html',
  styleUrls: ['./my-contacts.component.scss']
})
export class MyContactsComponent implements OnInit {
  currentProfileId: any;
  contacts:any = [];
  constructor(private contactService:ContactService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.contactService.getUserContacts(this.currentProfileId).subscribe(data=>{
      this.contacts = data;
    })
  }
}
