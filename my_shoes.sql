-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-08-2020 a las 07:15:38
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `my_shoes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `display_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(10) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `dni` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `profile_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detail`
--

CREATE TABLE `detail` (
  `id_detail` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite`
--

CREATE TABLE `favorite` (
  `id_favorite` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `quantity` int(10) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_payment` int(11) NOT NULL,
  `date_order` date NOT NULL DEFAULT current_timestamp(),
  `date_sales` date DEFAULT NULL,
  `code_descount` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `amount_initial` double NOT NULL,
  `amount_descount` double NOT NULL DEFAULT 0,
  `amount_total` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payment`
--

CREATE TABLE `payment` (
  `id_payment` int(11) NOT NULL,
  `method_payment` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `reference` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `date_payment` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  `display_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `price` double NOT NULL DEFAULT 0,
  `last_price` double NOT NULL DEFAULT 0,
  `stock` int(10) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Indices de la tabla `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indices de la tabla `detail`
--
ALTER TABLE `detail`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_order` (`id_order`);

--
-- Indices de la tabla `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id_favorite`),
  ADD KEY `id_customer` (`id_customer`),
  ADD KEY `id_product` (`id_product`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_customer` (`id_customer`),
  ADD KEY `id_payment` (`id_payment`);

--
-- Indices de la tabla `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id_payment`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_categorie` (`id_categorie`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detail`
--
ALTER TABLE `detail`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `favorite`
--
ALTER TABLE `favorite`
  MODIFY `id_favorite` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `payment`
--
ALTER TABLE `payment`
  MODIFY `id_payment` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
