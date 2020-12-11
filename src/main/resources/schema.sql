CREATE TABLE onlinefit_user
(
    id         INTEGER      NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    username   VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL,
    job_title  VARCHAR(100),
    race       VARCHAR(50),
    gender     VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE SEQUENCE hibernate_sequence INCREMENT BY 1 MINVALUE 1;