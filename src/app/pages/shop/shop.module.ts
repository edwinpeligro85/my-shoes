import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopRoutingModule } from './shop-routing.module';
import { ProductsComponent } from './products/products.component';
import { ProductCardComponent } from './components/product-card/product-card.component';
import { ProductShopComponent } from './components/product-shop/product-shop.component';


@NgModule({
  declarations: [ProductsComponent, ProductCardComponent, ProductShopComponent],
  imports: [
    CommonModule,
    ShopRoutingModule
  ]
  // ,
  // exports: [
  //   ProductCardComponent
  // ]
})
export class ShopModule {  }
