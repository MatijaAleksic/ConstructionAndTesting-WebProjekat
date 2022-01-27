import { Authority } from "./autority";

export class UserAuth {

    public id : number;
    public username: string;
    public password: string;
    public firstName: string;
    public lastName: string;
    public dateOfBirth: string;
    public salary: number;
    public authorities : Array<Authority>;

    constructor(id : number,username: string, password: string, firstName: string, lastName: string, dateOfBirth: string, salary: number, authorities : Array<Authority>) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.authorities = authorities;
    }

}