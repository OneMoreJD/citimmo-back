INSERT IGNORE INTO Profile (label) VALUES ('USER');
INSERT IGNORE INTO Profile (label) VALUES ('ADMINISTRATOR');
INSERT IGNORE INTO Profile (label) VALUES ('REAL_ESTATE_AGENT');
COMMIT ;
-- A default test user login: test@test.org / pwd: test
INSERT IGNORE INTO User (account_non_expired, account_non_locked, credentials_non_expired, email, enabled, firstname, lastname, password, phone, profile_picture_url, username, profile_id) VALUES (1, 1, 1, 'test@test.org', 1, 'Test', 'Test', '$2a$10$dp7W5w6nFLz5niTs.KjmIOtBEIHUL.Vh16C8bdfTe5KocuexFAvJ.', NULL, NULL, 'test@test.org', 1);
COMMIT ;