CREATE TABLE admin(
	 id INT NOT NULL,
	 username varchar(255),
	 password varchar(255),
	 PRIMARY KEY (id)	
);

ALTER TABLE admin
MODIFY  id INT NOT NULL  AUTO_INCREMENT;


insert into admin(username,password)values("aaa","aaa");
insert into admin(username,password)values("bbb","bbb");
insert into admin(username,password)values("ccc","ccc");
insert into admin(username,password)values("ddd","ddd");
insert into admin(username,password)values("eee","eee");
insert into admin(username,password)values("fff","fff");