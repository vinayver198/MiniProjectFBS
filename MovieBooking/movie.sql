drop table movie_master cascade constraint;

Create table movie_master(
movie_id varchar2(5) primary key,movie_name varchar2(40),
theatre_name varchar2(20),theatre_location varchar2(20),
city varchar2(20),
show_timing varchar2(10),
status varchar2(30) CHECK (status IN('Available','NotAvailable')));

Insert into movie_master values('m001','Krish 3','RMall','Ghodbander Road','Thane','9:00 a.m.','Available');
Insert into movie_master values('m002','Dhoom','RCity','Sinhagad Road','Pune','12:00 p.m.','Available');
Insert into movie_master values('m003','Dangal','Star Cinema','MG Road','Thane','9:00 a.m.','Available');
Insert into movie_master values('m004','Ishq','RMall','Kouth Road','Pune','3:00 p.m.','Available');
Insert into movie_master values('m005','Krish 3','Star Cinema','Bhivandi Road','Thane','12:00 p.m.','Available');
Insert into movie_master values('m006','Dhoom','RMall','Ghodbander Road','Thane','3:00 p.m.','Available');
Insert into movie_master values('m007','Ishq','RCity','Satara Road','Pune','12:00 p.m.','Available');

commit;

select * from movie_master;