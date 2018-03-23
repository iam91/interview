# https://www.nowcoder.com/practice/c1472daba75d4635b7f8540b837cc719?tpId=82&tqId=29770&tPage=1&rp=&ru=/ta/sql&qru=/ta/sql/question-ranking

select e.emp_no, s.salary, e.last_name, e.first_name
from employees e, salaries s
where e.emp_no = s.emp_no
    and s.to_date = '9999-01-01'
    and (
        select count(distinct s2.salary)
        from salaries s2
        where s2.to_date = '9999-01-01'
            and s2.salary > s.salary
    ) == 1;