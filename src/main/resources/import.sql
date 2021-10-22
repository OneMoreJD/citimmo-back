INSERT IGNORE INTO Profile (label) VALUES ('USER');
INSERT IGNORE INTO Profile (label) VALUES ('ADMINISTRATOR');
INSERT IGNORE INTO Profile (label) VALUES ('REAL_ESTATE_AGENT');
COMMIT ;
-- A default test user login: test@test.org / pwd: test
INSERT IGNORE INTO User (account_non_expired, account_non_locked, credentials_non_expired, email, enabled, firstname, lastname, password, phone, profile_picture_url, username, profile_id) VALUES (1, 1, 1, 'test@test.org', 1, 'Test', 'Test', '$2a$10$dp7W5w6nFLz5niTs.KjmIOtBEIHUL.Vh16C8bdfTe5KocuexFAvJ.', NULL, NULL, 'test@test.org', 1);
COMMIT ;
INSERT INTO `citibase`.`status` (`id`, `label`) VALUES (1, "free"), (2, "applied"), (3, "booked");
COMMIT ;

-- user agent jean pierre password='user'
INSERT INTO citibase.user (id, account_non_expired, account_non_locked, credentials_non_expired, email, enabled, firstname, lastname, password, phone, profile_picture_url, username, profile_id) VALUES (2, true, false, true, 'jean.pierre@net.fr', true, 'jean', 'pierre', '$2a$10$J159Nfzu25Tga9NVBdejLullvGoAyoDOrsklRF4R8TMAFWF9HP7HO', '', null, 'jean.pierre@net.fr', 3);

-- advert
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (1, 3, 2, '1930-01-01', 'Cette magnifique maison Grolandaise de 1955 est situé en plein centre de Bignolle avec un terrain de 600 m2 et une surface habitable de 115 m2.
Séjour très lumineux avec vu sur un jardin à la Grolandaise......', 'house', 'gas', 2, 154000, '2021-10-21', 5, 135, 650, 'Maison de 154 m2', 'buy', 12, 2);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (2, 3, 3, '1926-01-01', 'Très bel appartement en plein centre de Muflin.
Ancien avec moulure et parquet.', 'appartment', 'gas', 1, 98000, '2021-10-21', 4, 87, 0, 'Appartement de 87 m2', 'buy', 2, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (3, 2, 0, '1997-01-01', 'Magnifique appartement en plein centre de Muflin avec vue sur la place du princident.
toilette sur le palier.
travaux à prévoir.', 'appartment', 'electric', 1, 78000, '2021-10-21', 3, 68, 0, 'Appartement de 68m2 à Muflin', 'buy', 3, 2);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (4, 1, 3, '1930-01-01', 'PARIS 17 ème JONQUIERE Appartement 2 pièces', 'appartment', 'electric', 0, 345000, '2021-10-21', 2, 33, 0, 'Appartement 2 pièces', 'buy', 19, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (5, 2, 0, '1990-01-01', 'Appartement 3 pièces de 70.0m² | Rue de Crimée | Paris 19

Appartement de 3 pièces

Le bien est composé d''un salon de 24m², de deux chambres, d''une terrasse, d''une cuisine équipée, d''une salle de bain avec baignoire et d''un wc séparé.

Le bien est complété par deux parkings.

Les plus :

- Extérieur

- Grand Séjour

- Chauffage électricité individuel.

- Double vitrage.

Sur l''immeuble :

Construit en 1990. Immeuble bien entretenu.

Sur la localisation :

Flandres/ Crimée, à 2 pas de tous les commerces, 3 mn à pied du Métro Crimée, 5 mn à pied du Canal de la Villette et 7 mn à pied de la Gare Rosa Parks, RER E (bientôt direct La défense)

Libre immédiatement.', 'appartment', 'electric', 1, 585000, '2021-10-21', 3, 81, 0, 'Appartement 3 pièces 81 m² Étage 1/6', 'buy', 8, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (6, 0, 2, '1967-01-01', 'Magnifique Studio, idéal pour ceux qui sont libre dans leur tête. ', 'appartment', 'electric', 0, 250000, '2021-10-21', 1, 17, 0, 'Appartement de Caractère (Studio)', 'buy', 11, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (7, 0, 3, '1935-01-01', 'Une fermette à rénover pour les amateurs de travaux à Muflin', 'other', 'gas', 2, 35000, '2021-10-21', 1, 255, 2500, 'Fermette à rénover (potentiel 250m²)', 'buy', 13, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (8, 2, 2, '1985-01-01', 'Un appartement de charme dans un quartier prisé.

A quelques minutes à pieds de la gare (45minutes), toutes commodités (centre commercial à 1h en voiture)', 'appartment', 'electric', 1, 1250, '2021-10-21', 4, 85, 0, 'Appartement de charme', 'rent', 14, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (9, 2, 2, '1985-01-01', 'Idéal pour les personnes photosensibles, ce superbe souplex en plein centre de Muflin saura vous râvir.

L''humidité ambiante permet aux mycologues de s''adonner de façon optimale à leur passion!', 'appartment', 'electric', 1, 185, '2021-10-21', 3, 65, 0, 'Souplex pour troglodytes', 'rent', 15, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (10, 2, 1, '1857-01-01', 'Pour les amateurs de pierres, nous vous proposons cette demeure cossue. Quelques travaux sont à prévoir mais le potentiel est fort sur ce bien de caractère.

Notre agent sera ravi de vous faire visiter ce bien, munissez-vous simplement d''une bonne paire de bottes.', 'house', 'electric', 2, 198520, '2021-10-21', 4, 152, 1200, 'Maison cossue', 'buy', 16, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (11, 2, 0, '1835-01-01', 'Appartement de charme Haussmanien dans le très prisé quartier Latin.

Aucun travaux à prévoir, parquet en bois massif, moulures couronnées, tout le charme du logement Parisien, à la portée de (quelques) bourses', 'appartment', 'electric', 1, 1520365, '2021-10-21', 3, 120, 0, 'Appartement typiquement parisien ', 'buy', 17, 1);
INSERT INTO citibase.advert (id, bedrooms, condition_type, contruction_date, description, estate_type, heating_type, nb_car_in_garage, price, publication_date, rooms, surface_in, surface_out, title, transaction_type, address_id, status_id) VALUES (12, 4, 3, '1989-01-01', 'blable

une kligne', 'appartment', 'gas', 1, 120000, '2021-10-21', 4, 120, 0, 'Appartement F2', 'buy', 18, 1);

commit;

-- adress
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (1, 'BIGNOLLE', '34', 'RUE DES PIVOINES', 25657);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (2, 'VILLARS SOUS ECOT', '14', 'RUE DES BOURLION', 25150);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (3, 'MUFLIN', '5', 'RUE DES PIVOINES', 25789);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (6, 'PARIS', '56', 'RUE EPINETTE', 75017);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (7, 'PARIS', '56', 'RUE EPINETTE', 75017);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (8, 'PARIS', '45', 'RUE DE CRIMÉE', 75019);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (9, 'PARIS', '56', 'RUE EPINETTE', 75017);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (10, 'PARIS', '56', 'RUE EPINETTE', 75017);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (11, 'PARIS', '67', 'RUE DE LA GOUTTE D’OR', 75018);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (12, 'BIGNOLLE', '34', 'RUE DES PIVOINES', 25657);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (13, 'MUFLIN', '5', 'Route des mouflons', 25981);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (14, 'BORDEAUX', '65', 'AVENUE DES TROIS CARDINAUX', 33300);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (15, 'MUFLIN', '12', 'ROUTE DU CHARMEUR', 54851);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (16, 'MUFLIN', '15', 'RUE DU DOMAINE DIEU', 25425);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (17, 'PARIS', '10', 'RUE CUJAS', 75005);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (18, 'LIORAC SUR LOUYRE', '4', 'RUE DES GABARIERS', 24520);
INSERT INTO citibase.address (id, city, num, street, zip_code) VALUES (19, 'PARIS', '56', 'RUE EPINETTE', 75017);

commit;

INSERT INTO citibase.picture (id, source) VALUES (1, 'assets/images/adverts/demo/advert_01.jpg');
INSERT INTO citibase.picture (id, source) VALUES (2, 'assets/images/adverts/demo/epiaisgroland.jpg');
INSERT INTO citibase.picture (id, source) VALUES (3, 'assets/images/adverts/demo/Groland_Cornillard-sur-Flanche.jpg');
INSERT INTO citibase.picture (id, source) VALUES (4, 'assets/images/adverts/demo/image1.jpg');
INSERT INTO citibase.picture (id, source) VALUES (5, 'assets/images/adverts/demo/image2.webp');
INSERT INTO citibase.picture (id, source) VALUES (6, 'assets/images/adverts/demo/image3.webp');
INSERT INTO citibase.picture (id, source) VALUES (7, 'assets/images/adverts/demo/image4.webp');
INSERT INTO citibase.picture (id, source) VALUES (8, 'assets/images/adverts/demo/image5.webp');
INSERT INTO citibase.picture (id, source) VALUES (9, 'assets/images/adverts/demo/image6.webp');
INSERT INTO citibase.picture (id, source) VALUES (10, 'assets/images/adverts/demo/tente1.jpg');
INSERT INTO citibase.picture (id, source) VALUES (11, 'assets/images/adverts/demo/Epiais-les-Louvres_95_ferme_du_Manoir_rue_du_Manoir_2.jpg');
INSERT INTO citibase.picture (id, source) VALUES (12, 'assets/images/adverts/demo/1280px-Flag_of_Groland.png');
INSERT INTO citibase.picture (id, source) VALUES (13, 'assets/images/adverts/demo/demo.png');
INSERT INTO citibase.picture (id, source) VALUES (14, 'assets/images/adverts/demo/Groland_la_fete.gif');
INSERT INTO citibase.picture (id, source) VALUES (15, 'assets/images/adverts/demo/souplex1.jpg');
INSERT INTO citibase.picture (id, source) VALUES (16, 'assets/images/adverts/demo/souplex2.jpg');
INSERT INTO citibase.picture (id, source) VALUES (17, 'assets/images/adverts/demo/ferme_groland1.jpg');
INSERT INTO citibase.picture (id, source) VALUES (18, 'assets/images/adverts/demo/ferme_groland2.jpg');
INSERT INTO citibase.picture (id, source) VALUES (19, 'assets/images/adverts/demo/ferme_groland3.jpg');
INSERT INTO citibase.picture (id, source) VALUES (20, 'assets/images/adverts/demo/haussman1.jpg');
INSERT INTO citibase.picture (id, source) VALUES (21, 'assets/images/adverts/demo/haussman2.jpg');
INSERT INTO citibase.picture (id, source) VALUES (22, 'assets/images/adverts/demo/renover1.jpg');
INSERT INTO citibase.picture (id, source) VALUES (23, 'assets/images/adverts/demo/renover2.jpg');
INSERT INTO citibase.picture (id, source) VALUES (24, 'assets/images/adverts/demo/bordeaux1.jpg');
INSERT INTO citibase.picture (id, source) VALUES (25, 'assets/images/adverts/demo/bordeaux2.jpg');

commit;

-- advert_pictures
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (1, 1);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (1, 2);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (1, 3);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (2, 13);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (3, 11);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (3, 12);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (3, 14);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (4, 4);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (4, 5);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (4, 6);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (5, 7);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (5, 8);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (5, 9);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (6, 10);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (7, 22);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (7, 23);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (8, 24);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (8, 25);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (9, 15);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (9, 16);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (10, 17);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (10, 18);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (10, 19);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (11, 20);
INSERT INTO citibase.advert_pictures (advert_id, pictures_id) VALUES (11, 21);

commit;

-- application
INSERT INTO citibase.application (id, is_accepted, advert_id, user_id) VALUES (1, false, 5, 2);
INSERT INTO citibase.application (id, is_accepted, advert_id, user_id) VALUES (2, false, 1, 1);
INSERT INTO citibase.application (id, is_accepted, advert_id, user_id) VALUES (3, false, 3, 1);
INSERT INTO citibase.application (id, is_accepted, advert_id, user_id) VALUES (4, false, 1, 3);

commit;
