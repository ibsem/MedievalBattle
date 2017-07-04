CREATE TABLE IF NOT EXISTS fight_style  (id integer PRIMARY KEY AUTOINCREMENT,
										name text NOT NULL, 
										attack int NOT NULL, 
										defense int NOT NULL, 
										luck int NOT NULL);
INSERT INTO fight_style (name,attack,defense,luck) values ("Warrior", 1,2,1);
INSERT INTO fight_style (name,attack,defense,luck) values ("Archer", 2,1,1);
INSERT INTO fight_style (name,attack,defense,luck) values ("Mage", 1,1,2); 

CREATE TABLE IF NOT EXISTS ranking (id integer PRIMARY KEY AUTOINCREMENT,
									name text NOT NULL,
									score int NOT NULL,
									datescore datetime NOT NULL);
