create database if not exists mesadnd;
create table if not exists mesadnd.`character`(id int primary key NOT NULL auto_increment, name varchar(120) NOT NULL, maxHp int NOT NULL, currentHp int NOT NULL, exp int NOT NULL);
create table if not exists mesadnd.skills(id int primary key NOT NULL auto_increment, skillName varchar(30) NOT NULL, statModifier varchar(30) NOT NULL, fullProficiency tinyint(1) Not Null, characterId int NOT NULL, FOREIGN KEY (characterID) REFERENCES `character`(id));

