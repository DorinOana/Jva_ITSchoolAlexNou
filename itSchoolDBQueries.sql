create database if not exists itschooldemoqadb;

use itschooldemoqadb;

CREATE TABLE WebTable (
    idWebTable int not null auto_increment,
	FirstName varchar(255),
	LastName varchar(255),
	Email varchar(255),
    Age varchar(255),
    Salary varchar(255),
    Department varchar(255),
	EntryDate varchar(255),
	primary key(idWebTable)
);

CREATE TABLE PracticeForm (
    idPracticeForm int not null auto_increment,
	FirstName varchar(255),
	LastName varchar(255),
	Email varchar(255),
    Gender varchar(255),
    Mobile varchar(255),
    DateOfBirth varchar(255),
    Subjects varchar(255),
    Hobbies varchar(255),
    Address varchar(255),
    State varchar(255),
    City varchar(255),
	EntryDate varchar(255),
	primary key(idPracticeForm)
);