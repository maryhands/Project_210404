CREATE OR REPLACE PROCEDURE SCOTT.proc_login69
(u_id IN varchar2
,u_pw IN varchar2
,msg OUT varchar2)
IS
    r_status varchar2(100);
BEGIN
    SELECT NVL((SELECT mem_id FROM member69
                 WHERE mem_id=u_id),'-1') INTO r_status
      FROM dual;
    --dbms_output.put_line('r_status:'||r_status);
    IF r_status=u_id  THEN
     SELECT NVL((SELECT nickname FROM member69
                  WHERE mem_id=u_id AND mem_pw=u_pw),'��й�ȣ�� Ʋ���ϴ�.') INTO msg FROM dual;
    ELSIF r_status='-1' THEN
     msg:='���̵� �������� �ʽ��ϴ�.';
    END IF;  
END;
/