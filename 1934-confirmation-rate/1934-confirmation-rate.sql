# Write your MySQL query statement below
SELECT s.user_id, ROUND(AVG(IF(c.action="confirmed",1,0)),2) AS confirmation_rate
FROM Signups AS s LEFT JOIN Confirmations AS c ON s.user_id = c.user_id
GROUP BY s.user_id;

-- Converts each row to 1 if (confirmed) keyword found or 0 (not confirmed) using `IF()`.
-- `AVG()` calculates the fraction of confirmed records.
-- `ROUND(..., 2)` formats the result to 2 decimal places.
--  Overall, it returns the  percentage of confirmed actions .
