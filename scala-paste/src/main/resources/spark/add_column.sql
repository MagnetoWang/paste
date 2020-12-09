select
main_table.employee_name,main_table.department,main_table.state,main_table.salary,main_table.age,main_table.bonus,main_table.bonus,
case
when main_table.bonus <= percentile_0 then 1
when main_table.bonus > percentile_0 and main_table.bonus <= percentile_1 then 1
when main_table.bonus > percentile_1 and main_table.bonus <= percentile_2 then 2
when main_table.bonus > percentile_2 and main_table.bonus <= percentile_3 then 3
when main_table.bonus > percentile_3 and main_table.bonus <= percentile_4 then 4
end as tag_wzx
from main_table left join info_table on main_table.employee_name = info_table.employee_name and main_table.department = info_table.department;