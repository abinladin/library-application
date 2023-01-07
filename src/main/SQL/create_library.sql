drop database library;
create database library;
use library;
create table book(
    title varchar(30),
    publisher varchar(30),
    copies int,
    ISBN long PRIMARY KEY,
);