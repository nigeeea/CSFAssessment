import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})
export class RestaurantCuisineComponent implements OnInit {

  constructor(private restaurantSvc: RestaurantService){}

  restaurantsByCusine : string[] = ["Ajisen Ramen"]

  sub$!: Subscription

  ngOnInit(): void {
      this.restaurantSvc.getRestaurantsByCuisine("Asian");
      this.sub$ = this.restaurantSvc.cuisineResults.subscribe(
        results =>{
          this.restaurantsByCusine=results;
        }
      )
  }

    
  }

	
	// TODO Task 3
	// For View 2


