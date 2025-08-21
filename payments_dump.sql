--
-- PostgreSQL database dump
--

\restrict QO8f9sJRMPh3OocFCdHbFOi5Uhe6TOVaIyFk386ANVJDG85LCF7JYmbJ04mxlCD

-- Dumped from database version 16.10 (Debian 16.10-1.pgdg13+1)
-- Dumped by pg_dump version 16.10 (Debian 16.10-1.pgdg13+1)

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
-- Name: users; Type: TABLE; Schema: public; Owner: payments
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    approved boolean NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE public.users OWNER TO payments;

--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: payments
--

COPY public.users (id, approved, email, password, username) FROM stdin;
ef8b3581-dc6d-4c65-ac3d-b9985a080bfa	f	amol@test.com	secret	amol
b0890117-9787-4826-b5a2-abfce9b41afc	f	amol1@test.com	secret1	amol1
c1cd5250-ba05-4f5a-a332-25b0af1406fd	f	amol2@test.com	secret2	amol2
6b8679db-8d1f-4885-a91b-dfdb534f5ab2	f	amol3@test.com	secret3	amol3
23e7b398-f121-44d9-85ef-42be5b9ab460	f	amol4@test.com	secret4	amol4
\.


--
-- Name: users uk6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: payments
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- Name: users ukr43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: payments
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: payments
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict QO8f9sJRMPh3OocFCdHbFOi5Uhe6TOVaIyFk386ANVJDG85LCF7JYmbJ04mxlCD

