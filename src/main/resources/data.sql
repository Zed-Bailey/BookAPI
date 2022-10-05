-- imports all the data from the books.csv file and creates an in-memory h2 database
drop table Books;
create table Books as select * from CSVREAD('classpath:/books.csv');