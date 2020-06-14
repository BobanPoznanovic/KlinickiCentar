import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PacijentService} from '../../services/pacijent.service';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {Pacijent} from '../../model/pacijent';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  pacijent: Pacijent;
  ulogovanPacijent: Observable<Pacijent>;
  pacijentPom: Pacijent;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private pacijentService: PacijentService,
    private auth: AuthService
  ) {
    this.pacijent = new Pacijent();
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });


  }

  onSubmit() {
    console.log('Login press');

    const pacijent = new Pacijent();
    pacijent.email = this.loginForm.controls.email.value;
    pacijent.password = this.loginForm.controls.password.value;
    this.ulogovanPacijent = this.pacijentService.getByEmail(pacijent.email);
    this.ulogovanPacijent.subscribe(res => {
        this.pacijent.pacijentID = res.pacijentID;
        this.pacijent.aktivan = res.aktivan;
        console.log('this.pacijent.pacijentID: ' + this.pacijent.pacijentID);
        localStorage.setItem('aktivan', String(this.pacijent.aktivan));
        localStorage.setItem('pacijentID', String(this.pacijent.pacijentID));
      }
    );

    console.log('pacijent: ' + pacijent.email);

    this.pacijentService.login(pacijent).subscribe(
      res => {
        if ( res['token'] == null ) {
          console.log('Login failed');
        } else if (localStorage.getItem('aktivan') === 'false') {
          console.log(res['aktivan']);
          console.log('Morate aktivirati nalog');
        } else {
          this.auth.setToken(res);
         // localStorage.setItem('pacijentID', String(this.pacijent.pacijentID));
          // this.ulogovanPacijent = this.pacijentService.getByEmail(pacijent.email);
          // console.log('Ulogovan pacijent ID  -  ' + this.ulogovanPacijent);
          this.router.navigate(['/pacijent/home']);
        }
      }
    );

  }

}
