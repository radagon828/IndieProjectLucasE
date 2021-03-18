delete FROM run;
delete FROM technique;
delete FROM role;
delete FROM game;
delete FROM user;
INSERT INTO `game` VALUES(1, 'Haunting Ground', 'Developed by Capcom', 'imgpath'),(2, 'Resident Evil(1997)', 'Developed by Capcom', 'imgpath'),(3, 'Amnesia: Dark Descent', 'Developed by Frictional', 'imgpath'),(4, 'NightCry', 'Developed by Nude Maker', 'imgpath'),(5, 'Clock Tower 3', 'Developed by Capcom', 'imgpath');
INSERT INTO `user` VALUES(1, 'userone@gmail.com', 'sonic', '11111'),(2, 'usertwo@gmail.com', 'carci', '11112'),(3, 'userthree@gmail.com', 'darkflash', '11113'),(4, 'userfour@gmail.com', 'fourr', '11114'),(5, 'userfive@gmail.com', 'tomato', '11115');
INSERT INTO `run` (game_id, category, user_id, time, platform, date, video_link) VALUES(5, 'Normal Mode, Any%', 1, '1:17:52', 'PS2', now(), 'https://www.youtube.com/watch?v=_81rRLpYFBU'),(5, 'Normal Mode, Any%', 2, '1:18:03', 'PS2', now(), 'https://www.youtube.com/watch?v=IrqbMGFNnlQ'),(5, 'Clear Mode, Any%', 3, '1:21:33', 'PS2', now(), 'https://www.youtube.com/watch?v=ZGHipvliy7A'),(5, 'Clear Mode, Any%', 4, '1:21:49', 'PS2', now(), 'https://www.youtube.com/watch?v=y7PtJk8qSF8'),(5, 'Normal Mode, 100%', 5, '1:30:04', 'PS2', now(), 'https://www.youtube.com/watch?v=tsHLOI0mc1U'),(5, 'Clear Mode, 100%', 1, '1:31:26', 'PS2', now(), 'https://www.youtube.com/watch?v=zvpp8o190PA'),(4, 'Two Survivors Ending', 4, '39:22', 'PC', now(), 'https://www.twitch.tv/videos/544495787?t=0h0m6s%2F%3Ftt_content%3Dtwitch_logo'),(4, 'Two Survivors Ending', 5, '39:32', 'PC', now(), 'https://www.youtube.com/watch?v=_wWfH2RuXMM'),(4, 'Face Floating On Waves', 5, '8:14', 'PC', now(), 'https://www.youtube.com/watch?v=G4-YJBYVwuQ');
INSERT INTO `role` VALUES(1, 'admin', 'carci', 2),(2, 'user', 'sonic', 1);
