import { Injectable } from '@angular/core';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private token: any | null;
  private pacijentID: any | null;

  constructor(private router: Router) { }

  public logoutUser() {
    this.token = null;
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  public setToken(token: any) {
    this.token = token['token'];
    localStorage.setItem('token', this.token);
  }

  public setPacijentID(token: any) {
    this.pacijentID = token['pacijentID'];
    localStorage.setItem('pacijentID', String(this.pacijentID));
  }

  public getPacijentID() {
    this.pacijentID = Number(localStorage.getItem('pacijentID'));
    console.log('AuthService: pacijentID --  ' + this.pacijentID);
    return this.pacijentID;
  }

  public getToken(): any | null {
    this.token = localStorage.getItem('token');
    return this.token;
  }
}
