# https://www.nowcoder.com/practice/3a303a39cc40489b99a7e1867e6507c5?tpId=82&tqId=29780&tPage=1&rp=&ru=/ta/sql&qru=/ta/sql/question-ranking

# method1
select c.name, count(f.film_id)
from film f, film_category fc, (
    select category_id
    from film_category
    group by category_id
    having count(*) >= 5
) as cc, category c
where f.description like '%robot%'
    and f.film_id = fc.film_id
    and fc.category_id = cc.category_id
    and cc.category_id = c.category_id;

--- 

# method2
select c.name, count(f.film_id)
from film f, film_category fc, category c
where f.description like '%robot%'
    and f.film_id = fc.film_id
    and fc.category_id = c.category_id
    and fc.category_id in (
        select category_id
        from film_category
        group by category_id
        having count(film_id) >= 5
    );