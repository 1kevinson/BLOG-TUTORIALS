SELECT release_year, SUM(price)
FROM movies
GROUP BY release_year;