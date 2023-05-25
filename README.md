# Booking System
A booking system that encrypts data and sends it via HTTP to a PHP REST API that sends back the requested data, data rate limit has been implemented based on IP plus different security measures.

Download the Booking.JAR file and run it, register and login.

https://youtu.be/a0qjf9Ima3c

![Booking](https://github.com/DanielAndrei1/BookingSystem/assets/44091613/17e4c037-d672-4e0f-bb65-a1c8340868fb)
![Booking2](https://github.com/DanielAndrei1/BookingSystem/assets/44091613/b5e58eb8-ab9e-439e-a4ea-a7b88a72d802)



# Runnable jar (booking) only tested on Windows
To run the program you need to download JDK or  JRE Java:

JDK Java: https://www.oracle.com/java/technologies/downloads/

You will also need to set the system variable paths to direct to the build\bin folders as shown below.

For Java:
C:\Program Files\Java\jdk-20\bin

![image](https://user-images.githubusercontent.com/44091613/235814230-a99fdc59-c85a-4157-8327-5c2764785c98.png)


# Debugging the runnable jar
If it does not work just run a command prompt from the folder where you downloaded it and use the following command:
java -agentlib:jdwp=transport=dt_socket,address=8080,server=y,suspend=n -jar Booking.jar
This command will open the jar and show any errors in the terminal.
![image](https://user-images.githubusercontent.com/44091613/235815004-75ee95c1-d64d-4f21-9bfb-3fd93279807b.png)

![image](https://user-images.githubusercontent.com/44091613/235814451-def1aa1c-8561-4c1a-83e8-89ad7ba3194f.png)

Created by Daniel Andrei


