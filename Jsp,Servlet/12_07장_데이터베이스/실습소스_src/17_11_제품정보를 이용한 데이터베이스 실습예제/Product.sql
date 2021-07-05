
--제품 정보를 저장할 제품 테이블을 생성 한다.
create table Product(
  prodCode  varchar2(10) primary key,
  prodName varchar2(30),
  prodColor varchar2(20),
  prodQty  number(5)  
);




desc Product;

select * from Product;

delete from Product;
commit;