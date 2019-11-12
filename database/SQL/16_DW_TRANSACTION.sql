-- transaction

CREATE TABLE transaction (
	id NUMERIC(19) PRIMARY KEY,
	parent_id NUMERIC(19),
	operation_id NUMERIC(19) NOT NULL,
	user_id NUMERIC(19) NOT NULL,
	date DATE NOT NULL,
	data BYTEA NOT NULL,
	active BOOL NOT NULL
);
CREATE SEQUENCE transaction_seq OWNED BY transaction.id;
ALTER TABLE transaction
    ADD CONSTRAINT transaction_parent_fk FOREIGN KEY (parent_id) REFERENCES transaction (id);
ALTER TABLE transaction
    ADD CONSTRAINT transaction_operation_fk FOREIGN KEY (operation_id) REFERENCES operation (id);
ALTER TABLE transaction
    ADD CONSTRAINT transaction_user_fk FOREIGN KEY (user_id) REFERENCES users (id);

-- transaction_state_value

CREATE TABLE transaction_state_value (
	transaction_id NUMERIC(19) NOT NULL,
	value_id NUMERIC(19) NOT NULL
);
ALTER TABLE transaction_state_value
    ADD CONSTRAINT tsv_transaction_fk FOREIGN KEY (transaction_id) REFERENCES transaction (id);
ALTER TABLE transaction_state_value
    ADD CONSTRAINT tsv_state_value_fk FOREIGN KEY (value_id) REFERENCES state_value (id);

-- transaction_category_value

CREATE TABLE transaction_category_value (
	transaction_id NUMERIC(19) NOT NULL,
	value_id NUMERIC(19) NOT NULL
);
ALTER TABLE transaction_category_value
    ADD CONSTRAINT tcv_transaction_fk FOREIGN KEY (transaction_id) REFERENCES transaction (id);
ALTER TABLE transaction_category_value
    ADD CONSTRAINT tcv_category_value_fk FOREIGN KEY (value_id) REFERENCES category_value (id);























