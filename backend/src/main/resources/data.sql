/*Seed TABLE Users:*/
INSERT INTO public.users (full_name, username, description, email, password, role, enabled, active, avatar, followers_count)
VALUES ('Najib Rachid','najib-rachid', 'FullStack Web Developer', 'najib@anmoon.ma','$2a$10$OLqXyrDqoKyGkJu.3Tr/lesUfNs05hM.ZFRHzX6e8mnkBgh5.oo4G', 'ROLE_ADMIN',TRUE , FALSE, 'https://avatars.githubusercontent.com/u/38995898?v=4', 4),
       ('Mohammed idlmhor', 'med', 'Web Developer', 'med@anmoon.ma','$2a$10$iZstRX1sXhxnJpGfCUI2quSxvld5XDPRbB5Scw7eq27mqntCWA59C', 'ROLE_ADMIN',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 3),
       ('Ayoub Oudor', 'ayoub', 'Ethical Hacker','ayoub@anmoon.ma','$2a$10$3Rk0JxAID7kSqWYijvtB6eu7DplUsXnIMvcwr04sOGzaK3pRwk726', 'ROLE_USER',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 2),
       ('Fatiha El habti', 'fatiha', 'Web Designer', 'fatiha@anmoon.ma','$2a$10$uOqFjk3kQ482jDRIRaZmhe20slxLkM4c/b4YMRVfKCPOOU88HAC72' ,'ROLE_USER',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 1),
       ('Latifa Amouguay', 'latifa', 'Web Developer', 'latifa@anmoon.ma','$2a$10$HvPODtiJ1K9jmDY10iUt9.fVMSzvuTVYP4cPoMqbEV41JrtORpfbm', 'ROLE_USER',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 0),
       ('Anass ELmkhloufi', 'anas', 'Mobile Developer',  'anas@anmoon.ma','$2a$10$U6FJN3PbkePwVUoRSG7waOt0iBRdme9r1og5jLIdfdU3VjnX0yZry', 'ROLE_USER',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 0),
       ('Omar Dbaa', 'omar', 'Graphic Designer', 'omar@anmoon.ma','$2a$10$zTkULoo0xe9w6KDdNt185e0HvPCaxr80X/RejhnhthbNKgy8oJhiq', 'ROLE_USER', FALSE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 0);
       
       
       
/*Seed Table Users Set Social Links:*/ 
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= null, github='n4j1Br4ch1D' WHERE id = 1;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 2;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 3;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 4;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 5;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 6;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 7;

  
  
/*Seed TABLE Memes:*/
INSERT INTO public.memes (title, img, description, enabled, story, shared_count, user_id)
VALUES ('funny1', 'meme1.png', 'this one is a funny 1st @med @latifa #code-review #bug', TRUE, TRUE, 50, 1),
       ('funny2', 'meme2.jpg', 'this one is a funny 2nd', TRUE, FALSE, 66, 1),
       ('funny3', 'meme3.jpg', 'this one is a funny 3rd', TRUE, FALSE, 13, 2),
       ('funny4', 'meme4.jpg', 'this one is a funny 4th', TRUE, FALSE, 66, 3),
       ('funny5', 'meme5.png', 'this one is a funny 5th', TRUE, FALSE, 66, 1),
       ('funny6', 'meme6.png', 'this one is a funny 6th', TRUE, FALSE, 3, 2),
       ('funny7', 'meme7.jpg', 'this one is a funny 7th', TRUE, FALSE, 66, 4),
       ('funny8', 'meme8.jpg', 'this one is a funny 8th', TRUE, FALSE, 66, 1),
       ('funny9', 'meme9.jpg', 'this one is a funny 9th', TRUE, FALSE, 0, 2),
       ('funny10', 'meme10.jpg', 'this one is a funny 10th', TRUE, FALSE, 66, 5),
       ('funny11', 'meme11.jpg', 'this one is a funny 11st', TRUE, FALSE, 66, 1),
       ('funny12', 'meme12.jpg', 'this one is a funny 12nd', TRUE, FALSE, 0, 2),
       ('funny13', 'meme13.jpg', 'this one is a funny 13rd', TRUE, FALSE, 66, 7),
       ('funny14', 'meme14.jpg', 'this one is a funny 14th', TRUE, FALSE, 66, 1),
       ('funny15', 'meme15.jpg', 'this one is a funny 15th', TRUE, FALSE, 0, 2),
       ('funny16', 'meme16.png', 'this one is a funny 16th', TRUE, FALSE, 66, 1),
       ('funny17', 'meme17.jpg', 'this one is a funny 17th', TRUE, FALSE, 66, 1),
       ('funny18', 'meme18.jpg', 'this one is a funny 18th', TRUE, FALSE, 0, 2),
       ('funny19', 'meme19.jpg', 'this one is a funny 19th', TRUE, FALSE, 66, 1),      
       ('funny20', 'meme20.png', 'this one is a funny 20th', TRUE, FALSE, 0, 4),
       ('funny21', 'meme21.jpg', 'this one is a funny 21st', TRUE, FALSE, 0, 2),       
       ('funny22', 'meme22.png', 'this one is a funny 22nd', TRUE, FALSE, 0, 5),
       ('funny23', 'meme23.jpg', 'this one is a funny 23rd', TRUE, FALSE, 66, 6),
       ('funny24', 'meme24.jpg', 'this one is a funny 24th', TRUE, FALSE, 66, 1),
       ('funny25', 'meme25.jpg', 'this one is a funny 25th', TRUE, FALSE, 0, 2),
       ('funny26', 'meme26.jpg', 'this one is a funny 26th', TRUE, FALSE, 66, 1),      
       ('funny27', 'meme27.jpg', 'this one is a funny 27th', TRUE, FALSE, 0, 2),
       ('funny28', 'meme28.png', 'this one is a funny 28th', TRUE, FALSE, 0, 2),
       ('funny29', 'meme29.png', 'this one is a funny 29th', TRUE, FALSE, 0, 2),
       ('funny30th', 'meme30.jpg', 'this one is a funny 30th', TRUE, FALSE, 0, 2);

       
/*Seed TABLE followers:*/
INSERT INTO public.followers (follower_id, followed_id)
VALUES (1, 2),
       (1, 3),
       (2, 1),
       (2, 3);

/*Seed TABLE Reactions:*/
INSERT INTO public.reactions (user_id, meme_id)
VALUES (1, 1),
       (4, 1),
       (1, 2),
       (1, 3);

/*Seed TABLE Favorites:*/
INSERT INTO public.favorites (user_id, meme_id)
VALUES (1, 2),
       (1, 3),
       (2, 3);

       
/*Seed TABLE Comments:*/
INSERT INTO public.comments (user_id, meme_id, comment)
VALUES (1, 2,  'nice i like it @med'),
       (1, 3, 'not bad @med @latifa');
       
/*Seed TABLE Mentions:*/
INSERT INTO public.mentions (meme_id, comment_id, taggeduser_id)
VALUES (1, null,  2),
       (1, null, 5),
       (null, 1, 2),
       (null, 2, 2),
       (null, 2, 5);



       
/*Seed TABLE Tags:*/
INSERT INTO public.tags (name)
VALUES ('html'), ('css'), ('bootstrap'), ('java'), ('angular'), ('tailwind'), ('docker'), ('oop'), ('javascript'), ('typescript'), ('backend'), ('hacker'), ('php'),
('python'), ('npm'), ('web design'), ('code_reiew'), ('github'), ('bug'), ('network'), ('job'), ('testing'), ('ajax'), ('jenkins'), ('devops');


/*Seed TABLE Meme_tags:*/
INSERT INTO public.meme_tags (meme_id, tag_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);
       
       
/*Seed TABLE Notifications:*/
INSERT INTO public.notifications (user_id, type , content, seen)
VALUES (1, 'mention',  'Med has mentioned you!', true),
       (1, 'ad', 'check ou our new ad', false),
       (2, 'ad', 'check ou our new ad', false);
       
/*Seed TABLE Reports:*/
INSERT INTO public.reports (user_id, meme_id, reason)
VALUES (1, 1, 'theft!'),
       (1, 2, 'illegal'),
       (2, 1, 'abuse');

/*Seed TABLE Contacts:*/
INSERT INTO public.contacts (name, email, message, seen, user_id)
VALUES ('mr admin', 'admin@anmoon.ma',  'Hi i like ur site', false, null),
       ('user 1', 'user1@anmoon.ma',  'Hi i like ur site', true, 1),
       ('user 2', 'user2@anmoon.ma',  'Hi i like ur site', true, 2),
       ('user 3', 'user1@anmoon.ma',  'Hi i like ur site', true, 1);
       
 /*Seed TABLE Messages:*/
INSERT INTO public.messages (content, sender_id, reciver_id)
VALUES ('slm', 2, 1),
       ('ahlan', 1, 2),
       ('cv', 2, 1),
       ('slm 3likom', 2, 3),
       ('ach kadir', 2, 3),
       ('walo ra galss', 1, 3),
       ('ah okay!', 2, 3),
       ('wash!', 2, 4),
       ('hani!', 4, 2);


       


