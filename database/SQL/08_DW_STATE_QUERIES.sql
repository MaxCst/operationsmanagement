SELECT 
	a.code AS "CODIGO DE ESTADO", 
	a.name AS " DESCRIPCION DE ESTADO", 
	b.code  AS "CODIGO DE OPCION DE ESTADO",
	b.name  AS "CODIGO DE DESCRIPCION DE ESTADO"	
FROM 
	state a INNER JOIN 
	state_value b ON(a.id=b.state_id)
ORDER BY 
	a.name,
	b.name;




