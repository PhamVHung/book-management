create table books
(
    title  varchar(255) null,
    author varchar(255) null,
    year   int          null
);

create table users
(
    username varchar(255) not null
        primary key,
    password varchar(255) null
);


