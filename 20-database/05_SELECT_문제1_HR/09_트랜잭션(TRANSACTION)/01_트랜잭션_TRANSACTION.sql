/*  ****트랜잭션(TRANSACTION)  ****
트랜잭션(TRANSACTION): DBMS에서 데이터를 다루는 논리적인 작업의 단위

<트랜잭션의 종료>
COMMIT; -- 작업내용을 DB에 반영하고 트랜잭션 종료

<트랜잭션의 일부 또는 전체 무효화>
ROLLBACK; -- 최종 COMMIT 시점부터 모두 취소  
ROLLBACK TO 세이브포인트이름; -- 세이브포인트 위치까지 취소

<세이브포인트 설정>
SAVEPOINT 세이브포인트이름;


*/