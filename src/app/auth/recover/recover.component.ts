import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-recover',
  templateUrl: './recover.component.html',
  styleUrls: ['./recover.component.css']
})
export class RecoverComponent implements OnInit {

  public checkoutForm = this.formBuilder.group({
    email: ''
  });
      
  constructor(private formBuilder: FormBuilder) {
    
    
  }
  

  ngOnInit(): void {
    
  }

  onSubmit() {
    // Process checkout data here
    
    if (this.checkoutForm.valid) {
      console.log('Revisar Email', this.checkoutForm.value);
    this.checkoutForm.reset();
    }else{
      console.log('El email no está registrado');
    }
  }
  
}


  
