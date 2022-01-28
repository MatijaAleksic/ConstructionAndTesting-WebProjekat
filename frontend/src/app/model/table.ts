import { Order } from "./order";

export class Table {

    public id: number;
    public tableNumber : number;
    public floor : number;
    public positionX : number;
    public positionY : number;
    public state : any;
    public orders : Order[];
    

    constructor(tableNumber : number, floor : number, positionX : number, positionY : number, state : any ){
        this.tableNumber = tableNumber;
        this.floor = floor;
        this.positionX = positionX;
        this.positionY = positionY;
        this.state = state;
    }
}