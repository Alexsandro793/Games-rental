--liquibase formatted sql

--changeset gamesrental:1
create table customers (
    id_customer uuid not null,
    name varchar(244) not null,
    email varchar(244) unique not null,
    phone varchar(30) not null,

    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,

    constraint pk_customers primary key (id_customer)
);

--rollback drop table customers;