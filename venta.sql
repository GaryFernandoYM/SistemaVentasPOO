--
-- Base de datos: `pySistemaVentas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--


CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `origen` varchar(200) NOT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datostienda`
--
CREATE TABLE `datostienda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruc` varchar(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `razon` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;


--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalleproduc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cod_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_ventas` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;

--
-- Estructura de tabla para la tabla `productos`
--


CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(30) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `proveedor` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruc` int(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `telefono` int(15) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(100) NOT NULL,
  `vendedor` varchar(100) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;

