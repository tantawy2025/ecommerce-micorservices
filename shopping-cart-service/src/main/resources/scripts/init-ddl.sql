---------------------  create project schema  -------------------------------------


CREATE SCHEMA cart_service
    AUTHORIZATION postgres;


---------------------  create shopping cart table -------------------------------------
CREATE TABLE cart_service.shopping_cart
(
    id serial,
    customer_id character varying NOT NULL,
    created_date timestamp with time zone,
    last_modified_date time with time zone,
    created_by character varying,
    last_modified_by character varying,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS cart_service.shopping_cart
    OWNER to postgres;


---------------------  create product table -------------------------------------
CREATE TABLE cart_service.cart_item
(
    id serial,
    cart_id integer,
    product_id integer,
    quantity integer,
    created_date timestamp with time zone,
    last_modified_date time with time zone,
    created_by character varying,
    last_modified_by character varying,
    PRIMARY KEY (id),
    CONSTRAINT cart_fk FOREIGN KEY (cart_id)
        REFERENCES cart_service.shopping_cart (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID
);

ALTER TABLE IF EXISTS cart_service.cart_item
    OWNER to postgres;
