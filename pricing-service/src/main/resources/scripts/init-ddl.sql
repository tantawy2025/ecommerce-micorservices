
---------------------  create project schema  -------------------------------------


CREATE SCHEMA pricing_service
    AUTHORIZATION postgres;


---------------------  create pricing table -------------------------------------

CREATE TABLE pricing_service.pricing
(
    id serial,
    sku character varying,
    amount numeric,
    currency character varying,
    start_date timestamp with time zone,
    end_date timestamp with time zone,
	created_date timestamp with time zone,
    last_modified_date time with time zone,
    created_by character varying,
    last_modified_by character varying,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS pricing_service.pricing
    OWNER to postgres;