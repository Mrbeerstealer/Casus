import { UserEvent } from "./UserEvent";

export class User {
    id:number;
    name:string;
    lastName:string;
    userEventList:UserEvent[];
    xCoordinate:number;
    yCoordinate:number; 
    admin:boolean;
}