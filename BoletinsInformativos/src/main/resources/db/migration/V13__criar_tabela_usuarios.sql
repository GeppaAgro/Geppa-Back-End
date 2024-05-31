CREATE TABLE IF NOT EXISTS users
(
    id                      SERIAL PRIMARY KEY,
    user_name               varchar(255) DEFAULT NULL,
    full_name               varchar(255) DEFAULT NULL,
    password                varchar(255) DEFAULT NULL,
    account_non_expired     boolean      DEFAULT NULL,
    account_non_locked      boolean      DEFAULT NULL,
    credentials_non_expired boolean      DEFAULT NULL,
    enabled                 boolean      DEFAULT NULL,
    CONSTRAINT uk_user_name UNIQUE (user_name)
);