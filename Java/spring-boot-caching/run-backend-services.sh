# stop previous containers
docker stop spring-caching postgres-15 &&

# remove previous containers
docker rm spring-caching postgres-15 &&

# regenerate source files after recent changes
./mvnw clean package -DskipTests &&

# rebuilt the docker services by ignoring the cache
docker compose build --no-cache &&

# launch the services in background
docker compose up -d

# log the status of the services
last_command_status=$(echo $?)

if [ "$last_command_status" -eq 0 ]
then
    echo "All the service are up"
else
    echo "Something went wrong..."
fi