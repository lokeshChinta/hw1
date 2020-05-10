FROM openjdk:8u252-jre-buster

WORKDIR usr/lokesh

ADD target/selenium-docker.jar        selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/proj.properties            proj.properties
ADD target/libs                       libs

ADD testng.xml                       testng.xml


ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG  $MODULE