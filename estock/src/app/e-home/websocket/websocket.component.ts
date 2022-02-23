import { Component, OnInit } from '@angular/core';
// import * as Stomp from 'stompjs';
// import * as SockJS from 'sockjs-client';
import { Utils } from 'src/app/e-share/util/utils.static';
import { LOCAL_STORAGE } from 'src/app/e-share/constants/common.const';

@Component({
  selector: 'app-websocket',
  templateUrl: './websocket.component.html',
  styleUrls: ['./websocket.component.css']
})
export class WebsocketComponent implements OnInit {

  greetings: string[] = [];
  showConversation: boolean = false;
  ws: any;
  name: string = '';
  disabled: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  connect() {
    //connect to stomp where stomp endpoint is exposed
    // let ws = new SockJS('http://localhost:8080/greeting');
    // this.ws = Stomp.over(ws);
    // let that = this;

    // const authorization = Utils.getSecureStorage(LOCAL_STORAGE.Authorization);
    // const access_token = authorization.access_token;
    // this.ws.connect({"Authorization": "Bearer " + access_token}, function(frame:any) {
    //   that.ws.subscribe("/errors", function(message:any) {
    //     alert("Error " + message.body);
    //   });
    //   that.ws.subscribe("/topic/reply", function(message:any) {
    //     console.log(message)
    //     that.showGreeting(message.body);
    //   });
    //   that.disabled = true;
    // }, function(error:any) {
    //   alert("STOMP error " + error);
    // });
  }

  disconnect() {
    if (this.ws != null) {
      this.ws.ws.close();
    }
    this.setConnected(false);
    console.log("Disconnected");
  }

  sendName() {
    let data = JSON.stringify({
      'name' : this.name
    })
    this.ws.send("/app/message", {}, data);
  }

  showGreeting(message:any) {
    this.showConversation = true;
    this.greetings.push(message)
  }

  setConnected(connected:any) {
    this.disabled = connected;
    this.showConversation = connected;
    this.greetings = [];
  }
}
