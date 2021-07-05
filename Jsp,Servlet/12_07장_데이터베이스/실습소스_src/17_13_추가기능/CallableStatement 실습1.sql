
create or replace package types
as
    type cursorType is ref cursor;
end;

create or replace function f_list_mem return types.cursortype
as
    l_cursor    types.cursorType;
begin
    open l_cursor for select id, name from Member order by id;
    return l_cursor;
end;


create or replace function f_list_mem1(
   v_name in Member.name%type
)
return types.cursortype
as
    l_cursor    types.cursorType;
begin
    open l_cursor for 
      select id, name 
      from Member 
      where name=UPPER(v_name)
      order by id;
    return l_cursor;
end;



create or replace PROCEDURE p_list_member
 (in_id in varchar2, 
 out_name OUT varCHAR2, 
 out_age OUT NUMBER)
is
BEGIN
  SELECT 
   name,
   age
  INTO 
  out_name, 
  out_age
  FROM Member
  WHERE id=in_id;
end;

select * from Member
where name='¿”≤©¡§';