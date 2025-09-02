--liquibase formatted sql

--changeset amol:add-bigint-id
ALTER TABLE users ADD COLUMN new_id BIGSERIAL;

-- copy data? (optional: if you want to keep UUIDs as external reference)
-- UPDATE users SET new_id = nextval('users_new_id_seq');

-- drop old PK
ALTER TABLE users DROP CONSTRAINT users_pkey;

-- make new_id the PK
ALTER TABLE users ADD PRIMARY KEY (new_id);

-- optional: drop old uuid column
-- ALTER TABLE users DROP COLUMN id;

-- or rename for safety
ALTER TABLE users RENAME COLUMN id TO old_uuid_id;
ALTER TABLE users RENAME COLUMN new_id TO id;
