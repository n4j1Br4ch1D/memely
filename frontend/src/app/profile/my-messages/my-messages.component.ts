import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ChatService } from 'src/app/_services/chat.service';
import { StorageService } from 'src/app/_services/storage.service';

@Component({
  selector: 'app-my-messages',
  templateUrl: './my-messages.component.html',
  styleUrls: ['./my-messages.component.scss'],
})
export class MyMessagesComponent implements OnInit {
  userId: any;
  friendId: any;
  messages: any = [];
  friends: any = [];
  constructor(
    private storageService: StorageService,
    private chatService: ChatService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {

    this.userId = this.storageService.getUser()['id'];
    this.friendId = 2;
    this.chatService
      .getUserMessages(this.userId, this.friendId)
      .subscribe((data) => {
        this.messages = data;
      });
    this.chatService
      .getUserMessagesFriends(this.userId)
      .subscribe((data) => {
        this.friends = data;
      });
  }
}
