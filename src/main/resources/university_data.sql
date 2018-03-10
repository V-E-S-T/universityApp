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
  ('Yakov Betrich', 'assistant', 800),                  #1
  ('Elena Gorobec', 'assistant', 800),                  #2
  ('Petro Sagaydak', 'associate professor', 1200),      #3
  ('Mustafa Mabibulin', 'professor', 1800),             #4
  ('Igor Kravec', 'assistant', 800),                    #5
  ('Michael Vasyliev', 'associate professor', 1200),    #6
  ('Katerina Sobol', 'professor', 1800),                #7
  ('Mark Berdish', 'assistant', 800),                   #8
  ('Olive Doga', 'assistant', 800),                     #9
  ('Taras Michailuk', 'professor', 1800),               #10
  ('Nikolette Faster', 'assistant', 800),               #11
  ('Omar Barteluya', 'associate professor', 1200),      #12
  ('Vladislav Orlov', 'assistant', 800),                #13
  ('Aleksandr Boyko', 'associate professor', 1200);     #14

drop table if exists departments;
create table departments(id int(10) not null auto_increment,
                         name_department varchar(100),
                         head_department varchar(100),
  primary key (id))
  engine = innoDB
  default character set = utf8;
insert into departments (name_department, head_department) values
  ('head_department_1', 'physic_department'),
  ('head_department_1', 'mathematics_department'),
  ('head_department_1', 'chemistry_department'),
  ('head_department_1', 'biology_department'),
  ('head_department_1', 'economic_department');

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