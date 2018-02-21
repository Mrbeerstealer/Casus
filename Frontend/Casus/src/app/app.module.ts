import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

import { UserComponent } from './components/user/user.component';
import { UsersComponent } from './components/users/users.component';
import { EventComponent } from './components/ev/ev.component';
import { EventsComponent } from './components/evs/evs.component';

import { HttpserviceService } from './services/httpservice.service';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UsersComponent,
    EventComponent,
    EventsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [ HttpserviceService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
