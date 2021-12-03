/* UNION, UNION ALL: ������ó��
-- UNION: �ߺ������͸� �����ϰ� �����ش�.(���������ʹ� 1���� ǥ��)
-- UNION ALL: �ߺ������͸� �����ؼ� �����ش�.(�ߺ������� ��� ���)
��, ��ȸ�ϴ� �÷��� �̸�, ����, ����, Ÿ���� ��ġ�ǵ��� �ۼ����־�� �Ѵ�.
*/
-- UNION ���
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3);
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 4, 5);
---- UNION���� ���ϱ�: �ߺ������ʹ� 1���� ���
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3)
UNION 
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 4, 5)
;
---- UNION ALL���� ���ϱ�: �ߺ������͵� ��� ����Ѵ�.
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3)
UNION ALL 
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 4, 5)
ORDER BY NAME -- ORDER BY ���� �������� �ۼ��Ѵ�.(�ѹ���)
;
------------------------
-- MINUS: ������(���� ����)
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3)
MINUS 
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 4, 5)
;
-------------------
-- INTERSECT: ������(�ߺ������� ��ȸ) - ���ι��� ����� ����� �����ϴ�.
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3)
INTERSECT 
SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 3, 4, 5)
;
---- ���ι�(JOIN��)
SELECT *
 FROM (SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3)) A
      , (SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 4, 5)) B
 WHERE A.CUSTID = B.CUSTID
 AND A.NAME = B.NAME
;
