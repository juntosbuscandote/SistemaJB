/*Eliminar el unique*/
ALTER TABLE t_employee DROP CONSTRAINT t_employee_uq
/*Cambiar tipo de dato al store_bstate*/
ALTER TABLE t_storehouse ALTER COLUMN store_bstate TYPE character varying(2)
/*mtoledo 18/02/2018 Relación con de usuarios y empleados, obteniendo la empresa relacionada*/
ALTER TABLE t_employee ADD user_vuser varchar(50);
COMMENT ON COLUMN t_employee.user_vuser 
     IS 'Relación con de usuarios'
