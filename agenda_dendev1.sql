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
-- Name: patient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.patient (
    idpatient integer NOT NULL,
    name character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    rg character varying(12) NOT NULL,
    phonenumber1 character varying(12) NOT NULL,
    phonenumber2 character varying(12),
    dateofbirth date NOT NULL,
    createdat timestamp without time zone NOT NULL,
    address character varying(100) NOT NULL,
    email character varying(50) NOT NULL,
    sigtap character varying(15) NOT NULL
);


ALTER TABLE public.patient OWNER TO postgres;

--
-- Name: patient_idpatient_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.patient_idpatient_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.patient_idpatient_seq OWNER TO postgres;

--
-- Name: patient_idpatient_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.patient_idpatient_seq OWNED BY public.patient.idpatient;


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
    typeuser character varying(6) NOT NULL,
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
    crmconsultationdoctor character varying(9) NOT NULL,
    officeaddress character varying(100) NOT NULL,
    dateandtimeconsultation timestamp without time zone NOT NULL,
    idpublicagent integer NOT NULL,
    idsolicitation integer NOT NULL
);


ALTER TABLE public.query OWNER TO postgres;

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
-- Name: query_idsolicitation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.query_idsolicitation_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.query_idsolicitation_seq OWNER TO postgres;

--
-- Name: query_idsolicitation_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.query_idsolicitation_seq OWNED BY public.query.idsolicitation;


--
-- Name: solicitation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solicitation (
    idsolicitation integer NOT NULL,
    crm character varying(9) NOT NULL,
    request character varying(150) NOT NULL,
    nameofrequestdoctor character varying(50) NOT NULL,
    idpatient integer NOT NULL
);


ALTER TABLE public.solicitation OWNER TO postgres;

--
-- Name: solicitation_idpatient_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.solicitation_idpatient_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.solicitation_idpatient_seq OWNER TO postgres;

--
-- Name: solicitation_idpatient_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.solicitation_idpatient_seq OWNED BY public.solicitation.idpatient;


--
-- Name: solicitation_idsolicitation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.solicitation_idsolicitation_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.solicitation_idsolicitation_seq OWNER TO postgres;

--
-- Name: solicitation_idsolicitation_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.solicitation_idsolicitation_seq OWNED BY public.solicitation.idsolicitation;


--
-- Name: patient idpatient; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient ALTER COLUMN idpatient SET DEFAULT nextval('public.patient_idpatient_seq'::regclass);


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
-- Name: query idsolicitation; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query ALTER COLUMN idsolicitation SET DEFAULT nextval('public.query_idsolicitation_seq'::regclass);


--
-- Name: solicitation idsolicitation; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitation ALTER COLUMN idsolicitation SET DEFAULT nextval('public.solicitation_idsolicitation_seq'::regclass);


--
-- Name: solicitation idpatient; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitation ALTER COLUMN idpatient SET DEFAULT nextval('public.solicitation_idpatient_seq'::regclass);


--
-- Data for Name: patient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.patient (idpatient, name, cpf, rg, phonenumber1, phonenumber2, dateofbirth, createdat, address, email, sigtap) FROM stdin;
\.


--
-- Data for Name: public_agent; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.public_agent (idpublicagent, name, cpf, rg, phonenumber1, phonenumber2, dateofbirth, createdat, address, email, userr, password, typeuser) FROM stdin;
\.


--
-- Data for Name: query; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.query (idquery, nameofconsultationdoctor, crmconsultationdoctor, officeaddress, dateandtimeconsultation, idpublicagent, idsolicitation) FROM stdin;
\.


--
-- Data for Name: solicitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.solicitation (idsolicitation, crm, request, nameofrequestdoctor, idpatient) FROM stdin;
\.


--
-- Name: patient_idpatient_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.patient_idpatient_seq', 1, false);


--
-- Name: public_agent_idpublicagent_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.public_agent_idpublicagent_seq', 1, false);


--
-- Name: query_idpublicagent_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.query_idpublicagent_seq', 1, false);


--
-- Name: query_idquery_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.query_idquery_seq', 1, false);


--
-- Name: query_idsolicitation_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.query_idsolicitation_seq', 1, false);


--
-- Name: solicitation_idpatient_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.solicitation_idpatient_seq', 1, false);


--
-- Name: solicitation_idsolicitation_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.solicitation_idsolicitation_seq', 1, false);


--
-- Name: patient patient_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_cpf_key UNIQUE (cpf);


--
-- Name: patient patient_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_email_key UNIQUE (email);


--
-- Name: patient patient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (idpatient);


--
-- Name: patient patient_rg_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_rg_key UNIQUE (rg);


--
-- Name: patient patient_sigtap_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_sigtap_key UNIQUE (sigtap);


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
-- Name: solicitation solicitation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitation
    ADD CONSTRAINT solicitation_pkey PRIMARY KEY (idsolicitation);


--
-- Name: query query_idpublicagent_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query
    ADD CONSTRAINT query_idpublicagent_fkey FOREIGN KEY (idpublicagent) REFERENCES public.public_agent(idpublicagent);


--
-- Name: query query_idsolicitation_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query
    ADD CONSTRAINT query_idsolicitation_fkey FOREIGN KEY (idsolicitation) REFERENCES public.solicitation(idsolicitation);


--
-- Name: solicitation solicitation_idpatient_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitation
    ADD CONSTRAINT solicitation_idpatient_fkey FOREIGN KEY (idpatient) REFERENCES public.patient(idpatient);


--
-- PostgreSQL database dump complete
--

