--liquibase formatted sql

--changeset gamesrental:1
create table rentals (
    id_rental uuid not null,
    id_customer uuid not null,
    id_game uuid not null,

    rental_date timestamp not null,
    return_date timestamp,
    total numeric(10,2) default 0,

    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,

    constraint pk_rental
        primary key (id_rental),

    constraint fk_rental_customer
        foreign key (id_customer) references customers(id_customer),

    constraint fk_rental_game
        foreign key (id_game) references games(id_game)

);
--rollback drop table rentals;