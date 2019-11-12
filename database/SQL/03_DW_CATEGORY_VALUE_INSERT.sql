-- "ColorCategory" values:

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	1,
	'BlueColor',
	'Blue',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	1,
	'YellowColor',
	'Yellow',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	1,
	'RedColor',
	'Red',
	true
);

-- "ViewFormatCategory" values:

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	2,
	'ViewFormatPDF',
	'View Format PDF',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	2,
	'ViewFormatCSV',
	'View Format CSV',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	2,
	'ViewFormatTXT',
	'View Format TXT',
	true
);

-- "PaymentMethodCategory" values:

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	3,
	'CashPaymentMethod',
	'Cash Payment Method',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	3,
	'DebitPaymentMethod',
	'Debit Payment Method',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	3,
	'CreditPaymentMethod',
	'Credit Payment Method',
	true
);

-- "ViewTypeCategory" values:

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	4,
	'ReportView',
	'Report View',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	4,
	'QueryView',
	'Query View',
	true
);

INSERT INTO category_value (
	id,
	category_id,
	code,
	name,
	active
) 
VALUES
(
	nextval('category_value_seq'),
	4,
	'ExportView',
	'Export View',
	true
);
























































