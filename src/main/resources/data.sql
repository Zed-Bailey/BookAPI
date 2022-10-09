-- create table Books as select * from CSVREAD('classpath:/books.csv');

-- imports all the data from the books.csv file and creates an in-memory h2 database
insert into Books (BOOKID,
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
from CSVREAD('classpath:/books.csv');