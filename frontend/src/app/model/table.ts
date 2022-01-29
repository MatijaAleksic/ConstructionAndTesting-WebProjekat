import { Order } from "./order";

export class Table {

    public id: number;
    public floor : number;
    public position: {x: number,y: number};
    public state : any;
    public orders : Order[];
    

    constructor(floor : number, state : any ){
        this.floor = floor;
        this.state = state;
        this.position = {x: 20, y:20}
        
    }
}