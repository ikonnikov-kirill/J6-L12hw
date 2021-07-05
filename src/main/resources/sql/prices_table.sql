CREATE SEQUENCE public.prices_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.prices_id_seq
    OWNER TO postgres;

CREATE TABLE public.prices
(
    id bigint NOT NULL DEFAULT nextval('prices_id_seq'::regclass),
    cost real NOT NULL,
    date date NOT NULL,
    CONSTRAINT prices_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.prices
    OWNER to postgres;