CREATE TABLE `trader` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `full_name` varchar(64),
  `password` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `adviser` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `full_name` varchar(64),
  `password` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `trader_cryptos` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `trader_id` int,
  `crypto_id` int,
  `created_at` timestamp
);

CREATE TABLE `report` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `adviser_id` int,
  `crypto_id` int,
  `title` varchar(64),
  `content` text,
  `created_at` timestamp
);

CREATE TABLE `comment` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `trader_id` int,
  `report_id` int,
  `content` text,
  `created_at` timestamp
);

ALTER TABLE `trader_cryptos` ADD FOREIGN KEY (`trader_id`) REFERENCES `trader` (`id`);

ALTER TABLE `report` ADD FOREIGN KEY (`adviser_id`) REFERENCES `adviser` (`id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`trader_id`) REFERENCES `trader` (`id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`report_id`) REFERENCES `report` (`id`);
