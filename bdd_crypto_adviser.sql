create database bdd_crypto_adviser;

CREATE TABLE  bdd_sdzee.Utilisateur (
 id INT( 11 ) NOT NULL AUTO_INCREMENT ,
 email VARCHAR( 60 ) NOT NULL ,
 mot_de_passe VARCHAR( 32 ) NOT NULL ,
 nom VARCHAR( 20 ) NOT NULL ,
 date_inscription DATETIME NOT NULL ,
 PRIMARY KEY ( id ),
 UNIQUE ( email )
) ENGINE = INNODB;

CREATE TABLE  bdd_crypto_adviser.Trader (
	 id INT( 11 ) NOT NULL AUTO_INCREMENT ,
	 username VARCHAR( 60 ) NOT NULL ,
	 full_name VARCHAR( 60 ) NOT NULL ,
	 password VARCHAR( 32 ) NOT NULL ,
	 created_at DATETIME NOT NULL ,
	 PRIMARY KEY ( id ),
 	 UNIQUE ( username )
) ENGINE = INNODB;