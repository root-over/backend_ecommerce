
-- ----------------------------
-- Categorie dei libri
-- ----------------------------
INSERT INTO "public"."product_category" VALUES (2147483641, 'Informatica', 0, '2023-03-09 23:03:26', '2023-03-10 00:15:27');
INSERT INTO "public"."product_category" VALUES (2147483642, 'Storia', 2, '2023-03-10 00:15:02', '2023-03-10 00:15:21');
INSERT INTO "public"."product_category" VALUES (2147483644, 'Psicologia', 3, '2023-03-10 01:01:09', '2023-03-10 01:01:09');
INSERT INTO "public"."product_category" VALUES (2147483645, 'Matematica', 1, '2023-03-10 00:26:05', '2023-03-10 00:26:05');


-- ----------------------------
-- product_in_order
-- ----------------------------
INSERT INTO "public"."product_in_order" VALUES (200, 0,1,'Questo volume è dedicato a Python, un linguaggio di programmazione diffuso da anni tra i professionisti grazie alla sua potenza e semplicità sintattica, e di utilizzo sempre più frequente anche in ambito universitario. ', 'https://m.media-amazon.com/images/I/71U+96Efl+L._SL1500_.jpg', '8891605085', 'Concetti di informatica e fondamenti di Python', 70.00,100,NULL, 2147483641);

-- ----------------------------
-- Libri caricati
-- ----------------------------
INSERT INTO "public"."product_info" VALUES ('8891605085', 0, '2023-03-10 10:37:39', 'Questo volume è dedicato a Python, un linguaggio di programmazione diffuso da anni tra i professionisti grazie alla sua potenza e semplicità sintattica, e di utilizzo sempre più frequente anche in ambito universitario. ', 'https://m.media-amazon.com/images/I/71U+96Efl+L._SL1500_.jpg', 'Concetti di informatica e fondamenti di Python', 103.00, 0, 1, '2023-03-10 19:42:02');
INSERT INTO "public"."product_info" VALUES ('8891906239', 0, '2023-03-10 12:12:46', 'La nona edizione è stata soggetta a una profonda revisione, pur essendo stato mantenuto lo stesso approccio didattico e metodologico.', 'https://m.media-amazon.com/images/I/71UhgIHCgdL._SL1334_.jpg', 'Il linguaggio C. Fondamenti e tecniche di programmazione.', 28.00, 0, 100, '2023-03-10 12:12:46');
INSERT INTO "public"."product_info" VALUES ('8838664684', 0, '2023-03-10 06:51:03', 'Questo libro offre un''introduzione allo studio degli algoritmi e delle strutture dati, cercando di conciliare comprensibilità, chiarezza di esposizione e rigore matematico. ', 'https://m.media-amazon.com/images/I/81JS3MYpB2L._SL1500_.jpg', 'Algoritmi e strutture dati', 25.00, 0, 100, '2023-03-10 12:04:13');
INSERT INTO "public"."product_info" VALUES ('8891645273', 0, '2023-03-10 10:35:43', 'Questo libro si rivolge a chiunque voglia acquisire le nozioni di base relative all’informatica e alle tecnologie della comunicazione e dell’informazione (Information and Communication Technology, ICT).', 'https://m.media-amazon.com/images/I/61PvOYe5w0L._SL1431_.jpg', 'Informatica di base', 20.00, 0, 100, '2023-03-10 10:35:43');
INSERT INTO "public"."product_info" VALUES ('8808064859', 1, '2023-03-10 12:09:41', 'Analisi matematica di Bramanti, Pagani e Salsa è un corso per la formazione di base che riesce a conferire anche il giusto spazio all’approfondimento grazie ai rigorosi criteri didattici adottati', 'https://m.media-amazon.com/images/I/81l0RVWNgfL._SL1477_.jpg', 'Analisi matematica 1', 40.00, 0, 100, '2023-03-10 12:09:41');
INSERT INTO "public"."product_info" VALUES ('8836161006', 1, '2023-03-10 12:11:51', 'A causa di un approccio d''insegnamento decisamente poco ''friendly'' e di una radicata diffidenza, la matematica è la più odiata fra le materie studiate fin da ragazzi.', 'https://m.media-amazon.com/images/I/71BUgSYkxfL._SL1500_.jpg', 'Le anime della matematica. Da Pitagora alle intelligenze artificiali', 18.00, 0, 100, '2023-03-10 12:11:51');
INSERT INTO "public"."product_info" VALUES ('8804666684', 2, '2023-03-10 06:44:25', 'Com''era la vita quotidiana nella Roma Imperiale? Quali volti si incontravano nelle vie o sulle gradinate del Colosseo? Quali atmosfere si respiravano nelle case, nei palazzi?', 'https://m.media-amazon.com/images/I/81g-acEzHaL._SL1500_.jpg', 'Una giornata nell''antica Roma. Vita quotidiana, segreti e curiosità', 30.00, 0, 100, '2023-03-10 06:44:25');
INSERT INTO "public"."product_info" VALUES ('8891920657', 2, '2023-03-10 10:39:29', 'Questa edizione del manuale di riferimento per la storia contemporanea presenta un capitolo nuovo sulle pandemie nella storia e con la piattaforma online arricchita.', 'https://m.media-amazon.com/images/I/71BgmeKYT+L._SL1408_.jpg', 'Storia contemporanea', 30.00, 0, 197, '2023-03-10 10:39:32');
INSERT INTO "public"."product_info" VALUES ('8817050164', 3, '2023-03-10 10:40:35', 'Perché le persone più intelligenti nel senso tradizionale del termine non sono sempre quelle con cui lavoriamo più volentieri o con cui facciamo amicizia?', 'https://m.media-amazon.com/images/I/71ppUOpTBKL._SL1500_.jpg', 'Intelligenza emotiva', 15.00, 0, 157, '2023-03-10 10:40:35');

-- ----------------------------
-- Utenti
-- ----------------------------
INSERT INTO "public"."users" VALUES (2147483641, 't', 'Via utente', 'utente@utente.com', 'utente', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '123456789', 'ROLE_CUSTOMER');
INSERT INTO "public"."users" VALUES (2147483642, 't', 'Via admin', 'admin@admin.com', 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '987654321', 'ROLE_MANAGER');
-- ----------------------------
-- Carrelli degli utenti
-- ----------------------------
INSERT INTO "public"."cart" VALUES (2147483641);
INSERT INTO "public"."cart" VALUES (2147483642);


