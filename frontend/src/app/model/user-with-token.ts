import { Authority } from "./autority";

export class UserWithToken {

    public accessToken: string;
    public expiresIn: number;
    public userId: number;
    public expirationDate: Date;
    public authorities : Array<Authority>;

    constructor(accessToken: string, expiresIn: number, userId: number, authorities : Array<Authority>) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.userId = userId;
        this.authorities = authorities;
        this.expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
    }

    get getToken() {
        if(!this.expirationDate || new Date() > this.expirationDate) {
            return null;
        }

        return this.accessToken;
    }
}