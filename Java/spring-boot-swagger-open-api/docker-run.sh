docker run --restart=unless-stopped \
           --name=postgres-15 \
           --env POSTGRES_USER=postgres \
           --env POSTGRES_PASSWORD=motdepasse \
           --env POSTGRES_DB=productdb \
           --publish 5432:5432 \
           -v db:/var/lib/postgresql/data \
           -d postgres:15-alpine


# Check the volume have been created
docker volume ls

# Check that the container is up and running
docker ps