import { Injectable } from '@angular/core';
import { HttpHeaders ,HttpClient} from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Associates } from '../model/associates';

@Injectable({
  providedIn: 'root'
})
export class AssociateService {

  constructor(private http:HttpClient) { }
  getAllAssociates(){
    var currentUser={token:" "};
    var headers=new HttpHeaders();
    headers=headers.set("Authorization","Bearer");
    if(sessionStorage.currentUser!=null){
      currentUser=JSON.parse(sessionStorage.currentUser);
      headers=headers.set("Authorization","Bearer"+currentUser.token);

    }
    return this.http.get<Associates[]>("/api/associate/all",{headers:headers,responseType:"json"})
    .pipe(map(
      (data:Associates[])=>{
        return data;
      }
    ))
  }

  

}
