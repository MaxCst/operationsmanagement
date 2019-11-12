-- operation

INSERT INTO operation (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('operation_seq'),
	'PaymentOperation',
	'Payment Operation',
	true
);

INSERT INTO operation (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('operation_seq'),
	'CollectOperation',
	'Collect Operation',
	true
);

INSERT INTO operation (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('operation_seq'),
	'BillOperation',
	'Bill Operation',
	true
);

INSERT INTO operation (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('operation_seq'),
	'Connect4MatchOperation',
	'Connect 4 Match Operation',
	true
);

INSERT INTO operation (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('operation_seq'),
	'Connect4InsertCoinOperation',
	'Connect 4 Insert Coin Operation',
	true
);
























































