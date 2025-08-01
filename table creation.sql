use Samples
select * from Stud;
select count(*) as tot_student from Stud;
select max(year) as max_yr from Stud;
select min(year) as min_yr from Stud;
select avg(year) as av_yr from Stud;
select deparment,count(*) as dept_count from Stud group by deparment;
select deparment,max(year) as max_yr from Stud group by deparment;
select * from Stud
order by year asc;
select  * from stud
order by name;
select * from Stud
order by deparment desc;
select upper(deparment) as dep_upr from Stud;
select upper (name) as name_up from Stud;
select lower (name) as name_up from Stud;
select left (name,2) as srt from Stud;
select name,length(name) as name_ln from Stud;
select concat(name,' - ',deparment)as combine from Stud;
select name,year,year + 1 as nx_yr from Stud;
select reg_no,mod(reg_no,2) as odr from Stud;
alter table Stud
add date_detail date;
select * from Stud;
update Stud set date_detail='2021-08-18' where reg_no=111;
update Stud set date_detail='2021-08-18' where reg_no=122;
update Stud set date_detail='2021-08-18' where reg_no=124;
update Stud set date_detail='2021-08-18' where reg_no=130;
select curdate();
select reg_no,name,year,(date_detail) as yr from Stud;