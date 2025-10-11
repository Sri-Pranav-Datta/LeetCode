# Write your MySQL query statement below
select requester_id as id, count(requester_id) as num
from ((select * from  requestaccepted) 
union (select accepter_id as requester_id, requester_id as accepter_id, accept_date from requestaccepted)) as newtable
group by requester_id
order by num desc
limit 1


