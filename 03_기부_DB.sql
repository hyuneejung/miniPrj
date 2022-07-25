--MINIPRJ[기부]
DROP TABLE DONATION;
CREATE TABLE DONATION(
    NO NUMBER PRIMARY KEY  
    , NAME VARCHAR2(100) NOT NULL   
    , OBJECT VARCHAR2(1000) NOT NULL  
    , ADDEDPOINT NUMBER DEFAULT 0  NOT NULL
);

COMMENT ON COLUMN DONATION.NO IS '번호'; 
COMMENT ON COLUMN DONATION.NAME IS '기부지이름'; 
COMMENT ON COLUMN DONATION.OBJECT IS '기부금쓰임'; 
COMMENT ON COLUMN DONATION.ADDEDPOINT IS '누적기부금액'; 

INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(1, '그린피스', '환경파괴의 실태를 폭로하고, 과학연구를 통해 환경 보호를 실천합니다.');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(2, 'Sea Shepherd' , ' 해양 생물 보호 단체 입니다. 바다생물을 지켜주세요!');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(3, '서울 환경 연합', ' 환경에 대한 시민에 인식을 높이기 위한 사업을 합니다. ');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(4, '기후프로젝트 NGO', '환경교육, 환경캠페인, 에너지 취약계층을 위한 구호활동, 동물보호활동 등에 사용됩니다. ');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(5, '환경재단', ' 환경의, 환경에 의한, 환경을 위한 많은 캠페인을 실천합니다 ');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(6, '재단법인 녹색미래', ' 미세먼지 및 화학물질, 생태 등을 지속가능한 생태계 유지를 위해 활동합니다.');


SELECT * FROM DONATION;