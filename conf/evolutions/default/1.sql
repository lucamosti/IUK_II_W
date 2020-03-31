# Book schema
# ---!Ups
create table book (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255),
    isbn13 varchar(17),
    isbn10 varchar(10),
    description varchar(255),
    publisher varchar(50),
    pages int,
    PRIMARY KEY (id)
    );

# ---!Downs
drop table book;
