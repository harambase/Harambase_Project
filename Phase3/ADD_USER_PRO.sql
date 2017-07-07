create or replace PROCEDURE ADD_USER_PRO 
(
  USERID IN NUMBER 
, NAME IN VARCHAR2 
, EMAIL IN VARCHAR2 
, FNAME IN VARCHAR2 
, LNAME IN VARCHAR2 
, PASSWORD IN VARCHAR2 
, CREATORID IN NUMBER 
, ISBUYER IN NUMBER 
, ISELLER IN NUMBER
, STATUS OUT INTEGER
) AS 
BEGIN
  STATUS := 0;
  SELECT COUNT(*) INTO STATUS FROM HARAMBASE_MEMBER M WHERE M.UNAME = NAME;
  IF STATUS = 0 THEN
    INSERT INTO team2.HARAMBASE_MEMBER VALUES (USERID,NAME,EMAIL,FNAME,LNAME,PASSWORD,CREATORID,ISBUYER,ISELLER);
  END IF;
END ADD_USER_PRO;
