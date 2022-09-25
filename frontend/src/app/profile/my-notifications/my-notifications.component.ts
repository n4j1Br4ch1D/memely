import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NotificationService } from 'src/app/_services/notification.service';

@Component({
  selector: 'app-my-notifications',
  templateUrl: './my-notifications.component.html',
  styleUrls: ['./my-notifications.component.scss']
})
export class MyNotificationsComponent implements OnInit {
  currentProfileId: any;
  notifications:any = [];
  constructor(private notificationService:NotificationService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.notificationService.getuserNotifications(this.currentProfileId).subscribe(data=>{
      this.notifications = data;
    })
  }
}
