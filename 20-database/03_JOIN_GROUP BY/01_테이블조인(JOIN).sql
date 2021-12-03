-- ������ ��ID
SELECT CUSTID FROM CUSTOMER WHERE NAME = '������'; --CUSTID: 1

-- �������� ������ å�� �հ�ݾ�
SELECT * FROM ORDERS WHERE CUSTID = 1;
SELECT SUM(SALEPRICE) FROM ORDERS WHERE CUSTID = 1;

-- ��������(SUB QUERY) ���
SELECT SUM(SALEPRICE) FROM ORDERS
WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '������');

--===================================================
--���̺� ����(JOIN) ���
SELECT * FROM CUSTOMER WHERE CUSTID = 1;
SELECT * FROM ORDERS WHERE CUSTID = 1;

-- CUSTOMER, ORDERS ���̺� ������ ���� ��ȸ
SELECT *
FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
AND NAME = '������'
;
--------------------------------------------
-- ���̺� ���� ��Ī ������� �����ϰ� ǥ���ϰ� ���
SELECT * 
FROM CUSTOMER C, ORDERS O -- ���̺� ���� ��Ī ���
WHERE C.CUSTID = O.CUSTID -- ��������
AND C.NAME = '������' -- �˻�����
;
-- ANSI ǥ�� ���� ����
SELECT *
  FROM CUSTOMER C INNER JOIN ORDERS O
    ON C.CUSTID = O.CUSTID -- ��������
WHERE C.NAME = '������' -- �˻�����
;
------------------------------------------------
-- �������� ������ �հ�ݾ�
SELECT SUM(O.SALEPRICE)
--SELECT * 
FROM CUSTOMER C, ORDERS O -- ������ ���̺�
WHERE C.CUSTID = O.CUSTID -- ���� ����
AND C.NAME = '������' -- �˻� ����
;
-------------------------------------------------
-- ������ å�� �Ǹŵ� å ���(�̵��� ������ ���ǻ�)
SELECT * FROM BOOK;
SELECT * FROM ORDERS;

SELECT *
 FROM BOOK B, ORDERS O -- ������ ���̺�
 WHERE B.BOOKID = O.BOOKID -- ���� ����
 AND B.PUBLISHER LIKE '%�̵��' -- �˻� ����
 ORDER BY B.PUBLISHER , B.BOOKNAME
 ;
 
 --====================================
 -- ���̺� �����ؼ� ��û������ ã��
 -- 1. '�߱��� ��Ź��' ��� å�� �ȸ����� Ȯ��(å����, �Ǹűݾ�, �Ǹ�����)
 SELECT * FROM BOOK;
 SELECT * FROM ORDERS;

 SELECT B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
 FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
 AND B.BOOKNAME = '�߱��� ��Ź��'
 ;
 
 SELECT B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
  FROM BOOK B INNER JOIN ORDERS O
  ON B.BOOKID = O.BOOKID -- ��������
  WHERE B.BOOKNAME = '�߱��� ��Ź��'
 ;
 -- 2. '�߱��� ��Ź��' ��� å�� �� ���� �ȷȴ��� Ȯ��
 SELECT COUNT(*)
 FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
 AND B.BOOKNAME = '�߱��� ��Ź��'
 ;

 SELECT '�߱�����Ź�� �ǸŰǼ� ', COUNT(*)
 FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
 AND B.BOOKNAME = '�߱��� ��Ź��'
 ;
 
 -- 3. '�߽ż�'�� ������ å���� ��������(å��, ��������)
 SELECT * FROM CUSTOMER;
 SELECT * FROM ORDERS;
 
 SELECT O.SALEPRICE, O.ORDERDATE
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND C.NAME = '�߽ż�'
 ;
 
 SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  AND NAME = '�߽ż�'
  ;
 
 -- 4. '�߽ż�'�� ������ �հ�ݾ� Ȯ��
 SELECT SUM(O.SALEPRICE)
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND C.NAME = '�߽ż�'
 ;
 
 SELECT SUM(O.SALEPRICE)
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND NAME = '�߽ż�'
 ;
 
 -- 5. ������, �߽ż��� ������ ������ Ȯ��(�̸�, �Ǹűݾ�, �Ǹ�����)
SELECT C.NAME , O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C , ORDERS O
WHERE C.CUSTID = O.CUSTID
AND C.NAME IN ('������', '�߽ż�')
;

SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTiD = O.CUSTID
AND (C.NAME = '�߽ż�' OR C.NAME = '������')
ORDER BY C.NAME, O.ORDERDATE
;
--=================================================
-- 3�� ���̺� ����(����)�ؼ� ������ ��ȸ(�˻�, ����)
-- ����, å����, ���ǻ�, �ǸŰ���, �Ǹ����� 
SELECT C.NAME, B.BOOKNAME, B.PUBLISHER, O.SALEPRICE, O.ORDERDATE
 FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID -- ��������
 ;

SELECT C.NAME, B.BOOKNAME, B.PUBLISHER, O.SALEPRICE, O.ORDERDATE
 FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE B.BOOKID = O.BOOKID AND O.CUSTID = C.CUSTID -- ��������
 ;

 -- �� �ΰ������ ����� �Ȱ���.

-- ANSI ǥ�� SQL
SELECT C.NAME, B.BOOKNAME, B.PUBLISHER, O.SALEPRICE, O.ORDERDATE
 FROM BOOK B
   INNER JOIN ORDERS O
   ON B.BOOKID = O.BOOKID
   INNER JOIN CUSTOMER C
   ON O.CUSTID = C.CUSTID
;

-------------------------------------------------
-- BOOK, CUSTOMER, ORDERS ���̺� �����͸� ��ȸ
-- 1. ��̶��� ������ å����, ���԰���, ��������, ���ǻ�
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
 FROM CUSTOMER C, BOOK B, ORDERS O
 WHERE C.CUSTID = O.CUSTID AND B.BOOKID = O.BOOKID
 AND C.NAME = '��̶�'
 ;
-- 2. ��̶��� ������ å �߿� 2014-01-01 ~ 2014-07-08���� ������ ����
SELECT ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY-MM-DD HH24:MI:SS') FROM ORDERS;

SELECT *
 FROM CUSTOMER C, BOOK B, ORDERS O
 WHERE C.CUSTID = O.CUSTID AND B.BOOKID = O.BOOKID
 AND C.NAME = '��̶�'
 AND O.ORDERDATE >= TO_DATE('2014-01-01', 'YYYY-MM-DD') --��¥�� TO_DATE�� �����ִ°� ����
 AND O.ORDERDATE < TO_DATE('2014-07-09', 'YYYY-MM-DD') -- 2014-07-09 00:00:00
 ;
 
 SELECT *
 FROM CUSTOMER C, BOOK B, ORDERS O
 WHERE C.CUSTID = O.CUSTID AND B.BOOKID = O.BOOKID
 AND C.NAME = '��̶�'
 AND O.ORDERDATE BETWEEN  TO_DATE('2014-01-01', 'YYYY-MM-DD') --��¥�� TO_DATE�� �����ִ°� ����
                 AND TO_DATE('2014-07-09', 'YYYY-MM-DD') -- 2014-07-09 00:00:00
 ;

-- 3. '�߱��� ��Ź��'��� å�� ������ ����� �������ڸ� Ȯ��
SELECT '�߱��� ��Ź��', C.NAME, O.ORDERDATE 
 FROM BOOK B, ORDERS O, CUSTOMER C
 WHERE B.BOOKID = O.BOOKID AND O.CUSTID = C.CUSTID
 AND B.BOOKNAME = '�߱��� ��Ź��'
 ;
-- 4. �߽ż�, ��̶��� ������ å����, ���Աݾ�, �������ڸ� Ȯ��
--    (����: ����, �������� ������)
SELECT C.NAME,B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
 FROM BOOK B, CUSTOMER C, ORDERS O
 WHERE B.BOOKID = O.BOOKID AND C.CUSTID = O.CUSTID
 AND C.NAME IN('�߽ż�', '��̶�')
 ORDER BY C.NAME, O.ORDERDATE
 --ORDER BY 1, 4 �̷��Ե� ������ �����ϴ�.1��: �̸��� 4��: ��¥��
;
-- 5. �߽ż��� ������ å����, �հ�ݾ�, ��հ�, ���� ��� å�ݾ�, ����� å �ݾ�
SELECT '�߽ż��� ������ å����', COUNT(*), SUM(O.SALEPRICE), AVG(O.SALEPRICE)
 ,MAX(O.SALEPRICE), MIN(O.SALEPRICE)
 FROM CUSTOMER C, BOOK B, ORDERS O
 WHERE C.CUSTID = O.CUSTID AND B.BOOKID = O.BOOKID
 AND C.NAME = '�߽ż�'
 ;

SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), ROUND(AVG(O.SALEPRICE))
       , MAX(O.SALEPRICE), MIN(O.SALEPRICE)
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME -- GROUP BY�� �� ����� ���� ��Ÿ���ش�.
 ;



