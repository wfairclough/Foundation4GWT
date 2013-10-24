# Welcome to Foundation4GWT

A GWT Library that provides the widgets of Zurb Foundation. 

Currently the Foundation4GWT widget extend the standard GWT widgets. In the future I would like to change them to be lower level in order to keep compatibility across GWT versions. 


## Setting up for Eclipse

	mvn clean eclipse:clean eclipse:eclipse

## Compiling JAR 

	mvn package

This command will compile the JAR and place it in the target/ directory. 

## Update License Headers

	mvn license:format -Dyear={copyright year string}

-Dyear command is a option,not required.

## License

This project is licensed under the Apache License, Version 2.0 
