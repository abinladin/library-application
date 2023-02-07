-- author: Abdullah Binladin
-- This script creates the database and the tables required for the Library Application Java client to function.

-- Database set-up: creates an empty database with the necessary tables for the project

drop database library;
create database library;
use library;

-- creating the tables

create table books(
    isbn BIGINT NOT NULL,
    title VARCHAR(30) NOT NULL,
    publisher VARCHAR(30) NOT NULL,
    publication_date date NOT NULL,
    edition TINYINT,
    format ENUM("Hardcover", "Softcover", "Audiobook"),
    university_department ENUM("Computer_Science", "Business_Administration", "International_Relations"),
    PRIMARY KEY(isbn)
);

create table authors(
	name varchar(60) not null,
    primary key(name)
);

create table students(
	id int not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	primary key(id)
);

-- creating the junction tables

create table checkouts(
	student_id int not null,
	book_id bigint not null,
	checkout_date date not null,
	primary key(student_id, book_id),
	foreign key(student_id) references students(id),
	foreign key(book_id) references books(isbn)
);

create table book_author(
	book_id bigint not null,
	author_id varchar(60) not null,
	primary key(book_id, author_id),
	foreign key(book_id) references books(isbn),
	foreign key(author_id) references authors(name)
);

-- Fill with sample Data

