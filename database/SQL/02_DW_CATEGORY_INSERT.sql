-- category

INSERT INTO category (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_seq'),
	'ColorCategory',
	'Colors Category',
	true
);

INSERT INTO category (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_seq'),
	'ViewFormatCategory',
	'View Format Category',
	true
);

INSERT INTO category (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_seq'),
	'PaymentMethodCategory',
	'Payment Method Category',
	true
);

INSERT INTO category (
	id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_seq'),
	'ViewTypeCategory',
	'View Type Category',
	true
);






