import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErrorComponent } from './components/error/error.component';
import { LayoutComponent } from './layout/layout.component';


const routes: Routes = [
  {
    path: '', component: LayoutComponent, children: [
      {
        path: 'home',
        loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule)
      },
      {
        path: 'shop',
        loadChildren: () => import('./pages/shop/shop.module').then(m => m.ShopModule)
      },
      {
        path: 'contact',
        loadChildren: () => import('./pages/contact/contact.module').then(m => m.ContactModule)
      },
      {
        path: '**', redirectTo: '/auth', pathMatch: 'full'
      }
    ]
  },
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: '**', component: ErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
