----------------------------------------------------------------------------------------------------------------------
-----------------------------------Administrator SubSystem: Functionalities for administrators------------------------
----------------------------------------------------------------------------------------------------------------------
--NO.1 Functionality:
--Admin login
SELECT ADMIN_LOG_IN_FUNC('admin','admin') FROM DUAL;
--EXPECTED: 1
--       ADMIN_LOG_IN_FUNC('ADMIN','ADMIN')
-----------------------------------------
--                                      1       
SELECT ADMIN_LOG_IN_FUNC('admin','admi') FROM DUAL;
--EXPECTED: 0
--      ADMIN_LOG_IN_FUNC('ADMIN','ADMI')
-----------------------------------------
--                                      0
--IF IT IS 1, THEN LOGIN SUCCESSFUL, OTHERWISE NOT SUCCESSFUL.

----------------------------------------------------------------------------------------------------------------------
--NO2. Functionality:
--View Users
SELECT USERID, UNAME, FNAME, LNAME, EMAIL, PASSWORD FROM HARAMBASE_MEMBER;
--    USERID UNAME      FNAME           LNAME           EMAIL                 PASSWORD    
------------ ---------- --------------- --------------- -------------------- ------------------
--         1 jfolks     Josh            Folkerds        jfolks@harambase.org  Folkerds        
--
--         2 mkounn     Matthew         Kounniyom       mkounn@harambase.org  Kounniyom       
--
--         3 slin       Shilei          Lin             slin@harambase.org    Lin             
--
--         4 irahal     Imad            Rahal           irahal@harambase.org  Rahal 

----------------------------------------------------------------------------------------------------------------------
--NO3. Funcionality
--Add user by Procedure : ADD_USER_PRO
Set serveroutput on;
DECLARE
  STATUS INT;
BEGIN
  ADD_USER_PRO(-1, 'hrambe', 'hrambe@harambase.org', 'Harambe', 'Gorilla', 'Gorilla', 0, 0, 0, STATUS);
  DBMS_OUTPUT.PUT_LINE(STATUS);
  ADD_USER_PRO(-1, 'lmatt', 'Matt@harambase.org', 'Matthew', 'Lynch', 'Lynch', 0, 1, 1,STATUS);
  DBMS_OUTPUT.PUT_LINE(STATUS);
END; 


SELECT USERID, UNAME, FNAME, LNAME, EMAIL, PASSWORD FROM Harambase_Member;

--EXPECTED: hrambe add to the data base:
--PL/SQL procedure successfully completed.
--
--    USERID UNAME      FNAME           LNAME           EMAIL                 PASSWORD    
------------ ---------- --------------- --------------- -------------------- ------------------
--         1 jfolks     Josh            Folkerds        jfolks@harambase.org  Folkerds        
--
--         2 mkounn     Matthew         Kounniyom       mkounn@harambase.org  Kounniyom       
--
--         3 slin       Shilei          Lin             slin@harambase.org    Lin             
--
--         4 irahal     Imad            Rahal           irahal@harambase.org  Rahal           
--
--         5 hrambe     Harambe         Gorilla         hrambe@harambase.org  Gorilla 
--
--         6 lmatt      Matthew         Lynch           Matt@harambase.org   Lynch  

----------------------------------------------------------------------------------------------------------------------
--NO 4. Functionality
--View Sales Summary Report

--CREATE OR REPLACE FORCE VIEW SALES_SUMMARY_REPORT AS 
--SELECT ITEM.ITEMCATEGORY, ITEM.ITEMID, ITEM.ITEMNAME, HARAMBASE_GETPRICE_FUNC(ITEM.ITEMID) AS FINAL_SELLING_PRICE, 
--       HARAMBASE_GETPRICE_FUNC(ITEM.ITEMID)*0.05 AS COMMISSION
--FROM HARAMBASE_ITEM ITEM
--WHERE GET_STATUS_FUNC(ITEM.ITEMID) = 1
--ORDER BY ITEM.ITEMCATEGORY, ITEM.ITEMID;
--OUTPUT:
--View SALES_SUMMARY_REPORT created.

SELECT * FROM SALES_SUMMARY_REPORT;
--CATE  ID   NAME                 FINAL_PRICE  COMMISSION
-------------------------------------------------------------
--BOOK	101	DATABASES BOOK	           151     	7.55
--BOOK	104	Abstarct Mathematics	     21     	1.05
--FOOD	102	CHINSES INSTANT NODDLES	   7	      0.35
--FOOD	103	TACO	                     11	      0.55
--Outdoor Gear	100	SJU Snapback Hat	 51	      2.55
----------------------------------------------------------------------------------------------------------------------
--NO 5. Functionality
--View Overall Commission Report(NOT FINISHED: MISSING: COMMISSIONS)

--CREATE OR REPLACE VIEW Overall_Commission_View AS
--SELECT HM.UserID as userID, HM.Uname as User_Name, HM.Fname as First_Name,
--      HM.Lname as Last_Name, HM.Email as Email, 
--      AVG(HF.OverallRating) AS Seller_Rating,
--      SUM(SR.COMMISSION) AS COMMISSIONS
--FROM Harambase_Feedback HF, Harambase_MEMBER HM, SALES_SUMMARY_REPORT SR
--WHERE HM.UserID IN (Select Item.SellerID
--                    From Harambase_Item Item
--                    WHERE ITEM.ITEMID = SR.ITEMID AND ITEM.ITEMID = HF.ITEMID) 
--       
--Group By HM.UserID, HM.Uname, HM.Fname, HM.Lname, HM.Email
--ORDER BY HM.USERID;
--OUTPUT:
--View OVERALL_COMMISSION_VIEW created.
SELECT * FROM OVERALL_COMMISSION_VIEW;
--    USERID USER_NAME  FIRST_NAME      LAST_NAME       EMAIL               SELLER_RATING                             COMMISSIONS
------------ ---------- --------------- --------------- ------------------------------------------- ---------------------------------------
--         1 jfolks     Josh            Folkerds        jfolks@harambase.org  9.5                                     2.55
--         2 mkounn     Matthew         Kounniyom       mkounn@harambase.org  10                                      .35
--         3 slin       Shilei          Lin             slin@harambase.org    7.7E+00                                 9.15
--                                

----------------------------------------------------------------------------------------------------------------------
-----------------------------------CUSTOMERS SubSystem: Functionalities for MEMBERS-----------------------------------
----------------------------------------------------------------------------------------------------------------------
--NO.1 Functionality:
--MEMBER login: Function Member_Log_In_Func will reture 0/1 value like Admin_Login
--IF IT Returns 1, THEN LOGIN SUCCESSFUL, OTHERWISE (0) NOT SUCCESSFUL.
--For both Seller and Buyer
SELECT MEMBER_LOG_IN_FUNC('slin','Lin') FROM DUAL;
--EXPECTED: 1
--       MEMBER_LOG_IN_FUNC('SLIN','LIN')
-----------------------------------------
--                                      1  
SELECT ADMIN_LOG_IN_FUNC('slin','Lin') FROM DUAL; --s1lin is not Admin, return 0
--EXPECTED: 0
--        ADMIN_LOG_IN_FUNC('SLIN','LIN')
-----------------------------------------
--                                      0
SELECT MEMBER_LOG_IN_FUNC('slin','in') FROM DUAL;
--        MEMBER_LOG_IN_FUNC('SLIN','IN')
-----------------------------------------
--                                      0


----------------------------------------------------------------------------------------------------------------------
--NO.2 Functionality:
--Update Profile: User procedure Update_profile_FUNC to accomplish (BOTH SELLER AND BUYER)
SELECT * FROM HARAMBASE_MEMBER WHERE USERID = 3;

--    USERID UNAME      EMAIL                FNAME           LNAME    PASSWORD          CREATORID    ISBUYER    ISELLER
------------------ ---------- ---------- ---------- ---------- -----  ---------------- --------------- ---------------
--     3     slin       slin@harambase.org   Shilei          Lin      Lin                       0          1          1

                  

--sql SCRIPT TO UPDATE USER:
declare 
  SUCC Integer;
begin
  UPDATE_PROFILE_PRO(3,'s1in',NULL,'sHILEI','lIN',NULL,NULL,NULL,SUCC);
  DBMS_OUTPUT.PUT_LINE(SUCC);
end;


SELECT * FROM HARAMBASE_MEMBER WHERE USERID = 3;
--    USERID UNAME      EMAIL                FNAME           LNAME    PASSWORD          CREATORID    ISBUYER    ISELLER
------------------ ---------- ---------- ---------- ---------- -----  ---------------- --------------- -----------------
--     3     slin       slin@harambase.org   sHILEI          lIN      Lin                       0          1          1

------------------------------------------------------------------------------------------------------------------------

--NO.3 Functionality:
--Show list of bidders from List_Of_Bidder_View (SELLING)
SELECT HB.BIDDINGTIME ,HM.UNAME AS USERNAME, HB.MAXBIDLIMIT AS MAX_BID_LIMIT 
FROM HARAMBASE_BID HB, HARAMBASE_MEMBER HM
WHERE HB.USERID IN (SELECT HM.USERID
                      FROM HARAMBASE_ITEM HM)
                      AND HB.ITEMID = 101
ORDER BY HB.BIDDINGTIME;
--BIDDINGTIME                     USERNAME   MAX_BID_LIMIT
--------------------------------- ---------- -------------
--04-NOV-16 10.00.00.000000000 AM mkounn               150
--05-NOV-16 11.00.00.000000000 AM slin                 160
--06-NOV-16 12.00.00.000000000 PM irahal               170

----------------------------------------------------------------------------------------------------------------------
--NO.4 Functionality:
--Show list of Items that current seller listed. (SELLING)
-- 1: SOLD, 0: ON AUCTION, -1: NOT ON AUCTION
SELECT ITEM.ITEMID, ITEM.ITEMNAME, ITEM.ITEMCATEGORY, ITEM.AUCTIONSTARTTIME, ITEM.AUCTIONENDTIME, HARAMBASE_GETPRICE_FUNC(ITEM.ITEMID) AS CURRENT_BID,
       GET_STATUS_FUNC(ITEM.ITEMID) AS STATUS
FROM HARAMBASE_ITEM ITEM
WHERE ITEM.SELLERID IN (SELECT M.USERID
                        FROM HARAMBASE_MEMBER M) 
      AND ITEM.SELLERID = '3'
ORDER BY GET_STATUS_FUNC(ITEM.ITEMID) DESC, ITEM.ITEMID;
--ITEMID     ITEMNAME CATE   AUCTION START TIME             AUCTION END TIME               CURRENTBID STATUS
----------------------------------------------------------------------------------------------------------------------
--101	DATABASES BOOK	BOOK	03-NOV-16 11.00.00.000000000 AM	12-NOV-16 12.00.00.000000000 PM	151	1
--103	TACO	FOOD	03-NOV-16 11.00.00.000000000 AM	10-NOV-16 12.00.00.000000000 PM	11	1
--104	Abstarct Mathematics	BOOK	03-NOV-16 11.00.00.000000000 AM	10-NOV-16 12.00.00.000000000 PM	21	1
--106	INTRODUCTION TO Mathematics	BOOK	03-NOV-16 11.00.00.000000000 AM	10-NOV-17 12.00.00.000000000 PM	0	0
--105	INTRODUCTION TO Mathematics	BOOK	03-NOV-17 11.00.00.000000000 AM	10-NOV-17 12.00.00.000000000 PM	0	-1
----------------------------------------------------------------------------------------------------------------------
--NO.5 Functionality:
--Show ITEM INFORMATION (SELLING)
SELECT ITEM.ITEMID, ITEM.ITEMNAME, ITEM.ITEMCATEGORY, ITEM.AUCTIONSTARTTIME, ITEM.AUCTIONENDTIME, ITEM.DESCRIPTION
FROM HARAMBASE_ITEM ITEM
WHERE ITEM.ITEMID = '101';
--OUTPUT:
--ITEMID     ITEMNAME CATE   AUCTION START TIME             AUCTION END TIME                 DESCRIPTION
----------------------------------------------------------------------------------------------------------------------
--101	DATABASES BOOK	BOOK	03-NOV-16 11.00.00.000000000 AM	12-NOV-16 12.00.00.000000000 PM	BRAND NEW


----------------------------------------------------------------------------------------------------------------------
--NO.6 Functionality: 
--ADD ITEM (SELLING)
SELECT *  FROM Harambase_ITEM;
EXEC ADD_ITEM_PRO(1, 'TESTING', 'BOOK', 50, 'BRAND NEW', 3, TO_TIMESTAMP('03-NOV-2016 11:00:00', 'DD-MM-YYYY HH:MI:SS'), TO_TIMESTAMP('10-NOV-2017 12:00:00', 'DD-MM-YYYY  HH:MI:SS'));
SELECT *  FROM Harambase_ITEM;

----------------------------------------------------------------------------------------------------------------------
--NO.7 Functionality: 
--Bid an item (BUYING)
--declare 
--  SUCC Integer;
--begin
--  ADD_BID_PRO(4,106,100,SUCC);
--end;


--set serveroutput on;
--declare 
--  SUCC Integer;
--begin
--  ADD_BID_PRO(4,106,150,SUCC);
--  DBMS_OUTPUT.PUT_LINE(SUCC);
--end;
--EXPECTED: 4 --WINNER REJECTED
--ACTUAL: 4
SELECT * FROM harambase_bid WHERE itemid = 106;
--
--    USERID     ITEMID BIDDINGTIME                     MAXBIDLIMIT
------------ ---------- ------------------------------- -----------
--         4        106 15-NOV-16 01.18.37.457000000 AM         100

----------------------------------------------------------------------------------------------------------------------
--NO.8 Functionality: 
--Show items bid on (BUYING)
SELECT Distinct I.ItemID, I.ItemName, I.ItemCategory, I.AuctionStartTime, I.AuctionEndTime, Harambase_getPrice_Func(I.ItemID) AS CurrentBid, M.Uname AS Winner
FROM Harambase_BID B, Harambase_ITEM I, Harambase_Member M, Harambase_BID X
WHERE B.UserID = 4 AND B.ItemID = I.ItemID AND M.UserID = GetWinner_Func(I.ItemID)
ORDER BY I.ITEMID;
--Output-----------------------------------------------------------------------------------
--ItemID  ItemName   ItemCategory  StartTime   EndTime   CurrentBid  Winner
--101	DATABASES BOOK	BOOK	03-NOV-16 11.00.00.000000000 AM	12-NOV-16 12.00.00.000000000 PM	151	irahal
--102	CHINSES INSTANT NODDLES	FOOD	03-NOV-16 11.00.00.000000000 AM	10-NOV-16 12.00.00.000000000 PM	7	irahal
--104	Abstarct Mathematics	BOOK	03-NOV-16 11.00.00.000000000 AM	10-NOV-16 12.00.00.000000000 PM	21	irahal

----------------------------------------------------------------------------------------------------------------------
--NO.9 Functionality:
--List items bought (BUYING)
SELECT Distinct I.ItemID, I.ItemName, I.ItemCategory, I.AuctionStartTime, I.AuctionEndTime, I.StartPrice, Harambase_getPrice_Func(I.ItemID) AS SoldPrice, M.UName AS SellerUname, M.Email
FROM Harambase_ITEM I, Harambase_BID B, Harambase_MEMBER M
WHERE B.UserID = 4 AND M.UserID = I.SellerID AND B.UserID = GetWinner_Func(I.ItemID)
ORDER BY I.ITEMID;
--This page displays every item that the user has won. The item ID, item name, category, the auction start and end time, the start price, the sold price, the
--seller username and the seller email is displayed on this page. The user can also rate the seller from this page.
--Output---------------------------------------------------------------------------------------------------------------------------
--ItemID  ItemName                ItemCategory  StartTime                                    EndTime              StartPrice  SoldPrice   SellerUname Email
--101	    DATABASES BOOK            BOOK	       03-NOV-16 11.00.00.000000000 AM	12-NOV-16 12.00.00.000000000 PM	100	         151	       slin	slin@harambase.org
--102	    CHINSES INSTANT NODDLES	  FOOD	       03-NOV-16 11.00.00.000000000 AM	10-NOV-16 12.00.00.000000000 PM	20	          7	        mkounn	mkounn@harambase.org
--104	    Abstarct Mathematics	    BOOK	       03-NOV-16 11.00.00.000000000 AM	10-NOV-16 12.00.00.000000000 PM	20	          21    	   slin	slin@harambase.org

----------------------------------------------------------------------------------------------------------------------
--NO.10 Functionality: 
--Rate seller (BUYING)
SELECT *  FROM HARAMBASE_FEEDBACK FEED WHERE FEED.ITEMID = 103;
EXEC ADD_FEEDBACK_PRO(103, 10, 5, 5, 'VERY GOOD');
SELECT *  FROM HARAMBASE_FEEDBACK FEED WHERE FEED.ITEMID = 103;

--no rows selected
--PL/SQL procedure successfully completed.
--    ITEMID OVERALLRATING ITEMQUALITY   DELIVERY   COMMENTS                                                                     
-----------------------------------------------------------------
--       103            10           5          5   VERY GOOD                                                                       

----------------------------------------------------------------------------------------------------------------------
--NO.11 Functionality:
--View my feedback (SELLING)
SELECT Distinct M.UName, B.ItemID, F.OverallRating, F.ItemQuality, F.Delivery, F.Comments
FROM Harambase_FEEDBACK F, Harambase_ITEM I, Harambase_MEMBER M, Harambase_BID B
WHERE I.SellerID = 3 AND I.ItemID = F.ItemID AND B.MaxBidLimit = (SELECT Max(MaxBidLimit) FROM Harambase_BID B WHERE I.ItemID = B.ItemID) AND F.ItemID = B.ItemID AND B.UserID = M.UserID;
--The view my feedback page displays a table of all the feedback a user has received. The table displays the username of the user who submitted the feedback,
--as well as the item number, overall rating, item quality, delivery rating and any comments left by the reveiwer.
--Output---------------------------------------------------------------------
--Uname   ItemID  OverallRating ItemQuality Delivery  Comments
--irahal	202	    5	            5	          4	        The NOODLE IS GOOD.
--irahal	201	    8	            5	          4	        The BOOK IS GOOD.

----------------------------------------------------------------------------------------------------------------------
--NO.12 AND 13 Functionality:
--set serveroutput on;
--DECLARE
--  TID NUMBER;
--  KEYWORD VARCHAR2(200);
--  TCATEGORY VARCHAR2(200);
--  TAUCTIONSTARTTIME TIMESTAMP;
--  TAUCTIONENDTIME TIMESTAMP;
--  CURBIDMIN NUMBER;
--  CURBIDMAX NUMBER;
--  CURBID NUMBER;
--  STATUS NUMBER;
--  RESULTSET SYS_REFCURSOR;
--BEGIN
--  TID := NULL;
--  KEYWORD := 'DATA';
--  TCATEGORY := NULL;
--  TAUCTIONSTARTTIME := TO_TIMESTAMP('01-NOV-2016 10:00:00','DD-MM-YYYY HH:MI:SS');
--  TAUCTIONENDTIME := TO_TIMESTAMP('20-NOV-2017 11:00:00','DD-MM-YYYY HH:MI:SS');
--  CURBIDMIN := NULL;
--  CURBIDMAX := NULL;
--  CURBID := 0;
--  STATUS := 0;
--
--  SEARCH_ITEM_PRO(
--    TID,
--    KEYWORD,
--    TCATEGORY,
--    TAUCTIONSTARTTIME,
--    TAUCTIONENDTIME,
--    CURBIDMIN,
--    CURBIDMAX,
--    RESULTSET
--  );
--  /* Legacy output: 
--DBMS_OUTPUT.PUT_LINE('RESULTSET = ' || RESULTSET);
--*/ 
----  :RESULTSET := RESULTSET; --<-- Cursor
--  DBMS_OUTPUT.PUT_LINE('ID  | NAME | CATE |             AUCTION STAR TIME            |    AUCTION END TIME|   CURRENT BID |   STATUS');
--  LOOP 
--    FETCH RESULTSET
--    INTO TID, KEYWORD,TCATEGORY,TAUCTIONSTARTTIME,TAUCTIONENDTIME,CURBID,STATUS;
--    EXIT WHEN RESULTSET%NOTFOUND;
--    
--    DBMS_OUTPUT.PUT_LINE(TID || ' | ' || KEYWORD || ' | ' || TCATEGORY|| ' | ' ||TAUCTIONSTARTTIME || ' | ' || 
--          TAUCTIONENDTIME|| ' | ' ||CURBID|| ' | ' ||STATUS);
--  END LOOP;
--  CLOSE RESULTSET;
----rollback; 
--END;

--OUTPUT:
--PL/SQL procedure successfully completed.
--
--ID  | NAME | CATE |             AUCTION STAR TIME            |    AUCTION END TIME|      CURRENT BID |   STATUS
--101 | DATABASES BOOK | BOOK | 03-NOV-16 11.00.00.000000 AM | 12-NOV-16 12.00.00.000000 PM | 1501 | 1
