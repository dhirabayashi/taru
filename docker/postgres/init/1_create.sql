set client_encoding = 'UTF8';

create table users (
  id serial primary key,
  name varchar not null,
  age integer not null
);

insert into users(name, age) values 
  ('太郎', 30),
  ('次郎', 20),
  ('花子', 10)
;