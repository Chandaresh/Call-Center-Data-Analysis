use call_center;
create table Data(Id integer,
From_number varchar(10) ,
Start_time datetime,
End_time   datetime,
ST time,
ET time,
Dur Integer,
C_Date date,
day integer,
Hour integer);
desc data;
insert into data values(1,'9999900000','2021-01-13 06-00-05','2021-01-13 06-23-06',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(2,'9999902010','2021-01-13 06-12-49','2021-01-13 06-14-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(3,'9991323232','2021-01-13 07-02-49','2021-01-13 07-14-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(4,'8484848484','2021-01-13 08-12-49','2021-01-13 08-14-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(5,'9378373737','2021-01-13 10-12-49','2021-01-13 10-14-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(6,'9837373737','2021-01-13 12-12-49','2021-01-13 12-14-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(7,'9973737373','2021-01-13 15-12-49','2021-01-13 15-14-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(8,'9373737373','2021-01-13 15-22-49','2021-01-13 15-34-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
insert into data values(9,'7773737373','2021-01-13 15-45-49','2021-01-13 15-54-44',
time(Start_time),time(End_time),TIME_TO_SEC(SUBTIME(ET,ST)),date(Start_time),
DAYOFWEEK(C_Date),hour(ST));
select * from data;

