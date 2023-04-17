DROP TABLE IF EXISTS books;

CREATE TABLE books;
(
    id              bigint       NOT NULL,      PRIMARY KEY     AUTO_INCREMENT,
    title           varchar(255) NOT NULL,
    author          varchar(255) NOT NULL,
    publicationYear int          NOT NULL,
)