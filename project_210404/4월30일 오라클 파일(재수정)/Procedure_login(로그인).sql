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
                     WHERE id=p_id AND pw=p_pw),'��й�ȣ�� Ʋ���ϴ�.') INTO msg FROM dual;
    ELSIF connect_statue = '-1' THEN
    msg := '���̵� �������� �ʽ��ϴ�.';
    END IF;             
END;
/

drop procedure p_login;