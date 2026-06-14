drop database PerseusDatabase;
create database PerseusDatabase;

use PerseusDatabase;

create table User(
    name varchar(50) primary key,
    password varchar(200),
    pfp varchar(150),
    banner varchar(150),
    bio text
);

create table Event(
    id int primary key auto_increment,
    title varchar(50),
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
    idEvent int,

    constraint foreign key (idAuthor) references User(name),
    constraint foreign key (idEvent) references Event(id)
);

create table Comment(
    id int primary key auto_increment,
    idUser varchar(50),
    idPost int,
    content text,
    likes int,

    constraint foreign key (idUser) references User(name),
    constraint foreign key (idPost) references Post(id)
);

create table eventAttendees(
    eventAttId int primary key auto_increment,
    eventId int,
    userId varchar(50),

    constraint foreign key (eventId) references Event(id),
    constraint foreign key (userId) references User(name)
);

create table likes(
    likeId int primary key auto_increment,
    postId int,
    userId varchar(50),
    constraint foreign key (postId) references Post(id),
    constraint foreign key (userId) references User(name)
);