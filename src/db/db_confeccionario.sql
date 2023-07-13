-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20221117.561d9ca705
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-07-2023 a las 00:57:17
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_confeccionario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `descripcion`) VALUES
(1, 'Usuario'),
(2, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombres` varchar(80) DEFAULT NULL,
  `ap_paterno` varchar(20) DEFAULT NULL,
  `ap_materno` varchar(20) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `f_insercion` date DEFAULT NULL,
  `f_actualizacion` date DEFAULT NULL,
  `f_eliminacion` date DEFAULT NULL,
  `estado` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombres`, `ap_paterno`, `ap_materno`, `dni`, `telefono`, `f_insercion`, `f_actualizacion`, `f_eliminacion`, `estado`) VALUES
(1, 'Juan', 'Torres', 'González', '12345678', '987654321', '2023-07-11', NULL, NULL, 1),
(2, 'María', 'Rodríguez', 'López', '87654321', '912345678', '2023-07-11', NULL, NULL, 1),
(3, 'Pedro', 'García', 'Pérez', '54321678', '945678912', '2023-07-11', NULL, NULL, 1),
(4, 'Ana', 'Silva', 'Vargas', '87654321', '923456789', '2023-07-11', NULL, NULL, 1),
(5, 'Luis', 'Mendoza', 'Ramírez', '34567891', '956789123', '2023-07-11', NULL, NULL, 1),
(6, 'Carolina', 'Sánchez', 'Vargas', '67891234', '987123456', '2023-07-11', NULL, NULL, 1),
(7, 'Andrés', 'Flores', 'Paredes', '91234567', '912345678', '2023-07-11', NULL, NULL, 1),
(8, 'Gabriela', 'Ruiz', 'Medina', '45678912', '923456781', '2023-07-11', NULL, NULL, 1),
(9, 'Ricardo', 'Herrera', 'Jiménez', '78912345', '934567890', '2023-07-11', NULL, NULL, 1),
(10, 'Laura', 'Castro', 'López', '23456789', '945678912', '2023-07-11', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `total` double DEFAULT NULL CHECK (`total` >= 0),
  `fecha` datetime DEFAULT current_timestamp(),
  `impuesto` double NOT NULL CHECK (`impuesto` >= 0),
  `estado` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra`
--

CREATE TABLE `detalle_compra` (
  `id_insumo` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `subtotal` double DEFAULT NULL CHECK (`subtotal` >= 0),
  `cantidad` int(11) DEFAULT NULL CHECK (`cantidad` >= 0),
  `estado` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id_producto` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `subtotal` double DEFAULT NULL CHECK (`subtotal` >= 0),
  `cantidad` int(11) DEFAULT NULL CHECK (`cantidad` >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo`
--

CREATE TABLE `insumo` (
  `id_insumo` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL CHECK (`precio` >= 0),
  `stock` int(11) DEFAULT NULL CHECK (`stock` >= 0),
  `estado` int(11) DEFAULT 1,
  `f_insercion` date DEFAULT NULL,
  `f_actualizacion` date DEFAULT NULL,
  `f_eliminacion` date DEFAULT NULL,
  `descuento` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `insumo`
--

INSERT INTO `insumo` (`id_insumo`, `nombre`, `descripcion`, `precio`, `stock`, `estado`, `f_insercion`, `f_actualizacion`, `f_eliminacion`, `descuento`) VALUES
(1, 'Tela Bison', '1 metro', 10, 5, 1, '2023-07-11', NULL, NULL, 1),
(2, 'Polar', '1 metro', 9, 3, 1, '2023-07-11', NULL, NULL, 1),
(3, 'Fashion', '1 metro', 11, 4, 1, '2023-07-11', NULL, NULL, 1),
(4, 'Fashion', '1 metro', 11, 10, 1, '2023-07-11', NULL, NULL, 1),
(5, 'Notex', '1 metro', 4, 15, 1, '2023-07-11', NULL, NULL, 1),
(6, 'Polar', '1 metro', 9, 10, 1, '2023-07-11', NULL, NULL, 1),
(7, 'Fashion', '1 metro', 11, 18, 1, '2023-07-11', NULL, NULL, 1),
(8, 'Notex', '1 metro', 4, 8, 1, '2023-07-11', NULL, NULL, 1),
(9, 'Polar', '1 metro', 9, 20, 1, '2023-07-11', NULL, NULL, 1),
(10, 'Polar', '1 metro', 9, 5, 1, '2023-07-11', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL CHECK (`precio` >= 0),
  `stock` int(11) DEFAULT NULL CHECK (`stock` >= 0),
  `estado` int(11) DEFAULT 1,
  `f_insercion` date DEFAULT NULL,
  `f_actualizacion` date DEFAULT NULL,
  `f_eliminacion` date DEFAULT NULL,
  `descuento` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `descripcion`, `precio`, `stock`, `estado`, `f_insercion`, `f_actualizacion`, `f_eliminacion`, `descuento`) VALUES
(1, 'Cama Cuadrada', 'Talla 3', 37, 10, 1, '2023-07-11', NULL, NULL, 1),
(2, 'Cuevas', 'Talla 4', 22, 20, 1, '2023-07-11', NULL, NULL, 1),
(3, 'Colchonetas', 'Talla 5', 37, 30, 1, '2023-07-11', NULL, NULL, 1),
(4, 'Camas redondas', 'Talla 2', 22, 35, 1, '2023-07-11', NULL, NULL, 1),
(5, 'Cuevas', 'Talla 3', 15, 20, 1, '2023-07-11', NULL, NULL, 1),
(6, 'Colchonetas', 'Talla 2', 16, 15, 1, '2023-07-11', NULL, NULL, 1),
(7, 'Casas pegables', 'Talla 2', 30, 20, 1, '2023-07-11', NULL, NULL, 1),
(8, 'Casas pegables', 'Talla 6', 60, 60, 1, '2023-07-11', NULL, NULL, 2),
(9, 'Capitas polares', 'Talla 5', 8, 80, 1, '2023-07-11', NULL, NULL, 1),
(10, 'Enterizos', 'Talla 2', 10, 65, 1, '2023-07-11', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombres` varchar(80) DEFAULT NULL,
  `ap_paterno` varchar(20) DEFAULT NULL,
  `ap_materno` varchar(20) DEFAULT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `f_insercion` date DEFAULT NULL,
  `f_actualizacion` date DEFAULT NULL,
  `f_eliminacion` date DEFAULT NULL,
  `estado` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombres`, `ap_paterno`, `ap_materno`, `ruc`, `dni`, `telefono`, `f_insercion`, `f_actualizacion`, `f_eliminacion`, `estado`) VALUES
(1, 'Carlos', 'Rodríguez', 'López', '20123456789', '12345656', '987654321', '2023-07-11', NULL, NULL, 1),
(2, 'Ana', 'García', 'Pérez', '20198765432', '87654321', '912345678', '2023-07-11', NULL, NULL, 1),
(3, 'Luisa', 'Torres', 'González', '20154321678', '54321678', '945678912', '2023-07-11', NULL, NULL, 1),
(4, 'María', 'Silva', 'Vargas', '20187654321', '87654321', '23456789', '2023-07-11', NULL, NULL, 1),
(5, 'Alejandro', 'Medina', 'Ramírez', '20234567891', '34567891', '956789123', '2023-07-11', NULL, NULL, 1),
(6, 'Patricia', 'Vargas', 'Sánchez', '20267891234', '67891234', '987123456', '2023-07-11', NULL, NULL, 1),
(7, 'Roberto', 'Paredes', 'Flores', '20291234567', '91234567', '912345678', '2023-07-11', NULL, NULL, 1),
(8, 'Gabriela', 'Mendoza', 'Ruiz', '20245678912', '45678912', '923456781', '2023-07-11', NULL, NULL, 1),
(9, 'Laura', 'Jiménez', 'Herrera', '20278912345', '78912345', '934567890', '2023-07-11', NULL, NULL, 1),
(10, 'Julio', 'Castro', 'López', '20223456789', '23456789', '945678912', '2023-07-11', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombres` varchar(80) DEFAULT NULL,
  `ap_paterno` varchar(20) DEFAULT NULL,
  `ap_materno` varchar(20) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `pass` varchar(200) DEFAULT NULL,
  `id_cargo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombres`, `ap_paterno`, `ap_materno`, `usuario`, `pass`, `id_cargo`) VALUES
(7, NULL, NULL, NULL, 'root@gmail.com', '63a9f0ea7bb98050796b649e85481845', 2),
(8, NULL, NULL, NULL, 'admin@gmail.com', '21232f297a57a5a743894a0e4a801fc3', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `total` double DEFAULT NULL CHECK (`total` >= 0),
  `fecha` datetime DEFAULT current_timestamp(),
  `impuesto` double NOT NULL CHECK (`impuesto` >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_proveedor` (`id_proveedor`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD PRIMARY KEY (`id_insumo`,`id_compra`),
  ADD KEY `id_compra` (`id_compra`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id_producto`,`id_venta`),
  ADD KEY `id_venta` (`id_venta`);

--
-- Indices de la tabla `insumo`
--
ALTER TABLE `insumo`
  ADD PRIMARY KEY (`id_insumo`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `id_cargo` (`id_cargo`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `insumo`
--
ALTER TABLE `insumo`
  MODIFY `id_insumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`id_insumo`) REFERENCES `insumo` (`id_insumo`),
  ADD CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`);

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
