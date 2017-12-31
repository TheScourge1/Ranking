CREATE TABLE hibernate_sequence ( sequence_name varchar(255), next_val integer );
INSERT INTO hibernate_sequence values ('defaultSeqId', 1000);
CREATE TABLE player (ID INTEGER not null primary key,playerid INTEGER,profile_id VARCHAR(36),FIRSTNAME VARCHAR(50) not null,NAME VARCHAR(50) not null,SEX VARCHAR(11) not null,LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null);
CREATE TABLE tournament( ID INTEGER not null primary key,NAME VARCHAR(50) not null,TYPE VARCHAR(1),start_dat DATE not null,toernooinl_id VARCHAR(100) not null,LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null );
CREATE TABLE event( ID INTEGER not null primary key,tournament_id INTEGER not null, NAME VARCHAR(50) not null,sortorder INTEGER,toernooinl_id VARCHAR(100) not null,LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null );
CREATE TABLE draw( ID INTEGER not null primary key,event_id INTEGER not null, NAME VARCHAR(50) not null,sortorder INTEGER,draw_type VARCHAR(10), LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null );
CREATE TABLE game( ID INTEGER not null primary key,draw_id INTEGER not null,player1TeamA_id INTEGER,player2TeamA_id INTEGER,player1TeamB_id INTEGER,player2TeamB_id INTEGER, status VARCHAR(10), game_results VARCHAR(30),game_date DATE, LAST_UPDATE_DAT DATE not null,CREATE_DAT DATE not null );
