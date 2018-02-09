import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../../services/httpservice.service';
import { User } from '../../models/User';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users : User[];
  constructor(private httpService: HttpserviceService) { }

  ngOnInit() {
    this.findUsers()
  }

  findUsers() {
    this.httpService.getUsers().subscribe(
      data => { 
        console.log(data);
        this.users = data;
        console.log(this.users); },
      err => console.log(err),
      () => console.log('request done')
    );
  }
}

// interface User {
//   id:number;
//   name:string;
//   lastName:string;
//   userEvent:UserEvent;
//   xCoordinate:number;
//   yCoordinate:number; 
//   admin:boolean;
// }

// interface UserEvent {
//   id:number;
//   event:Event;
//   doesAttend: string;
// }

// interface Event{
//   id:number;
//   name: string;
//   description: string;
// }