
---------------------  create project schema  -------------------------------------


CREATE SCHEMA customer_service
    AUTHORIZATION postgres;


---------------------  create pricing table -------------------------------------
CREATE TABLE customer_service.customer
(
    id serial,
    name character varying NOT NULL,
    balance numeric,
    created_date timestamp with time zone,
    last_modified_date time with time zone,
    created_by character varying,
    last_modified_by character varying,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS customer_service.customer
    OWNER to postgres;