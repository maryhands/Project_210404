Create or replace procedure proc_IDOverlap(p_id IN varchar2
                                           , msg OUT varchar2)
                                           
is
    r_status varchar(10);
begin

SELECT NVL((
            SELECT 1 FROM dual WHERE EXISTS(SELECT id FROM ACCOUNT_INFO WHERE id = p_id))
            , 0) result INTO r_status FROM dual;
            
IF(r_status > 0) THEN
    msg := '�̹� ��ϵǾ� �ֽ��ϴ�.';
ELSE
    msg := '��� �����մϴ�.';
END IF; 
end;
/   