create or replace PROCEDURE ADD_FEEDBACK_PRO 
(
  ITEMID IN NUMBER 
, OVERALLRATING IN NUMBER
, ITEMQUALITY IN NUMBER 
, DELIVERY IN NUMBER 
, COMMENTS IN VARCHAR2 
) AS 
BEGIN
  INSERT INTO team2.HARAMBASE_FEEDBACK VALUES (ITEMID,OVERALLRATING,ITEMQUALITY,DELIVERY,COMMENTS);
END ADD_FEEDBACK_PRO;