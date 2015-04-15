Conference Application with Spring Data Neo4j 4
===============================================

This project is a demo application for the [Spring Data Neo4j](https://github.com/SpringSource/spring-data-neo4j)
library which provides convenient access to the [Neo4j](http://neo4j.org) graph database.

This tutorial is a fully functioning micro-service based web-application built using the following components

- Spring Boot
- Spring Data Neo4j
- Angular.js
- Twitter Bootstrap UI

The application's domain is conference management - and the application
allows you to manage the Conference's Speakers, Sessions, Tracks, Rooms and Attendees.

It leverages the power of Spring Data Neo4j/Spring Boot and in particular the new Neo4j Object Graph mapping technology to provide a RESTful interface with which the web client interacts. The application is entirely stateless: every interaction involves a call to a Neo4j server, hopefully demonstrating the speed of the new technology, even over the wire.

WARNING
-------
By default, the application will attempt to use a Neo4j instance running on the same machine as the application server, and on the standard port 7474. *IT WILL DESTROY ALL THE DATA IN THAT DATABASE AT STARTUP*. So if you don't want that to happen please back up any existing database first.

Start Neo4j
-----------

Now start your Neo4j server instance, if its not already running. 

**You should back up any data you want to keep because the application will purge any existing data first**

Starting the application
------------------------

    cd neo4j-spring-examples/sdn-boot
    mvn spring-boot:run

Authentication
--------------
The application itself does not require any authentication, but if you are running against Neo4j 2.2 or later,
you'll need to provide connection credentials for the database. Right now, the simplest way to do this is to pass
the Neo4j username and password on the command line:

    mvn spring-boot:run -Drun.jvmArguments="-Dusername=<usr> -Dpassword=<pwd>"

Loading the initial dataset
---------------------------
The application can load a set of base data, to get you started. Please be aware that this will destroy
any existing data that may previously exist, so take a backup.

    http://localhost:8080/api/reload

This will pre-load the Neo4j database with a handful of sessions, a dozen or so topics and speakers,
and 200 attendees.

Exploring the API:
-----------------
The JSON resources from the server can be inspected from the /api/... URLs, e.g.

    http://localhost:8080/api/tracks/
    http://localhost:8080/api/topics/
    http://localhost:8080/api/speakers/
    http://localhost:8080/api/attendees/
    http://localhost:8080/api/sessions/

Running the Conference Management web application
-------------------------------------------------
Simply point your browser at the root URL:

    http://localhost:8080

Stopping the application server
-------------------------------
You can stop the application server at any time by pressing Ctrl-C in the console window from where you launched it.

Make it better!
---------------
If you'd like to develop this application further, you will need to install node.js if it is not already installed:

- Node.js v0.10x+
- npm (which comes bundled with Node) v2.1.0+

Visit the node.js website for details of installing node.js for your particular operating system.

Once node is installed you'll then need to grab the following npm packages:

    npm install --global bower grunt-cli






