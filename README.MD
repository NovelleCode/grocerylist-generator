# Grocery list generator
----------------------------------------------------
###Setup PostgreSQL with docker
1. Turn on Docker Desktop
2. Open terminal of your choice
3. Type `docker run --name postgresqldb -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres`
    - Press enter, make sure that you got a running container with the name "postgresqldb" in your Docker Desktop
4. Type `docker ps` you will see the container id of your Docker container, copy it
5. Type ` docker exec -it nameofcontainer psql -U postgres`
6. Type `CREATE DATABASE grocerylistgenerator;` Don't forget `;`. You will see a message `CREATE DATABASE`
7. Type `\c grocerylistgenerator` to connect to database.

Useful commands in database:
- \dt 			- to see relations
- \d 			- to see tables and relations
- \d nameoftable 	- to see columns of chosen table.