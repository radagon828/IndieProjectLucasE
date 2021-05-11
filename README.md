# IndieProjectLucasE

Problem Statement:

In a standard speedrunning website one is able to submit and view speedruns on various games. People can also typically view the rankings of all the submitted runs as well as guides that describe how the run is performed. But another thing of interest for people into speedrunning are the individual techniques performed within the runs themselves. However speedrunning websites don’t offer the ability to search for information on the techniques themselves. In this website you will have the ability to not only submit and view runs but you can also view and submit techniques as their own individual submissions. You can also submit full video or written guides to a games page for people to learn from. This website will be focused on getting people into speedruns by allowing users to provide content that allows anyone to gradually learn what a speedrun is all about. 

###Project Technologies/Techniques

* Security/Authentication
    * Tomcat's JDBC Realm Authentication
* Database
    * MySQL 8.0.22
* ORM Framework
    * Hibernate 5
* Dependency Management
    * Maven
* CSS
    * Bootstrap 4
* Data Validation
    * jquery Validation for front end
    * Hibernate validation for backend
* Logging
    * Log4J2
* Hosting
    * AWS
* Independent Research Topic/s
    * Jquery Validation
* Unit Testing
    * JUnit tests to achieve 100%+ code coverage
* IDE: IntelliJ IDEA  

### Design

* [User Stories](DesignDocuments/UserStories.md)
* [Screen Design](DesignDocuments/ScreenDesigns)
* [Database Design](DesignDocuments/databaseDiagram.png)
* [Minimal Viable Product Requirements](DesignDocuments/MVP.md)
* [Time Log](DesignDocuments/timeLog.md)
* [Demo Video](https://www.youtube.com/watch?v=VsIkzylfNwE)

##Project plan:

2/11  Create jsp pages for home page, game list, and singular game page and java beans for 3 seperate databases;
run database, tech database, and user database

2/18 add ability to create an account on the website, create record submission page,
create sql statements in order to create the database, create the tables, and insert default data.

2/25  create search engine to search for games, create technique submission page servlet to grab the data and java class to run search query on game add code for the homepage
to display the most recently added records

3/4 create admin functions to approve videos that get submitted

3/11 Create profile page that displays all user submitted runs and technique videos
for the profile thats logged in

##Week 8 Onward

3/25 Figure out how to get auth to work by clicking on the Login link to start a session

4/1 Create functional search engine for games, and create at least one game page that displays top records

4/8 Create functional submission page for technique videos and records

4/15 Create functional sign in page that adds a user and a user role

4/22 Create admin page that approves runs and videos

4/29 add ability for the pages to change appearence depending on what role is signed into an app



