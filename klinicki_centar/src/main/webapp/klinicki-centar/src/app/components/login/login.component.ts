import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PacijentService} from '../../services/pacijent.service';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {Pacijent} from "../../model/pacijent";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  pacijent: Pacijent;

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

    console.log('pacijent: ' + pacijent.email);

    this.pacijentService.login(pacijent).subscribe(
      res => {
        if ( res['token'] == null ) {
          console.log('Login failed');
        } else {
          this.auth.setToken(res);
          this.router.navigate(['/']);
        }
      }
    );
  }

}
