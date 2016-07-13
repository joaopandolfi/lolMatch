/*
* Insercao titulo
*/
INSERT INTO titulo (idtitulo,nome,valor)
VALUES	(1 ,'Safadao' ,9000 ),
 		(2 ,'Matador de noob' ,5000 ),
 		(3 ,'Passa nois Paulim' ,5000 ),
	   	(4 ,'Pela égua' ,4000 );

/*
* Insercao itens
*/
INSERT INTO itens (iditens,nome,efeito,valor)
VALUES	(1 ,'Convites' ,2 ,200 ),
 		(2 ,'Convites promoção 2x' ,4 ,200 ),
	   	(3 ,'Convites promoção 4x' ,8 ,200 );


/*
* Insercao de usuario
*/

SELECT combo_insert('brtt','Teste123','t@1.com','123');
SELECT combo_insert('seu madruga','RobinDoTeste','seu@madruga.com','123');

/*
* Insercao lolaccount

INSERT INTO lolaccount (idlolaccount,idingame,avaliacao,idTitulo)
VALUES	(1 ,'BIXAO22' ,5 ,1 ),
 		(2 ,'SELOROTIO' ,0 ,0 ),
	   	(3 ,'MATEI_E_FUGI' ,1 ,2 );
*/

/*
* Insercao usuario

INSERT INTO usuario (idusuario,lolaccount_idlolaccount,nome,email,senha)
VALUES (1 ,1 ,'Joseilson' ,'joseilsonsafadao@hotmail.com' ,'papainoelnaotempai' ),
	   (2 ,2 ,'Jaspinto' ,'jaspintomatador@gmail.com' ,'hemanemelhorquejaspion' ),
	   (3 ,3 ,'Jeremias' ,'jeremiasmuitolouco@hotmail.com' ,'eutenhoumpicles' );
*/

/*
* Insercao carteira

INSERT INTO carteira (idcarteira,valor,usuario_idusuario)
VALUES (1 ,200 ,1 ),
	   (2 ,150 ,2 ),
	   (3 ,500 ,3 );
*/

/*
* Insercao itenscomprados

INSERT INTO itenscomprados (iditenscomprados,quantidade,carteira_idcarteira,itens_iditens)
VALUES	(1 ,1 ,1 ,1 ),
 		(2 ,1 ,2 ,2 ),
	   	(3 ,1 ,2 ,2 );
*/

/*
* Insercao tituloscomprados

INSERT INTO tituloscomprados (idtituloscomprados,carteira_idcarteira,titulo_idtitulo)
VALUES	(1 ,1,1 ),
 		(2 ,3,2 ),
	   	(3 ,3,3);
*/

/*
* Insercao chat

INSERT INTO chat (idmsg,message,read,usuario_idusuario_sender,usuario_idusuario_receiver)
VALUES	(1 ,'bacon é mt bom' ,1 ,1 ,2 ),
 		(2 ,'quer jogar com eu tio?' ,0 ,1 ,2 ),
	   	(3 ,'sou bronze, me sobe de elo?' ,0 ,2 ,1 );
*/
/*
* Insercao contratos

INSERT INTO contratos (idcontratos,valor,data,usuario_idusuario_contratante,usuario_idusuario_contratado)
VALUES	(1 ,2 ,'2016-7-04' ,1 ,2 ),
 		(2 ,100 ,'2016-7-04' ,3 ,2 ),
	   	(3 ,30 ,'2016-7-04' ,3 ,2 );
*/
/*
* Insercao matchs

INSERT INTO matchs (idmatchs,data,verifyed,usuario_idusuario_convidado,usuario_idusuario_convidante)
VALUES	(1 ,'2016-7-04' ,0 ,1 ,2 ),
 		(2 ,'2016-7-04' ,0 ,1 ,3 ),
	   	(3 ,'2016-7-04' ,0 ,1 ,3 );
*/
