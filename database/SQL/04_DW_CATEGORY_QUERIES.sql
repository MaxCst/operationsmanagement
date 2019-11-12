SELECT 
	a.code AS CATEGORIA_CODE, 
	a.name AS CATEGORIA_NAME, 
	b.code AS VALOR_DE_CATEGORIA_CODE,
	b.name AS VALOR_DE_CATEGORIA_NAME	
FROM 
	category a			                      -- A 
	INNER JOIN 								  -- x
	category_value b ON(a.id=b.category_id)   -- B
ORDER BY 
	a.code,
	b.code;



