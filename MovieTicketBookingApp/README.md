# Movie Ticket Booking App Using LLD 
NOTE :
- I have taken the UML and the code from youtube - [https://www.youtube.com/watch?v=t2FiaSThCw8&ab_channel=MrunmaiDahare] for my understanding of how everything works but the code is written by me since I wanted Java implementation.
- From this we will get a basic idea how to start in an interview when given this design.

## Requirements

1. **Admin Access:**  
   Admin has the authority to add or remove movies.

2. **Movie Management:**  
   Controls the duration of movies and manages seat availability for each theatre.

3. **Booking Flow:**  
   Users can select their location, choose a movie, pick desired seats, and choose a payment method.

4. **Ticket Generation:**  
   After payment, users receive a ticket for their selected movie and seats.

## Classes Required 

1. BookMyShowApp - contains the main method which implements the bookingService class.
2. bookingService - Contains the whole flow of the app - From selection of city to generation of ticket.
3. MovieController - Its the movie vs City map. It contains the list of all the movies as well as the movies corresponding to each city. The admin has the accessibility to add new movies here. This class is "associated" with the Movie Class.
4. Movie - defines the movie name, duration, id.
5. TheatreContoller - Its the city vs theatre map. The theatres corresponding to a particular city as well as all the theatres. This class is "asscociated" with Theatre class.
6. Theatre - Contains the attributes like screen, shows, city, address. A theatre must have one or more screens and multiple shows.
7. Screen - defines the id and seats. This class cannot exist without the Theatre class hence, has a "composition" relationship with the theatre class.
8. Show - contain the show id, duration, screen, starting time etc. This class is "associated" with Theatre class. This is also "associated" with Movie class and Seat class.
9. 




