export class UserWithToken {

    public accessToken: string;
    public expiresIn: number;
    public userId: number;
    public expirationDate: Date;

    constructor(accessToken: string, expiresIn: number, userId: number) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.userId = userId;
        this.expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
    }

    get getToken() {
        if(!this.expirationDate || new Date() > this.expirationDate) {
            return null;
        }

        return this.accessToken;
    }
}