--MINIPRJ[���]
DROP TABLE DONATION;
CREATE TABLE DONATION(
    NO NUMBER PRIMARY KEY  
    , NAME VARCHAR2(100) NOT NULL   
    , OBJECT VARCHAR2(1000) NOT NULL  
    , ADDEDPOINT NUMBER DEFAULT 0  NOT NULL
);

COMMENT ON COLUMN DONATION.NO IS '��ȣ'; 
COMMENT ON COLUMN DONATION.NAME IS '������̸�'; 
COMMENT ON COLUMN DONATION.OBJECT IS '��αݾ���'; 
COMMENT ON COLUMN DONATION.ADDEDPOINT IS '������αݾ�'; 

INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(1, '�׸��ǽ�', 'ȯ���ı��� ���¸� �����ϰ�, ���п����� ���� ȯ�� ��ȣ�� ��õ�մϴ�.');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(2, 'Sea Shepherd' , ' �ؾ� ���� ��ȣ ��ü �Դϴ�. �ٴٻ����� �����ּ���!');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(3, '���� ȯ�� ����', ' ȯ�濡 ���� �ùο� �ν��� ���̱� ���� ����� �մϴ�. ');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(4, '����������Ʈ NGO', 'ȯ�汳��, ȯ��ķ����, ������ �������� ���� ��ȣȰ��, ������ȣȰ�� � ���˴ϴ�. ');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(5, 'ȯ�����', ' ȯ����, ȯ�濡 ����, ȯ���� ���� ���� ķ������ ��õ�մϴ� ');
INSERT INTO DONATION (NO, NAME, OBJECT)VALUES(6, '��ܹ��� ����̷�', ' �̼����� �� ȭ�й���, ���� ���� ���Ӱ����� ���°� ������ ���� Ȱ���մϴ�.');


SELECT * FROM DONATION;