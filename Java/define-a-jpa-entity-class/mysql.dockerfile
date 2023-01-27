FROM mysql:latest

LABEL author="Kevin Kouomeu"
LABEL description="MySQL Image for demo"

ENV MYSQL_DATABASE="demodb"
ENV MYSQL_USER="dbuser"
ENV MYSQL_PASSWORD="dbpass"
ENV MYSQL_ROOT_PASSWORD="secret-root"

RUN echo "MYSQL_USER $MYSQL_USER"
RUN echo "MYSQL_DATABASE $MYSQL_DATABASE"