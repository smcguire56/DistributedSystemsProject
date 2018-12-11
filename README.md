# A RESTful Car Hire Booking System
Sean McGuire
In this project I was required to develop a Jersey, java RMI  and JAXB frameworks to allow a simple car hire booking service to allow the ability to create modify update and delete.

tests are finished in:
https://www.getpostman.com/collections/fbda7515836ebed0efad 


## Installation 
Firstly, clone this repo:

  ```
  git clone https://github.com/smcguire56/DistributedSystemsProject
  ```
 
 change directory to the file:

  ```
  cd CarHireProject
  ```

Set up the SQL file next with this command:  
  ````
  source CarBookingSQL.sql
  ````

And load up the jar file and war files:
  ````
  java -jar database-service.jar
  mv booking-server.war /Library/Tomcat/webapps/
  ````
* To run the Server, start tomcat. 
  ````
  cd /Library/Tomcat/bin/
  ````
  
Then just load up each project, on the server and run it on the tomcat server.



  
