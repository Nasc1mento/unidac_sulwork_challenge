DROP DATABASE IF EXISTS BREAKFAST;

CREATE DATABASE IF NOT EXISTS BREAKFAST;

USE BREAKFAST;

CREATE TABLE IF NOT EXISTS EMPLOYEE (
	EMP_ID INT NOT NULL AUTO_INCREMENT,
	EMP_NAME VARCHAR(128) NOT NULL,
	EMP_CPF VARCHAR(11) NOT NULL,
	PRIMARY KEY(EMP_ID)
);

CREATE TABLE IF NOT EXISTS ITEM (
	ITM_ID INT NOT NULL AUTO_INCREMENT,
	ITM_NAME VARCHAR(128) NOT NULL,
	ITM_DATE TIMESTAMP NOT NULL,
	ITM_USR_ID INT NOT NULL,
	PRIMARY KEY(ITM_ID),
	CONSTRAINT FK_ITM_USR_ID FOREIGN KEY(ITM_USR_ID) REFERENCES EMPLOYEE(EMP_ID) ON DELETE CASCADE
);
