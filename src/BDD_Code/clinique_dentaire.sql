-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 09 juin 2020 à 03:40
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `clinique_dentaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `ID` int(5) NOT NULL,
  `nom_admin` varchar(20) NOT NULL DEFAULT 'Admin',
  `prenom_admin` varchar(20) NOT NULL DEFAULT 'Admin',
  `password_admin` varchar(20) NOT NULL DEFAULT 'root'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`ID`, `nom_admin`, `prenom_admin`, `password_admin`) VALUES
(1, 'Admin', 'Admin', 'root');

-- --------------------------------------------------------

--
-- Structure de la table `anamnese`
--

CREATE TABLE `anamnese` (
  `id_anamnese` int(11) NOT NULL,
  `id_pat` int(11) NOT NULL,
  `id_med` int(11) NOT NULL,
  `date_consultation` date NOT NULL,
  `num_dent` int(11) NOT NULL,
  `acte` varchar(20) NOT NULL,
  `montant` int(11) NOT NULL,
  `versement` int(11) NOT NULL,
  `reste` int(11) NOT NULL,
  `observation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `anamnese`
--

INSERT INTO `anamnese` (`id_anamnese`, `id_pat`, `id_med`, `date_consultation`, `num_dent`, `acte`, `montant`, `versement`, `reste`, `observation`) VALUES
(1, 1, 1, '2020-06-08', 15, 'Exérèse de la pulpe ', 1200, 1000, 200, 'vide');

-- --------------------------------------------------------

--
-- Structure de la table `antecedent`
--

CREATE TABLE `antecedent` (
  `id_Ante` int(11) NOT NULL,
  `id_pat` int(11) NOT NULL,
  `Protéses` varchar(20) DEFAULT NULL,
  `Allergie` varchar(20) DEFAULT NULL,
  `Centre Andication` varchar(20) DEFAULT NULL,
  `Maladies Hereditaires` varchar(20) DEFAULT NULL,
  `Nom_medecin trait` varchar(20) NOT NULL,
  `Prenom_medecin trait` varchar(20) NOT NULL,
  `num_tel_medecin trait` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `antecedent`
--

INSERT INTO `antecedent` (`id_Ante`, `id_pat`, `Protéses`, `Allergie`, `Centre Andication`, `Maladies Hereditaires`, `Nom_medecin trait`, `Prenom_medecin trait`, `num_tel_medecin trait`) VALUES
(1, 1, NULL, 'd\'hypersensibilité a', NULL, NULL, 'XX', 'XX', '043262827');

-- --------------------------------------------------------

--
-- Structure de la table `medcin`
--

CREATE TABLE `medcin` (
  `id_med` int(11) NOT NULL,
  `nom_med` varchar(15) NOT NULL,
  `prenom_med` varchar(15) NOT NULL,
  `sexe` varchar(5) NOT NULL,
  `date_nes_med` date NOT NULL,
  `adress_med` varchar(40) NOT NULL,
  `num_tel_med` varchar(10) NOT NULL,
  `pseudo_med` varchar(20) NOT NULL,
  `mdp_medc` varchar(20) NOT NULL,
  `email_medc` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medcin`
--

INSERT INTO `medcin` (`id_med`, `nom_med`, `prenom_med`, `sexe`, `date_nes_med`, `adress_med`, `num_tel_med`, `pseudo_med`, `mdp_medc`, `email_medc`) VALUES
(1, 'BOUAZZAOUI', 'MOHAMMED', 'm', '1996-06-05', 'TLEMCEN - Alg', '0668552195', 'nadir', 'nadir', 'mohammed.nadir@gmail.com'),
(2, 'OUSSAMA', 'walid', 'M', '1992-08-10', 'Oran - Alg', '0676925466', 'walid', 'walid', 'walid.ous@yahoo.com'),
(3, 'Bz', 'NADIR', 'M', '1992-07-04', 'Alger - Alg', '0556179293', 'bz', 'bz', 'test1@mail.dz');

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

CREATE TABLE `ordonnance` (
  `id_ord` int(11) NOT NULL,
  `id_pat` int(11) NOT NULL,
  `id_med` int(11) NOT NULL,
  `date_ordonnace` date NOT NULL,
  `medicament1` varchar(20) NOT NULL,
  `medicament2` varchar(20) NOT NULL,
  `medicament3` varchar(20) NOT NULL,
  `medicament4` varchar(20) NOT NULL,
  `medicament5` varchar(20) NOT NULL,
  `medicament6` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ordonnance`
--

INSERT INTO `ordonnance` (`id_ord`, `id_pat`, `id_med`, `date_ordonnace`, `medicament1`, `medicament2`, `medicament3`, `medicament4`, `medicament5`, `medicament6`) VALUES
(1, 1, 1, '2020-06-08', 'Amoxicilline (CP) 1g', 'Flogyl (CP) 500mg', 'Rovamycine (CP) 3MUI', 'Flogyl (CP) 500mg', 'null', 'null');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id_pat` int(11) NOT NULL,
  `id_medecinTraitant` int(11) NOT NULL,
  `nom_pat` varchar(15) NOT NULL,
  `prenom_pat` varchar(15) NOT NULL,
  `sexe` varchar(6) NOT NULL,
  `date_nes_pat` date NOT NULL,
  `etat_civil` varchar(11) NOT NULL,
  `adress_pat` varchar(40) NOT NULL,
  `num_tel_pat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id_pat`, `id_medecinTraitant`, `nom_pat`, `prenom_pat`, `sexe`, `date_nes_pat`, `etat_civil`, `adress_pat`, `num_tel_pat`) VALUES
(1, 0, 'Bouazzaoui', 'Med', 'M', '1996-06-05', 'C', 'Tlemcen - DZ', '0668552195'),
(2, 0, 'NADIR', 'nad', 'M', '1995-01-05', 'M', 'SBA - DZ', '0556179293');

-- --------------------------------------------------------

--
-- Structure de la table `rdvs`
--

CREATE TABLE `rdvs` (
  `id_rdv` int(11) NOT NULL,
  `date` date NOT NULL,
  `time_rdv` time(6) NOT NULL DEFAULT '08:00:00.000000',
  `num_rdv` int(10) NOT NULL,
  `id_patRDV` int(11) NOT NULL,
  `info_pat` text NOT NULL,
  `activateRDV` varchar(3) NOT NULL DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rdvs`
--

INSERT INTO `rdvs` (`id_rdv`, `date`, `time_rdv`, `num_rdv`, `id_patRDV`, `info_pat`, `activateRDV`) VALUES
(1, '2020-06-08', '00:00:00.000000', 1, 1, 'information patient test', 'Yes'),
(2, '2020-06-11', '09:29:00.000000', 2, 2, 'patient nerveux', 'No');

-- --------------------------------------------------------

--
-- Structure de la table `receptionicte`
--

CREATE TABLE `receptionicte` (
  `id_recep` int(11) NOT NULL,
  `nom_recep` varchar(15) NOT NULL,
  `prenom_recep` varchar(15) NOT NULL,
  `sexe` varchar(6) NOT NULL,
  `date_nes_recep` date NOT NULL,
  `adress_recep` varchar(40) NOT NULL,
  `num_tel_recep` varchar(10) NOT NULL,
  `pseudo_recep` varchar(20) NOT NULL,
  `mdp_recep` varchar(20) NOT NULL,
  `email_recep` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `receptionicte`
--

INSERT INTO `receptionicte` (`id_recep`, `nom_recep`, `prenom_recep`, `sexe`, `date_nes_recep`, `adress_recep`, `num_tel_recep`, `pseudo_recep`, `mdp_recep`, `email_recep`) VALUES
(1, 'CHAIMMA', 'meriem', 'F', '1997-09-07', 'Tlemcen - Alg', '0558746235', 'test', 'test', 'chaimma.mer@hotmail.com'),
(3, 'Bz', 'Nadir', 'M', '1994-06-09', 'Oran', '043276164', 'bz', 'bz', 'test@mail.dz'),
(4, 'Fouad', 'Mohammed', 'M', '1992-04-14', 'Alger', '0556179293', 'bz', 'bz', 'test@mail.dz');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `anamnese`
--
ALTER TABLE `anamnese`
  ADD PRIMARY KEY (`id_anamnese`),
  ADD KEY `id_pat` (`id_pat`),
  ADD KEY `id_med` (`id_med`),
  ADD KEY `id_pat_2` (`id_pat`),
  ADD KEY `id_pat_3` (`id_pat`),
  ADD KEY `id_med_2` (`id_med`),
  ADD KEY `id_pat_4` (`id_pat`);

--
-- Index pour la table `antecedent`
--
ALTER TABLE `antecedent`
  ADD PRIMARY KEY (`id_Ante`),
  ADD KEY `id_pat` (`id_pat`),
  ADD KEY `id_pat_2` (`id_pat`),
  ADD KEY `id_pat_3` (`id_pat`),
  ADD KEY `id_pat_4` (`id_pat`);

--
-- Index pour la table `medcin`
--
ALTER TABLE `medcin`
  ADD PRIMARY KEY (`id_med`);

--
-- Index pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD PRIMARY KEY (`id_ord`),
  ADD KEY `id_pat` (`id_pat`),
  ADD KEY `id_med` (`id_med`),
  ADD KEY `id_med_2` (`id_med`),
  ADD KEY `id_pat_2` (`id_pat`),
  ADD KEY `id_med_3` (`id_med`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id_pat`);

--
-- Index pour la table `rdvs`
--
ALTER TABLE `rdvs`
  ADD PRIMARY KEY (`id_rdv`),
  ADD KEY `id_pat` (`id_patRDV`),
  ADD KEY `id_pat_2` (`id_patRDV`),
  ADD KEY `id_pat_3` (`id_patRDV`);

--
-- Index pour la table `receptionicte`
--
ALTER TABLE `receptionicte`
  ADD PRIMARY KEY (`id_recep`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `anamnese`
--
ALTER TABLE `anamnese`
  MODIFY `id_anamnese` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `antecedent`
--
ALTER TABLE `antecedent`
  MODIFY `id_Ante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `medcin`
--
ALTER TABLE `medcin`
  MODIFY `id_med` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  MODIFY `id_ord` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_pat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `rdvs`
--
ALTER TABLE `rdvs`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `receptionicte`
--
ALTER TABLE `receptionicte`
  MODIFY `id_recep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
