# Write your MySQL query statement below

# PERCENTAGE = NO OF REQUIRED / TOTAL COUNT * 100

select contest_id, ROUND((COUNT(DISTINCT user_id)) * 100/(SELECT COUNT( user_id)
FROM Users), 2)
AS percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id