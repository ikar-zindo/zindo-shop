SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+01:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE DATABASE IF NOT EXISTS `zindo-shop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zindo-shop`;

--
-- Database: `zindo-shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` INT(11) PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `category_name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(2550) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `available` BOOL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_name`, `description`) VALUES
('Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
('Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
('Confections', 'Desserts, candies, and sweet breads'),
('Dairy Products', 'Cheeses'),
('Grains/Cereals', 'Breads, crackers, pasta, and cereal'),
('Meat/Poultry', 'Prepared meats'),
('Produce', 'Dried fruit and bean curd'),
('Seafood', 'Seaweed and fish');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` INT(11) PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `product_name` VARCHAR(255) NOT NULL,
  `category_id` INT(11) DEFAULT NULL,
  `supplier_id` INT(11) DEFAULT NULL,
  `unit` VARCHAR(255) DEFAULT NULL,
  `price` DECIMAL(7,2) DEFAULT 0.01,
  `description` TEXT DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `available` BOOL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_name`, `supplier_id`,  `category_id`, `unit`, `price`) VALUES
('Chais', 1, 1, '10 boxes x 20 bags', 18),
('Chang', 1, 1, '24 - 12 oz bottles', 19),
('Aniseed Syrup', 1, 2, '12 - 550 ml bottles', 10),
('Chef Anton\'s Cajun Seasoning', 2, 2, '48 - 6 oz jars', 22),
('Chef Anton\'s Gumbo Mix', 2, 2, '36 boxes', 21.35),
('Grandma\'s Boysenberry Spread', 3, 2, '12 - 8 oz jars', 25),
('Uncle Bob\'s Organic Dried Pears', 3, 7, '12 - 1 lb pkgs.', 30),
('Northwoods Cranberry Sauce', 3, 2, '12 - 12 oz jars', 40),
('Mishi Kobe Niku', 4, 6, '18 - 500 g pkgs.', 97),
('Ikura', 4, 8, '12 - 200 ml jars', 31),
('Queso Cabrales', 5, 4, '1 kg pkg.', 21),
('Queso Manchego La Pastora', 5, 4, '10 - 500 g pkgs.', 38),
('Konbu', 6, 8, '2 kg box', 6),
('Tofu', 6, 7, '40 - 100 g pkgs.', 23.25),
('Genen Shouyu', 6, 2, '24 - 250 ml bottles', 15.5),
('Pavlova', 7, 3, '32 - 500 g boxes', 17.45),
('Alice Mutton', 7, 6, '20 - 1 kg tins', 39),
('Carnarvon Tigers', 7, 8, '16 kg pkg.', 62.5),
('Teatime Chocolate Biscuits', 8, 3, '10 boxes x 12 pieces', 9.2),
('Sir Rodney\'s Marmalade', 8, 3, '30 gift boxes', 81),
('Sir Rodney\'s Scones', 8, 3, '24 pkgs. x 4 pieces', 10),
('Gustaf\'s Knäckebröd', 9, 5, '24 - 500 g pkgs.', 21),
('Tunnbröd', 9, 5, '12 - 250 g pkgs.', 9),
('Guaraná Fantástica', 10, 1, '12 - 355 ml cans', 4.5),
('NuNuCa Nuß-Nougat-Creme', 11, 3, '20 - 450 g glasses', 14),
('Gumbär Gummibärchen', 11, 3, '100 - 250 g bags', 31.23),
('Schoggi Schokolade', 11, 3, '100 - 100 g pieces', 43.9),
('Rössle Sauerkraut', 12, 7, '25 - 825 g cans', 45.6),
('Thüringer Rostbratwurst', 12, 6, '50 bags x 30 sausgs.', 123.79),
('Nord-Ost Matjeshering', 13, 8, '10 - 200 g glasses', 25.89),
('Gorgonzola Telino', 14, 4, '12 - 100 g pkgs', 12.5),
('Mascarpone Fabioli', 14, 4, '24 - 200 g pkgs.', 32),
('Geitost', 15, 4, '500 g', 2.5),
('Sasquatch Ale', 16, 1, '24 - 12 oz bottles', 14),
('Steeleye Stout', 16, 1, '24 - 12 oz bottles', 18),
('Inlagd Sill', 17, 8, '24 - 250 g jars', 19),
('Gravad lax', 17, 8, '12 - 500 g pkgs.', 26),
('Côte de Blaye', 18, 1, '12 - 75 cl bottles', 263.5),
('Chartreuse verte', 18, 1, '750 cc per bottle', 18),
('Boston Crab Meat', 19, 8, '24 - 4 oz tins', 18.4),
('Jack\'s New England Clam Chowder', 19, 8, '12 - 12 oz cans', 9.65),
('Singaporean Hokkien Fried Mee', 20, 5, '32 - 1 kg pkgs.', 14),
('Ipoh Coffee', 20, 1, '16 - 500 g tins', 46),
('Gula Malacca', 20, 2, '20 - 2 kg bags', 19.45),
('Røgede sild', 21, 8, '1k pkg.', 9.5),
('Spegesild', 21, 8, '4 - 450 g glasses', 12),
('Zaanse koeken', 22, 3, '10 - 4 oz boxes', 9.5),
('Chocolade', 22, 3, '10 pkgs.', 12.75),
('Maxilaku', 23, 3, '24 - 50 g pkgs.', 20),
('Valkoinen suklaa', 23, 3, '12 - 100 g bars', 16.25),
('Manjimup Dried Apples', 24, 7, '50 - 300 g pkgs.', 53),
('Filo Mix', 24, 5, '16 - 2 kg boxes', 7),
('Perth Pasties', 24, 6, '48 pieces', 32.8),
('Tourtière', 25, 6, '16 pies', 7.45),
('Pâté chinois', 25, 6, '24 boxes x 2 pies', 24),
('Gnocchi di nonna Alice', 26, 5, '24 - 250 g pkgs.', 38),
('Ravioli Angelo', 26, 5, '24 - 250 g pkgs.', 19.5),
('Escargots de Bourgogne', 27, 8, '24 pieces', 13.25),
('Raclette Courdavault', 28, 4, '5 kg pkg.', 55),
('Camembert Pierrot', 28, 4, '15 - 300 g rounds', 34),
('Sirop d\'érable', 29, 2, '24 - 500 ml bottles', 28.5),
('Tarte au sucre', 29, 3, '48 pies', 49.3),
('Vegie-spread', 7, 2, '15 - 625 g jars', 43.9),
('Wimmers gute Semmelknödel', 12, 5, '20 bags x 4 pieces', 33.25),
('Louisiana Fiery Hot Pepper Sauce', 2, 2, '32 - 8 oz bottles', 21.05),
('Louisiana Hot Spiced Okra', 2, 2, '24 - 8 oz jars', 17),
('Laughing Lumberjack Lager', 16, 1, '24 - 12 oz bottles', 14),
('Scottish Longbreads', 8, 3, '10 boxes x 8 pieces', 12.5),
('Gudbrandsdalsost', 15, 4, '10 kg pkg.', 36),
('Outback Lager', 7, 1, '24 - 355 ml bottles', 15),
('Fløtemysost', 15, 4, '10 - 500 g pkgs.', 21.5),
('Mozzarella di Giovanni', 14, 4, '24 - 200 g pkgs.', 34.8),
('Röd Kaviar', 17, 8, '24 - 150 g jars', 15),
('Longlife Tofu', 4, 7, '5 kg pkg.', 10),
('Rhönbräu Klosterbier', 12, 1, '24 - 0.5 l bottles', 7.75),
('Lakkalikööri', 23, 1, '500 ml', 18),
('Original Frankfurter grüne Soße', 12, 2, '12 boxes', 13);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `supplier_name` VARCHAR(255) DEFAULT NULL,
  `contact_name` VARCHAR(255) DEFAULT NULL,
  `address` VARCHAR(255) DEFAULT NULL,
  `city` VARCHAR(255) DEFAULT NULL,
  `postal_code` VARCHAR(255) DEFAULT NULL,
  `country` VARCHAR(255) DEFAULT NULL,
  `phone` VARCHAR(255) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `available` BOOL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_name`, `contact_name`, `address`, `city`, `postal_code`, `country`, `phone`) VALUES
('Exotic Liquid', 'Charlotte Cooper', '49 Gilbert St.', 'Londona', 'EC1 4SD', 'UK', '(171) 555-2222'),
('New Orleans Cajun Delights', 'Shelley Burke', 'P.O. Box 78934', 'New Orleans', '70117', 'USA', '(100) 555-4822'),
('Grandma Kelly\'s Homestead', 'Regina Murphy', '707 Oxford Rd.', 'Ann Arbor', '48104', 'USA', '(313) 555-5735'),
('Tokyo Traders', 'Yoshi Nagase', '9-8 Sekimai Musashino-shi', 'Tokyo', '100', 'Japan', '(03) 3555-5011'),
('Cooperativa de Quesos \'Las Cabras\'', 'Antonio del Valle Saavedra', 'Calle del Rosal 4', 'Oviedo', '33007', 'Spain', '(98) 598 76 54'),
('Mayumi\'s', 'Mayumi Ohno', '92 Setsuko Chuo-ku', 'Osaka', '545', 'Japan', '(06) 431-7877'),
('Pavlova, Ltd.', 'Ian Devling', '74 Rose St. Moonie Ponds', 'Melbourne', '3058', 'Australia', '(03) 444-2343'),
('Specialty Biscuits, Ltd.', 'Peter Wilson', '29 King\'s Way', 'Manchester', 'M14 GSD', 'UK', '(161) 555-4448'),
('PB Knäckebröd AB', 'Lars Peterson', 'Kaloadagatan 13', 'Göteborg', 'S-345 67', 'Sweden', '031-987 65 43'),
('Refrescos Americanas LTDA', 'Carlos Diaz', 'Av. das Americanas 12.890', 'São Paulo', '5442', 'Brazil', '(11) 555 4640'),
('Heli Süßwaren GmbH & Co. KG', 'Petra Winkler', 'Tiergartenstraße 5', 'Berlin', '10785', 'Germany', '(010) 9984510'),
('Plutzer Lebensmittelgroßmärkte AG', 'Martin Bein', 'Bogenallee 51', 'Frankfurt', '60439', 'Germany', '(069) 992755'),
('Nord-Ost-Fisch Handelsgesellschaft mbH', 'Sven Petersen', 'Frahmredder 112a', 'Cuxhaven', '27478', 'Germany', '(04721) 8713'),
('Formaggi Fortini s.r.l.', 'Elio Rossi', 'Viale Dante, 75', 'Ravenna', '48100', 'Italy', '(0544) 60323'),
('Norske Meierier', 'Beate Vileid', 'Hatlevegen 5', 'Sandvika', '1320', 'Norway', '(0)2-953010'),
('Bigfoot Breweries', 'Cheryl Saylor', '3400 - 8th Avenue Suite 210', 'Bend', '97101', 'USA', '(503) 555-9931'),
('Svensk Sjöföda AB', 'Michael Björn', 'Brovallavägen 231', 'Stockholm', 'S-123 45', 'Sweden', '08-123 45 67'),
('Aux joyeux ecclésiastiques', 'Guylène Nodier', '203, Rue des Francs-Bourgeois', 'Paris', '75004', 'France', '(1) 03.83.00.68'),
('New England Seafood Cannery', 'Robb Merchant', 'Order Processing Dept. 2100 Paul Revere Blvd.', 'Boston', '02134', 'USA', '(617) 555-3267'),
('Leka Trading', 'Chandra Leka', '471 Serangoon Loop, Suite #402', 'Singapore', '0512', 'Singapore', '555-8787'),
('Lyngbysild', 'Niels Petersen', 'Lyngbysild Fiskebakken 10', 'Lyngby', '2800', 'Denmark', '43844108'),
('Zaanse Snoepfabriek', 'Dirk Luchte', 'Verkoop Rijnweg 22', 'Zaandam', '9999 ZZ', 'Netherlands', '(12345) 1212'),
('Karkki Oy', 'Anne Heikkonen', 'Valtakatu 12', 'Lappeenranta', '53120', 'Finland', '(953) 10956'),
('G\'day, Mate', 'Wendy Mackenzie', '170 Prince Edward Parade Hunter\'s Hill', 'Sydney', '2042', 'Australia', '(02) 555-5914'),
('Ma Maison', 'Jean-Guy Lauzon', '2960 Rue St. Laurent', 'Montréal', 'H1J 1C3', 'Canada', '(514) 555-9022'),
('Pasta Buttini s.r.l.', 'Giovanni Giudici', 'Via dei Gelsomini, 153', 'Salerno', '84100', 'Italy', '(089) 6547665'),
('Escargots Nouveaux', 'Marie Delamare', '22, rue H. Voiron', 'Montceau', '71300', 'France', '85.57.00.07'),
('Gai pâturage', 'Eliane Noz', 'Bat. B 3, rue des Alpes', 'Annecy', '74000', 'France', '38.76.98.06'),
('Forêts d\'érables', 'Chantal Goulet', '148 rue Chasseur', 'Ste-Hyacinthe', 'J2S 7S8', 'Canada', '(514) 555-2955');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` INT(11) PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `customer_name` VARCHAR(123) DEFAULT NULL,
  `age` INT(3) DEFAULT NULL,
  `email` VARCHAR(123) DEFAULT NULL,
  `address` VARCHAR(123) DEFAULT NULL,
  `city` VARCHAR(123) DEFAULT NULL,
  `postal_code` VARCHAR(64) DEFAULT NULL,
  `country` VARCHAR(123) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `is_blocked` BOOL DEFAULT FALSE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_name`, `age`, `email`, `address`, `city`, `postal_code`, `country`) VALUES
('Alfreds Futterkiste', 45, 'alfreds@gmail', 'Obere Str. 57', 'Berlin', '12209', 'Germany'),
('Ana Trujillo Emparedados y helados', 14, 'ana@gmail', 'Avda. de la Constitución 2222', 'México D.F.', '05021', 'Mexico'),
('Antonio Moreno Taquería', 54, 'antonio@gmail', 'Mataderos 2312', 'México D.F.', '05023', 'Mexico'),
('Around the Horn',  22, 'around@gmail', '120 Hanover Sq.', 'London', 'WA1 1DP', 'UK'),
('Berglunds snabbköp',  32, 'berglunds@gmail', 'Berguvsvägen 8', 'Luleå', 'S-958 22', 'Sweden'),
('Blauer See Delikatessen',  17, 'blauer@gmail', 'Forsterstr. 57', 'Mannheim', '68306', 'Germany'),
('Blondel père et fils',  44, 'blondel@gmail', '24, place Kléber', 'Strasbourg', '67000', 'France'),
('Bólido Comidas preparadas',  36, 'bolido@gmail', 'C/ Araquil, 67', 'Madrid', '28023', 'Spain'),
('Bottom-Dollar Marketse',  29, 'bottom@gmail', '23 Tsawassen Blvd.', 'Tsawassen', 'T2F 8M4', 'Canada');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cart_id` INT(11) PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `paid` BOOL DEFAULT FALSE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`customer_id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9);

-- --------------------------------------------------------

--
-- Table structure for table `cart_product`
--

CREATE TABLE `cart_product` (
  `cart_product_id` INT(11) PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `cart_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart_product`
--

INSERT INTO `cart_product` (`cart_id`, `product_id`) VALUES
(2,4),
(2,5),
(2,6),
(3,1),
(3,3),
(3,5),
(4,6),
(9,5),
(9,6),
(9,7),
(1,7),
(1,7),
(1,7),
(2,2),
(2,2),
(2,1),
(2,2),
(3,3),
(4,4),
(4,5),
(4,6),
(5,7),
(8,7),
(8,6),
(6,5),
(7,1),
(7,2),
(7,3);

-- --------------------------------------------------------

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--

ALTER TABLE `product`
  ADD KEY `category_id` (`category_id`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- Indexes for table `cart_product`
--

ALTER TABLE `cart_product`
  ADD KEY `cart_id` (`cart_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD KEY `customer_id` (`customer_id`);

-- --------------------------------------------------------

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`сategory_id`),
  ADD CONSTRAINT `product_ibfk_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`);

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `products_ibfk_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);
  
--
-- Constraints for table `cart_product`
--
ALTER TABLE `cart_product` 
	ADD CONSTRAINT `cart_product_ibfk_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`),
	ADD CONSTRAINT `cart_product_ibfk_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


-- --------------------------------------------------------

--
-- Additional tables
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `task` (
  `task_id` BIGINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(2000) NOT NULL,
  `created_at` TIMESTAMP(6) NOT NULL,
  PRIMARY KEY (`task_id`)
)ENGINE = InnoDBDEFAULT CHARACTER SET = utf8;


--
-- Dumping data for table `cart`
--





--
-- Indexes for table `product`
--

ALTER TABLE `task`
  ADD KEY `task_id` (`task_id`),