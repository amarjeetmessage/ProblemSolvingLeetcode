# Write your MySQL query statement below
SELECT name FROM Customer
WHERE referee_id <> 2 OR  referee_id IS NULL;
-- WHERE referee_id != 2 OR  referee_id IS NULL;



-- We want to return customers who are:

-- Referred by someone whose id != 2 ✅

-- NOT referred by anyone (means referee_id IS NULL) ✅