create database if not exists mesadnd;
create table if not exists mesadnd.character_sheet(id int primary key NOT NULL auto_increment, name varchar(120) NOT NULL, max_hp int NOT NULL, current_hp int NOT NULL, exp int NOT NULL);
create table if not exists mesadnd.skills(id int primary key NOT NULL auto_increment, skill_name varchar(30) NOT NULL, stat_modifier varchar(30) NOT NULL, full_proficiency tinyint(1) Not Null);

#character_id int NOT NULL, FOREIGN KEY (character_id) REFERENCES character_sheet(id)

