create database hospital;
use hospital;

create table user(
	id int primary key auto_increment,
	account varchar(20) not null,
	password varchar(20) not null
);

create table depclass(
	id int primary key auto_increment,
	name varchar(20) not null,
	createTime datetime,
	modifyTime datetime	
);

create table dep(
	id int primary key auto_increment,
	name varchar(20) not null,
	did int,
	createTime datetime,
	modifyTime datetime	
);

alter table dep add constraint fk_staff_dep foreign key(did) references depclass(id);

insert user(account,password) values("cyj","123456");
insert depclass(id,name) values(1,"外科");
insert depclass(id,name) values(2,"内科");

insert dep(name,did) values("小儿内科",2);
insert dep(name,did) values("肾内科",2);
insert dep(name,did) values("消化内科",2);