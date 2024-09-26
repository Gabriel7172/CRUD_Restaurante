create database if not exists test;
use test;

create table if not exists test(
  name varchar(40) not null,
  test varchar(30) not null
);
insert into test(name, test) values
("Pedro", "Teste");

select * from test;

