-- USER SQL
CREATE USER "MYSTUDY" IDENTIFIED BY "mystudypw"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";
-- ROLES
GRANT "CONNECT" TO "MYSTUDY" ;
GRANT "RESOURCE" TO "MYSTUDY" ;