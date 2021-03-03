DROP TABLE IF EXISTS `run`;
DROP TABLE IF EXISTS `technique`;
DROP TABLE IF EXISTS `game`;
DROP TABLE IF EXISTS `user`;
-- tables
-- Table: Game
CREATE TABLE game (
                      game_id int NOT NULL AUTO_INCREMENT,
                      title varchar(40) NOT NULL,
                      description varchar(200) NOT NULL,
                      image_pth varchar(200) NOT NULL,
                      CONSTRAINT game_id PRIMARY KEY (game_id)
);

-- Table: Run
CREATE TABLE run (
                     run_id int NOT NULL AUTO_INCREMENT,
                     game_id int NOT NULL,
                     category varchar(25) NOT NULL,
                     user_id int NOT NULL,
                     time time NOT NULL,
                     platform varchar(20) NOT NULL,
                     date datetime NOT NULL,
                     video_link varchar(100) NOT NULL,
                     CONSTRAINT Run_pk PRIMARY KEY (run_id)
);

-- Table: Technique
CREATE TABLE technique (
                           tech_id int NOT NULL AUTO_INCREMENT,
                           user_id int NOT NULL,
                           game_id int NOT NULL,
                           title varchar(50) NOT NULL,
                           description varchar(300) NOT NULL,
                           video_link varchar(100) NOT NULL,
                           submission_date datetime NOT NULL,
                           CONSTRAINT Technique_pk PRIMARY KEY (tech_id)
);

-- Table: User
CREATE TABLE user (
                      user_id int NOT NULL AUTO_INCREMENT,
                      user_email varchar(40) NOT NULL,
                      username varchar(30) NOT NULL,
                      password varchar(40) NOT NULL,
                      CONSTRAINT User_pk PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: Run_Game (table: Run)
ALTER TABLE run ADD CONSTRAINT run_game FOREIGN KEY run_game (game_id)
    REFERENCES game (game_id);

-- Reference: Run_User (table: Run)
ALTER TABLE run ADD CONSTRAINT run_user FOREIGN KEY run_user (user_id)
    REFERENCES user (user_id);

-- Reference: Technique_Game (table: Technique)
ALTER TABLE technique ADD CONSTRAINT technique_game FOREIGN KEY technique_game (game_id)
    REFERENCES game (game_id);

-- Reference: Technique_User (table: Technique)
ALTER TABLE technique ADD CONSTRAINT technique_user FOREIGN KEY technique_user (user_id)
    REFERENCES user (user_id);