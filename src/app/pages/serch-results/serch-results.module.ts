import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SerchResultsRoutingModule } from './serch-results-routing.module';
import { SerchResultsComponent } from './serch-results.component';


@NgModule({
  declarations: [SerchResultsComponent],
  imports: [
    CommonModule,
    SerchResultsRoutingModule
  ]
})
export class SerchResultsModule { }
