CREATE TABLE hibernate_sequence ( sequence_name varchar(255), next_val integer );
INSERT INTO hibernate_sequence values ('defaultSeqId', 1000);
CREATE TABLE player (ID INTEGER not null primary key,PLAYERID INTEGER not null,FIRSTNAME VARCHAR(50) not null,NAME VARCHAR(50) not null,SEX VARCHAR(11) not null,LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null);
CREATE TABLE tournament( ID INTEGER not null primary key,NAME VARCHAR(50) not null,start_dat DATE not null,URL VARCHAR(100) not null,LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null );
CREATE TABLE section( ID INTEGER not null primary key,tournament_id INTEGER not null, NAME VARCHAR(50) not null,URL VARCHAR(100) not null,LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null );