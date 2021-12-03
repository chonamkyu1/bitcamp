/* ********* ����� ����, ���� *********
-- ����� ���� : CREATE USER
CREATE USER ����ڸ�(������) --"MDGUEST" 
IDENTIFIED BY ��й�ȣ --"mdguest"  
DEFAULT TABLESPACE ���̺����̽� --"USERS"
TEMPORARY TABLESPACE �ӽ��۾����̺����̽� --"TEMP";

-- ����� �뷮 ����(����)
ALTER USER "MDGUEST" QUOTA UNLIMITED ON "USERS";

-- ����� ���� : ALTER USER 
ALTER USER ����ڸ�(������) IDENTIFIED BY ��й�ȣ;

-- ���Ѻο�(�� ��� ���� �ο�, �� �ο�)
GRANT "CONNECT" TO "MDGUEST" ;
GRANT "RESOURCE" TO "MDGUEST" ;

-- ����� ���� : DROP USER
DROP USER ������ [CASCADE];
--CASCADE : ���������� �����(����)�� ������ ��� ����Ÿ ����
*************************************/
--������ ���� ID: MYGUEST ��й�ȣ: myguest
-- ���� ���� + ���̺����̽� ����
ALTER USER "MYGUEST"
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
ACCOUNT UNLOCK ;

-- ���� ���� �뷮 ����(QUOTAS)
ALTER USER "MYGUEST" QUOTA UNLIMITED ON "USERS";

-- ��(����) �ο�(ROLES)
ALTER USER "MYGUEST" DEFAULT ROLE "CONNECT","RESOURCE";

--���Ѻο� - �� ��������
GRANT CREATE ANY VIEW TO "MYGUEST" ;

-----------------------------------------------------------
--(SYSTEM) CONNECT, RESOURCE ��(ROLE)�� �ִ� ���� Ȯ��
SELECT *
 FROM DBA_SYS_PRIVS
 WHERE GRANTEE IN ('CONNECT', 'RESOUTCE')
 ORDER BY GRANTEE, PRIVILEGE
; 


--------------------------------------------------------------
--=============================
/****** ���� �ο�(GRANT), ���� ���(REVOKE) **********************
GRANT ���� [ON ��ü] TO {�����|ROLE|PUBLIC,.., n} [WITH GRANT OPTION]
--PUBLIC�� ��� ����ڿ��� ������ �ǹ�

GRANT ���� TO �����; --������ ����ڿ��� �ο�
GRANT ���� ON ��ü TO �����; -��ü�� ���� ������ ����ڿ��� �ο�
-->> WITH GRANT OPTION :��ü�� ���� ������ ����ڿ��� �ο� 
-- ������ ���� ����ڰ� �ٸ� ����ڿ��� ���Ѻο��� �Ǹ� ����
GRANT ���� ON ��ü TO ����� WITH GRANT OPTION;
--------------------
-->>>���� ���(REVOKE)
REVOKE ���� [ON ��ü] FROM {�����|ROLE|PUBLIC,.., n} CASCADE
--CASCADE�� ����ڰ� �ٸ� ����ڿ��� �ο��� ���ѱ��� ��ҽ�Ŵ
  (Ȯ�� �� ���� �� �۾�)

REVOKE ���� FROM �����; --������ ����ڿ��� �ο�
REVOKE ���� ON ��ü FROM �����; -��ü�� ���� ������ ����ڿ��� �ο�
*************************************************/
-- ���� �ο�: MADANG ������ BOOK ���̺� ���� SELECT ������ MDGUEST�� �ο�
--(SYSTEM) ���Ѻο� - MADANG.BOOK�� SELECT �� �� �ִ� ������ MDGUEST�� �ο�




--========= MADANG �������� ���Ѻο�, ������� ===============
--(MADANG) CUSTOMER ���̺� ���Ͽ� MYGUEST ��������
-- SELECT, UPDATE ���� �ο�
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MYGUEST; -- ���� �ο�
REVOKE SELECT, UPDATE ON MADANG.CUSTOMER FROM MYGUEST; -- ���� ȸ��

--(MYGUEST) SELECT, UPDATE �۾� ����
SELECT * FROM MADANG.CUSTOMER;
UPDATE MADANG.CUSTOMER 
 SET PHONE = '010-1111-2222'
 WHERE CUSTID = 5;
DELETE FROM MADANG.CUSTOMER WHERE CUSTID = 5; 

--(MADAGNG) SELECT, UPDATE ���� ���
REVOKE SELECT, UPDATE ON CUSTOMER FROM MYGUEST;
--(MYGUEST) SELECT, UPDATE ���� ����� ���̺� ���� �� �� ����.
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


-- WITH GRANT OPTION: �ٸ� �������� ���� �ο� �� �� �ֵ��� ���
-- (MADANG) MADANG ������ MDGUEST���� ���� �ο�
GRANT SELECT, UPDATE ON CUSTOMER TO MYGUEST WITH GRANT OPTION; -- ���� �ο�
-- (MDGUEST) MDGUEST ������ MDGUEST2���� ���� �ο� �����ϴ�.
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MDGUEST2;
-- (MDGUEST2) MDGUEST2 ������ CUSTOMER���̺� SELSET, UPDATE �����ϴ�.
------
-- (MADANG) MADANG ������ MDGUEST�κ��� ���� ȸ��(���)
REVOKE SELECT, UPDATE ON CUSTOMER FROM MYGUEST; -- ���� ȸ��
-- -> MDGUEST���� �ο��� CUSTOMER���̺� SELSET, UPDATE ������ ��ҵ�
-- -> MDGUEST�� MDGUEST2���� �ο��� CUSTOMER���̺� SELSET, UPDATE ���ѵ� ��ҵ�
--=====================================================
-- (SYSTEM) MDGUEST ���� ����
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


-- WITH GRANT OPTION: �ٸ� �������� ���� �ο� �� �� �ֵ��� ���
-- (MADANG) MADANG ������ MDGUEST���� ���� �ο�
GRANT SELECT, UPDATE ON CUSTOMER TO MYGUEST WITH GRANT OPTION; -- ���� �ο�
-- (MDGUEST) MDGUEST ������ MDGUEST2���� ���� �ο� �����ϴ�.
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MDGUEST2;
-- (MDGUEST2) MDGUEST2 ������ CUSTOMER���̺� SELSET, UPDATE �����ϴ�.
------
-- (MADANG) MADANG ������ MDGUEST�κ��� ���� ȸ��(���)
REVOKE SELECT, UPDATE ON CUSTOMER FROM MYGUEST; -- ���� ȸ��
-- -> MDGUEST���� �ο��� CUSTOMER���̺� SELSET, UPDATE ������ ��ҵ�
-- -> MDGUEST�� MDGUEST2���� �ο��� CUSTOMER���̺� SELSET, UPDATE ���ѵ� ��ҵ�