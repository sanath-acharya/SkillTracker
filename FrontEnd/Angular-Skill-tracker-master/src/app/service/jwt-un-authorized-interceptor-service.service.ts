import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JwtUnAuthorizedInterceptorServiceService implements HttpInterceptor {
  intercept(request:HttpRequest<any>,next:HttpHandler):Observable<HttpEvent<any>>{
    return next.handle(request).pipe(tap(
      (event:HttpEvent<any>)=>{
        if(event instanceof HttpResponse){

        }
      },
      (error:any)=>{
        if(error.status==504)
        {
          console.log(error);
          alert("504 error unauthorized");
        }if(error.status==500)
        {
          console.log(error);
          alert("500 error unauthorized");
        }if(error.status==404)
        {
          console.log(error);
          alert("404 error page not found");
        }if(error.status==501)
        {
          console.log(error);
          alert("501 server side  error");
        }
      }
    ));
  }
  constructor() { }
}
