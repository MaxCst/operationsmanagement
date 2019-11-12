SELECT
	a.id   						AS TRANSACCION_ID,
	a.parent_id   				AS PARENT_ID,
	a.DATE 						AS FECHA,
	b.id 						AS OPERACION_ID,
	b.CODE 						AS OPERACION,
	c.CODE 						AS USUARIO,
	encode(a.DATA, 'escape') 	AS DATOS
FROM
	transaction a INNER JOIN
	operation b ON(a.operation_id=b.id) INNER JOIN
	users c ON(a.user_id=c.id)
ORDER BY
	a.id;

