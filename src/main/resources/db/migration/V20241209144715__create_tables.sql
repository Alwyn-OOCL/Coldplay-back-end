create table if not exists users (
    id serial primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    level varchar(255) not null,
    password varchar(255) not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);

create table if not exists venues (
    id serial primary key,
    country varchar(255) not null,
    city varchar(255) not null,
    address varchar(255) not null,
    image varchar(255) not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);

create table if not exists concerts (
    id serial primary key,
    name varchar(255) not null,
    start_time TIMESTAMP not null,
    duration double not null,
    venue_id int not null,
    image varchar(255) not null,
    description varchar(255) not null,
    sale_time TIMESTAMP not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);

create table if not exists area (
    id serial primary key,
    concert_id int not null,
    total int not null,
    available int not null,
    price float(53) not null,
    area_type varchar(255) not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);

create table if not exists seat (
    id serial primary key,
    seat_no int not null,
    area_id int not null,
    is_sold boolean not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);

create table if not exists `order` (
    id serial primary key,
    user_id int not null,
    concert_id int not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);

create table if not exists ticket (
    id serial primary key,
    amount float(53) not null,
    audience_name varchar(255) not null,
    audience_id_card varchar(255) not null,
    seat_id int not null,
    is_refunded boolean not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);

create table if not exists new_section (
    id serial primary key,
    title varchar(255) not null,
    description varchar(255) not null,
    image varchar(255) not null,
    created_by VARCHAR(255) not null ,
    created_by_name VARCHAR(255) not null,
    last_modified_by VARCHAR(255) not null ,
    last_modified_by_name VARCHAR(255) not null,
    created_time TIMESTAMP not null ,
    last_modified_time TIMESTAMP not null
);



