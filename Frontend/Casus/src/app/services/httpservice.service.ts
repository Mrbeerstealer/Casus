import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/User';

@Injectable()
export class HttpserviceService {

  constructor(private http:HttpClient) {
    console.log('Data service connected...');
   }

  getUser(userId) : Observable<User> {
    return this.http.get<User>('http://localhost:8080/user/'+ userId+ '/find', { params: { "userId": userId }} );
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/user/s/find' );
  }

}

