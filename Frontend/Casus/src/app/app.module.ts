import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { UserComponent } from './components/user/user.component';
import { UsersComponent } from './components/users/users.component';

import { HttpserviceService } from './services/httpservice.service';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    
  ],
  providers: [ HttpserviceService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
