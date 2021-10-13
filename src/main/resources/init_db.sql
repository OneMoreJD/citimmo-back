userCREATE DATABASE citibase;
CREATE USER 'citiboss'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'c1t1b0$$';
GRANT ALL ON citibase.* TO  'citiboss'@'localhost';
FLUSH PRIVILEGES ;
