create database if not exists mesadnd;
drop table mesadnd.character_sheet;
drop table mesadnd.skills;
create table if not exists mesadnd.character_sheet(character_id int primary key NOT NULL auto_increment, name varchar(120) NOT NULL, max_hp int NOT NULL, current_hp int NOT NULL, exp int NOT NULL);
create table if not exists mesadnd.skills(skills_id int primary key NOT NULL auto_increment, skill_name varchar(30) NOT NULL, stat_modifier varchar(30) NOT NULL, full_proficiency tinyint(1) Not Null);
create table if not exists mesadnd.abilities(abilities_id int primary key NOT NULL auto_increment, strength varchar(30) NOT NULL, dexterity varchar(30) NOT NULL, constitution tinyint(1) Not Null, intelligence tinyint(1) Not Null, wisdom tinyint(1) Not Null, charisma tinyint(1) Not Null);

