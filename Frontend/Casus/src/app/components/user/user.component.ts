import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../../services/httpservice.service';
import { User } from '../../models/User';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User;

  constructor(private httpService: HttpserviceService) {
    this.user = new User();
  }

  ngOnInit() {
    this.findUser(1);
  }

  findUser(userId) {
    this.httpService.getUser(userId).subscribe(
      data => {
        this.user = data;
        console.log(data);
        console.log(this.user);
      },
      err => console.log(err),
      () => console.log('request done')
    );
  }

}