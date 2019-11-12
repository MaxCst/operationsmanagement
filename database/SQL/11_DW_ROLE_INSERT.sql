-- role

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Adm',
	'Administrador',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Usr',
	'Usuario',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Opr',
	'Operator',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'SysAdm',
	'System Administrator',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Hlp',
	'Help',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Sup',
	'Supervisor',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Dba',
	'Database Administrator',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Dev',
	'Developer',
	true
);

INSERT INTO role (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('role_seq'),
	'Mgr',
	'Manager',
	true
);

-- users_role

INSERT INTO users_role (
	user_id,
	role_id
) 
VALUES
(
	1,
	1
);

INSERT INTO users_role (
	user_id,
	role_id
) 
VALUES
(
	2,
	1
);

INSERT INTO users_role (
	user_id,
	role_id
) 
VALUES
(
	3,
	2
);
































































































