create schema store;
create table order_infor
(
    id         int auto_increment   primary key,
    user_id    int not null,
    address_id int not null,
    cart_id    int not null,
    state      int not null
)auto_increment=30001;

create table product
(
    id    int auto_increment        primary key,
    name  varchar(20)  not null,
    image varchar(100) not null,
    price int          not null,
    des   varchar(200) not null,
    type  int          null
)auto_increment=10001;

create table shoppingcart
(
    user_id    int not null,
    product_id int not null,
    quantity   int not null,
    id         int auto_increment   primary key,
    isorder    int not null
)auto_increment=50001;

create table user
(
    id       int auto_increment     primary key,
    account  varchar(20)  not null,
    password varchar(100) not null,
    constraint account_UNIQUE
        unique (account)
)auto_increment=20001;

create table user_address
(
    id        int auto_increment    primary key,
    user_id   int          not null,
    addressee varchar(20)  not null,
    phone_num varchar(20)  not null,
    address   varchar(100) not null,
    _delete   int          not null
)auto_increment=40001;


