package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import calendar.CreateAccount;
import login.LoginDao;
import java.awt.Window;

public class LoginLogic implements ActionListener {
	
	LoginView lv = new LoginView();
	CreateAccount ca = new CreateAccount();

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (lv.jbtn_add == obj) {
			ca.initDisplay();
			this.dispose();
		}
		else if (lv.jbtn_login == obj) {
			LoginDao md = new LoginDao();

			if ("".equals(lv.jtf_id.getText()) || "".equals(lv.jpf_pw.getPassword())) {
				JOptionPane.showMessageDialog(lv, "아이디와 비번을 확인하세요");
				return;// actionPerformed 탈출하기
			}

			try {
				String	mem_id	= lv.jtf_id.getText();
				String	mem_pw	= lv.jpf_pw.getPassword().toString();
				String	msg		= md.login(mem_id, mem_pw);

				if ("비밀번호가 틀립니다.".equals(msg)) {
					JOptionPane.showMessageDialog(lv, "비번을 확인하세요");
					lv.jpf_pw.setText("");
					return;
				}
				else if ("아이디가 존재하지 않습니다.".equals(msg)) {
					JOptionPane.showMessageDialog(lv, "아이디를 확인하세요");
					lv.jtf_id.setText("");
					return;
				}
				else {
					JOptionPane.showMessageDialog(lv, "로그인 성공", "info", JOptionPane.INFORMATION_MESSAGE);
					lv.setVisible(false);

				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
