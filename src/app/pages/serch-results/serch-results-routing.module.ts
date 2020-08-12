import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SerchResultsComponent } from './serch-results.component';


const routes: Routes = [
  { path: '' , component: SerchResultsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SerchResultsRoutingModule { }
