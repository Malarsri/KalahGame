# Mancala Game implementation based on Microservices architecture

This application implements Kalaha Game 

The solution uses Microservices architecture for building the game mostly for demonstration purposes!
(See [OBJECT ORIENTED ANALYSIS & DESIGN]
(./pictures/OOAnalysis.jpeg))
(./pictures/ClassDiagram.jpeg)
(./pictures/Package-Structure.jpeg)
The implementation consists of microservice implemented in Java using Spring Boot:
                                                 
 -   `kalah-api`: A TDD based implementation of Mancala Game API with two endpoints:
     
        - `CreateGame Endpoint`: To create a new Game
        - `SowGame Endpoint`: To sow specific pit index of the Game 
        
 You can find several Tests created to make sure the implementation covers all possible cases within Kalah Game.
 
  
Technologies
------------
- `Spring Boot`
- `Spring MVC`, for creating RESTful API
- `Spring hateoas`, for Link
- `Docker`, for containerization of services
- `Swagger`, Swagger-UI, for API documentation


Solution Architecture
--
The overal architecture of Mancala Game weill be as below:

![solution_architecture](pictures/ClassDiagram.png, pictures/Requirements Ans Analysis

Swagger API Documentation
------------------------
Swagger provides documentation for API. You can check the Kalah Game API at home page.
<BaseURL>/games/swagger-ui(http://localhost:8081/games/swagger-ui/index.html)

ex: 

 How To Run
 ----------
 
 
 Kalah service which can be in future,for you to customize the Mancala game based on number of stones. 
 The default value for this 
variable is 6 . 
 
 See [How to build and_run](HOW-TO-RUN.md) for details.
 
 Once you run the server you can access the Game at this address: <http://localhost>


 Feedback
 ----------
Your valuable feedback is highly appreciated.

