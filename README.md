# MyBank

Basic web project with an embed tomcat. We use servlets and get information from request.

this project do:
- save transactions 
- list all transactions
- return transactions in ```JSON``` format

Goal of this project:
- Understand servlets
- Configure ```pom.xml``` to create a executable jar
- Package configuration
- implements ```get``` and ```post``` 
- Get parameters of ```request```

to execute:
- open command line
- execute ```java -jar MyBank-1.0-SNAPSHOT.jar```
- test with ```http://localhost:8090/health```

## endpoints 
- create: ```http://localhost:8090/create?amount=50&references=McDonalls&date=2022-10-29 03:13:10```j
- list: ```http://localhost:8090/transactions```


