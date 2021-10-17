create table if not exists shop
(
    id serial primary key,
    name varchar(255),
    description varchar(255),
    email varchar(255),
    mobile float,
    address_id int,
    foreign key (address_id) references address (id)
    on update cascade on delete cascade
    );
