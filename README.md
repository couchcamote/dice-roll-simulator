# Dice Roll Simulator

An application to simulate rollong of dice, configurable by the number of dice, number of face of each dice and the number of rolls



## Running this application

### From The Terminal

On the project root, compile and build the application codes. This should create or update the target folder which contains generated and compiled codes with. Depending on the build type, it will also include a deployable jar or war file.
    
> mvn install

Run the Application

> mvn spring-boot:run


### From Eclipse

1) Import the Maven project
    
        File > Import > Maven > Existing Maven Projects

    Make sure to select the root folder

2) Create Run Configurations

        Run > Run Configurations

    Create a new **Maven Build** Run Configuration. 

        Base directory > Click Workspace and select SpringBootLab 

    Set the Goals to

        clean install

    Save the configuration and create a new one. 

    Set the same Base Directory but change the Goals to

        spring-boot:run



## Tools and Utilities

### [Swagger](localhost/swagger-ui.html)

### [H2 Embedded Database](localhost/h2)
    





