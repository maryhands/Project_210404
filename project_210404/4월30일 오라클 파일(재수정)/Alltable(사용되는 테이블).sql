CREATE TABLE PROJECT.ACCOUNT_INFO
(
  MEMBER_CODE  NUMBER(20)                       NOT NULL,
  ID           VARCHAR2(30 BYTE),
  PW           VARCHAR2(50 BYTE),
  NAME         VARCHAR2(50 BYTE),
  DEPARTMENT   VARCHAR2(50 BYTE),
  GENDER       VARCHAR2(10 BYTE),
  EMAIL        VARCHAR2(100 BYTE)
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


--  There is no statement for index PROJECT.SYS_C0010046.
--  The object is created when the parent object is created.

CREATE UNIQUE INDEX PROJECT.XPKACCOUNT_INFO ON PROJECT.ACCOUNT_INFO
(MEMBER_CODE)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE PROJECT.ACCOUNT_INFO ADD (
  CONSTRAINT XPKACCOUNT_INFO
  PRIMARY KEY
  (MEMBER_CODE)
  USING INDEX PROJECT.XPKACCOUNT_INFO
  ENABLE VALIDATE,
  UNIQUE (ID, PW, NAME, DEPARTMENT, GENDER, EMAIL)
  USING INDEX
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                BUFFER_POOL      DEFAULT
               )
  ENABLE VALIDATE);
/


CREATE TABLE PROJECT.DATEMEMO
(
  MEMBER_CODE   NUMBER(20)                      NOT NULL,
  DATELIST_NUM  NUMBER(10)                      NOT NULL,
  MONTH         NUMBER(2),
  DAY           NUMBER(2),
  MASSAGE       VARCHAR2(4000 BYTE),
  YEAR          NUMBER(4)
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


--  There is no statement for index PROJECT.SYS_C0010043.
--  The object is created when the parent object is created.

--  There is no statement for index PROJECT.SYS_C0010044.
--  The object is created when the parent object is created.

--  There is no statement for index PROJECT.SYS_C0010047.
--  The object is created when the parent object is created.

CREATE UNIQUE INDEX PROJECT.XPKDATEMEMO ON PROJECT.DATEMEMO
(MEMBER_CODE)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE PROJECT.DATEMEMO ADD (
  PRIMARY KEY
  (MEMBER_CODE, DATELIST_NUM)
  USING INDEX
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                BUFFER_POOL      DEFAULT
               )
  ENABLE VALIDATE,
  UNIQUE (DATELIST_NUM)
  USING INDEX
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                BUFFER_POOL      DEFAULT
               )
  ENABLE VALIDATE,
  UNIQUE (MONTH, DAY)
  USING INDEX
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                BUFFER_POOL      DEFAULT
               )
  ENABLE VALIDATE);

ALTER TABLE PROJECT.DATEMEMO ADD (
  CONSTRAINT R_6 
  FOREIGN KEY (MEMBER_CODE) 
  REFERENCES PROJECT.ACCOUNT_INFO (MEMBER_CODE)
  ENABLE VALIDATE);
/



CREATE TABLE PROJECT.RECORD_WORK_DATA
(
  GT_WORK      VARCHAR2(30 BYTE),
  LEV_WORK     VARCHAR2(30 BYTE),
  MEMBER_CODE  NUMBER(20)                       NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


--  There is no statement for index PROJECT.SYS_C0010048.
--  The object is created when the parent object is created.

CREATE UNIQUE INDEX PROJECT.XPKRECORD_WORK_DATA ON PROJECT.RECORD_WORK_DATA
(MEMBER_CODE)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE PROJECT.RECORD_WORK_DATA ADD (
  CONSTRAINT XPKRECORD_WORK_DATA
  PRIMARY KEY
  (MEMBER_CODE)
  USING INDEX PROJECT.XPKRECORD_WORK_DATA
  ENABLE VALIDATE,
  UNIQUE (GT_WORK, LEV_WORK)
  USING INDEX
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                BUFFER_POOL      DEFAULT
               )
  ENABLE VALIDATE);

ALTER TABLE PROJECT.RECORD_WORK_DATA ADD (
  CONSTRAINT R_3 
  FOREIGN KEY (MEMBER_CODE) 
  REFERENCES PROJECT.ACCOUNT_INFO (MEMBER_CODE)
  ENABLE VALIDATE);
/



CREATE TABLE PROJECT.SAVE_REC_EMAIL
(
  REC_EMAIL    VARCHAR2(50 BYTE),
  MEMBER_CODE  NUMBER(20)                       NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX PROJECT.XPKSAVE_REC_EMAIL ON PROJECT.SAVE_REC_EMAIL
(MEMBER_CODE)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE PROJECT.SAVE_REC_EMAIL ADD (
  CONSTRAINT XPKSAVE_REC_EMAIL
  PRIMARY KEY
  (MEMBER_CODE)
  USING INDEX PROJECT.XPKSAVE_REC_EMAIL
  ENABLE VALIDATE);

ALTER TABLE PROJECT.SAVE_REC_EMAIL ADD (
  CONSTRAINT R_2 
  FOREIGN KEY (MEMBER_CODE) 
  REFERENCES PROJECT.ACCOUNT_INFO (MEMBER_CODE)
  ENABLE VALIDATE);
