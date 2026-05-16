# Write your MySQL query statement below
SELECT DEPT.name AS Department,EMP.name AS Employee,EMP.salary AS Salary 
FROM Employee EMP JOIN Department DEPT ON EMP.departmentId = DEPT.id
WHERE (EMP.departmentId, EMP.salary) IN (
    SELECT departmentId, MAX(salary) FROM Employee GROUP BY departmentId
);