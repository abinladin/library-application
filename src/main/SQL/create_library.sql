drop database library;
create database library;

use library;

create table books(
    isbn BIGINT NOT NULL,
    title VARCHAR(30) NOT NULL,
    publisher VARCHAR(30) NOT NULL,
    edition TINYINT,
    format ENUM("Hardcover", "Softcover", "Audiobook"),
    university_department ENUM("Computer Science", "Business Administration", "International Relations"),
    PRIMARY KEY (ISBN)
);

create table authors(
    author_id varchar,


);


