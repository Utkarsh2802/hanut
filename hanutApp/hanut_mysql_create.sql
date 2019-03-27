CREATE TABLE `customer` (
	`id` varchar(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`phone` numeric(10) NOT NULL UNIQUE,
	`email` varchar(50) UNIQUE,
	`address` varchar(50) UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `cred` (
	`id` varchar(10) NOT NULL AUTO_INCREMENT,
	`password` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `seller` (
	`id` varchar(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`phone` numeric(10) NOT NULL UNIQUE,
	`email` varchar(50) UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `manufacturer` (
	`id` varchar(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`phone` numeric(10) NOT NULL UNIQUE,
	`email` varchar(50) UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `product` (
	`P_ID` numeric(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(10) NOT NULL UNIQUE,
	`cost` double(10) NOT NULL,
	`category` varchar(10) NOT NULL,
	`S_ID` varchar(10) NOT NULL AUTO_INCREMENT,
	`quantity` int(5) NOT NULL DEFAULT '0',
	PRIMARY KEY (`P_ID`,`S_ID`)
);

CREATE TABLE `orders` (
	`cust_ID` varchar(10) NOT NULL,
	`order_ID` varchar(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`order_ID`)
);

CREATE TABLE `items` (
	`order_ID` varchar(10) NOT NULL,
	`P_ID` varchar(10) NOT NULL,
	PRIMARY KEY (`order_ID`,`P_ID`)
);

CREATE TABLE `Cart` (
	`cust_ID` varchar(10) NOT NULL AUTO_INCREMENT,
	`P_ID` numeric(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`cust_ID`,`P_ID`)
);

CREATE TABLE `wishlist` (
	`cust_ID` varchar(10) NOT NULL,
	`P_ID` numeric(10) NOT NULL,
	PRIMARY KEY (`cust_ID`,`P_ID`)
);

CREATE TABLE `delivery` (
	`order_ID` varchar(10) NOT NULL,
	`P_ID` varchar(10) NOT NULL,
	`dateoforder` DATE NOT NULL,
	`days` numeric(3) NOT NULL,
	`status` varchar(10) NOT NULL,
	PRIMARY KEY (`order_ID`,`P_ID`)
);

CREATE TABLE `S_ACC` (
	`S_ID` varchar(10) NOT NULL AUTO_INCREMENT,
	`income` numeric(10) DEFAULT '0',
	`expen` numeric(10),
	`profit` numeric(10),
	PRIMARY KEY (`S_ID`)
);

ALTER TABLE `customer` ADD CONSTRAINT `customer_fk0` FOREIGN KEY (`id`) REFERENCES `cred`(`id`);

ALTER TABLE `seller` ADD CONSTRAINT `seller_fk0` FOREIGN KEY (`id`) REFERENCES `cred`(`id`);

ALTER TABLE `manufacturer` ADD CONSTRAINT `manufacturer_fk0` FOREIGN KEY (`id`) REFERENCES `cred`(`id`);

ALTER TABLE `product` ADD CONSTRAINT `product_fk0` FOREIGN KEY (`S_ID`) REFERENCES `seller`(`id`);

ALTER TABLE `orders` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`cust_ID`) REFERENCES `customer`(`id`);

ALTER TABLE `items` ADD CONSTRAINT `items_fk0` FOREIGN KEY (`order_ID`) REFERENCES `orders`(`order_ID`);

ALTER TABLE `items` ADD CONSTRAINT `items_fk1` FOREIGN KEY (`P_ID`) REFERENCES `product`(`P_ID`);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk0` FOREIGN KEY (`cust_ID`) REFERENCES `customer`(`id`);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk1` FOREIGN KEY (`P_ID`) REFERENCES `product`(`P_ID`);

ALTER TABLE `wishlist` ADD CONSTRAINT `wishlist_fk0` FOREIGN KEY (`cust_ID`) REFERENCES `customer`(`id`);

ALTER TABLE `wishlist` ADD CONSTRAINT `wishlist_fk1` FOREIGN KEY (`P_ID`) REFERENCES `product`(`P_ID`);

ALTER TABLE `delivery` ADD CONSTRAINT `delivery_fk0` FOREIGN KEY (`order_ID`) REFERENCES `items`(`order_ID`);

ALTER TABLE `delivery` ADD CONSTRAINT `delivery_fk1` FOREIGN KEY (`P_ID`) REFERENCES `items`(`P_ID`);

ALTER TABLE `S_ACC` ADD CONSTRAINT `S_ACC_fk0` FOREIGN KEY (`S_ID`) REFERENCES `seller`(`id`);

