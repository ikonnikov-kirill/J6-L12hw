CREATE SEQUENCE public.orders_products_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.orders_products_id_seq
    OWNER TO postgres;

CREATE TABLE public.orders_products
(
    id bigint NOT NULL DEFAULT nextval('orders_products_id_seq'::regclass),
    product_id bigint NOT NULL,
    order_id bigint NOT NULL,
    price_id bigint NOT NULL,
    CONSTRAINT orders_products_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_products_prices FOREIGN KEY (price_id)
        REFERENCES public.prices (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_order_products_products FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_orders_product_orders FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE public.orders_products
    OWNER to postgres;

CREATE INDEX fki_fk_order_products_prices
    ON public.orders_products USING btree
        (price_id ASC NULLS LAST)
    TABLESPACE pg_default;

CREATE INDEX fki_fk_order_products_products
    ON public.orders_products USING btree
        (product_id ASC NULLS LAST)
    TABLESPACE pg_default;

CREATE INDEX fki_fk_orders_product_orders
    ON public.orders_products USING btree
        (order_id ASC NULLS LAST)
    TABLESPACE pg_default;