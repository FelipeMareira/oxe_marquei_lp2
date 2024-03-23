--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Ubuntu 16.2-1.pgdg22.04+1)
-- Dumped by pg_dump version 16.2 (Ubuntu 16.2-1.pgdg22.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: citizen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.citizen (
    idcitizen integer NOT NULL,
    name character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    rg character varying(12) NOT NULL,
    phonenumber1 character varying(12) NOT NULL,
    phonenumber2 character varying(12),
    dateofbirth date NOT NULL,
    createdat timestamp without time zone NOT NULL,
    address character varying(100) NOT NULL,
    email character varying(30) NOT NULL,
    sigtap character varying(15) NOT NULL
);


ALTER TABLE public.citizen OWNER TO postgres;

--
-- Name: citizen_idcitizen_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.citizen_idcitizen_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.citizen_idcitizen_seq OWNER TO postgres;

--
-- Name: citizen_idcitizen_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.citizen_idcitizen_seq OWNED BY public.citizen.idcitizen;


--
-- Name: forwarding; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.forwarding (
    idforwarding integer NOT NULL,
    crm character varying(9) NOT NULL,
    request character varying(150) NOT NULL,
    nameofrequestdoctor character varying(50) NOT NULL,
    idcitizen integer NOT NULL
);


ALTER TABLE public.forwarding OWNER TO postgres;

--
-- Name: forwarding_idcitizen_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.forwarding_idcitizen_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.forwarding_idcitizen_seq OWNER TO postgres;

--
-- Name: forwarding_idcitizen_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.forwarding_idcitizen_seq OWNED BY public.forwarding.idcitizen;


--
-- Name: forwarding_idforwarding_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.forwarding_idforwarding_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.forwarding_idforwarding_seq OWNER TO postgres;

--
-- Name: forwarding_idforwarding_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.forwarding_idforwarding_seq OWNED BY public.forwarding.idforwarding;


--
-- Name: public_agent; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.public_agent (
    idpublicagent integer NOT NULL,
    name character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    rg character varying(12) NOT NULL,
    phonenumber1 character varying(12) NOT NULL,
    phonenumber2 character varying(12),
    dateofbirth date NOT NULL,
    createdat timestamp without time zone NOT NULL,
    address character varying(100) NOT NULL,
    email character varying(30) NOT NULL,
    userr character varying(30) NOT NULL,
    password character varying(15) NOT NULL,
    typeuser character varying(6),
    CONSTRAINT public_agent_typeuser_check CHECK (((typeuser)::text = ANY ((ARRAY['normal'::character varying, 'admin'::character varying])::text[])))
);


ALTER TABLE public.public_agent OWNER TO postgres;

--
-- Name: public_agent_idpublicagent_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.public_agent_idpublicagent_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.public_agent_idpublicagent_seq OWNER TO postgres;

--
-- Name: public_agent_idpublicagent_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.public_agent_idpublicagent_seq OWNED BY public.public_agent.idpublicagent;


--
-- Name: query; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.query (
    idquery integer NOT NULL,
    nameofconsultationdoctor character varying(50) NOT NULL,
    officeaddress character varying(100) NOT NULL,
    dateandtimeconsultation timestamp without time zone NOT NULL,
    idpublicagent integer NOT NULL,
    idforwarding integer NOT NULL
);


ALTER TABLE public.query OWNER TO postgres;

--
-- Name: query_idforwarding_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.query_idforwarding_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.query_idforwarding_seq OWNER TO postgres;

--
-- Name: query_idforwarding_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.query_idforwarding_seq OWNED BY public.query.idforwarding;


--
-- Name: query_idpublicagent_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.query_idpublicagent_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.query_idpublicagent_seq OWNER TO postgres;

--
-- Name: query_idpublicagent_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.query_idpublicagent_seq OWNED BY public.query.idpublicagent;


--
-- Name: query_idquery_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.query_idquery_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.query_idquery_seq OWNER TO postgres;

--
-- Name: query_idquery_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.query_idquery_seq OWNED BY public.query.idquery;


--
-- Name: citizen idcitizen; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.citizen ALTER COLUMN idcitizen SET DEFAULT nextval('public.citizen_idcitizen_seq'::regclass);


--
-- Name: forwarding idforwarding; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forwarding ALTER COLUMN idforwarding SET DEFAULT nextval('public.forwarding_idforwarding_seq'::regclass);


--
-- Name: forwarding idcitizen; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forwarding ALTER COLUMN idcitizen SET DEFAULT nextval('public.forwarding_idcitizen_seq'::regclass);


--
-- Name: public_agent idpublicagent; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_agent ALTER COLUMN idpublicagent SET DEFAULT nextval('public.public_agent_idpublicagent_seq'::regclass);


--
-- Name: query idquery; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query ALTER COLUMN idquery SET DEFAULT nextval('public.query_idquery_seq'::regclass);


--
-- Name: query idpublicagent; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query ALTER COLUMN idpublicagent SET DEFAULT nextval('public.query_idpublicagent_seq'::regclass);


--
-- Name: query idforwarding; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query ALTER COLUMN idforwarding SET DEFAULT nextval('public.query_idforwarding_seq'::regclass);


--
-- Name: citizen citizen_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.citizen
    ADD CONSTRAINT citizen_cpf_key UNIQUE (cpf);


--
-- Name: citizen citizen_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.citizen
    ADD CONSTRAINT citizen_email_key UNIQUE (email);


--
-- Name: citizen citizen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.citizen
    ADD CONSTRAINT citizen_pkey PRIMARY KEY (idcitizen);


--
-- Name: citizen citizen_rg_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.citizen
    ADD CONSTRAINT citizen_rg_key UNIQUE (rg);


--
-- Name: citizen citizen_sigtap_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.citizen
    ADD CONSTRAINT citizen_sigtap_key UNIQUE (sigtap);


--
-- Name: forwarding forwarding_crm_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forwarding
    ADD CONSTRAINT forwarding_crm_key UNIQUE (crm);


--
-- Name: forwarding forwarding_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forwarding
    ADD CONSTRAINT forwarding_pkey PRIMARY KEY (idforwarding);


--
-- Name: public_agent public_agent_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_agent
    ADD CONSTRAINT public_agent_cpf_key UNIQUE (cpf);


--
-- Name: public_agent public_agent_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_agent
    ADD CONSTRAINT public_agent_email_key UNIQUE (email);


--
-- Name: public_agent public_agent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_agent
    ADD CONSTRAINT public_agent_pkey PRIMARY KEY (idpublicagent);


--
-- Name: public_agent public_agent_rg_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_agent
    ADD CONSTRAINT public_agent_rg_key UNIQUE (rg);


--
-- Name: public_agent public_agent_userr_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_agent
    ADD CONSTRAINT public_agent_userr_key UNIQUE (userr);


--
-- Name: query query_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query
    ADD CONSTRAINT query_pkey PRIMARY KEY (idquery);


--
-- Name: forwarding forwarding_idcitizen_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forwarding
    ADD CONSTRAINT forwarding_idcitizen_fkey FOREIGN KEY (idcitizen) REFERENCES public.citizen(idcitizen);


--
-- Name: query query_idforwarding_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query
    ADD CONSTRAINT query_idforwarding_fkey FOREIGN KEY (idforwarding) REFERENCES public.forwarding(idforwarding);


--
-- Name: query query_idpublicagent_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query
    ADD CONSTRAINT query_idpublicagent_fkey FOREIGN KEY (idpublicagent) REFERENCES public.public_agent(idpublicagent);


--
-- PostgreSQL database dump complete
--

