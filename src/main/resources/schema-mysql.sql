'CREATE DATABASE IF NOT EXISTS HealthAppDataBase'

'USE HealthAppDataBase'

'CREATE TABLE IF NOT EXISTS `HealthAppDataBase`.`Person_details` (
  `person_detail_id` double unsigned NOT NULL,
  `person_weight` double NOT NULL,
  `person_height` double NOT NULL,
  `person_sex` varchar(255) NOT NULL,
  PRIMARY KEY (`person_detail_id`),
  UNIQUE KEY `person_detail_id_UNIQUE` (`person_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci'

'CREATE TABLE IF NOT EXISTS `HealthAppDataBase`.`Persons` (
  `person_id` double unsigned NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `up_dt_tm` datetime NOT NULL,
  `person_detail_id` double unsigned NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`),
  KEY `fk_Persons_Person_Details_idx` (`person_detail_id`),
  CONSTRAINT `fk_Persons_Person_Details` FOREIGN KEY (`person_detail_id`) REFERENCES `Person_Details` (`person_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci'

'CREATE TABLE IF NOT EXISTS `HealthAppDataBase`.`Diet` (
  `diet_id` double unsigned NOT NULL,
  `food_type` varchar(255) NOT NULL,
  `calorie_value` double NOT NULL,
  `intake_frep` int NOT NULL,
  `up_dt_tm` datetime NOT NULL,
  PRIMARY KEY (`diet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci'

'CREATE TABLE IF NOT EXISTS `HealthAppDataBase`.`Encounters` (
  `encounter_id` double unsigned NOT NULL,
  `up_dt_tm` datetime NOT NULL,
  `person_id` double unsigned NOT NULL,
  `diet_id` double unsigned NOT NULL,
  PRIMARY KEY (`encounter_id`),
  KEY `fk_Encounters_Persons1_idx` (`person_id`),
  KEY `fk_Encounters_Diet1_idx` (`diet_id`),
  CONSTRAINT `fk_Encounters_Diet1` FOREIGN KEY (`diet_id`) REFERENCES `Diet` (`diet_id`),
  CONSTRAINT `fk_Encounters_Persons1` FOREIGN KEY (`person_id`) REFERENCES `Persons` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci'

'CREATE TABLE IF NOT EXISTS `HealthAppDataBase`.`Comments` (
  `comment_id` double unsigned NOT NULL,
  `comment_text` varchar(255) NOT NULL,
  `up_dt_tm` datetime NOT NULL,
  `diet_id` double unsigned NOT NULL,
  `encounter_id` double unsigned NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_Comments_Diet1_idx` (`diet_id`),
  KEY `fk_Comments_Encounters1_idx` (`encounter_id`),
  CONSTRAINT `fk_Comments_Diet1` FOREIGN KEY (`diet_id`) REFERENCES `Diet` (`diet_id`),
  CONSTRAINT `fk_Comments_Encounters1` FOREIGN KEY (`encounter_id`) REFERENCES `Encounters` (`encounter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci'