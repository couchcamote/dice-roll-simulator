# Help and FAQ

## Running this application

This application is separated into 2 parts, the Backend Server with Spring Boot and the [front-end](https://github.com/couchcamote/dice-roll-simulator-web) with Angular.

The back-end contains an embedded H2 database on runtime and currently configured to be an *in-memory storage = jdbc:h2:mem:db*. This can be changed into a persisted file storage by changing the datasource URL to the a local directory.

e.g. *spring.datasource.url = jdbc:h2:file:C:/data/sample*

**Required Installations**
* Java Development Kit (at least JDK 1.8)
* Maven
* Node JS and NPM (Node Package Manager)

They should be added to PATH directory of your machine.
[Adding to PATH environment variable in Windows](https://www.architectryan.com/2018/03/17/add-to-the-path-on-windows-10/)

If JDK, Node and Angular were installed using any packaging tool in Linux (apt, yum, etc) It is expected that they should be availabe to run on the terminal already.
[Manual adding on linux](https://linuxize.com/post/how-to-add-directory-to-path-in-linux/)


The back-end server can be started in two ways, by terminal or from inside an IDE like Eclipse or Microsoft Visual Code.

### From The Terminal

Clone or download this repository on your local directory. You should be on the root folder before running the following scripts.

If you cloned via git, the application root directory is currently a subfolder where git is run. Go to this directory first

> cd dice-roll-simulator

On the project root, compile and build the application codes. This should create or update the target folder which contains generated and compiled codes with. It will also contain the deployable jar file.
    
> mvn install

Run the Application

> mvn spring-boot:run

The server should be available on [localhost:8080](localhost:8080) or the one configured in [application.propertues](https://github.com/couchcamote/dice-roll-simulator/blob/master/src/main/resources/application.properties.) 

e.g server.port=8080

Check that the Back-end API can receive request by trying the built-in [Swagger Page](http://localhost:8080/swagger-ui.html)


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


## Run the Front-End 
Go the [Front End](https://github.com/couchcamote/dice-roll-simulator-web) page and follow the instruction.


## Additional Tools and Utilities

### [Swagger](http://localhost:8080/swagger-ui.html)

Use [Swagger](http://localhost:8080/swagger-ui.html) to test the Back-End API

### [H2 Database](http://localhost:8080/h2)

To access the embedded H2 database, go the [/h2](http://localhost:8080/h2) Console Page.

The database credentials are located on the [application.properties](src/main/resources/application.properties) file.

Fill in the configured database URL *Default: (jdbc:h2:mem:db)*.
    

