package calender;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CreateAccount2 extends JFrame implements ActionListener, ItemListener {

	Font font = new Font("맑은 고딕", Font.PLAIN, 20);
	JLabel jl_id = new JLabel("ID: ");
	JLabel jl_pw = new JLabel("PW: ");
	JLabel jl_dept = new JLabel("부서명: ");
	String[] array_dept = { "총무팀", "개발팀", "영업팀" };
	JLabel jl_name = new JLabel("성명: ");
	JLabel jl_sex = new JLabel("성별: ");
	JLabel jl_mail = new JLabel("E-Mail: ");
	JTextField idTextField = new JTextField(20);
	JPasswordField pwField = new JPasswordField(20);
	JComboBox<String> jc_dept = new JComboBox<>(array_dept);
	JTextField nameTextField = new JTextField(20);

	JRadioButton jrb_male = new JRadioButton("남", false);
	JRadioButton jrb_female = new JRadioButton("여", false);

	JTextField mailIdTextField = new JTextField(20);
	JTextField domainTextField = new JTextField(20);
	JLabel at = new JLabel("@");

	String[] domains = { "직접 입력", "gmail.com", "naver.com", "hanmail.net", "hotmail.com", "nate.com", "kakao.com" };
	JComboBox<String> jc_domain = new JComboBox<>(domains);

	JPanel jp_jrb = new JPanel();
	ButtonGroup bg = new ButtonGroup();
	JButton signUpButton = new JButton("등록");
	JButton closeButton = new JButton("닫기");
	String id = null;
	String pw = null;
	String dept = null;
	String name = null;
	String sex = null;
	String mailId = null;
	String domain = null;
	String address = null;

	public CreateAccount2() {
		initDisplay();
	}

	public void initDisplay() {

		this.setTitle("회원 가입");
		this.setLayout(null);

		// 아이디 입력
		this.add(jl_id);
		jl_id.setFont(font);
		jl_id.setBounds(50, 50, 100, 30);
		this.add(idTextField);
		idTextField.setFont(font);
		idTextField.setBounds(150, 50, 150, 30);

		// 비밀번호 입력
		this.add(jl_pw);
		jl_pw.setFont(font);
		jl_pw.setBounds(50, 100, 100, 30);
		this.add(pwField);
		pwField.setFont(font);
		pwField.setBounds(150, 100, 150, 30);

		// 부서명 선택 - 콤보박스
		this.add(jl_dept);
		jl_dept.setFont(font);
		jl_dept.setBounds(50, 150, 100, 30);
		this.add(jc_dept);
		jc_dept.setFont(font);
		jc_dept.setBounds(150, 150, 150, 30);

		// 이름 입력
		this.add(jl_name);
		jl_name.setFont(font);
		jl_name.setBounds(50, 200, 100, 30);
		this.add(nameTextField);
		nameTextField.setFont(font);
		nameTextField.setBounds(150, 200, 150, 30);

		// 성별 선택 - 라디오 버튼
		bg = new ButtonGroup();
		bg.add(jrb_female);
		bg.add(jrb_male);
		this.add(jl_sex);
		jl_sex.setFont(font);
		jl_sex.setBounds(50, 250, 100, 30);
		jp_jrb.setFont(font);
		jp_jrb.setBounds(120, 245, 200, 100);
		jp_jrb.add(jrb_male);
		jp_jrb.add(jrb_female);
		this.add(jp_jrb);
		jrb_male.addItemListener(this);
		jrb_female.addItemListener(this);

		// 메일 주소 입력
				this.add(jl_mail);
		jl_mail.setFont(font);
		jl_mail.setBounds(50, 300, 100, 30);
		this.add(mailIdTextField);
		mailIdTextField.setFont(font);
		mailIdTextField.setFont(font);
		mailIdTextField.setBounds(150, 300, 150, 30);
		this.add(at);
		at.setFont(font);
		at.setBounds(130, 350, 150, 30);
		this.add(domainTextField);
		jc_domain.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				Object obj = ie.getSource();
				if (jc_domain.getSelectedItem() == domains[0]) {
					domainTextField.setEnabled(true);
					domain = domainTextField.getText();
				} else if (jc_domain.getSelectedItem() != domains[0]) {
					domainTextField.setEnabled(false);
					domain = jc_domain.getSelectedItem().toString();
					domainTextField.setText(domain);
				}

			}
		});
		domainTextField.setFont(font);
		domainTextField.setBounds(150, 350, 150, 30);

		this.add(jc_domain);
		jc_domain.setFont(font);
		jc_domain.setBounds(150, 400, 150, 30);

		// 회원가입버튼
		this.add(signUpButton);
		signUpButton.setBounds(60, 450, 100, 50);
		signUpButton.setFont(font);
		signUpButton.addActionListener(this);
		this.add(closeButton);
		closeButton.setBounds(210, 450, 100, 50);
		closeButton.setFont(font);
		closeButton.addActionListener(this);

		this.setSize(400, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new CreateAccount2();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if (closeButton == obj) {
			dispose();
		} else if (signUpButton == obj) {
			id = idTextField.getText();
			pw = new String(pwField.getPassword());
			dept = jc_dept.getSelectedItem().toString();
			name = nameTextField.getText();
			mailId = mailIdTextField.getText();
			address = mailIdTextField.getText() + "@" + domainTextField.getText();
			System.out.println(id + " " + " " + pw + " " + dept + " " + name + "  " + sex + "  " + address);
		}
	}

	public void itemStateChanged(ItemEvent ie) {
		if (ie.getStateChange() == ItemEvent.SELECTED) {
			if (ie.getItem() == jrb_male) {
				sex = jrb_male.isSelected() ? "남" : "여";
			} else if (ie.getItem() == jrb_female) {
				sex = jrb_female.isSelected() ? "여" : "남";
			}
		}
	}
}