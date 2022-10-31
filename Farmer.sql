create database bdsmartfarmer;
use bdsmartfarmer;

drop table if exists Customer;
CREATE TABLE Customer (
    id_client VARCHAR(8) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mdp VARCHAR(255) NOT NULL,
    telephone BIGINT NOT NULL
);

drop table if exists Categorie;
CREATE TABLE Categorie (
    id_categorie VARCHAR(255) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    descript VARCHAR(255)
);

drop table if exists Image;
CREATE TABLE Image (
    id_image VARCHAR(255) PRIMARY KEY,
    url VARCHAR(255),
    url_thumbnail VARCHAR(255)
);

drop table if exists Localisation;
CREATE TABLE Localisation (
    id_localisation VARCHAR(255) PRIMARY KEY,
    residence VARCHAR(255),
    ville VARCHAR(255) DEFAULT 'Yaoundé',
    pays VARCHAR(255) DEFAULT 'Cameroun',
    region VARCHAR(255) DEFAULT 'Centre',
    longitude VARCHAR(255),
    latitude VARCHAR(255)
);

drop table if exists Fermier;
CREATE TABLE Fermier (
    id_fermier VARCHAR(255) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    pwd VARCHAR(255) NOT NULL,
    tel BIGINT NOT NULL,
    id_localisation VARCHAR(255),
    FOREIGN KEY (id_localisation)
        REFERENCES Localisation (id_localisation)
);

drop table if exists Article;
CREATE TABLE Article (
    id_article VARCHAR(255) PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    descript VARCHAR(255),
    prixU INT NOT NULL,
    qte INT,
    id_categorie VARCHAR(255),
    id_image VARCHAR(255),
    id_fermier VARCHAR(255),
    FOREIGN KEY (id_categorie)
        REFERENCES Categorie (id_categorie),
    FOREIGN KEY (id_image)
        REFERENCES Image (id_image),
    FOREIGN KEY (id_fermier)
        REFERENCES Fermier (id_fermier)
);

drop table if exists Livraison;
CREATE TABLE Livraison (
    id_livraison VARCHAR(255) PRIMARY KEY,
    date_liv DATE,
    statut_livraison ENUM('Livré', 'Non livré', 'Annulé'),
    id_localisation VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_localisation)
        REFERENCES Localisation (id_localisation)
);

drop table if exists Commande;
create table Commande(
	id_commande VARCHAR(255) primary key,
    date_com date not null,
    livre boolean not null,
    statut_commande ENUM('Non payé', 'Payé', 'En attente', 'Annulé') NOT NULL,
    id_client VARCHAR(255),
    id_livraison VARCHAR(255),
    foreign key(id_client) references Customer(id_client),
    FOREIGN KEY(id_livraison) REFERENCES Livraison(id_livraison)
);

drop table if exists CommandeArticle;
CREATE TABLE CommandeArticle (
    quantite INT NOT NULL,
    id_article VARCHAR(255) NOT NULL,
    id_commande VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_article)
        REFERENCES Article (id_article),
    FOREIGN KEY (id_commande)
        REFERENCES Commande (id_commande),
    PRIMARY KEY (id_article , id_commande)
);


drop table if exists Paiement;
CREATE TABLE Paiement (
    id_paiement VARCHAR(255) PRIMARY KEY,
    montant BIGINT NOT NULL,
    id_commande VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_commande)
        REFERENCES Commande (id_commande)
);

drop table if exists PaiementCarte;
CREATE TABLE PaiementCarte (
    id_pc VARCHAR(255) PRIMARY KEY,
    crypto VARCHAR(255),
    numero_carte BIGINT,
    date_verticale DATE NOT NULL,
    id_paiement VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_paiement)
        REFERENCES Paiement (id_paiement)
);

SHOW TABLES ;

SELECT *
FROM localisation;

