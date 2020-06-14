import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {PacijentService} from "../../services/pacijent.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  userIsLoggedIn: boolean;

  constructor(private auth: AuthService) { }

  ngOnInit(): void {
    this.userIsLoggedIn = false;

    if (this.auth.getToken() != null) {
      this.userIsLoggedIn = true;
    }
  }

  logout() {
    this.auth.logoutUser();
  }

}
