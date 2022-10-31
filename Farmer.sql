create database bdsmartfarmer;
use bdsmartfarmer;

drop table if exists Customer;
CREATE TABLE Customer (
    idClient CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    email CHAR(255) NOT NULL,
    mdp CHAR(255) NOT NULL,
    telephone BIGINT NOT NULL
);

drop table if exists Categorie;
CREATE TABLE Categorie (
    idCategorie CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    descript CHAR(255)
);

drop table if exists Image;
CREATE TABLE Image (
    idImage CHAR(255) PRIMARY KEY,
    url CHAR(255),
    urlThumbnail CHAR(255)
);

drop table if exists Localisation;
CREATE TABLE Localisation (
    idLocalisation CHAR(255) PRIMARY KEY,
    ville CHAR(255) DEFAULT 'Yaoundé',
    pays CHAR(255) DEFAULT 'Cameroun',
    region CHAR(255) DEFAULT 'Centre',
    longitude CHAR(255),
    latitude CHAR(255)
);

drop table if exists Fermier;
CREATE TABLE Fermier (
    idFermier CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    email CHAR(255) NOT NULL,
    pwd CHAR(255) NOT NULL,
    tel BIGINT NOT NULL,
    idLocalisation CHAR(255),
    FOREIGN KEY (idLocalisation)
        REFERENCES Localisation (idLocalisation)
);

drop table if exists Article;
CREATE TABLE Article (
    idArticle CHAR(255) PRIMARY KEY,
    nom CHAR(255) NOT NULL,
    descript CHAR(255),
    prixU INT NOT NULL,
    qte INT,
    idCategorie CHAR(255),
    idImage CHAR(255),
    idFermier CHAR(255),
    FOREIGN KEY (idCategorie)
        REFERENCES Categorie (idCategorie),
    FOREIGN KEY (idImage)
        REFERENCES Image (idImage),
    FOREIGN KEY (idFermier)
        REFERENCES Fermier (idFermier)
);

drop table if exists Livraison;
CREATE TABLE Livraison (
    idLivraison CHAR(255) PRIMARY KEY,
    dateLiv DATE,
    statutLivraison ENUM('Livré', 'Non livré', 'Annulé'),
    idLocalisation CHAR(255) NOT NULL,
    FOREIGN KEY (idLocalisation)
        REFERENCES Localisation (idLocalisation)
);

drop table if exists Commande;
create table Commande(
	idCommande char(255) primary key,
    dateCom date not null,
    livre boolean not null,
    statutCommande ENUM('Non payé', 'Payé', 'En attente', 'Annulé') NOT NULL,
    idClient char(255),
    idLivraison CHAR(255),
    foreign key(idClient) references Customer(idClient),
    FOREIGN KEY(idLivraison) REFERENCES Livraison(idLivraison)
);

drop table if exists CommandeArticle;
CREATE TABLE CommandeArticle (
    quantite INT NOT NULL,
    idArticle CHAR(255) NOT NULL,
    idCommande CHAR(255) NOT NULL,
    FOREIGN KEY (idArticle)
        REFERENCES Article (idArticle),
    FOREIGN KEY (idCommande)
        REFERENCES Commande (idCommande),
    PRIMARY KEY (idArticle , idCommande)
);


drop table if exists Paiement;
CREATE TABLE Paiement (
    idPaiement CHAR(255) PRIMARY KEY,
    montant BIGINT NOT NULL,
    idCommande CHAR(255) NOT NULL,
    FOREIGN KEY (idCommande)
        REFERENCES Commande (idCommande)
);

drop table if exists PaiementCarte;
CREATE TABLE PaiementCarte (
    idPC CHAR(255) PRIMARY KEY,
    crypto CHAR(255),
    numeroCarte BIGINT,
    dateVerticale DATE NOT NULL,
    idPaiement CHAR(255) NOT NULL,
    FOREIGN KEY (idPaiement)
        REFERENCES Paiement (idPaiement)
);

SHOW TABLES ;