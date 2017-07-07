--
--DECLARE 
-- CURMAX INTEGER;
--BEGIN
-- CURMAX := 1;
-- SELECT MAX(USERID) INTO CURMAX FROM HARAMBASE_MEMBER;
-- IF CURMAX > 1 THEN
--    EXECUTE IMMEDIATE 'DROP SEQUENCE USERSEQ';
-- END IF;
-- CURMAX := CURMAX + 1;
-- EXECUTE IMMEDIATE 'CREATE SEQUENCE  USERSEQ MINVALUE 1 MAXVALUE 1000 INCREMENT BY 1 START WITH '||CURMAX||' NOCACHE  ORDER  NOCYCLE  NOPARTITION' ;
--END;


CREATE OR REPLACE TRIGGER generateuserid
BEFORE INSERT ON harambase_member
FOR EACH ROW
BEGIN
	SELECT USERSEQ.nextval INTO :NEW.userid FROM dual;
END;



