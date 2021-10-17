create table if not exists discount
(
    id serial primary key,
    discount int,
    shop_id int,
    foreign key (shop_id) references shop (id)
    );
