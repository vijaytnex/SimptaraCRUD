drop table if exists Notes;

create table Users (
    id              serial          primary key,
    name            varchar(200)     not null,
    creation_date   timestamp       not null
);

