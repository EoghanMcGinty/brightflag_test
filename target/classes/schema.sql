create table student (
   studentID integer auto_increment not null,
   firstName varchar(255) not null,
   lastName varchar(255) not null,
   primary key(studentID)
);

create table subject (
   subjectID integer auto_increment not null,
   subjectName varchar(255) not null,
   primary key(subjectID),
   unique(subjectName)
);

create table enrollments (
   studentID integer not null,
   subjectID integer not null,
   primary key(studentID, subjectID)
);

create table exam (
   examID integer auto_increment not null,
   subjectID integer not null,
   examName varchar(255) not null,
   primary key(examID, subjectID)
);

create table result (
   studentID integer not null,
   examID integer not null,
   grade integer not null,
   primary key(studentID, examID)
);


create table faculty (
   facultyID integer auto_increment not null,
   facultyName varchar(255) not null,
   primary key(facultyID)
);
