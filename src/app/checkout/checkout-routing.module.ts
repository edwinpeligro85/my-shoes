import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { PayComponent } from './pay/pay.component';
import { ConfirmComponent } from './confirm/confirm.component';


const routes: Routes = [
  { path: 'cart', component: CartComponent },
  { path: 'pay', component: PayComponent },
  { path: 'confirm', component: ConfirmComponent },
  { path: '**', redirectTo: 'cart', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CheckoutRoutingModule { }
