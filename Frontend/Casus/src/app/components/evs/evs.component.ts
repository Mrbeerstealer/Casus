import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../../services/httpservice.service';
import { Ev } from '../../models/ev';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events: Ev[];
  ev: Ev;
  eventTypes: string[];

  constructor(private httpService: HttpserviceService ) {
    this.ev = new Ev;
  }

  ngOnInit() {
    this.findEvents()
    this.findEventTypes()
  }

  findEvents() {
    this.httpService.getEvents().subscribe(
      data => { 
        console.log(data);
        this.events = data;
        console.log(this.events); },
      err => console.log(err),
      () => console.log('request done')
    );
  }

  findEventTypes() {
    this.httpService.getEventTypes().subscribe(
      data => { 
        console.log(data);
        this.eventTypes = data;
        console.log(this.eventTypes); },
      err => console.log(err),
      () => console.log('request done')
    );
  }

  addEvent(){
    this.httpService.addEvent(this.ev).subscribe(
      ev => this.findEvents())
      
  }
}
