/* *** �Լ�(FUNCTION) ***
CREATE OR REPLACE FUNCTION FUNCTION1 
(
  PARAM1 IN VARCHAR2  -- �Ķ���� �ۼ�����
) RETURN VARCHAR2 AS -- ���� ������ Ÿ�Լ��� 
BEGIN
  RETURN NULL; -- ������ �� 
END
------
-- ������ �����Ϳ� ���� ���� �ʿ��ϴ�.
RETURN ����������(Ÿ��)
-- ���α׷� �������� �� �����ϴ� ���� �ʿ��ϴ�.
RETURN ���ϰ�
*/
-- ���ν����� �۾��� ó���ϴ°� ����
-- �Լ��� ó���ϰ� �� ���� �ǵ����޾� ����Ϸ��°� ����

-- BOOKID�� å���� Ȯ���ϴ� �Լ� (�Ķ���Ͱ�: BOOKID, RETURN��: BOOKNAME)

CREATE OR REPLACE FUNCTION GET_BOOKNAME (
  IN_ID IN NUMBER 
) RETURN VARCHAR2  -- ������ ������ Ÿ�� ����
AS 
    V_BOOKNAME BOOK.BOOKNAME%TYPE;
BEGIN
    SELECT BOOKNAME INTO V_BOOKNAME
    FROM BOOK
    WHERE BOOKID = IN_ID;

    RETURN V_BOOKNAME; -- ���ϰ� ����
END;

---------------------------
-- �Լ�(FUNCTION)�� ���
-- SELECT ���� ���
SELECT BOOKID, BOOKNAME, GET_BOOKNAME(BOOKID)
 FROM BOOK
 ;
 -----------------
SELECT O.*, GET_BOOKNAME(BOOKID)
 FROM ORDERS O;

--------
-- WHERE ������ �Լ� ���
SELECT O.*, GET_BOOKNAME(BOOKID)
 FROM ORDERS O 
 WHERE GET_BOOKNAME(BOOKID) = '�౸�� ����'
;

--------------------------------------
-- ��ID ���� �޾Ƽ� ������ �����ִ� �Լ� �ۼ�(CUSTOME ���̺� ���)
-- �Լ���: GET_CUSTNAME
-- �Լ��� ����ؼ� ORDERS ���̺� ������ ��ȸ
-- GET_BOOKNAME, GET_CUSTNAME �Լ� ��� �ֹ�(�Ǹ�) ������ å����, ���� ��ȸ
--------------------------------------------
create or replace FUNCTION GET_CUSTNAME (
  IN_CUSTID IN NUMBER 
) RETURN VARCHAR2
AS
    V_NAME CUSTOMER.NAME%TYPE;
    
    /*
    V_GET_BOOKNAME BOOK.BOOKNAME%TYPE
    V_GET_CUSTNAME CUSTOMER.NAME%TYPE
    */
BEGIN
    SELECT NAME INTO V_NAME
    FROM CUSTOMER
    WHERE CUSTID = IN_CUSTID;
    
   /* SELECT GET_BOOKNAME, GET_CUSTNAME
    INTO V_GET_BOOKNAME, V_GET_CUSTNAME
    FROM ORDERS
    WHERE GET_BOOKNAME = IN_ID
    AND GET_CUSTNAME = IN_ID
    */

  RETURN V_NAME;
END;
-- �Ʒ� ����
SELECT O.*, GET_CUSTNAME(CUSTID) AS CUSTNAME
 FROM ORDERS O
;
SELECT O.*,
        (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUST_NAME
 FROM ORDERS O
;
SELECT O.*, GET_BOOKNAME(BOOKID) BOOK_NAME
      , GET_CUSTNAME(CUSTID) CUST_NAME
 FROM ORDERS O
;
--------------
SELECT O.*, B.BOOKNAME, C.NAME
 FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID -- ��������
; 











