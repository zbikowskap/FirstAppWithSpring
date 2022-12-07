CREATE TABLE todos (
                           id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           text VARCHAR(100) NOT NULL ,
                           done BIT
);
INSERT INTO todos (text, done) VALUES ('Done todo',1);
INSERT INTO todos (text, done) VALUES ('Undone todo',0);