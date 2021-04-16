CREATE OR REPLACE PROCEDURE PROJECT.proc_login
(p_id IN VARCHAR2
,p_pw IN VARCHAR2
,msg OUT VARCHAR2)
                  
IS
   connect_statue VARCHAR2(100);
BEGIN
   SELECT NVL((SELECT id FROM ACCOUNT_INFO 
                 WHERE id=p_id),-1) INTO connect_statue
                 FROM dual;
    IF(connect_statue = p_id) THEN
         SELECT NVL((SELECT name FROM ACCOUNT_INFO 
                     WHERE id=p_id AND pw=p_pw),'비밀번호가 틀립니다.') INTO msg FROM dual;
    ELSIF connect_statue = '-1' THEN
    msg := '아이디가 존재하지 않습니다.';
    END IF;             
END;
/

drop procedure p_login;