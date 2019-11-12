-- view

CREATE TABLE view (
	id NUMERIC(19) PRIMARY KEY,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(4096) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE view
    ADD CONSTRAINT view_code_unique UNIQUE (code);
CREATE SEQUENCE view_seq OWNED BY view.id;

-- view_state_value

CREATE TABLE view_state_value (
	view_id NUMERIC(19) NOT NULL,
	value_id NUMERIC(19) NOT NULL
);
ALTER TABLE view_state_value
    ADD CONSTRAINT vsv_view_fk FOREIGN KEY (view_id) REFERENCES view (id);
ALTER TABLE view_state_value
    ADD CONSTRAINT vsv_state_value_fk FOREIGN KEY (value_id) REFERENCES state_value (id);

-- view_category_value

CREATE TABLE view_category_value (
	view_id NUMERIC(19) NOT NULL,
	value_id NUMERIC(19) NOT NULL
);

ALTER TABLE view_category_value
    ADD CONSTRAINT vcv_view_fk FOREIGN KEY (view_id) REFERENCES view (id);
ALTER TABLE view_category_value
    ADD CONSTRAINT vcv_category_value_fk FOREIGN KEY (value_id) REFERENCES category_value (id);

-- view_role

CREATE TABLE view_role (
	view_id NUMERIC(19) NOT NULL,
	role_id NUMERIC(19) NOT NULL
);
ALTER TABLE view_role
    ADD CONSTRAINT vr_view_fk FOREIGN KEY (view_id) REFERENCES view (id);
ALTER TABLE view_role
    ADD CONSTRAINT vr_role_fk FOREIGN KEY (role_id) REFERENCES role (id);


















