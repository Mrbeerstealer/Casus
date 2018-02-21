import { UserEvent } from "./UserEvent";

export class Ev { 
    id:number;
    name:string;
    description:string;
    eventType:string;
    xCoordinate:number;
    yCoordinate:number; 
    userEventList:UserEvent[];
    privateStatus: boolean;
    date: Date;
  }