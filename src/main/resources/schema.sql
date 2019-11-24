CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(255),
  `middle_name` varchar(255),
  `last_name` varchar(255),
  PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS `role` (
  `username` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (username, role),
  FOREIGN KEY (username) REFERENCES user(username)
);

CREATE TABLE IF NOT EXISTS `airline` (
  `airline_id` char(2) NOT NULL,
  `airline_name` varchar(255) NOT NULL,
  PRIMARY KEY (airline_id)
);

CREATE TABLE IF NOT EXISTS `aircraft` (
  `aircraft_id` varchar(32) NOT NULL,
  `aircraft_model` varchar(32) NOT NULL,
  `airline_id` char(2) NOT NULL,
  PRIMARY KEY (aircraft_id),
  FOREIGN KEY (airline_id) REFERENCES airline(airline_id)
);

CREATE TABLE IF NOT EXISTS `airport` (
  `airport_id` char(3) NOT NULL,
  `airport_name` varchar(255) NOT NULL,
  PRIMARY KEY (airport_id)
);

CREATE TABLE IF NOT EXISTS `airline_airport` (
  `airline_id` char(2) NOT NULL,
  `airport_id` char(3) NOT NULL,
  PRIMARY KEY (airline_id, airport_id),
  FOREIGN KEY (airline_id) REFERENCES airline(airline_id),
  FOREIGN KEY (airport_id) REFERENCES airport(airport_id)
);

CREATE TABLE IF NOT EXISTS `flight` (
  `flight_id` int NOT NULL,
  `airline_id` char(2) NOT NULL,
  `departure_airport_id` char(3) NOT NULL,
  `arrival_airport_id` char(3) NOT NULL,
  `departure_weekday` varchar(16) NOT NULL,
  `arrival_weekday` varchar(16) NOT NULL,
  `aircraft_id` varchar(32) NOT NULL,
  `departure_time` time,
  `arrival_time` time,
  `price` DECIMAL(9, 2) NOT NULL,
  PRIMARY KEY (airline_id, flight_id, departure_weekday),
  FOREIGN KEY (departure_airport_id) REFERENCES airport(airport_id),
  FOREIGN KEY (arrival_airport_id) REFERENCES airport(airport_id),
  FOREIGN KEY (aircraft_id) REFERENCES aircraft(aircraft_id)
);

CREATE TABLE IF NOT EXISTS `flight_waitinglist` (
  `flight_id` int NOT NULL,
  `airline_id` char(2) NOT NULL,
  `departure_weekday` varchar(16) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (airline_id, flight_id, departure_weekday),
  FOREIGN KEY (airline_id, flight_id, departure_weekday) REFERENCES flight(airline_id, flight_id, departure_weekday),
  FOREIGN KEY (username) REFERENCES user(username)
);

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `origin_airport_id` char(3) NOT NULL,
  `purchase_date` date NOT NULL,
  `purchase_time` time NOT NULL,
  `departure_date` date NOT NULL,
  `departure_time` time NOT NULL,
  `total_fare` DECIMAL(11, 2) NOT NULL,
  `fee` DECIMAL(11, 2) NOT NULL,
  `special_meal` varchar(255),
  `class` varchar(255) NOT NULL,
  `reservation_status` varchar(255) NOT NULL,
  PRIMARY KEY (reservation_id),
  FOREIGN KEY (origin_airport_id) REFERENCES airport(airport_id)
);

CREATE TABLE IF NOT EXISTS `ticket` (
  `ticket_id` int NOT NULL,
  `reservation_id` int NOT NULL,
  `leg_id` int NOT NULL,
  `airline_id` char(3) NOT NULL,
  `flight_id` int NOT NULL,
  `departure_weekday` varchar(16) NOT NULL,
  `departure_date` date NOT NULL,
  `price` DECIMAL(11, 2) NOT NULL,
  `waitlist_status` varchar(16) NOT NULL,
  PRIMARY KEY (ticket_id),
  FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id),
  FOREIGN KEY (airline_id, flight_id, departure_weekday) REFERENCES flight(airline_id, flight_id, departure_weekday)
);