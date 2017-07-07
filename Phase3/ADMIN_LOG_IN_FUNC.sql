create or replace FUNCTION ADMIN_LOG_IN_FUNC 
(
  USERNAME IN VARCHAR2 
, USERPASSWORD IN VARCHAR2 
) RETURN INTEGER AS ISLOG INT := 0; --CHECK FOR USERNAME AND PASSWORD. T/F = 1/0
BEGIN
  SELECT COUNT(*) INTO ISLOG FROM HARAMBASE_ADMIN A WHERE A.UNAME = USERNAME AND A.PASSWORD = USERPASSWORD;
  RETURN ISLOG; --RETURN 1 IF COUNT IS 1.
  
END ADMIN_LOG_IN_FUNC;