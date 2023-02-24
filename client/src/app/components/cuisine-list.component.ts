import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})
export class CuisineListComponent implements OnInit {

	// TODO Task 2
	// For View 1

  cuisinesReceived!: String[]

  sub$!: Subscription  

  constructor(private restaurantSvc: RestaurantService){}

  ngOnInit(): void {

    this.restaurantSvc.getCuisineList();
      this.sub$ = this.restaurantSvc.cuisineResults.subscribe(
        results =>{
          this.cuisinesReceived=results;
        }
      )
  }

}
