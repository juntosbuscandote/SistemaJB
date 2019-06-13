/* MTOLEDO catalogo de meses*/
insert into t_catalogue_det values(101,'1','ENERO','','',true,19);
insert into t_catalogue_det values(102,'2','FEBRERO','','',true,19);
insert into t_catalogue_det values(103,'3','MARZO','','',true,19);
insert into t_catalogue_det values(104,'4','ABRIL','','',true,19);
insert into t_catalogue_det values(105,'5','MAYO','','',true,19);
insert into t_catalogue_det values(106,'6','JUNIO','','',true,19);
insert into t_catalogue_det values(107,'7','JULIO','','',true,19);
insert into t_catalogue_det values(108,'8','AGOSTO','','',true,19);
insert into t_catalogue_det values(109,'9','SEPTIEMBRE','','',true,19);
insert into t_catalogue_det values(110,'10','OCTUBRE','','',true,19);
insert into t_catalogue_det values(111,'11','NOVIEMBRE','','',true,19);
insert into t_catalogue_det values(112,'12','DICIEMBRE','','',true,19);
/*Amarre por documento*/
update t_catalogue_det set catd_vshortname='1' where cata_bident=19