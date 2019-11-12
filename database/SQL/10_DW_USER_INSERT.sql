-- users

INSERT INTO users (
	id,
	code,
	email,
	name,
	active
) 
VALUES
(
	nextval('user_seq'),
	'mariana.sauda',
	'mariana.sauda@accenture.com',
	'Mariana Sauda',
	true
);

INSERT INTO users (
	id,
	code,
	email,
	name,
	active
) 
VALUES
(
	nextval('user_seq'),
	'camila.rocio.diaz',
	'camila.rocio.diaz@accenture.com',
	'Camila Diaz',
	true
);

INSERT INTO users (
	id,
	code,
	email,
	name,
	active
) 
VALUES
(
	nextval('user_seq'),
	'maximo.j.castillo',
	'maximo.j.castillo@gmail.com',
	'Máximo Javier Castillo',
	true
);














