# Write your MySQL query statement below
select distinct l1.num as ConsecutiveNums
from logs l1 join logs l2 join logs l3
on l2.id = l1.id+1 and l3.id = l2.id+1
where l1.num = l2.num and l2.num = l3.num