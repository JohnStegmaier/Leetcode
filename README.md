# John's Leetcode Solution Application
This here is a simple spring boot application with Thymeleaf support to showcase each of my solved Leetcode problems in the form of a webapp.

Each question will get it's own html page under `src/main/resources/templates/questions` as well as it's own Controller so that it can be interacted with. The hope is that in addition to automated tests, there will be a web interface that a user can provide input to for a given problem to see how my solution responds / interprets it.

## Building and Running the Application
To build the application, simply use the maven command line tool and run `mvn clean compile`

To run the tests against the application, run `mvn clean test`

Finally, to run the application.... well I have to implement the JAR packaging first and then eventually you'll be able to use `java -jar [application name]` but for now just import this project in IntelliJ and run it I guess lol 🤷
