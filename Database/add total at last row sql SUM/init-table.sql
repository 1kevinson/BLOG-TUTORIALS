-- CREATE TABLE
DROP TABLE IF EXISTS movies;
CREATE TABLE movies (
    id SERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    release_year VARCHAR,
    genre genre,
    price NUMERIC(4, 2)
);