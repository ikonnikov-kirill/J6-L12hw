CREATE SEQUENCE public.orders_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.orders_id_seq
    OWNER TO postgres;

CREATE TABLE public.orders
(
    id bigint NOT NULL DEFAULT nextval('orders_id_seq'::regclass),
    customer_id bigint NOT NULL,
    date date NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT fk_orders_customer FOREIGN KEY (customer_id)
        REFERENCES public.customers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE public.orders
    OWNER to postgres;

CREATE INDEX fki_fk_orders_customer
    ON public.orders USING btree
        (customer_id ASC NULLS LAST)
    TABLESPACE pg_default;