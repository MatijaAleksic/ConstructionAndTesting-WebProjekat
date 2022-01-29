export class ItemConstruct{
    id:number;
    name:string;
    price:number;
    subcategory: string;
    description: string;
    priority: number;
    picture: string;

    constructor(name:string, price:number, subcategory: string, description: string,  priority: number,
        picture: string) {
        this.name = name;
        this.price = price;
        this.subcategory = subcategory;
        this.description = description;
        this.priority = priority;
        this.picture = picture;
        
    }
}