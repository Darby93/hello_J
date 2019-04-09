/*
[1일차 수업]
1. 오라클 소프트웨어 다운로드
https://www.oracle.com/technetwork/database/enterprise-edition/downloads/index.html

2. 

3. Oracle 설치(SYS, SYSTEM 계정의 대한 암호 : 1004)

4. Sqlplus 프로그램 제공(CMD) : GUI 환경 일반개발자 사용 불편

5. 별도의 Tool 설치 무료 (SqlDeveloper), 유료(토드, 오렌지, SqlGate)

6. SqlDeveloper 툴을 통해서 Oracle Server 접속.....
  >> HR 계정 : 암호 1004, Unlock 2가지 사용가능 ...(사원관리 실습 테이블)
  
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

7. 현재 접속 계정 확인 : show user;

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


-- 가로줄 ROW
-- 세로줄 CALUME

--1. 사원테이블에서 모든 데이터를 출력하세요
select * from emp; --쿼리문장은 대소문자를 구분하지 않습니다
SELECT * FROM DEPT;
select * from galgrade;

--2. 특정 컬럼 데이터 출력하기
SELECT empno , ename , sal FROM emp; 

--3. 컬럼에 가명칭(별칭)(alias) 부여하기

select empno 사번, ename 이름
from emp;

select empno "사    번", ename "이   름" 
from emp;

--정식(ansi 문법)   as를쓰고 뒤에 별칭 
select empno as"사    번", ename as"이   름" 
from emp;

--Oracle 데이터 문자열 (문자열 데이터는 대소문자 구분)
--문자열 표기 '문자열'
-- 소문자 : a 대문자 : A     다른 문자 취급
select empno, ename from emp where ename='king'; --이건 안나옴

select empno, ename from emp where ename='KING';

--Java : + (숫자 + 숫자 연산)
--Java : + (문자열 + 문자열 결합)
 
--Oracle SQL : 연산자(결합 연산자(||)와 산술 연산자(+) 구분)
--TIP)ms - sql + (연산, 결합)

select '사원의 이름은'|| ename ||'입니다' as "사원정보"
from emp;

--테이블 컬럼은 기본 타입
--컬럼의 타입 숫자, 문자, 날짜
desc emp;
--테이블의 기본정보를 볼 수 있음

--number || varchar 내부적으로 형변환(숫자->문자) 결합
select empno || ename 
from emp;

--invalid number 오류뜹니다 타입이 맞지 않아서 산술연산 불가
select empno + ename 
from emp;

-- 사장님 우리 회사에 직종이 몇개나 있나요
-- distinct : 중복 데이터 제거
-- distinct 원리 : grouping
select distinct job from emp; 

-- 재미삼아서 --------
select distinct job ,deptno from emp order by job;
select distinct deptno ,job from emp order by deptno;

---------------------------------------------------------------------

--JAVA 언어 (연산자)
--JAVA 언어 거의 동일 (+,*,-,...) % : 나머지
--Oracle (SQL 언어) % : 검색 폐턴 // 오라클에서는 나머지 구하는 연산자가 X : 
--MOD()함수로 나머지 구함

--산술연산(+,*,-,/...),MOD()함수 나머지를 구한다

--사원테이블에서 사원의 급여를 100달러 인상한 결과를 출력하세용
desc emp; 
--SAL NUMBER
select empno, sal, sal+100 as "인상급여" from emp; 

select 100 + 100 from dual; --200
select 100 || 100 from dual; --100100 (형변환)
select '100' + 100 from dual; --200   ( + 는 무조건 산술임) 문자 -> 숫자
select 'A100' + 100 from dual; --에러나요  숫자로 못바꿈

--비교연산자
-->,<,<=
--JAVA 같다 (==) 할당 (=)
--Oracle 같다(=) 같지않다(!=)

--논리 연산자
--AND, OR, NOR

--조건절 (원하는 row 가지고 오겠다)
select *
from emp
where sal >= 3000;

select empno, ename, sal
from emp
where sal >= 3000;

--이상, 이하(=포함)
--초과, 미만

--사번이 7788번인 사원의 사번, 이름, 직종, 입사일
--실행순서 : emp
select empno, ename, job, hiredate --3
from emp                     --1
where empno=7788;            --2

--사원의 이름이 king 사원의 사번, 이름, 급여정보
select ename, empno, sal
from emp
where ename='KING';

--급여가 2000달러 이상이면서 직종이 manager 인 사원은 모든 정보를 출력하세요
--두개의 조건을 모든 만족(둘다 참인)
select *
from emp
where SAL>=2000 AND JOB = 'MANAGER';

--급여가 2000달러 이상이면서 직종이 manager 인 사원은 모든 정보를 출력하세요
--두개의 조건중 하나만 참이여도 출력
select *
from emp
where SAL>=2000 OR JOB = 'MANAGER';

-----------------------------------------------------------------------
--오라클 날짜 (DB 서버의 날짜)
--오라클 날짜 (sysdate)
--모든 시스템 날짜 정보
--게시판 글쓰기
--insert into board(write, title, content, regdate) values('홍길동','방가,'배고파요',sysdate)
--TIP)ms - sql : select getdate()

select sysdate from dual;
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
select hiredate from emp;

--오라클 시스템 테이블...
select * from SYS.NLS_SESSION_PARAMETERS;
--NLS_DATE_FORMAT	YYYY-MM-DD HH24:MI:SS
--NLS_DATE_LANGUAGE	KOREAN
--NLS_TIME_FORMAT	HH24:MI:SSXFF

--오라클 날짜 조회 : '2019-12-12'  
select * from emp
where hiredate = '1980-12-17';

select * from emp
where hiredate = '1980/12/17';

select * from emp
where hiredate = '80/12/17'; --이건 안되용
--형식 : RR-MM-DD > YYYY-MM-DD

--사원의 급여가 2000달라 이상이고 4000이하인 모든 사원의 정보를 출력하세요
desc emp; --SAL NUMBER

select *
from emp
where SAL >=2000 AND SAL <=4000;

--연산자 : between A and B (=포함)
--주의사항 : 미만 초과 의 사용 금지
select *
from emp
where sal between 2000 and 4000;

--사원의 급여가 2000초과 4000 미만인 모든 사원의 정보를 출력하세요
select *
from emp
where SAL >2000 AND SAL <4000;

--부서번호가 10번 또는 20번 또는 30번인 사원의 사번, 이름, 급여, 부서번호를 출력하세요
select empno, ename, sal, deptno
from emp
where deptno=10 or deptno=20 or deptno=30;

--IN 연산자 (저건 OR 조건 OR .....)
select empno, ename, sal, deptno
from emp
where deptno in(10,20,30); --deptno=10 or deptno=20 or deptno=30;

--부서번호가 10번 또는 20번이 아닌 사원의 사번, 이름, 급여 , 부서번호를 출력하세요
select *
from emp
where deptno !=10 and deptno !=20;

--NOT IN 연산자 (부정값 and 부정값 and ...)
select *
from emp
where deptno NOT IN(10,20); --not in을 풀어쓰세요 -> deptno !=10 and deptno !=20;9

--POINT : Oracle 값이 없다(데이터 없다) null
--null (필요악)

create table member(
  userid varchar2(20) not null, --한글 10자  값이 무조건 들어가야한다 not null
  name varchar2(20) not null,  --not null 필수입력사항
  hobby varchar2(50)           -- default값은 null 옵션  써도 되고 안써도 되고
);

desc member;
insert into member(userid,hobby) values('hong', '농구'); --실행안됨 (name컬럼에...)
insert into member(userid,name) values('hong', '홍길동');
insert into member(userid,name,hobby) values('hong', '홍길동','농구');

select *
from member;

insert into member(userid,name,hobby) values('kim','김씨','게임');

select *
from member;

delete from member where userid = 'kim';

--실제반영
commit;

--수당(comm)을 받지 않는 모든 사원의 정보를 출력하세요
--O도 데이터 취급(받는 조건 포함)
--comm 컬럼에 데이터가 null인것만 출력
select * from emp where comm = null; --안되용(x)

--null 의 비교는 (is null, is not null)
select * from emp where comm is null;

--수당(comm)을 받는 모든 사원의 정보를 출력하세요
select * from emp where comm is not null;

--사원테이블에서 사번, 이름, 급여, 수당, 총급여를 출력하세요
--총급여 (급여 + 수당)
select empno,ename,sal,comm,sal+comm as "총급여"
from emp; 



select empno,ename,sal,comm,sal+nvl(comm,0) as "총급여"
--nvl(a,b) a에서 null값을 만다면 b로 바꿔라
from emp; 

--POINT null
--1. null 과의 모든 연산은 null
--2. 위 문제 해결 : 함수nvl(),nvl2() >>TIP ms-sql : convert()
                                      --my-sql : IFNULL() : null값 대체...

select 1000 + null from dual;
select 1000 + nvl(null,0) from dual;
select comm as "수당", nvl(comm,1111) from emp;

--사원의 급여가 1000 이상이고 수당을 받지 않는 사원의 사번, 이름, 직종, 급여, 수당 출력
select empno,ename,job,sal,comm
from emp
where sal >= 1000 AND comm is null;

commit;

-----------------------------------------------------------
--DQL(data query language): SELECT
--DDL(데이터 정의어) : creat, alter, drop... (객체 생성, 수정, 삭제)

--create Board(boardno number...
--JAVA : class Board (private  int boardno)

create table Board (
  boardid number not null, --숫자, 필수입력
  title varchar2(20) not null, --한글 10자, 영문자, 특수문자,공백 20자, 필수입력
  content varchar2(2000) not null, --한글 1000자 다른거 2000자, 필수입력
  hp varchar2(20) -- default null허용 필수 입력 사항 (x)
);

desc Board;

--DML(데이터 조작에 반영 여부에서 결정 (실반영, 취소) 반드시 수행
--insert, update, delete 작업

insert into board(boardid, title, content)
values(100, '오라클','할만하네');

select*from board;
--의사결정 : 실제 반영 할거야 (commit)
--의사 결정 : 실제 반영 안할거야 (rollback)

rollback;
commit;

--insert 치는 순간 default로 begin이 잡힘
--begin
insert into board(boardid, title, content)
values(200,'자바','그립다');


insert into board(boardid, title, content)
values(300,'자바','그립다');

--commit 둘다반영
--rollback 둘다 취소

select * from board;
commit;
rollback;

select boardid, nvl(hp,'EMPTY') as "hp" from board;
--nvl 함수는 숫자, 날짜, 문자열 모두 적용 가능하다....

------------------------------------------------------------------
--문자열 검색
--주소검색 : 검색어 : '역삼' -> 역삼 단어가 있는 모든 문장이 다나와용
--문자열 패턴 검색 ( Like 연산자 )

--like 연산자 ( 와일드 카드 문자 ( % : 모든 것, _ : 한문자) 결합....)

select *
from emp
where ename like '%A%'; --ename 컬럼에 데이터에 A 들어있는 모든 이름.....

select *
from emp
where ename like '%a%'; --문자열 데이터 대소문자 엄격하게 구분

select ename
from emp
where ename like 'A%'; --첫 글자가 A로 시작하면 출력

select ename
from emp
where ename like '김수환무%';

select ename
from emp
where ename like '%S'; --마지막 글자가 S로 끝나면 출력

select ename
from emp
where ename like '%LL%';  

select ename
from emp
where ename like '%A%A%'; --A가 두개만 들어있으면 다찾아요

select ename
from emp
where ename like '_A%'; --첫글자 어떤것이 와도 상관 없고 두번째 글자는 A가와야해
-- WARD
-- MARTIN
-- JAMES

select ename
from emp
where ename like '_D%';

--오라클 과제 (regexp_like(e)상세 검색
select * from emp where regexp_like(ename,'A-C');
--정규표현식(java -> oracle -> javascript
--과제 : 정규 표현 예제 5개 만들기 (카페 올려드리면 하세요)

--------------------------------------------------------------
--데이터 정렬하기
--order by 컬럼명 : 문자, 숫자, 날짜
--오름차순 : asc : 낮은순(default)
--내림차순 : desc : 높은순

select * from emp order by sal; -- default asc
select * from emp order by sal asc;

--급여를 많이 받는 순으로 정렬해서 출력하세요
select * from emp order by sal desc; 

select ename from emp order by ename asc; --알파벳순   // 정렬이 가능합니다

--입사일이 가장 늦은 순으로 정렬해서 사번, 이름, 급여, 입사일 데이터를 출력하세요
--(가장 최근에 입사한 순으로)
select empno, ename, sal, hiredate 
from emp 
order by hiredate asc;

/*
실행순서
SELECT      3
FROM        1
WHERE      2
ORDER BY  4  (select 결과물 정렬)
*/

--  emp 테이블에서 매니저인 사람중에서 사번, 이름, 봉급, 직책, 입사일 데이터를 입사가 늦은 순으로 정렬해서 출력
select empno, ename, sal, job, hiredate
from emp
where job = 'MANAGER'
order by hiredate desc;

-- order by 컬럼명 desc, 컬럼명, asc, 컬럼명 desc

--직업 알파벳순으로 정렬후  알파벳별로 사번으로 다시 정렬
select job, deptno
from emp
order by job asc, deptno desc;

---------------------------------------------------------------------------------------------------------
--연산자
--합집합(union) : 테이블과 테이블의 데이터를 합치는 것 (중복값은 배제)
--합집합(union all) : 중복값을 허용

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

--union  중복x
select * from ut
union
select * from uta; --ut 테이블에 uta테이블이 들어감

--union all 중복데이터 다합침
select * from ut
union all
select * from uta;

--union 규칙 
--1. 대응되는 컬럼에 타입이 동일해야된다.
select empno, ename from emp
union
select dname, deptno from dept; -- 타입이 달라서 오류

select empno, ename from emp
union
select deptno, dname from dept; -- 타입이 같아서 되요

--실무 ) subquery
select empno, ename
from (
            select empno, ename from emp
            union
            select deptno, dname from dept
          )order by empno desc;


--2. 대응대는 컬럼의 개수가 동일 (null 사용)
select empno, ename, job, sal from emp 
union
select deptno, dname, loc, null from dept;   --null 사용해서 컬럼 갯수 맞춰줌

--여기까지가 초보개발자가 의무적으로 해야하는 (단일 테이블) 대상으로......
----------------------------------------------------------------------------------
--오라클 함수  .....
select * from SYSNLS_DATABASE_PARAMETERS;
--NLS_CHARACTERSET : AL32UTF8 한글 3BYTE 인식
--KO16KSC560 2BYTE (현재 변환하면 한글 다깨짐)
select * from rls_database_parameters where parameter like '%CHAR%';
-----------------------------------------------------------------------------------
-- [2일차]
/*
1.2.2 단일 행 함수의 종류
1) 문자형 함수 : 문자를 입력 받고 문자와 숫자 값 모두를 RETURN 할 수 있다.
2) 숫자형 함수 : 숫자를 입력 받고 숫자를 RETURN 한다.
3) 날짜형 함수 : 날짜형에 대해 수행하고 숫자를 RETURN 하는 MONTHS_BETWEEN 함수를
제외하고 모두 날짜 데이터형의 값을 RETURN 한다.
4) 변환형 함수 : 어떤 데이터형의 값을 다른 데이터형으로 변환한다.
5) 일반적인 함수 : NVL, DECODE
*/



insert into study

--문자열 함수
select initcap('the super man') from dual;  --첫 글자를 대문자로 만들어줌

select lower('AAA'),upper('aaaa') from dual;

select ename, lower(ename) as "ename" from emp;

select * from emp where lower(ename) = 'king';

--문자열 개수
select length ('abcd') from dual; --4개
select length ('홍길동') from dual; --3개

select length('홍 o길 동') from dual;

--결합 연산자
--concat()
select 'a' || 'o' || 'c' from dual;
select concat('a','b') from dual;

select concat(ename,job) from emp;
select ename||'     '|| job from emp;

--부분 문자열 추출
-- java - substring
-- oracle - substr
  -- substr('a',3,4) a문자열에서 3번째 글짜부터 4개 출력
select substr('ABCDE',2,3) from dual;  --BCD
select substr('ABCDE',1,1) from dual;  -- A
select substr('ABCDE',3,1) from dual; --C

select substr('ABCDE',3) from dual; --CDE
select substr('ABCDE',-2,1) from dual; --DE
select substr('ABCDE',-2,2) from dual; --DE

/*
사원테이블에서 ENAME 컬럼 데이터에 대해서 첫글자는 소문자로 나머지 문자는 대문자로 출력하되
하나의 컬럼으로 출력하세요
- 컬럼의 가명칭은 : fullname
- 첫글자와 나머지 문자 사이에 공백 하나를 넣으세요
*/

select lower(substr(ename,1,1)) 
from emp;

select upper(substr(ename,2)) 
from emp;

select lower(substr(ename,1,1))  ||' '||upper(substr(ename,2))  as "fullname" from emp;

--lpad, rpad (채우기)
select lpad('ABC',10,'*') from dual; --*******ABC
select rpad('ABC',10,'%') from dual; --%%%%%%%ABC

--Quiz
--사용자 비번 : hong1006
--화면 : ho******** 출력하고 싶어요 (비번 : 1004) 10**



select rpad(substr('hong1006',1,2),length('hong1006'),'*') as "password" from dual;
select rpad(substr('1004',1,2),length('1004'),'*')as "password"  from dual;

--emp 테이블에서 ename 컬럼에 데이터를 출력
-- 첫글자만 출력하고 나머지는 *

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
--출력결과
--하나의 컬럼으로 출력 : 
--100 : 123456-*******
--200 : 234567-*******
--컬럼의 가명칭 'juminnumber'
select id ||' : '|| rpad(substr(jumin,1,7),length(jumin),'*') as "Juminnumber" from member2;

--rtrim 함수
--오른쪽 문자 지워라

select rtrim('MILLER','ER') from dual;

select ltrim('MILLLLLER','MIL') from dual; --ER
select rtrim('MILLLLLER','IL') from dual;


select '>' || rtrim('MILLER    ',' ') ||'<' FROM DUAL; --공백제거

--치환함수 (REPLACE)
select ename, replace(ename,'A','와우') from emp;

--------------------------------------------------------------------------
--숫자함수
--round (반올림함수)
--trunc (절삭함수)
--나머지 구하는 함수 mod()


-- -3  -2  -1  0(정수) 1  2  3
--round 반올림
select round(12.345,0) as "r" from dual; --12    0 = 정수부분만 남겨라  
select round(12.567,0) as "r" from dual; --13

select round(12.345,1) as "r" from dual; -- 소수이하 첫째자리 까지 남겨라 12.3
select round(12.567,1) as "r" from dual; -- 12.6

select round(12.345,-1) as "r" from dual; --10 
select round(15.345,-1) as "r" from dual; --20
select round(12.345,-2) as "r" from dual; --0

--trunc 반올림 하지 않고 버림
select trunc(12.345,0) as "t" from dual; --12    0 = 정수부분만 남겨라  
select trunc(12.567,0) as "t" from dual; --12

select trunc(12.345,1) as "t" from dual; -- 소수이하 첫째자리 까지 남겨라 12.3
select trunc(12.567,1) as "t" from dual; -- 12.5

select trunc(12.345,-1) as "t" from dual; --10 
select trunc(15.345,-1) as "t" from dual; --10
select trunc(12.345,-2) as "t" from dual; --0

--------------------------------------------------------------------------
select trunc(12.7234985349584329583924584329,1) from dual;
select round(12.7234985349584329583924584329,1) from dual;

--나머지 mod()
select 12/10 from dual;
select mod(12,10) from dual; --2
--a를 b로 나눈 나머지 

select mod(0,0) from dual;


---------------------숫자함수 end------------------------------------------
---------------------------------------------------------------------------

--날짜 함수
select sysdate from dual;
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
--날짜  연산 (POINT)
--DATE + NUMBER >> DATE
--DATE - NUMBER >> DATE
--DATE - DATE >> NUMBER

select * from SYS.NLS_SESSION_PARAMETERS;

SELECT HIREDATE FROM EMP;

select MONTHS_BETWEEN('2018-02-27','2010-02-27') from dual; --개월의 차 96개월

select MONTHS_BETWEEN(sysdate,'2010-01-01') from dual; --값이 더러워서 trunc , round 써줌

select round(MONTHS_BETWEEN(sysdate,'2010-01-01'),1) from dual;
select trunc(MONTHS_BETWEEN(sysdate,'2010-01-01'),1) from dual;

select to_date('2019-03-20') + 1/24 from dual;
select to_date('2019-03-20') + 1000 from dual;
select  + 1000 from dual;


--Quiz1
--사원 테이블에서 사원들의 입사일에서 현재날짜까지 근속월수를 구하세요
--단, 근속월수는 정수부분만 남기세요
select ename, hiredate, trunc(MONTHS_BETWEEN(sysdate,hiredate),0) as "근속월수" from emp;

--Quiz2
--한달이 31 일 이라는 기준에서 근속월수를 구하세요
select ename, hiredate, trunc((sysdate-hiredate)/31,0) as "근속월수" from emp;
 
---------------------------날짜함수 end -------------------------------------------------------
--문자 ..
--숫자 ..
--날자 ..  연산규칙이 중요해요!
-----------------------------------------------------------------------------------------------
--[변환함수] Today POINT
--Oracle : 문자, 숫자, 날짜
--to_char() : 숫자 -> 문자 (1000 -> $1000) , 날짜 -> 문자 (2019-03-03 -> 2019년03월03일)      문자랑 조합할려고 씀 = 형식 (format) 정의하려고

--to_date() : 문자 -> 날짜 select '2019-03-03' + 1000 그냥하면 안됨   날짜타입으로 계산해야 제대로됨 to_date('2019-03-03') +1000

--to_number() : 문자 -> 숫자 (자동 형변환 있어서 잘안씀)
select '100'+ 100 from dual;
-- 위아래 같은거야
select to_number('100') + 100 from dual;

/*
오라클 기본 데이터 타입
create table 테이블명(컬러명 타입)
create table member (age number); >> 1건 insert .. 1000건

Java : class person >> person p = new person(); 1건
         List<person> personlist = new ArrayList();  오라클 테이블이랑 또이또이
         personlist.add(new person); 
Oracle : create person >> 데이터 제한 x

문자 타입
--char(20) >> 20Byte >> 한글 10자 / 영문자, 특수문자, 공백 20자 : 고정길이 문자열
--varchar2(20) >> 20Byte >> 한글 10자 / 영문자, 특수문자, 공백 20자 : 가변길이 문자열

char(20) >> '홍길동' >> 6Byte >> char 쓰면 홍길동 - 20Byte 안에 저장
varchar2(20) >> '홍길동' >> 데이터 크기 만큼 확보 >> 홍길동 - 6Byte

고정길이 데이터 : 남, 여
char(2) >>

성능상의 문제 >
char() - > varchar() 검색 우선

결국 문제는 한글 ....
unicode (2byte) : 한글 , 영문자, 특수문자, 공백 >> 2byte

nchar(20) >> 유니코드 char  20글자 >> 2*20 40byte
nvarchar2(30) >> 30글자

*/
 
--1. to_number : 문자를 숫자로
select '1' + 1 from dual;

select to_number('1') + 1 from dual;



--2. to_char() : 숫자 - > 형식문자, 날짜 - > 형식문자
alter session set nls_date_format='YYYY-MM-DD';

select to_char(sysdate) || '일' from dual;

select sysdate, to_char(sysdate,'YYYY') ||'년' as "YYYY",
To_char(sysdate,'YEAR'),
To_char(sysdate,'MM'),
To_char(sysdate,'DD'),
To_char(sysdate,'DAY'),
To_char(sysdate,'DY')
from dual;

/*
입사일이 12월인 사원들의 사번, 이름, 입사일, 입사년도, 입사월
*/

select empno as "사번", ename as "사원명", to_char(hiredate,'DD')as "입사일",to_char(hiredate,'YYYY')as "입사년도",
to_char(hiredate,'MM')as "입사월"
from emp
where to_char(hiredate,'MM') = 12;

select to_char(hiredate, 'yyyy mm dd') from emp;



--to_char() : 숫자 -> 형식문자
--1000000 -> $1,000,000,000 (문자형태로)
--표 오라클.pdf 71page

select '>' ||to_char(12345,'9999999999999') ||'<' from dual;
select '>' ||to_char(12345,'09999999999999') ||'<' from dual;
--> 0000000123456<

select '>' ||to_char(12345,'$9,999,999,999') ||'<' from dual;
-->      $12.345< 결과는 문자 데이터

select sal , to_char(sal,'$999,999') from emp;




/*
사원테이블에서 사원의 이름은 last name, first name 합쳐서 fullname 별칭 부여해서 출력하고
입사일은 YYYY-MM-DD 형식으로 출력하고 연봉(급여*12)를 구하고 연봉의 10%(연봉*1.1) 인상한 값을
출력하고 그 결과는 1000단위 콤마 처리해서 출력하세요.
단 2005년 이후 입사자들만 출력하세요. 그리고 연봉이 높은 순으로 출력하세요.+6+63

*/

select * from employees;




select 
employee_id,
last_name || first_name as "fullname",
to_char(hire_date, 'yyyy-mm-dd') as "hire_date", 
salary,
SALARY * 12 as "연봉", 
to_char((salary *12)*1.1,'$999,999,999') as "인상분",
hire_date
from employees
where to_char(hire_date,'YYYY') >= '2005'
order by "연봉" desc;

----다시 bituser 계정으로 전환 ----------------------------------------------------------------
---to_date() 문자를 - > 날짜로
select '2019-03-03' + 100 from dual;

select to_date('2019-03-03') + 100 from dual;
---------------------------------------------------------------------------------------------
--변환함수 (to_date(), to_char(), to_number()

--일반함수 (프로그램적인 성격이 강한함수?)
--nvl(), nvl2() >> null 처리 함수
--decode() 함수  >> java if 문
--case() 함수 >> java switch 문 

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

--2. nvl2 >> null 인 경우와 null이 아닌 경우
--nul2(a,b,c)  a컬럼에서  null값이 아니면 b를 쓰고 null값이면 c를 쓴다

select id,job,nvl2(job,job||'입니다','empty') from t_emp;

select id, job, nvl2(job,'aaa','bbb') from t_emp;

--3. decode Point(통계 데이터) : java if, switch
--decode(  표현식, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3 ............)
select id, job, decode(id,100, 'IT...',
                                    200,'SALES.....',
                                    300, 'MGR...',
                                    'ETC...') as "decodejob"
from t_emp;

select job , decode(job, 'IT',1) from t_emp;
--IT가아니면 NULL줌

select count(decode(job,'IT',1)) AS "IT",
          count(decode(job,'SALES',1)) AS "SALES",
          count(decode(job,'MGR',1)) AS "MGR"
from t_emp;

/*
emp 테이블에서 부서번호가 10이면 '인사부', 20이면 '관리부', 30이면 '회계부'
나머지 부서는 '기타부서' 출력되는 구문을 만드세요
*/

select decode(deptno,'10','인사부',
                               '20','관리부',
                               '30','회계부',
                               '기타부서') AS "부서"
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
t_emp2 테이블에서 id,jumin 데이터를 출력하되 jumin컬럼의 앞자리가 1이면
남성이라고 출력하고 2라면 여성  3이면 중성 그외는 기타라고 출력
컬럼명은 성별
*/

select id, jumin, decode(substr(jumin,1,1),'1','남성',
                                                      '2','여성',
                                                      '3','중성',
                                                      '기타') as "성별"
                                                      from t_emp2;

/*
2분 커피
부서번호가 20번인 사원중에서 smith 라는 이름을 가진 사원이라면 hello 문자 출력하고
 20번 smith 아니라면 world출력
 20번 사원이 아니라면 etc
*/

select  deptno, ename, decode(deptno,20,
                                          decode(ename,'SMITH','hello','world'),
                                          'etc')
from emp;


--CASE 문
--Java : switch

/*
  CASE 조건식 WHEN 결과1 THEN 출력1
                   WHEN 결과2 THEN 출력2
                   WHEN 결과3 THEN 출력3
                   ELSE 출력4
END "컬럼명"
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

select '0' || to_char(zipcode) as "지역번호", 
          case zipcode when 2 then '서울'
                             when 31 then '경기'
                             when 33 then '강원'
                             when 41 then '제주'
                             else '기타지역'
              end "지역이름"
from t_zip;

/*
사원테이블에서 사원급여가 1000달러 이하면 '4급'
1001 달러 2000이하면 '3급'
2001 달러 3000이하면 '2급'
3001 달러 4000이하면 '1급'
나머지 '특급'
*/
--1. case 컬럼명 when 결과 then 출력 (=) 조건
--2. case when 컬럼명 조건비교식 then ....

select sal, case when sal<=1000 then '4급'
                       when sal between 1001 and 2000 then '3급'
                       when sal between 2001 and 3000 then '2급'
                       when sal between 3001 and 4000 then '1급'
                       else '특급'
             end "등급"
from emp;

--문자함수 lpad, rpad concat() substr()
--숫자함수  round (반올림함수) trunc (절삭함수) 나머지 구하는 함수 mod()
--날짜함수 
--변환함수 to_char(), to_date(), to_number()
--일반함수 nvl(), decode(), case()

------------------------------------------------------------------------------------------
--오라클 pdf 75page

--집계함수 --
--1. count(*)  >> 줄(row)수, count(컬럼명) >> 데이터 건수 (null 을 포함하지 않는다)
--2. sum()
--3. avg()
--4. max()
--5. min()
--등등

/*
1. 집계함수는 group by 절과 같이 사용
2. 모든 집계함수는 null 값을 무시
3. select 절에 집계한수 이외에 다른 컬럼이 오면 반드시 그 컬럼은 group by절에 명시되어야 한다
*/

select count(*) from emp;
select count(comm) from emp; --null 값을 못봐서 6건
select count(empno) from emp;


-- select count(comm) from emp; 데이터가 14건 출력되게...
select count(nvl(comm,0)) from emp;

------------------------------------------------------------------------------------------
--급여의 합
select sum(sal) as "급여합" from emp;

--평균급여
select round(avg(sal),0) as "평균급여" from emp;

--회사 총 수당이 얼마인가요  >> 평균까지
select trunc(avg(comm),0) from emp;  -- 721

select sum(comm) from emp;
select round((sum(comm) /14),0) from emp;  -- 309


select trunc(avg(nvl(comm,0)),0) from emp; --309

-- 회사의 규정이 (전체 사원수로 나눈다)  309
-- 회사의 규정이 (받는 사원수로 나눈다) 721

select count(*) from emp where comm is null; --데이터 처리 할 때 >> null 값 미리 확인 
desc emp;

select max(sal) from emp;
select min(sal) from emp;

--POINT 집계함수 결과는 1개 (1건 컬럼하나 ROW 하나)
SELECT empno, count(empno) from emp; --(x) empno 14건, 집계 1건

select sum(sal), avg(sal), max(sal), min(sal),count(sal) ,count(*) from emp;

----------------------------------------------------------
--부서별 평균 급여를 구하세요
select deptno, avg(sal)
from emp
group by deptno;

select job, avg(sal)
from emp
group by job;

--직종별 평균급여, 급여합, 최대급여, 최소급여, 건수를 출력하세요
select job, sum(sal), max(sal), min(sal), count(*)
from emp
group by job;

/*
grouping 원리

distinct 컬럼명1, 컬럼명2
order by 컬럼명1, 컬럼명2
group by 컬럼명1, 컬럼명2

*/

--부서별, 직종별 급여의 합을 구하세요
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
직종별 평균급여가 3000달러 이상인 사원의 직종과 평균급여 출력
group by 조건절
having 절
*/

select job, avg(sal) as "avgsal"
from emp
-- where sal > 3000 -- group by 보다 우선...
group by job
having avg(sal) >= 3000;

/*
from 의 조건절 where 절
group by 조건절 having
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
1. 사원테이블에서 직종별 급여합을 출력하되 수당은 지급 받고 급여의 합이 5000 이상인 사원들의 목록을 출력하세요
--급여의 합이 낮은 순으로 출력하세요
*/

/*
2. 사원 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력하세요

*/

/*
3. 사원 테이블에서 직종별 급여의 합이 5000를 초과하는 직종과 급여의 합을 출력하세요
단' 판매직종(salesman)은 제외하고 급여함으로 내림차순 정렬하세요
*/

--1번
select job, sum(sal)
from emp
WHERE COMM IS NOT NULL
group by job
having sum(sal) >=5000
order by sum(sal) asc;

--2번
select deptno, count(deptno), sum(sal)
from emp
group by deptno
having count(deptno) > 4;

--3번
select job ,sum(sal)
from emp
where job !='SALESMAN'
group by job
having sum(sal) > 5000
order by sum(sal) desc;


--지훈
select upper(substr(ename,1,1)) || lower(substr(ename,2)) || '의' || '연봉은' || sal*12 || '입니다' as "연봉"
from emp
where deptno = 30
order by "연봉" asc;

--선하누나
select job, ename, hiredate, sal
from emp
where sal > 2000
order by sal desc;

--다빈
select ename, trunc(to_number(sysdate-hiredate),0) as "근무일수"
from emp
where trunc(to_number(sysdate-hiredate),0) <= 13500;

--예지
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
--3/21 목요일

--종류
--1. 등가조인 (equal join)
--원테이블과 대응대는 테이블에 있는 컬럼의 데이터를 1:1 메핑
--SQL JOIN 문법
--ANSI 문법(표준문법) 권장       [inner] join on ~조건절

--SQL JOIN 문법 잘안쓴다하내요
select * from m, s
where m.m1 = s.s1;  

SELECT m.m1, m.m2, s.s2
from m,s
where m.m1 = s.s1;

--ANSI 문법
--where from 절의 조건절
--where join 조건절로 사용 (어떤것이 join 조건이고 어떤것이 from 절의 조건절인지 혼동)
select *
from m inner join s
on m.m1 = s.s1;

select m.m1, s.s1, s.s2
from m join s
on m.m1 = s.s1;

select * 
from m join x
on m.m1 = x.x1;

--테이블은 쪼갤수 있는대로 쪼개세요!!!!! 
--pk : 중복된 데이터가 없고 null값이 없는 것을 

--사원번호, 사원이름, 사원부서번호, 사원부서명을 알고 싶어요
select *
from emp join dept
on emp.deptno = dept.deptno;

select emp.empno, emp.ename, emp.deptno, dept.dname
from emp join dept
on emp.deptno = dept.deptno;

--join 에서 테이블의 별칭 부여 사용 가능 
select e.empno, e.ename, d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

--SQL join 문법 (3개 테이블 조인)
select *
from m,s,x
where m.m1 = s.s1 and x.x1 = s.s1;

--ansi join 문법     > 이걸 익히세요 !!
select m.m1 , s.s2, x.x2
from m join s on m.m1 = s.s1
           join x on x.x1 = s.s1;

--{ HR 계정으로 이동}
select * from employees;
select * from departments;
select * from locations;

--1. 사번, 이름(last_name), 부서번호
select e.employee_id,
          e.last_name, 
          e.department_id, 
          d.DEPARTMENT_NAME
from employees e join departments d 
on e.department_id = d.department_id
order by e.employee_id asc;

--문제점
select count(*) from employees; --107명
--위 join 쿼리의 결과는 : 106명 (누군가 누락)
--등가 조인으로 해결이 안된다요    ....별도의 다른  outer join으로 해결

--2. 사번, 이름, 부서번호, 부서명, 지역코드, 도시명
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
--2. 비등가 조인(non-euqi join) => 의미만 존재 => 문법 등가조인        
--원테이블과 대응대는 테이블에 있는 컬럼이 1:1 메핑되지 않는 경우
--ex) emp, salgrade 급여등급(emp:salgrade), salgrade losal, hisal 2개비교

select * from emp;   
select * from salgrade;

select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal;
---------------------------------------------------------------------------------------------------
--3. outer join (equi join + null)
--outer join (주 종관계의 파악) >> 주가 되는 테이블의 데이터를 가져오는 방법 (euqi join 하고 남는 데이터)
--문법 > left outer join (왼쪽 주)
        -- rigth outer join (오른쪽 주)
        -- full outer join (left, right join >> union
        
select * from m left join s on m.m1 = s.s1;
select * from m right join s on m.m1 = s.s1;
--left , right join >> union
select * from m full join s on m.m1 = s.s1;

--1. 사번, 이름(last_name), 부서번호
select e.employee_id,
          e.last_name, 
          e.department_id, 
          d.DEPARTMENT_NAME
from employees e left outer join departments d 
on e.department_id = d.department_id
order by e.employee_id asc;

--부서번호에 null이 껴있다!
select * from employees where department_id is null;

-----------------------------------------------------------------------------
--self join (자기참조) -> 문법 > 등가조인
--하나의 테이블에서 특정컬럼이 다른 컬럼을 참조하는 경우

select * from emp;
--문제점 : 테이블이 하나 ...>> 가명칭 >> 하나의 테이블을 여러번 사용 가능

--null >> outer join >> null 데이터 확인
select e.empno, e.ename, m.empno, m.ename 
from emp e left join emp m 
on e.mgr = m.empno;

select * -- 모든 가지의 수   잘안쓴데   natural 조인
from m, s;

-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하라.

select e.ename, e.deptno, d.dname
from emp e join dept d on e.deptno = d.deptno;
 
-- 2. DALLAS에서 근무하는 사원의 이름, 직위, 부서번호, 부서이름을
-- 출력하라.

select e.ename, e.job, e.deptno, d.dname
from emp e join dept d on e.deptno = d.deptno
where d.loc = 'DALLAS';

-- 3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라.

select e.ename, d.dname
from emp e join dept d on e.deptno = d.deptno
where e.ename like ('%A%');

-- 4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
--출력하는데 월급이 3000이상인 사원을 출력하라.

select e.ename, d.dname, e.sal
from emp e join dept d on e.deptno = d.deptno
where sal >= 3000;

-- 5. 직위(직종)가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하라.

select e.job, e.ename, d.dname
from emp e join dept d on e.deptno=d.deptno
where e.job = 'SALESMAN';

-- 6. 커미션이 책정된 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하라.
--(비등가 ) 1 : 1 매핑 대는 컬럼이 없다

select e.empno as "사원번호", e.ename as "사원이름", e.sal * 12 as "연봉", e.sal*12+comm as " 실급여", s.grade as "급여등급"
from emp e join salgrade s on e.sal between s.losal and s.hisal;

-- 7. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하라.

select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where e.deptno = 10;

-- 8. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 출력하라. 그리고 그 출력된
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로
-- 정렬하라.

select e.deptno , d.dname , e.ename , e.sal, s.grade 
from emp e join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where e.deptno in (10,20)
order by e.deptno asc, e.sal desc;

-- 9. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의
-- 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
-- '사원이름', '관리자번호', '관리자이름'으로 하여 출력하라.
--SELF JOIN (자기 자신테이블의 컬럼을 참조 하는 경우)

select e.empno, e.ename, m.empno, m.ename
from emp e join emp m on e.mgr = m.empno;

select e.empno, e.ename, m.empno, m.ename
from emp e left outer join emp m on e.mgr = m.empno;

--[subquery] 오라클.pdf (100page)
--sql 의 꽃이다 >> sql 만능 해결사
-- 함수 >> 조인 >> subquery

--사언테이블에서 사원들의 평균 월급보다 더 많은 급여를 받는 사원의 사번, 이름, 급여를 출력하세요

select avg(sal)
from emp;

select *
from emp where sal > (select avg(sal) from emp); --subquery --


--subquery
--1. single row subquery : subquery의 결과가 한개의 row(단일 값)를 가질 때 (단일컬럼)
--2. multi row subquery : subquery의 결과가 한개 이상의 row(여러개의 값)를 가질 때 (단일컬럼)
--구분하는 이유는 : 사용되는 연산자의 차이
--multi row (IN, NOT IN) (ANY, ALL)
--ALL : sal > 1000 and sal >2000 and.....
--ANY : SAL > 1000 or sal > 2000 or.....

--정의(subquery)
--1. 괄호안에 있어야 한다 (select avg(sal) from emp)
--2. 단일 컬럼으로 구성 >> (select sal, deptno from emp >> (X) 컬럼 여러개라 안되요
--3. 단독으로 실행 가능해야 한다

--실행 순서
--1. subquery 먼저 실행
--2. subquery 의 결과를 가지고 main query 실행

--사원 테이블에서 jones의 급여보다 더 많은 급여를 받는 사원의 사번, 이름, 급여를 출력하세요
select sal from emp where ename = 'JONES';

select empno, ename, sal
from emp
where sal > (select sal from emp where ename = 'JONES');

--급여가 2000달라 이상인..

select sal from emp where sal >= 2000;  --결과 row가 1개 이상이다

--select * from emp where sal = (select sal from emp where sal >= 2000); (x)

select ename ,sal from emp 
where sal in (select sal from emp where sal >= 2000); 
--sal = 2001 or 5000 or 3000 ....

select ename ,sal from emp 
where sal not in (select sal from emp where sal >= 2000); 
--sal !=2000 and sal != 3000 and...

--부하직원이 있는 사원의 사번과 이름을 출력하세요
select empno, ename
from emp
where empno in (select mgr from emp);

--empno = 7902 or empno = 7839 or empno = 7698 or empno is null; 

--부하직원이 없는 사원의 사번과 이름을 출력하세요
select empno, ename
from emp
where empno not in (select nvl(mgr,0) from emp);
--empno != 7902 and empno != 7839 and empno != 7698 and empno is null; 

--king 에게 보고하는 즉 직속상관이 king 인 사원의 사번, 이름, 직종, 관리자 사번을 출력하세요
select empno from emp where ename = 'KING';

select empno, ename, job, mgr
from emp
where mgr = (select empno from emp where ename = 'KING');

--20번 부서의 사원중에서 가장 많은 급여를 받는 사원보다 더 많은 급여를 받는 사원의  
--사번, 이름, 급여, 부서번호 출력

select max(sal) from emp where deptno = 20;

select empno, ename, sal, deptno
from emp
where sal > (select max(sal) from emp where deptno = 20); 

-------------------------------------------------------------------
select *
from emp
where deptno in (select deptno from emp where job = 'SALESMAN')
   and sal in (select sal from emp where job = 'SALESMAN');

--quiz--------------중ㅇ중요중요중요중요--------------------------------------------POINT
--자기 부서의 평균 월급보다 더 많은 월급을 받는 사원의 사번, 이름, 부서번호, 부서별 평균월급
select deptno, round(avg(sal),0) from emp group by deptno;

select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join (select deptno, round(avg(sal),0) as avgsal from emp group by deptno) s 
on e.deptno = s.deptno
where e.sal > s.avgsal;
---------------------------- 존나 중요 ---------------------------------------------

--1. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.
select sal from emp where ename = 'SMITH'; 

select ename, sal
from emp
where sal > (select sal from emp where ename = 'SMITH');

--2. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급,
-- 부서번호를 출력하라.
select sal from emp where deptno = 10;

select ename, sal, deptno
from emp
where sal in (select sal from emp where deptno = 10);

--3. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데
-- 'BLAKE'는 빼고 출력하라.

select deptno from emp where ename = 'BLAKE';

select ename, hiredate
from emp
where deptno in (select deptno from emp where ename = 'BLAKE')
            and  ename != 'BLAKE';
 

--4. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력하라.

select avg(sal) from emp;

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp); 
 
--5. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
-- 있는 사원의 사원번호와 이름을 출력하라.

select deptno from emp where ename like '%T%';

select ename, empno
from emp
where deptno in (select deptno from emp where ename like '%T%');


--6. 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라.
--(단, ALL(and) 또는 ANY(or) 연산자를 사용할 것)

 select max(sal) from emp where deptno = 30;

select ename, deptno, sal
from emp
where sal > (select max(sal) from emp where deptno = 30) ;
 
--7. 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의
-- 이름, 부서번호, 직업을 출력하라.
select deptno from dept where loc = 'DALLAS';

select e.ename, e.deptno, e.job
from emp e join dept d on e.deptno = d.deptno 
where e.deptno in (select deptno from dept where loc = 'DALLAS');

--8. SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력하라.
 select deptno from dept where dname = 'SALES';
 
 select deptno, ename, job
 from emp
 where deptno = (select deptno from dept where dname = 'SALES');
 
--9. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라
--king 이 사수인 사람 (mgr 데이터가 king 사번)
select empno from emp where ename = 'KING';
 

 
--10. 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는
-- 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름,
-- 급여를 출력하라.
select avg(sal) from emp;
select deptno from emp where ename like '%S%';

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp) and 
          deptno in (select deptno from emp where ename like '%S%');
 
--11. 커미션을 받는 사원과 부서번호, 월급이 같은 사원의
-- 이름, 월급, 부서번호를 출력하라.
select deptno from emp where comm is not null;



--12. 30번 부서 사원들과 월급과 커미션이 같지 않은
-- 사원들의 이름, 월급, 커미션을 출력하라.
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
오라클 기준
DDL(데이터 정의어) : create, alter, drop, truncate (rename, modify)
DML(데이터 조작어) : insert, update, delete
DQL(데이터 질의어) : select
DCL(데이터 제어어) : 권한 (grant, revoke)
TCL(트랜젝션) : commit, rollback, savepoint
*/

--DML (트렌젝션 : 하나의 논리적인 직업 단위)
--A은행에서 출금 B라는 은행 입금 (하나의 논리적인 단위)

--A라는 계좌 (100)출금 : update....
--..
--B라는 계좌(100) 입금 | update ...

--둘다 : 성공 : commit
--둘중에 하나라도 실패 : rollback

--테이블 정보 보기 (TIP) ------------------------------------------
desc emp;

select * from tab; --사용자가 만든(계정) 테이블 목록 출력

select * from tab where tname = 'BOARD'; --데이터가 있다는 것은 이미 존재 한다

select * from col;

select * from col where tname = 'EMP';

select * from user_tables; --시스템 관리자가 확인함 거의

select * from user_tables where table_name = 'DEPT';

--------------------------------------------------------------------------
--DML (오라클pdf 168 page)
/*
INSERT INTO table ,name [columm][(culunm1)
*/

create table temp(
    id number primary key, --id 컬럼에는 null(x), 중복데이터(x),유일한 데이터 1건 보장, where id = 10
    name varchar2(20)
);

--1. 가장 일반적인 insert
insert into temp(id, name) values(100, '홍길동');

--실반
commit;
-- 반영x
rollback;

--2. 컬럼 목록 생략    - 컬럼 리스트 생략이 가능하지만 왠만하면 씁시다
insert into temp values(200,'김유신');
commit;

--1. 문제 (id 컬럼에 pk 제약정보)
insert into temp(id, name)
values(100,'아무개'); --unique constraint (BITUSER.SYS_C007014) violated
--중복 값 못와요

insert into temp(name)
values('아무개'); --ORA-01400: cannot insert NULL into
--null 값 몬와요

----------------------------------------------------------------------------
--일반 sql 은 프로그램적인 요소(x)
--pl-sql (변수, 제어문)

--pl-sql
create table temp2 (id varchar2(20));

-- pl- sql 이용해서  반복문처리
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
  name varchar2(10), -- null 허용
  regdate date default sysdate -- 기본값 설정 regdate insert하지 않으면 자동으로 날짜 넣음
);

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

insert into temp3(memberid, name, regdate)
  values(100,'홍길동','2019-03-21');
commit;

insert into temp3(memberid, name)
  values(200,'아무개');
select * from temp3;
commit;

insert into temp3(memberid) values (300);
select * from temp3;
commit;

insert into temp3(name)
values('아무개'); -- memberid에 null값 못들어가서 에러임
--
-------------------------------------------------------------------------------------------
--3/21 스퉈디

--예지
select deptno, round(avg(sal),0)
from emp
group by deptno;

--다빈
--급여가 10번부서의 최저급여보다 적고,
--20번부서에서 일하지 않는 모든 사원의 사원번호, 이름, 부서명을 출력하라.
select e.ename, e.empno, d.dname
from emp e join dept d on e.deptno = d.deptno
where e.deptno != 20 and e.sal < (select min(sal) from emp where deptno =10);

--8. 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는 
--사원들의 부서이름,사원이름, 월급, 급여등급을 출력하라.
--그리고 그 출력된 결과물을 월급이 낮은 순으로정렬하라.

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

--요구사항 : temp4에 있는 모든 데이터를 temp5에 넣고싶어요
--insert into 테이블명(컬럼리스트) values (값리스트)
--insert into 테이블명(컬럼리스트) select 구문 ...(단, 컬럼의 개수와 타입이 동일

insert into temp5 (num)
select id from temp4;

select * from temp5;
commit;

--2. insert
--테이블이 없는 상황에서 [테이블을 생성] + [대량 데이터 삽입]
--단 복사개념 (제약 정보는 복사 안되요 (PK, FK)
--순소한 구조정보(컬럼이름, 타입) 복사

--create table 테이블명 (컬럼명 타입정보)

create table copyemp
as select * from emp;   --구조(스키마) + 데이터 insert

select * from copyemp;

create table copyemp2
as select empno, ename, sal
from emp where deptno = 30;

select * from copyemp2;

--질문) 구조(틀)만 복사하고 데이터는 복사하고 싶지 않아요
create table copyemp3
as select * from emp where 1=2;  --거짓 조건을 만들어준다

select * from copyemp3;
desc copyemp3;

--TIP)
--오라클 시스템 테이블 (다양한 정보)
--제약 정보 (PK, FK.....)
select * from user_constraints;
select * from user_constraints where table_name = 'EMP';
select * from user_constraints where table_name = 'COPYEMP';

desc temp;

-- 제약정보를 출력한다

create table pktest (id number primary key); -- not null 하고 uique
insert into pktest(id) values (100);
commit;

select * from user_constraints where table_name = 'PKTEST';


--제약정보는 복사되지 않아요 검증
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
where 조건

update table_name
set column1 = (subquery)
where 조건
*/



update copyemp
set sal = 0;  -- 모든 sal 행을 바꿔줌
rollback;

update copyemp
set sal = 0
where deptno = 20;
commit;

--update( set 구문에 subquery 사용)
update copyemp
set sAl = (select sum(sal) from emp);

select * from copyemp where deptno = 10;


--여러개 컬럼 update
update copyemp
set ename = 'AAA', job = 'BBB', hiredate = sysdate, sal = (select sum(sal) from emp)
where deptno = 10;
commit;

--------------------------------UPDATE END------------------------------------------------

--[DELETE]
--원칙 :  delete -> commit -> 복원불가 -> 백업 데이터가 있다면 복원가능.....

delete from copyemp;
select * from copyemp;
rollback;

delete from copyemp where deptno in(10,20);
rollback;
---------------------------------DELETE END-------------------------------------------------------

/*
 APP(JAVA) -> JDBC API -> DB작업(ORACLE)
 
 CRUD 
 
 create : insert
 read : select (전체) , 조건조회(1건)
 update : update
 delete : delete
 
 (DML : create, update, delete) 트랜잭션 : commit, rollback 강제)
 
 --전체조회(함수), 조건조회(함수), 삭제(함수), 수정(함수), 삽입(함수) =>> 개발자
 
 --public List(Emp) getEmpAllList (select * from emp....)
 --public Emp getEmpListByEmpno( select * from emp where empno = ?)
 --public int insertEmp(Emp emp) {insert into emp (....) values(....)}
*/ 
 ------------------------------------------------------------------------
 
 -- [DDL]
 --create, alter, drop (테이블 기준)
 
 select * from user_tables where table_name = 'BOARD';
 drop table board;
 
 create table board(
  boardid number,
  title varchar2(50),
  content varchar2(4000),
  regdate date
 );
 
---------------------------------------------------------------------------------

--개발자 편하게 살기...
select * from user_tables where lower(table_name) = 'board';
select * from user_constraints where table_name = 'BOARD';
 ---------------------------------------------------------------------------------
 
 --Oracle 11g 가상컬럼(조합컬럼)
 --학생성적 테이블 : 국어, 영어, 수학, 총점 컬럼
 --국어, 영어, 수학 데이터만 insert 하면 자동으로 총점이 구해지기를 원합니다
 
 create table vtable(
  no1 number,
  no2 number,
  no3 number GENERATED ALWAYS as (no1 + no2) VIRTUAL
 );
 
insert into vtable (no1, no2) values (100,50); 
insert into vtable (no1, no2) values (80,60); 

select * from vtable;

--insert into vtable (no1,no2,no3) values(80,60,10); 안들어가는듯

--컬럼의 정보보기
select COLUMN_NAME, DATA_TYPE, DATA_DEFAULT
from user_tab_columns where table_name='VTABLE';

--실무에서 활용하는 코드
--제품정보 (입고일) 분기별 데이터 (4분기)
--입고일 : 2019 -01-01 >> 1분기 데이터

create table vtable2(
  no number, --순번
  p_code char(4), --제품코드 (AOO1, BOO2)
  p_date char(8), --입고일(20190303)
  P_qty number, --수량
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
--DDL 테이블 다루기 (오라클.PDF 138PAGE)

--1. 테이블 생성하기
create table temp6(id number);

--2. 테이블 생성했는데 컬럼 추가하기
--기존 테이블에 컬럼 추가하기
desc temp6;

alter table temp6
add ename varchar2(20);

--3. 기존 테이블에 있는 컬럼의 이름을 잘못 표기 (ename - > username)
--기존 테이블에 있는 기존 컬럼의 이름 바꾸기 (rename)
alter table temp6
rename column ename to username;

--4. 기존 테이블에 있는 기존 컬럼의 타입 정보 수정하기
--modify
alter table temp6
modify(username varchar2(2000));

--5. 기존 테이블에 있는 기존 컬럼 삭제
alter table temp6
drop column username;

--6. 테이블 삭제
--6.1 데이터만 삭제 : delete
--테이블 처음 만들면 처음크기 >> 데이터를 넣으면 >> 데이터 크기증가
--ex) 처음 1M >> 10 만건 >>100M >> DELETE 10만건 삭제 >> 여전히 테이블의 크기는 100M

--테이블 데이터 삭제 (공간의 크기를 줄일 수 있을까?)
--truncate (where 절을 사용 못해요)
--ex) 처음 1M >> 10 만건 >>100M >> DELETE 10만건 삭제 >> 여전히 테이블의 크기는 1M

--7. 테이블 삭제 drop
drop table temp6;



--기본적인 ddl 구문
-------------------------------------------------------------------------------------------------------------

--테이블 제약 설정하기
--오라클.pdf(144 page)
--데이터 무결성 확보
--제약 (constraint) : insert, update 주로적용
/*
*NOT NULL(NN) :옅은 NULL 값을 포함할 수 없습니다.

*UNIQUE key  (UK) : 테이블의 모든 행을 (유일하게 하는 값)을 가진 열 (null 을 허용)
--unique 제약은 null 값을 가질 수 있다. >> null 값을 못가지게 할려면 ( not null 포함)

*PRMARY KEY(PK) : 유일하게 테이블의 각 행을 식별 (NOT NULL 과 UNQUE 조건을 만족)
 not null 하고 unique 한 제약 (내부적으로 index 가 자동 설정)
 
*FOREIGN KEY(FK) 열과 참조된 열 사이의 외래키 관계를 적용하고 설정합니다(참조제약)
테이블과 테이블간의 관계 설정
EX) e.deptno에   d.deptno 에 있는 것만 쓸 수 있도록 강제하는 느낌 ?

*CHECK(CK) 참이어야 하는 조건을 지정함(대부분 업무 규칙을 설정)
설정한 범위 내의 값만 입력받겠다  (gender : 컬럼에  '남' 또는 '여' 하는 데이터 만)
ex) where gender in ('남','여')

제약을 만드는 시점
1. 테이블 만들면서 바로 생성   (create table ....)
2. 테이블 생성 이후  ( alter table ...  add constraint....)  >> 자동 생성 툴 (exerd )     *보통 테이블 생성이후 추가해준다
*/

--1
select * from user_constraints where table_name = 'EMP';
--오라클 not null 제약으로 봄
-------------------------------------------------------------------------
create table temp7
(
--id number primary key --권장하지 않아요 --SYS_C007022 제약이름 - 나중에 제약수정, 삭제 해야되는데 제약이름이 구별이 잘안되서 안쓴다
  id number constraint pk_temp7_id primary key, --관용적 표현  : PK_테이블명_컬럼명 으로 써요!!!
  name varchar2(20) not null,
  addr varchar2(50)
);

select * from user_constraints where table_name = 'TEMP7';

insert into temp7(name, addr) values('홍길동', '서울시 강남구'); --id가 pk제약이라 꼭 써줘야해

insert into temp7(id, name, addr) values(10,'홍길동', '서울시 강남구');

insert into temp7(id, name, addr) values(10,'홍ㅇ동', '서ㅇ시 강남구'); --id가 중복이라 안되

select * from temp7;

commit;

--1. primary key 는 테이블에 몇개까지 걸 수 있을까요? 1개...
--여러개의 컬럼을 묶어서 1개는 가능하요 (ename, age) => 복합키...

create table temp8(
  id number constraint pk_temp8_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp8_jumin unique, --null도 허용 >> not null 
  addr varchar2(20)
);

select * from user_constraints where table_name = 'TEMP8';

insert into temp8(id, name, jumin, addr) values (10,'홍길동',123456 ,'경기도');

insert into temp8(id, name, jumin, addr) values (20,'김유신',123456 ,'경기도'); -- 안되용

insert into temp8(id, name, addr) values (20,'김유신','경기도'); --null data 허용 (중복체크는 될까요 ?)


insert into temp8(id, name, addr) values (30,'아무개','강기도'); --null 중복체크 안됨  계속들어감 (not null + unque 같이 사용해서 쓰면됨)

select * from temp8;

--------------------------------------------------------------------------------------------------------------
--테이블 생성 후에 제약 걸기

create table temp9(id number);
--기존 테이블에 제약 추가하기
--주의 ) 기존 데이터가 제약을 위반한다면 제약은 추가되지 않는다. >> 중복된 데이터 >> 데이터 삭제 >> 제약
--제약 걸기전에 데이터검사 작업 수행

alter table temp9
add constraint pk_temp9_id primary key(id);
--add constraint pk_temp9_id primary key(id,name); > 묶어버리는 pk
--2개 컬럼의 값을 합쳐서 중복값이 아니면 되요

select * from user_constraints where table_name = 'TEMP9';

alter table temp9
add ename varchar(20);

alter table temp9
modify (ename not null);

-----------------------------------------------------------------------------------------------------
--[check] 제약
-- where 조건과 동일한 형태의 제약 >> 조건과 동일한 형태의 제약 >> where gender in ('남','여');

create table temp10(
  id number constraint pk_temp10_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp10_jumin unique,
  addr varchar2(20),
  age number constraint ck_temp10_age check(age >= 19)
 );
  
select * from user_constraints where table_name = 'TEMP10';

insert into temp10(id,name,jumin,addr,age)
values(100,'홍길동','123456','서울시',25);

select * from temp10;

insert into temp10(id,name,jumin,addr,age)
values(200,'김유신','123456','부산시',18); --check 제약 걸림

commit;

----------------------------------------------------------------------------------------
-- 참조제약 : 테이블과 테이블과의 제약 >> 
-- EMP (deptno) 컬럼은 DEPT (deptno) 컬럼을 참조한다
--POINT
create table c_emp
as
    select empno, ename, deptno from emp where 1=2;

create table c_dept
as
    select deptno, dname from dept where 1=2;
    
select * from c_emp;
select * from c_dept;

--1. 참조제약 (c_emp 테이블에 있는 deptno 컬럼에 __ deptno 컬럼 insert 되는 데이터는 c.dept 테이블 deptno 가지는
--데이터중에 하나가 insert, update 강제

alter table c_emp
add constraint fk_emp_deptno foreign key(deptno) references c_dept(deptno);
--위 코드 실행 ERROR 발생
--c_dept >> deptno 에서 데이터를 빌려 쓸거야.... (저 신용있어요 빌려가 주세요...
--deptno 가지는 데이터는 중복데이터 없고 null 값 없어요 primary key

--c_dept >> deptno >> primary key 선행

--1
alter table c_dept
add constraint pk_dept_deptno primary key(deptno);
    
--2
alter table c_emp
add constraint fk_emp_deptno foreign key(deptno) references c_dept(deptno);

insert  into c_dept(deptno, dname) values(100,'인사팀');
insert  into c_dept(deptno, dname) values(200,'관리팀');
insert  into c_dept(deptno, dname) values(300,'회계팀');
    
select * from c_dept;

--신입사원 입사
insert into c_emp(empno, ename)
  values(100,'홍길동'); --FK는 not null 하지 않아요 (null값 허용)
--신입사원은 부서를 갖지 않을 수 있따

--규칠 : 신입사원은 무조건 부서를 가져야 한다 (deptno not null constraint _ FK ....
--------------------------------------------------------------------------------

insert into c_emp(empno, ename, deptno) values (200,'아무개',500); --안되는거
insert into c_emp(empno, ename, deptno) values (200,'아무개',300); --되는거

select * from c_emp;

-------------------------------------------------------------------------------
--테이블 (부모, 자식 테이블)
--테이블 (master, detail)
--두개 테이블 deptno 관계에서 __ (부모 : c_dept(PK), master)
--                                           (자식 : c_emp(FK), detail)

--주의점
select*from c_emp;
select*from d_dept;

--이 때 : c_dept 테이블에서 300 데이터 삭제 불가능 (빌려쓰고 있는 데이터)
delete from c_dept where deptno = 300; --빌려주고 있어서 못지움
delete from c_dept where deptno = 100; -- 빌려쓰지 않는 데이터는 삭제 가능
commit;

------------------------------------------------------------------------------------
--오라클.pdf
/*
(column datatype [CONSTRAINT constraint_name]
REFERANECE

*/
--[ON DELETE CASCADE] 부모테이블과 생명을 같이 하겠다
--300 삭제 할 수 있나요? 네
--delete from c_dept where detpno=300;
--참조하는 지식 데이터 같이 삭제
--delete from c_emp where deptno= 300; 같이 실행

--------------------------------------------------------------------------------------
--학생 성적 테이블
--학번의 데이터는 중복되거나 NULL 값을 허용하면 안된다
--이름 NULL 값을 허용하지 않는다
--국어  o
--영어  o
--수학 점수 컬럼은 숫자 타입이고 NULL 값을 허용 
--는 값을 입력하지 않으면  default로 0값을 갖는다 
--총점 ,평균 컬럼은 가상컬럼으로(조합컬럼) 생성한다 o
--학과코드는 학과 테이블에 학과코드를 참조한다 o
--학번 , 이름 , 국어 , 영어 , 수학 , 총점 , 평균 , 학과코드 o

--학과 테이블
--학과코드 데이터는 중복되거나 NULL 값을 허용하면 안된다,
--학과명 은 null값을 허락하지 않는다

--학과코드 , 학과명

--그리고 select 결과는
--학번 , 이름  총점, 평균 , 학과코드 , 학과명 을 출력하세요

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
                  values (12345,'장지훈',100,100,100,1);

insert into major(deptno, dname) values (1,'아이티');

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
--3/22 문제풀이
--규현이형
select round(avg(salary),0) from employees;

select * from employees;

select * from employees
where salary > (select round(avg(salary),0) from employees)
order by salary desc;

--예지

create table copyemp4
as select * from emp; 

update copyemp4
set sAl = (select sum(sal) from emp), hiredate = sysdate;

select * from copyemp4;

---------------------------------------------------------------------------------------------------------------------------
-- 1. EMP 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력하라.

select deptno, count(deptno), sum(sal) 
from emp 
group by deptno having count(deptno) > 4;

-- 2. EMP 테이블에서 가장 많은 사원이 속해있는 부서번호와 사원수를 출력하라.

select deptno as "부서번호", count(deptno) as "사원수" from emp group by deptno 
having count(deptno) = (select max(count(deptno)) from emp group by deptno);



select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join (select deptno, round(avg(sal),0) as avgsal from emp group by deptno) s 
on e.deptno = s.deptno
where e.sal > s.avgsal;

-- 3. EMP 테이블에서 가장 많은 사원을 갖는 MGR의 사원번호를 출력하라.

select mgr as "No1 MGR" from emp group by mgr 
having count(nvl(mgr,0)) = (select max(count(mgr)) 
from emp group by mgr);

-- 4. EMP 테이블에서 부서번호가 10인 사원수와 부서번호가 30인 사원수를 각각 출력하라.

select deptno as "부서번호", count(deptno) as "사원 수" from emp
group by deptno having deptno in(10,30);

-- 5. EMP 테이블에서 사원번호가 7521인 사원의 직업과 같고 사원번호가 7934인 사원의 급여(SAL)보다 많은 사원의 사원번호, 이름, 직업, 급여를 출력하라.

select empno, ename, job, sal from emp
where job = (select job from emp where empno = 7521)
   and sal > (select sal from emp where empno = 7934);

-- 6. 직업(JOB)별로 최소 급여를 받는 사원의 정보를 사원번호, 이름, 업무, 부서명을 출력하라.
-- 조건1 : 직업별로 내림차순 정렬

select e.empno as "사원번호", e.ename as "이름", e.job as "업무", d.dname as "부서명"
from emp e join dept d on e.deptno = d.deptno
where e.sal in (select min(sal) from emp group by job)
order by e.job desc;

-- 7. 각 사원 별 시급을 계산하여 부서번호, 사원이름, 시급을 출력하라.

-- 조건1. 한달 근무일수는 20일, 하루 근무시간은 8시간이다.

-- 조건2. 시급은 소수 두 번째 자리에서 반올림한다.

-- 조건3. 부서별로 오름차순 정렬

-- 조건4. 시급이 많은 순으로 출력

select deptno, ename ,round((sal/20/8),2) as "시급" from emp
order by deptno asc, "시급" asc;

-- 8. 각 사원 별 커미션이 0 또는 NULL이고 부서위치가 ‘GO’로 끝나는 사원의 정보를 사원번호, 
--사원이름, 커미션, 부서번호, 부서명, 부서위치를 출력하라.

-- 조건1. 보너스가 NULL이면 0으로 출력

select e.empno as "사번",
          e.ename as "이름",
          nvl(e.comm,0) as "수당",
          e.deptno as "부서번호",
          d.dname as "부서명",
          d.loc as "부서위치"
from emp e join dept d on e.deptno = d.deptno
where nvl(e.comm,0) = 0 and d.loc like '%GO';

-- 9. 각 부서 별 평균 급여가 2000 이상이면 초과, 그렇지 않으면 미만을 출력하라.

select round(avg(sal),0) as "평균", case when avg(sal) > 2000 then '초과'
                                                      else '미만'
                                              end "2000"
from emp group by deptno; 

-- 10. 각 부서 별 입사일이 가장 오래된 사원을 한 명씩 선별해 사원번호, 사원명, 부서번호, 입사일을 출력하라.

select empno, ename, deptno, hiredate from emp
where sysdate-hiredate in (select max(sysdate-hiredate) from emp group by deptno);

-- 11. 1980년~1980년 사이에 입사된 각 부서별 사원수를 부서번호, 부서명, 입사1980, 입사1981, 입사1982로 출력하라.

select e.deptno, d.dname,
         count(decode(to_char(hiredate,'yyyy'),'1980',1)) as "입사 1980",
         count(decode(to_char(hiredate,'yyyy'),'1981',1)) as "입사 1981",
         count(decode(to_char(hiredate,'yyyy'),'1982',1)) as "입사 1982",
         count(decode(to_char(hiredate,'yyyy'),'1983',1)) as "입사 1983"
from emp e join dept d on e.deptno = d.deptno
group by e.deptno , d.dname;

-- 12. 1981년 5월 31일 이후 입사자 중 커미션이 NULL이거나 0인 사원의 커미션은 500으로 그렇지 않으면 기존 커미션을 출력하라.

select hiredate from emp;
select hiredate ,decode(nvl(comm,0),0,500,
                                   comm) as "수당" 
from emp where hiredate > '1981/05/31';

-- 13. 1981년 6월 1일 ~ 1981년 12월 31일 입사자 중 부서명이 SALES인 사원의 부서번호, 사원명, 직업, 입사일을 출력하라.

-- 조건1. 입사일 오름차순 정렬

select e.deptno, e.ename, e.job, e.hiredate 
from emp e join dept d on e.deptno = d.deptno 
where hiredate between '1981/06/01' and '1981/12/31' and d.dname = 'SALES'
order by hiredate asc;

-- 14. 현재 시간과 현재 시간으로부터 한 시간 후의 시간을 출력하라.

-- 조건1. 현재시간 포맷은 ‘4자리년-2자일월-2자리일 24시:2자리분:2자리초’로 출력

-- 조건1. 한시간후 포맷은 ‘4자리년-2자일월-2자리일 24시:2자리분:2자리초’로 출력

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

select SYSDATE, sysdate + 1/24 from dual;

-- 15. 각 부서별 사원수를 출력하라.

-- 조건1. 부서별 사원수가 없더라도 부서번호, 부서명은 출력

-- 조건2. 부서별 사원수가 0인 경우 ‘없음’ 출력

-- 조건3. 부서번호 오름차순 정렬

select e.deptno, decode(count(e.deptno),0,'없음',
                                                            count(e.deptno)) --기타등등 
from emp e right outer join dept d on e.deptno = d.deptno
group by e.deptno;


-- 16. 사원 테이블에서 각 사원의 사원번호, 사원명, 매니저번호, 매니저명을 출력하라.

-- 조건1. 각 사원의 급여(SAL)는 매니저 급여보다 많거나 같다.

select e.deptno, e.ename, e.mgr, m.ename
from emp e join emp m on m.empno = e.mgr
where e.sal > m.sal;

-- 18. 사원명의 첫 글자가 ‘A’이고, 처음과 끝 사이에 ‘LL’이 들어가는 사원의 커미션이 COMM2일때, 모든 사원의 커미션에 COMM2를 
-- 더한 결과를 사원명, COMM, COMM2, COMM+COMM2로 출력하라.

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

-- 19. 각 부서별로 1981년 5월 31일 이후 입사자의 부서번호, 부서명, 사원번호, 사원명, 입사일을 출력하시오.

-- 조건1. 부서별 사원정보가 없더라도 부서번호, 부서명은 출력

-- 조건2. 부서번호 오름차순 정렬

-- 조건3. 입사일 오름차순 정렬

select e.deptno, d.dname, e.ename, e.hiredate
from emp e right outer join dept d on e.deptno = d.deptno 
                                                       and  hiredate > '1981/05/31'
order by e.deptno, e.hiredate;

select deptno from dept;

-- 20. 입사일로부터 지금까지 근무년수가 30년 이상 미만인 사원의 사원번호, 사원명, 입사일, 근무년수를 출력하라.

-- 조건1. 근무년수는 월을 기준으로 버림 (예:30.4년 = 30년, 30.7년=30년)

select empno, ename, hiredate, trunc((sysdate - hiredate)/365,0) as "근무년수" from emp;
-- 최소 37년된거같은딩 ㅠ


--------------------------------------------------------------------------------------------------------------------
--view 객체(create ....)
--create view 뷰이름 as [select 구문]    (view 통해서 볼수 있는 데이터 목록)
--view 는 테이블처럼 사용가능 (가상테이블) -> emp, dept 같은 논리로 접근 사용
--view 메모리상에만 존재하는 가상테이블 (subquery -> i line view -> from(select deptno, avg(Sas)..)

--view 가상 테이블
--사용법 : 일반 테이블과 사용법이 동일 (select.. where...)
--DML(insert, update, delete) -> view 통해서 dml 가능 -> view 가지고 있는 (볼 수 있는) - > 실 테이블 데이터를 변경


--------------------------------------------------------------------------------------------------------------
--3/25

--view 는 별도의 권한 필요 ORA-01031: insufficient privileges
create view v_001
as
    select empno, ename from emp;
    
    
select * from v_001; --view 가지고 있는 sql 문장을 실행한다

--VIEW 사용 목적
--1. 개발자의 편리성 (JOIN, SUBQUERY) 가상테이블 개념...
--2. 편리성 (쿼리 단순화) -> 복잡한 것을 미리 만들어 두고 사용
--3. 보안(권한 처리) -> 노출하고 싶은 데이터만 모아서 view 생성 -> view

create view v_emp
as
    select empno, ename, job, hiredate from emp;

select empno, ename job, hiredate from v_emp;
select * from v_emp;
select empno, ename from v_emp;
select * from v_emp where empno=7788;

--편리성 (쿼리 산순화)
create view v_002
as
   select e.empno, e.ename, d.deptno, d.dname
   from emp e join dept d 
   on e.deptno = d.deptno;
   
select * from v_002;
select * from v_002 where deptno=30;

create view v_003 --view는 가상 테이블    조작컬럼은 컬럼명을 만들어줘야 된다
as
    select deptno, avg(sal) as avgsal
    from emp
    group by deptno;

select * from v_003;

select *
from emp e join v_003 s      --저번에는 join(select ...) 서브쿼리 이용해서 풀었었음
on e.deptno = s.deptno
where e.sal > s.avgsal;


--테이블 1개 이상 ... JOIN... 안되면 .... subquery .... 가상테이블 (view)

/*
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name [(alias[,alias,...])]
AS Subquery
[WITH CHECK OPTION [CONSTRAINT constraint ]]
[WITH READ ONLY

OR REPLACE 이미 존재한다면 다시 생성한다.
FORCE Base Table 유무에 관계없이 VIEW 을 만든다.
NOFORCE 기본 테이블이 존재할 경우에만 VIEW 를 생성한다.
view_name VIEW 의 이름
Alias Subquery 를 통해 선택된 값에 대한 Column 명이 된다.
Subquery SELECT 문장을 기술한다.
WITH CHECK OPTION VIEW 에 의해 액세스 될 수 있는 행만이 입력,갱신될 수 있다.
Constraint CHECK OPTON 제약 조건에 대해 지정된 이름이다.
WITH READ ONLY 이 VIEW 에서 DML 이 수행될 수 없게 한다.
*/

drop view v_007;

create or replace view v_007
as
    select avg(sal) as avgsal from emp; --함수 ....

select * from v_007;

create or replace view v_007
as
    select round(avg(sal),0) as avgsal from emp;

--view 통한 DML 가능 (insert, update, delete)
--단 view 텡니블이 아니기 때문에 view 통해서 볼 수 있는 데이터에 대해서만
--복합 view(1개 이상의 테이블 구성) --->DML불가
--단순 view (테이블 1개 로) 만든 view

select * from v_emp; --view 통해서 볼 수 있는 데이터 (empno, ename, job, hiredate)

update v_emp
set sal = 0;        --(x)

update v_emp -- 원본 테이블가서... 데이트를 update -- 결국 emp 테이블 데이터 변경
set job = 'IT';

select * from emp;
select * from v_emp;
rollback;


create or replace view v_emp2
as
    select * from emp where deptno = 20;

update v_emp2
set sal  = 0;                 -- 자기가 볼 수 있는 데이터만 바뀜
                                  --  부서번호가 20번인 사람들만 0이됨

select * from emp;
select * from v_emp2;

rollback;

--view 목록보기
select * from user_views;

------------------------------------------------------------------------------------------------------

--1. 30번 부서 사원들의 직위, 이름, 월급을 담는 view를 만들어라

create or replace view v_emp30
as
    select job, ename, sal 
    from emp 
    where deptno = 30;

select * from v_emp30;

--2. 30번 부서 사원들의  직위, 이름, 월급을 담는 VIEW를 만드는데,
-- 각각의 컬럼명을 직위, 사원이름, 월급으로 ALIAS를 주고 월급이
-- 300보다 많은 사원들만 추출하도록 하라.
-- create or replace view view001 (컬럼명, 컬럼명, .....)  

 create or replace view v_emp30
as
    select job as 직위, ename as 사원이름, sal as 월급 
    from emp 
    where deptno = 30 and sal > 300;

select * from v_emp30;
 
--3. 부서별 최대월급, 최소월급, 평균월급을 담는 VIEW를 만들어라.

create or replace view v_emp30
as
    select deptno, max(sal) as 최대월급, min(sal) as 최소월급, avg(sal) as 평균월급 
    from emp 
    group by deptno;


select * from v_emp30 ;
       
--4. 부서별 평균월급을 담는 VIEW를 만들되, 평균월급이 2000 이상인
-- 부서만 출력하도록 하라.

CREATE OR REPLACE VIEW VIEW103
AS
 SELECT DEPTNO, AVG(SAL) AS "평균월급"
 FROM EMP
 GROUP BY DEPTNO
 HAVING AVG(SAL) >=2000;
 
----------------------------------------
SELECT v.deptno,v.평균월급 , d.dname
FROM view103 v JOIN dept d
ON v.deptno = d.deptno;
-----------------------------------------
 
--5. 직위별 총월급을 담는 VIEW를 만들되, 직위가 MANAGER인
-- 사원들은 제외하고 총월급이 3000이상인 직위만 출력하도록 하라.


CREATE OR REPLACE VIEW VIEW104
AS
 SELECT JOB, SUM(SAL) AS "총월급"
 FROM EMP
 WHERE JOB!='MANAGER'
 GROUP BY JOB
 HAVING SUM(SAL)>=3000;
 
SELECT * FROM VIEW104;


---------------------------------------------------------------------------------------------------------
-- db 
             --개발자 : app (crud)
             --관리자 : 백업 과 복원 (관리 : 네트워크, 권한 .....)
             --튜닝 : APP + DB + 네트워크
                        --SQL 튜닝
                        --SERVER 튜닝
             --설계 : 모델링 (업무 지식 중요)
    
--sequence 시퀀스
--오라클 pdf 185page
/*
CREATE  SEQUENCE  sequence_name 
[INCREMENT  BY  n]  [START  WITH  n] 
[{MAXVALUE n | NOMAXVALUE}] 
[{MINVALUE n | NOMINVALUE}]  
[{CYCLE | NOCYCLE}] 
[{CACHE | NOCACHE}];


sequence_name  SEQUENCE 의 이름입니다. 
INCREMENT  BY  n 정수 값인 n 으로 SEQUENCE 번호 사이의 간격을 지정. 
    이 절이 생략되면 SEQUENCE 는 1 씩 증가. 
START  WITH  n  생성하기 위해 첫번째 SEQUENCE 를 지정. 
    이 절이 생략되면 SEQUENCE 는 1 로 시작. 
MAXVALUE n  SEQUENCE 를 생성할 수 있는 최대 값을 지정. 
NOMAXVALUE   오름차순용 10^27 최대값과 내림차순용-1 의 최소값을 지정. 
MINVALUE n  최소 SEQUENCE 값을 지정. 
NOMINVALUE  오름차순용 1 과 내림차순용-(10^26)의 최소값을 지정. 
CYCLE | NOCYCLE  최대 또는 최소값에 도달한 후에 계속 값을 생성할 지의 여부를 
    지정. NOCYCLE 이 디폴트. 
CACHE | NOCACHE  얼마나 많은 값이 메모리에 오라클 서버가 미리 할당하고 유지 
    하는가를 지정. 디폴트로 오라클 서버는 20 을 CACHE. 
*/
drop table board;

create table board(
  boardid number constraint pk_board_id primary key,
  title varchar2(100)
);

--boardid 컬럼 (nof null, unique, index 구성된다)
--개발자 : boardid 데이터는 ....
--개발자 : where boardid = 무조건 한건의 데이터

--insert into board(boardid, title) values(.....
--그러면 중복되지 않고, null 값이 아니다 라는 보장...

--조건 : 처음 ㄱ글을 쓰면 1이라는 값을 insert ... 그 다음 글 부터는 2,3,4, 순차적인 값을 insert
--쿼리문 (insert)

insert into board(boardid, title) values ((select count(boardid)+1 from board), '제목');
select * from board;

--위 count() 문제점 제기 (DML)
delete from board where boardid = 1;

select * from board;
insert into board(boardid, title) values((select count(boardid) +1 from board),'제목3');
--지우고 다시하면  중복값이 나와  오류나옴
----------------------------------------------------------------------------------
--다른방법 max, nvl
-- 중간값이 사라지면   값이 채워지진 않는다 오류는 없다   1,2,4
select * from board;

insert into board(boardid, title)
values ((select nvl(max(boardid),0) from board) + 1,'처음');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) from board) + 1,'두번째');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) from board) + 1,'세번째');

select * from board;
insert into board(boardid, title) values( (select decode(count(boardid),null,0,count(boardid)+1) from board),'ss');
insert into board(boardid, title) values( (select decode(count(boardid),null,0,count(boardid)+1) from board),'sㄴㄴ');


--------------------------------------------------------------------------------------
--sequence 번호 추출 ( 규칙) : 중복값이 없고 순차적인 값 (공유객체)
--------------------------------------------------------------------------------------
create sequence board_num;

select * from sys.user_sequences;

/*
1.4.1 NEXTVAL 과 CURRVAL 의사열
가) 특징
1) NEXTVAL 는 다음 사용 가능한 SEQUENCE 값을 반환 한다.
－188－
2) SEQUENCE 가 참조될 때 마다, 다른 사용자에게 조차도 유일한 값을 반환한다.
3) CURRVAL 은 현재 SEQUENCE 값을 얻는다.
4) CURRVAL 이 참조되기 전에 NEXTVAL 이 사용되어야 한다
*/

--실재번
select board_num.nextval from dual; -- 몇번째인지 리턴

--몇번까지 했죠? (현재값 채번하지 않고 정보만 출력
select board_num.currval from dual;
---------------------------------------------------------------------------------------------
create sequence kboard_num;


create table kboard(
  num number constraint pk_kboard_id primary key,
  title varchar2(100)
);

insert into kboard(num, title) values ((kboard_num.nextval),'처음글');

select * from kboard;
select kboard_num.currval from dual;

insert into kboard(num, title) values ((kboard_num.nextval),'두번째 글');
insert into kboard(num, title) values ((kboard_num.nextval),'세번째 글');
insert into kboard(num, title) values ((kboard_num.nextval),'네번째 글');

delete from kboard where num = 2;
rollback;
------------------------------------------------------------------------------------
--1. sequence 객체 하나 >> 여러개의 테이블에서 사용가능 (가능하다)
--A (1),(4) , B(2), C(3)

--사이트 (게시판) 10개
--상품 게시판, 관리자 게시판, 회원게시판
--sequence 따로 만들어서 사용 .... 하나의 sequence 를 공유해도 된다

-- TIP)
-- ms-sql : create table board(boardnum int identity(1,1) , title varchar(20))
-- insert into board(title) values('방가') --> boardnum 1 값이 자동 insert
-- ms-sql 2012 부터 sequence 부터 도입되었어요

-- my-sql  : create table board(boardnum int auto_increment, title varchar(20));
-- --insert into board(title) values('방가')

--https://mariodb.com/en/library/create-sequence/ sequence 객체존재
----------------------------------------------------------------------------------

--sequence 객체 옵션
create sequence seq_num
start with 10
increment by 2;

select seq_num.nextval from dual;
select seq_num.currval from dual;


--게시한 글을 insert
--게사판 최신글 순으로 보이기

--게시판 글을 insert
--게시판 최신글 순으로 보이기
--select * from board order by boardnum desc;
----------------------------------------------------------------------------------------

--개발자 필수 2
--rownum 의사컬럼 : 실제 물리적으로 존재하는 컬럼이 아니고 논리적인 존재

--ROWNUM : 실제로 테이블에 컬럼으로 존재하지 않지만 내부적으로 형 번호 부여할 수 있는 의사 컬럼
--ROWID : 주소값 담고있음  (행이 실제로 저장되는 내부 주소값) -> 인덱스 만들 때 사용

select * from emp;

select rownum as 순번, empno, ename from emp;
--select 한 결과를 가지고 순번을 붙임

-- Top - n 쿼리
-- 테이블에서 조건에 맞는 상위 (TOP) 레코드(row) n개 추출

-- ms-sql 서버
-- select top 10 , " from emp oder by  sal dsc;

-- oracle
-- rownum(의사컬럼) : 기준을 정의
------------------------------------------------------------------------------------------------------
--rownum
--1. 정렬의 기준을 정의하는 작업(선행)
--2. 정렬이 된 상황에서 앞에 순번 -> 조건절 제시 -> 데이터 추출
 

--1단계
select *
from( 
        select * 
        from emp order by sal desc)
      e;

--2단계
select rownum as "num", e.*
from( 
        select * 
        from emp order by sal desc)
      e;

--3단계 (급여 많이 받는 사원 5명...)

select rownum as "num", e.*
from( 
        select * 
        from emp order by sal desc) e
where rownum <= 5;

---------------------------------------------------------------------------------
--게시판  만들기 페이징 처리 필수 .....
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
--게시판 (페이징 처리)
--1000건 데이터
--10건씩 나누어서 보여주는 것

--총 100건
--pagesize = 10 (한 화면에 (페이지) 보여줄 데이터 건수 row 수)
--page개수 >>10

--1~10 1page (DB에서 1~10번글까지 select 가지고 app출력)
--11~20 2page
--...
--91~100 10page
------------------------------------------------------------------------------------------------
--HR 계정으로 이동
select * from employees;
--41 ~ 50 사원데이터 출력하세요
--복습
select *
from 
        (
          select rownum as num, e.*
          from( 
                  select * 
                  from employees order by employee_id asc --기준점
        ) e
 )n
 where num  between 41 and 50;


--pagesize = 10 사원데이터 출력하세요(조건 - 사원은 낮은순으로)
--1~10, 11~20, 21~30

--또는 between A and B >> where rownum between 10 and 20 사용해도 됩니다
-------------------------------------------------------------------------
--sql 기본 과정 end-------------------------------------------------------

--sql 고급과정 (3차 프로젝트 전에0
--고급쿼리 (순위)...
--pl-sql
--(변수, 제어문, 커서, 함수, 프로시저,트리거, 스케쥴....)


--1차 종합 test 50문제

--1> 부서테이블의 모든 데이터를 출력하라.
 select * from dept;
--2> EMP테이블에서 각 사원의 직업, 사원번호, 이름, 입사일을 출력하라.
 select job, empno, ename, hiredate from emp;
--3> EMP테이블에서 직업을 출력하되, 각 항목(ROW)가 중복되지 않게
-- 출력하라.
  select distinct job from emp; 
--4> 급여가 2850 이상인 사원의 이름 및 급여를 출력하라.
  select ename, sal from emp where sal > 2850;
--5> 사원번호가 7566인 사원의 이름 및 부서번호를 출력하라.
 select ename, empno from emp where empno = 7566;
--6> 급여가 1500이상 ~ 2850이하의 범위에 속하지 않는 모든 사원의 이름
-- 및 급여를 출력하라.
 select ename, sal from emp where sal not between 1500 and 2850;
--7> 1981년 2월 20일 ~ 1981년 5월 1일에 입사한 사원의 이름,직업 및 
--입사일을 출력하라. 입사일을 기준으로 해서 오름차순으로 정렬하라.
 select ename, job, hiredate from emp 
 where hiredate between '81/02/20' and '81/05/01'
 order by hiredate asc;
--8> 10번 및 30번 부서에 속하는 모든 사원의 이름과 부서 번호를
-- 출력하되, 이름을 알파벳순으로 정렬하여 출력하라.
 select ename, deptno from emp where deptno in (10,30) order by ename asc;
--9> 10번 및 30번 부서에 속하는 모든 사원 중 급여가 1500을 넘는
-- 사원의 이름 및 급여를 출력하라.
--(단 컬럼명을 각각 employee 및 Monthly Salary로 지정하시오)
 select ename as "employee", sal as "monthly Salary" 
 from emp 
 where deptno in (10,30) and sal > 1500;
--10> 관리자가 없는 모든 사원의 이름 및 직위를 출력하라.
 select ename, job from emp where mgr is null;
--11> 커미션을 받는 모든 사원의 이름, 급여 및 커미션을 출력하되, 
-- 급여를 기준으로 내림차순으로 정렬하여 출력하라.
 select ename, sal, comm from emp where nvl(comm,0) != 0 order by sal;
--12> 이름의 세 번째 문자가 A인 모든 사원의 이름을 출력하라.
 select ename from emp where ename like '__A%';
--13> 이름에 L이 두 번 들어가며 부서 30에 속해있는 사원의 이름을 
--출력하라.
 select ename from emp where ename like '%L%L%' and deptno = 30;
--14> 직업이 Clerk 또는 Analyst 이면서 급여가 1000,3000,5000 이 
-- 아닌 모든 사원의 이름, 직업 및 급여를 출력하라.
 select ename, job from emp where job in('CLERK','ANALYST') and sal not in (1000,3000,5000);
--15> 사원번호, 이름, 급여 그리고 15%인상된 급여를 정수로 표시하되 
--컬럼명을 New Salary로 지정하여 출력하라.
 select empno, ename, sal, round(sal*1.15,0) as "New Salary" from emp;
--16> 15번 문제와 동일한 데이타에서 급여 인상분(새 급여에서 이전 
-- 급여를 뺀 값)을 추가해서 출력하라.(컬럼명은 Increase로 하라). 
 
 
 
--18> 모든 사원의 이름(첫 글자는 
-- 대문자로, 나머지 글자는 소문자로 표시) 및 이름 길이를 표시하는
-- 쿼리를 작성하고 컬럼 별칭은 적당히 넣어서 출력하라.
 
 
--19> 사원의 이름과 커미션을 출력하되, 커미션이 책정되지 않은 
-- 사원의 커미션은 'no commission'으로 출력하라.
 select ename, decode(nvl(comm,0),0,'no commission',comm) from emp;
 
 
--20> 모든 사원의 이름,부서번호,부서이름을 표시하는 질의를 작성하라.
 
 
--21> 30번 부서에 속한 사원의 이름과 부서번호 그리고 부서이름을 출력하라.
 select e.ename, d.deptno, d.dname
 from emp e join dept d on e.deptno = d.deptno;
--22> 30번 부서에 속한 사원들의 모든 직업과 부서위치를 출력하라.
--(단, 직업 목록이 중복되지 않게 하라.)
 
 
--23> 커미션이 책정되어 있는 모든 사원의 이름, 부서이름 및 위치를 출력하라.
  select e.ename, d.deptno, d.dname, d.loc
 from emp e join dept d on e.deptno = d.deptno
 where nvl(comm,0) !=0;
--24> 이름에 A가 들어가는 모든 사원의 이름과 부서 이름을 출력하라.
 
 
--25> Dallas에서 근무하는 모든 사원의 이름, 직업, 부서번호 및 부서이름을 
-- 출력하라.
 select e.ename, job, d.deptno, d.dname
 from emp e join dept d on e.deptno = d.deptno
 where d.loc = 'DALLAS';
 
--26> 사원이름 및 사원번호, 해당 관리자이름 및 관리자 번호를 출력하되,
-- 각 컬럼명을 employee,emp#,manager,mgr#으로 표시하여 출력하라.
 
--27> 모든 사원의 이름,직업,부서이름,급여 및 등급을 출력하라.
 select e.ename, e.job, d.dname, e.sal, s.grade
 from emp e join dept d on e.deptno = d.deptno
                  join salgrade s on e.sal between s.losal and s.hisal;
--28> Smith보다 늦게 입사한 사원의 이름 및 입사일을 출력하라.
 
--29> 자신의 관리자보다 먼저 입사한 모든 사원의 이름, 입사일, 
-- 관리자의 이름, 관리자의 입사일을 출력하되 각각 컬럼명을 
-- Employee,EmpHiredate, Manager,MgrHiredate로 표시하여 
-- 출력하라.
 select e.ename as "Employee", e.hiredate as "EmpHiredate", m.ename as "Manager", m.hiredate as "MgrHiredate"
 from emp e join emp m on m.empno = e.mgr;
 
--30> 모든 사원의 급여 최고액,최저액,총액 및 평균액을 출력하되 
-- 각 컬럼명을 Maximum,Minimum,Sum,Average로 지정하여 출력하라.
 
--31> 각 직업별로 급여 최저액.최고액,총액 및 평균액을 출력하라.
 select  job, min(sal), max(sal), sum(sal), avg(sal) from emp group by job;
--32> 직업이 동일한 사람 수를 직업과 같이 출력하라.

--33> 관리자의 수를 출력하되, 관리자 번호가 중복되지 않게하라.
-- 그리고, 컬럼명을 Number of Manager로 지정하여 출력하라.
 select count(job) as "Number of Manager" from emp where job = 'MANAGER'; 
--34> 최고 급여와 최저 급여의 차액을 출력하라.
 
--35> 관리자 번호 및 해당 관리자에 속한 사원들의 최저 급여를 출력하라.
-- 단, 관리자가 없는 사원 및 최저 급여가 1000 미만인 그룹은 제외시키고 
-- 급여를 기준으로 출력 결과를 내림차순으로 정렬하라.
 select min(sal) from emp 
 group by mgr having mgr is not null and min(sal) >1000
 order by avg(sal) desc;

--36> 부서별로 부서이름, 부서위치, 사원 수 및 평균 급여를 출력하라.
-- 그리고 각각의 컬럼명을 부서명,위치,사원의 수,평균급여로 표시하라.
 
 
--37> Smith와 동일한 부서에 속한 모든 사원의 이름 및 입사일을 출력하라.
-- 단, Smith는 제외하고 출력하시오
 select deptno from emp where ename = 'SMITH';
 select ename, hiredate from emp where deptno = (select deptno from emp where ename = 'SMITH') and ename != 'SMITH';
 
--38> 자신의 급여가 평균 급여보다 많은 모든 사원의 사원 번호, 이름, 급여를 
--    표시하는 질의를 작성하고 급여를 기준으로 결과를 내림차순으로 정렬하라.
 
 
--39> 이름에 T가 들어가는 사원의 속한 부서에서 근무하는 모든 사원의 사원번호
-- 및 이름을 출력하라.
 select deptno from emp where ename like '%T%';
 select empno, ename from emp where deptno in (select deptno from emp where ename like '%T%');
--40> 부서위치가 Dallas인 모든 사원의 이름,부서번호 및 직위를 출력하라.
 
 
--41> KING에게 보고하는 모든 사원의 이름과 급여를 출력하라.
 select EMPNO from emp where ename = 'KING';
 select ename, sal from emp where mgr = (select EMPNO from emp where ename = 'KING');
--42> Sales 부서의 모든 사원에 대한 부서번호, 이름 및 직위를 출력하라.
 
 
--43> 자신의 급여가 평균 급여보다 많고 이름에 T가 들어가는 사원과 동일한
-- 부서에 근무하는 모든 사원의 사원 번호, 이름 및 급여를 출력하라.
 select round(avg(sal),0) from emp;
 select deptno from emp where ename like '%T%';
 
 select empno, ename, sal from emp where sal > (select round(avg(sal),0) from emp) and deptno = (select deptno from emp where ename like '%T%');
 --다시
 
--44> 커미션을 받는 사원과 급여가 일치하는 사원의 이름,부서번호,급여를 
-- 출력하라.
 select ename, deptno, sal from emp where sal in (select sal from emp where nvl(comm,0) != 0);
 select sal from emp where nvl(comm,0) != 0;
--45> Dallas에서 근무하는 사원과 직업이 일치하는 사원의 이름,부서이름,
--     및 급여를 출력하시오
 select job from emp e join dept d on e.deptno = d.deptno where d.loc = 'DALLAS';
 select e.ename, d.dname, e.sal from emp e join dept d on e.deptno = d.deptno
 where job  IN (select job from emp e join dept d on e.deptno = d.deptno where d.loc = 'DALLAS');
--46> Scott과 동일한 급여 및 커미션을 받는 모든 사원의 이름, 입사일 및 
-- 급여를 출력하시오
 
 
--47> 직업이 Clerk 인 사원들보다 더 많은 급여를 받는 사원의 사원번호,
-- 이름, 급여를 출력하되, 결과를 급여가 높은 순으로 정렬하라.
 select ename, sal, empno from emp where sal in (select sal from emp where job = 'CLERK')
 order by sal desc;
  
--48> 이름에 A가 들어가는 사원과 같은 직업을 가진 사원의 이름과
-- 월급, 부서번호를 출력하라.
 
 
--49> New  York 에서 근무하는 사원과 급여 및 커미션이 같은 사원의 
-- 사원이름과 부서명을 출력하라.

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

--50> Dallas에서 근무하는 사원과 직업 및 관리자가 같은 사원의 사원번호,사원이름,
--    직업,월급,부서명,커미션을 출력하되 커미션이 책정되지 않은 사원은 NoCommission
--    으로 표시하고, 커미션의 컬럼명은 Comm으로 나오게 출력하시오.
--    단, 최고월급부터 출력되게 하시오

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

insert into department(deptno, dname) values (1,'장지훈');
commit;

select * from dept;

update department set dname='부부' where deptno=30;
commit;

delete from


create table temp22222(
  id number constraint pk_temp8_id primary key,
  name varchar(20) not null,
  jumin char(6) constraint uk_temp8_jumin unique, --null도 허용 >> not null 
  addr varchar2(20)
);

