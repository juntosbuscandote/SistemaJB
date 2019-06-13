CREATE TABLE public.t_repository(
	repo_bident bigint,
	offi_bident bigint,
	repo_vcode character varying (5),
	repo_vname character varying (100),
	repo_vshortname character varying (50),
	repo_vphone character varying (50),
	repo_vmandated character varying (250),
	repo_stock numeric DEFAULT 0,
	repo_tregistration_date timestamp with time zone,
	repo_tdate_update timestamp with time zone,
	repo_buser_register character varying (45),
	repo_buser_modify character varying (45),
	CONSTRAINT t_repo_pk PRIMARY KEY (repo_bident)
);
COMMENT ON COLUMN public.t_repository.repo_bident IS 'codigo identificador de almacen';
COMMENT ON COLUMN public.t_repository.offi_bident IS 'codigo identificador de sucursal';
COMMENT ON COLUMN public.t_repository.repo_vcode IS 'codigo de almacen';
COMMENT ON COLUMN public.t_repository.repo_vname IS 'nombre de almacen';
COMMENT ON COLUMN public.t_repository.repo_vshortname IS 'nombre corto de almacen';
COMMENT ON COLUMN public.t_repository.repo_vphone IS 'telefono de almacen';
COMMENT ON COLUMN public.t_repository.repo_vmandated IS 'nombre completo del encargado del almacen';
COMMENT ON COLUMN public.t_repository.repo_tregistration_date IS 'fecha de registro';
COMMENT ON COLUMN public.t_repository.repo_tdate_update IS 'fecha de ultima actualización';
COMMENT ON COLUMN public.t_repository.repo_buser_register IS 'usuario que registro el almacen';
COMMENT ON COLUMN public.t_repository.repo_buser_modify IS 'ultimo usuario que modifico el almacen';



ALTER TABLE public.t_repository ADD CONSTRAINT t_branch_office_fk FOREIGN KEY (offi_bident)
REFERENCES public.t_branch_office (offi_bident) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE SEQUENCE public.sec_t_repository
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999
	START WITH 1
	CACHE 1
	CYCLE
	OWNED BY NONE;
	
	
ALTER TABLE t_branch_office ADD offi_vaddress character varying(250);
COMMENT ON COLUMN t_branch_office.offi_vaddress 
     IS 'Direccion de la sucursal';

ALTER TABLE t_branch_office ADD offi_vphone character varying(15);
COMMENT ON COLUMN t_branch_office.offi_vphone 
     IS 'Telefono de la sucursal';
	 
ALTER TABLE t_branch_office ADD offi_vcode character varying(5);
COMMENT ON COLUMN t_branch_office.offi_vcode 
     IS 'Codigo de la sucursal';
	 
ALTER TABLE t_branch_office  ALTER COLUMN offi_buser_modify TYPE character varying (45);
ALTER TABLE t_branch_office  ALTER COLUMN offi_buser_create TYPE character varying (45);

ALTER TABLE t_branch_office ALTER COLUMN offi_vshortname TYPE varchar(100);
