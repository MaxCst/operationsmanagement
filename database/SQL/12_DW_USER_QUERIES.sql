SELECT
	a.name AS "NOMBRE Y APELLIDO",
	a.email AS "CORREO ELECTRONICO",
	c.name AS "PERFIL"
FROM 
	users a 							-- A
	INNER JOIN 							-- x
	users_role b ON(a.id=b.user_id)  	-- B
	INNER JOIN 							-- x
	role c ON(b.role_id=c.id)			-- C
ORDER BY 
	a.name;



