# my-paymnet-app

1. Creating Repository
  a. separate repo for each microservice
     independent upgrade, deploy, scale
  b. common repo for all microservices
     easy to manage, deploy together
     create my-payment-app repo inside that we can create separate folder for each microservice
     create docker-compose file in root folder
     create parent pom.xml in root folder
     create separate pom.xml for each microservice & inherit parent pom.xml

2. Creating Docker Compose file
   points to remember
   1. add -Duser.timezone=Asia/Kolkata in vm option if get error after start
   2. to see db login to http://localhost:5050 on browser when container is running
   3. use credentials: given in this file pgadmin section(email & password)
   4. create new server there add (schema will be automatially created as public & database will be payments)
      - name: payments
      - host: postgres
      - port: 5432
      - username: payments
      - password: payments

   5. Bash at docker file location
      - docker compose up -d
      - docker compose down
      - docker exec -t payments_postgres pg_dump -U payments payments > payments_dump.sql -> for db table storing data in file
      - psql -U payments -d payments < payments_dump.sql  -> for restoring db table from file
      
3. Creating Keycloak
   1. update docker-compose file with keycloak section
   2. open browser http://localhost:8080 LOGIN with admin/admin
   3. create realm, client, roles, users in keycloak
   6. credentials -> client secret - gIs7cUCEC53Aq5nCm5tcgM075Ccggueg
   8. root uri -> http://localhost:8081
   9. valid redirect uri -> *
   10. user details
        Username: amol
        email:amol@test.com
        password: password