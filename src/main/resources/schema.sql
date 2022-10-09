drop table if exists Books;
create table Books
(
    BOOKID             INT primary key auto_increment,
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