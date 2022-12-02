
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


DROP TABLE IF EXISTS "user";

CREATE TABLE "user"(
    id  uuid DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
  	 first_name  VARCHAR(255) NOT NULL,
  	 last_name  VARCHAR(255) NOT NULL,
  	 email   VARCHAR(255) NOT NULL,
  	 password  VARCHAR(255) NOT NULL,
  	 phone_number  VARCHAR(255),
  	 school_number  VARCHAR(255) NOT NULL,
  	 role  VARCHAR(255) NOT NULL,
  	 gender  VARCHAR(255) NOT NULL,
  	 date_of_birth  VARCHAR(255) NOT NULL,
  	 notes  VARCHAR(255) NOT NULL,
  	 created_at TIMESTAMPTZ NOT NULL default now()
);

