-- operation

CREATE TABLE operation (
	id NUMERIC(19) PRIMARY KEY,
	code VARCHAR(64) NOT NULL,
	name VARCHAR(4096) NOT NULL,
	active BOOL NOT NULL
);
ALTER TABLE operation
    ADD CONSTRAINT ope_code_unique UNIQUE (code);
CREATE SEQUENCE operation_seq OWNED BY operation.id;

-- operation_state_value

CREATE TABLE operation_state_value (
	operation_id NUMERIC(19) NOT NULL,
	value_id NUMERIC(19) NOT NULL
);
ALTER TABLE operation_state_value
    ADD CONSTRAINT osv_operation_fk FOREIGN KEY (operation_id) REFERENCES operation (id);
ALTER TABLE operation_state_value
    ADD CONSTRAINT osv_state_value_fk FOREIGN KEY (value_id) REFERENCES state_value (id);

-- operation_category_value

CREATE TABLE operation_category_value (
	operation_id NUMERIC(19) NOT NULL,
	value_id NUMERIC(19) NOT NULL
);
ALTER TABLE operation_category_value
    ADD CONSTRAINT ocv_operation_fk FOREIGN KEY (operation_id) REFERENCES operation (id);
ALTER TABLE operation_category_value
    ADD CONSTRAINT ocv_category_value_fk FOREIGN KEY (value_id) REFERENCES category_value (id);






























