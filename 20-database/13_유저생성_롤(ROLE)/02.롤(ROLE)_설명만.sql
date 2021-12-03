/* ********* ����(�� ROLE) ***********
����(��, ROLE) : DB ��ü �� �ý��ۿ� ���� ������ ��Ƶ� ������ �ǹ�
���� ���� : CREATE ROLE �����̸�
���� ���� : DROP ROLE �����̸�
���ҿ� ���� �ο� : GRANT ���� [ON ��ü] TO �����̸�
������ ���� ȸ�� : REVOKE ���� [ON ��ü] FROM �����̸�
����ڿ��� ���� �ο� : GRANT �����̸� TO �����

<���� �������� ����� �߰������� �ܰ�>
CREATE ROLE - ���һ���
GRANT - ������� ���ҿ� ���� �ο�
GRANT - ����ڿ��� ���� �ο�
-->>���� ������ ��� �ݴ�� ����
DROP ROLE - ���� ����(����ڿ��� �ο��� ���ҿ� ���� ���� ���� ���ŵ�)
***************************************/
-- ����� �������� �˻� ����(��) ��ȸ
SELECT * FROM USER_ROLE_PRIVS;

-- (DBA���� -SYSTEM) CONNECT, RESOURCE �ѿ� ���� ���� Ȯ��
SELECT * FROM DBA_SYS_PRIVS
WHERE GRANTEE IN('CONNECT', 'RESOUTCE')
ORDER BY GRANTEE, PRIVILEGE
;
-----------------
--(SYSTEM) ��(ROLE) ����: PROGRAMMER(������)��� ����(��, ROLE ����)
CREATE ROLE PROGRAMMER;

-- (SYSTEM) PROGRAMMER ��(����)�� ���̺�, �� ���� ���� ���
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO PROGRAMMER;
--====================================
-- (SYSTEM) MDGUEST �������� PROGRAMMER ��(ROLE) �ο�
CREATE USER "MDGUEST" IDENTIFIED BY "mdguest"
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";
-- (SYSTEM) MDGUEST �������� ���� �ο�
GRANT CONNECT, RESOURCE TO MDGUEST;
-------------------------
-- (SYSTEM) MDGUEST �������� PROGRAMMER ��(ROLE) �ο�
GRANT PROGRAMMER TO MDGUEST;
-- (MDGUEST) ���̺� ���� ���� ���

CREATE TABLE MADANG.AAA (TEST VARCHAR2(30)); -- OK
CREATE TABLE MADANG.BBB (BBB NUMBER); -- OK
SELECT * FROM MADANG.AAA; -- ���� ����

--(SYSTEM) ��(����) ����
DROP ROLE PROGRAMMER;




