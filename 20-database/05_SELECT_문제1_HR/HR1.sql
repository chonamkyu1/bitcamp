/* ** �ǽ����� : HR����(DB)���� �䱸���� �ذ� **********
-- ���(employee_id)�� 100�� ���� ���� ��ü ����
-- ����(salary)�� 15000 �̻��� ������ ��� ���� ����
-- ������ 15000 �̻��� ����� ���, �̸�(LAST_NAME), �Ի���(hire_date), ���޿� ���� ����
-- ������ 10000 ������ ����� ���, �̸�(LAST_NAME), �Ի���, ���޿� ���� ����
---- (�޿��� ���� �������)
-- �̸�(first_name)�� john�� ����� ��� ���� ��ȸ
-- �̸�(first_name)�� john�� ����� �� ���ΰ�?
-- 2008�⿡ �Ի��� ����� ���, ����('first_name last_name'), ���޿� ���� ��ȸ
---- ���� ��¿�) 'Steven King'
-- ���޿��� 20000~30000 ������ ���� ���, ����(last_name first_name), ���޿� ���� ��ȸ
-- ������ID(MANAGER_ID)�� ���� ��� ���� ��ȸ
-- ����(job_id)�ڵ� 'IT_PROG'���� ���� ���� ���޿��� ��
-- ������ �ִ� ���޿� �˻�
-- ������ �ִ� ���޿� �˻��ϰ�, �ִ� ���޿��� 10000�̻��� ���� ��ȸ
-- ������ ��ձ޿� �̻��� ���� ��ȸ
**********************************************************/

-- ���(employee_id)�� 100�� ���� ���� ��ü ����
SELECT *
 FROM EMPLOYEES
 WHERE EMPLOYEE_ID >= 100
;

-- ����� Ǯ��
SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;

-- ����(salary)�� 15000 �̻��� ������ ��� ���� ����
SELECT *
 FROM EMPLOYEES 
 WHERE SALARY >= 15000
;

-- ����� Ǯ��
SELECT * FROM EMPLOYEES WHERE SALARY >= 15000 ORDER BY SALARY;

-- ������ 15000 �̻��� ����� ���, �̸�(LAST_NAME), �Ի���(hire_date), ���޿� ���� ����
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
 FROM EMPLOYEES
 WHERE SALARY >= 15000
;

-- ����� Ǯ��
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
 FROM EMPLOYEES
 WHERE SALARY >= 15000
;


 -- ������ 10000 ������ ����� ���, �̸�(LAST_NAME), �Ի���, ���޿� ���� ����
---- (�޿��� ���� �������)
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
 FROM EMPLOYEES
 WHERE SALARY <= 10000
 ORDER BY SALARY DESC
; 

-- ����� Ǯ��
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
 FROM EMPLOYEES
 WHERE SALARY <= 10000
 ORDER BY SALARY DESC
;

-- �̸�(first_name)�� john�� ����� ��� ���� ��ȸ
SELECT *
 FROM EMPLOYEES
 WHERE FIRST_NAME = 'John'
;

-- ����� Ǯ��
---- JOHN, John, john, jOHn ...
SELECT * FROM EMPLOYEES WHERE FIRST_NAME = 'John';
SELECT *
 FROM EMPLOYEES 
 WHERE FIRST_NAME = INITCAP('john'); -- ǥ��ȭ�� �Ǿ� �ִ� ���
 
SELECT *
 FROM EMPLOYEES 
 WHERE UPPER(FIRST_NAME) = 'JOHN'; -- �����Ͱ� ǥ��ȭ ���� ���� ���
 SELECT *
 FROM EMPLOYEES 
 WHERE LOWER(FIRST_NAME) = 'john';
 SELECT *
 FROM EMPLOYEES 
 WHERE INITCAP(FIRST_NAME) = 'John';

-- �̸�(first_name)�� john�� ����� �� ���ΰ�?
SELECT COUNT(*)
 FROM EMPLOYEES
 WHERE FIRST_NAME = 'John'
; 

-- ����� Ǯ��
SELECT COUNT(*)
 FROM EMPLOYEES
 WHERE FIRST_NAME = INITCAP('john')
;

-- 2008�⿡ �Ի��� ����� ���, ����('first_name last_name'), ���޿� ���� ��ȸ
---- ���� ��¿�) 'Steven King'
SELECT EMPLOYEE_ID, FIRST_NAME,LAST_NAME, SALARY, HIRE_DATE
 FROM EMPLOYEES
 WHERE HIRE_DATE >= '08/01/01' 
;

-- ����� Ǯ��
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' ||LAST_NAME  AS NAME, SALARY
       , HIRE_DATE
 FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('2008/01/01', 'YYYY/MM/DD')
                     AND TO_DATE('2008/12/31', 'YYYY/MM/DD')
 ORDER BY HIRE_DATE
 ;

SELECT EMPLOYEE_ID, FIRST_NAME || ' ' ||LAST_NAME  AS NAME, SALARY
       , HIRE_DATE
 FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'YYYY') = '2008'
 ORDER BY HIRE_DATE
 ;
-- ���޿��� 20000~30000 ������ ���� ���, ����(last_name first_name), ���޿� ���� ��ȸ
SELECT EMPLOYEE_ID, LAST_NAME, FIRST_NAME, SALARY
 FROM EMPLOYEES
 WHERE SALARY BETWEEN 20000 AND 30000
; 

-- ����� Ǯ��
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' ||LAST_NAME  AS NAME, SALARY
 FROM EMPLOYEES
 WHERE SALARY BETWEEN 20000 AND 30000
;

SELECT EMPLOYEE_ID, FIRST_NAME || ' ' ||LAST_NAME  AS NAME, SALARY
 FROM EMPLOYEES
 WHERE SALARY >= 20000 AND SALARY <= 30000
; 

-- ������ID(MANAGER_ID)�� ���� ��� ���� ��ȸ
SELECT *
 FROM EMPLOYEES
 WHERE  MANAGER_ID IS NULL
;

-- ����� Ǯ��
SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NULL;

-- ����(job_id)�ڵ� 'IT_PROG'���� ���� ���� ���޿��� ��
SELECT MAX(SALARY)
 FROM EMPLOYEES
 WHERE JOB_ID = 'IT_PROG'
; 
 
-- ����� Ǯ��
SELECT MAX(SALARY)
 FROM EMPLOYEES
 WHERE JOB_ID = 'IT_PROG'
;
 
-- ������ �ִ� ���޿� �˻�
SELECT JOB_ID, MAX(SALARY)
 FROM EMPLOYEES
 GROUP BY JOB_ID
;

-- ����� Ǯ��
SELECT JOB_ID, MAX(SALARY)
 FROM EMPLOYEES
 GROUP BY JOB_ID
;

SELECT JOB_ID,COUNT(*),SUM(SALARY),AVG(SALARY), MAX(SALARY), MIN(SALARY)
 FROM EMPLOYEES
 GROUP BY JOB_ID
;

-- ������ �ִ� ���޿� �˻��ϰ�, �ִ� ���޿��� 10000�̻��� ���� ��ȸ
SELECT JOB_ID, MAX(SALARY)
 FROM EMPLOYEES
 GROUP BY JOB_ID
 HAVING MAX(SALARY) >= 10000
; 

-- ����� Ǯ��
SELECT JOB_ID, MAX(SALARY)
 FROM EMPLOYEES
 GROUP BY JOB_ID
 HAVING MAX(SALARY) >= 10000
;

SELECT JOB_ID, MAX(SALARY)
-- SELECT EMPLOYEE_ID, JOB_ID, SALARY
 FROM EMPLOYEES
 WHERE SALARY >= 10000 -- 10000�̻� �޴� ����鸸 ������� �� ��
 GROUP BY JOB_ID
;

-- ������ ��ձ޿� �̻��� ���� ��ȸ
SELECT JOB_ID
 FROM EMPLOYEES E , (SELECT AVG(SALARY) AVG_SALARY FROM EMPLOYEES) M
 WHERE SALARY >= M.AVG_SALARY
 GROUP BY JOB_ID
;
E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, SALARY
SELECT AVG(SALARY) FROM EMPLOYEES;

-- ����� Ǯ��
SELECT JOB_ID, AVG(SALARY)
 FROM EMPLOYEES
 GROUP BY JOB_ID
;
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, E.SALARY
 FROM EMPLOYEES E
 WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEES
                WHERE JOB_ID = E.JOB_ID)
; 
-----
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, E.SALARY
       ,J.JOB_ID J_JOB_ID, J.AVG_SALARY
 FROM EMPLOYEES E 
      , (SELECT JOB_ID, AVG(SALARY) AVG_SALARY
        FROM EMPLOYEES
        GROUP BY JOB_ID) J -- ��������: �������̺�(�ζ��κ�)
 WHERE E.JOB_ID = J.JOB_ID -- ��������
 AND E.SALARY >= J.AVG_SALARY -- �˻�����
; 