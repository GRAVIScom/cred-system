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
    limits BIGSERIAL NOT NULL ,
    rate BIGSERIAL  NOT NULL
    );
CREATE TABLE IF NOT EXISTS loan_offers
(
    id    BIGSERIAL PRIMARY KEY ,
    id_client    BIGSERIAL NOT NULL ,
    id_loan_template   BIGSERIAL NOT NULL ,
    summ BIGSERIAL NOT NULL ,
    rate DOUBlE PRECISION NOT NULL,
    limits BIGSERIAL NOT NULL,
    datePayment date
);
CREATE TABLE IF NOT EXISTS pay_shedule
(
    id    BIGSERIAL PRIMARY KEY ,
    date DATE NOT NULL ,
    summ_body BIGSERIAL NOT NULL ,
    summ_percent BIGSERIAL NOT NULL
);
INSERT INTO loan_offers VALUES
                            (2,13, 55,2000000, 15.5, 36,'2024-01-01'),
                            (3,14, 68,1500000, 15.5, 42,'2024-01-01'),
                            (4,15, 123,100000, 15.5, 22,'2024-01-01'),
                            (5,16, 178,4000000, 15.5,49,'2024-01-01');
