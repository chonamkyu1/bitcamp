-- ��������(�μ�����, SUB QUERY)
-- SQL(SELECT, INSERT, UPDATE, DELETE) ���� �ִ� ������
------------------------------
-- �������� ������ ������ �˻�
SELECT CUSTID FROM CUSTOMER WHERE NAME = '������'; -- CUSTID: 1
SELECT * FROM ORDERS WHERE CUSTID = 1;

-- �������� ���
SELECT * FROM ORDERS
 WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '������');

-- ���ι����� ó��
SELECT C.NAME, O.*
 FROM ORDERS O , CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
 AND C.NAME = '������'
 ;
---------------------------------------
-- WHERE ������ �������� ���� ��ȸ����� 2�� �̻��� ��� IN ����ϱ�
-- ������, �迬�� ���Գ���
SELECT * FROM ORDERS
 WHERE CUSTID IN (SELECT CUSTID
                  FROM CUSTOMER
                  WHERE NAME IN('������', '�迬��'))
;
----------------------------------------
-- å�� ������ ���� ��� ������ �̸��� ���Ͻÿ�
SELECT MAX(PRICE) FROM BOOK; -- ���� ��� å�� ����: 35000
SELECT * FROM BOOK WHERE PRICE = 35000;
--
SELECT * FROM BOOK
 WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK)
;
----------------------------------------
-- ���������� FROM ���� ����ϴ� ���
SELECT *
 FROM BOOK B,
      (SELECT MAX(PRICE) MAX_PRICE FROM BOOK) M
 WHERE B.PRICE = M.MAX_PRICE
;
-- ���ǵ� å�� ��ձݾ� �̻��� ���� ��� (FROM�� �����������)
SELECT *
 FROM BOOK B,
      (SELECT AVG(PRICE) AVG_PRICE FROM BOOK) M
 WHERE B.PRICE >= M.AVG_PRICE 
;
-- ������, �迬�� ���Գ���(�������� - FROM��)
SELECT *
 FROM ORDERS O,
      (SELECT CUSTID FROM CUSTOMER WHERE NAME IN('������', '�迬��')) C
 WHERE O.CUSTID = C.CUSTID
;

-- ����� Ǯ��
SELECT *
 FROM ORDERS O, (SELECT * FROM CUSTOMER WHERE NAME IN('������', '�迬��')) C
 WHERE O.CUSTID = C.CUSTID
 ;
--------------------------
-- SELECT ���� �������� ���
SELECT O.ORDERID, O.CUSTID, O.BOOKID
        ,(SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUSTNAME
        ,(SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID)BOOKNAME
        , O.SALEPRICE, O.ORDERDATE
 FROM ORDERS O
;
--------------------------
-- �������� ������ å ���(å����)   
SELECT *
 FROM BOOK
 WHERE BOOKID IN (SELECT BOOKID
                  FROM ORDERS 
                  WHERE CUSTID = (SELECT CUSTID
                  FROM CUSTOMER WHERE NAME = '������'))
;
---------------------------
-- ��������, ���ι� 
-- 1. �ѹ��̶� ������ ������ �ִ� ���
--(�Ǵ� �ѹ��� �������� ���� ���)
-- 2. 20000�� �̻�Ǵ� å�� ������ �� ��� ��ȸ
-- 3. '���ѹ̵��' ���ǻ��� å�� ������ ���̸� ��ȸ
-- 4. ��ü å���� ��պ��� ��� å�� ��� ��ȸ
---------------------------
-- 1. �ѹ��̶� ������ ������ �ִ� ���
SELECT *
 FROM CUSTOMER 
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE CUSTID >= 1)
;

SELECT DISTINCT C.*  -- DISTINCT �ߺ��� �͵� �ϳ��� �߷��� ���
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
; 
 
-- ����� Ǯ��
SELECT * FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS)
;

SELECT DISTINCT C.*
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 ;

-- ǥ�� SQL
SELECT DISTINCT C.*
 FROM CUSTOMER C INNER JOIN ORDERS O
 ON C.CUSTID = O.CUSTID
 ;
 
-- �Ǵ� �ѹ��� �������� ���� ���
SELECT * FROM CUSTOMER
 WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS) -- IN �տ� NOT ���̱�
;

SELECT C.*
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID(+)
 AND O.CUSTID IS NULL
 ;

-- ǥ��SQL
SELECT C.*
 FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
 ON C.CUSTID = O.CUSTID
 WHERE O.CUSTID IS NULL
 ;
 
 
-- 2. 20000�� �̻�Ǵ� å�� ������ �� ��� ��ȸ
SELECT *
 FROM CUSTOMER
 WHERE CUSTID IN ( SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000)
;

SELECT *
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND O.SALEPRICE >= 20000
; 

-- ����� Ǯ��
SELECT * FROM CUSTOMER 
 WHERE CUSTID IN(SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000)
;

SELECT C.*, O.SALEPRICE, O.ORDERDATE
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND SALEPRICE >= 20000
;

-- 3. '���ѹ̵��' ���ǻ��� å�� ������ ���̸� ��ȸ
SELECT *
 FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID
                  FROM ORDERS
                  WHERE BOOKID IN (SELECT BOOKID
                  FROM BOOK WHERE PUBLISHER = '���ѹ̵��')) 
 ;

SELECT * 
 FROM CUSTOMER C, ORDERS O, BOOK B
 WHERE C.CUSTID = O.CUSTID AND O.BOOKID = B.BOOKID
 AND B.PUBLISHER = '���ѹ̵��'
 ;
 
 -- ����� Ǯ��
SELECT * FROM CUSTOMER
 WHERE CUSTID = (SELECT CUSTID FROM ORDERS
 WHERE BOOKID IN ( SELECT BOOKID FROM BOOK WHERE PUBLISHER = '���ѹ̵��'));

SELECT C.*, O.SALEPRICE, O.ORDERDATE, B.BOOKNAME, B.PUBLISHER
 FROM CUSTOMER C, ORDERS O, BOOK B
 WHERE C.CUSTID = O.CUSTID AND O.BOOKID = B.BOOKID -- ��������
 AND B.PUBLISHER = '���ѹ̵��' 
 ;

-- ǥ�� SQL��
SELECT C.*, O.SALEPRICE, O.ORDERDATE, B.BOOKNAME, B.PUBLISHER
 FROM CUSTOMER C INNER JOIN ORDERS O -- �������̺� ���ι��
 ON C.CUSTID = O.CUSTID -- ��������
 INNER JOIN BOOK B -- �������̺� ���ι��
 ON O.BOOKID = B.BOOKID -- �������� 
 WHERE B.PUBLISHER = '���ѹ̵��' -- �˻�����
 ;
 
-- 4. ��ü å���� ��պ��� ��� å�� ��� ��ȸ
SELECT *
 FROM BOOK , (SELECT AVG(PRICE) AVG_PRICE FROM BOOK) M
 WHERE PRICE >= M.AVG_PRICE
 ;
 
SELECT *
 FROM BOOK
 WHERE PRICE >=  (SELECT AVG(PRICE) FROM BOOK)
;

