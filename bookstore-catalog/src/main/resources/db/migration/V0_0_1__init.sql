CREATE TABLE BOOK (ID BINARY(255) NOT NULL, AUHTOR_FIRSTNAME VARCHAR(255), AUTHOR_LASTNAME VARCHAR(255), ISBN VARCHAR(255) NOT NULL, TITLE VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE STOCK (ID BINARY(255) NOT NULL, BOOK_ID BINARY(255) NOT NULL, QUANTITY INTEGER NOT NULL, PRIMARY KEY (ID));
ALTER TABLE BOOK ADD CONSTRAINT BOOK_UNIQUE_ISBN UNIQUE (ISBN);
