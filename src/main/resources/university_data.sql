create schema if not exists university default character set utf8;
use university;
drop table if exists lectors;
create table lectors(id int(10) not null auto_increment,
                     name varchar(100),
                     degree varchar(255),
                     salary int(20),
  primary key (id))
  engine = innoDB
  default character set = utf8;
insert into lectors (name, degree, salary) values
  ('Yakov Betrich', 'ASSISTANT', 800),                  #1
  ('Elena Gorobec', 'ASSISTANT', 800),                  #2
  ('Petro Sagaydak', 'ASSOCIATE_PROFESSOR', 1200),      #3
  ('Mustafa Mabibulin', 'PROFESSOR', 1800),             #4
  ('Igor Kravec', 'ASSISTANT', 800),                    #5
  ('Michael Vasyliev', 'ASSOCIATE_PROFESSOR', 1200),    #6
  ('Katerina Sobol', 'PROFESSOR', 1800),                #7
  ('Mark Berdish', 'ASSISTANT', 800),                   #8
  ('Olive Doga', 'ASSISTANT', 800),                     #9
  ('Taras Michailuk', 'PROFESSOR', 1800),               #10
  ('Nikolette Faster', 'ASSISTANT', 800),               #11
  ('Omar Barteluya', 'ASSOCIATE_PROFESSOR', 1200),      #12
  ('Vladislav Orlov', 'ASSISTANT', 800),                #13
  ('Aleksandr Boyko', 'ASSOCIATE_PROFESSOR', 1200);     #14

drop table if exists departments;
create table departments(id int(10) not null auto_increment,
                         name_department varchar(100),
                         head_department varchar(100),
  primary key (id))
  engine = innoDB
  default character set = utf8;
insert into departments (name_department, head_department) values
  ('physic', 'Lisa Molisa'),
  ('mathematics', 'Dan Balan'),
  ('chemistry', 'Boris Noris'),
  ('biology', 'Mark Shtein'),
  ('economic', 'Anna Morison');

drop table if exists lectors_department;
create table lectors_department(lectors_id int(10),
                                department_id int(10),
  primary key (lectors_id, department_id),
  foreign key (lectors_id) REFERENCES lectors (id),
  foreign key (department_id) REFERENCES departments (id))
  default character set = utf8;
insert into lectors_department (lectors_id, department_id) values
  (1, 1),  (2, 1),  (3, 1),  (3, 3),  (4, 1),  (4, 2),  (4, 3),  (5, 2),
  (5, 5),  (6, 2),  (6, 5),  (7, 2),  (7, 5),  (8, 4),  (9, 4),  (10, 4),
  (10, 3),  (11, 3),  (12, 5),  (13, 4),  (14, 3),  (14, 2),  (14, 1);