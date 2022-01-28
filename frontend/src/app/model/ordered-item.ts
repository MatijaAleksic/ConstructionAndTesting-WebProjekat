import { Item } from "./item.model";

export class OrderedItem {

    public id: number;
    public price : number;
    public number : number;
    public state : any;
    public item : Item;
    public staff : any;
    public note : string;
    public dateTime : Date;

    constructor(price : number, number : number, state : any, item : Item, staff : any, note : string){
        this.price = price;
        this.number = number;
        this.state = state;
        this.item = item;
        this.staff = staff;
        this.note = note;
    }
    
}
