
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;


DROP TABLE IF EXISTS registration;

CREATE TABLE registration (
    id  uuid DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
  	 match_day  VARCHAR(255) NOT NULL,
  	 status  VARCHAR(255) NOT NULL,
  	 player_id  uuid NOT NULL,
  	 proficiency_id uuid NOT NULL,
  	 created_at TIMESTAMPTZ NOT NULL default now()
);

DROP TABLE IF EXISTS proficiency;

CREATE TABLE proficiency (
     id uuid DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
  	 proficiency_name  VARCHAR(255) NOT NULL
);

INSERT INTO proficiency (id, proficiency_name)
VALUES
(uuid_generate_v4(), 'Recreational'),
(uuid_generate_v4(), 'Intermediate'),
(uuid_generate_v4(), 'Competitive');
