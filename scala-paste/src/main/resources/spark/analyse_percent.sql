select
employee_name,
department,
count(employee_name,department) as key_cnt,
min(bonus) as min_bonus,
max(bonus) as max_bonus,
mean(bonus) as mean_bonus,
sum(bonus) as sum_bonus,
percentile_approx(bonus, 0.0) as percentile_0,
percentile_approx(bonus, 0.25) as percentile_1,
percentile_approx(bonus, 0.5) as percentile_2,
percentile_approx(bonus, 0.75) as percentile_3,
percentile_approx(bonus, 1) as percentile_4
from
main_table
group by employee_name , department;


select * from t1
union
select *, 1 from t1 where t1.x = 2 or t1.x = 3 or t1.x = 4
union
select *, 2 from t1 where t1.x = 3 or t1.x = 4
union
select *, 3 from t1 where t1.x = 4

