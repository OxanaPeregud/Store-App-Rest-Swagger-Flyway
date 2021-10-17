create table if not exists shop_customer
(
    id serial primary key,
    shop_id int,
    customer_id int,
    foreign key (shop_id) references shop (id)
    on update cascade on delete cascade,
    foreign key (customer_id) references customer (id)
    on update cascade on delete cascade
    );
