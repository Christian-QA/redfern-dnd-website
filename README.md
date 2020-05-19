Test Coverage: Junit - 88.9%, SonarQube 80.2%
# MesaDND - Dungeons and Dragons Homebrew Application - QA Individual Project 

![alt text](https://github.com/Christian-QA/redfern-dnd-website/blob/master/src/main/resources/static/images/mesafinalex1.png)

MesaDND is a spring web application made to accompany a Dungeons and Dragons scenario I made in 2017. It holds character sheets for a player to use, which can be created, read, updated and destroyed at the behest of the user. The character sheets are stored in a [MySQL](https://www.mysql.com/) 
database on [GCP](https://console.cloud.google.com/). The application is built with Spring Boot [Spring Boot](https://spring.io/guides/gs/spring-boot/), a [Java](https://www.java.com/en/)-based framework commonly used to create stand-alone applications. The back-end was developed in [Java](https://www.java.com/en/) 
using the [IntelliJ IDEA](https://www.jetbrains.com/idea/) while the front-end was developed in [HTML, CSS](https://html.com/) and [JavaScript](https://www.javascript.com/) using the [Visual Studios Code](https://code.visualstudio.com/).  
The project is built using [Maven](https://maven.apache.org/). [Jenkins](https://www.jenkins.io/) is used as a CI Pipeline to send to an instance on GCP, which hosts [SonarQube](https://www.sonarqube.org/), and to send to [Nexus Artifact Repository](https://www.sonatype.com/product-nexus-repository).
Progress on the project can be viewed in the [Projects tab on GitHub as a kanban board](https://github.com/Christian-QA/redfern-dnd-website/projects/1).

The program's server can be run on a terminal of your choice, and has been tested on cmd.exe (Windows Command Prompt) and [git bash](https://git-scm.com/) using the command 'mvn spring-boot:run'. The server is configured to run using 'localport:8181'. 
Once 'Started MesaDND in 8.613 seconds (JVM running for 9.055)' appears in the terminal, you can access the application as a user by searching for the configured localport in a browser of your choice, though [Google Chrome](https://www.google.com/chrome/) is recommended.

## Disclaimer
The project's development is in its alpha stage and is not yet ready for public release.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To use this program, you will need:

- [Java SE 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or later (needed to run the jar file located in the target folder)
- A [mySQL](https://www.mysql.com/) database, preferably one hosted on [GCP](https://console.cloud.google.com/) as this application was built with GCP in mind.

At the moment, a demo mySQL database exists and is linked to this application. If you wish to change the database, you can by changing the settings in the 'application.properties' file, specifically 'spring.cloud.gcp.sql.database-name', 'spring.cloud.gcp.sql.instance-connection-name' and 'spring.datasource.url'.

To develop using this project, you will need:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/) or a similar IDE capable of running Spring Boot.
- [Apache Maven](https://maven.apache.org/)

It is also recommended you use [Visual Studios Code](https://code.visualstudio.com/) for your HTML, CSS and JavaScript as most Java-centric IDEs like [IntelliJ IDE](https://www.jetbrains.com/idea/) show false-errors with other languages, though ignoring these issues is viable.

If you use this project for your own development, you will need to follow the instructions above in order to use your own database.


## Obtaining a Copy

You can geta copy of the application in one of two ways:
- Open [Git Bash](https://git-scm.com/) in a directory of your choice and enter 'git clone https://github.com/Christian-QA/redfern-dnd-website.git'.
- Navigate to [releases](https://github.com/Christian-QA/redfern-dnd-website/releases) on the project repository's main page and download the redfern-dnd-website-master-v0.1.4.zip file from the assets drop-down list.

## Getting Started

The app can be run on an App Engine on [GCP](https://console.cloud.google.com/). An App Engine already exists for this application to be accessed from other devices, though accessibility is subject to change for as long as the project remains in the pre-beta stages. 
For now, a local or self-hosted GCP App Engine is the recommended option, and mandatory if you wish to develop this app further.

To run the application on your local machine, use a terminal of your choice (Windows Command Prompt is recommended) and enter 'mvn spring-boot:run'. This will initialise the server and allocate a server port (8181 by default) to the application. This server port can be accessed by searching 'localport:8181' in your browser.

Once the server is running, you can access the web application as a user. 
Upon accessing the application on your browser, you will be taken to the Mesa Home Page (index.html) displays basic information about the application relating to the scenario it's based off. 
From here you can either access the Character Sheet (character.html) or the Character Maker (maker.html).

## Database

![alt text](https://github.com/Christian-QA/redfern-dnd-website/blob/master/documentation/ERD%20DND%20Website.png)

The application uses a database called mesadnd, hosted on [GCP](https://console.cloud.google.com/). As with the App Engine, its accessibility to subject to change while the project is in pre-beta stages, so it's recommended that any user or developer make their own at this stage.
Their are six tables contained in the database, and any missing will be recreated by the application upon its next run.

### Character Sheet

In the database, this table is called 'character_sheet'. It contains the following fields:
   - `character_id` - A bigint(20), auto-incrementing field serving as the primary key.
   - `name` - A varchar(120) acting as the personalised name of the selected character. This is assigned on the Character Maker page and read on the Character Sheet.
   - `max_hp` - An int(4) field storying the last inputted maximum value for hp. This fields currently defaults to '1' upon character creation.
   - `current_hp` - An int(4) field storing the last inputted hp value. This fields currently defaults to '1' upon character creation.
   - `exp` - An int(11) field storing the total experience points of the selected character. This field currently defaults to '0' upon character creation.

To create the character values, navigate to the Character Maker page. Every field, excluding the Skills checkboxes, need to be filled.

To read the character fields, navigate to the Character Sheet page. The values are all displayed on the Character Sheet on the top-most section of the page's article, below the navbar. This works by utilising an [axios](https://github.com/axios/axios) GET API request and fetching the values from the database by the character_id. At this stage, the character_id defaults to the first entry in the database.

To update the character fields, navigate to the Character Sheet page. Click on the value you wish to change and edit the text. Once you've changed to the new value, click 'confirm changes'. This will update every entry on the page to their new value. This works by utilising an [axios](https://github.com/axios/axios) PUT API request and sending replacement values to the database by the currently selected character_id.

To delete a character, navigate to the Character Sheet page. Click the 'delete character' button next to 'confirm changes'. This will delete the currently selected character. This works by utilising an [axios](https://github.com/axios/axios) DELETE API request, which deletes every entry associated with the current character_id.
(WARNING: This will send the delete request the moment it is clicked. There are plans to move this option to its own page and give a warning message to reduce the chance of users accidently clicking it).

### Abilities

In the database, this table is called 'abilities'. It contains the following fields:
   - `abilities_id` - A bigint(20), auto-incrementing field serving as the primary key.
   - `strength` - An int(3) value used as the strength ability statistic for the selected character.
   - `dexterity` - An int(3) value used as the dexterity ability statistic for the selected character.
   - `constitution` - An int(3) value used as the constitution ability statistic for the selected character.
   - `intelligence` - An int(3) value used as the intelligence ability statistic for the selected character.
   - `wisdom` - An int(3) value used as the wisdom ability statistic for the selected character.
   - `charisma` - An int(3) value used as the charisma ability statistic for the selected character.
   
To create the ability values, navigate to the Character Maker page. Every field, excluding the Skills checkboxes, need to be filled. This is done alongside the Character Sheet values, and must be filled in together to avoid an error. Currently, the abilities_id is assigned alongside the character_id, and increment simultaneously.  

To read the abilities fields, navigate to the Character Sheet page. The values are all displayed atop images below the CRUD buttons. This works by utilising an [axios](https://github.com/axios/axios) GET API request and fetching the values from the database by the character_id (not the abilities_id as abilities can only be made alongside the character, meaning there's only one set of abilities embedded into characters at any given time). 
At this stage, the character_id defaults to the first entry in the database.

To update the abilities fields, navigate to the Character Sheet page. Updating the character_sheet will update the abilities as well as the [axios](https://github.com/axios/axios) PUT API request is executed simultaneous to the character_sheets request. The update uses the currently selected character_id, which is synched to the abilities_id.

To delete the abilities fields, navigate to the Character Sheet page. Deleting the character sheet will delete the abilities entries as well because the abilities table from the front-end's perspective is embedded into the character_sheet. 

### Skills

In the database, this table is called 'skills'. It contains the following fields:
   - `skills_id` - A bigint(20), auto-incrementing field serving as the primary key.
   - `skill_name` - A varchar(35) value used to specify the name of the skill.
   - `stat_modifier` - varchar(12) value used to specify which ability the roll is modified by.

The skill values are premade and cannot be made by the user without accessing the code. This may be reconsidered at a later date.

To read the skills fields, navigate to the Character Sheet page. The values are all displayed atop a box below the ability statistic boxes, alongside their ability modifier. This is retrieved by the same GET request which obtains the Character Sheet and Abilities data.

The skills values cannot be deleted at this time. 

### Skills to Character Sheet and Abilities to Character Sheet

In the database, to link the Skills table and the Abilities table to the Character Sheet, intermediate tables exists to hold their respective keys to allow for ManyToMany connections. 

The 'skills_character_sheet' contains the following fields:
   - `skills_id` - A bigint(20) foreign key referring to the skills_id of the skills table.
   - `character_id` - A bigint(20) foreign key referring to the character_id of the character_sheets table.

The 'abilities_character_sheet' contains the following fields:
   - `abilities_id` - A bigint(20) foreign key referring to the abilities_id of the abilities table.
   - `character_id` - A bigint(20) foreign key referring to the character_id of the character_sheets table.

Both these table work the same way, by taking a Character Sheet row by its id and associating it with multiple rows belonging to the Skills and Abilities table. This is mainly for the benefit of skills, as characters will likely possess numerous skills throughout their campaign.

### Hibernate Sequence

In the database, this table is called hibernate_sequence. This is a table created and utilised by the Spring Boot framework, and should not be touched. If deleted, it will recreate itself upon the applications next run.

## Running the Tests

The project utilises three different tools for testing: JUnit for Unit Testing, JUnit with Mockito and TestNG with Selenium for Integration Testing, and SonarQube for Coding Style Tests.

### Unit Tests

Individual modules within the program can be tested using JUnit, which tests the methods within their main counterpart.

To test on JUnit (IntelliJ):

1. Right click on the class you wish to test in the file explorer of the IntelliJ IDE, as found in src/test/java, not the actual classes found in src/main/java (to run all tests, right click the src/test/java folder instead).
2. Hover over 'Run As' on the dropdown menu.
3. Click '2 JUnit Test'.
4. All tests within the application are undertaken and can be reviewed using the 'JUnit' and 'Coverage' windows.

## Integration Tests

Mockito is used to run integration tests by mocking user input, creating a map of possible inputs to test if they're consistently error-proofed. Mockito tests are run using JUnit alongside the basic unit tests, meaning they follow the same steps as unit tests.

## Coding Style Tests

To test on SonarQube (you must have Maven installed on your computer to build the project for SonarQube to read):

1. Create a VM Instance on GCP called 'sonarqube'.
2. Click on the instance name.
3. Click 'edit'.
4. Scroll down to network tags and give it the tag 'tcp-9000'.
5. Go back to your instance list and click 'SSH' beneath 'connect'
6. Once you have access to the terminal, enter 'docker start sonarqube'
7. Open a new tab in any browser and enter the external IP of your instance (next to 'SSH'), followed by a semicolon, followed by '9000'. You should now have access to SonarQube.

Deploy to SonarQube using a local terminal:

8. Open a terminal within your local project directory.
9. Enter 'mvn clean package test'.
10. Enter 'mvn sonar:sonar -Dsonar.host.url=http://<YOUR EXTERNAL IP>:9000 -Dsonar.login.admin=admin -Dsonar.password=admin'.

Deploy to SonarQube using Jenkins:

8. Create a project on Jenkins.
9. Link it to your GitHub Repository URL for this project (either from this repository or your own forked version).
10. Ensure 'Poll SCM' and 'Abort the build if it's stuck' are checkout (optional: build periodically with 'H \* \* \* \*' typed into the 11. Schedule for hourly testing).
11. Create two 'Execute Windows batch commands'
    12.In the first Windows batch command, enter 'mvn clean package test'.
12. In the second Windows batch command, enter 'mvn sonar:sonar -Dsonar.host.url=http://<YOUR EXTERNAL IP>:9000 -Dsonar.login.admin=admin -Dsonar.password=admin'.

Following these steps, the project should now be viewable on the tab you opened for SonarQube.

## Deployment

The project is open source, therefore is available to anyone to clone or fork.
Regardless of whether you clone this repository or a repository you forked, you will need to open a terminal within the local directory and enter the following:

- mvn clean package
- cd target/
- java -jar ChristianRedfern-SoftwareMarch16-jar-with-dependencies.jar

Note: if you changed the Artifact Id within your pom.xml, you will need to enter the new id followed by .jar instead. If you are unsure

## Built With


- [IntelliJ IDEA](https://www.jetbrains.com/idea/) - Back-End IDE
- [Visual Studios Code](https://code.visualstudio.com/) - Front-End IDE
- [Spring Boot](https://spring.io/guides/gs/spring-boot/) - API Development Platform
- [Maven](https://maven.apache.org/) - Dependency Management
- [GCP (Google Cloud Platform](https://console.cloud.google.com/) - Database and Instance Host
- [MySQL](https://www.mysql.com/) - Database Language
- [Jenkins](https://www.jenkins.io/) - CI Pipeline
- [Git](https://git-scm.com/) - Local Repository and Version Control
- [GitHub](https://github.com/) - Online Repository, Version Control and Project Management
- [SonarQube](https://www.sonarqube.org/) - Static Program Analysis
- [Nexus](https://www.sonatype.com/product-nexus-repository) - Artifact Repository
- [JUnit](https://junit.org/junit5/) - Unit and Integration Testing
- [Mockito](https://site.mockito.org/) - Integration Testing Testing
- [TestNG](https://testng.org/doc/) - Integration Testing Testing
- [Selenium](https://www.selenium.dev/) - Integration Testing Testing
- [Postman](https://www.postman.com/) - Testing
- [Diagrams](https://www.diagrams.net/) - Diagram Making


## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

- \*_Christian Redfern_ - _Author_ - [Christian-QA](https://github.com/Christian-QA)

## Contributing to the Project

This project has a code of conduct for those wishing to propose changes - see the [CONTRIBUTING.md](CONTRIBUTING.md) file for details

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgements

- Nicholas Johnson - Software Trainer - [nickrstewarttds](https://github.com/nickrstewarttds)
- Jordan Harrison - Software Trainer - [JHarry444](https://github.com/JHarry444)
- Tadas Vaidotas - Software Trainer - [tvaidotas](https://github.com/tvaidotas)
- David Williams - Advice with Java - [DavidWilliamsQA](https://github.com/DavidWilliamsQA)
- Caroline Strasenburgh - Advice with JavaScript - [CarolineS-QA](https://github.com/CarolineS-QA)
- Korbinian Ring - Advice with Java - [KMRRingQA](https://github.com/KMRRingQA)
- Luke Conway - Advice with Database Planning - [ConwayQA](https://github.com/ConwayQA)
- Felix Marley - Feedback - [Femarleycode](https://github.com/Femarleycode)

