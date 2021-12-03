/*
-- ��(VIEW) ������
CREATE [OR REPLACE] VIEW ���̸� [(�÷���Ī1, �÷���Ī2, ..., �÷���Īn)]
AS
SELECT ����
[�ɼ�];

-- �б����� �ɼ�: WITH READ ONLY

-- ��(VIEW) ����
DROP VIEW ���̸�
*/
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%�౸%';
--- ��(VIEW) ����� ---
CREATE VIEW VI_BOOK
AS
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%�౸%'
WITH READ ONLY; -- �б�����

-- �� ����ؼ� ������ �˻�
SELECT * FROM (SELECT * FROM BOOK WHERE BOOKNAME LIKE '%�౸%');
SELECT * FROM VI_BOOK;
SELECT * FROM VI_BOOK WHERE PUBLISHER = '�½�����';
SELECT *
 FROM (SELECT * FROM BOOK WHERE BOOKNAME LIKE '%�౸%')
 WHERE PUBLISHER = '�½�����';
 --------------------------------------
 -- ��(VIEW) ���� - �÷���Ī (alias) ���
CREATE OR REPLACE VIEW VW_BOOK2
   (BID, BNAME, PUB, PRICE)
AS
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%�౸%'
WITH READ ONLY
;

SELECT * FROM VW_BOOK2 WHERE PUB = '�½�����';
--------------------
CREATE VIEW VW_BOOK3
    (BNAME, PUB, PRICE)
AS
SELECT BOOKNAME, PUBLISHER, PRICE
 FROM BOOK
 WHERE BOOKNAME LIKE '%�౸%'
;
---------------------
CREATE OR REPLACE VIEW VW_ORDERS
AS
SELECT O.ORDERID, O.CUSTID, O.BOOKID
        , C.NAME, C.PHONE, C.ADDRESS
        , B.BOOKNAME, B.PUBLISHER, B.PRICE
        , O.SALEPRICE, O.ORDERDATE
 FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID
 ORDER BY O.ORDERID
WITH READ ONLY
;
-----------------
--(����) ������, �迬�ư� ������ å����,���Աݾ�, ��������
SELECT NAME, BOOKNAME, SALEPRICE, ORDERDATE
 FROM VW_ORDERS
 WHERE NAME IN ('������', '�迬��')
;
-----------------
-- �� ����
DROP VIEW VW_ORDERS;

--=======================================
-- 1. ����� - ���Ī: VW_ORD_ALL
---- �ֹ�(�Ǹ�)����, å����, ������ ��� ��ȸ�� �� �ִ� ���� ��
-- 2. �̻�̵��� ������ å �� �Ǹŵ� å����, �Ǹűݾ�, �Ǹ��� ��ȸ
-- 3. �̻�̵��� ������ å �߿��� �߽ż�, ��̶��� ������ å ���� ��ȸ
---- ����׸�: ������ ����̸�, å����, ���ǻ� ����(����), �ǸŰ�, �Ǹ�����
---- ����: ������ ����̸�, �������� �ֱټ�
-- 4. �Ǹŵ� ä�� ���Ͽ� �����ں� �Ǽ�, �հ�ݾ�, ��ձݾ�, �ְ�, ������ ��ȸ
-- ���� �����: VW_ORD_ALL ���� ó��

-- FORCE: SELECT ���� ���̺��� ��� ��(VIEW)�� ������ �����Ѵ�.

-- 1. ����� - ���Ī: VW_ORD_ALL
---- �ֹ�(�Ǹ�)����, å����, ������ ��� ��ȸ�� �� �ִ� ���� ��
CREATE OR REPLACE VIEW VW_ORD_ALL
AS
SELECT O.ORDERID, O.CUSTID, O.BOOKID
        , C.NAME, C.PHONE, C.ADDRESS
        , B.BOOKNAME, B.PUBLISHER, B.PRICE
        , O.SALEPRICE, O.ORDERDATE
 FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID
 ORDER BY O.CUSTID
WITH READ ONLY
; 
-- 2. �̻�̵��� ������ å �� �Ǹŵ� å����, �Ǹűݾ�, �Ǹ��� ��ȸ
SELECT BOOKNAME, PUBLISHER , SALEPRICE, ORDERDATE
 FROM VW_ORD_ALL
 WHERE PUBLISHER = '�̻�̵��'
 ;





DROP VIEW VW_ORD_ALL;

     