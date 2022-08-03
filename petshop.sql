-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13-Jun-2022 às 22:15
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `petshop`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(100) NOT NULL,
  `cpf_cliente` varchar(100) NOT NULL,
  `fone_cliente` varchar(100) NOT NULL,
  `nome_pet` varchar(100) NOT NULL,
  `tipo_pet` varchar(100) NOT NULL,
  `idade_pet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`id_cliente`, `nome_cliente`, `cpf_cliente`, `fone_cliente`, `nome_pet`, `tipo_pet`, `idade_pet`) VALUES
(1, 'Pedro', '4444444444', '54545445455', 'Marcinho', 'Cachorro', 3),
(2, 'Marcos', '3333333333', '18981557722', 'Zézinho', 'Cachorro', 14),
(3, 'Jales', '11111111111', '121212121212', 'Mel', 'Gato', 1),
(4, 'Marcia', '2222222222', '33232323232', 'Nemo', 'Peixe', 20);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_func`
--

CREATE TABLE `tb_func` (
  `id_func` int(11) NOT NULL,
  `nome_func` varchar(30) NOT NULL,
  `cod_func` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_func`
--

INSERT INTO `tb_func` (`id_func`, `nome_func`, `cod_func`) VALUES
(2, 'Bruna', 'a123'),
(3, 'pamela', 'b2512');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_produto`
--

CREATE TABLE `tb_produto` (
  `id_produ` int(11) NOT NULL,
  `nome_produ` varchar(100) NOT NULL,
  `cate_produ` varchar(100) NOT NULL,
  `cod_produ` int(11) NOT NULL,
  `valor_produ` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_produto`
--

INSERT INTO `tb_produto` (`id_produ`, `nome_produ`, `cate_produ`, `cod_produ`, `valor_produ`) VALUES
(3, 'Shampoo para cachorro', 'Higiene', 123, 12.36),
(4, 'Super cat', 'Ração', 888, 150.52),
(5, 'Gold dog', 'Ração', 999, 200),
(6, 'Aquário', 'Casa', 654, 560.36),
(8, 'Peixoto', 'Ração', 874, 69.54),
(9, 'Coleira para cachorro', 'Acessório', 235, 25.65),
(10, 'Gaiola', 'Casa', 145, 79.99);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices para tabela `tb_func`
--
ALTER TABLE `tb_func`
  ADD PRIMARY KEY (`id_func`);

--
-- Índices para tabela `tb_produto`
--
ALTER TABLE `tb_produto`
  ADD PRIMARY KEY (`id_produ`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tb_func`
--
ALTER TABLE `tb_func`
  MODIFY `id_func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_produto`
--
ALTER TABLE `tb_produto`
  MODIFY `id_produ` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
