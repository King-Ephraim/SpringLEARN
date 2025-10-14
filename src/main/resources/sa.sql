/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  code
 * Created: 13 oct. 2025
 */

-- Création de la base de données
CREATE DATABASE SA;

-- Table CLIENT
CREATE TABLE CLIENT (
    ID SERIAL PRIMARY KEY,
    EMAIL VARCHAR(50)
);

-- Table SENTIMENT
CREATE TABLE SENTIMENT (
    ID SERIAL PRIMARY KEY,
    TEXTE VARCHAR(50),
    TYPE VARCHAR(10),
    CLIENT_ID INTEGER,
    CONSTRAINT client_fk FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT (ID)
);
