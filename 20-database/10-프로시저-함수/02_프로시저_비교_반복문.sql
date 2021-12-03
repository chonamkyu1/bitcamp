/* �񱳱���(�б�ó��) IF��
IF (���ǽ�) THEN ~ END IF;
IF (���ǽ�) THEN ~ ELSE ~ END IF;
IF (���ǽ�) THEN ~ ELSIF ... ELSIF ... ELSE ~ END IF;
*/
-- Ȧ��, ¦�� �Ǻ�
CREATE OR REPLACE PROCEDURE PRC_IF (
  IN_NUM IN NUMBER --�Ķ���Ͱ� 
) AS 
BEGIN   
    DBMS_OUTPUT.PUT_LINE('>>�Է°�: ' || IN_NUM);
  
    -- Ȧ,¦ �Ǻ�
    IF (MOD(IN_NUM,2) = 0) THEN
        DBMS_OUTPUT.PUT_LINE(IN_NUM || ': ¦��');
    ELSE
        DBMS_OUTPUT.PUT_LINE(IN_NUM || ': Ȧ��');
    END IF;
END PRC_IF;
-----------------------
-- 4�� ���� ������ 
CREATE OR REPLACE PROCEDURE PRC_IF2 (
  IN_NUM IN NUMBER 
) AS 
BEGIN
  DBMS_OUTPUT.PUT_LINE('>>�Է°�: ' || IN_NUM); 
  
  -- 4�� ���� ������ �� Ȯ��
    IF (MOD(IN_NUM, 4) = 0) THEN
        DBMS_OUTPUT.PUT_LINE('>> 4�� ���� ������ 0');
    ELSIF (MOD(IN_NUM, 4) = 1) THEN 
        DBMS_OUTPUT.PUT_LINE('>> 4�� ���� ������ 1');
    ELSIF (MOD(IN_NUM, 4) = 2) THEN 
        DBMS_OUTPUT.PUT_LINE('>> 4�� ���� ������ 2');
    ELSE
        DBMS_OUTPUT.PUT_LINE('>> 4�� ���� ������ 3');
    END IF;
END PRC_IF2;

--=================================
-- �ݺ���: FOR, WHILE
-- FOR��
---- FOR ���� IN �ʱⰪ ... ������ LOOP ~ END LOOP;
-----------------
-- ����(N)�� �ϳ� �Է� �޾Ƽ� �հ� ���(1~N ������ ��)

CREATE OR REPLACE PROCEDURE PRC_FOR_SUM (
  IN_NUM IN NUMBER 
) AS 
    V_SUM NUMBER := 0; -- �հ� ���� ����(�ʱⰪ 0)
BEGIN
    -- �Է¹��� ���ڱ����� �հ� ���ϱ�
    DBMS_OUTPUT.PUT_LINE('>> �Է°�: ' || IN_NUM);
    
    -- FOR ������ �ݺ�ó��
    FOR I IN 1 .. IN_NUM LOOP
        V_SUM := V_SUM + I;
    END LOOP;
    
    DBMS_OUTPUT.PUT('1 ���� ' || IN_NUM || '������ �հ�: ');
    DBMS_OUTPUT.PUT_LINE(V_SUM);
    
    DBMS_OUTPUT.PUT_LINE('�հ�:' || V_SUM);
END PRC_FOR_SUM;

----------------------------------------------


CREATE OR REPLACE PROCEDURE PRC_FOR_REVERSE (
  IN_NUM IN NUMBER 
) AS 
BEGIN
    FOR I IN REVERSE 1 .. IN_NUM LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END PRC_FOR_REVERSE;

--================================
-- WHILE ��
-- WHILE (���ǽ�) LOOP ~ END LOOP;
-- ����(N)�� �ϳ� �Է� �޾Ƽ� �հ� ���(1~N ������ ��)
CREATE OR REPLACE PROCEDURE PRC_WHILE_SUM (
    IN_NUM IN NUMBER 
) AS 
    V_SUM NUMBER := 0;
    I NUMBER := 1;
BEGIN
  -- �Է°� Ȯ��(���)
  DBMS_OUTPUT.PUT_LINE('�Է°�: ' || IN_NUM);
  
  WHILE (I <= IN_NUM) LOOP
    V_SUM := V_SUM + I;
    I := I + 1; -- 1�� �����Ѵٴ� ��
  END LOOP;
  
  DBMS_OUTPUT.PUT_LINE('1~' || IN_NUM || ' ������ �հ�: '|| V_SUM);
END PRC_WHILE_SUM;

--===========================================
CREATE OR REPLACE PROCEDURE LOOP1
AS
    I NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('I: ' ||  I);
        EXIT WHEN (I>= 10);
        I := I + 1;
    END LOOP;
    
END LOOP1;

--==============================================
/* ���ڸ� �ϳ� �Է� �޾Ƽ� 1~ ���ڱ����� �հ� ���ϱ�
���ν�����: PRC_SUM_EVENODD
-- �Է°��� Ȧ���� Ȧ������ ���ϱ�
-- �Է°��� ¦���� ¦������ ���ؼ�
���� �հ谪�� ȭ�� ���
<�������>
-- �Է¼���: �Է°�, Ȧ��/¦��, �հ�: �հ���
    ��¿�) �Է¼���: 4, ¦��, �հ�: 6
    ��¿�) �Է¼���: 5, Ȧ��, �հ�: 9
*/










