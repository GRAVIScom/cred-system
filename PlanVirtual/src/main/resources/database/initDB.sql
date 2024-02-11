CREATE TABLE IF NOT EXISTS clients
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(20)  NOT NULL ,
    passnumber VARCHAR(20) NOT NUll
    );
CREATE TABLE IF NOT EXISTS loan_templates
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    limit BIGSERIAL NOT NULL ,
    rate BIGSERIAL  NOT NULL
    );
CREATE TABLE IF NOT EXISTS loan_offers
(
    id    BIGSERIAL PRIMARY KEY ,
    id_client    BIGSERIAL NOT NULL ,
    id_loan_template   BIGSERIAL NOT NULL ,
    limit BIGSERIAL NOT NULL ,
    summ BIGSERIAL NOT NULL ,
    rate BIGSERIAL  NOT NULL
    );
CREATE TABLE IF NOT EXISTS pay_shedule
(
    id    BIGSERIAL PRIMARY KEY ,
    date DATE NOT NULL ,
    summ_body BIGSERIAL NOT NULL ,
    summ_percent BIGSERIAL NOT NULL ,
    );