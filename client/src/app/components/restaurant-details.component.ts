import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms'
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {
	
	// TODO Task 4 and Task 5
	// For View 3

  commentPostForm!: FormGroup

  commentToSubmit!: Comment

  constructor(private fb: FormBuilder, private restaurantSvc: RestaurantService){}

  ngOnInit(): void {
      
    this.commentPostForm = this.createForm()
  }

  createForm(){
    return this.fb.group({
      name: this.fb.control(''),
      rating: this.fb.control(''),
      text: this.fb.control('')
    })
  }

  submitForm(){
    const name = this.commentPostForm.get('name')?.value
    const rating = this.commentPostForm.get('rating')?.value
    const text = this.commentPostForm.get('text')?.value

    //create teh object and pass it into the service
    //this.restaurantSvc.postComment()
  }

}
