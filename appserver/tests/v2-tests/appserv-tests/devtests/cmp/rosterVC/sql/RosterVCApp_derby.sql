DROP TRIGGER T_LEAGUE;
DROP TRIGGER T_PLAYER;
DROP TRIGGER T_TEAM;

DROP TABLE TEAMPLAYER;
DROP TABLE PLAYER;
DROP TABLE TEAM;
DROP TABLE LEAGUE;

CREATE TABLE PLAYER 
(
	PLAYER_ID VARCHAR(255) 	PRIMARY KEY NOT NULL, 
	NAME VARCHAR(255), 
	POSITION VARCHAR(255), 
	SALARY DOUBLE PRECISION NOT NULL,
    VERSION NUMERIC(19)     	NOT NULL
);

CREATE TABLE LEAGUE 
(
	LEAGUE_ID VARCHAR(255) 	PRIMARY KEY NOT NULL, 
	NAME VARCHAR(255), 
	SPORT VARCHAR(255),
    	VERSION NUMERIC(19)     	NOT NULL
);

CREATE TABLE TEAM 
(
	TEAM_ID VARCHAR(255) 	PRIMARY KEY NOT NULL, 
	CITY VARCHAR(255), 
	NAME VARCHAR(255),
	LEAGUE_ID VARCHAR(255),
    VERSION NUMERIC(19)     	NOT NULL,
	FOREIGN KEY (LEAGUE_ID) REFERENCES LEAGUE (LEAGUE_ID)
);

CREATE TABLE TEAMPLAYER 
(
	PLAYER_ID VARCHAR(255) 	NOT NULL, 
    TEAM_ID VARCHAR(255) 	NOT NULL, 
    CONSTRAINT PK_TEAMPLAYER PRIMARY KEY (PLAYER_ID, TEAM_ID),
	FOREIGN KEY (TEAM_ID)   REFERENCES TEAM (TEAM_ID),
	FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER (PLAYER_ID)
);

CREATE TRIGGER T_LEAGUE
      AFTER UPDATE ON LEAGUE
   REFERENCING
            OLD AS O_ROW
   FOR EACH ROW MODE DB2SQL
   UPDATE LEAGUE SET version = O_ROW.version + 1
	   WHERE LEAGUE_ID = O_ROW.LEAGUE_ID
;


CREATE TRIGGER T_PLAYER
      AFTER UPDATE ON PLAYER
   REFERENCING
            OLD AS O_ROW
   FOR EACH ROW MODE DB2SQL
   UPDATE PLAYER SET version = O_ROW.version + 1
	   WHERE PLAYER_ID = O_ROW.PLAYER_ID
;

CREATE TRIGGER T_TEAM
      AFTER UPDATE ON TEAM
   REFERENCING
            OLD AS O_ROW
   FOR EACH ROW MODE DB2SQL
   UPDATE TEAM SET version = O_ROW.version + 1
	   WHERE TEAM_ID = O_ROW.TEAM_ID
;
