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
- `GET : /students`: Retrieve all the students stored in the database


- `GET : /students/{teacherId}`: Retrieve all the students related to the given teacher


- `GET : /student/{studentId}`: Retrieve a single student that has the given student id


- `POST : /student`: Create a new student in the database


- `PUT : /student/{studentId}`: Update the information of an existing student in the database

### 2. Teacher Controller
- `GET : /teachers`: Retrieve all the teachers stored in the database


- `GET : /teachers/{studentId}`: Retrieve all the teachers related to the given student


- `GET : /teacher/{teacherId}`: Retrieve a single teacher that has the given teacher id


- `POST : /teacher`: Create a new teacher in the database


- `PUT : /teacher/{teacherId}`: Update the information of an existing teacher in the database
