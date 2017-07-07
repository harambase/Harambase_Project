create or replace Function Harambase_getPrice_Func(iID int) Return int
  AS
    price int := 0;
    numRows int := 0;
    Begin
        Select count(*) Into numRows From Harambase_BID B Where B.ItemID = iID;
        If (numRows = 0) Then
            RETURN 0;
        ElsIf (numRows = 1) Then
            Select I.StartPrice + 1 Into price From Harambase_Item I Where I.ItemID = iID;
        Else
          Select B.MaxBidLimit + 1 Into price From Harambase_BID B Where B.ItemID = iID AND rownum = 1 Order By B.MaxBidLimit;
        End If;       
        Return price;
    End;