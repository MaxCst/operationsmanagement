-- state

CREATE TABLE state (
	id NUMERIC(19) PRIMARY KEY,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(4096) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE state
    ADD CONSTRAINT sta_code_unique UNIQUE (code);
CREATE SEQUENCE state_seq OWNED BY state.id;

-- state_value

CREATE TABLE state_value (
	id NUMERIC(19) PRIMARY KEY,
	parent_id NUMERIC(19),
	state_id NUMERIC(19) NOT NULL,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(4096) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE state_value
    ADD CONSTRAINT state_value_parent_fk FOREIGN KEY (parent_id) REFERENCES state_value (id);
ALTER TABLE state_value
    ADD CONSTRAINT state_fk FOREIGN KEY (state_id) REFERENCES state (id);
ALTER TABLE state_value
    ADD CONSTRAINT staval_code_unique UNIQUE (code);
CREATE SEQUENCE state_value_seq OWNED BY state_value.id;


































