import { Restaurant, Comment } from './models'
import {Injectable} from '@angular/core'
import {HttpClient, HttpParams} from '@angular/common/http'
import{Subject, firstValueFrom} from 'rxjs'


const BACKEND = 'http://localhost:8085';

@Injectable()
export class RestaurantService {

	// TODO Task 2 
	// Use the following method to get a list of cuisines
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	cuisineResults = new Subject<string[]>()

	restaurantResults = new Subject<string[]>()

	constructor(private http: HttpClient){}

	public getCuisineList(): Promise<string[]>  {
		// Implememntation in here
		
		return firstValueFrom(
			this.http.get<string[]>(`${BACKEND}/api/getcuisines`)
		)
		.then(results =>{
			this.restaurantResults.next(results);

			console.info(results);

			return results;
		}

		)

	}

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME

	public getRestaurantsByCuisine(cuisine: string): Promise<string[]> {
		
		const params = new HttpParams().set("cuisine", cuisine)

		return firstValueFrom(
			this.http.get<string[]>(`${BACKEND}/api/getRestaurantsByCuisine`, { params })
		).then(results =>
			{
			  this.restaurantResults.next(results);
			  return results;
			}
			
		  )

	}
	
	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE

	// public getRestaurant(???): Promise<Restaurant> {
	// 	// Implememntation in here

	// }

	// TODO Task 5
	// Use this method to submit a comment
	// DO NOT CHANGE THE METHOD'S NAME OR SIGNATURE

	// public postComment(comment: Comment): Promise<any> {
	// 	// Implememntation in here

	// }
}
