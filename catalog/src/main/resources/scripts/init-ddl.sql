---------------------  create project database  -------------------------------------

CREATE DATABASE ecommerce
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

---------------------  create project schema  -------------------------------------


CREATE SCHEMA catalog_service
    AUTHORIZATION postgres;


---------------------  create category table -------------------------------------

CREATE TABLE catalog_service.category
(
    id serial,
    name character varying NOT NULL,
    description character varying,
    created_date timestamp with time zone,
    last_modified_date time with time zone,
    created_by character varying,
    last_modified_by character varying,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS catalog_service.category
    OWNER to postgres;


---------------------  create product table -------------------------------------
CREATE TABLE catalog_service.product
(
    id serial,
    name character varying,
    sku character varying,
    description character varying,
    stock integer,
    status boolean,
    category_id integer,
    created_date timestamp with time zone,
    last_modified_date time with time zone,
    created_by character varying,
    last_modified_by character varying,
    PRIMARY KEY (id),
    CONSTRAINT fk_category FOREIGN KEY (category_id)
        REFERENCES catalog_service.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS catalog_service.product
    OWNER to postgres;
