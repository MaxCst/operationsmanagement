-- states

INSERT INTO state (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_seq'),
	'CollectionStatus',
	'Collection Status',
	true
);

INSERT INTO state (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_seq'),
	'PaymentStatus',
	'Payment Status',
	true
);

INSERT INTO state (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_seq'),
	'AvailabilityStatus',
	'Availability Status',
	true
);

INSERT INTO state (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_seq'),
	'EnableStatus',
	'Enable Status',
	true
);

INSERT INTO state (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_seq'),
	'ViewGenerationStatus',
	'View Generation Status',
	true
);

INSERT INTO state (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_seq'),
	'Connect4MatchStatus',
	'Connect 4 Match Status',
	true
);










































