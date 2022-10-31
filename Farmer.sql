create database bdsmartfarmer;
use bdsmartfarmer;

drop table if exists Customer;
CREATE TABLE Customer (
    id_client CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    email CHAR(255) NOT NULL,
    mdp CHAR(255) NOT NULL,
    telephone BIGINT NOT NULL
);

drop table if exists Categorie;
CREATE TABLE Categorie (
    id_categorie CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    descript CHAR(255)
);

drop table if exists Image;
CREATE TABLE Image (
    id_image CHAR(255) PRIMARY KEY,
    url CHAR(255),
    url_thumbnail CHAR(255)
);

drop table if exists Localisation;
CREATE TABLE Localisation (
    id_localisation CHAR(255) PRIMARY KEY,
    ville CHAR(255) DEFAULT 'Yaoundé',
    pays CHAR(255) DEFAULT 'Cameroun',
    region CHAR(255) DEFAULT 'Centre',
    longitude CHAR(255),
    latitude CHAR(255)
);

drop table if exists Fermier;
CREATE TABLE Fermier (
    id_fermier CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    email CHAR(255) NOT NULL,
    pwd CHAR(255) NOT NULL,
    tel BIGINT NOT NULL,
    id_localisation CHAR(255),
    FOREIGN KEY (id_localisation)
        REFERENCES Localisation (id_localisation)
);

drop table if exists Article;
CREATE TABLE Article (
    id_article CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    descript CHAR(255),
    prixU INT NOT NULL,
    qte INT,
    id_categorie CHAR(255),
    id_image CHAR(255),
    id_fermier CHAR(255),
    FOREIGN KEY (id_categorie)
        REFERENCES Categorie (id_categorie),
    FOREIGN KEY (id_image)
        REFERENCES Image (id_image),
    FOREIGN KEY (id_fermier)
        REFERENCES Fermier (id_fermier)
);

drop table if exists Livraison;
CREATE TABLE Livraison (
    id_livraison CHAR(255) PRIMARY KEY,
    date_liv DATE,
    statut_livraison ENUM('Livré', 'Non livré', 'Annulé'),
    id_localisation CHAR(255) NOT NULL,
    FOREIGN KEY (id_localisation)
        REFERENCES Localisation (id_localisation)
);

drop table if exists Commande;
create table Commande(
	id_commande char(255) primary key,
    date_com date not null,
    livre boolean not null,
    statut_commande ENUM('Non payé', 'Payé', 'En attente', 'Annulé') NOT NULL,
    id_client char(255),
    id_livraison CHAR(255),
    foreign key(id_client) references Customer(id_client),
    FOREIGN KEY(id_livraison) REFERENCES Livraison(id_livraison)
);

drop table if exists CommandeArticle;
CREATE TABLE CommandeArticle (
    quantite INT NOT NULL,
    id_article CHAR(255) NOT NULL,
    id_commande CHAR(255) NOT NULL,
    FOREIGN KEY (id_article)
        REFERENCES Article (id_article),
    FOREIGN KEY (id_commande)
        REFERENCES Commande (id_commande),
    PRIMARY KEY (id_article , id_commande)
);


drop table if exists Paiement;
CREATE TABLE Paiement (
    id_paiement CHAR(255) PRIMARY KEY,
    montant BIGINT NOT NULL,
    id_commande CHAR(255) NOT NULL,
    FOREIGN KEY (id_commande)
        REFERENCES Commande (id_commande)
);

drop table if exists PaiementCarte;
CREATE TABLE PaiementCarte (
    id_pc CHAR(255) PRIMARY KEY,
    crypto CHAR(255),
    numero_carte BIGINT,
    date_verticale DATE NOT NULL,
    id_paiement CHAR(255) NOT NULL,
    FOREIGN KEY (id_paiement)
        REFERENCES Paiement (id_paiement)
);

SHOW TABLES ;

INSERT INTO localisation VALUE
    ('LO001', DEFAULT, DEFAULT, DEFAULT, '0005874', '558898');

DESCRIBE localisation;

INSERT INTO livraison VALUES
                          ('LI003', '2022-10-31', 'Livré', 'LO001'),
                          ('LI004', '2022-10-31', 'Annulé', 'LO003'),
                          ('LI005', '2022-10-31', 'Livré', 'LO003');

SELECT *
FROM localisation;

