-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  mer. 22 mai 2019 à 12:42
-- Version du serveur :  5.7.25
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ProjetJAVA`
--

-- --------------------------------------------------------

--
-- Structure de la table `AnneeScolaire`
--

CREATE TABLE `AnneeScolaire` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Bulletin`
--

CREATE TABLE `Bulletin` (
  `id` int(11) NOT NULL,
  `Trimestre.id` int(11) NOT NULL,
  `Inscription.id` int(11) NOT NULL,
  `appreciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Classe`
--

CREATE TABLE `Classe` (
  `id` int(11) NOT NULL,
  `nom` text,
  `Ecole.id` int(11) NOT NULL,
  `Niveau.id` int(11) NOT NULL,
  `AnneeScolaire.id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `DetailBulletin`
--

CREATE TABLE `DetailBulletin` (
  `id` int(11) NOT NULL,
  `Bulletin.id` int(11) NOT NULL,
  `Enseignant.id` int(11) NOT NULL,
  `appreciation` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Discipline`
--

CREATE TABLE `Discipline` (
  `id` int(11) NOT NULL,
  `nom` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Ecole`
--

CREATE TABLE `Ecole` (
  `id_ecole` int(11) NOT NULL,
  `nom_ecole` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Enseignant`
--

CREATE TABLE `Enseignant` (
  `id` int(11) NOT NULL,
  `Classe.id` int(11) NOT NULL,
  `Discipline.id` int(11) NOT NULL,
  `Personne.id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Evaluation`
--

CREATE TABLE `Evaluation` (
  `id` int(11) NOT NULL,
  `DetailBulletin.id` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `appreciation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Inscription`
--

CREATE TABLE `Inscription` (
  `id` int(11) NOT NULL,
  `Classe.id` int(11) NOT NULL,
  `Personne.id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Niveau`
--

CREATE TABLE `Niveau` (
  `id` int(11) NOT NULL,
  `nom` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Personne`
--

CREATE TABLE `Personne` (
  `id` int(11) NOT NULL,
  `nom` text,
  `prenom` text,
  `type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Trimestre`
--

CREATE TABLE `Trimestre` (
  `id` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `AnneeScolaire.id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `AnneeScolaire`
--
ALTER TABLE `AnneeScolaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Bulletin`
--
ALTER TABLE `Bulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Trimestre.id` (`Trimestre.id`),
  ADD KEY `Inscription.id` (`Inscription.id`);

--
-- Index pour la table `Classe`
--
ALTER TABLE `Classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ecole.id` (`Ecole.id`),
  ADD KEY `AnneeScolaire.id` (`AnneeScolaire.id`),
  ADD KEY `Niveau.id` (`Niveau.id`);

--
-- Index pour la table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Bulletin.id` (`Bulletin.id`),
  ADD KEY `Enseignant.id` (`Enseignant.id`);

--
-- Index pour la table `Discipline`
--
ALTER TABLE `Discipline`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Ecole`
--
ALTER TABLE `Ecole`
  ADD PRIMARY KEY (`id_ecole`);

--
-- Index pour la table `Enseignant`
--
ALTER TABLE `Enseignant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Discipline.id` (`Discipline.id`),
  ADD KEY `Personne.id` (`Personne.id`),
  ADD KEY `Classe.id` (`Classe.id`);

--
-- Index pour la table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `DetailBulletin.id` (`DetailBulletin.id`);

--
-- Index pour la table `Inscription`
--
ALTER TABLE `Inscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Classe.id` (`Classe.id`),
  ADD KEY `Personne.id` (`Personne.id`);

--
-- Index pour la table `Niveau`
--
ALTER TABLE `Niveau`
  ADD UNIQUE KEY `id` (`id`);

--
-- Index pour la table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Trimestre`
--
ALTER TABLE `Trimestre`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `AnneeScolaire.id` (`AnneeScolaire.id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `AnneeScolaire`
--
ALTER TABLE `AnneeScolaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Bulletin`
--
ALTER TABLE `Bulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Classe`
--
ALTER TABLE `Classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Discipline`
--
ALTER TABLE `Discipline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Ecole`
--
ALTER TABLE `Ecole`
  MODIFY `id_ecole` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Enseignant`
--
ALTER TABLE `Enseignant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Evaluation`
--
ALTER TABLE `Evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Inscription`
--
ALTER TABLE `Inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Niveau`
--
ALTER TABLE `Niveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Personne`
--
ALTER TABLE `Personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Trimestre`
--
ALTER TABLE `Trimestre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Bulletin`
--
ALTER TABLE `Bulletin`
  ADD CONSTRAINT `bulletin_ibfk_1` FOREIGN KEY (`Trimestre.id`) REFERENCES `Trimestre` (`id`),
  ADD CONSTRAINT `bulletin_ibfk_2` FOREIGN KEY (`Inscription.id`) REFERENCES `Inscription` (`id`);

--
-- Contraintes pour la table `Classe`
--
ALTER TABLE `Classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`Ecole.id`) REFERENCES `Ecole` (`id_ecole`),
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`Niveau.id`) REFERENCES `Niveau` (`id`);

--
-- Contraintes pour la table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  ADD CONSTRAINT `detailbulletin_ibfk_1` FOREIGN KEY (`Bulletin.id`) REFERENCES `Bulletin` (`id`),
  ADD CONSTRAINT `detailbulletin_ibfk_2` FOREIGN KEY (`Enseignant.id`) REFERENCES `Enseignant` (`id`);

--
-- Contraintes pour la table `Enseignant`
--
ALTER TABLE `Enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`Classe.id`) REFERENCES `Classe` (`id`),
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`Discipline.id`) REFERENCES `Discipline` (`id`),
  ADD CONSTRAINT `enseignant_ibfk_3` FOREIGN KEY (`Personne.id`) REFERENCES `Personne` (`id`);

--
-- Contraintes pour la table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`DetailBulletin.id`) REFERENCES `DetailBulletin` (`id`);

--
-- Contraintes pour la table `Inscription`
--
ALTER TABLE `Inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`Classe.id`) REFERENCES `Classe` (`id`),
  ADD CONSTRAINT `inscription_ibfk_2` FOREIGN KEY (`Personne.id`) REFERENCES `Personne` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
