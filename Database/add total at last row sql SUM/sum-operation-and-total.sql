SELECT
    CASE
        WHEN GROUPING(release_year) = 1 THEN 'Total'
        ELSE release_year
    END AS "Release year",
    SUM(price) AS "Prices"
FROM
    movies
GROUP BY
    ROLLUP (release_year)
ORDER BY
    CASE
        WHEN GROUPING(release_year) = 1 THEN NULL
        ELSE release_year
    END NULLS LAST;