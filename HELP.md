# Help and FAQ

## Running this application

### From The Terminal

On the project root, compile and build the application codes. This should create or update the target folder which contains generated and compiled codes with. It will also contain the deployable jar file.
    
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

### [Swagger](http://localhost:8080/swagger-ui.html)

Use [Swagger](http://localhost:8080/swagger-ui.html) to test the Back-End API

### [H2 Database](http://localhost:8080/h2)

To access the embedded H2 database, go the [/h2](http://localhost:8080/h2) Console Page.

The database credentials are located on the [application.properties](src/main/resources/application.properties) file.

Fill in the configured database URL *Default: (jdbc:h2:mem:db)*.
    

