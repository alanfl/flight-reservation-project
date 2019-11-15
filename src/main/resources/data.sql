INSERT IGNORE INTO user (username, password) VALUES ('admin', 'admin');
INSERT IGNORE INTO user (username, password) VALUES ('user', 'user');

INSERT IGNORE INTO role (username, role) VALUES ('admin', 'admin');
INSERT IGNORE INTO role (username, role) VALUES ('user', 'customer');

INSERT IGNORE INTO airline (airline_id, airline_name) VALUES ('UA', 'United Airlines');