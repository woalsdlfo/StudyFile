
--create 문으로 Member 테이블 생성하기
create table Member(
  id varchar2(10) primary key,
  name varchar2(50),
  height number(5),
  weight number(5),
  age number(5)
);

desc Member;

--Member 테이블에 회원 정보를 추가한다.
insert into Member(id,name, height,weight,age)
values('0001','홍길동',188,64,24);

insert into Member
values('0002','임꺽정',177,56,31);


select * from Member;

commit;

--select문 실습
select * from Member;

select name from Member;

select id,name,age from Member;

select * from Member
order by height; --내림 차순으로 정렬해서 출력하라.


--조건이 있는 select문
select * from Member
where
name='홍길동';

select * from Member
where
age >30;

select * from Member
where
(height >175 and age >30)
 or weight<70;
 
 --update 문
 update Member
 set age=20;
 
 select * from Member;
 rollback;
 
 --홍길동 회원의 나이를 30살로 변경하라.
 update Member
 set age=30
 where
 name='홍길동';
 commit;

--delete 문
delete from Member;
select * from Member;
rollback;

delete from Member
where
name='홍길동';
commit;
