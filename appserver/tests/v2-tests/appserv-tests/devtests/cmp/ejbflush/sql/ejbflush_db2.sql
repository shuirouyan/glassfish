DROP TABLE FLUSHTEST1;
DROP TABLE FLUSHTEST2;

CREATE TABLE FLUSHTEST1
(
    id     VARCHAR(3)          PRIMARY KEY NOT NULL,
    name   VARCHAR(5)
);

CREATE TABLE FLUSHTEST2
(
    id     VARCHAR(3)          PRIMARY KEY NOT NULL,
    name   VARCHAR(5)
);

commit;

quit;
