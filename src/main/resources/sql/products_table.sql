CREATE SEQUENCE public.products_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.products_id_seq
    OWNER TO postgres;


CREATE TABLE public.products
(
    id bigint NOT NULL DEFAULT nextval('products_id_seq'::regclass),
    title character varying COLLATE pg_catalog."default" NOT NULL,
    price_id bigint,
    CONSTRAINT products_pkey PRIMARY KEY (id),
    CONSTRAINT fk_products_prices FOREIGN KEY (price_id)
        REFERENCES public.prices (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.products
    OWNER to postgres;

CREATE INDEX fki_fk_products_prices
    ON public.products USING btree
    (price_id ASC NULLS LAST)
    TABLESPACE pg_default;