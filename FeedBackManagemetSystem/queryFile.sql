
drop table feedback_master;

create table feedback_master(training_code number(5),participant_id number(5),
fb_prs_comm number(1),
fb_clrfy_dbts number(1),
fb_tm number(1),
fb_hnd_out number(1),fb_hw_sw_ntwrk number(1),
comments varchar2(200),suggestions varchar2(200),
feedback_date date );

CREATE table Employee_master(Employee_ID number (5),Employee_name Varchar2(50),Password Varchar2(20),Role Varchar2(20));

CREATE TABLE TRAINING_PROGRAM (TRAINING_CODE NUMBER(5,0), 
	 COURSE_CODE NUMBER(5,0), 
	 FACULTY_CODE NUMBER(5,0), 
	 START_DATE DATE, 
	 END_DATE DATE);
   
   CREATE SEQUENCE TRAININGPROG_seq START WITH 10000;
   
   CREATE table course_master(course_id number (5),course_name Varchar2(50),no_days number(2));