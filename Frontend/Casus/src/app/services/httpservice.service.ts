import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/User';
import { Ev } from '../models/Ev';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class HttpserviceService {

  constructor(private http:HttpClient) {
    console.log('Data service connected...');
  }

  // const httpOptions = {
  //   headers: new HttpHeaders({
  //     'Content-Type': 'application/json',
  //     'Authorization': 'my-auth-token'

  //   })
  // };

  addUser(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/user/new', user);
  }

  addEvent(ev: Ev): Observable<Ev> {
    return this.http.post<Ev>('http://localhost:8080/event/new', ev);
  }

  getUser(userId) : Observable<User> {
    return this.http.get<User>('http://localhost:8080/user/'+ userId+ '/find', { params: { "userId": userId }} );
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/user/s/find' );
  }

  getEvent(eventId) : Observable<Ev> {
    return this.http.get<Ev>('http://localhost:8080/event/' + eventId+ '/find', {params: {"eventId": eventId}});
  }

  getEvents(): Observable<Ev[]> {
    return this.http.get<Ev[]>('http://localhost:8080/event/s/find' );
  }

  getEventTypes(): Observable<string[]> {
    return this.http.get<string[]>('http://localhost:8080/eventTypes/all' );
  }
}

