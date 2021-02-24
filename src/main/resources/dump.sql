DROP TABLE IF EXISTS `Run`;
DROP TABLE IF EXISTS `Technique`;
DROP TABLE IF EXISTS `Game`;
DROP TABLE IF EXISTS `User`;
-- tables
-- Table: Game
CREATE TABLE Game (
                      game_id int NOT NULL,
                      title varchar(40) NOT NULL,
                      description varchar(200) NOT NULL,
                      image_pth varchar(200) NOT NULL,
                      CONSTRAINT game_id PRIMARY KEY (game_id)
);

-- Table: Run
CREATE TABLE Run (
                     run_id int NOT NULL,
                     game_id int NOT NULL,
                     category varchar(25) NOT NULL,
                     user_id int NOT NULL,
                     time double(8,2) NOT NULL,
    platform varchar(20) NOT NULL,
    date datetime NOT NULL,
    video_link varchar(100) NOT NULL,
    CONSTRAINT Run_pk PRIMARY KEY (run_id)
);

-- Table: Technique
CREATE TABLE Technique (
                           tech_id int NOT NULL,
                           user_id int NOT NULL,
                           game_id int NOT NULL,
                           title varchar(50) NOT NULL,
                           description varchar(300) NOT NULL,
                           video_link varchar(100) NOT NULL,
                           submission_date datetime NOT NULL,
                           CONSTRAINT Technique_pk PRIMARY KEY (tech_id)
);

-- Table: User
CREATE TABLE User (
                      user_id int NOT NULL,
                      username varchar(30) NOT NULL,
                      password varchar(40) NOT NULL,
                      CONSTRAINT User_pk PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: Run_Game (table: Run)
ALTER TABLE Run ADD CONSTRAINT Run_Game FOREIGN KEY Run_Game (game_id)
    REFERENCES Game (game_id);

-- Reference: Run_User (table: Run)
ALTER TABLE Run ADD CONSTRAINT Run_User FOREIGN KEY Run_User (user_id)
    REFERENCES User (user_id);

-- Reference: Technique_Game (table: Technique)
ALTER TABLE Technique ADD CONSTRAINT Technique_Game FOREIGN KEY Technique_Game (game_id)
    REFERENCES Game (game_id);

-- Reference: Technique_User (table: Technique)
ALTER TABLE Technique ADD CONSTRAINT Technique_User FOREIGN KEY Technique_User (user_id)
    REFERENCES User (user_id);