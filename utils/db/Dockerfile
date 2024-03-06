FROM mysql:latest

COPY ./db/init.sql /docker-entrypoint-initdb.d/init.sql

ENV MYSQL_ROOT_PASSWORD=1234

EXPOSE 3306