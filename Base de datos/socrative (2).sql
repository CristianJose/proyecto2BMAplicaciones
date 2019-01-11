-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-01-2019 a las 22:19:39
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `socrative`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuestionario`
--

CREATE TABLE `cuestionario` (
  `id_cuestionario` int(10) NOT NULL,
  `cod_cuestionario` int(10) NOT NULL,
  `nom_cuestionario` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cuestionario`
--

INSERT INTO `cuestionario` (`id_cuestionario`, `cod_cuestionario`, `nom_cuestionario`) VALUES
(5, 123, 'asdad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `id_pregunta` int(10) NOT NULL,
  `nom_pregunta` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `id_cuestionario` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`id_pregunta`, `nom_pregunta`, `id_cuestionario`) VALUES
(1, 'adssadsa', 5),
(2, 'dadsad', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntac`
--

CREATE TABLE `preguntac` (
  `id_preguntac` int(11) NOT NULL,
  `id_cuestionario` int(11) NOT NULL,
  `nom_preguntac` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntavf`
--

CREATE TABLE `preguntavf` (
  `id_vf` int(10) NOT NULL,
  `nom_vf` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `res_vf` tinyint(1) NOT NULL,
  `id_cuestionario` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestam`
--

CREATE TABLE `respuestam` (
  `id_respuestaM` int(10) NOT NULL,
  `id_pregunta` int(10) NOT NULL,
  `nom_respuestaM` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `valor_respuestaM` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuestionario`
--
ALTER TABLE `cuestionario`
  ADD PRIMARY KEY (`id_cuestionario`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`id_pregunta`),
  ADD KEY `fk_pregunta_cuestionario` (`id_cuestionario`);

--
-- Indices de la tabla `preguntac`
--
ALTER TABLE `preguntac`
  ADD PRIMARY KEY (`id_preguntac`),
  ADD KEY `fk_prec_cues` (`id_cuestionario`);

--
-- Indices de la tabla `preguntavf`
--
ALTER TABLE `preguntavf`
  ADD PRIMARY KEY (`id_vf`),
  ADD KEY `fk_prevf_cues` (`id_cuestionario`);

--
-- Indices de la tabla `respuestam`
--
ALTER TABLE `respuestam`
  ADD PRIMARY KEY (`id_respuestaM`),
  ADD KEY `fk_resm_prem` (`id_pregunta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuestionario`
--
ALTER TABLE `cuestionario`
  MODIFY `id_cuestionario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `id_pregunta` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `preguntac`
--
ALTER TABLE `preguntac`
  MODIFY `id_preguntac` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `preguntavf`
--
ALTER TABLE `preguntavf`
  MODIFY `id_vf` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `respuestam`
--
ALTER TABLE `respuestam`
  MODIFY `id_respuestaM` int(10) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `fk_pregunta_cuestionario` FOREIGN KEY (`id_cuestionario`) REFERENCES `cuestionario` (`id_cuestionario`);

--
-- Filtros para la tabla `preguntac`
--
ALTER TABLE `preguntac`
  ADD CONSTRAINT `fk_prec_cues` FOREIGN KEY (`id_cuestionario`) REFERENCES `cuestionario` (`id_cuestionario`);

--
-- Filtros para la tabla `preguntavf`
--
ALTER TABLE `preguntavf`
  ADD CONSTRAINT `fk_prevf_cues` FOREIGN KEY (`id_cuestionario`) REFERENCES `cuestionario` (`id_cuestionario`);

--
-- Filtros para la tabla `respuestam`
--
ALTER TABLE `respuestam`
  ADD CONSTRAINT `fk_resm_prem` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id_pregunta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
