select * from member;
create table member(
			id varchar2(20) primary key,
			pw varchar2(20),
			name varchar2(20),
			reg_date varchar2(20),
			ssn varchar2(10)
			);
-- CREATE(ROW)			
insert into member(id,pw,name,reg_date,ssn)values('lee2','1','이순신','2016-07-01','900101-1');
insert into member(id,pw,name,reg_date,ssn)
values('hong2','1','홍길동','2015-07-01','991201-1');
insert into member(id,pw,name,reg_date,ssn)
values('you','1','유관순','2014-07-01','010701-4');
-- READ
select * from member; -- list
select * from member where id = 'hong'; -- findByPK
select * from member where gender = '남'; -- findByNotPK
select count(*) from member; --count 
-- UPDATE
update member set pw = '999'
where id = 'hong';
-- DELETE
delete from member where id = 'you';

