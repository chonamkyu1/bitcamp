/*
SELECT [* | DISTINCT] {�÷���, �÷���, ... }
  FROM ���̺��
[WHERE ������]
[GROUP BY {�÷���, ...}
    [HAVING ����] ] -- GROUP BY ���� ���� ����
[ORDER BY {�÷��� [ASC | DESC], ....}] -- ASC: ��������(�⺻/ ���� ����)
                                      -- DESC: ��������

-----------------
GROUP BY: �����͸� �׷����ؼ� ó���� ��� ���
GROUP BY ���� ����� �� SELECT �׸� ����� �� �ִ� ���� GROUP BY ����
���� �÷� �Ǵ� �׷��Լ�(COUNT, SUM, AVG, MAX, MIN)�� ����� �� �ִ�.

*************************/
-- ���� ������ ���űݾ��� �հ踦 ���Ͻÿ�
SELECT  CUSTID, SUM(SALEPRICE)
 FROM ORDERS
 GROUP BY CUSTID 
 ;
 --------
 SELECT C.NAME, SUM(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY SUM(SALEPRICE) DESC
 ;
 --------
 SELECT C.NAME, SUM(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY 2 DESC -- SELECT ���� 2��° �׸����� ����
 ; 
 ----------------------------------------
 -- �ֹ�(�Ǹ�) ���̺��� ���� ������ ��ȸ(�Ǽ�, �հ�, ���, �ּ�, �ִ�)
 SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE)), MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM ORDERS O, CUSTOMER C
  WHERE O.CUSTID = C.CUSTID --��������
--  AND C.NAME IN ('�߽ż�', '������')
  GROUP BY C.NAME
  ORDER BY C.NAME
  ;
  --------------------------------------
  -- ���� �������� ���� ������ ��ȸ(�Ǽ�, ���, ���, �ּ�, �ִ�)
  -- �߽ż�, ��̶�, �� 2�� ��ȸ
  SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
         , MIN(O.SALEPRICE), MAX(O.SALEPRICE)
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID AND C.NAME IN('��̶�', '�߽ż�')
 GROUP BY C.NAME
 ORDER BY C.NAME   
;

SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
         , MAX(O.SALEPRICE), MIN(O.SALEPRICE)
 FROM CUSTOMER C INNER JOIN ORDERS O
 ON C.CUSTID = O.CUSTID
 WHERE C.NAME IN('��̶�', '�߽ż�')-- ��������
 GROUP BY C.NAME
 ;
 -------------------------------------
 -- HAVING ��: GROUP BY ���� ���ؼ� ������� �����Ϳ��� �˻����� �ο�
 -- HAVING ���� �ܵ����� ���� �� ����, �ݵ�� GROUP BY���� �Բ� ����ؾ� �Ѵ�.
 -------------------------------------
 -- 3�� �̻� ������ �� ��ȸ(����, �Ǽ�)
 SELECT C.NAME, COUNT(*) AS CNT -- AS�� ��Ī
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  HAVING COUNT(*) >= 3 -- �׷��ε� �����Ϳ��� ���ϴ� ������ �˻�
  ;
 -------------------------------------
 -- ������ å�߿��� 20000�� �̻��� å�� ������ ����� ��赥����
 -- (�Ǽ�, �հ�, ���, �ּ�, �ִ�)
 SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
         , MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  HAVING MAX(O.SALEPRICE) >= 20000 -- �׷��� ����� ���ϰ� 2���� �̻� ������ ��� �հ� 
  ;
 
 SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
         , MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
-- SELECT * 
  WHERE C.CUSTID = O.CUSTID
  AND O.SALEPRICE >= 20000 -- 2���� �̻��� å ���Գ����� ������� 
  GROUP BY C.NAME
  ;
-- WHERE ���� ������ HAVING���� �������� ���� �� ���� �����ϴ�.
-- ����: WHERE���� ���Ǵ� ã�� ����(���̺� ������ ����)
--      HAVING������ ���Ǵ� �������� �׸��ε� ������ �������� �˻��Ѵ�.
-- ������� �ٸ��� ó���ǹǷ� ã�� �����Ͱ� �������� ��Ȯ�� �Ǵ��ϰ� ����� ��

--==============================================
-- �ʿ�� GROUP BY ~ HAVING ������ ����ؼ� ó��
-- 1. ���� �ֹ��� ������ ���ǸŰǼ�, �Ǹž�, ��հ�, ������, �ְ� ���ϱ�
-- 2. ������ �ֹ��� ������ �Ѽ���, ���Ǹž� ���ϱ�
-- 3. ���� �̸��� ���� �ֹ��� ������ �ǸŰ��� �˻�
-- 4. ������ �ֹ��� ��� ������ ���Ǹž��� ���ϰ�, �������� ����
-- 5. ������ �ֹ��� �Ǽ�, �հ�ݾ�, ��ձݾ��� ���ϰ�(3�� ���� ���� ������ ��� �˻�)
-- (����) �� �� �� �ǵ� ���� ���� ���
--==============================================
-- 1. ���� �ֹ��� ������ ���ǸŰǼ�, �Ǹž�, ��հ�, ������, �ְ� ���ϱ�
SELECT C.NAME, COUNT(*),SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
       , MIN(O.SALEPRICE), MAX(O.SALEPRICE)
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 ;
 --�����Ǯ��
 SELECT COUNT(*) AS "TOTAL COUNT"
        , SUM(SALEPRICE) AS "�Ǹž� �հ�" -- �ѱ� ����� �� ������ ������� ����
        , AVG(SALEPRICE) ��հ�AVG -- AS ���� �����ϴ�.
        , MIN(SALEPRICE) ������_MIN -- �����(_) ��밡���ϴ�.
        , MAX(SALEPRICE) "�ְ�(MAX)"
  FROM ORDERS
  ;

-- 2. ������ �ֹ��� ������ �Ѽ���, ���Ǹž� ���ϱ� ( ~�� �̶� ���� ������ GROUP BY)
 SELECT  C.NAME, COUNT(*), SUM(O.SALEPRICE) 
  FROM CUSTOMER C, ORDERS O 
  WHERE C.CUSTID = O.CUSTID 
  GROUP BY C.NAME 
  ;
-- ����� Ǯ��
SELECT C.NAME, COUNT(*) AS CNT, SUM(O.SALEPRICE) AS SUM_PRICE
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 -- ORDER BY SUM(O.SALEPRICE) DESC -- ����� �׷��Լ��� ���� �����ϴ�.
 -- ORDER BY 3 DESC -- �ķ� ��ġ������ ���� �����ϴ�.
 ORDER BY SUM_PRICE DESC -- ��Ī(ALIAS)���� ���� �����ϴ�.
 ;
  
-- 3. ���� �̸��� ���� �ֹ��� ������ �ǸŰ��� �˻�
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE
 FROM CUSTOMER C, BOOK B, ORDERS O
 WHERE C.CUSTID = O.CUSTID AND B.BOOKID = O.BOOKID
 GROUP BY C.NAME , b.bookname, O.SALEPRICE
 ORDER BY C.NAME 
 ;
 
 -- ����� Ǯ��
 SELECT C.NAME, O.SALEPRICE, B.BOOKNAME
  FROM CUSTOMER C, ORDERS O, BOOK B
  WHERE C.CUSTID = O.CUSTID AND O.BOOKID = B.BOOKID
  ;
 
 -- 4. ������ �ֹ��� ��� ������ ���Ǹž��� ���ϰ�, �������� ����
SELECT C.NAME, SUM(O.SALEPRICE)
 FROM CUSTOMER C,ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 ORDER BY C.NAME
 ;
 
 -- ����� Ǯ��
 SELECT C.NAME, SUM(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY C.NAME
  ;
  
 -- 5. ������ �ֹ��� �Ǽ�, �հ�ݾ�, ��ձݾ��� ���ϰ�(3�� ���� ���� ������ ��� �˻�)
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 HAVING COUNT(*) < 3
 ;
 -- ����� Ǯ��
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
 FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 HAVING COUNT(*)  < 3
  ;
  
  -- (����) �� �� �� �ǵ� ���� ���� ����� �����ΰ�?
