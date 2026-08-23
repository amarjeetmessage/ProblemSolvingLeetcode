# Write your MySQL query statement below
#avg selling price 2 place rounded for each product (group by), if not any sold (0)
select p.product_id, IFNULL(ROUND(SUM(p.price*u.units)/ SUM(u.units),2),0) as average_price
from Prices p
left join UnitsSold u
on p.product_id = u.product_id
and u.purchase_date >= p.start_date
and u.purchase_date <= p.end_date
group by p.product_id