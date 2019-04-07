FROM centos:centos7
RUN yum update
RUN yum install -y php

RUN docker-php-ext-install pdo pdo_mysql
COPY src /var/www/html
COPY main.conf /etc/apache2/sites-enabled/main.conf
RUN rm -frv /etc/apache2/sites-enabled/000-default.conf
COPY php.ini /usr/local/etc/php/php.ini
RUN a2enmod rewrite && \
	service apache2 restart

EXPOSE 80