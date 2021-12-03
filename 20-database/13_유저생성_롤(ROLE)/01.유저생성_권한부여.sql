/* ********* 사용자 생성, 삭제 *********
-- 사용자 생성 : CREATE USER
CREATE USER 사용자명(유저명) --"MDGUEST" 
IDENTIFIED BY 비밀번호 --"mdguest"  
DEFAULT TABLESPACE 테이블스페이스 --"USERS"
TEMPORARY TABLESPACE 임시작업테이블스페이스 --"TEMP";

-- 사용할 용량 지정(수정)
ALTER USER "MDGUEST" QUOTA UNLIMITED ON "USERS";

-- 사용자 수정 : ALTER USER 
ALTER USER 사용자명(유저명) IDENTIFIED BY 비밀번호;

-- 권한부여(롤 사용 권한 부여, 롤 부여)
GRANT "CONNECT" TO "MDGUEST" ;
GRANT "RESOURCE" TO "MDGUEST" ;

-- 사용자 삭제 : DROP USER
DROP USER 유저명 [CASCADE];
--CASCADE : 삭제시점에 사용자(유저)가 보유한 모든 데이타 삭제
*************************************/
--관리자 계정 ID: MYGUEST 비밀번호: myguest
-- 유저 생성 + 테이블스페이스 지정
ALTER USER "MYGUEST"
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
ACCOUNT UNLOCK ;

-- 유저 수정 용량 설정(QUOTAS)
ALTER USER "MYGUEST" QUOTA UNLIMITED ON "USERS";

-- 롤(역할) 부여(ROLES)
ALTER USER "MYGUEST" DEFAULT ROLE "CONNECT","RESOURCE";

--권한부여 - 뷰 생성권한
GRANT CREATE ANY VIEW TO "MYGUEST" ;

-----------------------------------------------------------
--(SYSTEM) CONNECT, RESOURCE 롤(ROLE)에 있는 권한 확인
SELECT *
 FROM DBA_SYS_PRIVS
 WHERE GRANTEE IN ('CONNECT', 'RESOUTCE')
 ORDER BY GRANTEE, PRIVILEGE
; 


--------------------------------------------------------------
--=============================
/****** 권한 부여(GRANT), 권한 취소(REVOKE) **********************
GRANT 권한 [ON 객체] TO {사용자|ROLE|PUBLIC,.., n} [WITH GRANT OPTION]
--PUBLIC은 모든 사용자에게 적용을 의미

GRANT 권한 TO 사용자; --권한을 사용자에게 부여
GRANT 권한 ON 객체 TO 사용자; -객체에 대한 권한을 사용자에게 부여
-->> WITH GRANT OPTION :객체에 대한 권한을 사용자에게 부여 
-- 권한을 받은 사용자가 다른 사용자에게 권한부여할 권리 포함
GRANT 권한 ON 객체 TO 사용자 WITH GRANT OPTION;
--------------------
-->>>권한 취소(REVOKE)
REVOKE 권한 [ON 객체] FROM {사용자|ROLE|PUBLIC,.., n} CASCADE
--CASCADE는 사용자가 다른 사용자에게 부여한 권한까지 취소시킴
  (확인 및 검증 후 작업)

REVOKE 권한 FROM 사용자; --권한을 사용자에게 부여
REVOKE 권한 ON 객체 FROM 사용자; -객체에 대한 권한을 사용자에게 부여
*************************************************/
-- 권한 부여: MADANG 유저의 BOOK 테이블에 대한 SELECT 권한을 MDGUEST에 부여
--(SYSTEM) 권한부여 - MADANG.BOOK을 SELECT 할 수 있는 권한을 MDGUEST에 부여




--========= MADANG 유저에서 권한부여, 권한취소 ===============
--(MADANG) CUSTOMER 테이블에 대하여 MYGUEST 유저에게
-- SELECT, UPDATE 권한 부여
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MYGUEST; -- 권한 부여
REVOKE SELECT, UPDATE ON MADANG.CUSTOMER FROM MYGUEST; -- 권한 회수

--(MYGUEST) SELECT, UPDATE 작업 가능
SELECT * FROM MADANG.CUSTOMER;
UPDATE MADANG.CUSTOMER 
 SET PHONE = '010-1111-2222'
 WHERE CUSTID = 5;
DELETE FROM MADANG.CUSTOMER WHERE CUSTID = 5; 

--(MADAGNG) SELECT, UPDATE 권한 취소
REVOKE SELECT, UPDATE ON CUSTOMER FROM MYGUEST;
--(MYGUEST) SELECT, UPDATE 권한 취소후 테이블에 접근 할 수 없다.
-- ORA-00942: table or view does not exist

--------------------------------------------
-- USER SQL
CREATE USER "MDGUEST2" IDENTIFIED BY "mdguest2"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS
ALTER USER "MDGUEST2" QUOTA UNLIMITED ON "USERS";

-- ROLES
GRANT "CONNECT" TO "MDGUEST2" ;
GRANT "RESOURCE" TO "MDGUEST2" ;


-- WITH GRANT OPTION: 다른 유저에게 권한 부여 할 수 있도록 허용
-- (MADANG) MADANG 유저가 MDGUEST에게 권한 부여
GRANT SELECT, UPDATE ON CUSTOMER TO MYGUEST WITH GRANT OPTION; -- 권한 부여
-- (MDGUEST) MDGUEST 유저가 MDGUEST2에게 권한 부여 가능하다.
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MDGUEST2;
-- (MDGUEST2) MDGUEST2 유저가 CUSTOMER테이블 SELSET, UPDATE 가능하다.
------
-- (MADANG) MADANG 유저가 MDGUEST로부터 권한 회수(취수)
REVOKE SELECT, UPDATE ON CUSTOMER FROM MYGUEST; -- 권한 회수
-- -> MDGUEST에게 부여된 CUSTOMER테이블 SELSET, UPDATE 권한이 취소됨
-- -> MDGUEST가 MDGUEST2에게 부여한 CUSTOMER테이블 SELSET, UPDATE 권한도 취소됨
--=====================================================
-- (SYSTEM) MDGUEST 유저 삭제
DROP USER MDGUEST2 CASCADE;

--=================================================
-- USER SQL
CREATE USER "TEST" IDENTIFIED BY "testpw"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS
ALTER USER "TEST" QUOTA UNLIMITED ON "USERS";

-- ROLES
GRANT "CONNECT" TO "TEST" ;
GRANT "RESOURCE" TO "TEST" ;

GRANT CREATE VIEW TO "TEST";


-- WITH GRANT OPTION: 다른 유저에게 권한 부여 할 수 있도록 허용
-- (MADANG) MADANG 유저가 MDGUEST에게 권한 부여
GRANT SELECT, UPDATE ON CUSTOMER TO MYGUEST WITH GRANT OPTION; -- 권한 부여
-- (MDGUEST) MDGUEST 유저가 MDGUEST2에게 권한 부여 가능하다.
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MDGUEST2;
-- (MDGUEST2) MDGUEST2 유저가 CUSTOMER테이블 SELSET, UPDATE 가능하다.
------
-- (MADANG) MADANG 유저가 MDGUEST로부터 권한 회수(취수)
REVOKE SELECT, UPDATE ON CUSTOMER FROM MYGUEST; -- 권한 회수
-- -> MDGUEST에게 부여된 CUSTOMER테이블 SELSET, UPDATE 권한이 취소됨
-- -> MDGUEST가 MDGUEST2에게 부여한 CUSTOMER테이블 SELSET, UPDATE 권한도 취소됨