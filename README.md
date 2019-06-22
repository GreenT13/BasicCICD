[![Build Status](https://travis-ci.org/GreenT13/BasicCICD.svg?branch=master)](https://travis-ci.org/GreenT13/BasicCICD)
# BasicCICD
Todo:
* Branches fb - acc - prd on github.
* Deploying separate branches to separate heroku servers.

# Database version control (Flyway)
I use Flyway for all the database-related stuff. Just a list of SQL files, nothing fancy. Spring automatically detects Flyway, so there was no additional configuration. Just add the scripts in the resources/db/migration folder and voila!

# CICD (travis-ci and heroku)
Project is automatically build using travis-ci, and deployed to heroku.
