-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 08 juin 2019 à 22:05
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id`) VALUES
(2016),
(2017),
(2018),
(2019);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Trimestre.id` int(11) NOT NULL,
  `Inscription.id` int(11) NOT NULL,
  `appreciation` text NOT NULL,
  `Moyenneg` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Trimestre.id` (`Trimestre.id`),
  KEY `Inscription.id` (`Inscription.id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `Trimestre.id`, `Inscription.id`, `appreciation`, `Moyenneg`) VALUES
(2, 10, 1, 'Peut mieux faire.', 0),
(3, 10, 2, 'Catastrophique.', 0),
(6, 12, 3, 'Connaissances très approximatives.', 10),
(7, 12, 1, '', 10),
(8, 12, 2, '', 10);

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text,
  `Ecole.id` int(11) NOT NULL DEFAULT '1',
  `Niveau.id` int(11) NOT NULL,
  `AnneeScolaire.id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Ecole.id` (`Ecole.id`),
  KEY `AnneeScolaire.id` (`AnneeScolaire.id`),
  KEY `Niveau.id` (`Niveau.id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `Ecole.id`, `Niveau.id`, `AnneeScolaire.id`) VALUES
(1, 'CPA', 1, 1, 2018),
(2, 'CPB', 1, 1, 2018),
(3, 'Ecureuil', 1, 5, 2018),
(4, 'Lievre', 1, 2, 2019),
(5, 'Marmotte', 1, 3, 2019);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Bulletin.id` int(11) NOT NULL,
  `Enseignement.id` int(11) NOT NULL,
  `appreciation` text,
  `Moyenne` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Bulletin.id` (`Bulletin.id`),
  KEY `Enseignant.id` (`Enseignement.id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id`, `Bulletin.id`, `Enseignement.id`, `appreciation`, `Moyenne`) VALUES
(1, 3, 1, 'A toucher le fond mais creuse encore.', 0),
(2, 2, 2, 'Quelques efforts à faire et cet éléve pourrait obtenir plus que la moyenne.', 0),
(3, 6, 1, '', 0);

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id`, `nom`) VALUES
(1, 'Anglais'),
(2, 'Francais'),
(3, 'Histoire');

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
CREATE TABLE IF NOT EXISTS `ecole` (
  `id_ecole` int(11) NOT NULL AUTO_INCREMENT,
  `nom_ecole` text NOT NULL,
  PRIMARY KEY (`id_ecole`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ecole`
--

INSERT INTO `ecole` (`id_ecole`, `nom_ecole`) VALUES
(1, 'Gambetta');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Classe.id` int(11) NOT NULL,
  `Discipline.id` int(11) NOT NULL,
  `Personne.id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Discipline.id` (`Discipline.id`),
  KEY `Personne.id` (`Personne.id`),
  KEY `Classe.id` (`Classe.id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`id`, `Classe.id`, `Discipline.id`, `Personne.id`) VALUES
(1, 1, 2, 1),
(2, 1, 1, 2),
(3, 2, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DetailBulletin.id` int(11) NOT NULL,
  `Enseignement.id` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `appreciation` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DetailBulletin.id` (`DetailBulletin.id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `DetailBulletin.id`, `Enseignement.id`, `note`, `appreciation`) VALUES
(1, 1, 1, 8, 'A retravailler.'),
(2, 2, 2, 10, 'Passable'),
(3, 1, 1, 9, 'Mediocre'),
(4, 3, 14, 6, 'Mauvais'),
(5, 3, 14, 16, 'Très bonne connaissance de l\'histoire romaine.');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Classe.id` int(11) NOT NULL,
  `Personne.id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Classe.id` (`Classe.id`),
  KEY `Personne.id` (`Personne.id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `Classe.id`, `Personne.id`) VALUES
(1, 1, 12),
(2, 1, 13),
(3, 1, 14),
(4, 1, 15),
(5, 5, 17);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, 'CP'),
(2, 'CE1'),
(3, 'CE2'),
(4, 'CM1'),
(5, 'CM2');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text,
  `prenom` text,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `type`) VALUES
(1, 'Chainet', 'Pauline', 0),
(2, 'Choquet', 'Gregoire', 0),
(12, 'Tilleul', 'Gilles', 1),
(13, 'Eugene', 'Jean', 1),
(14, 'Robilliard', 'Julia', 1),
(15, 'Berger', 'Christine', 1),
(16, 'Frey', 'Thomas', 0),
(17, 'Aye', 'Eva', 1);

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `AnneeScolaire.id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `numero`, `debut`, `fin`, `AnneeScolaire.id`) VALUES
(1, 1, '2016-09-05', '2016-12-10', 2016),
(2, 2, '2016-12-10', '2017-02-28', 2016),
(4, 3, '2017-02-28', '2017-06-10', 2016),
(5, 1, '2017-09-03', '2017-12-28', 2017),
(6, 2, '2017-12-28', '2017-02-28', 2017),
(7, 3, '2017-02-28', '2017-06-13', 2017),
(10, 1, '2018-09-03', '2018-12-14', 2018),
(11, 2, '2018-12-14', '2019-03-01', 2018),
(12, 3, '2019-03-01', '2019-06-09', 2018),
(13, 1, '2019-09-01', '2019-12-15', 2019);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `bulletin_ibfk_1` FOREIGN KEY (`Trimestre.id`) REFERENCES `trimestre` (`id`),
  ADD CONSTRAINT `bulletin_ibfk_2` FOREIGN KEY (`Inscription.id`) REFERENCES `inscription` (`id`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`Ecole.id`) REFERENCES `ecole` (`id_ecole`),
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`Niveau.id`) REFERENCES `niveau` (`id`);

--
-- Contraintes pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `detailbulletin_ibfk_1` FOREIGN KEY (`Bulletin.id`) REFERENCES `bulletin` (`id`),
  ADD CONSTRAINT `detailbulletin_ibfk_2` FOREIGN KEY (`Enseignement.id`) REFERENCES `enseignement` (`id`);

--
-- Contraintes pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `enseignement_ibfk_1` FOREIGN KEY (`Classe.id`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_2` FOREIGN KEY (`Discipline.id`) REFERENCES `discipline` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_3` FOREIGN KEY (`Personne.id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`DetailBulletin.id`) REFERENCES `detailbulletin` (`id`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`Classe.id`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `inscription_ibfk_2` FOREIGN KEY (`Personne.id`) REFERENCES `personne` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
