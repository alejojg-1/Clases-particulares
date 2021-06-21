update agenda
set usuario_id = :idUsuario,
	curso_id = :idCurso,
	fecha_inicio =:fechaInicio,
	fecha_fin =:fechaFin,
	costo_total=:costoTotal
where id = :id

