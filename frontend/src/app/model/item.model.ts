export class Item{
    id:number;
    name:string;
    price:number;
    subcategory: string;
    description: string;
    priority: number;
    itemStatus: string;
    slika: string;

    constructor(id:number ,name:string, price:number,subcategory: string, description: string,
        priority: number, itemStatus: string, slika: string) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.subcategory = subcategory;
        this.description = description;
        this.priority = priority;
        this.itemStatus = itemStatus;
        this.slika = slika;

    }
}