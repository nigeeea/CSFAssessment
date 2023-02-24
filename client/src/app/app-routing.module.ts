import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CuisineListComponent } from './components/cuisine-list.component';


const routes: Routes = [
  {path: 'api/cuisines', component: CuisineListComponent},
  { path: '**', redirectTo: '/', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
