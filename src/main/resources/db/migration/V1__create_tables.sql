CREATE TABLE IF NOT EXISTS sotrydnik (
    id_sotrydnika SERIAL PRIMARY KEY,
    familiya VARCHAR(50) NOT NULL,
    imya VARCHAR(30) NOT NULL,
    otchestvo VARCHAR(30),
    dolzhnost VARCHAR(30),
    email VARCHAR(30) NOT NULL,
    nomer_telefona CHAR(12) NOT NULL
);

CREATE TABLE IF NOT EXISTS uchastnik (
    id_uchastnika SERIAL PRIMARY KEY,
    familiya VARCHAR(50) NOT NULL,
    imya VARCHAR(30) NOT NULL,
    otchestvo VARCHAR(30),
    kolichestvo_kuplennyh_tovarov INT NOT NULL
);

CREATE TABLE IF NOT EXISTS auktsion (
    id_auktsiona SERIAL PRIMARY KEY,
    id_sotrydnika INT NOT NULL REFERENCES sotrydnik(id_sotrydnika),
    nazvanie VARCHAR(50) NOT NULL,
    data_provedeniya DATE NOT NULL,
    status VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS lot (
    id_lota SERIAL PRIMARY KEY,
    nazvanie VARCHAR(50) NOT NULL,
    opisanie VARCHAR(30) NOT NULL,
    startovaya_tsena INT NOT NULL,
    rezervnaya_tsena INT NOT NULL,
    status VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS sdelka (
    id_sdelki SERIAL PRIMARY KEY,
    finalnaya_tsena INT NOT NULL,
    summa_k_oplate INT NOT NULL,
    summa_k_vyplate INT NOT NULL,
    status VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS stavka (
    id_stavki SERIAL PRIMARY KEY,
    id_sdelki INT NOT NULL REFERENCES sdelka(id_sdelki),
    id_lota INT NOT NULL REFERENCES lot(id_lota),
    id_uchastnika INT NOT NULL REFERENCES uchastnik(id_uchastnika),
    summa_stavki INT NOT NULL,
    vremya_stavki TIME NOT NULL
);

CREATE TABLE IF NOT EXISTS registratsiya (
    id_registratsii SERIAL PRIMARY KEY,
    id_auktsiona INT NOT NULL REFERENCES auktsion(id_auktsiona),
    id_uchastnika INT NOT NULL REFERENCES uchastnik(id_uchastnika),
    nomer_uchastnika INT NOT NULL,
    status_dostupa VARCHAR(50) NOT NULL,
    summa_zadatka INT NOT NULL
);