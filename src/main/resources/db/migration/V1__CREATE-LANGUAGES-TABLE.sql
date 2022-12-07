DROP TABLE IF EXISTS TBL_EMPLOYEES;
CREATE TABLE languages(
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          welcomeMsg VARCHAR(100) NOT NULL ,
                          code VARCHAR(3)

);