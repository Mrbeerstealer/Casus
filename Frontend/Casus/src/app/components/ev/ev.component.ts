import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../../services/httpservice.service';
import { Ev } from '../../models/Ev';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {
  ev: Ev;

  constructor(private httpService: HttpserviceService) {
    this.ev = new Ev();
  }

  ngOnInit() {
    this.findEvent(1);
  }

  findEvent(eventId) {
    this.httpService.getEvent(eventId).subscribe(
      data => {
        this.ev = data;
        console.log(data);
        console.log(this.ev);
      },
      err => console.log(err),
      () => console.log('request done')
    );
  }

}
