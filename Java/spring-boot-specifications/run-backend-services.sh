docker stop jpa-specifications postgres-demo &&

docker rm jpa-specifications postgres-demo &&

./mvnw clean package -DskipTests &&

docker compose build --no-cache &&

docker compose up -d