-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 16 jan. 2023 à 15:31
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdsmartfarmer`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_article` varchar(50) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `descript` varchar(255) DEFAULT NULL,
  `prixU` int NOT NULL,
  `qte` int DEFAULT NULL,
  `id_categorie` varchar(50) DEFAULT NULL,
  `id_image` varchar(50) DEFAULT NULL,
  `id_fermier` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_article`),
  KEY `FK5qbslk1ioudummgell60ha69j` (`id_categorie`),
  KEY `FKmmnu28v0fkpg1q8wwdkp2i4o4` (`id_fermier`),
  KEY `FKcgjglveh9und0h790a6d3f48k` (`id_image`),
  KEY `id_categorie` (`id_categorie`),
  KEY `id_image` (`id_image`),
  KEY `id_fermier` (`id_fermier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `nom`, `descript`, `prixU`, `qte`, `id_categorie`, `id_image`, `id_fermier`) VALUES
('AR0001', 'Oeuf', '', 75, 536, 'CA0001', 'IM0001', 'FE0002'),
('AR0006', 'Huile d\'arachide', 'Bouteille de 1L', 1550, 200, 'CA0003', 'IM0006', 'FE0005'),
('AR0007', 'Margarine JADIDA', '', 2600, 62, 'CA0003', 'IM0007', 'FE0005'),
('AR0008', 'Tomates', 'Tomate en fruit', 100, 581, 'CA0004', 'IM0008', 'FE0006'),
('AR0009', 'Avocats', '', 250, 45, 'CA0004', 'IM0009', 'FE0005'),
('AR0010', 'Eau Supermpont', 'Bouteille d\'eau de 1.5L', 450, 120, 'CA0007', 'IM0010', 'FE0001');

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` varchar(50) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `descript` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `nom`, `descript`) VALUES
('CA0001', 'Viandes-Poissons-Œufs', 'Sources de protéines et de minéraux riche en vitamine A et D'),
('CA0002', 'Produits Laitiers', 'Riches en protéines et glucides'),
('CA0003', 'Matières Grasses', 'Aident l\'absorption de vitamines A,D,E et K par le corps'),
('CA0004', 'Fruits & Légumes', 'Riches en fibres, en vitamines, ainsi qu\'en antioxydants'),
('CA0005', 'Céréales & dérivés-légumineuses', 'Riches en fribres alimentaires et en vitamines diverses'),
('CA0006', 'Sucres & Produits Sucrés', 'Permet le bon fonctionnement des muscles et du cerveau'),
('CA0007', 'Boissons', 'Régularisent la température corporelle');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` varchar(50) NOT NULL,
  `date_com` date NOT NULL,
  `livre` tinyint(1) NOT NULL,
  `statut_commande` enum('Non payé','Payé','En attente','Annulé') NOT NULL,
  `id_client` varchar(50) DEFAULT NULL,
  `id_livraison` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `FKfli8jhlji7kqjm5dpuey15agd` (`id_client`),
  KEY `FKaxq0magj1niv0nvq5s7c6vk5s` (`id_livraison`),
  KEY `id_client` (`id_client`),
  KEY `id_livraison` (`id_livraison`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `date_com`, `livre`, `statut_commande`, `id_client`, `id_livraison`) VALUES
('CO0001', '2022-09-11', 0, 'Payé', 'CU0108', 'LI0001'),
('CO0002', '2022-07-04', 0, 'Annulé', 'CU0117', 'LI0002'),
('CO0003', '2022-11-01', 0, 'En attente', 'CU0105', 'LI0006'),
('CO0004', '2022-08-16', 0, 'Non payé', 'CU0107', 'LI0007'),
('CO0016', '2022-10-22', 1, 'Payé', 'CU0120', 'LI0013'),
('CO0019', '2022-10-02', 1, 'Payé', 'CU0117', 'LI0017');

-- --------------------------------------------------------

--
-- Structure de la table `commandearticle`
--

DROP TABLE IF EXISTS `commandearticle`;
CREATE TABLE IF NOT EXISTS `commandearticle` (
  `quantite` int NOT NULL,
  `id_article` varchar(50) NOT NULL,
  `id_commande` varchar(50) NOT NULL,
  PRIMARY KEY (`id_article`,`id_commande`),
  KEY `id_commande` (`id_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `commandearticle`
--

INSERT INTO `commandearticle` (`quantite`, `id_article`, `id_commande`) VALUES
(1, 'AR0006', 'CO0019'),
(1, 'AR0007', 'CO0001'),
(10, 'AR0008', 'CO0019'),
(3, 'AR0009', 'CO0019'),
(2, 'AR0010', 'CO0002');

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id_client` varchar(50) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `telephone` bigint NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id_client`, `nom`, `email`, `mdp`, `telephone`, `username`) VALUES
('CU0002', 'Ganago Ignacio', 'ignacioganago@gmail.com', 'igniaciogagano', 655489314, ''),
('CU0003', 'Toko Ekambi', 'ekambi@yahoo.com', 'tokoekambi', 657203694, ''),
('CU0004', 'Fotsing Gabriel', 'gabrielfotsing@yahoo.com', 'gabrielfosting', 695412358, ''),
('CU0005', 'Ngah Roland', 'ngahroland@gmail.com', 'ngahroland', 697452586, ''),
('CU0006', 'Dongmo Salomon', 'salomondongmo@yahoo.fr', 'dongmosalomon', 656680479, ''),
('CU0007', 'Magne Justine', 'magne.justine@institutsaintjean.org', 'justinemagne', 654200036, ''),
('CU0008', 'Dipanda Solange', 'solangedipanda@yahoo.fr', 'dipandasolange', 695478899, ''),
('CU0009', 'Njitap Marcella', 'marcellanjitap@gmail.com', 'njitapmarcella', 656231402, ''),
('CU0010', 'Bustive Laraison', 'bustivelaraison@gmail.com', 'bustivelaraison', 693254164, ''),
('CU0011', 'Mindjos Amélie', 'mindjosamelie@yahoo.com', 'mindjosamelie', 655798951, ''),
('CU0012', 'Kenfack Boris', 'boriskenfack@yahoo.fr', 'boriskenfack', 675486210, ''),
('CU0013', 'Nadia Morelle', 'morellenadia@gmail.com', 'nadiamorelle', 656120837, ''),
('CU0014', 'Konlack Cassidy', 'cassidykonlack@gmail.com', 'cassidykonlack', 694752395, ''),
('CU0015', 'Minsinga Jeff', 'jeffminsinga@gmail.com', 'jeffminsinga', 674016692, ''),
('CU0016', 'Fotso Badouel', 'fotsobadouel@gmail.com', 'badouelfotso', 691513681, ''),
('CU0017', 'Ngue Hirna', 'nguehirna@yahoo.com', 'nguehirna', 656893651, ''),
('CU0018', 'Massing Eva', 'massingeva@gmail.com', 'massingeva', 673846523, ''),
('CU0019', 'Akono Bernadette', 'bernadetteakono@yahoo.fr', 'bernadetteakono', 678932845, ''),
('CU0020', 'Melong Elsina', 'elsinamelong@gmail.com', 'melongelsina', 6927418530, ''),
('CU0101', 'ATANGANA Martin', 'martinatangana@gmail.com', 'atangana101', 699352485, ''),
('CU0102', 'TINAH Josephine', 'josephinetinah@gmail.com', 'tinah102', 655328456, ''),
('CU0103', 'TAWAMO Cébastien', 'cebtawamo@gmail.com', 'ceb404', 677524965, ''),
('CU0104', 'MUSTAFI Al Kelaib', 'kelalmustafi@gmail.com', 'sasuke03', 697481102, ''),
('CU0105', 'AZEBAZE Olivier', 'olivierazebaze@yahoo.fr', 'badboy197', 650654875, ''),
('CU0106', 'KENFACK Junior', 'juniorkenfack@gmail.com', 'cr7goat', 670864523, ''),
('CU0107', 'DONFACK Timothée', 'timotheedonfack@gmail.com', 'ghost33', 690258484, ''),
('CU0108', 'SIMO Mirabelle', 'mirabellesimo@gmail.com', 'cardib237', 696545423, ''),
('CU0109', 'KANA Estelle', 'kanaestelle@yahoo.fr', 'kanacoco0000', 677452565, ''),
('CU0110', 'BOGA Aladin', 'aladinboga@gmail.com', 'bgboga007', 650342696, ''),
('CU0111', 'PEYO Anastasie', 'anapeyo@gmail.com', 'ana111', 675223654, ''),
('CU0112', 'DONFACK Isabelle', 'isabelledonfack@ygmail.com', 'ibelle112', 699963254, ''),
('CU0113', 'DOGMO Teddy', 'dogmoteddy@yahoo.fr', 'teddybear10', 650965326, ''),
('CU0114', 'BELLA Manuella', 'manubella@gmail.com', 'manubella++', 655232368, ''),
('CU0115', 'EBENDA Sandrine', 'sandrineebenda@gmail.com', 'sandrychou4', 674513809, ''),
('CU0116', 'TSAFFACK Franklin', 'tsafackfranklin@yahoo.fr', 'francky06', 655245632, ''),
('CU0117', 'ZAYO Rick', 'rickross@gmail.com', 'rick.ross', 696541237, ''),
('CU0118', 'DATCHOUA Patrick', 'patreickdatchoua@gmail.com', 'patpatterson.jr', 697852423, ''),
('CU0119', 'TEUKAM Andy', 'andyteukam@gmail.com', 'leomessi10', 655863552, ''),
('CU0120', 'DANDJEU Junior', 'dandjeujr@gmail.com', 'jrdj365', 656338433, ''),
('CU2011', 'paqueta', 'paquetanom@gmail.com', 'paqet15', 655244043, ''),
('CU2032', 'bozar', 'bozarnom@gmail.com', 'boza1', 655244041, ''),
('CU2053', 'aristide', 'aristidenom@gmail.com', 'aris1', 655244041, ''),
('CU2064', 'malo', 'malonom@gmail.com', ' malo2', 655244041, ''),
('CU2085', 'marius', 'mariusnom@gmail.com', ' marius1', 655244041, ''),
('CU2157', 'chacala', 'chacalanom@gmail.com', 'chacala6', 655244041, ''),
('CU2165', 'pernel', 'pernelnom@gmail.com', 'pernel1', 655244041, ''),
('CU2255', 'djipa', 'djipanom@gmail.com', 'djipa1', 655244041, ''),
('CU2324', 'zepe', 'zepenom@gmail.com', 'zepe1', 655244041, ''),
('CU2446', 'aziz', 'aziznom@gmail.com', 'aziz1', 655244041, ''),
('CU2506', 'virus', 'virusnom@gmail.com', 'virus1', 655244041, ''),
('CU2553', ' joel', ' joelnom@gmail.com', 'joel1', 655244041, ''),
('CU2662', 'jordan', 'jordannom@gmail.com', 'jordan1', 655244041, ''),
('CU2771', 'fopa', 'fopanom@gmail.com', 'fopa1', 655244041, ''),
('CU2786', 'ludo', 'ludonom@gmail.com', 'ludo1', 655244041, ''),
('CU2881', 'moza', 'mozanom@gmail.com', 'moza1', 655244041, ''),
('CU2957', 'nick', 'nicknom@gmail.com', ' nick1', 655244041, ''),
('CU2979', 'frank', 'franknom@gmail.com', 'frank', 655244041, ''),
('CU2988', 'boyboy', 'boyboynom@gmail.com', 'boy251', 655244041, ''),
('CU2998', 'chris', 'chrisnom@gmail.com', 'chris1', 655244041, ''),
('CU3009', 'baba', 'babanom@gmail.com', 'baba1', 655244041, '');

-- --------------------------------------------------------

--
-- Structure de la table `fermier`
--

DROP TABLE IF EXISTS `fermier`;
CREATE TABLE IF NOT EXISTS `fermier` (
  `id_fermier` varchar(50) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `tel` bigint NOT NULL,
  `id_localisation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id_fermier`),
  KEY `id_localisation` (`id_localisation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `fermier`
--

INSERT INTO `fermier` (`id_fermier`, `nom`, `email`, `pwd`, `tel`, `id_localisation`) VALUES
('FE0001', 'ABDOULAYE Mohamadou', 'mohamadouabdoulaye@gamil.com', 'abmo237', 699523412, 'LO0004'),
('FE0002', 'FATIMA Léandre', 'leafati@gmail.com', 'leadash66', 655324567, 'LO0002'),
('FE0003', 'BATOU Phillipe', 'philbatou@gmail.com', 'hisoka44', 697524856, 'LO0002'),
('FE0004', 'TATAMO André', 'tatamoandre@yahoo.fr', 'mimi4life', 675224712, 'LO0003'),
('FE0005', 'TEDONGMO Sylvere', 'sylveretedongmo@gmail.com', 'sylver02', 677834112, 'LO0002'),
('FE0006', 'ABOMO Patrick', 'patrickabomo@gmail.com', 'inri000', 696532486, 'LO0001'),
('FE0007', 'SIDIANG Channelle', 'chanellesidiang@yahoo.fr', '10june97', 650023985, 'LO0004'),
('FE0008', 'NANA Junior', 'juniornana@gmail.com', 'lejunior20', 670234123, 'LO0004'),
('FE0009', 'MAFOTSING Paloma', 'palomamafotsing@gmail.com', 'pal0maf0', 693552187, 'LO0002'),
('FE0010', 'tonfack', 'tonfacknom@gmail.com', 'tfk00', 655244043, 'LO0001'),
('FE0011', 'sonfack', 'sonfacknom@gmail.com', 'sfk01', 655244043, 'LO0002'),
('FE0012', 'donfack', 'donfacknom@gmail.com', 'dfk02', 655244043, 'LO0003'),
('FE0013', 'donkeng', 'donkengnom@gmail.com', 'dfg03', 655244043, 'LO0004'),
('FE0014', 'nguimfack', 'nguimfacknom@gmail.com', 'ngf04', 655244043, 'LO0001'),
('FE0015', 'nanfack', 'nanfacknom@gmail.com', 'nfk05', 655244043, 'LO0002'),
('FE0016', 'djifack', 'djifacknom@gmail.com', 'dfk06', 655244043, 'LO0003'),
('FE0017', 'tsafack', 'tsafacknom@gmail.com', 'tsfk07', 655244043, 'LO0002'),
('FE0018', 'nanfack', 'nanfacknom@gmail.com', 'nfk08', 655244043, 'LO0003'),
('FE0019', 'tsolefack', 'tsolefacknom@gmail.com', 'tslk09', 655244043, 'LO0004'),
('FE0020', 'MPONO', 'mpono@gmail.com', 'noname06', 694514819, 'LO0002'),
('FE0021', 'Nguetsop Martin', 'martinnguetsop@yahoo.fr', 'martinnguetsop', 655147658, 'LO0001'),
('FE0022', 'Oumarou Kabir', 'oumaroukabir@gmail.com', 'oumaroukabir', 699987382, 'LO0003'),
('FE0023', 'Ewane Bertrand', 'ewanebertrand@gmail.com', 'ewanebertrand', 680146297, 'LO0002'),
('FE0024', 'Kouamou Jean', 'jeankouamou@gmail.com', 'kouamoujean', 697852301, 'LO0002'),
('FE0025', 'Omgba Laura', 'omgbalaura@yahoo.com', 'lauraomgba', 698745214, 'LO0001'),
('FE0026', 'Mbida Estelle', 'estellembida@gmail.com', 'estellembida', 693587100, 'LO0004'),
('FE0027', 'Ndoum Gabriel', 'ndoumgabriel@yahoo.fr', 'gabrielndoum', 675498526, 'LO0001'),
('FE0028', 'Mba Chancellin', 'chancellinmba@yahoo.com', 'chancellinmba', 681523974, 'LO0002'),
('FE0029', 'Biyina Robert', 'bihinarobert@gmail.com', 'biyinarobert', 690327169, 'LO0003'),
('FE0030', 'Ngadio Soumira', 'soumirangadio@yahoo.fr', 'ngadiosoumira', 698710478, 'LO0001');

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `id_image` varchar(50) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `url_thumbnail` varchar(255) DEFAULT NULL,
  `data` longblob NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`id_image`, `url`, `url_thumbnail`, `data`, `name`) VALUES
('IM0001', '', '', '', ''),
('IM0006', '', '', '', ''),
('IM0007', '', '', '', ''),
('IM0008', '', '', '', ''),
('IM0009', '', '', '', ''),
('IM0010', '', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `id_livraison` varchar(50) NOT NULL,
  `date_liv` date DEFAULT NULL,
  `statut_livraison` enum('Livré','Non livré','Annulé') DEFAULT NULL,
  `id_localisation` varchar(50) NOT NULL,
  PRIMARY KEY (`id_livraison`),
  KEY `FKq6sxgrn1c09deikecs5pwmbug` (`id_localisation`),
  KEY `id_localisation` (`id_localisation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`id_livraison`, `date_liv`, `statut_livraison`, `id_localisation`) VALUES
('LI0001', '2022-01-05', 'Livré', 'LO0003'),
('LI0002', '2022-01-09', 'Livré', 'LO0002'),
('LI0003', '2022-01-15', 'Livré', 'LO0001'),
('LI0004', '2022-09-18', 'Annulé', 'LO0002'),
('LI0005', '2022-05-13', 'Annulé', 'LO0004'),
('LI0006', '2022-02-26', 'Livré', 'LO0003'),
('LI0007', '2022-10-27', 'Non livré', 'LO0001'),
('LI0008', '2022-06-18', 'Livré', 'LO0004'),
('LI0009', '2022-06-04', 'Livré', 'LO0002'),
('LI0010', '2022-03-14', 'Livré', 'LO0003'),
('LI0011', '2022-04-29', 'Non livré', 'LO0001'),
('LI0012', '2022-07-07', 'Livré', 'LO0003'),
('LI0013', '2022-10-29', 'Livré', 'LO0002'),
('LI0014', '2022-06-10', 'Annulé', 'LO0002'),
('LI0015', '2022-06-10', 'Livré', 'LO0004'),
('LI0016', '2022-09-20', 'Livré', 'LO0003'),
('LI0017', '2022-10-08', 'Livré', 'LO0002'),
('LI0018', '2022-11-02', 'Non livré', 'LO0004');

-- --------------------------------------------------------

--
-- Structure de la table `localisation`
--

DROP TABLE IF EXISTS `localisation`;
CREATE TABLE IF NOT EXISTS `localisation` (
  `id_localisation` varchar(50) NOT NULL,
  `residence` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT 'Yaoundé',
  `pays` varchar(255) DEFAULT 'Cameroun',
  `region` varchar(255) DEFAULT 'Centre',
  `longitude` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `added_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_localisation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `localisation`
--

INSERT INTO `localisation` (`id_localisation`, `residence`, `ville`, `pays`, `region`, `longitude`, `latitude`, `added_by`, `deleted`) VALUES
('AR288', 'mvog-Ada', 'yaounde', 'cameroun', 'centre', '11.087858', '44.15784', 'CU0117', b'1'),
('AR3520', 'Ekounou', 'yaounde', 'cameroun', 'centre', '11.087858', '44.15784', NULL, NULL),
('AR3800', 'simbock', 'yaounde', NULL, 'centre', '4515', '5457', 'CU0117', b'1'),
('AR7153', '13501 mendong', 'yaounde', NULL, 'centre', '123.52', '148', 'CU0117', b'1'),
('AR7217', 'odza petit marche', 'yaounde', NULL, 'centre', '812.255', '1155.99', 'CU0117', b'1'),
('AR7236', 'mvog-Ada marche', 'yaounde', 'cameroun', 'centre', '11.087858', '44.15784', 'CU0117', b'1'),
('AR8417', 'Ekounou marche', 'yaounde', 'cameroun', 'centre', '11.087858', '44.15784', NULL, NULL),
('AR8698', 'bonamoussadi', 'Douala', 'cameroun', 'centre', '12.087858', '34.15784', 'CU0117', b'1'),
('AR9957', 'Etougbe', 'yaounde', NULL, 'centre', '122588', '755220.55', 'CU0117', b'1'),
('LO0001', 'Eyang', 'Lobo', 'Cameroun', 'Centre', '11.390734', '3.884117', 'CU0107', b'0'),
('LO0002', 'Carrefour MEEC', 'Yaounde', 'Cameroun', 'Centre', '11.485111', '3.869552', 'CU0117', b'0'),
('LO0003', 'Carrefour Nkolbisson', 'Yaounde', 'Cameroun', 'Centre', '11.454283', '3.872730', 'CU0108', b'0'),
('LO0004', 'Rue des écoles', 'Douala', 'Cameroun', 'Littoral', '9.692649', '4.045433', 'CU0117', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
CREATE TABLE IF NOT EXISTS `paiement` (
  `id_paiement` varchar(50) NOT NULL,
  `montant` bigint NOT NULL,
  `id_commande` varchar(50) NOT NULL,
  PRIMARY KEY (`id_paiement`),
  KEY `FKlyltwlxfuqnk4duwmrj7n4vv9` (`id_commande`),
  KEY `id_commande` (`id_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `paiement`
--

INSERT INTO `paiement` (`id_paiement`, `montant`, `id_commande`) VALUES
('PA0001', 2600, 'CO0001'),
('PA0002', 900, 'CO0002'),
('PA0019', 3300, 'CO0019');

-- --------------------------------------------------------

--
-- Structure de la table `paiementcarte`
--

DROP TABLE IF EXISTS `paiementcarte`;
CREATE TABLE IF NOT EXISTS `paiementcarte` (
  `id_pc` varchar(50) NOT NULL,
  `crypto` varchar(255) DEFAULT NULL,
  `numero_carte` bigint DEFAULT NULL,
  `date_verticale` date NOT NULL,
  `id_paiement` varchar(50) NOT NULL,
  PRIMARY KEY (`id_pc`),
  KEY `FK7xhnvynjh2ha2v0jeb86xrd74` (`id_paiement`),
  KEY `id_paiement` (`id_paiement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK5qbslk1ioudummgell60ha69j` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`),
  ADD CONSTRAINT `FKcgjglveh9und0h790a6d3f48k` FOREIGN KEY (`id_image`) REFERENCES `image` (`id_image`),
  ADD CONSTRAINT `FKmmnu28v0fkpg1q8wwdkp2i4o4` FOREIGN KEY (`id_fermier`) REFERENCES `fermier` (`id_fermier`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FKaxq0magj1niv0nvq5s7c6vk5s` FOREIGN KEY (`id_livraison`) REFERENCES `livraison` (`id_livraison`),
  ADD CONSTRAINT `FKfli8jhlji7kqjm5dpuey15agd` FOREIGN KEY (`id_client`) REFERENCES `customer` (`id_client`);

--
-- Contraintes pour la table `fermier`
--
ALTER TABLE `fermier`
  ADD CONSTRAINT `et` FOREIGN KEY (`id_localisation`) REFERENCES `localisation` (`id_localisation`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `FKq6sxgrn1c09deikecs5pwmbug` FOREIGN KEY (`id_localisation`) REFERENCES `localisation` (`id_localisation`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `FKlyltwlxfuqnk4duwmrj7n4vv9` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`);

--
-- Contraintes pour la table `paiementcarte`
--
ALTER TABLE `paiementcarte`
  ADD CONSTRAINT `FK7xhnvynjh2ha2v0jeb86xrd74` FOREIGN KEY (`id_paiement`) REFERENCES `paiement` (`id_paiement`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
