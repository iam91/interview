# https://www.nowcoder.com/practice/fc7344ece7294b9e98401826b94c6ea5?tpId=82&tqId=29773&tPage=1&rp=&ru=/ta/sql&qru=/ta/sql/question-ranking

select e.emp_no, (s2.salary - s1.salary) as growth
from employees e, salaries s1, salaries s2
where e.emp_no = s1.emp_no
    and e.emp_no = s2.emp_no
    and e.hire_date = s1.from_date
    and s2.to_date = '9999-01-01'
order by growth;