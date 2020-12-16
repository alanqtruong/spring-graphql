# Spring Boot GraphQL Example

Sample application demonstrating GraphQL with REST API equivalent using spring boot, JPA repository, hibernate transaction, Spring Rest Controller, GraphQL, HyperSQL embedded database and tomcat application server 

## Getting Started

Option 1 (JAR)
* mvn clean install -U
* java -jar spring-graphql-*.jar

Option 2 (Docker)
* docker build -t spring-graphql:1.0 .
* docker run -p 8080:8080 -t spring-graphql:1.0 .

  
* build using mvn clean install -U
* run main

### REST Services
* Create new student (POST)
    * http://localhost:8080/api/student/
        * body: {"firstName":"John", "lastName":"Smith"}
    
* Create new course (POST)
    * http://localhost:8080/api/course/
        * body: {"courseName":"Math"} 
        
* Add Student to a Course (POST)
    * http://localhost:8080/api/student/add-course/?studentId=1&courseId=1   
    
* Retrieve all students (GET)
    * http://localhost:8080/api/student/
    
* Retrieve student by id (GET)
    * http://localhost:8080/api/student/1
    
* Retrieve all courses (GET)
    * http://localhost:8080/api/course/
    
* Retrieve course by id (GET)
    * http://localhost:8080/api/course/1
    
### GraphQL
http://localhost:8080/playground

* Queries
```
query{
  students {
    studentId
    firstName
    lastName
    courses {
      courseName
    }
  }
}
```
```
query{
  student(id: 1) {
    studentId
    firstName
    lastName
    courses {
      courseName
    }
  }
}
```
```
query{
  courses {
    courseId
    courseName
    students {
       studentId
       firstName
       lastName
    }
  }
}
```
```
query{
  course(id: 1) {
    courseId
    courseName
    students {
       studentId
       firstName
       lastName
    }
  }
}
```

* Mutations
```
mutation{
  addStudent(student: {firstName:"Ben", lastName: "Smith"}){
    studentId
    firstName
    lastName
  }
}
```
```
mutation{
  addCourse(course: {courseName:"Math"}){
    courseId
    courseName
  }
}
```
```
mutation{
  addStudentToCourse(studentId: 1, courseId: 1){
    studentId
    firstName
    lastName
    courses{
      courseName
    }
  }
}
```       
        
### Prerequisites

* Java 11
* Lombok  
* Maven