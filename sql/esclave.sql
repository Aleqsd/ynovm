-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 02 déc. 2017 à 19:56
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `esclave`
--

-- --------------------------------------------------------

--
-- Structure de la table `station`
--

DROP TABLE IF EXISTS `station`;
CREATE TABLE IF NOT EXISTS `station` (
  `id` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `localisation` varchar(50) NOT NULL,
  `temperature` double NOT NULL,
  `hygrometrie` double NOT NULL,
  `nebulosite` int(11) NOT NULL,
  `anemotrie` int(11) NOT NULL,
  `pluviometrie` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `etat_Pluvio` int(11) NOT NULL,
  `etat_Anemo` int(11) NOT NULL,
  `etat_Nebul` int(11) NOT NULL,
  `etat_Hygro` int(11) NOT NULL,
  `etat_Temp` int(11) NOT NULL,
  `h_restart` int(11) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `remarques` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `station`
--

INSERT INTO `station` (`id`, `x`, `y`, `nom`, `localisation`, `temperature`, `hygrometrie`, `nebulosite`, `anemotrie`, `pluviometrie`, `etat`, `etat_Pluvio`, `etat_Anemo`, `etat_Nebul`, `etat_Hygro`, `etat_Temp`, `h_restart`, `type`, `remarques`) VALUES
(1, 9, 5, 'esclave', 'Toulouse', 17.6, 3.9, 4, 7, 6, 3, 2, 2, 2, 2, 2, NULL, 1, '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
