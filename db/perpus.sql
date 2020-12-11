-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20 Jan 2020 pada 16.04
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_anggota`
--

CREATE TABLE `tb_anggota` (
  `id_anggota` varchar(20) NOT NULL,
  `nama_anggota` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `NIS` int(20) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `kelamin` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_anggota`
--

INSERT INTO `tb_anggota` (`id_anggota`, `nama_anggota`, `alamat`, `NIS`, `kelas`, `kelamin`) VALUES
('A001', 'ADE LIA SARI', 'Guno  Rt 01 Rw 02 Jatiroto', 8208, '9A', 'P'),
('A002', 'AGUNG PRABOWO', 'Mojopuro Rt 01 Rw 05 Jatiroto', 8209, '9A', 'P'),
('A003', 'AYU DEWI SEPTIANI', 'Duren Rt 01 Rw 05 Jatiroto', 8210, '9A', 'P'),
('A004', 'AGUS TRI SAPUTRO', 'Duren Rt 03 Rw 05 Jatiroto', 8274, '9B', 'L'),
('A005', 'ALFINA RAHMA DHYANI', 'Mojopuro Rt 01 Rw 06 Jatiroto', 8241, '9B', 'P'),
('A006', 'LIA AMBARWATI', 'Brenggolo Rt 01 Rw 04 Jatiroto', 8227, '9B', 'P'),
('A007', 'NURFIKA', 'Boto Rt 01 Rw 04 Jatiroto', 8262, '9B', 'P'),
('A008', 'AGUNG SRIYANTO ', 'Pengkol Rt 05 Rw 01 Jatiroto', 8240, '9B', 'P'),
('A009', 'ESTU YULIANTO', 'Sugihan Rt 05 Rw 01 Jatiroto', 8217, '9C', 'L'),
('A010', 'SOLEH USAMA', 'Pingkuk Rt 01 Rw 01 Jatiroto', 8249, '9C', 'L'),
('A011', 'AMRIH MAULANA', 'Ngelo Rt 02 Rw 01 Jatiroto', 8249, '9C', 'L'),
('A012', 'TEGUH BIMA NUGRAHA', 'Pengkol Rt 02 Rw 03 Jatiroto', 8367, '9D', 'L'),
('A013', 'HERLINA SALSABILA', 'Cangkring Rt 02 Rw 03 Jatiroto', 8284, '9D', 'P'),
('A014', 'VINA AGUSTINA', 'Ngelo Rt 07 Rw 03 Jatiroto', 8302, '9D', 'P'),
('A015', 'YAHYA ELANG PERDANA', 'Boto Rt 04 Rw 02 Jatiroto', 8336, '9E', 'L'),
('A016', 'BIMA DWI SETIYAWAN', 'Cangkring Rt 02 Rw 01 Jatiroto', 8408, '9E', 'L'),
('A017', 'DANA RHESTI ANDINI', 'Cangkring Rt 02 Rw 05 Jatiroto', 8380, '9E', 'P'),
('A018', 'APRILIA NUR HIDAYATI', 'Pengkol Rt 02 Rw 05 Jatiroto', 8376, '9F', 'P'),
('A019', 'KUKUH AJI PRAYOGO', 'Dawungan Rt 01 Rw 01 Jatiroto', 8356, '9F', 'L'),
('A020', 'AULIA KHOIRUNISAK', 'Jatirejo Rt 01 Rw 01 Jatiroto', 8213, '9F', 'P');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_buku`
--

CREATE TABLE `tb_buku` (
  `id_buku` varchar(20) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `pengarang` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `tahun` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_buku`
--

INSERT INTO `tb_buku` (`id_buku`, `judul`, `pengarang`, `penerbit`, `kategori`, `tahun`) VALUES
(' B3502/303', 'Fakta Tentang Murni', 'John Malarn', 'ExaMedia', 'Sosial', 2010),
(' B3503/901', 'Fakta Tentang Senjata', 'Rupert Matheus', 'ExaMedia', 'Sosial', 2010),
(' B3504/904', 'Fakta Tentang Penjelajah', 'Dan North', 'ExaMedia', 'Sosial', 2010),
(' B3505/372.3', '99 Percobaan Sehari-hari', 'Wahyudin', 'Armadelta Selaras', 'Sains ', 2009),
(' B3506/590.7', '100 Fakta Tentang Kuda', 'Cammilzi de Bedoyere', 'ExaMedia', 'Sains ', 2008),
(' B3507/590.7', '100 Fakta Tentang Paus', 'Steve Parker', 'ExaMedia', 'Sains ', 2008),
(' B3508/613.1', 'Pencemaran', 'Cindy Leany', 'ExaMedia', 'Umum', 2008),
(' B3509/400.2', 'Nikmatnya Kue dan Roti', 'Cindy Leany', 'ExaMedia', 'Bahasa', 2008),
(' B3510/400.2', 'Suvenir Cantik', 'Winarti', 'ExaMedia', 'Bahasa', 2008),
(' B3511/324.6', 'PILKADA', 'Yudi Suparyanto', 'Permata Equator', 'Umum', 2008),
(' B3512/411', 'Menulis Ringkasan dan Sinopsis', 'Uti Darmawati', 'Permata Equator', 'Bahasa', 2008),
(' B3513/519.5', 'Statistika', 'Maria Noor Hidayah', 'Permata Equator', 'Matematika', 2008),
(' B3514/002', 'Kebakaran', 'Rinawan Abadi', 'Permata Equator', 'Umum', 2008),
(' B3515/002', 'Sumber Sumber Energi', 'Anindita Khoirunisa', 'Permata Equator', 'Umum', 2008),
(' B3516/2X4.01', 'Panduan Puasa Lengkap', 'Efri Al Bakory', 'Erlangga', 'Agama', 2014),
(' B3517/2X4.01', 'Panduan Zakat Lengkap', 'Fim Emir', 'Erlangga', 'Agama', 2016),
(' B3518/2X4.01', 'Panduan Shalat Untuk Muslimah', 'Tim Baitul Mukmin', 'Erlangga', 'Agama', 2018),
(' B3519/513', 'Rumus Praktis Matematika', 'Haris Asri Candra', 'Erlangga', 'Matematika', 2017),
(' B3520/513', 'Buku Sakti Matematika', 'Candra Hirawan', 'Kaifa', 'Matematika', 2011);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kembali`
--

CREATE TABLE `tb_kembali` (
  `id_kembali` varchar(20) NOT NULL,
  `id_pinjam` varchar(20) NOT NULL,
  `id_buku` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `denda` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_kembali`
--

INSERT INTO `tb_kembali` (`id_kembali`, `id_pinjam`, `id_buku`, `id_anggota`, `tgl_pinjam`, `tgl_kembali`, `denda`) VALUES
('K0001', 'P0001', 'B3502/303', 'A001', '2020-01-01', '2020-01-04', 0),
('K0002', 'P0002', 'B3510/400.2', 'A001', '2020-01-04', '2020-01-11', 0),
('K0003', 'P0003', 'B3511/324.6', 'A020', '2020-01-05', '2020-01-13', 500),
('K0004', 'P0004', 'B3503', 'A002', '2020-01-08', '2020-01-17', 1000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`username`, `password`, `status`) VALUES
('admin', 'admin', 'admin'),
('petugas', 'admin', 'petugas'),
('wijaya', '1234', 'kepala');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_petugas`
--

CREATE TABLE `tb_petugas` (
  `id_petugas` varchar(20) NOT NULL,
  `nama_petugas` varchar(100) NOT NULL,
  `kelamin` varchar(1) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `no_telp` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pinjam`
--

CREATE TABLE `tb_pinjam` (
  `id_pinjam` varchar(20) NOT NULL,
  `id_buku` varchar(20) NOT NULL,
  `pengarang` varchar(20) NOT NULL,
  `tahun` int(4) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `tgl_pinjam` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_pinjam`
--

INSERT INTO `tb_pinjam` (`id_pinjam`, `id_buku`, `pengarang`, `tahun`, `id_anggota`, `kelas`, `tgl_pinjam`) VALUES
('P0001', 'B3502/303', 'John Malarn', 2010, 'A001', '9A', '2020-01-01'),
('P0002', 'B3510/400.2', 'Winarti', 2008, 'A010', '9C', '2020-01-03'),
('P0003', 'B3511/324.6', 'Yudi Suparyanto', 2008, 'A020', '9F', '2020-01-04'),
('P0004', 'B3503', 'Rupert Matheus', 2010, 'A002', '9A', '2020-01-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_anggota`
--
ALTER TABLE `tb_anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `tb_buku`
--
ALTER TABLE `tb_buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `tb_kembali`
--
ALTER TABLE `tb_kembali`
  ADD PRIMARY KEY (`id_kembali`),
  ADD KEY `id_buku` (`id_buku`),
  ADD KEY `id_anggota` (`id_anggota`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `tb_pinjam`
--
ALTER TABLE `tb_pinjam`
  ADD PRIMARY KEY (`id_pinjam`),
  ADD KEY `id_buku` (`id_buku`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `id_buku_2` (`id_buku`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
