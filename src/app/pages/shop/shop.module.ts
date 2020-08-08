import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopRoutingModule } from './shop-routing.module';
import { ProductsComponent } from './products/products.component';


@NgModule({
  declarations: [ProductsComponent],
  imports: [
    CommonModule,
    ShopRoutingModule
  ]
})
export class ShopModule { }
