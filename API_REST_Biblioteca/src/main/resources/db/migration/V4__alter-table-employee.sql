ALTER TABLE employee
ADD activate TINYINT;

UPDATE employee set activate = 1;