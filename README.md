#American Ten-Pin Bowling Application

The Application uses Gradle 7.11 as the Build System.  However to run the application or to run any of the below commands we do not need to install Gradle.

Java 11.0.12 (Oracle JDK) is used as the main Development Language.

All Unit and Integration Tests are written using JUnit - 5.

## Application Commands

1. Clean and Build: ./gradlew clean build
2. Unit and Integration Tests: ./gradlew clean test
3. Run application: ./gradlew run

The './gradlew' command will only run in Unix Systems.  In order to use in Windows please replace the './gradlew' with 'gradlew'.
However, please note that this application has not been tested on a Windows platform.

## Assumptions

1. Considered it to be a console based application
2. Wrote comprehensive Integration Test to cover scenarios.  Hence, did not write unit tests per each class.  However, I have added unit tests to test certain classes.
3. Built the system with the mindset that it can return current score in real world, instead of waiting till the game finishes to calculate score.

## How to

Once the application is running, the application will ask for "Please enter Roll:".
Valid Options are:

    1. X: Indicates a Strike
    2. /: Indicates a Spare
    3. -: Indicates a Miss
    4. 1: Indicates a 1 pin was knocked down
    5. 2 Indicates a 2 pin was knocked down
    6. 3 Indicates a 3 pin was knocked down
    7. 4 Indicates a 4 pin was knocked down
    8. 5 Indicates a 5 pin was knocked down
    9. 6 Indicates a 6 pin was knocked down
    10. 7 Indicates a 7 pin was knocked down
    11. 8 Indicates a 8 pin was knocked down
    12. 9 Indicates a 9 pin was knocked down

When there are no more rolls it will return the total score.

## A bit about the design

The main class is 'au.com.senthur.bowling.Application'.  This will start the application up.

RollService.java is responsible for governing the game.  It will use a 'GameLine' and the 'user input' to handle and calculate the score.  
There are knock down handlers that are responsible to handle each knock down type. This will be injected at runtime polymorphically to calculate the score, retries and bonuses.  These handlers are obtained dynamically using a Handler Factory.
Identified Knock Down Types are:

1. Strike
2. Spare
3. Partial
4. Miss

