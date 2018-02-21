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
  user: User;

  constructor(private httpService: HttpserviceService) {
    this.user = new User;
  }

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

  addUser(){
    this.httpService.addUser(this.user).subscribe(
      user => this.findUsers())
      
  }
}