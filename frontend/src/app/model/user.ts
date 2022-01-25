export class User {

    public username: string;
    public password: string;
    public firstName: string;
    public lastName: string;
    public dateOfBirth: Date;
    public salary: number;


    constructor(username: string, password: string, firstName: string, lastName: string, dateOfBirth: Date, salary: number) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }
}