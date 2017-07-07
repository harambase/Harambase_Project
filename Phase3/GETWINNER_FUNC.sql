create or replace Function GETWINNER_FUNC(item int) Return int
  AS
    winner int := 0;
    numMax int := 0;
    Begin
        Select count(UserID) Into numMax From Harambase_BID 
        Where MaxBidLimit = (SELECT Max(X.MaxBidLimit) 
                             FROM Harambase_BID X 
                             WHERE X.ItemID = item) AND ItemID = item;
        IF (numMax > 1) THEN
          Select B.UserID Into winner From Harambase_BID B
          Where B.MaxBidLimit = (SELECT Max(X.MaxBidLimit) 
                               FROM Harambase_BID X 
                               WHERE X.ItemID = item) AND ItemID = item         
            AND B.BIDDINGTIME < (SELECT Y.BIDDINGTIME
                               FROM HARAMBASE_BID Y
                               WHERE Y.MAXBIDLIMIT = MAXBIDLIMIT AND Y.USERID <> B.USERID AND Y.ItemID = item);
        ELSIF(numMax=0) THEN
          winner := 0;
        ELSE
          Select UserID Into winner From Harambase_BID 
          Where MaxBidLimit = (SELECT Max(X.MaxBidLimit) 
                               FROM Harambase_BID X 
                               WHERE X.ItemID = item) AND ItemID = item;
        End If;
        Return winner;
        
  END GETWINNER_FUNC;