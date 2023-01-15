docker stop spring-caching postgres-15 &&

docker rm spring-caching postgres-15 &&

./mvnw clean package -DskipTests &&

docker compose build --no-cache &&

docker compose up -d