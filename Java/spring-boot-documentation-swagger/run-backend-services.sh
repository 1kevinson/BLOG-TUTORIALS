docker stop spring-rest-api postgres-15 &&

docker rm spring-rest-api postgres-15 &&

./mvnw clean package -DskipTests &&

docker compose build --no-cache &&

docker compose up -d