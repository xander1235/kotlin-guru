create schema demo;

use  demo;

create table user
(
    id bigint primary key not null,
    name varchar(255) not null,
    email varchar(350) not null,
    mobile varchar(11) not null
);

create table friend_request
(
    id bigint primary key not null,
    name1 varchar(255) not null,
    name2 varchar(255) not null,
    is_friend boolean  default false not null
);