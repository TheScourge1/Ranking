insert into player values (1,'5001','Koen','Tourné','M',curdate(),curdate());
insert into tournament VALUES ( 1,'testToernooi','T','20160901','F750AAD0-FB8C-4EFB-8A70-100EB0E153B0',curdate(),curdate() );
insert into event values ( 1,1, 'reeks 1',1,'2EE16507-FBD1-4124-A79E-0E90BD7902E4&event=1',curdate(),curdate() );
insert into event values ( 2,1, 'reeks 4',4,'2EE16507-FBD1-4124-A79E-0E90BD7902E4&event=4',curdate(),curdate() );
insert into event values ( 3,1, 'reeks 2',2,'2EE16507-FBD1-4124-A79E-0E90BD7902E4&event=2',curdate(),curdate() );
insert into event values ( 4,1, 'reeks 3',3,'2EE16507-FBD1-4124-A79E-0E90BD7902E4&event=3',curdate(),curdate() );
insert into draw values ( 1,3,'event 3',1,'KO',curdate(),curdate() );
insert into draw values ( 2,1,'event 1',1,'POULE',curdate(),curdate() );
insert into draw values ( 3,2,'event 2',1,'POULE',curdate(),curdate() );