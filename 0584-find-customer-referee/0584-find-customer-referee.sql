# Write your MySQL query statement below
select name 
from Customer
where referee_id != 2 OR referee_id is null              
# we can not check like referee_id = null