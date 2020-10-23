# roombookingapi
Hotel room booking api 

Problem Statement :

There is a hotel booking website
Expose an API to book a room based on user bonus points.

Conditions:
If User has 'n' bonus points and Price to book the hotel is 'n’ ,Status of room changes to "BOOKED".
If User has 'n' bonus points and Price to book the hotel is greater than 'n’ , Status of room changes to "PENDING APPROVAL".
Any changes to user bonus is tracked in the system.

Devise a solution with proper architecture and documentation.

Note:
You can make necessary assumptions while devising the solution. Use JAVA , Node.js , Spring and any of the database.

Important points to consider:

1) Clean code
2) Design
3) Tests if possible
4) API documentation

Solution : 

1. /swagger-ui.html - swagger documentation for the api. 
2. There is an sql script hotel_mgt.sql which needs to be run on Mysql to run all APIs. This includes schema creation, table creation and initial data to support api operations.

Some assumtions : 
1. There are three statuses for rooms - BOOKED, PENDING APPROVAL, VACANT
2. if room is in PENDING APPROVAL, and some other bookings come with higher bonus points which are sufficiant to book the room, we'll consider new user and book the room for new user.
3. There is an api which vacants the room : this includes user bonus points deduction. 
4. There is a report module having api to get all rooms which are booked and to which user. 
