# Dominoes application

## Prerequisites
To install and run the project you will need **Java** and **Apache Maven**

I used the following versions in my local machine:
* OpenJDK Runtime Environment (build 15+36-1562)
* Apache Maven 3.6.3

## Install
Compile the project from its root (Daniel-Sequeira/dominoes) with the following maven command:
```bash
$ mvn clean install
```

## Run
Once the code is compiled, the following command runs the **main** method from the Application class:
```bash
$ mvn exec:java -Dexec.mainClass="org.dsequeira.Application"
```