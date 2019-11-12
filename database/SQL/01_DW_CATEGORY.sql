-- category

CREATE TABLE category (
	id NUMERIC(19) PRIMARY KEY,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(4096) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE category
    ADD CONSTRAINT cat_code_unique UNIQUE (code);
CREATE SEQUENCE category_seq OWNED BY category.id;

-- category_value

CREATE TABLE category_value (
	id NUMERIC(19) PRIMARY KEY,
	category_id NUMERIC(19) NOT NULL,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(4096) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE category_value
    ADD CONSTRAINT category_fk FOREIGN KEY (category_id) REFERENCES category (id);
ALTER TABLE category_value
    ADD CONSTRAINT catval_code_unique UNIQUE (code);
CREATE SEQUENCE category_value_seq OWNED BY category_value.id;





