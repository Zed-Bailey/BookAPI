-- imports all the data from the books.csv file and creates an in-memory h2 database
drop table if exists Books;
-- create table Books as select * from CSVREAD('classpath:/books.csv');

create table Books
(
    BOOKID             INT PRIMARY KEY,
    TITLE              TEXT,
    AUTHORS            TEXT,
    AVERAGE_RATING     DOUBLE,
    ISBN               TEXT,
    ISBN13             TEXT,
    LANGUAGE_CODE      TEXT,
    NUM_PAGES          INT,
    RATINGS_COUNT      INT,
    TEXT_REVIEWS_COUNT INT,
    PUBLICATION_DATE   DATE,
    PUBLISHER          TEXT
);

insert into Books(BOOKID,
                  TITLE,
                  AUTHORS,
                  AVERAGE_RATING,
                  ISBN,
                  ISBN13,
                  LANGUAGE_CODE,
                  NUM_PAGES,
                  RATINGS_COUNT,
                  TEXT_REVIEWS_COUNT,
                  PUBLICATION_DATE,
                  PUBLISHER)
select BOOKID,
       TITLE,
       AUTHORS,
       AVERAGE_RATING,
       ISBN,
       ISBN13,
       LANGUAGE_CODE,
       NUM_PAGES,
       RATINGS_COUNT,
       TEXT_REVIEWS_COUNT,
       parsedatetime("PUBLICATION_DATE", 'M/d/y'),
       PUBLISHER
from CSVREAD('classpath:/books.csv', null);