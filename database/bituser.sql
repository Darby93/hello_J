/*
[1���� ����]
1. ����Ŭ ����Ʈ���� �ٿ�ε�
https://www.oracle.com/technetwork/database/enterprise-edition/downloads/index.html

2. 

3. Oracle ��ġ(SYS, SYSTEM ������ ���� ��ȣ : 1004)

4. Sqlplus ���α׷� ����(CMD) : GUI ȯ�� �Ϲݰ����� ��� ����

5. ������ Tool ��ġ ���� (SqlDeveloper), ����(���, ������, SqlGate)

6. SqlDeveloper ���� ���ؼ� Oracle Server ����.....
  >> HR ���� : ��ȣ 1004, Unlock 2���� ��밡�� ...(������� �ǽ� ���̺�)
  
  -- USER SQL
CREATE USER "bituser" IDENTIFIED BY "1004"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS
ALTER USER "bituser" QUOTA UNLIMITED ON "USERS";

-- ROLES
GRANT "CONNECT" TO "bituser" WITH ADMIN OPTION;
GRANT "RESOURCE" TO "bituser" WITH ADMIN OPTION;
ALTER USER "bituser" DEFAULT ROLE "CONNECT","RESOURCE";

-- SYSTEM PRIVILEGES

7. ���� ���� ���� Ȯ�� : show user;

CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

COMMIT;

CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;



CREATE TABLE SALGRADE
( GRADE number,
LOSAL number,
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;


*/

select * from emp;
select * from dept;
select * from salgrade;


-- ������ ROW
-- ������ CALUME

--1. ������̺��� ��� �����͸� ����ϼ���
select * from emp; --���������� ��ҹ��ڸ� �������� �ʽ��ϴ�
SELECT * FROM DEPT;
select * from galgrade;

--2. Ư�� �÷� ������ ����ϱ�
SELECT empno , ename , sal FROM emp; 

--3. �÷��� ����Ī(��Ī)(alias) �ο��ϱ�

select empno ���, ename �̸�
from emp;

select empno "��    ��", ename "��   ��" 
from emp;

--����(ansi ����)   as������ �ڿ� ��Ī 
select empno as"��    ��", ename as"��   ��" 
from emp;

--Oracle ������ ���ڿ� (���ڿ� �����ʹ� ��ҹ��� ����)
--���ڿ� ǥ�� '���ڿ�'
-- �ҹ��� : a �빮�� : A     �ٸ� ���� ���
select empno, ename from emp where ename='king'; --�̰� �ȳ���

select empno, ename from emp where ename='KING';

--Java : + (���� + ���� ����)
--Java : + (���ڿ� + ���ڿ� ����)
 
--Oracle SQL : ������(���� ������(||)�� ��� ������(+) ����)
--TIP)ms - sql + (����, ����)

select '����� �̸���'|| ename ||'�Դϴ�' as "�������"
from emp;

--���̺� �÷��� �⺻ Ÿ��
--�÷��� Ÿ�� ����, ����, ��¥
desc emp;
--���̺��� �⺻������ �� �� ����

--number || varchar ���������� ����ȯ(����->����) ����
select empno || ename 
from emp;

--invalid number ������ϴ� Ÿ���� ���� �ʾƼ� ������� �Ұ�
select empno + ename 
from emp;

-- ����� �츮 ȸ�翡 ������ ��� �ֳ���
-- distinct : �ߺ� ������ ����
-- distinct ���� : grouping
select distinct job from emp; 

-- ��̻�Ƽ� --------
select distinct job ,deptno from emp order by job;
select distinct deptno ,job from emp order by deptno;

---------------------------------------------------------------------

--JAVA ��� (������)
--JAVA ��� ���� ���� (+,*,-,...) % : ������
--Oracle (SQL ���) % : �˻� ���� // ����Ŭ������ ������ ���ϴ� �����ڰ� X : 
--MOD()�Լ��� ������ ����

--�������(+,*,-,/...),MOD()�Լ� �������� ���Ѵ�

--������̺��� ����� �޿��� 100�޷� �λ��� ����� ����ϼ���
desc emp; 
--SAL NUMBER
select empno, sal, sal+100 as "�λ�޿�" from emp; 

select 100 + 100 from dual; --200
select 100 || 100 from dual; --100100 (����ȯ)
select '100' + 100 from dual; --200   ( + �� ������ �����) ���� -> ����
select 'A100' + 100 from dual; --��������  ���ڷ� ���ٲ�

--�񱳿�����
-->,<,<=
--JAVA ���� (==) �Ҵ� (=)
--Oracle ����(=) �����ʴ�(!=)

--�� ������
--AND, OR, NOR

--������ (���ϴ� row ������ ���ڴ�)
select *
from emp
where sal >= 3000;

select empno, ename, sal
from emp
where sal >= 3000;

--�̻�, ����(=����)
--�ʰ�, �̸�

--����� 7788���� ����� ���, �̸�, ����, �Ի���
--������� : emp
select empno, ename, job, hiredate --3
from emp                     --1
where empno=7788;            --2

--����� �̸��� king ����� ���, �̸�, �޿�����
select ename, empno, sal
from emp
where ename='KING';

--�޿��� 2000�޷� �̻��̸鼭 ������ manager �� ����� ��� ������ ����ϼ���
--�ΰ��� ������ ��� ����(�Ѵ� ����)
select *
from emp
where SAL>=2000 AND JOB = 'MANAGER';

--�޿��� 2000�޷� �̻��̸鼭 ������ manager �� ����� ��� ������ ����ϼ���
--�ΰ��� ������ �ϳ��� ���̿��� ���
select *
from emp
where SAL>=2000 OR JOB = 'MANAGER';

-----------------------------------------------------------------------
--����Ŭ ��¥ (DB ������ ��¥)
--����Ŭ ��¥ (sysdate)
--��� �ý��� ��¥ ����
--�Խ��� �۾���
--insert into board(write, title, content, regdate) values('ȫ�浿','�氡,'����Ŀ�',sysdate)
--TIP)ms - sql : select getdate()

select sysdate from dual;
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
select hiredate from emp;

--����Ŭ �ý��� ���̺�...
select * from SYS.NLS_SESSION_PARAMETERS;
--NLS_DATE_FORMAT	YYYY-MM-DD HH24:MI:SS
--NLS_DATE_LANGUAGE	KOREAN
--NLS_TIME_FORMAT	HH24:MI:SSXFF

--����Ŭ ��¥ ��ȸ : '2019-12-12'  
select * from emp
where hiredate = '1980-12-17';

select * from emp
where hiredate = '1980/12/17';

select * from emp
where hiredate = '80/12/17'; --�̰� �ȵǿ�
--���� : RR-MM-DD > YYYY-MM-DD

--����� �޿��� 2000�޶� �̻��̰� 4000������ ��� ����� ������ ����ϼ���
desc emp; --SAL NUMBER

select *
from emp
where SAL >=2000 AND SAL <=4000;

--������ : between A and B (=����)
--���ǻ��� : �̸� �ʰ� �� ��� ����
select *
from emp
where sal between 2000 and 4000;

--����� �޿��� 2000�ʰ� 4000 �̸��� ��� ����� ������ ����ϼ���
select *
from emp
where SAL >2000 AND SAL <4000;

--�μ���ȣ�� 10�� �Ǵ� 20�� �Ǵ� 30���� ����� ���, �̸�, �޿�, �μ���ȣ�� ����ϼ���
select empno, ename, sal, deptno
from emp
where deptno=10 or deptno=20 or deptno=30;

--IN ������ (���� OR ���� OR .....)
select empno, ename, sal, deptno
from emp
where deptno in(10,20,30); --deptno=10 or deptno=20 or deptno=30;

--�μ���ȣ�� 10�� �Ǵ� 20���� �ƴ� ����� ���, �̸�, �޿� , �μ���ȣ�� ����ϼ���
select *
from emp
where deptno !=10 and deptno !=20;

--NOT IN ������ (������ and ������ and ...)
select *
from emp
where deptno NOT IN(10,20); --not in�� Ǯ����� -> deptno !=10 and deptno !=20;9

--POINT : Oracle ���� ����(������ ����) null
--null (�ʿ��)

create table member(
  userid varchar2(20) not null, --�ѱ� 10��  ���� ������ �����Ѵ� not null
  name varchar2(20) not null,  --not null �ʼ��Է»���
  hobby varchar2(50)           -- default���� null �ɼ�  �ᵵ �ǰ� �Ƚᵵ �ǰ�
);

desc member;
insert into member(userid,hobby) values('hong', '��'); --����ȵ� (name�÷���...)
insert into member(userid,name) values('hong', 'ȫ�浿');
insert into member(userid,name,hobby) values('hong', 'ȫ�浿','��');

select *
from member;

insert into member(userid,name,hobby) values('kim','�达','����');

select *
from member;

delete from member where userid = 'kim';

--�����ݿ�
commit;

--����(comm)�� ���� �ʴ� ��� ����� ������ ����ϼ���
--O�� ������ ���(�޴� ���� ����)
--comm �÷��� �����Ͱ� null�ΰ͸� ���
select * from emp where comm = null; --�ȵǿ�(x)

--null �� �񱳴� (is null, is not null)
select * from emp where comm is null;

--����(comm)�� �޴� ��� ����� ������ ����ϼ���
select * from emp where comm is not null;

--������̺��� ���, �̸�, �޿�, ����, �ѱ޿��� ����ϼ���
--�ѱ޿� (�޿� + ����)
select empno,ename,sal,comm,sal+comm as "�ѱ޿�"
from emp; 



select empno,ename,sal,comm,sal+nvl(comm,0) as "�ѱ޿�"
--nvl(a,b) a���� null���� ���ٸ� b�� �ٲ��
from emp; 

--POINT null
--1. null ���� ��� ������ null
--2. �� ���� �ذ� : �Լ�nvl(),nvl2() >>TIP ms-sql : convert()
                                      --my-sql : IFNULL() : null�� ��ü...

select 1000 + null from dual;
select 1000 + nvl(null,0) from dual;
select comm as "����", nvl(comm,1111) from emp;

--����� �޿��� 1000 �̻��̰� ������ ���� �ʴ� ����� ���, �̸�, ����, �޿�, ���� ���
select empno,ename,job,sal,comm
from emp
where sal >= 1000 AND comm is null;

commit;

-----------------------------------------------------------
--DQL(data query language): SELECT
--DDL(������ ���Ǿ�) : creat, alter, drop... (��ü ����, ����, ����)

--create Board(boardno number...
--JAVA : class Board (private  int boardno)

create table Board (
  boardid number not null, --����, �ʼ��Է�
  title varchar2(20) not null, --�ѱ� 10��, ������, Ư������,���� 20��, �ʼ��Է�
  content varchar2(2000) not null, --�ѱ� 1000�� �ٸ��� 2000��, �ʼ��Է�
  hp varchar2(20) -- default null��� �ʼ� �Է� ���� (x)
);

desc Board;

--DML(������ ���ۿ� �ݿ� ���ο��� ���� (�ǹݿ�, ���) �ݵ�� ����
--insert, update, delete �۾�

insert into board(boardid, title, content)
values(100, '����Ŭ','�Ҹ��ϳ�');

select*from board;
--�ǻ���� : ���� �ݿ� �Ұž� (commit)
--�ǻ� ���� : ���� �ݿ� ���Ұž� (rollback)

rollback;
commit;

--insert ġ�� ���� default�� begin�� ����
--begin
insert into board(boardid, title, content)
values(200,'�ڹ�','�׸���');


insert into board(boardid, title, content)
values(300,'�ڹ�','�׸���');

--commit �Ѵٹݿ�
--rollback �Ѵ� ���

select * from board;
commit;
rollback;

select boardid, nvl(hp,'EMPTY') as "hp" from board;
--nvl �Լ��� ����, ��¥, ���ڿ� ��� ���� �����ϴ�....

------------------------------------------------------------------
--���ڿ� �˻�
--�ּҰ˻� : �˻��� : '����' -> ���� �ܾ �ִ� ��� ������ �ٳ��Ϳ�
--���ڿ� ���� �˻� ( Like ������ )

--like ������ ( ���ϵ� ī�� ���� ( % : ��� ��, _ : �ѹ���) ����....)

select *
from emp
where ename like '%A%'; --ename �÷��� �����Ϳ� A ����ִ� ��� �̸�.....

select *
from emp
where ename like '%a%'; --���ڿ� ������ ��ҹ��� �����ϰ� ����

select ename
from emp
where ename like 'A%'; --ù ���ڰ� A�� �����ϸ� ���

select ename
from emp
where ename like '���ȯ��%';

select ename
from emp
where ename like '%S'; --������ ���ڰ� S�� ������ ���

select ename
from emp
where ename like '%LL%';  

select ename
from emp
where ename like '%A%A%'; --A�� �ΰ��� ��������� ��ã�ƿ�

select ename
from emp
where ename like '_A%'; --ù���� ����� �͵� ��� ���� �ι�° ���ڴ� A���;���
-- WARD
-- MARTIN
-- JAMES

select ename
from emp
where ename like '_D%';

--����Ŭ ���� (regexp_like(e)�� �˻�
select * from emp where regexp_like(ename,'A-C');
--����ǥ����(java -> oracle -> javascript
--���� : ���� ǥ�� ���� 5�� ����� (ī�� �÷��帮�� �ϼ���)

--------------------------------------------------------------
--������ �����ϱ�
--order by �÷��� : ����, ����, ��¥
--�������� : asc : ������(default)
--�������� : desc : ������

select * from emp order by sal; -- default asc
select * from emp order by sal asc;

--�޿��� ���� �޴� ������ �����ؼ� ����ϼ���
select * from emp order by sal desc; 

select ename from emp order by ename asc; --���ĺ���   // ������ �����մϴ�

--�Ի����� ���� ���� ������ �����ؼ� ���, �̸�, �޿�, �Ի��� �����͸� ����ϼ���
--(���� �ֱٿ� �Ի��� ������)
select empno, ename, sal, hiredate 
from emp 
order by hiredate asc;

/*
�������
SELECT      3
FROM        1
WHERE      2
ORDER BY  4  (select ����� ����)
*/

--  emp ���̺��� �Ŵ����� ����߿��� ���, �̸�, ����, ��å, �Ի��� �����͸� �Ի簡 ���� ������ �����ؼ� ���
select empno, ename, sal, job, hiredate
from emp
where job = 'MANAGER'
order by hiredate desc;

-- order by �÷��� desc, �÷���, asc, �÷��� desc

--���� ���ĺ������� ������  ���ĺ����� ������� �ٽ� ����
select job, deptno
from emp
order by job asc, deptno desc;

---------------------------------------------------------------------------------------------------------
--������
--������(union) : ���̺�� ���̺��� �����͸� ��ġ�� �� (�ߺ����� ����)
--������(union all) : �ߺ����� ���

create table uta (name varchar2(20));

insert into uta(name) values('AAA');
insert into uta(name) values('BBB');
insert into uta(name) values('CCC');
insert into uta(name) values('DDD');
commit;

select * from uta;

create table ut(name varchar2(20));

insert into ut(name) values('AAA');
insert into ut(name) values('BBB');
insert into ut(name) values('CCC');
commit;

select * from ut;

--union  �ߺ�x
select * from ut
union
select * from uta; --ut ���̺� uta���̺��� ��

--union all �ߺ������� ����ħ
select * from ut
union all
select * from uta;

--union ��Ģ 
--1. �����Ǵ� �÷��� Ÿ���� �����ؾߵȴ�.
select empno, ename from emp
union
select dname, deptno from dept; -- Ÿ���� �޶� ����

select empno, ename from emp
union
select deptno, dname from dept; -- Ÿ���� ���Ƽ� �ǿ�

--�ǹ� ) subquery
select empno, ename
from (
            select empno, ename from emp
            union
            select deptno, dname from dept
          )order by empno desc;


--2. ������� �÷��� ������ ���� (null ���)
select empno, ename, job, sal from emp 
union
select deptno, dname, loc, null from dept;   --null ����ؼ� �÷� ���� ������

--��������� �ʺ������ڰ� �ǹ������� �ؾ��ϴ� (���� ���̺�) �������......
----------------------------------------------------------------------------------
--����Ŭ �Լ�  .....
select * from SYSNLS_DATABASE_PARAMETERS;
--NLS_CHARACTERSET : AL32UTF8 �ѱ� 3BYTE �ν�
--KO16KSC560 2BYTE (���� ��ȯ�ϸ� �ѱ� �ٱ���)
select * from rls_database_parameters where parameter like '%CHAR%';
-----------------------------------------------------------------------------------
-- [2����]
/*
1.2.2 ���� �� �Լ��� ����
1) ������ �Լ� : ���ڸ� �Է� �ް� ���ڿ� ���� �� ��θ� RETURN �� �� �ִ�.
2) ������ �Լ� : ���ڸ� �Է� �ް� ���ڸ� RETURN �Ѵ�.
3) ��¥�� �Լ� : ��¥���� ���� �����ϰ� ���ڸ� RETURN �ϴ� MONTHS_BETWEEN �Լ���
�����ϰ� ��� ��¥ ���������� ���� RETURN �Ѵ�.
4) ��ȯ�� �Լ� : � ���������� ���� �ٸ� ������������ ��ȯ�Ѵ�.
5) �Ϲ����� �Լ� : NVL, DECODE
*/



insert into study

--���ڿ� �Լ�
select initcap('the super man') from dual;  --ù ���ڸ� �빮�ڷ� �������

select lower('AAA'),upper('aaaa') from dual;

select ename, lower(ename) as "ename" from emp;

select * from emp where lower(ename) = 'king';

--���ڿ� ����
select length ('abcd') from dual; --4��
select length ('ȫ�浿') from dual; --3��

select length('ȫ o�� ��') from dual;

--���� ������
--concat()
select 'a' || 'o' || 'c' from dual;
select concat('a','b') from dual;

select concat(ename,job) from emp;
select ename||'     '|| job from emp;

--�κ� ���ڿ� ����
-- java - substring
-- oracle - substr
  -- substr('a',3,4) a���ڿ����� 3��° ��¥���� 4�� ���
select substr('ABCDE',2,3) from dual;  --BCD
select substr('ABCDE',1,1) from dual;  -- A
select substr('ABCDE',3,1) from dual; --C

select substr('ABCDE',3) from dual; --CDE
select substr('ABCDE',-2,1) from dual; --DE
select substr('ABCDE',-2,2) from dual; --DE

/*
������̺��� ENAME �÷� �����Ϳ� ���ؼ� ù���ڴ� �ҹ��ڷ� ������ ���ڴ� �빮�ڷ� ����ϵ�
�ϳ��� �÷����� ����ϼ���
- �÷��� ����Ī�� : fullname
- ù���ڿ� ������ ���� ���̿� ���� �ϳ��� ��������
*/

select lower(substr(ename,1,1)) 
from emp;

select upper(substr(ename,2)) 
from emp;

select lower(substr(ename,1,1))  ||' '||upper(substr(ename,2))  as "fullname" from emp;

--lpad, rpad (ä���)
select lpad('ABC',10,'*') from dual; --*******ABC
select rpad('ABC',10,'%') from dual; --%%%%%%%ABC

--Quiz
--����� ��� : hong1006
--ȭ�� : ho******** ����ϰ� �;�� (��� : 1004) 10**



select rpad(substr('hong1006',1,2),length('hong1006'),'*') as "password" from dual;
select rpad(substr('1004',1,2),length('1004'),'*')as "password"  from dual;

--emp ���̺��� ename �÷��� �����͸� ���
-- ù���ڸ� ����ϰ� �������� *

select rpad(substr(ename,1,1),length(ename),'*') from emp;

create table member2(
id number ,
jumin varchar2(14)
);

insert into member2(id,jumin) values(100,'123456-1234567');
insert into member2(id,jumin) values(200,'123457-1234567');
commit;

select * from member2;

--Quiz
--��°��
--�ϳ��� �÷����� ��� : 
--100 : 123456-*******
--200 : 234567-*******
--�÷��� ����Ī 'juminnumber'
select id ||' : '|| rpad(substr(jumin,1,7),length(jumin),'*') as "Juminnumber" from member2;

--rtrim �Լ�
--������ ���� ������

select rtrim('MILLER','ER') from dual;

select ltrim('MILLLLLER','MIL') from dual; --ER
select rtrim('MILLLLLER','IL') from dual;


select '>' || rtrim('MILLER    ',' ') ||'<' FROM DUAL; --��������

--ġȯ�Լ� (REPLACE)
select ename, replace(ename,'A','�Ϳ�') from emp;

--------------------------------------------------------------------------
--�����Լ�
--round (�ݿø��Լ�)
--trunc (�����Լ�)
--������ ���ϴ� �Լ� mod()


-- -3  -2  -1  0(����) 1  2  3
--round �ݿø�
select round(12.345,0) as "r" from dual; --12    0 = �����κи� ���ܶ�  
select round(12.567,0) as "r" from dual; --13

select round(12.345,1) as "r" from dual; -- �Ҽ����� ù°�ڸ� ���� ���ܶ� 12.3
select round(12.567,1) as "r" from dual; -- 12.6

select round(12.345,-1) as "r" from dual; --10 
select round(15.345,-1) as "r" from dual; --20
select round(12.345,-2) as "r" from dual; --0

--trunc �ݿø� ���� �ʰ� ����
select trunc(12.345,0) as "t" from dual; --12    0 = �����κи� ���ܶ�  
select trunc(12.567,0) as "t" from dual; --12

select trunc(12.345,1) as "t" from dual; -- �Ҽ����� ù°�ڸ� ���� ���ܶ� 12.3
select trunc(12.567,1) as "t" from dual; -- 12.5

select trunc(12.345,-1) as "t" from dual; --10 
select trunc(15.345,-1) as "t" from dual; --10
select trunc(12.345,-2) as "t" from dual; --0

--------------------------------------------------------------------------
select trunc(12.7234985349584329583924584329,1) from dual;
select round(12.7234985349584329583924584329,1) from dual;

--������ mod()
select 12/10 from dual;
select mod(12,10) from dual; --2
--a�� b�� ���� ������ 

select mod(0,0) from dual;


---------------------�����Լ� end------------------------------------------
---------------------------------------------------------------------------

--��¥ �Լ�
select sysdate from dual;
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
--��¥  ���� (POINT)
--DATE + NUMBER >> DATE
--DATE - NUMBER >> DATE
--DATE - DATE >> NUMBER

select * from SYS.NLS_SESSION_PARAMETERS;

SELECT HIREDATE FROM EMP;

select MONTHS_BETWEEN('2018-02-27','2010-02-27') from dual; --������ �� 96����

select MONTHS_BETWEEN(sysdate,'2010-01-01') from dual; --���� �������� trunc , round ����

select round(MONTHS_BETWEEN(sysdate,'2010-01-01'),1) from dual;
select trunc(MONTHS_BETWEEN(sysdate,'2010-01-01'),1) from dual;

select to_date('2019-03-20') + 1/24 from dual;
select to_date('2019-03-20') + 1000 from dual;
select  + 1000 from dual;


--Quiz1
--��� ���̺��� ������� �Ի��Ͽ��� ���糯¥���� �ټӿ����� ���ϼ���
--��, �ټӿ����� �����κи� ���⼼��
select ename, hiredate, trunc(MONTHS_BETWEEN(sysdate,hiredate),0) as "�ټӿ���" from emp;

--Quiz2
--�Ѵ��� 31 �� �̶�� ���ؿ��� �ټӿ����� ���ϼ���
select ename, hiredate, trunc((sysdate-hiredate)/31,0) as "�ټӿ���" from emp;
 
---------------------------��¥�Լ� end -------------------------------------------------------
--���� ..
--���� ..
--���� ..  �����Ģ�� �߿��ؿ�!
-----------------------------------------------------------------------------------------------
--[��ȯ�Լ�] Today POINT
--Oracle : ����, ����, ��¥
--to_char() : ���� -> ���� (1000 -> $1000) , ��¥ -> ���� (2019-03-03 -> 2019��03��03��)      ���ڶ� �����ҷ��� �� = ���� (format) �����Ϸ���

--to_date() : ���� -> ��¥ select '2019-03-03' + 1000 �׳��ϸ� �ȵ�   ��¥Ÿ������ ����ؾ� ����ε� to_date('2019-03-03') +1000

--to_number() : ���� -> ���� (�ڵ� ����ȯ �־ �߾Ⱦ�)
select '100'+ 100 from dual;
-- ���Ʒ� �����ž�
select to_number('100') + 100 from dual;

/*
����Ŭ �⺻ ������ Ÿ��
create table ���̺��(�÷��� Ÿ��)
create table member (age number); >> 1�� insert .. 1000��

Java : class person >> person p = new person(); 1��
         List<person> personlist = new ArrayList();  ����Ŭ ���̺��̶� ���̶���
         personlist.add(new person); 
Oracle : create person >> ������ ���� x

���� Ÿ��
--char(20) >> 20Byte >> �ѱ� 10�� / ������, Ư������, ���� 20�� : �������� ���ڿ�
--varchar2(20) >> 20Byte >> �ѱ� 10�� / ������, Ư������, ���� 20�� : �������� ���ڿ�

char(20) >> 'ȫ�浿' >> 6Byte >> char ���� ȫ�浿 - 20Byte �ȿ� ����
varchar2(20) >> 'ȫ�浿' >> ������ ũ�� ��ŭ Ȯ�� >> ȫ�浿 - 6Byte

�������� ������ : ��, ��
char(2) >>

���ɻ��� ���� >
char() - > varchar() �˻� �켱

�ᱹ ������ �ѱ� ....
unicode (2byte) : �ѱ� , ������, Ư������, ���� >> 2byte

nchar(20) >> �����ڵ� char  20���� >> 2*20 40byte
nvarchar2(30) >> 30����

*/
 
--1. to_number : ���ڸ� ���ڷ�
select '1' + 1 from dual;

select to_number('1') + 1 from dual;



--2. to_char() : ���� - > ���Ĺ���, ��¥ - > ���Ĺ���
alter session set nls_date_format='YYYY-MM-DD';

select to_char(sysdate) || '��' from dual;

select sysdate, to_char(sysdate,'YYYY') ||'��' as "YYYY",
To_char(sysdate,'YEAR'),
To_char(sysdate,'MM'),
To_char(sysdate,'DD'),
To_char(sysdate,'DAY'),
To_char(sysdate,'DY')
from dual;

/*
�Ի����� 12���� ������� ���, �̸�, �Ի���, �Ի�⵵, �Ի��
*/

select empno as "���", ename as "�����", to_char(hiredate,'DD')as "�Ի���",to_char(hiredate,'YYYY')as "�Ի�⵵",
to_char(hiredate,'MM')as "�Ի��"
from emp
where to_char(hiredate,'MM') = 12;

select to_char(hiredate, 'yyyy mm dd') from emp;



--to_char() : ���� -> ���Ĺ���
--1000000 -> $1,000,000,000 (�������·�)
--ǥ ����Ŭ.pdf 71page

select '>' ||to_char(12345,'9999999999999') ||'<' from dual;
select '>' ||to_char(12345,'09999999999999') ||'<' from dual;
--> 0000000123456<

select '>' ||to_char(12345,'$9,999,999,999') ||'<' from dual;
-->      $12.345< ����� ���� ������

select sal , to_char(sal,'$999,999') from emp;




/*
������̺��� ����� �̸��� last name, first name ���ļ� fullname ��Ī �ο��ؼ� ����ϰ�
�Ի����� YYYY-MM-DD �������� ����ϰ� ����(�޿�*12)�� ���ϰ� ������ 10%(����*1.1) �λ��� ����
����ϰ� �� ����� 1000���� �޸� ó���ؼ� ����ϼ���.
�� 2005�� ���� �Ի��ڵ鸸 ����ϼ���. �׸��� ������ ���� ������ ����ϼ���.+6+63

*/

select * from employees;




select 
employee_id,
last_name || first_name as "fullname",
to_char(hire_date, 'yyyy-mm-dd') as "hire_date", 
salary,
SALARY * 12 as "����", 
to_char((salary *12)*1.1,'$999,999,999') as "�λ��",
hire_date
from employees
where to_char(hire_date,'YYYY') >= '2005'
order by "����" desc;

----�ٽ� bituser �������� ��ȯ ----------------------------------------------------------------
---to_date() ���ڸ� - > ��¥��
select '2019-03-03' + 100 from dual;

select to_date('2019-03-03') + 100 from dual;
---------------------------------------------------------------------------------------------
--��ȯ�Լ� (to_date(), to_char(), to_number()

--�Ϲ��Լ� (���α׷����� ������ �����Լ�?)
--nvl(), nvl2() >> null ó�� �Լ�
--decode() �Լ�  >> java if ��
--case() �Լ� >> java switch �� 

select comm, nvl(comm,0) from emp;

create table t_emp(
  id number(6),
  job varchar2(20)
);

select * from t_emp;

insert into t_emp(id,job) values(100,'IT');
insert into t_emp(id,job) values(200,'SALES');
insert into t_emp(id,job) values(300,'MGR');
insert into t_emp(id) values(400);
insert into t_emp(id,job) values(500,'MGR');
commit;

--1. nvl
select id, job, nvl(job,'Empty') from t_emp;

--2. nvl2 >> null �� ���� null�� �ƴ� ���
--nul2(a,b,c)  a�÷�����  null���� �ƴϸ� b�� ���� null���̸� c�� ����

select id,job,nvl2(job,job||'�Դϴ�','empty') from t_emp;

select id, job, nvl2(job,'aaa','bbb') from t_emp;

--3. decode Point(��� ������) : java if, switch
--decode(  ǥ����, ����1, ���1, ����2, ���2, ����3, ���3 ............)
select id, job, decode(id,100, 'IT...',
                                    200,'SALES.....',
                                    300, 'MGR...',
                                    'ETC...') as "decodejob"
from t_emp;

select job , decode(job, 'IT',1) from t_emp;
--IT���ƴϸ� NULL��

select count(decode(job,'IT',1)) AS "IT",
          count(decode(job,'SALES',1)) AS "SALES",
          count(decode(job,'MGR',1)) AS "MGR"
from t_emp;

/*
emp ���̺��� �μ���ȣ�� 10�̸� '�λ��', 20�̸� '������', 30�̸� 'ȸ���'
������ �μ��� '��Ÿ�μ�' ��µǴ� ������ ���弼��
*/

select decode(deptno,'10','�λ��',
                               '20','������',
                               '30','ȸ���',
                               '��Ÿ�μ�') AS "�μ�"
FROM emp;
          
--Quiz2
create table t_emp2(
id number(2),
jumin char(7)
);

insert into t_emp2(id, jumin) values(1,'1234567');
insert into t_emp2(id, jumin) values(2,'2234567');
insert into t_emp2(id, jumin) values(3,'3234567');
insert into t_emp2(id, jumin) values(4,'4234567');
insert into t_emp2(id, jumin) values(5,'5234567');
commit;
select * from t_emp2;

/*
t_emp2 ���̺��� id,jumin �����͸� ����ϵ� jumin�÷��� ���ڸ��� 1�̸�
�����̶�� ����ϰ� 2��� ����  3�̸� �߼� �׿ܴ� ��Ÿ��� ���
�÷����� ����
*/

select id, jumin, decode(substr(jumin,1,1),'1','����',
                                                      '2','����',
                                                      '3','�߼�',
                                                      '��Ÿ') as "����"
                                                      from t_emp2;

/*
2�� Ŀ��
�μ���ȣ�� 20���� ����߿��� smith ��� �̸��� ���� ����̶�� hello ���� ����ϰ�
 20�� smith �ƴ϶�� world���
 20�� ����� �ƴ϶�� etc
*/

select  deptno, ename, decode(deptno,20,
                                          decode(ename,'SMITH','hello','world'),
                                          'etc')
from emp;


--CASE ��
--Java : switch

/*
  CASE ���ǽ� WHEN ���1 THEN ���1
                   WHEN ���2 THEN ���2
                   WHEN ���3 THEN ���3
                   ELSE ���4
END "�÷���"
*/

create table t_zip(
zipcode number(10)
);

insert into t_zip(zipcode) values(2);
insert into t_zip(zipcode) values(31);
insert into t_zip(zipcode) values(32);
insert into t_zip(zipcode) values(33);
insert into t_zip(zipcode) values(41);
commit;

select * from t_zip;

select '0' || to_char(zipcode) as "������ȣ", 
          case zipcode when 2 then '����'
                             when 31 then '���'
                             when 33 then '����'
                             when 41 then '����'
                             else '��Ÿ����'
              end "�����̸�"
from t_zip;

/*
������̺��� ����޿��� 1000�޷� ���ϸ� '4��'
1001 �޷� 2000���ϸ� '3��'
2001 �޷� 3000���ϸ� '2��'
3001 �޷� 4000���ϸ� '1��'
������ 'Ư��'
*/
--1. case �÷��� when ��� then ��� (=) ����
--2. case when �÷��� ���Ǻ񱳽� then ....

select sal, case when sal<=1000 then '4��'
                       when sal between 1001 and 2000 then '3��'
                       when sal between 2001 and 3000 then '2��'
                       when sal between 3001 and 4000 then '1��'
                       else 'Ư��'
             end "���"
from emp;

--�����Լ� lpad, rpad concat() substr()
--�����Լ�  round (�ݿø��Լ�) trunc (�����Լ�) ������ ���ϴ� �Լ� mod()
--��¥�Լ� 
--��ȯ�Լ� to_char(), to_date(), to_number()
--�Ϲ��Լ� nvl(), decode(), case()

------------------------------------------------------------------------------------------
--����Ŭ pdf 75page

--�����Լ� --
--1. count(*)  >> ��(row)��, count(�÷���) >> ������ �Ǽ� (null �� �������� �ʴ´�)
--2. sum()
--3. avg()
--4. max()
--5. min()
--���

/*
1. �����Լ��� group by ���� ���� ���
2. ��� �����Լ��� null ���� ����
3. select ���� �����Ѽ� �̿ܿ� �ٸ� �÷��� ���� �ݵ�� �� �÷��� group by���� ��õǾ�� �Ѵ�
*/

select count(*) from emp;
select count(comm) from emp; --null ���� ������ 6��
select count(empno) from emp;


-- select count(comm) from emp; �����Ͱ� 14�� ��µǰ�...
select count(nvl(comm,0)) from emp;

------------------------------------------------------------------------------------------
--�޿��� ��
select sum(sal) as "�޿���" from emp;

--��ձ޿�
select round(avg(sal),0) as "��ձ޿�" from emp;

--ȸ�� �� ������ ���ΰ���  >> ��ձ���
select trunc(avg(comm),0) from emp;  -- 721

select sum(comm) from emp;
select round((sum(comm) /14),0) from emp;  -- 309


select trunc(avg(nvl(comm,0)),0) from emp; --309

-- ȸ���� ������ (��ü ������� ������)  309
-- ȸ���� ������ (�޴� ������� ������) 721

select count(*) from emp where comm is null; --������ ó�� �� �� >> null �� �̸� Ȯ�� 
desc emp;

select max(sal) from emp;
select min(sal) from emp;

--POINT �����Լ� ����� 1�� (1�� �÷��ϳ� ROW �ϳ�)
SELECT empno, count(empno) from emp; --(x) empno 14��, ���� 1��

select sum(sal), avg(sal), max(sal), min(sal),count(sal) ,count(*) from emp;

----------------------------------------------------------
--�μ��� ��� �޿��� ���ϼ���
select deptno, avg(sal)
from emp
group by deptno;

select job, avg(sal)
from emp
group by job;

--������ ��ձ޿�, �޿���, �ִ�޿�, �ּұ޿�, �Ǽ��� ����ϼ���
select job, sum(sal), max(sal), min(sal), count(*)
from emp
group by job;

/*
grouping ����

distinct �÷���1, �÷���2
order by �÷���1, �÷���2
group by �÷���1, �÷���2

*/

--�μ���, ������ �޿��� ���� ���ϼ���
select deptno, job, sum(sal), count(sal)
from emp
group by deptno, job
order by deptno;

/*
select           4
from             1
where           2
group by       3
order by        5
*/

/*
������ ��ձ޿��� 3000�޷� �̻��� ����� ������ ��ձ޿� ���
group by ������
having ��
*/

select job, avg(sal) as "avgsal"
from emp
-- where sal > 3000 -- group by ���� �켱...
group by job
having avg(sal) >= 3000;

/*
from �� ������ where ��
group by ������ having
*/

/*
select                5
from                  1
where                2
group by            3
having               4
order by             6
*/

/*
1. ������̺��� ������ �޿����� ����ϵ� ������ ���� �ް� �޿��� ���� 5000 �̻��� ������� ����� ����ϼ���
--�޿��� ���� ���� ������ ����ϼ���
*/

/*
2. ��� ���̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ����ϼ���

*/

/*
3. ��� ���̺��� ������ �޿��� ���� 5000�� �ʰ��ϴ� ������ �޿��� ���� ����ϼ���
��' �Ǹ�����(salesman)�� �����ϰ� �޿������� �������� �����ϼ���
*/

--1��
select job, sum(sal)
from emp
WHERE COMM IS NOT NULL
group by job
having sum(sal) >=5000
order by sum(sal) asc;

--2��
select deptno, count(deptno), sum(sal)
from emp
group by deptno
having count(deptno) > 4;

--3��
select job ,sum(sal)
from emp
where job !='SALESMAN'
group by job
having sum(sal) > 5000
order by sum(sal) desc;


--����
select upper(substr(ename,1,1)) || lower(substr(ename,2)) || '��' || '������' || sal*12 || '�Դϴ�' as "����"
from emp
where deptno = 30
order by "����" asc;

--���ϴ���
select job, ename, hiredate, sal
from emp
where sal > 2000
order by sal desc;

--�ٺ�
select ename, trunc(to_number(sysdate-hiredate),0) as "�ٹ��ϼ�"
from emp
where trunc(to_number(sysdate-hiredate),0) <= 13500;

--����
create table login (
    id varchar2(20),
    pwd varchar2(6));
insert into login(id,pwd) values('jangjihoon','123456');
select 'ID' || ':'|| rpad(substr(id,1,3),length(id),'*') as "ID" ,
         'PWD' || ':'|| regexp_replace(pwd,'[[:digit:]]' ,'*') as "PWD"
from login;





create table M (M1 char(6) , M2 char(10));
create table S (S1 char(6) , S2 char(10));
create table X (X1 char(6) , X2 char(10));

insert into M values('A','1');
insert into M values('B','1');
insert into M values('C','3');
insert into M values(null,'3');
commit;

insert into S values('A','X');
insert into S values('B','Y');
insert into S values(null,'Z');
commit;

insert into X values('A','DATA');
commit;

select * from m;
select * from s;
select * from x;

----------------------------------------------------------------------------
--3/21 �����

--����
--1. ����� (equal join)
--�����̺�� ������� ���̺� �ִ� �÷��� �����͸� 1:1 ����
--SQL JOIN ����
--ANSI ����(ǥ�ع���) ����       [inner] join on ~������

--SQL JOIN ���� �߾Ⱦ����ϳ���
select * from m, s
where m.m1 = s.s1;  

SELECT m.m1, m.m2, s.s2
from m,s
where m.m1 = s.s1;

--ANSI ����
--where from ���� ������
--where join �������� ��� (����� join �����̰� ����� from ���� ���������� ȥ��)
select *
from m inner join s
on m.m1 = s.s1;

select m.m1, s.s1, s.s2
from m join s
on m.m1 = s.s1;

select * 
from m join x
on m.m1 = x.x1;

--���̺��� �ɰ��� �ִ´�� �ɰ�����!!!!! 
--pk : �ߺ��� �����Ͱ� ���� null���� ���� ���� 

--�����ȣ, ����̸�, ����μ���ȣ, ����μ����� �˰� �;��
select *
from emp join dept
on emp.deptno = dept.deptno;

select emp.empno, emp.ename, emp.deptno, dept.dname
from emp join dept
on emp.deptno = dept.deptno;

--join ���� ���̺��� ��Ī �ο� ��� ���� 
select e.empno, e.ename, d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

--SQL join ���� (3�� ���̺� ����)
select *
from m,s,x
where m.m1 = s.s1 and x.x1 = s.s1;

--ansi join ����     > �̰� �������� !!
select m.m1 , s.s2, x.x2
from m join s on m.m1 = s.s1
           join x on x.x1 = s.s1;

--{ HR �������� �̵�}
select * from employees;
select * from departments;
select * from locations;

--1. ���, �̸�(last_name), �μ���ȣ
select e.employee_id,
          e.last_name, 
          e.department_id, 
          d.DEPARTMENT_NAME
from employees e join departments d 
on e.department_id = d.department_id
order by e.employee_id asc;

--������
select count(*) from employees; --107��
--�� join ������ ����� : 106�� (������ ����)
--� �������� �ذ��� �ȵȴٿ�    ....������ �ٸ�  outer join���� �ذ�

--2. ���, �̸�, �μ���ȣ, �μ���, �����ڵ�, ���ø�
select e.employee_id,
          e.last_name, 
          e.department_id, 
          d.DEPARTMENT_NAME,
          d.location_id,
          l.city
from employees e 
              join departments d on e.department_id = d.department_id
              join locations l on d.location_id = l.location_id;

---------------------------------------------------------------------------------------------------
--2. �� ����(non-euqi join) => �ǹ̸� ���� => ���� �����        
--�����̺�� ������� ���̺� �ִ� �÷��� 1:1 ���ε��� �ʴ� ���
--ex) emp, salgrade �޿����(emp:salgrade), salgrade losal, hisal 2����

select * from emp;   
select * from salgrade;

select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal;
---------------------------------------------------------------------------------------------------
--3. outer join (equi join + null)
--outer join (�� �������� �ľ�) >> �ְ� �Ǵ� ���̺��� �����͸� �������� ��� (euqi join �ϰ� ���� ������)
--���� > left outer join (���� ��)
        -- rigth outer join (������ ��)
        -- full outer join (left, right join >> union
        
select * from m left join s on m.m1 = s.s1;
select * from m right join s on m.m1 = s.s1;
--left , right join >> union
select * from m full join s on m.m1 = s.s1;

--1. ���, �̸�(last_name), �μ���ȣ
select e.employee_id,
          e.last_name, 
          e.department_id, 
          d.DEPARTMENT_NAME
from employees e left outer join departments d 
on e.department_id = d.department_id
order by e.employee_id asc;

--�μ���ȣ�� null�� ���ִ�!
select * from employees where department_id is null;

-----------------------------------------------------------------------------
--self join (�ڱ�����) -> ���� > �����
--�ϳ��� ���̺��� Ư���÷��� �ٸ� �÷��� �����ϴ� ���

select * from emp;
--������ : ���̺��� �ϳ� ...>> ����Ī >> �ϳ��� ���̺��� ������ ��� ����

--null >> outer join >> null ������ Ȯ��
select e.empno, e.ename, m.empno, m.ename 
from emp e left join emp m 
on e.mgr = m.empno;

select * -- ��� ������ ��   �߾Ⱦ���   natural ����
from m, s;

-- 1. ������� �̸�, �μ���ȣ, �μ��̸��� ����϶�.

select e.ename, e.deptno, d.dname
from emp e join dept d on e.deptno = d.deptno;
 
-- 2. DALLAS���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸���
-- ����϶�.

select e.ename, e.job, e.deptno, d.dname
from emp e join dept d on e.deptno = d.deptno
where d.loc = 'DALLAS';

-- 3. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����϶�.

select e.ename, d.dname
from emp e join dept d on e.deptno = d.deptno
where e.ename like ('%A%');

-- 4. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������
--����ϴµ� ������ 3000�̻��� ����� ����϶�.

select e.ename, d.dname, e.sal
from emp e join dept d on e.deptno = d.deptno
where sal >= 3000;

-- 5. ����(����)�� 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����϶�.

select e.job, e.ename, d.dname
from emp e join dept d on e.deptno=d.deptno
where e.job = 'SALESMAN';

-- 6. Ŀ�̼��� å���� ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����϶�.
--(�� ) 1 : 1 ���� ��� �÷��� ����

select e.empno as "�����ȣ", e.ename as "����̸�", e.sal * 12 as "����", e.sal*12+comm as " �Ǳ޿�", s.grade as "�޿����"
from emp e join salgrade s on e.sal between s.losal and s.hisal;

-- 7. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����϶�.

select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where e.deptno = 10;

-- 8. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�,
-- ����̸�, ����, �޿������ ����϶�. �׸��� �� ��µ�
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������
-- �����϶�.

select e.deptno , d.dname , e.ename , e.sal, s.grade 
from emp e join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where e.deptno in (10,20)
order by e.deptno asc, e.sal desc;

-- 9. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� ��������
-- �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
-- '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����϶�.
--SELF JOIN (�ڱ� �ڽ����̺��� �÷��� ���� �ϴ� ���)

select e.empno, e.ename, m.empno, m.ename
from emp e join emp m on e.mgr = m.empno;

select e.empno, e.ename, m.empno, m.ename
from emp e left outer join emp m on e.mgr = m.empno;

--[subquery] ����Ŭ.pdf (100page)
--sql �� ���̴� >> sql ���� �ذ��
-- �Լ� >> ���� >> subquery

--������̺��� ������� ��� ���޺��� �� ���� �޿��� �޴� ����� ���, �̸�, �޿��� ����ϼ���

select avg(sal)
from emp;

select *
from emp where sal > (select avg(sal) from emp); --subquery --


--subquery
--1. single row subquery : subquery�� ����� �Ѱ��� row(���� ��)�� ���� �� (�����÷�)
--2. multi row subquery : subquery�� ����� �Ѱ� �̻��� row(�������� ��)�� ���� �� (�����÷�)
--�����ϴ� ������ : ���Ǵ� �������� ����
--multi row (IN, NOT IN) (ANY, ALL)
--ALL : sal > 1000 and sal >2000 and.....
--ANY : SAL > 1000 or sal > 2000 or.....

--����(subquery)
--1. ��ȣ�ȿ� �־�� �Ѵ� (select avg(sal) from emp)
--2. ���� �÷����� ���� >> (select sal, deptno from emp >> (X) �÷� �������� �ȵǿ�
--3. �ܵ����� ���� �����ؾ� �Ѵ�

--���� ����
--1. subquery ���� ����
--2. subquery �� ����� ������ main query ����

--��� ���̺��� jones�� �޿����� �� ���� �޿��� �޴� ����� ���, �̸�, �޿��� ����ϼ���
select sal from emp where ename = 'JONES';

select empno, ename, sal
from emp
where sal > (select sal from emp where ename = 'JONES');

--�޿��� 2000�޶� �̻���..

select sal from emp where sal >= 2000;  --��� row�� 1�� �̻��̴�

--select * from emp where sal = (select sal from emp where sal >= 2000); (x)

select ename ,sal from emp 
where sal in (select sal from emp where sal >= 2000); 
--sal = 2001 or 5000 or 3000 ....

select ename ,sal from emp 
where sal not in (select sal from emp where sal >= 2000); 
--sal !=2000 and sal != 3000 and...

--���������� �ִ� ����� ����� �̸��� ����ϼ���
select empno, ename
from emp
where empno in (select mgr from emp);

--empno = 7902 or empno = 7839 or empno = 7698 or empno is null; 

--���������� ���� ����� ����� �̸��� ����ϼ���
select empno, ename
from emp
where empno not in (select nvl(mgr,0) from emp);
--empno != 7902 and empno != 7839 and empno != 7698 and empno is null; 

--king ���� �����ϴ� �� ���ӻ���� king �� ����� ���, �̸�, ����, ������ ����� ����ϼ���
select empno from emp where ename = 'KING';

select empno, ename, job, mgr
from emp
where mgr = (select empno from emp where ename = 'KING');

--20�� �μ��� ����߿��� ���� ���� �޿��� �޴� ������� �� ���� �޿��� �޴� �����  
--���, �̸�, �޿�, �μ���ȣ ���

select max(sal) from emp where deptno = 20;

select empno, ename, sal, deptno
from emp
where sal > (select max(sal) from emp where deptno = 20); 

-------------------------------------------------------------------
select *
from emp
where deptno in (select deptno from emp where job = 'SALESMAN')
   and sal in (select sal from emp where job = 'SALESMAN');

--quiz--------------�ߤ��߿��߿��߿��߿�--------------------------------------------POINT
--�ڱ� �μ��� ��� ���޺��� �� ���� ������ �޴� ����� ���, �̸�, �μ���ȣ, �μ��� ��տ���
select deptno, round(avg(sal),0) from emp group by deptno;

select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join (select deptno, round(avg(sal),0) as avgsal from emp group by deptno) s 
on e.deptno = s.deptno
where e.sal > s.avgsal;
---------------------------- ���� �߿� ---------------------------------------------

--1. 'SMITH'���� ������ ���� �޴� ������� �̸��� ������ ����϶�.
select sal from emp where ename = 'SMITH'; 

select ename, sal
from emp
where sal > (select sal from emp where ename = 'SMITH');

--2. 10�� �μ��� ������ ���� ������ �޴� ������� �̸�, ����,
-- �μ���ȣ�� ����϶�.
select sal from emp where deptno = 10;

select ename, sal, deptno
from emp
where sal in (select sal from emp where deptno = 10);

--3. 'BLAKE'�� ���� �μ��� �ִ� ������� �̸��� ������� �̴µ�
-- 'BLAKE'�� ���� ����϶�.

select deptno from emp where ename = 'BLAKE';

select ename, hiredate
from emp
where deptno in (select deptno from emp where ename = 'BLAKE')
            and  ename != 'BLAKE';
 

--4. ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������
-- ����ϵ�, ������ ���� ��� ������ ����϶�.

select avg(sal) from emp;

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp); 
 
--5. �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ�
-- �ִ� ����� �����ȣ�� �̸��� ����϶�.

select deptno from emp where ename like '%T%';

select ename, empno
from emp
where deptno in (select deptno from emp where ename like '%T%');


--6. 30�� �μ��� �ִ� ����� �߿��� ���� ���� ������ �޴� �������
-- ���� ������ �޴� ������� �̸�, �μ���ȣ, ������ ����϶�.
--(��, ALL(and) �Ǵ� ANY(or) �����ڸ� ����� ��)

 select max(sal) from emp where deptno = 30;

select ename, deptno, sal
from emp
where sal > (select max(sal) from emp where deptno = 30) ;
 
--7. 'DALLAS'���� �ٹ��ϰ� �ִ� ����� ���� �μ����� ���ϴ� �����
-- �̸�, �μ���ȣ, ������ ����϶�.
select deptno from dept where loc = 'DALLAS';

select e.ename, e.deptno, e.job
from emp e join dept d on e.deptno = d.deptno 
where e.deptno in (select deptno from dept where loc = 'DALLAS');

--8. SALES �μ����� ���ϴ� ������� �μ���ȣ, �̸�, ������ ����϶�.
 select deptno from dept where dname = 'SALES';
 
 select deptno, ename, job
 from emp
 where deptno = (select deptno from dept where dname = 'SALES');
 
--9. 'KING'���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�
--king �� ����� ��� (mgr �����Ͱ� king ���)
select empno from emp where ename = 'KING';
 

 
--10. �ڽ��� �޿��� ��� �޿����� ����, �̸��� 'S'�� ����
-- ����� ������ �μ����� �ٹ��ϴ� ��� ����� �����ȣ, �̸�,
-- �޿��� ����϶�.
select avg(sal) from emp;
select deptno from emp where ename like '%S%';

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp) and 
          deptno in (select deptno from emp where ename like '%S%');
 
--11. Ŀ�̼��� �޴� ����� �μ���ȣ, ������ ���� �����
-- �̸�, ����, �μ���ȣ�� ����϶�.
select deptno from emp where comm is not null;



--12. 30�� �μ� ������ ���ް� Ŀ�̼��� ���� ����
-- ������� �̸�, ����, Ŀ�̼��� ����϶�.
select comm from emp where deptno =30;

select ename, sal, comm
from emp
where sal not in (select sal from emp where deptno =30)
     and comm not in (select comm from emp where deptno =30 and comm is not null);

SELECT ENAME, SAL, COMM
FROM EMP
WHERE SAL NOT IN(SELECT SAL
                        FROM EMP
                        WHERE DEPTNO=30)
AND COMM NOT IN(SELECT NVL(COMM, 0)
                         FROM EMP
                         WHERE DEPTNO=30 and comm is not null);
 
----------------------------------------------------------------------------------------
--[INSERT], [UPDATE], [DELETE]

/*
����Ŭ ����
DDL(������ ���Ǿ�) : create, alter, drop, truncate (rename, modify)
DML(������ ���۾�) : insert, update, delete
DQL(������ ���Ǿ�) : select
DCL(������ �����) : ���� (grant, revoke)
TCL(Ʈ������) : commit, rollback, savepoint
*/

--DML (Ʈ������ : �ϳ��� ������ ���� ����)
--A���࿡�� ��� B��� ���� �Ա� (�ϳ��� ������ ����)

--A��� ���� (100)��� : update....
--..
--B��� ����(100) �Ա� | update ...

--�Ѵ� : ���� : commit
--���߿� �ϳ��� ���� : rollback

--���̺� ���� ���� (TIP) ------------------------------------------
desc emp;

select * from tab; --����ڰ� ����(����) ���̺� ��� ���

select * from tab where tname = 'BOARD'; --�����Ͱ� �ִٴ� ���� �̹� ���� �Ѵ�

select * from col;

select * from col where tname = 'EMP';

select * from user_tables; --�ý��� �����ڰ� Ȯ���� ����

select * from user_tables where table_name = 'DEPT';

--------------------------------------------------------------------------
--DML (����Ŭpdf 168 page)
/*
INSERT INTO table ,name [columm][(culunm1)
*/

create table temp(
    id number primary key, --id �÷����� null(x), �ߺ�������(x),������ ������ 1�� ����, where id = 10
    name varchar2(20)
);

--1. ���� �Ϲ����� insert
insert into temp(id, name) values(100, 'ȫ�浿');

--�ǹ�
commit;
-- �ݿ�x
rollback;

--2. �÷� ��� ����    - �÷� ����Ʈ ������ ���������� �ظ��ϸ� ���ô�
insert into temp values(200,'������');
commit;

--1. ���� (id �÷��� pk ��������)
insert into temp(id, name)
values(100,'�ƹ���'); --unique constraint (BITUSER.SYS_C007014) violated
--�ߺ� �� ���Ϳ�

insert into temp(name)
values('�ƹ���'); --ORA-01400: cannot insert NULL into
--null �� ��Ϳ�

----------------------------------------------------------------------------
--�Ϲ� sql �� ���α׷����� ���(x)
--pl-sql (����, ���)

--pl-sql
create table temp2 (id varchar2(20));

-- pl- sql �̿��ؼ�  �ݺ���ó��
/*
BEGIN 
    FOR i IN 1..1000 LOOP
    insert into temp2(id) values('A'||to_char(i));
    END LOOP;
END;
*/

select * from temp2;

--------------------------------------------------------------------------------
create table temp3(
  memberid number(3) not null,
  name varchar2(10), -- null ���
  regdate date default sysdate -- �⺻�� ���� regdate insert���� ������ �ڵ����� ��¥ ����
);

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

insert into temp3(memberid, name, regdate)
  values(100,'ȫ�浿','2019-03-21');
commit;

insert into temp3(memberid, name)
  values(200,'�ƹ���');
select * from temp3;
commit;

insert into temp3(memberid) values (300);
select * from temp3;
commit;

insert into temp3(name)
values('�ƹ���'); -- memberid�� null�� ������ ������
--
-------------------------------------------------------------------------------------------
--3/21 ������

--����
select deptno, round(avg(sal),0)
from emp
group by deptno;

--�ٺ�
--�޿��� 10���μ��� �����޿����� ����,
--20���μ����� ������ �ʴ� ��� ����� �����ȣ, �̸�, �μ����� ����϶�.
select e.ename, e.empno, d.dname
from emp e join dept d on e.deptno = d.deptno
where e.deptno != 20 and e.sal < (select min(sal) from emp where deptno =10);

--8. �޿��� ��� �޿����� ����, �̸��� 'S'�� ���� 
--������� �μ��̸�,����̸�, ����, �޿������ ����϶�.
--�׸��� �� ��µ� ������� ������ ���� �����������϶�.

select avg(sal) from emp;

SELECT DEPTNO
                   FROM EMP
                   WHERE ENAME LIKE '%S%';


select d.dname, e.ename, e.sal, s.grade
from emp e join dept d    on e.deptno = d.deptno
                 join salgrade s on e.sal between s.losal and s.hisal
where  e.sal > (select avg(sal) from emp)
  AND e.ename in (SELECT ename
                   FROM EMP
                   WHERE ENAME LIKE '%S%');



SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL)
                FROM EMP)
AND DEPTNO IN(SELECT DEPTNO
                   FROM EMP
                   WHERE ENAME LIKE '%S%');

 SELECT E.DEPTNO, D.DNAME, E.ENAME, E.SAL, S.GRADE
FROM EMP E  join DEPT D               on E.DEPTNO=D.DEPTNO
                        join SALGRADE S       on E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE  E.DEPTNO<=20 --WHERE E.DEPTNO IN (10,20)  -- e.deptno = 10 or 
ORDER BY E.DEPTNO ASC,  E.SAL DESC;

SELECT  deptno, job,COUNT(*),SUM(sal)
FROM EMP
GROUP BY ROLLUP(deptno,job);

SELECT  deptno, job,COUNT(*),SUM(sal)
FROM EMP
GROUP BY ROLLUP(job,deptno);

-------------------------------------------------------------------------------------
--3/22-------------------------------------

create table temp4(id number);
create table temp5(num number);

insert into temp4(id) values (1);
insert into temp4(id) values (2);
insert into temp4(id) values (3);
insert into temp4(id) values (4);
insert into temp4(id) values (5);
insert into temp4(id) values (6);
insert into temp4(id) values (7);
insert into temp4(id) values (8);
insert into temp4(id) values (9);
insert into temp4(id) values (10);

select * from temp4;

--�䱸���� : temp4�� �ִ� ��� �����͸� temp5�� �ְ�;��
--insert into ���̺��(�÷�����Ʈ) values (������Ʈ)
--insert into ���̺��(�÷�����Ʈ) select ���� ...(��, �÷��� ������ Ÿ���� ����

insert into temp5 (num)
select id from temp4;

select * from temp5;
commit;

--2. insert
--���̺��� ���� ��Ȳ���� [���̺��� ����] + [�뷮 ������ ����]
--�� ���簳�� (���� ������ ���� �ȵǿ� (PK, FK)
--������ ��������(�÷��̸�, Ÿ��) ����

--create table ���̺�� (�÷��� Ÿ������)

create table copyemp
as select * from emp;   --����(��Ű��) + ������ insert

select * from copyemp;

create table copyemp2
as select empno, ename, sal
from emp where deptno = 30;

select * from copyemp2;

--����) ����(Ʋ)�� �����ϰ� �����ʹ� �����ϰ� ���� �ʾƿ�
create table copyemp3
as select * from emp where 1=2;  --���� ������ ������ش�

select * from copyemp3;
desc copyemp3;

--TIP)
--����Ŭ �ý��� ���̺� (�پ��� ����)
--���� ���� (PK, FK.....)
select * from user_constraints;
select * from user_constraints where table_name = 'EMP';
select * from user_constraints where table_name = 'COPYEMP';

desc temp;

-- ���������� ����Ѵ�

create table pktest (id number primary key); -- not null �ϰ� uique
insert into pktest(id) values (100);
commit;

select * from user_constraints where table_name = 'PKTEST';


--���������� ������� �ʾƿ� ����
create table pktest2
as 
    select *from pktest;

select * from pktest2;
select * from user_constraints where table_name = 'PKTEST2';

-----------------------------(insert end)-------------------------------------------

-------------------------------UPDATE ----------------------------------------------
/*
update table_name
set column1 = value1, column2 = value2 .....
where ����

update table_name
set column1 = (subquery)
where ����
*/



update copyemp
set sal = 0;  -- ��� sal ���� �ٲ���
rollback;

update copyemp
set sal = 0
where deptno = 20;
commit;

--update( set ������ subquery ���)
update copyemp
set sAl = (select sum(sal) from emp);

select * from copyemp where deptno = 10;


--������ �÷� update
update copyemp
set ename = 'AAA', job = 'BBB', hiredate = sysdate, sal = (select sum(sal) from emp)
where deptno = 10;
commit;

--------------------------------UPDATE END------------------------------------------------

--[DELETE]
--��Ģ :  delete -> commit -> �����Ұ� -> ��� �����Ͱ� �ִٸ� ��������.....

delete from copyemp;
select * from copyemp;
rollback;

delete from copyemp where deptno in(10,20);
rollback;
---------------------------------DELETE END-------------------------------------------------------

/*
 APP(JAVA) -> JDBC API -> DB�۾�(ORACLE)
 
 CRUD 
 
 create : insert
 read : select (��ü) , ������ȸ(1��)
 update : update
 delete : delete
 
 (DML : create, update, delete) Ʈ����� : commit, rollback ����)
 
 --��ü��ȸ(�Լ�), ������ȸ(�Լ�), ����(�Լ�), ����(�Լ�), ����(�Լ�) =>> ������
 
 --public List(Emp) getEmpAllList (select * from emp....)
 --public Emp getEmpListByEmpno( select * from emp where empno = ?)
 --public int insertEmp(Emp emp) {insert into emp (....) values(....)}
*/ 
 ------------------------------------------------------------------------
 
 -- [DDL]
 --create, alter, drop (���̺� ����)
 
 select * from user_tables where table_name = 'BOARD';
 drop table board;
 
 create table board(
  boardid number,
  title varchar2(50),
  content varchar2(4000),
  regdate date
 );
 
---------------------------------------------------------------------------------

--������ ���ϰ� ���...
select * from user_tables where lower(table_name) = 'board';
select * from user_constraints where table_name = 'BOARD';
 ---------------------------------------------------------------------------------
 
 --Oracle 11g �����÷�(�����÷�)
 --�л����� ���̺� : ����, ����, ����, ���� �÷�
 --����, ����, ���� �����͸� insert �ϸ� �ڵ����� ������ �������⸦ ���մϴ�
 
 create table vtable(
  no1 number,
  no2 number,
  no3 number GENERATED ALWAYS as (no1 + no2) VIRTUAL
 );
 
insert into vtable (no1, no2) values (100,50); 
insert into vtable (no1, no2) values (80,60); 

select * from vtable;

--insert into vtable (no1,no2,no3) values(80,60,10); �ȵ��µ�

--�÷��� ��������
select COLUMN_NAME, DATA_TYPE, DATA_DEFAULT
from user_tab_columns where table_name='VTABLE';

--�ǹ����� Ȱ���ϴ� �ڵ�
--��ǰ���� (�԰���) �б⺰ ������ (4�б�)
--�԰��� : 2019 -01-01 >> 1�б� ������

create table vtable2(
  no number, --����
  p_code char(4), --��ǰ�ڵ� (AOO1, BOO2)
  p_date char(8), --�԰���(20190303)
  P_qty number, --����
  p_bungi number(1) GENERATED ALWAYS as (
                                                                    CASE WHEN substr(p_date,5,2) IN ('01','02','03') THEN 1
                                                                             WHEN substr(p_date,5,2) IN ('04','05','06') THEN 2
                                                                             WHEN substr(p_date,5,2) IN ('07','08','09') THEN 3
                                                                             ELSE 4
                                                                    END
                                                                ) VIRTUAL
);

select COLUMN_NAME, DATA_TYPE, DATA_DEFAULT
from user_tab_columns where table_name='VTABLE2';

insert into vtable2 (p_date) values(20180101);
insert into vtable2 (p_date) values(20180126);
insert into vtable2 (p_date) values(20190301);
insert into vtable2 (p_date) values(20190701);
insert into vtable2 (p_date) values(20191225);

select * from vtable2;
select * from vtable2 where p_bungi = 1;

commit;

-------------------------------------------------------------------------------------
--DDL ���̺� �ٷ�� (����Ŭ.PDF 138PAGE)

--1. ���̺� �����ϱ�
create table temp6(id number);

--2. ���̺� �����ߴµ� �÷� �߰��ϱ�
--���� ���̺� �÷� �߰��ϱ�
desc temp6;

alter table temp6
add ename varchar2(20);

--3. ���� ���̺� �ִ� �÷��� �̸��� �߸� ǥ�� (ename - > username)
--���� ���̺� �ִ� ���� �÷��� �̸� �ٲٱ� (rename)
alter table temp6
rename column ename to username;

--4. ���� ���̺� �ִ� ���� �÷��� Ÿ�� ���� �����ϱ�
--modify
alter table temp6
modify(username varchar2(2000));

--5. ���� ���̺� �ִ� ���� �÷� ����
alter table temp6
drop column username;

--6. ���̺� ����
--6.1 �����͸� ���� : delete
--���̺� ó�� ����� ó��ũ�� >> �����͸� ������ >> ������ ũ������
--ex) ó�� 1M >> 10 ���� >>100M >> DELETE 10���� ���� >> ������ ���̺��� ũ��� 100M

--���̺� ������ ���� (������ ũ�⸦ ���� �� ������?)
--truncate (where ���� ��� ���ؿ�)
--ex) ó�� 1M >> 10 ���� >>100M >> DELETE 10���� ���� >> ������ ���̺��� ũ��� 1M

--7. ���̺� ���� drop
drop table temp6;



--�⺻���� ddl ����
-------------------------------------------------------------------------------------------------------------

--���̺� ���� �����ϱ�
--����Ŭ.pdf(144 page)
--������ ���Ἲ Ȯ��
--���� (constraint) : insert, update �ַ�����
/*
*NOT NULL(NN) :���� NULL ���� ������ �� �����ϴ�.

*UNIQUE key  (UK) : ���̺��� ��� ���� (�����ϰ� �ϴ� ��)�� ���� �� (null �� ���)
--unique ������ null ���� ���� �� �ִ�. >> null ���� �������� �ҷ��� ( not null ����)

*PRMARY KEY(PK) : �����ϰ� ���̺��� �� ���� �ĺ� (NOT NULL �� UNQUE ������ ����)
 not null �ϰ� unique �� ���� (���������� index �� �ڵ� ����)
 
*FOREIGN KEY(FK) ���� ������ �� ������ �ܷ�Ű ���踦 �����ϰ� �����մϴ�(��������)
���̺�� ���̺��� ���� ����
EX) e.deptno��   d.deptno �� �ִ� �͸� �� �� �ֵ��� �����ϴ� ���� ?

*CHECK(CK) ���̾�� �ϴ� ������ ������(��κ� ���� ��Ģ�� ����)
������ ���� ���� ���� �Է¹ްڴ�  (gender : �÷���  '��' �Ǵ� '��' �ϴ� ������ ��)
ex) where gender in ('��','��')

������ ����� ����
1. ���̺� ����鼭 �ٷ� ����   (create table ....)
2. ���̺� ���� ����  ( alter table ...  add constraint....)  >> �ڵ� ���� �� (exerd )     *���� ���̺� �������� �߰����ش�
*/

--1
select * from user_constraints where table_name = 'EMP';
--����Ŭ not null �������� ��
-------------------------------------------------------------------------
create table temp7
(
--id number primary key --�������� �ʾƿ� --SYS_C007022 �����̸� - ���߿� �������, ���� �ؾߵǴµ� �����̸��� ������ �߾ȵǼ� �Ⱦ���
  id number constraint pk_temp7_id primary key, --������ ǥ��  : PK_���̺��_�÷��� ���� ���!!!
  name varchar2(20) not null,
  addr varchar2(50)
);

select * from user_constraints where table_name = 'TEMP7';

insert into temp7(name, addr) values('ȫ�浿', '����� ������'); --id�� pk�����̶� �� �������

insert into temp7(id, name, addr) values(10,'ȫ�浿', '����� ������');

insert into temp7(id, name, addr) values(10,'ȫ����', '������ ������'); --id�� �ߺ��̶� �ȵ�

select * from temp7;

commit;

--1. primary key �� ���̺� ����� �� �� �������? 1��...
--�������� �÷��� ��� 1���� �����Ͽ� (ename, age) => ����Ű...

create table temp8(
  id number constraint pk_temp8_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp8_jumin unique, --null�� ��� >> not null 
  addr varchar2(20)
);

select * from user_constraints where table_name = 'TEMP8';

insert into temp8(id, name, jumin, addr) values (10,'ȫ�浿',123456 ,'��⵵');

insert into temp8(id, name, jumin, addr) values (20,'������',123456 ,'��⵵'); -- �ȵǿ�

insert into temp8(id, name, addr) values (20,'������','��⵵'); --null data ��� (�ߺ�üũ�� �ɱ�� ?)


insert into temp8(id, name, addr) values (30,'�ƹ���','���⵵'); --null �ߺ�üũ �ȵ�  ��ӵ� (not null + unque ���� ����ؼ� �����)

select * from temp8;

--------------------------------------------------------------------------------------------------------------
--���̺� ���� �Ŀ� ���� �ɱ�

create table temp9(id number);
--���� ���̺� ���� �߰��ϱ�
--���� ) ���� �����Ͱ� ������ �����Ѵٸ� ������ �߰����� �ʴ´�. >> �ߺ��� ������ >> ������ ���� >> ����
--���� �ɱ����� �����Ͱ˻� �۾� ����

alter table temp9
add constraint pk_temp9_id primary key(id);
--add constraint pk_temp9_id primary key(id,name); > ��������� pk
--2�� �÷��� ���� ���ļ� �ߺ����� �ƴϸ� �ǿ�

select * from user_constraints where table_name = 'TEMP9';

alter table temp9
add ename varchar(20);

alter table temp9
modify (ename not null);

-----------------------------------------------------------------------------------------------------
--[check] ����
-- where ���ǰ� ������ ������ ���� >> ���ǰ� ������ ������ ���� >> where gender in ('��','��');

create table temp10(
  id number constraint pk_temp10_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp10_jumin unique,
  addr varchar2(20),
  age number constraint ck_temp10_age check(age >= 19)
 );
  
select * from user_constraints where table_name = 'TEMP10';

insert into temp10(id,name,jumin,addr,age)
values(100,'ȫ�浿','123456','�����',25);

select * from temp10;

insert into temp10(id,name,jumin,addr,age)
values(200,'������','123456','�λ��',18); --check ���� �ɸ�

commit;

----------------------------------------------------------------------------------------
-- �������� : ���̺�� ���̺���� ���� >> 
-- EMP (deptno) �÷��� DEPT (deptno) �÷��� �����Ѵ�
--POINT
create table c_emp
as
    select empno, ename, deptno from emp where 1=2;

create table c_dept
as
    select deptno, dname from dept where 1=2;
    
select * from c_emp;
select * from c_dept;

--1. �������� (c_emp ���̺� �ִ� deptno �÷��� __ deptno �÷� insert �Ǵ� �����ʹ� c.dept ���̺� deptno ������
--�������߿� �ϳ��� insert, update ����

alter table c_emp
add constraint fk_emp_deptno foreign key(deptno) references c_dept(deptno);
--�� �ڵ� ���� ERROR �߻�
--c_dept >> deptno ���� �����͸� ���� ���ž�.... (�� �ſ��־�� ������ �ּ���...
--deptno ������ �����ʹ� �ߺ������� ���� null �� ����� primary key

--c_dept >> deptno >> primary key ����

--1
alter table c_dept
add constraint pk_dept_deptno primary key(deptno);
    
--2
alter table c_emp
add constraint fk_emp_deptno foreign key(deptno) references c_dept(deptno);

insert  into c_dept(deptno, dname) values(100,'�λ���');
insert  into c_dept(deptno, dname) values(200,'������');
insert  into c_dept(deptno, dname) values(300,'ȸ����');
    
select * from c_dept;

--���Ի�� �Ի�
insert into c_emp(empno, ename)
  values(100,'ȫ�浿'); --FK�� not null ���� �ʾƿ� (null�� ���)
--���Ի���� �μ��� ���� ���� �� �ֵ�

--��ĥ : ���Ի���� ������ �μ��� ������ �Ѵ� (deptno not null constraint _ FK ....
--------------------------------------------------------------------------------

insert into c_emp(empno, ename, deptno) values (200,'�ƹ���',500); --�ȵǴ°�
insert into c_emp(empno, ename, deptno) values (200,'�ƹ���',300); --�Ǵ°�

select * from c_emp;

-------------------------------------------------------------------------------
--���̺� (�θ�, �ڽ� ���̺�)
--���̺� (master, detail)
--�ΰ� ���̺� deptno ���迡�� __ (�θ� : c_dept(PK), master)
--                                           (�ڽ� : c_emp(FK), detail)

--������
select*from c_emp;
select*from d_dept;

--�� �� : c_dept ���̺��� 300 ������ ���� �Ұ��� (�������� �ִ� ������)
delete from c_dept where deptno = 300; --�����ְ� �־ ������
delete from c_dept where deptno = 100; -- �������� �ʴ� �����ʹ� ���� ����
commit;

------------------------------------------------------------------------------------
--����Ŭ.pdf
/*
(column datatype [CONSTRAINT constraint_name]
REFERANECE

*/
--[ON DELETE CASCADE] �θ����̺�� ������ ���� �ϰڴ�
--300 ���� �� �� �ֳ���? ��
--delete from c_dept where detpno=300;
--�����ϴ� ���� ������ ���� ����
--delete from c_emp where deptno= 300; ���� ����

--------------------------------------------------------------------------------------
--�л� ���� ���̺�
--�й��� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�
--�̸� NULL ���� ������� �ʴ´�
--����  o
--����  o
--���� ���� �÷��� ���� Ÿ���̰� NULL ���� ��� 
--�� ���� �Է����� ������  default�� 0���� ���´� 
--���� ,��� �÷��� �����÷�����(�����÷�) �����Ѵ� o
--�а��ڵ�� �а� ���̺� �а��ڵ带 �����Ѵ� o
--�й� , �̸� , ���� , ���� , ���� , ���� , ��� , �а��ڵ� o

--�а� ���̺�
--�а��ڵ� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�,
--�а��� �� null���� ������� �ʴ´�

--�а��ڵ� , �а���

--�׸��� select �����
--�й� , �̸�  ����, ��� , �а��ڵ� , �а��� �� ����ϼ���

select g.studentNumber, g.name, g.sum, g.mean, g.deptno, m.dname
from grade g join major m on g.deptno = m.deptno;

create table grade(
  studentNumber number,
  name varchar2(10) not null,
  bilingual number default 0,
  english number default 0,
  math number,
  sum GENERATED ALWAYS as (bilingual + english + math) VIRTUAL,
  mean GENERATED ALWAYS as ((bilingual + english + math)/3) VIRTUAL,
  deptno number
);



insert into grade(
                  studentNumber,
                  name, 
                  bilingual, 
                  english,
                  math,
                  deptno
                ) 
                  values (12345,'������',100,100,100,1);

insert into major(deptno, dname) values (1,'����Ƽ');

create table major(
  deptno number,
  dname varchar2(10)
);

--1
alter table major
add constraint pk_major_deptno primary key(deptno);



--2
alter table grade
add constraint fk_grade_deptno foreign key(deptno) references major(deptno);

alter table grade
add constraint pk_grade_id primary key(studentNumber);

------------------------------------------------------------------
--3/22 ����Ǯ��
--��������
select round(avg(salary),0) from employees;

select * from employees;

select * from employees
where salary > (select round(avg(salary),0) from employees)
order by salary desc;

--����

create table copyemp4
as select * from emp; 

update copyemp4
set sAl = (select sum(sal) from emp), hiredate = sysdate;

select * from copyemp4;

---------------------------------------------------------------------------------------------------------------------------
-- 1. EMP ���̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ����϶�.

select deptno, count(deptno), sum(sal) 
from emp 
group by deptno having count(deptno) > 4;

-- 2. EMP ���̺��� ���� ���� ����� �����ִ� �μ���ȣ�� ������� ����϶�.

select deptno as "�μ���ȣ", count(deptno) as "�����" from emp group by deptno 
having count(deptno) = (select max(count(deptno)) from emp group by deptno);



select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join (select deptno, round(avg(sal),0) as avgsal from emp group by deptno) s 
on e.deptno = s.deptno
where e.sal > s.avgsal;

-- 3. EMP ���̺��� ���� ���� ����� ���� MGR�� �����ȣ�� ����϶�.

select mgr as "No1 MGR" from emp group by mgr 
having count(nvl(mgr,0)) = (select max(count(mgr)) 
from emp group by mgr);

-- 4. EMP ���̺��� �μ���ȣ�� 10�� ������� �μ���ȣ�� 30�� ������� ���� ����϶�.

select deptno as "�μ���ȣ", count(deptno) as "��� ��" from emp
group by deptno having deptno in(10,30);

-- 5. EMP ���̺��� �����ȣ�� 7521�� ����� ������ ���� �����ȣ�� 7934�� ����� �޿�(SAL)���� ���� ����� �����ȣ, �̸�, ����, �޿��� ����϶�.

select empno, ename, job, sal from emp
where job = (select job from emp where empno = 7521)
   and sal > (select sal from emp where empno = 7934);

-- 6. ����(JOB)���� �ּ� �޿��� �޴� ����� ������ �����ȣ, �̸�, ����, �μ����� ����϶�.
-- ����1 : �������� �������� ����

select e.empno as "�����ȣ", e.ename as "�̸�", e.job as "����", d.dname as "�μ���"
from emp e join dept d on e.deptno = d.deptno
where e.sal in (select min(sal) from emp group by job)
order by e.job desc;

-- 7. �� ��� �� �ñ��� ����Ͽ� �μ���ȣ, ����̸�, �ñ��� ����϶�.

-- ����1. �Ѵ� �ٹ��ϼ��� 20��, �Ϸ� �ٹ��ð��� 8�ð��̴�.

-- ����2. �ñ��� �Ҽ� �� ��° �ڸ����� �ݿø��Ѵ�.

-- ����3. �μ����� �������� ����

-- ����4. �ñ��� ���� ������ ���

select deptno, ename ,round((sal/20/8),2) as "�ñ�" from emp
order by deptno asc, "�ñ�" asc;

-- 8. �� ��� �� Ŀ�̼��� 0 �Ǵ� NULL�̰� �μ���ġ�� ��GO���� ������ ����� ������ �����ȣ, 
--����̸�, Ŀ�̼�, �μ���ȣ, �μ���, �μ���ġ�� ����϶�.

-- ����1. ���ʽ��� NULL�̸� 0���� ���

select e.empno as "���",
          e.ename as "�̸�",
          nvl(e.comm,0) as "����",
          e.deptno as "�μ���ȣ",
          d.dname as "�μ���",
          d.loc as "�μ���ġ"
from emp e join dept d on e.deptno = d.deptno
where nvl(e.comm,0) = 0 and d.loc like '%GO';

-- 9. �� �μ� �� ��� �޿��� 2000 �̻��̸� �ʰ�, �׷��� ������ �̸��� ����϶�.

select round(avg(sal),0) as "���", case when avg(sal) > 2000 then '�ʰ�'
                                                      else '�̸�'
                                              end "2000"
from emp group by deptno; 

-- 10. �� �μ� �� �Ի����� ���� ������ ����� �� �� ������ �����ȣ, �����, �μ���ȣ, �Ի����� ����϶�.

select empno, ename, deptno, hiredate from emp
where sysdate-hiredate in (select max(sysdate-hiredate) from emp group by deptno);

-- 11. 1980��~1980�� ���̿� �Ի�� �� �μ��� ������� �μ���ȣ, �μ���, �Ի�1980, �Ի�1981, �Ի�1982�� ����϶�.

select e.deptno, d.dname,
         count(decode(to_char(hiredate,'yyyy'),'1980',1)) as "�Ի� 1980",
         count(decode(to_char(hiredate,'yyyy'),'1981',1)) as "�Ի� 1981",
         count(decode(to_char(hiredate,'yyyy'),'1982',1)) as "�Ի� 1982",
         count(decode(to_char(hiredate,'yyyy'),'1983',1)) as "�Ի� 1983"
from emp e join dept d on e.deptno = d.deptno
group by e.deptno , d.dname;

-- 12. 1981�� 5�� 31�� ���� �Ի��� �� Ŀ�̼��� NULL�̰ų� 0�� ����� Ŀ�̼��� 500���� �׷��� ������ ���� Ŀ�̼��� ����϶�.

select hiredate from emp;
select hiredate ,decode(nvl(comm,0),0,500,
                                   comm) as "����" 
from emp where hiredate > '1981/05/31';

-- 13. 1981�� 6�� 1�� ~ 1981�� 12�� 31�� �Ի��� �� �μ����� SALES�� ����� �μ���ȣ, �����, ����, �Ի����� ����϶�.

-- ����1. �Ի��� �������� ����

select e.deptno, e.ename, e.job, e.hiredate 
from emp e join dept d on e.deptno = d.deptno 
where hiredate between '1981/06/01' and '1981/12/31' and d.dname = 'SALES'
order by hiredate asc;

-- 14. ���� �ð��� ���� �ð����κ��� �� �ð� ���� �ð��� ����϶�.

-- ����1. ����ð� ������ ��4�ڸ���-2���Ͽ�-2�ڸ��� 24��:2�ڸ���:2�ڸ��ʡ��� ���

-- ����1. �ѽð��� ������ ��4�ڸ���-2���Ͽ�-2�ڸ��� 24��:2�ڸ���:2�ڸ��ʡ��� ���

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

select SYSDATE, sysdate + 1/24 from dual;

-- 15. �� �μ��� ������� ����϶�.

-- ����1. �μ��� ������� ������ �μ���ȣ, �μ����� ���

-- ����2. �μ��� ������� 0�� ��� �������� ���

-- ����3. �μ���ȣ �������� ����

select e.deptno, decode(count(e.deptno),0,'����',
                                                            count(e.deptno)) --��Ÿ��� 
from emp e right outer join dept d on e.deptno = d.deptno
group by e.deptno;


-- 16. ��� ���̺��� �� ����� �����ȣ, �����, �Ŵ�����ȣ, �Ŵ������� ����϶�.

-- ����1. �� ����� �޿�(SAL)�� �Ŵ��� �޿����� ���ų� ����.

select e.deptno, e.ename, e.mgr, m.ename
from emp e join emp m on m.empno = e.mgr
where e.sal > m.sal;

-- 18. ������� ù ���ڰ� ��A���̰�, ó���� �� ���̿� ��LL���� ���� ����� Ŀ�̼��� COMM2�϶�, ��� ����� Ŀ�̼ǿ� COMM2�� 
-- ���� ����� �����, COMM, COMM2, COMM+COMM2�� ����϶�.

select e.ename, nvl(e.comm,0), m."comm2" , nvl(e.comm,0)+m."comm2" as "comm+comm2"
          from emp e join (select empno, comm as "comm2" from emp where ename like '%A%LL%') m
          on e.deptno != m.empno;

/*
select                5
from                  1
where                2
group by            3
having               4
order by             6
*/

-- 19. �� �μ����� 1981�� 5�� 31�� ���� �Ի����� �μ���ȣ, �μ���, �����ȣ, �����, �Ի����� ����Ͻÿ�.

-- ����1. �μ��� ��������� ������ �μ���ȣ, �μ����� ���

-- ����2. �μ���ȣ �������� ����

-- ����3. �Ի��� �������� ����

select e.deptno, d.dname, e.ename, e.hiredate
from emp e right outer join dept d on e.deptno = d.deptno 
                                                       and  hiredate > '1981/05/31'
order by e.deptno, e.hiredate;

select deptno from dept;

-- 20. �Ի��Ϸκ��� ���ݱ��� �ٹ������ 30�� �̻� �̸��� ����� �����ȣ, �����, �Ի���, �ٹ������ ����϶�.

-- ����1. �ٹ������ ���� �������� ���� (��:30.4�� = 30��, 30.7��=30��)

select empno, ename, hiredate, trunc((sysdate - hiredate)/365,0) as "�ٹ����" from emp;
-- �ּ� 37��ȰŰ����� ��


--------------------------------------------------------------------------------------------------------------------
--view ��ü(create ....)
--create view ���̸� as [select ����]    (view ���ؼ� ���� �ִ� ������ ���)
--view �� ���̺�ó�� ��밡�� (�������̺�) -> emp, dept ���� ���� ���� ���
--view �޸𸮻󿡸� �����ϴ� �������̺� (subquery -> i line view -> from(select deptno, avg(Sas)..)

--view ���� ���̺�
--���� : �Ϲ� ���̺�� ������ ���� (select.. where...)
--DML(insert, update, delete) -> view ���ؼ� dml ���� -> view ������ �ִ� (�� �� �ִ�) - > �� ���̺� �����͸� ����


--------------------------------------------------------------------------------------------------------------
--3/25

--view �� ������ ���� �ʿ� ORA-01031: insufficient privileges
create view v_001
as
    select empno, ename from emp;
    
    
select * from v_001; --view ������ �ִ� sql ������ �����Ѵ�

--VIEW ��� ����
--1. �������� ���� (JOIN, SUBQUERY) �������̺� ����...
--2. ���� (���� �ܼ�ȭ) -> ������ ���� �̸� ����� �ΰ� ���
--3. ����(���� ó��) -> �����ϰ� ���� �����͸� ��Ƽ� view ���� -> view

create view v_emp
as
    select empno, ename, job, hiredate from emp;

select empno, ename job, hiredate from v_emp;
select * from v_emp;
select empno, ename from v_emp;
select * from v_emp where empno=7788;

--���� (���� ���ȭ)
create view v_002
as
   select e.empno, e.ename, d.deptno, d.dname
   from emp e join dept d 
   on e.deptno = d.deptno;
   
select * from v_002;
select * from v_002 where deptno=30;

create view v_003 --view�� ���� ���̺�    �����÷��� �÷����� �������� �ȴ�
as
    select deptno, avg(sal) as avgsal
    from emp
    group by deptno;

select * from v_003;

select *
from emp e join v_003 s      --�������� join(select ...) �������� �̿��ؼ� Ǯ������
on e.deptno = s.deptno
where e.sal > s.avgsal;


--���̺� 1�� �̻� ... JOIN... �ȵǸ� .... subquery .... �������̺� (view)

/*
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name [(alias[,alias,...])]
AS Subquery
[WITH CHECK OPTION [CONSTRAINT constraint ]]
[WITH READ ONLY

OR REPLACE �̹� �����Ѵٸ� �ٽ� �����Ѵ�.
FORCE Base Table ������ ������� VIEW �� �����.
NOFORCE �⺻ ���̺��� ������ ��쿡�� VIEW �� �����Ѵ�.
view_name VIEW �� �̸�
Alias Subquery �� ���� ���õ� ���� ���� Column ���� �ȴ�.
Subquery SELECT ������ ����Ѵ�.
WITH CHECK OPTION VIEW �� ���� �׼��� �� �� �ִ� �ุ�� �Է�,���ŵ� �� �ִ�.
Constraint CHECK OPTON ���� ���ǿ� ���� ������ �̸��̴�.
WITH READ ONLY �� VIEW ���� DML �� ����� �� ���� �Ѵ�.
*/

drop view v_007;

create or replace view v_007
as
    select avg(sal) as avgsal from emp; --�Լ� ....

select * from v_007;

create or replace view v_007
as
    select round(avg(sal),0) as avgsal from emp;

--view ���� DML ���� (insert, update, delete)
--�� view �޴Ϻ��� �ƴϱ� ������ view ���ؼ� �� �� �ִ� �����Ϳ� ���ؼ���
--���� view(1�� �̻��� ���̺� ����) --->DML�Ұ�
--�ܼ� view (���̺� 1�� ��) ���� view

select * from v_emp; --view ���ؼ� �� �� �ִ� ������ (empno, ename, job, hiredate)

update v_emp
set sal = 0;        --(x)

update v_emp -- ���� ���̺���... ����Ʈ�� update -- �ᱹ emp ���̺� ������ ����
set job = 'IT';

select * from emp;
select * from v_emp;
rollback;


create or replace view v_emp2
as
    select * from emp where deptno = 20;

update v_emp2
set sal  = 0;                 -- �ڱⰡ �� �� �ִ� �����͸� �ٲ�
                                  --  �μ���ȣ�� 20���� ����鸸 0�̵�

select * from emp;
select * from v_emp2;

rollback;

--view ��Ϻ���
select * from user_views;

------------------------------------------------------------------------------------------------------

--1. 30�� �μ� ������� ����, �̸�, ������ ��� view�� ������

create or replace view v_emp30
as
    select job, ename, sal 
    from emp 
    where deptno = 30;

select * from v_emp30;

--2. 30�� �μ� �������  ����, �̸�, ������ ��� VIEW�� ����µ�,
-- ������ �÷����� ����, ����̸�, �������� ALIAS�� �ְ� ������
-- 300���� ���� ����鸸 �����ϵ��� �϶�.
-- create or replace view view001 (�÷���, �÷���, .....)  

 create or replace view v_emp30
as
    select job as ����, ename as ����̸�, sal as ���� 
    from emp 
    where deptno = 30 and sal > 300;

select * from v_emp30;
 
--3. �μ��� �ִ����, �ּҿ���, ��տ����� ��� VIEW�� ������.

create or replace view v_emp30
as
    select deptno, max(sal) as �ִ����, min(sal) as �ּҿ���, avg(sal) as ��տ��� 
    from emp 
    group by deptno;


select * from v_emp30 ;
       
--4. �μ��� ��տ����� ��� VIEW�� �����, ��տ����� 2000 �̻���
-- �μ��� ����ϵ��� �϶�.

CREATE OR REPLACE VIEW VIEW103
AS
 SELECT DEPTNO, AVG(SAL) AS "��տ���"
 FROM EMP
 GROUP BY DEPTNO
 HAVING AVG(SAL) >=2000;
 
----------------------------------------
SELECT v.deptno,v.��տ��� , d.dname
FROM view103 v JOIN dept d
ON v.deptno = d.deptno;
-----------------------------------------
 
--5. ������ �ѿ����� ��� VIEW�� �����, ������ MANAGER��
-- ������� �����ϰ� �ѿ����� 3000�̻��� ������ ����ϵ��� �϶�.


CREATE OR REPLACE VIEW VIEW104
AS
 SELECT JOB, SUM(SAL) AS "�ѿ���"
 FROM EMP
 WHERE JOB!='MANAGER'
 GROUP BY JOB
 HAVING SUM(SAL)>=3000;
 
SELECT * FROM VIEW104;


---------------------------------------------------------------------------------------------------------
-- db 
             --������ : app (crud)
             --������ : ��� �� ���� (���� : ��Ʈ��ũ, ���� .....)
             --Ʃ�� : APP + DB + ��Ʈ��ũ
                        --SQL Ʃ��
                        --SERVER Ʃ��
             --���� : �𵨸� (���� ���� �߿�)
    
--sequence ������
--����Ŭ pdf 185page
/*
CREATE  SEQUENCE  sequence_name 
[INCREMENT  BY  n]  [START  WITH  n] 
[{MAXVALUE n | NOMAXVALUE}] 
[{MINVALUE n | NOMINVALUE}]  
[{CYCLE | NOCYCLE}] 
[{CACHE | NOCACHE}];


sequence_name  SEQUENCE �� �̸��Դϴ�. 
INCREMENT  BY  n ���� ���� n ���� SEQUENCE ��ȣ ������ ������ ����. 
    �� ���� �����Ǹ� SEQUENCE �� 1 �� ����. 
START  WITH  n  �����ϱ� ���� ù��° SEQUENCE �� ����. 
    �� ���� �����Ǹ� SEQUENCE �� 1 �� ����. 
MAXVALUE n  SEQUENCE �� ������ �� �ִ� �ִ� ���� ����. 
NOMAXVALUE   ���������� 10^27 �ִ밪�� ����������-1 �� �ּҰ��� ����. 
MINVALUE n  �ּ� SEQUENCE ���� ����. 
NOMINVALUE  ���������� 1 �� ����������-(10^26)�� �ּҰ��� ����. 
CYCLE | NOCYCLE  �ִ� �Ǵ� �ּҰ��� ������ �Ŀ� ��� ���� ������ ���� ���θ� 
    ����. NOCYCLE �� ����Ʈ. 
CACHE | NOCACHE  �󸶳� ���� ���� �޸𸮿� ����Ŭ ������ �̸� �Ҵ��ϰ� ���� 
    �ϴ°��� ����. ����Ʈ�� ����Ŭ ������ 20 �� CACHE. 
*/
drop table board;

create table board(
  boardid number constraint pk_board_id primary key,
  title varchar2(100)
);

--boardid �÷� (nof null, unique, index �����ȴ�)
--������ : boardid �����ʹ� ....
--������ : where boardid = ������ �Ѱ��� ������

--insert into board(boardid, title) values(.....
--�׷��� �ߺ����� �ʰ�, null ���� �ƴϴ� ��� ����...

--���� : ó�� ������ ���� 1�̶�� ���� insert ... �� ���� �� ���ʹ� 2,3,4, �������� ���� insert
--������ (insert)

insert into board(boardid, title) values ((select count(boardid)+1 from board), '����');
select * from board;

--�� count() ������ ���� (DML)
delete from board where boardid = 1;

select * from board;
insert into board(boardid, title) values((select count(boardid) +1 from board),'����3');
--����� �ٽ��ϸ�  �ߺ����� ����  ��������
----------------------------------------------------------------------------------
--�ٸ���� max, nvl
-- �߰����� �������   ���� ä������ �ʴ´� ������ ����   1,2,4
select * from board;

insert into board(boardid, title)
values ((select nvl(max(boardid),0) from board) + 1,'ó��');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) from board) + 1,'�ι�°');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) from board) + 1,'����°');

select * from board;
insert into board(boardid, title) values( (select decode(count(boardid),null,0,count(boardid)+1) from board),'ss');
insert into board(boardid, title) values( (select decode(count(boardid),null,0,count(boardid)+1) from board),'s����');


--------------------------------------------------------------------------------------
--sequence ��ȣ ���� ( ��Ģ) : �ߺ����� ���� �������� �� (������ü)
--------------------------------------------------------------------------------------
create sequence board_num;

select * from sys.user_sequences;

/*
1.4.1 NEXTVAL �� CURRVAL �ǻ翭
��) Ư¡
1) NEXTVAL �� ���� ��� ������ SEQUENCE ���� ��ȯ �Ѵ�.
��188��
2) SEQUENCE �� ������ �� ����, �ٸ� ����ڿ��� ������ ������ ���� ��ȯ�Ѵ�.
3) CURRVAL �� ���� SEQUENCE ���� ��´�.
4) CURRVAL �� �����Ǳ� ���� NEXTVAL �� ���Ǿ�� �Ѵ�
*/

--�����
select board_num.nextval from dual; -- ���°���� ����

--������� ����? (���簪 ä������ �ʰ� ������ ���
select board_num.currval from dual;
---------------------------------------------------------------------------------------------
create sequence kboard_num;


create table kboard(
  num number constraint pk_kboard_id primary key,
  title varchar2(100)
);

insert into kboard(num, title) values ((kboard_num.nextval),'ó����');

select * from kboard;
select kboard_num.currval from dual;

insert into kboard(num, title) values ((kboard_num.nextval),'�ι�° ��');
insert into kboard(num, title) values ((kboard_num.nextval),'����° ��');
insert into kboard(num, title) values ((kboard_num.nextval),'�׹�° ��');

delete from kboard where num = 2;
rollback;
------------------------------------------------------------------------------------
--1. sequence ��ü �ϳ� >> �������� ���̺��� ��밡�� (�����ϴ�)
--A (1),(4) , B(2), C(3)

--����Ʈ (�Խ���) 10��
--��ǰ �Խ���, ������ �Խ���, ȸ���Խ���
--sequence ���� ���� ��� .... �ϳ��� sequence �� �����ص� �ȴ�

-- TIP)
-- ms-sql : create table board(boardnum int identity(1,1) , title varchar(20))
-- insert into board(title) values('�氡') --> boardnum 1 ���� �ڵ� insert
-- ms-sql 2012 ���� sequence ���� ���ԵǾ����

-- my-sql  : create table board(boardnum int auto_increment, title varchar(20));
-- --insert into board(title) values('�氡')

--https://mariodb.com/en/library/create-sequence/ sequence ��ü����
----------------------------------------------------------------------------------

--sequence ��ü �ɼ�
create sequence seq_num
start with 10
increment by 2;

select seq_num.nextval from dual;
select seq_num.currval from dual;


--�Խ��� ���� insert
--�Ի��� �ֽű� ������ ���̱�

--�Խ��� ���� insert
--�Խ��� �ֽű� ������ ���̱�
--select * from board order by boardnum desc;
----------------------------------------------------------------------------------------

--������ �ʼ� 2
--rownum �ǻ��÷� : ���� ���������� �����ϴ� �÷��� �ƴϰ� ������ ����

--ROWNUM : ������ ���̺� �÷����� �������� ������ ���������� �� ��ȣ �ο��� �� �ִ� �ǻ� �÷�
--ROWID : �ּҰ� �������  (���� ������ ����Ǵ� ���� �ּҰ�) -> �ε��� ���� �� ���

select * from emp;

select rownum as ����, empno, ename from emp;
--select �� ����� ������ ������ ����

-- Top - n ����
-- ���̺��� ���ǿ� �´� ���� (TOP) ���ڵ�(row) n�� ����

-- ms-sql ����
-- select top 10 , " from emp oder by  sal dsc;

-- oracle
-- rownum(�ǻ��÷�) : ������ ����
------------------------------------------------------------------------------------------------------
--rownum
--1. ������ ������ �����ϴ� �۾�(����)
--2. ������ �� ��Ȳ���� �տ� ���� -> ������ ���� -> ������ ����
 

--1�ܰ�
select *
from( 
        select * 
        from emp order by sal desc)
      e;

--2�ܰ�
select rownum as "num", e.*
from( 
        select * 
        from emp order by sal desc)
      e;

--3�ܰ� (�޿� ���� �޴� ��� 5��...)

select rownum as "num", e.*
from( 
        select * 
        from emp order by sal desc) e
where rownum <= 5;

---------------------------------------------------------------------------------
--�Խ���  ����� ����¡ ó�� �ʼ� .....
select *
from 
        (
          select rownum as num, e.*
          from( 
                  select * 
                  from emp order by sal desc 
        ) e
 )n
 where num < 10;

--------------------------------------------------------------------------------------------
--�Խ��� (����¡ ó��)
--1000�� ������
--10�Ǿ� ����� �����ִ� ��

--�� 100��
--pagesize = 10 (�� ȭ�鿡 (������) ������ ������ �Ǽ� row ��)
--page���� >>10

--1~10 1page (DB���� 1~10���۱��� select ������ app���)
--11~20 2page
--...
--91~100 10page
------------------------------------------------------------------------------------------------
--HR �������� �̵�
select * from employees;
--41 ~ 50 ��������� ����ϼ���
--����
select *
from 
        (
          select rownum as num, e.*
          from( 
                  select * 
                  from employees order by employee_id asc --������
        ) e
 )n
 where num  between 41 and 50;


--pagesize = 10 ��������� ����ϼ���(���� - ����� ����������)
--1~10, 11~20, 21~30

--�Ǵ� between A and B >> where rownum between 10 and 20 ����ص� �˴ϴ�
-------------------------------------------------------------------------
--sql �⺻ ���� end-------------------------------------------------------

--sql ��ް��� (3�� ������Ʈ ����0
--������� (����)...
--pl-sql
--(����, ���, Ŀ��, �Լ�, ���ν���,Ʈ����, ������....)


--1�� ���� test 50����

--1> �μ����̺��� ��� �����͸� ����϶�.
 select * from dept;
--2> EMP���̺��� �� ����� ����, �����ȣ, �̸�, �Ի����� ����϶�.
 select job, empno, ename, hiredate from emp;
--3> EMP���̺��� ������ ����ϵ�, �� �׸�(ROW)�� �ߺ����� �ʰ�
-- ����϶�.
  select distinct job from emp; 
--4> �޿��� 2850 �̻��� ����� �̸� �� �޿��� ����϶�.
  select ename, sal from emp where sal > 2850;
--5> �����ȣ�� 7566�� ����� �̸� �� �μ���ȣ�� ����϶�.
 select ename, empno from emp where empno = 7566;
--6> �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ��� ����� �̸�
-- �� �޿��� ����϶�.
 select ename, sal from emp where sal not between 1500 and 2850;
--7> 1981�� 2�� 20�� ~ 1981�� 5�� 1�Ͽ� �Ի��� ����� �̸�,���� �� 
--�Ի����� ����϶�. �Ի����� �������� �ؼ� ������������ �����϶�.
 select ename, job, hiredate from emp 
 where hiredate between '81/02/20' and '81/05/01'
 order by hiredate asc;
--8> 10�� �� 30�� �μ��� ���ϴ� ��� ����� �̸��� �μ� ��ȣ��
-- ����ϵ�, �̸��� ���ĺ������� �����Ͽ� ����϶�.
 select ename, deptno from emp where deptno in (10,30) order by ename asc;
--9> 10�� �� 30�� �μ��� ���ϴ� ��� ��� �� �޿��� 1500�� �Ѵ�
-- ����� �̸� �� �޿��� ����϶�.
--(�� �÷����� ���� employee �� Monthly Salary�� �����Ͻÿ�)
 select ename as "employee", sal as "monthly Salary" 
 from emp 
 where deptno in (10,30) and sal > 1500;
--10> �����ڰ� ���� ��� ����� �̸� �� ������ ����϶�.
 select ename, job from emp where mgr is null;
--11> Ŀ�̼��� �޴� ��� ����� �̸�, �޿� �� Ŀ�̼��� ����ϵ�, 
-- �޿��� �������� ������������ �����Ͽ� ����϶�.
 select ename, sal, comm from emp where nvl(comm,0) != 0 order by sal;
--12> �̸��� �� ��° ���ڰ� A�� ��� ����� �̸��� ����϶�.
 select ename from emp where ename like '__A%';
--13> �̸��� L�� �� �� ���� �μ� 30�� �����ִ� ����� �̸��� 
--����϶�.
 select ename from emp where ename like '%L%L%' and deptno = 30;
--14> ������ Clerk �Ǵ� Analyst �̸鼭 �޿��� 1000,3000,5000 �� 
-- �ƴ� ��� ����� �̸�, ���� �� �޿��� ����϶�.
 select ename, job from emp where job in('CLERK','ANALYST') and sal not in (1000,3000,5000);
--15> �����ȣ, �̸�, �޿� �׸��� 15%�λ�� �޿��� ������ ǥ���ϵ� 
--�÷����� New Salary�� �����Ͽ� ����϶�.
 select empno, ename, sal, round(sal*1.15,0) as "New Salary" from emp;
--16> 15�� ������ ������ ����Ÿ���� �޿� �λ��(�� �޿����� ���� 
-- �޿��� �� ��)�� �߰��ؼ� ����϶�.(�÷����� Increase�� �϶�). 
 
 
 
--18> ��� ����� �̸�(ù ���ڴ� 
-- �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ� ǥ��) �� �̸� ���̸� ǥ���ϴ�
-- ������ �ۼ��ϰ� �÷� ��Ī�� ������ �־ ����϶�.
 
 
--19> ����� �̸��� Ŀ�̼��� ����ϵ�, Ŀ�̼��� å������ ���� 
-- ����� Ŀ�̼��� 'no commission'���� ����϶�.
 select ename, decode(nvl(comm,0),0,'no commission',comm) from emp;
 
 
--20> ��� ����� �̸�,�μ���ȣ,�μ��̸��� ǥ���ϴ� ���Ǹ� �ۼ��϶�.
 
 
--21> 30�� �μ��� ���� ����� �̸��� �μ���ȣ �׸��� �μ��̸��� ����϶�.
 select e.ename, d.deptno, d.dname
 from emp e join dept d on e.deptno = d.deptno;
--22> 30�� �μ��� ���� ������� ��� ������ �μ���ġ�� ����϶�.
--(��, ���� ����� �ߺ����� �ʰ� �϶�.)
 
 
--23> Ŀ�̼��� å���Ǿ� �ִ� ��� ����� �̸�, �μ��̸� �� ��ġ�� ����϶�.
  select e.ename, d.deptno, d.dname, d.loc
 from emp e join dept d on e.deptno = d.deptno
 where nvl(comm,0) !=0;
--24> �̸��� A�� ���� ��� ����� �̸��� �μ� �̸��� ����϶�.
 
 
--25> Dallas���� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ��̸��� 
-- ����϶�.
 select e.ename, job, d.deptno, d.dname
 from emp e join dept d on e.deptno = d.deptno
 where d.loc = 'DALLAS';
 
--26> ����̸� �� �����ȣ, �ش� �������̸� �� ������ ��ȣ�� ����ϵ�,
-- �� �÷����� employee,emp#,manager,mgr#���� ǥ���Ͽ� ����϶�.
 
--27> ��� ����� �̸�,����,�μ��̸�,�޿� �� ����� ����϶�.
 select e.ename, e.job, d.dname, e.sal, s.grade
 from emp e join dept d on e.deptno = d.deptno
                  join salgrade s on e.sal between s.losal and s.hisal;
--28> Smith���� �ʰ� �Ի��� ����� �̸� �� �Ի����� ����϶�.
 
--29> �ڽ��� �����ں��� ���� �Ի��� ��� ����� �̸�, �Ի���, 
-- �������� �̸�, �������� �Ի����� ����ϵ� ���� �÷����� 
-- Employee,EmpHiredate, Manager,MgrHiredate�� ǥ���Ͽ� 
-- ����϶�.
 select e.ename as "Employee", e.hiredate as "EmpHiredate", m.ename as "Manager", m.hiredate as "MgrHiredate"
 from emp e join emp m on m.empno = e.mgr;
 
--30> ��� ����� �޿� �ְ��,������,�Ѿ� �� ��վ��� ����ϵ� 
-- �� �÷����� Maximum,Minimum,Sum,Average�� �����Ͽ� ����϶�.
 
--31> �� �������� �޿� ������.�ְ��,�Ѿ� �� ��վ��� ����϶�.
 select  job, min(sal), max(sal), sum(sal), avg(sal) from emp group by job;
--32> ������ ������ ��� ���� ������ ���� ����϶�.

--33> �������� ���� ����ϵ�, ������ ��ȣ�� �ߺ����� �ʰ��϶�.
-- �׸���, �÷����� Number of Manager�� �����Ͽ� ����϶�.
 select count(job) as "Number of Manager" from emp where job = 'MANAGER'; 
--34> �ְ� �޿��� ���� �޿��� ������ ����϶�.
 
--35> ������ ��ȣ �� �ش� �����ڿ� ���� ������� ���� �޿��� ����϶�.
-- ��, �����ڰ� ���� ��� �� ���� �޿��� 1000 �̸��� �׷��� ���ܽ�Ű�� 
-- �޿��� �������� ��� ����� ������������ �����϶�.
 select min(sal) from emp 
 group by mgr having mgr is not null and min(sal) >1000
 order by avg(sal) desc;

--36> �μ����� �μ��̸�, �μ���ġ, ��� �� �� ��� �޿��� ����϶�.
-- �׸��� ������ �÷����� �μ���,��ġ,����� ��,��ձ޿��� ǥ���϶�.
 
 
--37> Smith�� ������ �μ��� ���� ��� ����� �̸� �� �Ի����� ����϶�.
-- ��, Smith�� �����ϰ� ����Ͻÿ�
 select deptno from emp where ename = 'SMITH';
 select ename, hiredate from emp where deptno = (select deptno from emp where ename = 'SMITH') and ename != 'SMITH';
 
--38> �ڽ��� �޿��� ��� �޿����� ���� ��� ����� ��� ��ȣ, �̸�, �޿��� 
--    ǥ���ϴ� ���Ǹ� �ۼ��ϰ� �޿��� �������� ����� ������������ �����϶�.
 
 
--39> �̸��� T�� ���� ����� ���� �μ����� �ٹ��ϴ� ��� ����� �����ȣ
-- �� �̸��� ����϶�.
 select deptno from emp where ename like '%T%';
 select empno, ename from emp where deptno in (select deptno from emp where ename like '%T%');
--40> �μ���ġ�� Dallas�� ��� ����� �̸�,�μ���ȣ �� ������ ����϶�.
 
 
--41> KING���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�.
 select EMPNO from emp where ename = 'KING';
 select ename, sal from emp where mgr = (select EMPNO from emp where ename = 'KING');
--42> Sales �μ��� ��� ����� ���� �μ���ȣ, �̸� �� ������ ����϶�.
 
 
--43> �ڽ��� �޿��� ��� �޿����� ���� �̸��� T�� ���� ����� ������
-- �μ��� �ٹ��ϴ� ��� ����� ��� ��ȣ, �̸� �� �޿��� ����϶�.
 select round(avg(sal),0) from emp;
 select deptno from emp where ename like '%T%';
 
 select empno, ename, sal from emp where sal > (select round(avg(sal),0) from emp) and deptno = (select deptno from emp where ename like '%T%');
 --�ٽ�
 
--44> Ŀ�̼��� �޴� ����� �޿��� ��ġ�ϴ� ����� �̸�,�μ���ȣ,�޿��� 
-- ����϶�.
 select ename, deptno, sal from emp where sal in (select sal from emp where nvl(comm,0) != 0);
 select sal from emp where nvl(comm,0) != 0;
--45> Dallas���� �ٹ��ϴ� ����� ������ ��ġ�ϴ� ����� �̸�,�μ��̸�,
--     �� �޿��� ����Ͻÿ�
 select job from emp e join dept d on e.deptno = d.deptno where d.loc = 'DALLAS';
 select e.ename, d.dname, e.sal from emp e join dept d on e.deptno = d.deptno
 where job  IN (select job from emp e join dept d on e.deptno = d.deptno where d.loc = 'DALLAS');
--46> Scott�� ������ �޿� �� Ŀ�̼��� �޴� ��� ����� �̸�, �Ի��� �� 
-- �޿��� ����Ͻÿ�
 
 
--47> ������ Clerk �� ����麸�� �� ���� �޿��� �޴� ����� �����ȣ,
-- �̸�, �޿��� ����ϵ�, ����� �޿��� ���� ������ �����϶�.
 select ename, sal, empno from emp where sal in (select sal from emp where job = 'CLERK')
 order by sal desc;
  
--48> �̸��� A�� ���� ����� ���� ������ ���� ����� �̸���
-- ����, �μ���ȣ�� ����϶�.
 
 
--49> New  York ���� �ٹ��ϴ� ����� �޿� �� Ŀ�̼��� ���� ����� 
-- ����̸��� �μ����� ����϶�.

SELECT E.ENAME, D.DNAME
FROM EMP E, DEPT D
WHERE
e.deptno= d.deptno
AND E.SAL IN(
          SELECT E.SAL
                FROM EMP E, DEPT D
                WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK'
                  )
AND NVL(COMM,0) IN(
               SELECT NVL(COMM,0)
               FROM EMP E, DEPT D
               WHERE E.DEPTNO=D.DEPTNO
                              AND LOC='NEW YORK');

--50> Dallas���� �ٹ��ϴ� ����� ���� �� �����ڰ� ���� ����� �����ȣ,����̸�,
--    ����,����,�μ���,Ŀ�̼��� ����ϵ� Ŀ�̼��� å������ ���� ����� NoCommission
--    ���� ǥ���ϰ�, Ŀ�̼��� �÷����� Comm���� ������ ����Ͻÿ�.
--    ��, �ְ���޺��� ��µǰ� �Ͻÿ�

select e.empno, e.ename, e.job, e.sal, d.dname, decode(nvl(e.comm,0),0,'no commission',comm) as "comm"
from emp e join dept d on e.deptno = d.deptno
where  E.job in (select job from emp e join dept d on e.deptno = d.deptno where d.loc = 'DALLAS')
     and E.mgr in (select mgr from emp e join  dept d on e.deptno = d.deptno where d.loc = 'DALLAS');


------------------------------------------------------------------------------------------------
create table dmlemp
as 
    select * from emp;

select * from dmlemp;

alter table dmlemp
add constraint pk_dmlemp_empno primary key(empno);

select * from SYS.USER_CONSTRAINTS where TABLE_NAME='DMLEMP';

select * from dmlemp;


create table trans_A(
    num number,
    name varchar2(20)
);

create table trans_B(
    num number constraint pk_trans_B_num primary key,
    name varchar2(20)
);

select * from trans_A;

select * from trans_ B;

select * from dept;

create table department(
deptno number,
dname varchar2(50)
);

select * from department;

insert into department(deptno, dname) values (1,'������');
commit;

select * from dept;

update department set dname='�κ�' where deptno=30;
commit;

delete from


create table temp22222(
  id number constraint pk_temp8_id primary key,
  name varchar(20) not null,
  jumin char(6) constraint uk_temp8_jumin unique, --null�� ��� >> not null 
  addr varchar2(20)
);

