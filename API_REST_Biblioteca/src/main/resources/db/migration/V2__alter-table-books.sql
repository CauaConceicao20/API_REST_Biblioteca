ALTER TABLE books
ADD activate TINYINT;

UPDATE books set activate = 1;