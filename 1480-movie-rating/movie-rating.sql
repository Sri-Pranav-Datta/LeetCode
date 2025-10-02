# Write your MySQL query statement below
(
select u.name as results
from users u join movierating m
on u.user_id = m.user_id
group by u.user_id
order by count(m.user_id) desc, u.name
limit 1
)
union all
(
select m.title as results
from movies m join movierating r
on m.movie_id = r.movie_id
where r.created_at between '2020-02-01' and '2020-02-29'
group by m.movie_id
order by avg(r.rating) desc, m.title
limit 1
)