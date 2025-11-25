--liquibase formatted sql

--changeset gamesrental:1
create table games (
    id_game uuid not null,
    title varchar(255) not null,
    platform varchar(100) not null,
    genre varchar(100) not null,
    release_year int not null,
    daily_fee numeric(10,2) not null,
    quantity int not null,

    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,

    constraint pk_game primary key (id_game)
);

--rollback drop table games;