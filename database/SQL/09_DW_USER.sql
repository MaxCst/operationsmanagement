-- users

CREATE TABLE users (
	id NUMERIC(19) PRIMARY KEY,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(128) NOT NULL,
	email VARCHAR(128) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE users
    ADD CONSTRAINT usr_code_unique UNIQUE (code);
CREATE SEQUENCE user_seq OWNED BY users.id;

-- role

CREATE TABLE role (
	id NUMERIC(19) PRIMARY KEY,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(4096) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE role
    ADD CONSTRAINT role_code_unique UNIQUE (code);
CREATE SEQUENCE role_seq OWNED BY role.id;

-- users_role

CREATE TABLE users_role (
	user_id NUMERIC(19) NOT NULL,
	role_id NUMERIC(19) NOT NULL
);
ALTER TABLE users_role
    ADD CONSTRAINT ur_user_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_role
    ADD CONSTRAINT ur_role_fk FOREIGN KEY (role_id) REFERENCES role (id);




























