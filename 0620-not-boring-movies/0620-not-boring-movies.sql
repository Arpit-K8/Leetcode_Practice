# Write your MySQL query statement below
select * from Cinema where MOD(id,2)=1 and description!='boring' order by rating desc;
-- i can do this one also: select * from Cinema where id%2=1 and description!='boring' order by rating desc;