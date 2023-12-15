package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.studentDaoImpl;
import model.student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;
	private JTable table;
	private JTextField displayTextField;
	private JTextField inputTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel.setBounds(145, 6, 142, 33);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(16, 43, 401, 154);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(14, 28, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("國文");
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(158, 28, 46, 15);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("英文");
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(269, 26, 46, 19);
		panel.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setBounds(53, 27, 85, 21);
		panel.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		chi.setBounds(198, 26, 55, 21);
		panel.add(chi);
		chi.setColumns(10);
		
		eng = new JTextField();
		eng.setColumns(10);
		eng.setBounds(323, 26, 55, 21);
		panel.add(eng);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 210, 401, 210);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(86, 55, 1, 1);
		panel_1.add(table);
		
		JButton newButton = new JButton("新增");
		
		newButton.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		newButton.setBounds(27, 66, 87, 37);
		panel.add(newButton);
		
		JButton newButton_1 = new JButton("清除");
		newButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText(null);
				chi.setText(null);
				eng.setText(null);
				
			}
		});
		newButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		newButton_1.setBounds(26, 111, 87, 37);
		panel.add(newButton_1);
		
		displayTextField = new JTextField();
		displayTextField.setBounds(230, 102, 96, 21);
		panel.add(displayTextField);
		displayTextField.setColumns(10);
		
		inputTextField = new JTextField();
		inputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Integer lcdQ=Integer.parseInt(inputTextField.getText());
				displayTextField.setText(""+(lcdQ*100));
			}
		});
		inputTextField.setColumns(10);
		inputTextField.setBounds(121, 103, 96, 21);
		panel.add(inputTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 50, 377, 150);
		panel_1.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JButton queryButton = new JButton("查詢");
		queryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(new studentDaoImpl().queryAll());
			}
		});
		queryButton.setBounds(28, 4, 87, 38);
		panel_1.add(queryButton);
		queryButton.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		
		JButton queryButton_1 = new JButton("查詢");
		queryButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.List-->queryAll2();
				 * 2.show:String;
				 * 
				 */
				List<student> l=new studentDaoImpl().queryAll2();
				String show="";
				int sum=0;
				int i=0;
				
				for(student o:l)
				{
					i++;
					sum=sum+(o.getChi()+o.getEng());
					show=show+"id="+o.getId()+
							"\t姓名="+o.getName()+
							"\t國文="+o.getChi()+
							"\t英文="+o.getEng()+
							"\t總分="+(o.getChi()+o.getEng())+"\n";
				}
				show=show+"總分平均="+(sum/i);
				output.setText(show);
			}
		});
		queryButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		queryButton_1.setBounds(213, 3, 87, 38);
		panel_1.add(queryButton_1);
		
		newButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				//String Chi =chi.getText();
				//String Eng =eng.getText();
				
//				(name.getText()=="" || name.getText()=="")
				
				if ((name.getText().length()==0) || (chi.getText().length()==0) || (eng.getText().length()==0))
				{
					
						JOptionPane.showMessageDialog(contentPane,"不可寫空白","會員登入",1);
						//message.setText("123");
				}
				else
				{
					 int CHI=Integer.parseInt(chi.getText());
					 int ENG=Integer.parseInt(eng.getText());
					 student s=new student(Name,CHI,ENG);
					 new studentDaoImpl().add(s);
						
				
				}
				
				
				
					
						 
					
				
				
				
				

				
				
			}
		});
		
	}
}
