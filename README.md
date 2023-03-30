## Entities
### 1. Student
There are three attributes in the `Student` entity
- id
- name
- major

### 2. Teacher
There are also three attributes in the `Teacher` entity
- id
- name
- department

Two entities maintain a many-to-many relationship, i.e., one student
may relate to a single or multiple teachers, and vice versa



## Endpoints
### 1. Student Controller
- Retrieve all the students stored in the database


- Retrieve all the students related to the given teacher


- Retrieve a single student that has the given student id


- Create a new student in the database


- Update the information of an existing student in the database

### 2. Teacher Controller
- Retrieve all the teachers stored in the database


- Retrieve all the teachers related to the given student


- Retrieve a single teacher that has the given teacher id


- Create a new teacher in the database


- Update the information of an existing teacher in the database
