docker stop spring-sql mysql-8 &&

docker rm spring-sql mysql-8 &&

./mvnw clean package -DskipTests &&

docker compose build --no-cache &&

docker compose up -d

last_command_status=$(echo $?)

if [ "$last_command_status" -eq 0 ]
then
    echo "All the service are up"
else
    echo "Something went wrong..."
fi