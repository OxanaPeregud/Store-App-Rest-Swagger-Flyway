create table if not exists address
(
   id serial primary key,
   street varchar(255),
   house int,
   unit int
);
