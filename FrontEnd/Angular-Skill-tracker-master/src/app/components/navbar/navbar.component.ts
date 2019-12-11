import { Component, OnInit, ElementRef } from '@angular/core';
import { ROUTES } from '../sidebar/sidebar.component';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { Router, NavigationEnd } from '@angular/router';
import { AddAssociateService } from 'src/app/service/add-associate.service';
import { Associate } from 'src/app/model/associate';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  public focus;
  public listTitles: any[];
  public location: Location;
  associate:Associate;
  type=""
  admin:string
  constructor(location: Location,  
    private element: ElementRef,
     private router: Router,
    private AssociateService:AddAssociateService) {

       
        router.events.subscribe(event => {
          if (event instanceof NavigationEnd) {
            this.ngOnInit();
          }
          // Instance of should be: 
          // NavigationEnd
          // NavigationCancel
          // NavigationError
          // RoutesRecognized
        });
      



    this.location = location;
  }

  ngOnInit() {
    this.listTitles = ROUTES.filter(listTitle => listTitle);
    this.type=sessionStorage.getItem('type');
    let id=sessionStorage.getItem("id")
    let iid=+id;
    console.log(this.type);
    if(this.type == "admin"){
      this.admin="admin"
      console.log("this is  admin")
    
    }else{
      console.log("this is lse block dosednt got to admin")
      this.AssociateService.getAssociatebyId(iid).subscribe(response=>{
console.log(response)
        this.associate= response;
      })
      this.admin="employee"
        // this.admin=this.associate.associateFirstName;
    }

  }
  

  logout(){
    sessionStorage.removeItem('type')
    sessionStorage.removeItem('currentUser')
    sessionStorage.removeItem('id')
    window.location.reload();
    this.router.navigate(['login'])
  }
  

}
