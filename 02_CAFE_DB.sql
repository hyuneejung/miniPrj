--MINIPRJ[CAFE]
DROP TABLE CAFE;
CREATE TABLE CAFE(
    NO NUMBER PRIMARY KEY
    , NAME VARCHAR2(100) NOT NULL
    , CUPPOINT NUMBER DEFAULT 300 NOT NULL
    , TUMPOINT NUMBER NOT NULL
    , SECRETCODE NUMBER NOT NULL UNIQUE
);
COMMENT ON COLUMN CAFE.NO IS '��ȣ'; 
COMMENT ON COLUMN CAFE.NAME IS '�����̸�'; 
COMMENT ON COLUMN CAFE.CUPPOINT IS '��������'; 
COMMENT ON COLUMN CAFE.TUMPOINT IS '�Һ���������'; 
COMMENT ON COLUMN CAFE.SECRETCODE IS '���������ȣ'; 

INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(1, 'PaulBassett', 500, 1234);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(2, 'AngelInUs', 400, 1236);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(3, 'KrispyKreme', 400, 5432);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(4, 'Starbucks', 300,1332);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(5, 'CafeBene', 300, 2421);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(6, 'CoffeeBean', 300, 4242);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(7, 'PASCUCCI', 300, 1239);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(8, 'HOLLYS', 300, 1663);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(9, 'TOMNTOMS', 300, 7547);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(10, 'aTwosomePlace', 300, 2428);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(11, 'YOGERPRESSO', 300, 5221);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(12, 'DUNKINDONUTS', 300, 4211);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(13, 'BaskinRabbins31', 300, 2232);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(14, 'CoffeeBay', 200, 5525);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(15, 'LOTTERIA', 200, 5689);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(16, 'KFC', 200, 2483);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(17, 'POPEYES', 200, 5991);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(18, 'BUGGERKING', 200, 4860);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(19, 'EDIYACOFFEE', 200, 3429);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(20, 'McDonalds', 200, 8806);
INSERT INTO CAFE (NO, NAME, TUMPOINT, SECRETCODE)VALUES(21, 'PAIKSCOFFEE', 100, 8990);

SELECT * FROM CAFE;