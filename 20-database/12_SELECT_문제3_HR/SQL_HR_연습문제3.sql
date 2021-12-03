/****** HR ����Ÿ ��ȸ ����2 ****************
/*1�� HR �μ��� � ����� �޿������� ��ȸ�ϴ� ������ �ð� �ִ�. 
  Tucker ��� ���� �޿��� ���� �ް� �ִ� ����� 
  �̸��� ��(Name���� ��Ī), ����, �޿��� ����Ͻÿ�
*****************************************************/
SELECT (FIRST_NAME || ' '|| LAST_NAME) NAME , JOB_ID, SALARY -- Tucker�� 10000�� �޴´�
 FROM EMPLOYEES
 WHERE SALARY >  (SELECT SALARY FROM EMPLOYEES WHERE LAST_NAME = 'Tucker')
 ORDER BY SALARY 
;

SELECT SALARY
FROM EMPLOYEES
WHERE LAST_NAME = 'Tucker'
;

SELECT * FROM EMPLOYEES;

/*2�� ����� �޿� ���� �� ������ �ּ� �޿��� �ް� �ִ� ����� -> GROUP BY 
  �̸��� ��(Name���κ�Ī), ����, �޿�, �Ի����� ����Ͻÿ�
********************************************************/
SELECT E.EMPLOYEE_ID, E.JOB_ID, E.SALARY, M.JOB_ID M_JOB_ID, M.MIN_SALARY
 FROM EMPLOYEES E, 
      (SELECT E.JOB_ID, MIN(E.SALARY) MIN_SALARY
       FROM EMPLOYEES E  
       GROUP BY E.JOB_ID) M
 WHERE E.JOB_ID = M.JOB_ID
 AND E.SALARY = M.MIN_SALARY
 ORDER BY E.JOB_ID 
 ;
 
 SELECT (E.FIRST_NAME|| ' ' || E.LAST_NAME) NAME, E.JOB_ID, E.SALARY, M.M_SALARY, E.HIRE_DATE
 FROM EMPLOYEES E, (SELECT JOB_ID, MIN(SALARY) AS M_SALARY
                     FROM EMPLOYEES
                     GROUP BY JOB_ID) M
 WHERE E.JOB_ID = M.JOB_ID AND E.SALARY = M.M_SALARY
 ORDER BY M.M_SALARY
;

SELECT JOB_ID
FROM EMPLOYEES
GROUP BY JOB_ID
;

/*3�� �Ҽ� �μ��� ��� �޿����� ���� �޿��� �޴� ����� 
  �̸��� ��(Name���� ��Ī), �޿�, �μ���ȣ, ������ ����Ͻÿ�
***********************************************************/ 
SELECT E.EMPLOYEE_ID,(E.FIRST_NAME|| ' ' || E.LAST_NAME) NAME, E.DEPARTMENT_ID,D.DEPARTMENT_ID ,E.SALARY, D.AVG_SALARY
 FROM EMPLOYEES E, (SELECT DEPARTMENT_ID , ROUND(AVG(SALARY)) AVG_SALARY
                     FROM EMPLOYEES
                     GROUP BY DEPARTMENT_ID) D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
 AND E.SALARY > D.AVG_SALARY
;

SELECT E.EMPLOYEE_ID,(E.FIRST_NAME|| ' ' || E.LAST_NAME) NAME, E.JOB_ID, E.SALARY, D.D_SALARY
 FROM  EMPLOYEES E, (SELECT DEPARTMENT_ID, ROUND(AVG(SALARY)) AS D_SALARY
                     FROM EMPLOYEES
                    GROUP BY DEPARTMENT_ID) D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
 AND E.SALARY > D.D_SALARY
;


/*4�� ��� ����� �ҼӺμ� ��տ����� ����Ͽ� ������� �̸��� ��(Name���� ��Ī),
  ����, �޿�, �μ���ȣ, �μ���տ���(Department Avg Salary�� ��Ī)�� ����Ͻÿ�
***************************************************************/
SELECT *
 FROM EMPLOYEES E, (SELECT DEPARTMENT_ID, ROUND(AVG(SALARY)) AVG_SALARY
                    FROM EMPLOYEES
                    GROUP BY DEPARTMENT_ID) D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.SALARY = D.AVG_SALARY
; 


/*5�� HR ��Ű���� �ִ� Job_history ���̺��� ������� ���� ���� �̷��� ��Ÿ���� ���̺��̴�. 
  �� ������ �̿��Ͽ� ��� ����� ���� �� ������ ���� �̷� ������ ����ϰ��� �Ѵ�. 
  �ߺ��� ��������� ������ �� ���� ǥ���Ͽ� ����Ͻÿ�
  (�����ȣ, ����)  UNION (������) ���
*********************************************************************/
SELECT EMPLOYEE_ID, JOB_ID
 FROM JOB_HISTORY 
UNION 
SELECT EMPLOYEE_ID, JOB_ID
 FROM EMPLOYEES
 ORDER BY EMPLOYEE_ID
;
/*6�� �� �������� �� ����� ���� �̷� ������ Ȯ���Ͽ���. ������ '��� �����
  ���� �̷� ��ü'�� ������ ���ߴ�. ���⿡���� ��� ����� 
  ���� �̷� ���� ����(JOB_HISTORY) �� �������濡 ���� �μ������� 
  �����ȣ�� ���� ������� ����Ͻÿ�(���տ����� UNION)
  (�����ȣ, �μ�����, ����)
**********************************************************************/
  SELECT EMPLOYEE_ID, DEPARTMENT_ID,JOB_ID
 FROM JOB_HISTORY 
UNION ALL
SELECT EMPLOYEE_ID,DEPARTMENT_ID, JOB_ID
 FROM EMPLOYEES
 ORDER BY EMPLOYEE_ID
 ;
/*7�� HR �μ������� �ű� ������Ʈ�� �������� �̲� �ش� �����ڵ��� 
  �޿��� �λ� �ϱ�� �����Ͽ���. 
  ����� ���� 107���̸� 19���� ������ �ҼӵǾ� �ٹ� ���̴�. 
  �޿� �λ� ����ڴ� ȸ���� ����(Distinct job_id) �� ���� 5�� �������� 
  ���ϴ� ����� �ش�ȴ�. ������ ������ ���ؼ��� �޿��� ����ȴ�. 
  5�� ������ �޿� �λ���� ������ ����.
  HR_REP(10%), MK_REP(12%), PR_REP(15%), SA_REP(18%), IT_PROG(20%)
**********************************************************************/
SELECT COUNT(*)
 FROM EMPLOYEES
 WHERE JOB_ID
;
/*8�� HR �μ������� �ֻ��� �Ի��Ͽ� �ش��ϴ� 2001����� 2003����� �Ի��ڵ��� �޿��� 
  ���� 5%, 3%, 1% �λ��Ͽ� ���п� ���� �������� �����ϰ��� �Ѵ�. 
  ��ü ����� �� �ش� �⵵�� �ش��ϴ� ������� �޿��� �˻��Ͽ� �����ϰ�, 
  �Ի����ڿ� ���� �������� ������ �����Ͻÿ�
**********************************************************************/

/*9�� �μ��� �޿� �հ踦 ���ϰ�, �� ����� ������ ���� ǥ���Ͻÿ�.
  Sum Salary > 100000 �̸�, "Excellent"
  Sum Salary > 50000 �̸�, "Good"
  Sum Salary > 10000 �̸�, "Medium"
  Sum Salary <= 10000 �̸�, "Well"
**********************************************************************/
SELECT E.DEPARTMENT_ID, SUM(SALARY)
       , CASE
       WHEN SUM(SALARY) > 100000 THEN 'Excellent'
       WHEN SUM(SALARY) > 50000 THEN 'GOOD'
       WHEN SUM(SALARY) > 10000 THEN 'MEDIUM'
       ELSE 'WELL'
       END
 FROM DEPARTMENTS D , EMPLOYEES E
 WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID
 GROUP BY E.DEPARTMENT_ID

 ;
 
/*10�� 2005�� ������ �Ի��� ��� �� ������ "MGR"�� ���Ե� ����� 15%, 
  "MAN"�� ���Ե� ����� 20% �޿��� �λ��Ѵ�. 
  ���� 2005����� �ٹ��� ������ ��� �� "MGR"�� ���Ե� ����� 25% �޿��� �λ��Ѵ�. 
  �̸� �����ϴ� ������ �ۼ��Ͻÿ�
**********************************************************************/
SELECT  EMPLOYEE_ID, TO_CHAR(HIRE_DATE, 'YYYY')AS YEAR,JOB_ID,SALARY
        , CASE
        WHEN TO_CHAR(HIRE_DATE, 'YYYY') < '2005' AND JOB_ID LIKE '%MGR%' THEN SALARY+ SALARY*0.15
        WHEN TO_CHAR(HIRE_DATE, 'YYYY') < '2005'AND JOB_ID LIKE '%MAN%' THEN SALARY+ SALARY*0.20
        WHEN TO_CHAR(HIRE_DATE, 'YYYY') >= '2005'AND JOB_ID LIKE '%MGR%' THEN SALARY+ SALARY*0.25
        ELSE SALARY
        END AS SALARY2,
        CASE
        WHEN TO_CHAR(HIRE_DATE, 'YYYY') < '2005' AND JOB_ID LIKE '%MGR%' THEN SALARY*0.15
        WHEN TO_CHAR(HIRE_DATE, 'YYYY') < '2005'AND JOB_ID LIKE '%MAN%' THEN  SALARY*0.20
        WHEN TO_CHAR(HIRE_DATE, 'YYYY') >= '2005'AND JOB_ID LIKE '%MGR%' THEN  SALARY*0.25
        ELSE 0
        END AS "�λ�ݾ�"
 FROM EMPLOYEES
 ;
 
 SELECT JOB_ID, HIRE_DATE FROM EMPLOYEES ORDER BY JOB_ID;
/*11�� ������ �Ի��� ��� �� ���
  (���1) ������ �Ի��� ��� ���� �Ʒ��� ���� �� �ະ�� ��µǵ��� �Ͻÿ�(12��).
  1�� xx
  2�� xx
  3�� xx
  ..
  12�� xx
  �հ� XXX
**********************************************************************/  
SELECT E.EMPLOYEE_ID, TO_CHAR(E.HIRE_DATE, 'MM') AS MONTH
 FROM EMPLOYEES E, (SELECT TO_CHAR(HIRE_DATE, 'MM') AS HIRE_DATE2
                    FROM EMPLOYEES GROUP BY HIRE_DATE) M
 WHERE E.HIRE_DATE = M.HIRE_DATE2
 ORDER BY MONTH
;
 ;
SELECT TO_CHAR(HIRE_DATE, 'MM') AS MM, COUNT(*)
 FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'MM')
 ;
 
SELECT TO_CHAR(HIRE_DATE, 'MM') AS "��", COUNT(*) AS "�ο���"
 FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'MM')
 
 UNION
 SELECT '�հ�' AS "��", COUNT(*) AS "�ο���"
 FROM EMPLOYEES
;

SELECT TO_NUMBER(TO_CHAR(HIRE_DATE, 'MM')) AS "��", COUNT(*) AS "�ο���"
 FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'MM')
UNION
SELECT 99 AS "��", COUNT(*) AS "�ο���"
 FROM EMPLOYEES
 ORDER BY 1
;

--SELECT DECODE(MM, 99, '�հ�', MM||'��') AS "�Ի��", CNT AS "�ο���"
SELECT DECODE(MM,99,'�հ�', MM||'��') AS "�Ի��", CNT AS "�ο���"
 FROM (SELECT TO_NUMBER(TO_CHAR(HIRE_DATE, 'MM')) AS MM, COUNT(*) AS CNT
 FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'MM')
UNION
SELECT 99 AS MM, COUNT(*) AS CNT
 FROM EMPLOYEES
 ORDER BY 1)
 ;

SELECT TO_NUMBER(TO_CHAR(HIRE_DATE, 'MM')) AS MM, COUNT(*) AS CNT
 FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'MM')
UNION
SELECT 99 AS MM, COUNT(*) AS CNT
 FROM EMPLOYEES
;


---------------------------------------------------------
/* (���2) ù �࿡ ��� ���� �Ի� ��� ���� ��µǵ��� �Ͻÿ�
  1�� 2�� 3�� 4�� .... 11�� 12��
  xx  xx  xx xx  .... xx   xx
**********************************************************************/
SELECT TO_CHAR(HIRE_DATE, 'MM')
 FROM EMPLOYEES
;

SELECT DECODE(TO_CHAR(HIRE_DATE, 'MM'), '01',1,0) AS "1��"
       ,DECODE(TO_CHAR(HIRE_DATE, 'MM'), '02',1,0) AS "2��"
       ,DECODE(TO_CHAR(HIRE_DATE, 'MM'), '03',1,0) AS "3��"    
 FROM EMPLOYEES
 ORDER BY TO_CHAR(HIRE_DATE, 'MM')
;

SELECT SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '01',1,0)) AS "1��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '02',1,0)) AS "2��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '03',1,0)) AS "3��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '04',1,0)) AS "4��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '05',1,0)) AS "5��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '06',1,0)) AS "6��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '07',1,0)) AS "7��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '08',1,0)) AS "8��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '09',1,0)) AS "9��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '10',1,0)) AS "10��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '11',1,0)) AS "11��"
       ,SUM(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '12',1,0)) AS "12��"
 FROM EMPLOYEES
 ORDER BY TO_CHAR(HIRE_DATE, 'MM')
;

