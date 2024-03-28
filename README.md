# Medical Clinic System
## What our system allows?
It is a system for the operation of a medical clinic, which makes it possible, first and foremost, to: 
  1.  Adding a clinic patient
  2.  Deletion of a patient
  3.  Change its data
  4.  Display all patients of the clinic
  5.  Display basic information about a patient
  6.  Display his/her home address
  7.  Display the patient's examination history
  8.  Search patients by name/surname/fullname
  9.  Adding a new treatment
  10.  Removal of treatment
  11. Enrolling a patient for a given treatment
  12. Indication that the patient has undergone treatment
  13. Postpone the visit
  14. Display all available treatments

## Before starting
  1.  Make sure you have Java installed
  2.  Make sure you have Maven installed
  3.  Make sure you have MySQL installed
  4.  Please change 4, 5 and 6 line in [this file](https://github.com/arturgesiarz/Medical_Clinic_System/blob/origin/src/main/resources/application.properties).
     Line 4 is your local link to your database, line 5 is your local login to the data base, and line 4 is your password. 

## How to run it?

  1. `git clone https://github.com/arturgesiarz/Medical_Clinic_System`
  2. `cd Medical_Clinic_System`
  3. `mvn clean install`
  4. `cd target`
  5. `java -jar medical-clinic.jar`

## In which it was written ?

The system was written in Java using the Spring Boot framework. The DBMS is MySQL

## Let's test it!
Now you can test the application, for example, with software such as Postman, in order to follow the operation of the programme well

## Documentaction
After you run, the program vist `http://localhost:8080/swagger-ui/index.html#/`
