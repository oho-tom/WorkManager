DROP TABLE IF EXISTS meeting_room CASCADE /;
DROP TABLE IF EXISTS reservation CASCADE /;
DROP TABLE IF EXISTS usr CASCADE /;
DROP TABLE IF EXISTS role CASCADE /;

CREATE TABLE IF NOT EXISTS meeting_room (
  room_id SERIAL NOT NULL,
  room_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (room_id)
)/;
CREATE TABLE IF NOT EXISTS reservation (
  reservation_id SERIAL NOT NULL,
  user_id VARCHAR(255) NOT NULL,
  room_id INT4 NOT NULL,
  reserved_date DATE NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  PRIMARY KEY (reservation_id)
)/;
CREATE TABLE IF NOT EXISTS usr (
  user_id VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role_id VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
)/;
CREATE TABLE IF NOT EXISTS role (
  role_id VARCHAR(255) NOT NULL,
  role_name VARCHAR(255) NOT NULL,
  user_regist BOOLEAN NOT NULL,
  PRIMARY KEY (role_id)
)/;
