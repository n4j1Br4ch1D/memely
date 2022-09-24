/*Seed TABLE Users:*/
INSERT INTO public.users (full_name, username, description, email, password, role, enabled, active, avatar, followers_count)
VALUES ('Najib Rachid','najib-rachid', 'FullStack Web Developer', 'najib@anmoon.ma','$2a$10$OLqXyrDqoKyGkJu.3Tr/lesUfNs05hM.ZFRHzX6e8mnkBgh5.oo4G', 'ROLE_ADMIN',TRUE , FALSE, 'https://avatars.githubusercontent.com/u/38995898?v=4', 4),
       ('Khadija idlmhor', 'med', 'Web Developer', 'khadija@anmoon.ma','$2a$10$iZstRX1sXhxnJpGfCUI2quSxvld5XDPRbB5Scw7eq27mqntCWA59C', 'ROLE_ADMIN',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 3),
       ('Abderahim Oudor', 'ayoub', 'Ethical Hacker','ayoub@anmoon.ma','$2a$10$3Rk0JxAID7kSqWYijvtB6eu7DplUsXnIMvcwr04sOGzaK3pRwk726', 'ROLE_CLIENT',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 2),
       ('Fatiha El habti', 'fatiha', 'Web Designer', 'fatiha@anmoon.ma','$2a$10$uOqFjk3kQ482jDRIRaZmhe20slxLkM4c/b4YMRVfKCPOOU88HAC72' ,'ROLE_CLIENT',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 1),
       ('Latifa Amouguay', 'latifa', 'Web Developer', 'latifa@anmoon.ma','$2a$10$HvPODtiJ1K9jmDY10iUt9.fVMSzvuTVYP4cPoMqbEV41JrtORpfbm', 'ROLE_CLIENT',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 0),
       ('Anass ELmkhloufi', 'anas', 'Mobile Developer',  'anas@anmoon.ma','$2a$10$U6FJN3PbkePwVUoRSG7waOt0iBRdme9r1og5jLIdfdU3VjnX0yZry', 'ROLE_CLIENT',TRUE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 0),
       ('Omar Dbaa', 'omar', 'Graphic Designer', 'omar@anmoon.ma','$2a$10$zTkULoo0xe9w6KDdNt185e0HvPCaxr80X/RejhnhthbNKgy8oJhiq', 'ROLE_CLIENT', FALSE, FALSE, 'https://avatars.githubusercontent.com/u/105658089?v=4', 0);
       
       
       
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
VALUES ('funny1', 'https://assets-global.website-files.com/5f3c19f18169b62a0d0bf387/60d33be8cf4ba7565123c8bc_YPD3ulQQAGQpOcnqIm3QzSTRgzmr1SexpW9ZjMpJ1mAnUxx4iF05XOTu44sk0qQG-8XgBcYmGZGAD-5SAZvJl3TjtmhgWnn-w0C2XKwhBscV78RVvhwZfyp0v_Pa6sNj5zxpOvRW.png', 'this one is a funny one', TRUE, TRUE, 50, 1),
       ('funny2', 'https://pbs.twimg.com/media/D46dvSSW4AE2Mm9.jpg', 'this one is a funny one', TRUE, FALSE, 66, 1),
       ('funny3', 'https://devhumor.com/content/uploads/images/March2022/new_bugs.jpg', 'this one is a funny one', TRUE, FALSE, 0, 2);
       
  
       
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
VALUES ('html'),
       ('php');

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


