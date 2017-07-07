create or replace function get_status_func(iid int) return int AS
  STATUS int := 0;
  endTime date := TO_TIMESTAMP('01/JAN/1900 12:00:00','DD/MM/YYYY HH:MI:SS');
  startTime date := TO_TIMESTAMP('01/JAN/1900 11:00:00','DD/MM/YYYY HH:MI:SS');
begin
      Select I.AuctionEndTime Into endTime From Harambase_Item I Where I.ItemID = iid;
      Select I.AuctionStartTime Into startTime From Harambase_Item I Where I.ItemID = iid;
      
      If (endTime < CURRENT_TIMESTAMP) Then
          STATUS := 1; --SOLD
      ELSE
          STATUS := 0; --ON AUCTION
      End If;
      
      IF (startTime > CURRENT_TIMESTAMP) THEN
          STATUS := -1; --NOT ON AUCTION
      END IF;
            
      RETURN STATUS;
      
end get_status_func;