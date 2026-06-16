drop database if exists perseusDatabase;
create database if not exists perseusDatabase;

use perseusDatabase;

create table User(
    name varchar(50) primary key,
    password varchar(200)
);

create table Event(
    id int primary key auto_increment,
    title varchar(100),
    description text,
    startDate datetime,
    endTime datetime,
    place varchar(100),
    image varchar(150),
    idAuthor varchar(50),

    constraint foreign key (idAuthor) references User(name)
);

create table Post(
    id int primary key auto_increment,
    textContent text,
    image varchar(150),
    idAuthor varchar(50),

    constraint foreign key (idAuthor) references User(name)
);

create table Comment(
    id int primary key auto_increment,
    idUser varchar(50),
    idPost int,
    content text,

    constraint foreign key (idUser) references User(name),
    constraint foreign key (idPost) references Post(id)
);