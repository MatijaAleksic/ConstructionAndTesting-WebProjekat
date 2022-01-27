export class Item{
    id:number;
    name:string;
    price:number;
    subcategory: string;
    description: string;
    priority: number;
    itemStatus: string;
    picture: string;
    number: number;

    constructor(item: Item) {
        this.convert(item);
    }
    

    convert(item: Item){
        this.id = item.id;
        this.name = item.name;
        this.price = item.price;
        this.subcategory = item.subcategory;
        this.description = item.description;
        this.priority = item.priority;
        this.itemStatus = item.itemStatus;
        this.picture = item.picture;
        this.number = 0;
    }


    


}