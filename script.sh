#!/bin/bash

MYSQL_CONTAINER_NAME='mysql-container'

docker container start $MYSQL_CONTAINER_NAME

# # ID do container de desenvolvimento
# MYSQL_CONTAINER_ID='c35efbde67a4'
# MYSQL_CONTAINER=$(docker container list -q)
# if [ "$MYSQL_CONTAINER" = "$MYSQL_CONTAINER_ID" ]; then
#     echo 'Container já em execução!'
# else
#     echo 'Iniciando container...'
#     docker container start $MYSQL_CONTAINER_ID
#     echo 'Container '$MYSQL_CONTAINER_ID' iniciado! '
# fi

