# Write your MySQL query statement below

# apply left join 

select p.product_name, s.year, s.price
from Sales s
join Product p
where s.product_id = p.product_id

