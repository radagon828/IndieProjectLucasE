DELETE FROM Run;
DELETE FROM Technique;
DELETE FROM Game;
DELETE FROM User;

INSERT INTO Game (title, description, image_pth)
VALUES
('Haunting ground', 'Developed by Capcom', 'imgpath'),
('Resident Evil(1997)', 'Developed by Capcom', 'imgpath'),
('Amnesia: Dark Descent', 'Developed by Frictional', 'imgpath'),
('NightCry', 'Developed by Nude Maker', 'imgpath'),
('Clock Tower 3', 'Developed by Capcom', 'imgpath');

INSERT INTO User (username, user_email, password)
VALUES
('sonic', 'userone@gmail.com', '11111'),
('carci', 'usertwo@gmail.com', '11112'),
('darkflash', 'userthree@gmail.com', '11113'),
('fourr', 'userfour@gmail.com', '11114'),
('tomato', 'userfive@gmail.com', '11115');

-- //change time data type from double to time
-- //java.time.LocalDateTime.now()

INSERT INTO Run (game_id, category, user_id, time, platform, date, video_link)
    VALUE
    (5, 'Normal Mode, Any%', 1, '1:17:52', 'PS2', now(), 'https://www.youtube.com/watch?v=_81rRLpYFBU'),
    (5, 'Normal Mode, Any%', 2, '1:18:03', 'PS2', now(), 'https://www.youtube.com/watch?v=IrqbMGFNnlQ'),
    (5, 'Clear Mode, Any%', 3, '1:21:33', 'PS2', now(), 'https://www.youtube.com/watch?v=ZGHipvliy7A'),
    (5, 'Clear Mode, Any%', 4, '1:21:49', 'PS2', now(), 'https://www.youtube.com/watch?v=y7PtJk8qSF8'),
    (5, 'Normal Mode, 100%', 5, '1:30:04', 'PS2', now(), 'https://www.youtube.com/watch?v=tsHLOI0mc1U'),
    (5, 'Clear Mode, 100%', 1, '1:31:26', 'PS2', now(), 'https://www.youtube.com/watch?v=zvpp8o190PA'),
    (4, 'Two Survivors Ending', 4, '39:22', 'PC', now(), 'https://www.twitch.tv/videos/544495787?t=0h0m6s%2F%3Ftt_content%3Dtwitch_logo'),
    (4, 'Two Survivors Ending', 5, '39:32', 'PC', now(), 'https://www.youtube.com/watch?v=_wWfH2RuXMM'),
    (4, 'Face Floating On Waves', 5, '8:14', 'PC', now(), 'https://www.youtube.com/watch?v=G4-YJBYVwuQ');