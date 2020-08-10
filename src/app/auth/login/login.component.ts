import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public checkoutForm = this.formBuilder.group({
    email: '',
    contraseña: ''
  });


  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  onSubmit() {
    // Process checkout data here
    
   if (this.checkoutForm.valid) {
    console.log('Inicio de Sesion Exitoso', this.checkoutForm.value);
    this.checkoutForm.reset();
   }else{
     console.log('Inicio de Sesion incorrecto');
   }
  }
}
