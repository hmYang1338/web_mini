drop table users;
drop table arrivalinfo;
drop table departinfo;


create table users (
    id varchar2(30) primary key,
    pw varchar2(30) not null,
    name varchar2(30) not null,
    email varchar2(100) not null
);

CREATE TABLE arrivalInfo ( 
  aFLIGHTID VARCHAR2(30) NOT NULL,
  aSCHEDULEDATETIME varchar2(30) NOT NULL,
  AIRLINE VARCHAR2(30),
  AIRPORT VARCHAR2(30),
  primary key (aflightid, ascheduledatetime)
);   
    
CREATE TABLE departInfo ( 
  dFLIGHTID VARCHAR2(30) NOT NULL,
  dSCHEDULEDATETIME varchar2(30) NOT NULL,
  AIRLINE VARCHAR2(30),
  AIRPORT VARCHAR2(30),
  primary key (dflightid, dscheduledatetime)
);   

CREATE SEQUENCE bookingCode START WITH 1 INCREMENT BY 1 MAXVALUE 10000 CYCLE NOCACHE;
create table bookingInfo (
    bookingCode number not null, 
    id varchar2(30) not null,
    dflightid varchar2(30) not null,
    dscheduledatetime varchar2(30) not null,
    aflightid varchar2(30) not null,
    ascheduledatetime varchar2(30) not null,
    primary key(bookingCode),
    foreign key (id) references users(id),
    foreign key (dflightid, dscheduledatetime) references departinfo(dflightid, dscheduledatetime),
--    foreign key (dscheduledatetime) references departinfo(dscheduledatetime),
    foreign key (aflightid, ascheduledatetime) references arrivalinfo(aflightid, ascheduledatetime)
--    foreign key (ascheduledatetime) references arrivalinfo(ascheduledatetime)
);


desc ARRIVALINFO;
desc DEPARTINFO;
desc users;
select * from arrivalinfo;
select * from departinfo;
select * from bookingInfo;


 