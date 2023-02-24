import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CuisineListComponent } from './components/cuisine-list.component';
import { RestaurantCuisineComponent } from './components/restaurant-cuisine.component';


const routes: Routes = [
  {path: 'api/cuisines', component: CuisineListComponent},
  { path: '**', redirectTo: '/', pathMatch: 'full'},
  {path:'api/:cuisine/restaurants', component: RestaurantCuisineComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
