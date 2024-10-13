
---------------------  create project schema  -------------------------------------


CREATE SCHEMA discount_service
    AUTHORIZATION postgres;


---------------------  create pricing table -------------------------------------
CREATE TABLE discount_service.discount
(
    id serial,
    sku character varying NOT NULL,
    discount_percentage numeric,
    created_date timestamp with time zone,
    last_modified_date time with time zone,
    created_by character varying,
    last_modified_by character varying,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS discount_service.discount
    OWNER to postgres;