DROP TRIGGER T_UNKNOWNPKVC1;
DROP TRIGGER T_UNKNOWNPKVC2;

DROP TABLE UNKNOWNPKVC1;
DROP TABLE UNKNOWNPKVC2;

CREATE TABLE UNKNOWNPKVC1
(
    ID     NUMBER(38)          	PRIMARY KEY,
    NAME   VARCHAR2(32) 	NULL,
    VERSION   NUMBER(19)  	NOT NULL
);

CREATE TABLE UNKNOWNPKVC2
(
    ID     NUMBER(38)          	PRIMARY KEY,
    NAME   VARCHAR2(32) 	NULL,
    VERSION   NUMBER(19)  	NOT NULL
);

commit;

CREATE TRIGGER T_UNKNOWNPKVC1
   BEFORE UPDATE ON UNKNOWNPKVC1
   FOR EACH ROW
       WHEN (NEW.VERSION = OLD.VERSION)
   BEGIN
       :NEW.VERSION := :OLD.VERSION + 1;
   END;
/

CREATE TRIGGER T_UNKNOWNPKVC2
   BEFORE UPDATE ON UNKNOWNPKVC2
   FOR EACH ROW
       WHEN (NEW.VERSION = OLD.VERSION)
   BEGIN
       :NEW.VERSION := :OLD.VERSION + 1;
   END;
/

commit;

quit;
