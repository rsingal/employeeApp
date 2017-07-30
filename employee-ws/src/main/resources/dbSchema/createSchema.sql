-- **********************************************************************
-- From User: SYSTEM 
-- **********************************************************************
BEGIN
	BEGIN
		EXECUTE IMMEDIATE 'DROP USER RSINGAL CASCADE';
	EXCEPTION
		WHEN OTHERS THEN
		IF SQLCODE != -1918 THEN
			RAISE;
		END IF;
	END;
	EXECUTE IMMEDIATE 'CREATE USER rsingal IDENTIFIED BY "rsingal" DEFAULT TABLESPACE "USERS" TEMPORARY TABLESPACE "TEMP"';
	EXECUTE IMMEDIATE 'GRANT all privileges to rsingal identified by rsingal';
	EXECUTE IMMEDIATE 'GRANT CONNECT, DBA to rsingal identified by rsingal';
	EXECUTE IMMEDIATE 'ALTER USER rsingal QUOTA UNLIMITED ON USERS';
END;

-- **********************************************************************
-- From User: RSINGAL, Delete data from all tables, Make sure to Commit
-- **********************************************************************
DELETE EMPLOYEE CASCADE;
COMMIT;

-- **********************************************************************
-- From User: RSINGAL, Create all tables
-- **********************************************************************
-- Table EMPLOYEE
-- **********************************************************************
CREATE TABLE "EMPLOYEE" 
	(	"ID_EMPLOYEE" NUMBER(4,0) NOT NULL ENABLE, 
		"NAME" VARCHAR2(32 BYTE) NOT NULL ENABLE, 
		"AGE" NUMBER(4,0) NOT NULL ENABLE
	);
