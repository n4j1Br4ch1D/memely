/*Seed TABLE Users:*/
INSERT INTO public.users (full_name, username, description, email, password, role, enabled, active)
VALUES ('Najib Rachid','najib-rachid', 'FullStack Web Developer', 'najib@anmoon.ma','$2a$10$OLqXyrDqoKyGkJu.3Tr/lesUfNs05hM.ZFRHzX6e8mnkBgh5.oo4G', 'ROLE_ADMIN',TRUE , FALSE),
       ('Khadija idlmhor', 'med', 'Web Developer', 'khadija@anmoon.ma','$2a$10$iZstRX1sXhxnJpGfCUI2quSxvld5XDPRbB5Scw7eq27mqntCWA59C', 'ROLE_ADMIN',TRUE, FALSE),
       ('Abderahim Oudor', 'ayoub', 'Ethical Hacker','ayoub@anmoon.ma','$2a$10$3Rk0JxAID7kSqWYijvtB6eu7DplUsXnIMvcwr04sOGzaK3pRwk726', 'ROLE_CLIENT',TRUE, FALSE),
       ('Fatiha El habti', 'fatiha', 'Web Designer', 'fatiha@anmoon.ma','$2a$10$uOqFjk3kQ482jDRIRaZmhe20slxLkM4c/b4YMRVfKCPOOU88HAC72' ,'ROLE_CLIENT',TRUE, FALSE),
       ('Latifa Amouguay', 'latifa', 'Web Developer', 'latifa@anmoon.ma','$2a$10$HvPODtiJ1K9jmDY10iUt9.fVMSzvuTVYP4cPoMqbEV41JrtORpfbm', 'ROLE_CLIENT',TRUE, FALSE),
       ('Anass ELmkhloufi', 'anas', 'Mobile Developer',  'anas@anmoon.ma','$2a$10$U6FJN3PbkePwVUoRSG7waOt0iBRdme9r1og5jLIdfdU3VjnX0yZry', 'ROLE_CLIENT',TRUE, FALSE),
       ('Omar Dbaa', 'omar', 'Graphic Designer', 'omar@anmoon.ma','$2a$10$zTkULoo0xe9w6KDdNt185e0HvPCaxr80X/RejhnhthbNKgy8oJhiq', 'ROLE_CLIENT', FALSE, FALSE);
       
       
       
/*Seed Table Users Set Social Links:*/ 
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= null, github='n4j1Br4ch1D' WHERE id = 1;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 2;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 3;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 4;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 5;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 6;
  UPDATE public.users SET website = 'anmoon.ma', linkedin = 'najib-rachid', twitter = 'najib-rachid', instagram= 'najib-rachid', github='n4j1Br4ch1D' WHERE id = 7;
