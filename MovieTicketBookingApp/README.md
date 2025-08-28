# Movie Ticket Booking App Using LLD 
NOTE :
- I have taken the UML and the code from youtube - [https://www.youtube.com/watch?v=t2FiaSThCw8&ab_channel=MrunmaiDahare] for my understanding of how everything works.
- From this we will get a basic idea how to start in an interview when given this design.
- I have not fully implemented the payment service here, just a dummy class, but we can talk about it in the interview.

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

1. **BookMyShowApp:**  
   Contains the main method and implements the `BookingService` class.

2. **BookingService:**  
   Manages the entire booking flow—from city selection to ticket generation.

3. **MovieController:**  
   Maintains a mapping of movies to cities.  
   Contains the list of all movies and movies available in each city.  
   Admin can add new movies here.  
   *Associated* with the `Movie` class.

4. **Movie:**  
   Defines movie attributes such as name, duration, and ID.

5. **TheatreController:**  
   Maintains a mapping of cities to theatres and all available theatres.  
   *Associated* with the `Theatre` class.

6. **Theatre:**  
   Contains attributes like screens, shows, city, and address.  
   Each theatre must have one or more screens and multiple shows.

7. **Screen:**  
   Defines screen ID and seats.  
   Cannot exist without the `Theatre` class (composition relationship).

8. **Show:**  
   Contains show ID, duration, screen, start time, etc.  
   *Associated* with `Theatre`, `Movie`, and `Seat` classes.

---

## Handling Concurrency

Concurrency is a crucial aspect in ticket booking systems, especially during high traffic events. Also concurrency is important from the interview point of view where we can be asked about how to handle conconcurrency.

- **Pessimistic Approach:**  
  When a user views a seat, it is locked for others and released only when the user stops viewing.  
  Best for high-traffic scenarios (concerts, IPL matches).

- **Optimistic Approach:**  
  Suitable for low contention.  
  Uses a version variable in the database; if two users try to book the same seat, only the first transaction succeeds.

- **Distributed Locking:**  
  Ensures safe seat booking in scalable systems using Redis.  
  For example, if the system runs on AWS and GCP, a lock is set on seats across servers for a stipulated time.  
  Used during flash sales or high traffic.

---

## UML

View the UML diagram here: [Lucidchart UML Link](https://lucid.app/lucidchart/90c7c283-3ac6-4213-8231-a923873dfac7/edit?invitationId=inv_081b76bb-9e57-4b53-a6a0-adda10c5ab64&page=0_0#)
