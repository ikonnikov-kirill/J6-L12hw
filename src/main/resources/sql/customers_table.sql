CREATE SEQUENCE IF NOT EXISTS public.customers_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.customers_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.customer
(
    id bigint NOT NULL DEFAULT nextval('customers_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.customers
    OWNER to postgres;