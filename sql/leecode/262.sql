select t.Request_at Day, 
    round(sum(
        case when t.Status <> 'completed' 
        then 1 
        else 0 
        end) / count(*), 2) 'Cancellation Rate'
from Trips t
left join Users u on t.Client_id = u.Users_id
where u.Banned = 'No' and t.Request_at between '2013-10-01' and '2013-10-03'
group by t.Request_at;