# Use an official MySQL image as the base
FROM mysql:8.0

LABEL author="Your Name here"
LABEL description="MySQL Image for training"
LABEL version="1.0"

# Copy the SQL dump file into the container (if needed)
COPY *.sql /docker-entrypoint-initdb.d/

# Configuration files if necessary (uncomment and adjust as needed)
# COPY ./my.cnf /etc/mysql/conf.d/my.cnf
