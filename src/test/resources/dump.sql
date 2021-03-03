DROP TABLE IF EXISTS `run`;
DROP TABLE IF EXISTS `technique`;
DROP TABLE IF EXISTS `game`;
DROP TABLE IF EXISTS `user`;
-- tables
-- Table: Game
CREATE TABLE `game` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `title` varchar(40) NOT NULL,
                        `description` varchar(200) NOT NULL,
                        `image_pth` varchar(200) NOT NULL,
                        PRIMARY KEY (`id`)
);

-- Table: Run
CREATE TABLE `run` (
                       `id` int(11) NOT NULL AUTO_INCREMENT,
                       `game_id` int(11) NOT NULL,
                       `category` varchar(25) NOT NULL,
                       `user_id` int(11) NOT NULL,
                       `time` time NOT NULL,
                       `platform` varchar(20) NOT NULL,
                       `date` datetime NOT NULL,
                       `video_link` varchar(100) NOT NULL,
                       PRIMARY KEY (`id`)
);

-- Table: Technique
CREATE TABLE `technique` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) NOT NULL,
                             `game_id` int(11) NOT NULL,
                             `title` varchar(50) NOT NULL,
                             `description` varchar(300) NOT NULL,
                             `video_link` varchar(100) NOT NULL,
                             `submission_date` datetime NOT NULL,
                             PRIMARY KEY (`id`)
);

-- Table: User
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `user_email` varchar(40) NOT NULL,
                        `username` varchar(30) NOT NULL,
                        `password` varchar(40) NOT NULL,
                        PRIMARY KEY (`id`)
);

-- foreign keys
-- Reference: Run_Game (table: Run)
ALTER TABLE `run` ADD CONSTRAINT `run_game` FOREIGN KEY `run_game` (`game_id`)
    REFERENCES `game` (`id`);

-- Reference: Run_User (table: Run)
ALTER TABLE `run` ADD CONSTRAINT `run_user` FOREIGN KEY `run_user` (`user_id`)
    REFERENCES `user` (`id`);

-- Reference: Technique_Game (table: Technique)
ALTER TABLE `technique` ADD CONSTRAINT `technique_game` FOREIGN KEY `technique_game` (`game_id`)
    REFERENCES `game` (`id`);

-- Reference: Technique_User (table: Technique)
ALTER TABLE `technique` ADD CONSTRAINT `technique_user` FOREIGN KEY `technique_user` (`user_id`)
    REFERENCES `user` (`id`);