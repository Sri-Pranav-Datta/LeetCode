# Write your MySQL query statement below
select q1.person_name 
from queue q1
join queue q2
on q1.turn >= q2.turn
group by q1.turn
having sum(q2.weight) <= 1000
limit 1