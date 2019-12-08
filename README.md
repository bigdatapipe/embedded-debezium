# Change Data Capture (CDC) with Embedded Debezium and SpringBoot

Blog URL: https://medium.com/@sohan_ganapathy/change-data-capture-cdc-with-embedded-debezium-and-springboot-6f10cd33d8ec

## Prerequisites
- [Docker](https://docs.docker.com/v17.09/engine/installation/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Installing required tools

Once the prerequisites are installed, run the command.

```shell
docker-compose up -d
```

## Student table

```sql
CREATE TABLE company
(
    id integer NOT NULL,
    address character varying(255),
    code character varying(255),
    name character varying(255),
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
```

## Starting the SpringBoot application

The the folder `company-cdc-test`, run the command

```shell
mvn spring-boot:run
```

## Scripts to Insert, Update and Delete a record on Postgres

```sql
INSERT INTO COMPANY(ID, NAME, ADDRESS, CODE) VALUES('2','wydewy','Beijing, Haidian','dskncndjncsd');

UPDATE COMPANY SET CODE='cdcdvdfvxdfv', NAME='vnique' WHERE ID = 2; 

DELETE FROM COMPANY WHERE ID = 1;
```

## Elasticsearch commands to test if CDC worked !

```shell
curl -X GET http://cent1:9200/company/company/1?pretty=true
```
