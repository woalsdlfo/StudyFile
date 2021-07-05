
--create ������ Member ���̺� �����ϱ�
create table Member(
  id varchar2(10) primary key,
  name varchar2(50),
  height number(5),
  weight number(5),
  age number(5)
);

desc Member;

--Member ���̺� ȸ�� ������ �߰��Ѵ�.
insert into Member(id,name, height,weight,age)
values('0001','ȫ�浿',188,64,24);

insert into Member
values('0002','�Ӳ���',177,56,31);


select * from Member;

commit;

--select�� �ǽ�
select * from Member;

select name from Member;

select id,name,age from Member;

select * from Member
order by height; --���� �������� �����ؼ� ����϶�.


--������ �ִ� select��
select * from Member
where
name='ȫ�浿';

select * from Member
where
age >30;

select * from Member
where
(height >175 and age >30)
 or weight<70;
 
 --update ��
 update Member
 set age=20;
 
 select * from Member;
 rollback;
 
 --ȫ�浿 ȸ���� ���̸� 30��� �����϶�.
 update Member
 set age=30
 where
 name='ȫ�浿';
 commit;

--delete ��
delete from Member;
select * from Member;
rollback;

delete from Member
where
name='ȫ�浿';
commit;
