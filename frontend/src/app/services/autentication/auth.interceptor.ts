import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { AuthentitacionService } from '../autentication/authentitacion.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor(private auth: AuthentitacionService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler) : Observable<HttpEvent<any>>{

    // Get the auth token from the service.
    const authToken = this.auth.getAuthorizationToken();

    if(authToken){  
        const authReq = req.clone({
            headers: req.headers.set('Authorization', 'Bearer ' + authToken)
          });
        return next.handle(authReq);
    }
    else{
        return next.handle(req);
    }

    
  }
}