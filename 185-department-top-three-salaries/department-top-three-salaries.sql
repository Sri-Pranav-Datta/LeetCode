# Write your MySQL query statement below
with ranked as (
    select d.name as department, e.name as employee, e.salary,
    dense_rank() over(partition by d.name order by e.salary desc) as rnk
    from department d join employee e
    on d.id = e.departmentid
)
select department, employee, salary 
from ranked
where rnk <=3