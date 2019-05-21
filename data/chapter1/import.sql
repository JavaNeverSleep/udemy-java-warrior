.separator "\t"
CREATE TABLE IF NOT EXISTS users (id VARCHAR PRIMARY KEY NOT NULL, name VARCHAR NOT NULL);
DELETE FROM users;
.import "users.txt" users
.exit