create database PerseusDatabase;

use PerseusDatabase;

create table User(
    id int primary key,
    name varchar(50),
    password varchar(50),
    mail varchar(50),
    pfp varchar(150),
    banner varchar(150),
    bio text
);

create table Event(
    id int primary key,
    title varchar(50),
    description text,
    startDate datetime,
    endTime datetime,
    place varchar(100),
    image varchar(150),
    idAuthor int,

    constraint foreign key (idAuthor) references User(id)
);

create table Post(
    id int primary key,
    textContent text,
    idAuthor int,
    idEvent int,

    constraint foreign key (idAuthor) references User(id),
    constraint foreign key (idEvent) references Event(id)
);

create table Agency(
    name varchar(50) primary key,
    country varchar(50),
    history text,
    info text
);

create table Article(
    id int primary key,
    doc varchar(150),
    idAgency varchar(50),

    constraint foreign key (idAgency) references Agency(name)
);

create table Occurrence(
    name varchar(50),
    date datetime,
    description text,

    constraint primary key (name, date)
);

create table Comment(
    idUser int,
    idPost int,
    content text,
    likes int,

    constraint primary key (idUser, idPost),
    constraint foreign key (idUser) references User(id),
    constraint foreign key (idPost) references Post(id)
);

create table Opinion(
    idUser int,
    idArticle int,
    content text,
    likes int,
    line int,

    constraint primary key (idUser, idArticle),
    constraint foreign key (idUser) references User(id),
    constraint foreign key (idArticle) references Article(id)
);

create table Favorite(
    idUser int,
    occurrenceName varchar(50),
    occurrenceDate datetime,

    constraint primary key (idUser, occurrenceName, occurrenceDate),
    constraint foreign key (idUser) references User(id),
    constraint foreign key (occurrenceName, occurrenceDate) references occurrence(name, date)
)