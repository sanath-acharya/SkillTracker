import { Ping } from './../model/ping';

import { HttpClient, HttpHeaders, HttpBackend } from '@angular/common/http';
import { Injectable,TemplateRef  } from '@angular/core';
import { Associate } from '../model/associate';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AddAssociateService {
  editModeltoupdate:Associate=new  Associate(0,"", "", "", "", null, "", "", "", "");
  // private httpClientBackend: HttpClient;
  constructor(private http:HttpClient,private route:Router,
    private http1:HttpClient,
    private httpBackend:HttpBackend) { 

      // this.httpClientBackend = new HttpClient(httpBackend);
    }

  


  addAssociate(model){
    console.log(model);
    console.log("inside service");

    return this.http.post("/api/saveAssociate",model);
  }
  // getAssociatefeing():Observable<Associate[]>{

  //   this.http1=new HttpClient(this.httpBackend)
   
  //   return this.http1.get<Associate[]>("/api/associate/all");
  // }

  getAssociatefeign():Observable<Associate[]>{
    // var currentUser={token:""};
    // var header=new HttpHeaders();
    // header=header.set("Authorization","Bearer");
    // if(sessionStorage.currentUser!=null){
    //   currentUser=JSON.parse(sessionStorage.currentUser);
    //   header=header.set("Authorization","Bearer"+currentUser.token);
    // }
    return this.http.get<Associate[]>("http://localhost:9999/allAssociate");
  }

  getAssociate():Observable<Associate[]>{
  //   // var currentUser={token:""};
  //   // var header=new HttpHeaders();
  //   // header=header.set("Authorization","Bearer");
  //   // if(sessionStorage.currentUser!=null){
  //   //   currentUser=JSON.parse(sessionStorage.currentUser);
  //   //   header=header.set("Authorization","Bearer"+currentUser.token);
  //   // }
  return this.http.get<Associate[]>("/api/associate/all");
   }


  getAssociatebyId(aid:number){
    return this.http.get<Associate>("/api/associate/"+aid);
  }

  searchbyfirstname(searchtext:string):Observable<Associate[]>{
    
    return this.http.get<Associate[]>("/api/name/"+searchtext);
  }
  
  searchbylastname(searchtext:string):Observable<Associate[]>{
    
    return this.http.get<Associate[]>("/api/AssociateLastName/"+searchtext);
  }
 
  
  searchbyemail(searchtext:string):Observable<Associate[]>{
    
    return this.http.get<Associate[]>("/api/AssociateEmail/"+searchtext);
  }
  searchbymobile(searchtext:string):Observable<Associate[]>{
    
    return this.http.get<Associate[]>("/api/AssociateMobile/"+searchtext);
  }
 
 

  updateAssociate(editModel:Associate){
    this.editModeltoupdate=editModel;
    

    this.route.navigate(["/editAssociate"]);

    // return this.http.put<Associate>("/api/",tochangemodel);
  }
  updateAfterEdit(model:Associate):Observable<any>{

    console.log(model)
    console.log("this is tob be edited");
    return this.http.put<any>("/api/updateAssociate",model);
   


  }
  deletebyId(email:string)
  {
    
    console.log("tis. is service");
    console.log(email);
      return this.http.delete("/api/deleteAssociate/"+email);
      console.log("after. is service")
  }
  getModalofEdit():Associate{
    return this.editModeltoupdate;
  }
  ping(email:Ping){
    console.log(email)
    return this.http.post<any>("http://localhost:5724/send-mail",email)
  }
}
