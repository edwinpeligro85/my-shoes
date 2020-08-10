import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public checkoutForm = this.formBuilder.group({
    nombre: '',
    email: '',
    contraseña: '',
    confirmcontraseña: ''
  });


  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  onSubmit() {
    // Process checkout data here
    const contraseña = this.checkoutForm.value.contraseña;
    const confirmcontraseña = this.checkoutForm.value.confirmcontraseña;

    if (contraseña === confirmcontraseña && this.checkoutForm.valid) {
      console.log('Exito', this.checkoutForm.value);
      this.checkoutForm.reset();
    }
    else{
      console.log('Las contraseñas no coinciden o registro incorrecto');
    }

  }
}
