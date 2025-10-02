# Write your MySQL query statement below
select m.id, 
case 
when m.id %2 = 0 then (select c1.student from seat c1 where c1.id = m.id - 1)
when m.id %2 = 1 and id != (select count(*) from seat) then (select c2.student from seat c2 where c2.id = m.id + 1)
else m.student
end as student
from seat m