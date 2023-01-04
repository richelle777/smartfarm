drop database if exists bdsmartfarmer;

create database bdsmartfarmer;
use bdsmartfarmer;

drop table if exists Customer;
CREATE TABLE Customer (
    id_client VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mdp VARCHAR(255) NOT NULL,
    telephone BIGINT NOT NULL
);

drop table if exists Categorie;
CREATE TABLE Categorie (
    id_categorie VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    descript VARCHAR(255)
);

drop table if exists Image;
CREATE TABLE Image (
    id_image VARCHAR(50) PRIMARY KEY,
    url VARCHAR(255),
    url_thumbnail VARCHAR(255)
);

drop table if exists Localisation;
CREATE TABLE Localisation (
    id_localisation VARCHAR(50) PRIMARY KEY,
    residence VARCHAR(255),
    ville VARCHAR(255) DEFAULT 'Yaoundé',
    pays VARCHAR(255) DEFAULT 'Cameroun',
    region VARCHAR(255) DEFAULT 'Centre',
    longitude VARCHAR(255),
    latitude VARCHAR(255)
);

drop table if exists Fermier;
CREATE TABLE Fermier (
    id_fermier VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    pwd VARCHAR(255) NOT NULL,
    tel BIGINT NOT NULL,
    id_localisation VARCHAR(50),
    FOREIGN KEY (id_localisation)
        REFERENCES Localisation (id_localisation)
);

drop table if exists Article;
CREATE TABLE Article (
    id_article VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    descript VARCHAR(255),
    prixU INT NOT NULL,
    qte INT,
    id_categorie VARCHAR(50),
    id_image VARCHAR(50),
    id_fermier VARCHAR(50),
    FOREIGN KEY (id_categorie)
        REFERENCES Categorie (id_categorie),
    FOREIGN KEY (id_image)
        REFERENCES Image (id_image),
    FOREIGN KEY (id_fermier)
        REFERENCES Fermier (id_fermier)
);

drop table if exists Livraison;
CREATE TABLE Livraison (
    id_livraison VARCHAR(50) PRIMARY KEY,
    date_liv DATE,
    statut_livraison ENUM('Livré', 'Non livré', 'Annulé'),
    id_localisation VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_localisation)
        REFERENCES Localisation (id_localisation)
);

drop table if exists Commande;
create table Commande(
	id_commande VARCHAR(50) primary key,
    date_com date not null,
    livre boolean not null,
    statut_commande ENUM('Non payé', 'Payé', 'En attente', 'Annulé') NOT NULL,
    id_client VARCHAR(50),
    id_livraison VARCHAR(50),
    foreign key(id_client) references Customer(id_client),
    FOREIGN KEY(id_livraison) REFERENCES Livraison(id_livraison)
);

drop table if exists CommandeArticle;
CREATE TABLE CommandeArticle (
    quantite INT NOT NULL,
    id_article VARCHAR(50) NOT NULL,
    id_commande VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_article)
        REFERENCES Article (id_article),
    FOREIGN KEY (id_commande)
        REFERENCES Commande (id_commande),
    PRIMARY KEY (id_article , id_commande)
);


drop table if exists Paiement;
CREATE TABLE Paiement (
    id_paiement VARCHAR(50) PRIMARY KEY,
    montant BIGINT NOT NULL,
    id_commande VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_commande)
        REFERENCES Commande (id_commande)
);

drop table if exists PaiementCarte;
CREATE TABLE PaiementCarte (
    id_pc VARCHAR(50) PRIMARY KEY,
    crypto VARCHAR(255),
    numero_carte BIGINT,
    date_verticale DATE NOT NULL,
    id_paiement VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_paiement)
        REFERENCES Paiement (id_paiement)
);

SHOW TABLES ;

SELECT *
FROM localisation;

SELECT *
FROM commande;

insert into Customer values
    ('CU0101','ATANGANA Martin','martinatangana@gmail.com','atangana101',699352485),
    ('CU0102','TINAH Josephine','josephinetinah@gmail.com','tinah102',655328456),
    ('CU0103','TAWAMO Cébastien','cebtawamo@gmail.com','ceb404',677524965),
    ('CU0104','MUSTAFI Al Kelaib','kelalmustafi@gmail.com','sasuke03',697481102),
    ('CU0105','AZEBAZE Olivier','olivierazebaze@yahoo.fr','badboy197',650654875),
    ('CU0106','KENFACK Junior','juniorkenfack@gmail.com','cr7goat',670864523),
    ('CU0107','DONFACK Timothée','timotheedonfack@gmail.com','ghost33',690258484),
    ('CU0108','SIMO Mirabelle','mirabellesimo@gmail.com','cardib237',696545423),
    ('CU0109','KANA Estelle','kanaestelle@yahoo.fr','kanacoco0000',677452565),
    ('CU0110','BOGA Aladin','aladinboga@gmail.com','bgboga007',650342696),
    ('CU0111','PEYO Anastasie','anapeyo@gmail.com','ana111',675223654),
    ('CU0112','DONFACK Isabelle','isabelledonfack@ygmail.com','ibelle112',699963254),
    ('CU0113','DOGMO Teddy','dogmoteddy@yahoo.fr','teddybear10',650965326),
    ('CU0114','BELLA Manuella','manubella@gmail.com','manubella++',655232368),
    ('CU0115','EBENDA Sandrine','sandrineebenda@gmail.com','sandrychou4',674513809),
    ('CU0116','TSAFFACK Franklin','tsafackfranklin@yahoo.fr','francky06',655245632),
    ('CU0117','ZAYO Rick','rickross@gmail.com','rick.ross',696541237),
    ('CU0118','DATCHOUA Patrick','patreickdatchoua@gmail.com','patpatterson.jr',697852423),
    ('CU0119','TEUKAM Andy','andyteukam@gmail.com','leomessi10',655863552),
    ('CU0120','DANDJEU Junior','dandjeujr@gmail.com','jrdj365',656338433);

insert into Customer values
    ('CU0002', 'Ganago Ignacio', 'ignacioganago@gmail.com', 'igniaciogagano', 655489314),
    ('CU0003', 'Toko Ekambi', 'ekambi@yahoo.com', 'tokoekambi',657203694),
    ('CU0004', 'Fotsing Gabriel', 'gabrielfotsing@yahoo.com', 'gabrielfosting',695412358),
    ('CU0005', 'Ngah Roland', 'ngahroland@gmail.com', 'ngahroland',697452586),
    ('CU0006', 'Dongmo Salomon', 'salomondongmo@yahoo.fr', 'dongmosalomon',656680479),
    ('CU0007', 'Magne Justine', 'magne.justine@institutsaintjean.org', 'justinemagne', 654200036),
    ('CU0008', 'Dipanda Solange', 'solangedipanda@yahoo.fr', 'dipandasolange', 695478899),
    ('CU0009', 'Njitap Marcella', 'marcellanjitap@gmail.com', 'njitapmarcella', 656231402),
    ('CU0010', 'Bustive Laraison', 'bustivelaraison@gmail.com', 'bustivelaraison', 693254164),
    ('CU0011', 'Mindjos Amélie', 'mindjosamelie@yahoo.com', 'mindjosamelie', 655798951),
	('CU0012', 'Kenfack Boris', 'boriskenfack@yahoo.fr', 'boriskenfack', 675486210),
    ('CU0013', 'Nadia Morelle', 'morellenadia@gmail.com', 'nadiamorelle', 656120837),
    ('CU0014', 'Konlack Cassidy', 'cassidykonlack@gmail.com', 'cassidykonlack', 694752395),
    ('CU0015', 'Minsinga Jeff', 'jeffminsinga@gmail.com', 'jeffminsinga', 674016692),
    ('CU0016', 'Fotso Badouel', 'fotsobadouel@gmail.com', 'badouelfotso', 691513681),
    ('CU0017', 'Ngue Hirna', 'nguehirna@yahoo.com', 'nguehirna', 656893651),
    ('CU0018', 'Massing Eva', 'massingeva@gmail.com', 'massingeva', 673846523),
    ('CU0019', 'Akono Bernadette', 'bernadetteakono@yahoo.fr', 'bernadetteakono', 678932845),
    ('CU0020', 'Melong Elsina', 'elsinamelong@gmail.com', 'melongelsina', 6927418530);

INSERT INTO Customer values
    ('CU2011', 'paqueta', 'paquetanom@gmail.com', 'paqet15', 655244043),
    ('CU2032', 'bozar', 'bozarnom@gmail.com', 'boza1', 655244041),
    ('CU2053', 'aristide', 'aristidenom@gmail.com', 'aris1',655244041),
    ('CU2064', 'malo', 'malonom@gmail.com',' malo2' ,655244041),
    ('CU2085', 'marius', 'mariusnom@gmail.com',' marius1', 655244041),
    ('CU2506', 'virus', 'virusnom@gmail.com', 'virus1', 655244041),
    ('CU2157', 'chacala', 'chacalanom@gmail.com', 'chacala6', 655244041),
    ('CU2988', 'boyboy', 'boyboynom@gmail.com', 'boy251', 655244041),
    ('CU3009', 'baba', 'babanom@gmail.com', 'baba1', 655244041),
    ('CU2324', 'zepe', 'zepenom@gmail.com', 'zepe1', 655244041),
    ('CU2255', 'djipa', 'djipanom@gmail.com', 'djipa1', 655244041),
    ('CU2446', 'aziz', 'aziznom@gmail.com', 'aziz1', 655244041),
    ('CU2553',' joel',' joelnom@gmail.com', 'joel1', 655244041),
    ('CU2662', 'jordan', 'jordannom@gmail.com', 'jordan1', 655244041),
    ('CU2771', 'fopa', 'fopanom@gmail.com','fopa1', 655244041),
    ('CU2881', 'moza', 'mozanom@gmail.com', 'moza1', 655244041),
    ('CU2998', 'chris', 'chrisnom@gmail.com', 'chris1', 655244041),
    ('CU2979', 'frank', 'franknom@gmail.com', 'frank', 655244041),
    ('CU2957', 'nick', 'nicknom@gmail.com',' nick1', 655244041),
    ('CU2786', 'ludo', 'ludonom@gmail.com', 'ludo1', 655244041),
    ('CU2165', 'pernel','pernelnom@gmail.com', 'pernel1', 655244041);

insert into Categorie values
    ('CA0001','Viandes-Poissons-Œufs','Sources de protéines et de minéraux riche en vitamine A et D'),
    ('CA0002','Produits Laitiers','Riches en protéines et glucides'),
    ('CA0003','Matières Grasses','Aident l\'absorption de vitamines A,D,E et K par le corps'),
    ('CA0004','Fruits & Légumes','Riches en fibres, en vitamines, ainsi qu\'en antioxydants'),
    ('CA0005','Céréales & dérivés-légumineuses','Riches en fribres alimentaires et en vitamines diverses'),
    ('CA0006','Sucres & Produits Sucrés','Permet le bon fonctionnement des muscles et du cerveau'),
    ('CA0007','Boissons','Régularisent la température corporelle');

insert into Image values
    ('IM0001','',''),
    ('IM0006','',''),
    ('IM0007','',''),
    ('IM0008','',''),
    ('IM0009','',''),
    ('IM0010','','');

insert into Localisation values
     ('LO0001','Eyang','Lobo','Cameroun','Centre','11.390734','3.884117'),
     ('LO0002','Carrefour MEEC','Yaounde','Cameroun','Centre','11.485111','3.869552'),
     ('LO0003','Carrefour Nkolbisson','Yaounde','Cameroun','Centre','11.454283','3.872730'),
     ('LO0004','Rue des écoles','Douala','Cameroun','Littoral','9.692649','4.045433');

insert into Fermier values
    ('FE0001','ABDOULAYE Mohamadou','mohamadouabdoulaye@gamil.com','abmo237',699523412,'LO0004'),
    ('FE0002','FATIMA Léandre','leafati@gmail.com','leadash66',655324567,'LO0002'),
    ('FE0003','BATOU Phillipe','philbatou@gmail.com','hisoka44',697524856,'LO0002'),
    ('FE0004','TATAMO André','tatamoandre@yahoo.fr','mimi4life',675224712,'LO0003'),
    ('FE0005','TEDONGMO Sylvere','sylveretedongmo@gmail.com','sylver02',677834112,'LO0002'),
    ('FE0006','ABOMO Patrick','patrickabomo@gmail.com','inri000',696532486,'LO0001'),
    ('FE0007','SIDIANG Channelle','chanellesidiang@yahoo.fr','10june97',650023985,'LO0004'),
    ('FE0008','NANA Junior','juniornana@gmail.com','lejunior20',670234123,'LO0004'),
    ('FE0009','MAFOTSING Paloma','palomamafotsing@gmail.com','pal0maf0',693552187,'LO0002'),
    ('FE0020','MPONO','mpono@gmail.com','noname06',694514819,'LO0002');

insert into Fermier values
    ('FE0010','tonfack','tonfacknom@gmail.com', 'tfk00', 655244043,'LO0001'),
    ('FE0011','sonfack','sonfacknom@gmail.com','sfk01',655244043,'LO0002'),
    ('FE0012','donfack','donfacknom@gmail.com','dfk02',655244043,'LO0003'),
    ('FE0013','donkeng','donkengnom@gmail.com','dfg03',655244043,'LO0004'),
    ('FE0014','nguimfack','nguimfacknom@gmail.com','ngf04',655244043,'LO0001'),
    ('FE0015','nanfack','nanfacknom@gmail.com','nfk05',655244043,'LO0002'),
    ('FE0016','djifack','djifacknom@gmail.com','dfk06',655244043,'LO0003'),
    ('FE0017','tsafack','tsafacknom@gmail.com','tsfk07',655244043,'LO0002'),
    ('FE0018','nanfack','nanfacknom@gmail.com','nfk08',655244043,'LO0003'),
    ('FE0019','tsolefack','tsolefacknom@gmail.com','tslk09',655244043,'LO0004');

 insert into Fermier values
    ('FE0021','Nguetsop Martin','martinnguetsop@yahoo.fr','martinnguetsop',655147658,'LO0001'),
    ('FE0022','Oumarou Kabir','oumaroukabir@gmail.com','oumaroukabir',699987382,'LO0003'),
    ('FE0023','Ewane Bertrand','ewanebertrand@gmail.com','ewanebertrand',680146297,'LO0002'),
    ('FE0024','Kouamou Jean','jeankouamou@gmail.com','kouamoujean',697852301,'LO0002'),
    ('FE0025','Omgba Laura','omgbalaura@yahoo.com','lauraomgba',698745214,'LO0001'),
    ('FE0026','Mbida Estelle','estellembida@gmail.com','estellembida',693587100,'LO0004'),
    ('FE0027','Ndoum Gabriel','ndoumgabriel@yahoo.fr','gabrielndoum',675498526,'LO0001'),
    ('FE0028','Mba Chancellin','chancellinmba@yahoo.com','chancellinmba',681523974,'LO0002'),
    ('FE0029','Biyina Robert','bihinarobert@gmail.com','biyinarobert',690327169,'LO0003'),
    ('FE0030','Ngadio Soumira','soumirangadio@yahoo.fr','ngadiosoumira',698710478,'LO0001');

insert into Article values
    ('AR0001','Oeuf','',75,536,'CA0001','IM0001','FE0002'),
    ('AR0006','Huile d\'arachide','Bouteille de 1L',1550,200,'CA0003','IM0006','FE0005'),
    ('AR0007','Margarine JADIDA','',2600,62,'CA0003','IM0007','FE0005'),
    ('AR0008','Tomates','Tomate en fruit',100,581,'CA0004','IM0008','FE0006'),
    ('AR0009','Avocats','',250,45,'CA0004','IM0009','FE0005'),
    ('AR0010','Eau Supermpont','Bouteille d\'eau de 1.5L',450,120,'CA0007','IM0010','FE0001');

insert into Livraison values
    ('LI0013','2022-10-29','Livré','LO0002'),
    ('LI0014','2022-06-10','Annulé','LO0002'),
    ('LI0015','2022-06-10','Livré','LO0004'),
    ('LI0016','2022-09-20','Livré','LO0003'),
    ('LI0017','2022-10-08','Livré','LO0002'),
    ('LI0018','2022-11-02','Non livré','LO0004');

insert into Livraison values
    ('LI0001','2022-01-05','Livré','LO0003'),
    ('LI0002','2022-01-09','Livré','LO0002'),
    ('LI0003','2022-01-15','Livré','LO0001'),
    ('LI0004','2022-09-18','Annulé','LO0002'),
    ('LI0005','2022-05-13','Annulé','LO0004'),
    ('LI0006','2022-02-26','Livré','LO0003'),
    ('LI0007','2022-10-27','Non livré','LO0001'),
    ('LI0008','2022-06-18','Livré','LO0004'),
    ('LI0009','2022-06-04','Livré','LO0002'),
    ('LI0010','2022-03-14','Livré','LO0003'),
    ('LI0011','2022-04-29','Non livré','LO0001'),
    ('LI0012','2022-07-07','Livré','LO0003');

insert into Commande values
    ('CO0001','2022-09-11',0,'Payé','CU0108',null),
    ('CO0016','2022-10-22',1,'Payé','CU0120','LI0013'),
    ('CO0002','2022-07-04',0,'Annulé','CU0117',null),
    ('CO0019','2022-10-02',1,'Payé','CU0117','LI0017'),
    ('CO0003','2022-11-01',0,'En attente','CU0105',null),
    ('CO0004','2022-08-16',0,'Non payé','CU0107',null);

insert into Commandearticle values
    (10,'AR0008','CO0019'),
    (3,'AR0009','CO0019'),
    (1,'AR0006','CO0019'),
    (1,'AR0007','CO0001'),
    (2,'AR0010','CO0002');

insert into paiement values
    ('PA0001',2600,'CO0001'),
    ('PA0019',3300,'CO0019'),
    ('PA0002',900,'CO0002');




