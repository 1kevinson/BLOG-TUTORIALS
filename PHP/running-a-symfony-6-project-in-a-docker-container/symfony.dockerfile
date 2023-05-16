FROM php:8.2.2

RUN apt-get update -y && apt-get install -y libmcrypt-dev
RUN apt-get install --yes zip

RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer
RUN curl -sS https://get.symfony.com/cli/installer | bash

WORKDIR /var/www/html
RUN mkdir php8-sf6

WORKDIR /var/www/html/php8-sf6
COPY composer.json ./
RUN composer install

COPY . ./

EXPOSE 8000

RUN mv /root/.symfony5/bin/symfony /usr/local/bin/symfony
CMD symfony server:start