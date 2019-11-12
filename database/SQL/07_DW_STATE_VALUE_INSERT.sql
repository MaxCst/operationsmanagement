-- "CollectionStatus" values:

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	1,
	'FulfilledCollection',
	'Fulfilled Collection',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	1,
	'CollectionInProgress',
	'Collection In Progress',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	1,
	'DefaultedCollection',
	'Defaulted Collection',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	1,
	'CancelledCollection',
	'Cancelled Collection',
	true
);

-- "PaymentStatus" values:

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	2,
	'FulfilledPayment',
	'Fulfilled Payment',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	2,
	'PaymentInProgress',
	'Payment In Progress',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	2,
	'PartialPayment',
	'Partial Payment',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	2,
	'PendingPayment',
	'Pending Payment',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	2,
	'CancelledPayment',
	'Cancelled Payment',
	true
);

-- "AvailabilityStatus" values:

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	3,
	'Available',
	'Available',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	3,
	'AvailableWithErrors',
	'Available With Errors',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	3,
	'AvailableWithRestrictions',
	'Available With Restrictions',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	3,
	'UnknownAvailablity',
	'Unknown Availablity',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	3,
	'Unavailable',
	'Unavailable',
	true
);

-- "EnableStatus" values:

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	4,
	'Enabled',
	'Enabled',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	4,
	'Disabled',
	'Disabled',
	true
);

-- "ViewGenerationStatus" values:

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	5,
	'ViewGenerationPending',
	'View Generation Pending',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	5,
	'ViewGenerationProcessed',
	'View Generation Processed',
	true
);

-- "Connect4MatchStatus" values:

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	6,
	'Connect4NotStartedYet',
	'Not Started Yet',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	6,
	'Connect4InProgress',
	'In Progress',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	6,
	'Connect4Draw',
	'Draw',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	6,
	'Connect4Player1Won',
	'Player 1 Won',
	true
);

INSERT INTO state_value (
	id,
	state_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('state_value_seq'),
	6,
	'Connect4Player2Won',
	'Player 2 Won',
	true
);




































































































































