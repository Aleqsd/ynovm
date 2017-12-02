-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 02 déc. 2017 à 14:49
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ynovm`
--

-- --------------------------------------------------------

--
-- Structure de la table `station`
--

DROP TABLE IF EXISTS `station`;
CREATE TABLE IF NOT EXISTS `station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `temperature` double DEFAULT NULL,
  `hygrometrie` double DEFAULT NULL,
  `nebulosite` int(11) DEFAULT NULL,
  `anemometre` int(11) DEFAULT NULL,
  `pluviometrie` int(11) DEFAULT NULL,
  `remarques` text,
  `etat` int(11) NOT NULL,
  `etat_Pluvio` int(11) NOT NULL,
  `etat_Anemo` int(11) NOT NULL,
  `etat_Nebul` int(11) NOT NULL,
  `etat_Hygro` int(11) NOT NULL,
  `etat_Temp` int(11) NOT NULL,
  `h_restart` bigint(20) DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `station`
--

INSERT INTO `station` (`id`, `x`, `y`, `nom`, `localisation`, `temperature`, `hygrometrie`, `nebulosite`, `anemometre`, `pluviometrie`, `remarques`, `etat`, `etat_Pluvio`, `etat_Anemo`, `etat_Nebul`, `etat_Hygro`, `etat_Temp`, `h_restart`, `type`) VALUES
(1, 7, 8, 'AlphaStation', 'Bretagne', 0, 56, 4, 92, 57, 'RAS', 3, 2, 2, 2, 2, 2, NULL, 0),
(3, 7, 8, 'CharlieStation', 'Marseille', 17, 4, 5, 8, 7, 'RAS', 3, 2, 2, 2, 2, 2, NULL, 0),
(4, 7, 8, 'DeltaStation', 'Paris', 17, 4, 5, 8, 7, 'RAS', 3, 2, 2, 2, 2, 2, NULL, 1),
(2, 7, 8, 'BetaStation', 'Aix', 17, 4, 5, 8, 7, 'RAS', 3, 2, 2, 2, 2, 2, NULL, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
