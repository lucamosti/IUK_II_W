# Book schema
# --- !Ups
create table book (
id bigint(20) NOT NULL AUTO_INCREMENT,
title varchar(255)
PRIMARY KEY (id)
);
# --- !Downs
drop table book;