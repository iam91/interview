# https://www.nowcoder.com/practice/4bcb6a7d3e39423291d2f7bdbbff87f8?tpId=82&tqId=29778&tPage=1&rp=&ru=/ta/sql&qru=/ta/sql/question-ranking

select de.dept_no, d.dept_name, t.title, count(de.emp_no)
from dept_emp de, departments d, titles t
where de.to_date = '9999-01-01'
    and t.to_date = '9999-01-01'
    and de.dept_no = d.dept_no
    and de.emp_no = t.emp_no
group by de.dept_no, t.title;