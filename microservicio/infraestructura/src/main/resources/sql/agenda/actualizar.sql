update agenda
set usuario_id = :usuario_id,
	curso_id = :curso_id,
	fecha_inicio =:fecha_fin,
	costo_total=:costo_total
where id = :id

