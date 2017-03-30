package Database.design.build;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.FlatteningPathIterator;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Calendar;
import java.util.EventObject;

public class Pannel extends JFrame{
	//타 클래스 정의
	Control _control;
	Model _model;
	Pannel pannel;
	
	//메인 프레임&컨테이너 정의
	JFrame frame;
	Container contentPane;
	JFrame sub = new JFrame("전체 내역");
	Container subContainer;
	
	//서브 패널 & 버튼 생성( 전체 회원/트레이너/골프프로 )
	JPanel subPanel = new JPanel();
	JButton check = new JButton("닫기");
	JTable coustomerTable;	//JTable 객체
	JTable trainerTable;	//JTable 객체
	JTable golfProTable;	//JTable 객체
	JScrollPane scrollPane;	//스크롤 객체
	DefaultTableCellRenderer celAlignCenter;	//레이블 가운데 정렬 위한 객체
	
	//( PT/ Lesson )
	JTable PTTable;	//JTable 객체
	JTable LessonTable;	//JTable 객체
	JTable PTMTable;	//JTable 객체
	JTable LessonMTable;	//JTable 객체
	
	// Sales;
	JTable SalesMTable;
	JTable SalesCTable;
	JTable SalesPTTable;
	JTable SalesLessonTable;
	
	//스크롤바&메뉴바 정의
	
	JMenuBar menubar;
	JMenu jmenu;
	
	//메뉴 패널&레이블 정의
	JPanel manuPanel;
	JLabel adminID;
	JButton member;
	JButton course;
	JButton profit;
	
	//공용 레이블 & 텍스트 & 버튼 정의
	String ID = "DB";
	String PW = "0000";
	JLabel ID_L = new JLabel(  "     I      D     : ");
	JTextArea ID_T = new JTextArea();
	JLabel PW_L = new JLabel("PassWord : ");
	//JTextArea PW_T = new JTextArea();
	JPasswordField PW_PF = new JPasswordField();
	JButton LoginBtn = new JButton("LogIn");
	
	JLabel OfficialNoteL = new JLabel("비고 : ");
	JTextArea OfficialNoteT	= new JTextArea();
	
	JLabel blank[] = new JLabel[4];
	JLabel OfficialNoteL_DB = new JLabel("병력 없음\n.");//;
	
	//ActionListenner 한번 생성
	private boolean Memberflag = true;
	private boolean Courseflag = true;
	private boolean Profitflag = true;
	
	private boolean CustomerEflag = true;
	private boolean CustomerQflag = true;
	private boolean TrainerEflag = true;
	private boolean TrainerQflag = true;
	private boolean GolfProEflag = true;
	private boolean GolfProQflag = true;
	private boolean EliteCEflag = true;
	private boolean EliteCQueryflag = true;
	private boolean EliteCEnrollflag = true;
	
	private boolean CustomerOverlapflag = true;
	private boolean TrainerOverlapflag = true;
	private boolean GolfProOverlapflag = true;
	
	private boolean CustomerEnrollflag = true;
	private boolean TrainerEnrollflag = true;
	private boolean GolfProEnrollflag = true;
	
	private boolean CustomerQBflag = true;
	private boolean TrainerQBflag = true;
	private boolean GolfProQBflag = true;
	
	
	private boolean PEflag = true;
	private boolean PQflag = true;
	private boolean PMflag = true;
	private boolean PMQflag = true;
	private boolean LEflag = true;
	private boolean LQflag = true;
	private boolean LMflag = true;
	private boolean LMQflag = true;
		
	private boolean PTQBflag = true;
	private boolean PTMQBflag = true;
	private boolean LessonQBflag = true;
	private boolean LessonMQBflag = true;
		
	private boolean PTEnrollflag = true;
	private boolean PTMEnrollflag = true;
	private boolean LessonEnrollflag = true;
	private boolean LessonMEnrollflag = true;
	
	private boolean ProfitEnrollflag = true;
	private boolean ProfitQueryflag = true;
	
	private boolean ProfitEnrollMflag = true;
	private boolean ProfitEnrollCflag = true;
	
	private boolean SaleQueryMflag = true;
	private boolean SaleQueryCflag = true;
	private boolean SaleQueryPflag = true;
	private boolean SaleQueryLflag = true;
	
	//왼쪽 & 가운데 패널 정의
	JPanel west;
	JPanel center;
	JPanel south = new JPanel();
	JPanel north = new JPanel();

	//KEY
	private boolean blank_once = true;
	private boolean CM = false;	//개인정보
	private boolean CMCE = false;	//회원 등록
	private boolean CMCQ = false;	//회원 조회
	private boolean CMCAQ = false;	//회원 전체 조회
	private boolean CMTE = false;	//트레이너 등록
	private boolean CMTQ = false;	//트레이너 조회
	private boolean CMTAQ = false;	//트레이너 전체 조회
	private boolean CMGE = false;	//골프프로 등록
	private boolean CMGQ = false;	//골프프로 조회
	private boolean CMGAQ = false;	//트레이너 전체 조회
	private boolean CMEE = false;	//트레이너 전체 조회
	
	private boolean CC = false;		//코스
	private boolean CCPE = false;	//PT 등록
	private boolean CCPQ = false;	//PT 조회
	private boolean CCPAQ = false;	//PT 전체 조회
	private boolean CCPM = false;	//PT 관리
	private boolean CCPMQ = false;	//PT 관리 조회
	private boolean CCPMAQ = false;	//PT 관리 전체 조회
	private boolean CCLE = false;	//Lesson 등록
	private boolean CCLQ = false;	//Lesson 조회
	private boolean CCLAQ = false;	//Lesson 전체 조회
	private boolean CCLM = false;	//Lesson 관리
	private boolean CCLMQ = false;	//Lesson 관리 조회
	private boolean CCLMAQ = false;	//Lesson 관리 전체 조회
	
	private boolean CP = false;		//매출
	private boolean CPE = false;	//매출 등록
	private boolean CPQ = false;	//매출 등록
	private boolean CPQM = false;	//매출 등록
	private boolean CPQC = false;	//매출 등록
	private boolean CPQP = false;	//매출 등록
	private boolean CPQL = false;	//매출 등록
	
	//Click Button
	String clickBtn = new String("");	//이전에 눌렀던 버튼 기록
	
	//Color
	ColorUIResource BtnColor = new ColorUIResource(238,238,238);	//기본 버튼 UIR
	
	//생성자
	Pannel(Control control, Model pMember){
		_control = control;
		_model = pMember;
	}
	
	//로그인 화면 구성
	public void Login(){
		JFrame Loginframe = new JFrame("관리자 프로그램");
		Loginframe.setLocation(400,200);
		Loginframe.setMinimumSize(new Dimension(800,580));
		Container LoginContentPane = Loginframe.getContentPane();
		
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.FirstLabel.setBounds(100, 100, 600, 220);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,6));

		ID_L.setBounds(150, 150, 180, 50);
		ID_L.setFont(new Font("", Font.BOLD, 30));
		ID_T.setBounds(340, 160, 130, 30);
		ID_T.setFont(new Font("", Font.BOLD, 20));
		ID_T.setBorder(new LineBorder(Color.black,1));
		PW_L.setBounds(150, 200, 180, 50);
		PW_L.setFont(new Font("", Font.BOLD, 30));
		PW_PF.setBounds(340, 210, 130, 30);
		PW_PF.setFont(new Font("", Font.BOLD, 20));
		PW_PF.setBorder(new LineBorder(Color.black,1));
		LoginBtn.setBounds(490, 160, 130, 80);
		LoginBtn.setFont(new Font("", Font.BOLD, 30));
		
		
		center.add(_model.FirstLabel);
		center.add(ID_L);
		center.add(ID_T);
		center.add(PW_L);
		center.add(PW_PF);
		center.add(LoginBtn);
		
		LoginContentPane.add(center, BorderLayout.CENTER);
		
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.equals(ID_T.getText()) && PW.equals(PW_PF.getText())){
					Loginframe.dispose();
					createMain();
				}
				else{
					JOptionPane.showMessageDialog(pannel, "ID 또는 PW가 잘못 되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		//frame 설정
		Loginframe.setResizable(false);// frame 사이즈 변경 불가능
		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Loginframe.pack();
		Loginframe.setVisible(true);
	}
	
	
	//메인 프레임 화면 구성
	public void createMain(){
		frame = new JFrame("관리자 프로그램");
		frame.setLocation(400,200);
		frame.setMinimumSize(new Dimension(800,580));
		contentPane = frame.getContentPane();
		
		//메뉴바 추가
		menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu jmenu = new JMenu("파일");
		menubar.add(jmenu);
		JMenuItem j1, j2, j3;
		j1 = new JMenuItem("메인 화면");
		j2 = new JMenuItem("데이터");
		j3 = new JMenuItem("관리");
		jmenu.add(j1);
		jmenu.add(j2);
		jmenu.add(j3);
		jmenu.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		j1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		j2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		j3.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		
		//메뉴 버튼 생성
		manuButton();
		
		//frame 설정
		frame.setResizable(false);// frame 사이즈 변경 불가능
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	//메뉴 버튼 생성
	public void manuButton(){
		//메뉴 버튼 객체생성
		manuPanel = new JPanel();
		manuPanel.setLayout(new GridLayout(1, 4));
		adminID = new JLabel("Admin ID : "+ID);
		member = new JButton("개인 정보");
		course = new JButton("Lesson 정보");
		profit = new JButton("매출 정보");
		
		//메뉴 패널에 버튼 추가
		manuPanel.add(adminID);
		manuPanel.add(member);
		manuPanel.add(course);
		manuPanel.add(profit);
		
		//메뉴 버튼 폰트 설정
		adminID.setFont(new Font("", Font.BOLD, 20));
		adminID.setBorder(new LineBorder(Color.black,1));
		member.setFont(new Font("", Font.BOLD, 20));
		course.setFont(new Font("", Font.BOLD, 20));
		profit.setFont(new Font("", Font.BOLD, 20));
		
		//컨테이너에 패널들 추가
		contentPane.add(manuPanel, BorderLayout.NORTH);

		if(Memberflag){
			//개인 정보 버튼을 눌렀을 때
			member.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(CC)
						contentPane.remove(west);
					else if(CM)
						contentPane.remove(west);
					else if(CP)
						contentPane.remove(west);
					memberRemoveCenter();		//멤버 버튼 중에 중앙 패널 사용한 패널 지우기
					classRemoveCenter();
					profitRemoveCenter();
					memberRemoveScroll();
					classRemoveScroll();
					profitRemoveScroll();
					
					CM = true;
					
					memberCheckBgcolor(clickBtn);		//개인정보에서 이전에 눌러서 색이 바뀐 버튼을 기본 버튼으로 변경
					classCheckBgcolor(clickBtn);
					MemberALLCLEAR();
					CourseALLCLEAR();
					ProfitALLCLEAR();
					
					createMember();
				}
			});
			Memberflag = false;
		}
		
		if(Courseflag){
			//lesson 정보 버튼을 눌렀을 때
			course.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(CC)
						contentPane.remove(west);
					else if(CM)
						contentPane.remove(west);
					else if(CP)
						contentPane.remove(west);
					memberRemoveCenter();	//멤버 버튼 중에 중앙 패널 사용한 패널 지우기
					classRemoveCenter();
					profitRemoveCenter();
					memberRemoveScroll();
					classRemoveScroll();
					profitRemoveScroll();
			
					CC = true;
					
					memberCheckBgcolor(clickBtn);
					classCheckBgcolor(clickBtn);
					MemberALLCLEAR();
					CourseALLCLEAR();
					ProfitALLCLEAR();
					
					createClass();
				}
			});
			Courseflag = false;
		}
		
		if(Profitflag){
			//매출 정보 버튼 눌렀을 때
			profit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(CC)
						contentPane.remove(west);
					else if(CM)
						contentPane.remove(west);
					else if(CP)
						contentPane.remove(west);
					memberRemoveCenter();	//멤버 버튼 중에 중앙 패널 사용한 패널 지우기
					classRemoveCenter();
					profitRemoveCenter();
					memberRemoveScroll();
					classRemoveScroll();
					profitRemoveScroll();
			
					CP = true;
					
					memberCheckBgcolor(clickBtn);
					classCheckBgcolor(clickBtn);
					MemberALLCLEAR();
					CourseALLCLEAR();
					ProfitALLCLEAR();
					
					createProfit();
				}
			});
			Profitflag = false;
		}
	}
	
	//개인 정보
	public void createMember(){
		//서쪽 패널 생성
		west = new JPanel();
		west.setLayout(new GridLayout(7, 1));
		
		//패널에 버튼 추가
		west.add(_model.customerEnroll);
		west.add(_model.customerQuery);
		west.add(_model.healthTrainerEnroll);
		west.add(_model.healthTrainerQuery);
		west.add(_model.golfProEnroll);
		west.add(_model.golfProQuery);
		west.add(_model.EliteCustomerEnroll);
		
		//개인정보 폰트 설정
		_model.customerEnroll.setFont(new Font("", Font.BOLD, 18));
		_model.customerQuery.setFont(new Font("", Font.BOLD, 18));
		_model.healthTrainerEnroll.setFont(new Font("", Font.BOLD, 18));
		_model.healthTrainerQuery.setFont(new Font("", Font.BOLD, 18));
		_model.golfProEnroll.setFont(new Font("", Font.BOLD, 18));
		_model.golfProQuery.setFont(new Font("", Font.BOLD, 18));
		_model.EliteCustomerEnroll.setFont(new Font("", Font.BOLD, 18));
		
		if(CustomerEflag){
		//회원 등록 버튼을 눌렀을 때
		_model.customerEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberRemoveCenter();	//멤버 버튼 중에 중앙 패널 사용한 패널 지우기
				
				memberCheckBgcolor(clickBtn);
				_model.customerEnroll.setBackground(Color.LIGHT_GRAY);	//누른 버튼 색 변화
				clickBtn = e.getActionCommand();		//누른 버튼이 무었인지를 저장

				MemberALLCLEAR();
				
				createCustomerEnroll();
			}
		});
		CustomerEflag = false;
		}

		if(CustomerQflag){
		//회원 조회 버튼을 눌렀을 때
		_model.customerQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberRemoveCenter();
				memberRemoveScroll();

				memberCheckBgcolor(clickBtn);
				_model.customerQuery.setBackground(Color.LIGHT_GRAY);
				clickBtn = e.getActionCommand();
				sub.setTitle("회원 전체내역");
				
				MemberALLCLEAR();
				
				createCustomerQuery();
			}
		});
		CustomerQflag = false;
		}
		
		if(TrainerEflag){
		//트레이너 등록 버튼을 눌렀을 때
		_model.healthTrainerEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberRemoveCenter();
				
				memberCheckBgcolor(clickBtn);
				_model.healthTrainerEnroll.setBackground(Color.LIGHT_GRAY);
				clickBtn = e.getActionCommand();
				
				MemberALLCLEAR();
				
				createTrainerEnroll();
			}
		});
		TrainerEflag = false;
		}
		
		if(TrainerQflag){
		//트레이너 조회 버튼을 눌렀을 때
		_model.healthTrainerQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberRemoveCenter();
				memberRemoveScroll();
				
				memberCheckBgcolor(clickBtn);
				_model.healthTrainerQuery.setBackground(Color.LIGHT_GRAY);
				clickBtn = e.getActionCommand();
				sub.setTitle("트레이너 전체내역");
				
				MemberALLCLEAR();
				
				createTrainerQuery();
			}
		});
		TrainerQflag =false;
		}
		
		if(GolfProEflag){
		//골프프로 등록 버튼을 눌렀을 때
		_model.golfProEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberRemoveCenter();
				
				memberCheckBgcolor(clickBtn);
				_model.golfProEnroll.setBackground(Color.LIGHT_GRAY);
				clickBtn = e.getActionCommand();
				
				MemberALLCLEAR();
				
				createGolfEnroll();
			}
		});
		GolfProEflag =false;
		}
		
		if(GolfProQflag){
		//골프프로 조회 버튼을 눌렀을 때
		_model.golfProQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberRemoveCenter();
				memberRemoveScroll();
				
				memberCheckBgcolor(clickBtn);
				_model.golfProQuery.setBackground(Color.LIGHT_GRAY);
				clickBtn = e.getActionCommand();
				sub.setTitle("골프프로 전체내역");
				
				MemberALLCLEAR();
				
				createGolfQuery();
			}
		});
		GolfProQflag = false;
		}
		
		if(EliteCEflag){
		//우수회원 등록 버튼을 눌렀을 때
		_model.EliteCustomerEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memberRemoveCenter();
				memberRemoveScroll();
				
				memberCheckBgcolor(clickBtn);
				_model.EliteCustomerEnroll.setBackground(Color.LIGHT_GRAY);
				clickBtn = e.getActionCommand();
				
				MemberALLCLEAR();
				
				createEliteCustomerEnroll();
			}
		});
		EliteCEflag = false;
		}
		
		
		//컨테이너에 패널 추가			
		contentPane.add(west, BorderLayout.WEST);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//회원 등록
	public void createCustomerEnroll(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.FirstLabel.setBounds(-2, 0, 650, 50);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,2));

		_model.customerNumL.setBounds(10, 0, 100, 50);
		_model.customerNumL.setFont(new Font("", Font.BOLD, 18));
		_model.customerNumT.setBounds(110, 10, 130, 30);
		_model.customerNumT.setFont(new Font("", Font.BOLD, 18));
		_model.customerNumT.setBorder(new LineBorder(Color.black,1));
		_model.customerOverlapTest.setBounds(250, 10, 100, 30);
		_model.customerGenderL.setBounds(370, 0, 130, 50);
		_model.customerGenderL.setFont(new Font("", Font.BOLD, 18));
		_model.customerGenderT[0] = new JRadioButton("남");
		_model.customerGenderT[0].setBounds(465, 10, 65, 30);
		_model.customerGenderT[1] = new JRadioButton("여");
		_model.customerGenderT[1].setBounds(530, 10, 65, 30);
		
		_model.SecondLabel.setBounds(-2, 48, 650, 50);
		_model.SecondLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerNameL.setBounds(10, 48, 100, 50);
		_model.customerNameL.setFont(new Font("", Font.BOLD, 18));
		_model.customerNameT.setBounds(110, 58, 130, 30);
		_model.customerNameT.setFont(new Font("", Font.BOLD, 18));
		_model.customerNameT.setBorder(new LineBorder(Color.black,1));
		_model.customerBirthL.setBounds(370, 48, 100, 50);
		_model.customerBirthL.setFont(new Font("", Font.BOLD, 18));
		_model.customerBirthT.setBounds(465, 58, 130, 30);
		_model.customerBirthT.setFont(new Font("", Font.BOLD, 18));
		_model.customerBirthT.setBorder(new LineBorder(Color.black,1));
		
		_model.ThirdLabel.setBounds(-2, 96, 650, 50);
		_model.ThirdLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerPhoneL.setBounds(10, 96, 100, 50);
		_model.customerPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.customerPhoneT.setBounds(110, 106, 130, 30);
		_model.customerPhoneT.setFont(new Font("", Font.BOLD, 18));
		_model.customerPhoneT.setBorder(new LineBorder(Color.black,1));
		_model.customerPathL.setBounds(370, 96, 100, 50);
		_model.customerPathL.setFont(new Font("", Font.BOLD, 18));
		if(!CMCE){
			_model.customerPathT.addItem("광고");
			_model.customerPathT.addItem("지인의 소개");
			_model.customerPathT.addItem("이유 없음");
		}
		_model.customerPathT.setFont(new Font("", Font.BOLD, 18));
		_model.customerPathT.setBounds(465, 106, 130, 30);
		
		_model.FourthLabel.setBounds(-2, 144, 650, 50);
		_model.FourthLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerFirstDayL.setBounds(10, 144, 100, 50);
		_model.customerFirstDayL.setFont(new Font("", Font.BOLD, 18));
		_model.customerFirstDayT.setBounds(110, 154, 130, 30);
		_model.customerFirstDayT.setFont(new Font("", Font.BOLD, 18));
		_model.customerFirstDayT.setBorder(new LineBorder(Color.black,1));
		_model.customerLastDayL.setBounds(370, 144, 100, 50);
		_model.customerLastDayL.setFont(new Font("", Font.BOLD, 18));
		_model.customerLastDayT.setBounds(465, 154, 130, 30);
		_model.customerLastDayT.setFont(new Font("", Font.BOLD, 18));
		_model.customerLastDayT.setBorder(new LineBorder(Color.black,1));
		
		_model.FifthLabel.setBounds(-2, 192, 650, 50);
		_model.FifthLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerAddrL.setBounds(10, 192, 100, 50);
		_model.customerAddrL.setFont(new Font("", Font.BOLD, 18));
		_model.customerAddrT.setBounds(110, 202, 485, 30);
		_model.customerAddrT.setFont(new Font("", Font.BOLD, 18));
		_model.customerAddrT.setBorder(new LineBorder(Color.black,1));
		
		_model.SixthLabel.setBounds(-2, 240, 650, 120);
		_model.SixthLabel.setBorder(new LineBorder(Color.black,2));
		OfficialNoteL.setBounds(10, 240, 100, 50);
		OfficialNoteL.setFont(new Font("", Font.BOLD, 18));
		OfficialNoteT.setBounds(110, 250, 485, 100);
		OfficialNoteT.setFont(new Font("", Font.BOLD, 18));
		OfficialNoteT.setBorder(new LineBorder(Color.black,1));
		
		_model.customerEnrollBtn.setBounds(430, 413, 200, 35);
		_model.customerEnrollBtn.setFont(new Font("", Font.BOLD, 18));
		
		ButtonGroup genderG = new ButtonGroup();
		genderG.add(_model.customerGenderT[0]);
		genderG.add(_model.customerGenderT[1]);
		
		//패널에 추가
		center.add(_model.FirstLabel);
		center.add(_model.customerNumL);
		center.add(_model.customerNumT);
		center.add(_model.customerOverlapTest);
		center.add(_model.customerGenderL);
		center.add(_model.customerGenderT[0]);
		center.add(_model.customerGenderT[1]);
		
		center.add(_model.SecondLabel);
		center.add(_model.customerNameL);
		center.add(_model.customerNameT);
		center.add(_model.customerBirthL);
		center.add(_model.customerBirthT);
		
		center.add(_model.ThirdLabel);
		center.add(_model.customerPhoneL);
		center.add(_model.customerPhoneT);
		center.add(_model.customerPathL);
		center.add(_model.customerPathT);	
		
		center.add(_model.FourthLabel);
		center.add(_model.customerFirstDayL);
		center.add(_model.customerFirstDayT);
		center.add(_model.customerLastDayL);
		center.add(_model.customerLastDayT);
		
		center.add(_model.FifthLabel);
		center.add(_model.customerAddrL);
		center.add(_model.customerAddrT);
		
		center.add(_model.SixthLabel);
		center.add(OfficialNoteT);
		center.add(OfficialNoteL);
		
		center.add(_model.customerEnrollBtn);
		
		CMCE = true;
		
		if(CustomerEnrollflag){
			_model.customerEnrollBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(_model.customerGenderT[0].isSelected())
						_model.customerGender = "남자";
					else
						_model.customerGender = "여자";
					_control.setDBCustomer();
				}
			});
			CustomerEnrollflag = false;
		}
		
		_control.setCustomerDBCheck();
		if(_model.Count != 0)
			_model.customerNumT.setText(String.valueOf(Integer.parseInt(_model.customerNumL_DB[_model.Count-1].getText()) + 1)); 
		
		
		if(CustomerOverlapflag){
			_model.customerOverlapTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i< _model.Count; i++){
					System.out.println("확인 : "+_model.customerNumL_DB[i].getText());
					if(_model.customerNumT.getText().equals(_model.customerNumL_DB[i].getText()))
						JOptionPane.showMessageDialog(pannel, "동일한 회원코드가 있습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		CustomerOverlapflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		//frame.repaint();
		frame.setVisible(true);
	}
	
	//회원 조회
	public void createCustomerQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.customerInfoCombo.setBounds(50, 15, 200, 30);
		_model.customerInfoCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CMCQ){
			_model.customerInfoCombo.addItem("회원 번호");
			_model.customerInfoCombo.addItem("회원 명");
			_model.customerInfoCombo.addItem("전화 번호");
			_model.customerInfoCombo.addItem("전체 회원");
		}
		_model.customerInfoComboT.setBounds(270, 15, 130, 30);
		_model.customerInfoComboT.setFont(new Font("", Font.BOLD, 18));
		_model.customerInfoComboT.setBorder(new LineBorder(Color.black,1));
		_model.customerQueryBtn.setBounds(420, 15, 100, 30);
		_model.customerQueryBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.FirstLabel.setBounds(-2, 58, 650, 50);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,2));
		
		_model.customerNumL.setBounds(10, 58, 100, 50);
		_model.customerNumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerNumL.setBounds(110, 68, 130, 30);
		_model.queryCustomerNumL.setFont(new Font("", Font.BOLD, 18));
		_model.customerGenderL.setBounds(370, 58, 130, 50);
		_model.customerGenderL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerGenderL.setBounds(465, 68, 130, 30);
		_model.queryCustomerGenderL.setFont(new Font("", Font.BOLD, 18));
		
		_model.SecondLabel.setBounds(-2, 106, 650, 50);
		_model.SecondLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerNameL.setBounds(10, 106, 100, 50);
		_model.customerNameL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerNameL.setBounds(110, 116, 130, 30);
		_model.queryCustomerNameL.setFont(new Font("", Font.BOLD, 18));
		_model.customerBirthL.setBounds(370, 106, 100, 50);
		_model.customerBirthL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerBirthL.setBounds(465, 116, 130, 30);
		_model.queryCustomerBirthL.setFont(new Font("", Font.BOLD, 18));
		
		_model.ThirdLabel.setBounds(-2, 154, 650, 50);
		_model.ThirdLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerPhoneL.setBounds(10, 154, 100, 50);
		_model.customerPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerPhoneL.setBounds(110, 164, 130, 30);
		_model.queryCustomerPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.customerPathL.setBounds(370, 154, 100, 50);
		_model.customerPathL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerPathL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerPathL.setBounds(465, 164, 130, 30);
		
		_model.FourthLabel.setBounds(-2, 202, 650, 50);
		_model.FourthLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerFirstDayL.setBounds(10, 202, 100, 50);
		_model.customerFirstDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerFirstDayL.setBounds(110, 212, 130, 30);
		_model.queryCustomerFirstDayL.setFont(new Font("", Font.BOLD, 18));
		_model.customerLastDayL.setBounds(370, 202, 100, 50);
		_model.customerLastDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerLastDayL.setBounds(465, 212, 130, 30);
		_model.queryCustomerLastDayL.setFont(new Font("", Font.BOLD, 18));
		
		_model.FifthLabel.setBounds(-2, 250, 650, 50);
		_model.FifthLabel.setBorder(new LineBorder(Color.black,2));
		_model.customerAddrL.setBounds(10, 250, 100, 50);
		_model.customerAddrL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerAddrL.setBounds(110, 260, 485, 30);
		_model.queryCustomerAddrL.setFont(new Font("", Font.BOLD, 18));
		
		_model.SixthLabel.setBounds(-2, 298, 650, 160);
		_model.SixthLabel.setBorder(new LineBorder(Color.black,2));
		OfficialNoteL.setBounds(10, 298, 100, 50);
		OfficialNoteL.setFont(new Font("", Font.BOLD, 18));
		_model.queryCustomerNoteL.setBounds(110, 308, 485, 100);
		_model.queryCustomerNoteL.setFont(new Font("", Font.BOLD, 18));
		
//		ButtonGroup genderG = new ButtonGroup();
//		genderG.add(_model.customerGenderT[0]);
//		genderG.add(_model.customerGenderT[1]);

		//패널에 추가
		center.add(_model.customerInfoCombo);
		center.add(_model.customerInfoComboT);
		center.add(_model.customerQueryBtn);
		
		center.add(_model.FirstLabel);
		center.add(_model.customerNumL);
		center.add(_model.queryCustomerNumL);
		center.add(_model.customerGenderL);
		center.add(_model.queryCustomerGenderL);
		
		center.add(_model.SecondLabel);
		center.add(_model.customerNameL);
		center.add(_model.queryCustomerNameL);
		center.add(_model.customerBirthL);
		center.add(_model.queryCustomerBirthL);
		
		center.add(_model.ThirdLabel);
		center.add(_model.customerPhoneL);
		center.add(_model.queryCustomerPhoneL);
		center.add(_model.customerPathL);
		center.add(_model.queryCustomerPathL);	
		
		center.add(_model.FourthLabel);
		center.add(_model.customerFirstDayL);
		center.add(_model.queryCustomerFirstDayL);
		center.add(_model.customerLastDayL);
		center.add(_model.queryCustomerLastDayL);	
		
		center.add(_model.FifthLabel);
		center.add(_model.customerAddrL);
		center.add(_model.queryCustomerAddrL);
		
		center.add(_model.SixthLabel);
		center.add(OfficialNoteL);
		center.add(_model.queryCustomerNoteL);
				
		CMCQ = true;
		
		if(CustomerQBflag){
		//회원 조회 버튼을 눌렀을 때 
		_model.customerQueryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_model.customerInfoCombo.getSelectedItem().toString() == "전체 회원"){
					
					CMCAQ = true;
					
					createCustomerSub();
				}
				else
					_control.getDBCustomer(_model.customerInfoComboT.getText());
				
				for(int i=0; i<_model.Count; i++){
					System.out.println("cname :"+_model.cnum+" NumL_DB : "+_model.customerNumL_DB[i].getText());
					try{
						if(_model.cnum.equals(_model.customerNumL_DB[i].getText())){
							System.out.println("check");
							_control.setCustomerDBQuery(i);
							break;
						}
					}
					catch(NullPointerException nullPointerException){
						_control.setCustomerDBQuery(0);
					}
				}
				
			}
		});
		CustomerQBflag = false;
		}
				
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//회원 전체회원 프레임 화면 구성
	public void createCustomerSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBCustomer(_model.customerInfoComboT.getText());
		
		
		
		coustomerTable = new JTable(_model.CustomerData, _model.customerColNames);
		scrollPane = new JScrollPane(coustomerTable);
		coustomerTable.setFillsViewportHeight(true);
		coustomerTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		coustomerTable.getColumn("회원 번호").setPreferredWidth(1);
		coustomerTable.getColumn("회원 번호").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("회원 번호").setResizable(false);
		coustomerTable.getColumn("회원 이름").setPreferredWidth(1);
		coustomerTable.getColumn("회원 이름").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("생년월일").setPreferredWidth(1);
		coustomerTable.getColumn("생년월일").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("회원 성별").setPreferredWidth(1);
		coustomerTable.getColumn("회원 성별").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("전화번호").setPreferredWidth(50);
		coustomerTable.getColumn("전화번호").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("주소").setPreferredWidth(300);
		coustomerTable.getColumn("주소").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("방문 경로").setPreferredWidth(1);
		coustomerTable.getColumn("방문 경로").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("우수 회원").setPreferredWidth(1);
		coustomerTable.getColumn("우수 회원").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("시작일").setPreferredWidth(1);
		coustomerTable.getColumn("시작일").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("종료일").setPreferredWidth(1);
		coustomerTable.getColumn("종료일").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("비고").setPreferredWidth(300);
		coustomerTable.getColumn("비고").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//트레이너 등록
	public void createTrainerEnroll(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.FirstLabel.setBounds(-2, 0, 650, 50);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerNickL.setBounds(10, 0, 100, 50);
		_model.trainerNickL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerNickT.setBounds(110, 10, 130, 30);
		_model.trainerNickT.setFont(new Font("", Font.BOLD, 18));
		_model.trainerNickT.setBorder(new LineBorder(Color.black,1));
		_model.trainerOverlapTest.setBounds(250, 10, 100, 30);
		
		_model.SecondLabel.setBounds(-2, 48, 650, 50);
		_model.SecondLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerNameL.setBounds(10, 48, 100, 50);
		_model.trainerNameL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerNameT.setBounds(110, 58, 130, 30);
		_model.trainerNameT.setFont(new Font("", Font.BOLD, 18));
		_model.trainerNameT.setBorder(new LineBorder(Color.black,1));
		_model.trainerGenderL.setBounds(370, 48, 100, 50);
		_model.trainerGenderL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerGenderT[0] = new JRadioButton("남");
		_model.trainerGenderT[0].setBounds(465, 58, 65, 30);
		_model.trainerGenderT[1] = new JRadioButton("여");
		_model.trainerGenderT[1].setBounds(530, 58, 65, 30);
		
		_model.ThirdLabel.setBounds(-2, 96, 650, 50);
		_model.ThirdLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerPhoneL.setBounds(10, 96, 100, 50);
		_model.trainerPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerPhoneT.setBounds(110, 106, 130, 30);
		_model.trainerPhoneT.setFont(new Font("", Font.BOLD, 18));
		_model.trainerPhoneT.setBorder(new LineBorder(Color.black,1));
		_model.trainerBirthL.setBounds(370, 96, 100, 50);
		_model.trainerBirthL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerBirthT.setBounds(465, 106, 130, 30);
		_model.trainerBirthT.setFont(new Font("", Font.BOLD, 18));
		_model.trainerBirthT.setBorder(new LineBorder(Color.black,1));
		
		_model.FourthLabel.setBounds(-2, 144, 650, 50);
		_model.FourthLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerAddrL.setBounds(10, 144, 100, 50);
		_model.trainerAddrL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerAddrT.setBounds(110, 154, 485, 30);
		_model.trainerAddrT.setFont(new Font("", Font.BOLD, 18));
		_model.trainerAddrT.setBorder(new LineBorder(Color.black,1));
		
		_model.FifthLabel.setBounds(-2, 192, 650, 120);
		_model.FifthLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerLicenseL.setBounds(10, 192, 100, 50);
		_model.trainerLicenseL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerLicenseT.setBounds(110, 202, 485, 100);
		_model.trainerLicenseT.setFont(new Font("", Font.BOLD, 18));
		_model.trainerLicenseT.setBorder(new LineBorder(Color.black,1));
		
		_model.trainerEnrollBtn.setBounds(430, 365, 200, 35);
		_model.trainerEnrollBtn.setFont(new Font("", Font.BOLD, 18));
		
		ButtonGroup genderG = new ButtonGroup();
		genderG.add(_model.trainerGenderT[0]);
		genderG.add(_model.trainerGenderT[1]);

		//패널에 추가
		center.add(_model.FirstLabel);
		center.add(_model.trainerNickL);
		center.add(_model.trainerNickT);
		center.add(_model.trainerOverlapTest);
		
		center.add(_model.SecondLabel);
		center.add(_model.trainerNameL);
		center.add(_model.trainerNameT);
		center.add(_model.trainerGenderL);
		center.add(_model.trainerGenderT[0]);
		center.add(_model.trainerGenderT[1]);
		
		center.add(_model.ThirdLabel);
		center.add(_model.trainerPhoneL);
		center.add(_model.trainerPhoneT);
		center.add(_model.trainerBirthL);
		center.add(_model.trainerBirthT);
		
		center.add(_model.FourthLabel);
		center.add(_model.trainerAddrL);
		center.add(_model.trainerAddrT);
		
		center.add(_model.FifthLabel);
		center.add(_model.trainerLicenseL);
		center.add(_model.trainerLicenseT);
		
		center.add(_model.trainerEnrollBtn);
		
		CMTE = true;
		
		if(TrainerEnrollflag){
			_model.trainerEnrollBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(_model.trainerGenderT[0].isSelected())
						_model.trainerGender = "남자";
					else
						_model.trainerGender = "여자";
					_control.setDBTrainer();
				}
			});
			TrainerEnrollflag = false;
		}
		
		_control.setTrainerDBCheck();
		
		if(TrainerOverlapflag){
			_model.trainerOverlapTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(int i=0; i< _model.Count; i++){
						System.out.println("확인 : "+_model.trainerNickL_DB[i].getText());
						if(_model.trainerNickT.getText().equals(_model.trainerNickL_DB[i].getText()))
							JOptionPane.showMessageDialog(pannel, "동일한 닉네임이 있습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			TrainerOverlapflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//트레이너 조회
	public void createTrainerQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.trainerInfoCombo.setBounds(50, 15, 200, 30);
		_model.trainerInfoCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CMTQ){
			_model.trainerInfoCombo.addItem("닉네임");
			_model.trainerInfoCombo.addItem("트레이너 명");
			_model.trainerInfoCombo.addItem("전화 번호");
			_model.trainerInfoCombo.addItem("전체 트레이너");
		}
		_model.trainerInfoComboT.setBounds(270, 15, 130, 30);
		_model.trainerInfoComboT.setFont(new Font("", Font.BOLD, 18));
		_model.trainerInfoComboT.setBorder(new LineBorder(Color.black,1));
		_model.trainerQueryBtn.setBounds(420, 15, 100, 30);
		_model.trainerQueryBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.FirstLabel.setBounds(-2, 58, 650, 50);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerNickL.setBounds(10, 58, 100, 50);
		_model.trainerNickL.setFont(new Font("", Font.BOLD, 18));
		_model.queryTrainerNickL.setBounds(110, 68, 130, 30);
		_model.queryTrainerNickL.setFont(new Font("", Font.BOLD, 18));
		
		_model.SecondLabel.setBounds(-2, 106, 650, 50);
		_model.SecondLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerNameL.setBounds(10, 106, 100, 50);
		_model.trainerNameL.setFont(new Font("", Font.BOLD, 18));
		_model.queryTrainerNameL.setBounds(110, 116, 130, 30);
		_model.queryTrainerNameL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerGenderL.setBounds(370, 106, 100, 50);
		_model.trainerGenderL.setFont(new Font("", Font.BOLD, 18));
		_model.queryTrainerGenderL.setBounds(465, 116, 130, 30);
		_model.queryTrainerGenderL.setFont(new Font("", Font.BOLD, 18));
		
		_model.ThirdLabel.setBounds(-2, 154, 650, 50);
		_model.ThirdLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerPhoneL.setBounds(10, 154, 100, 50);
		_model.trainerPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.queryTrainerPhoneL.setBounds(110, 164, 130, 30);
		_model.queryTrainerPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.trainerBirthL.setBounds(370, 154, 100, 50);
		_model.trainerBirthL.setFont(new Font("", Font.BOLD, 18));
		_model.queryTrainerBirthL.setBounds(465, 164, 130, 30);
		_model.queryTrainerBirthL.setFont(new Font("", Font.BOLD, 18));
		
		_model.FourthLabel.setBounds(-2, 202, 650, 50);
		_model.FourthLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerAddrL.setBounds(10, 202, 100, 50);
		_model.trainerAddrL.setFont(new Font("", Font.BOLD, 18));
		_model.queryTrainerAddrL.setBounds(110, 212, 485, 30);
		_model.queryTrainerAddrL.setFont(new Font("", Font.BOLD, 18));
		
		_model.FifthLabel.setBounds(-2, 250, 650, 160);
		_model.FifthLabel.setBorder(new LineBorder(Color.black,2));
		_model.trainerLicenseL.setBounds(10, 250, 100, 50);
		_model.trainerLicenseL.setFont(new Font("", Font.BOLD, 18));
		_model.queryTrainerLicenseL.setBounds(110, 260, 485, 100);
		_model.queryTrainerLicenseL.setFont(new Font("", Font.BOLD, 18));
		
//		ButtonGroup genderG = new ButtonGroup();
//		genderG.add(_model.trainerGenderT[0]);
//		genderG.add(_model.trainerGenderT[1]);

		//패널에 추가
		center.add(_model.trainerInfoCombo);
		center.add(_model.trainerInfoComboT);
		center.add(_model.trainerQueryBtn);
		
		center.add(_model.FirstLabel);
		center.add(_model.trainerNickL);
		center.add(_model.queryTrainerNickL);
		
		center.add(_model.SecondLabel);
		center.add(_model.trainerNameL);
		center.add(_model.queryTrainerNameL);
		center.add(_model.trainerGenderL);
		center.add(_model.queryTrainerGenderL);
				
		center.add(_model.ThirdLabel);
		center.add(_model.trainerPhoneL);
		center.add(_model.queryTrainerPhoneL);
		center.add(_model.trainerBirthL);
		center.add(_model.queryTrainerBirthL);
		
		center.add(_model.FourthLabel);
		center.add(_model.trainerAddrL);
		center.add(_model.queryTrainerAddrL);
		
		center.add(_model.FifthLabel);
		center.add(_model.trainerLicenseL);
		center.add(_model.queryTrainerLicenseL);	
				
		CMTQ = true;
		
		if(TrainerQBflag){
		//트레이너 조회 버튼을 눌렀을 때 
		_model.trainerQueryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_model.trainerInfoCombo.getSelectedItem().toString() == "전체 트레이너"){
					
					CMTAQ = true;
					
					createTrainerSub();
				}
				else
					_control.getDBTrainer(_model.trainerInfoComboT.getText());
				
				for(int i=0; i<_model.Count; i++){
					System.out.println("tnick :"+_model.tnick+" nickL_DB : "+_model.trainerNickL_DB[i].getText());
					if(_model.tnick.equals(_model.trainerNickL_DB[i].getText())){
						System.out.println("check");
						_control.setTrainerDBQuery(i);
						break;
					}
					else{
						_control.setTrainerDBQuery(0);
					}
				}
				
			}
		});
		TrainerQBflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//트레이너 전체회원 프레임 화면 구성
	public void createTrainerSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBTrainer(_model.trainerInfoComboT.getText());
		
		trainerTable = new JTable(_model.TrainerData, _model.trainerColNames);
		scrollPane = new JScrollPane(trainerTable);
		trainerTable.setFillsViewportHeight(true);
		trainerTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		trainerTable.getColumn("닉네임").setPreferredWidth(1);
		trainerTable.getColumn("닉네임").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("닉네임").setResizable(false);
		trainerTable.getColumn("트레이너 이름").setPreferredWidth(50);
		trainerTable.getColumn("트레이너 이름").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("생년월일").setPreferredWidth(1);
		trainerTable.getColumn("생년월일").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("트레이너 성별").setPreferredWidth(1);
		trainerTable.getColumn("트레이너 성별").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("전화번호").setPreferredWidth(50);
		trainerTable.getColumn("전화번호").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("주소").setPreferredWidth(400);
		trainerTable.getColumn("주소").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("자격증").setPreferredWidth(400);
		trainerTable.getColumn("자격증").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//골프프로 등록
	public void createGolfEnroll(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.FirstLabel.setBounds(-2, 0, 650, 50);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProNumL.setBounds(10, 0, 100, 50);
		_model.golfProNumL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProNumT.setBounds(110, 10, 130, 30);
		_model.golfProNumT.setFont(new Font("", Font.BOLD, 18));
		_model.golfProNumT.setBorder(new LineBorder(Color.black,1));
		_model.golfProOverlapTest.setBounds(250, 10, 100, 30);
		
		_model.SecondLabel.setBounds(-2, 48, 650, 50);
		_model.SecondLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProNameL.setBounds(10, 48, 100, 50);
		_model.golfProNameL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProNameT.setBounds(110, 58, 130, 30);
		_model.golfProNameT.setFont(new Font("", Font.BOLD, 18));
		_model.golfProNameT.setBorder(new LineBorder(Color.black,1));
		_model.golfProGenderL.setBounds(370, 48, 100, 50);
		_model.golfProGenderL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProGenderT[0] = new JRadioButton("남");
		_model.golfProGenderT[0].setBounds(465, 58, 65, 30);
		_model.golfProGenderT[1] = new JRadioButton("여");
		_model.golfProGenderT[1].setBounds(530, 58, 65, 30);
		
		_model.ThirdLabel.setBounds(-2, 96, 650, 50);
		_model.ThirdLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProPhoneL.setBounds(10, 96, 100, 50);
		_model.golfProPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProPhoneT.setBounds(110, 106, 130, 30);
		_model.golfProPhoneT.setFont(new Font("", Font.BOLD, 18));
		_model.golfProPhoneT.setBorder(new LineBorder(Color.black,1));
		_model.golfProBirthL.setBounds(370, 96, 100, 50);
		_model.golfProBirthL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProBirthT.setBounds(465, 106, 130, 30);
		_model.golfProBirthT.setFont(new Font("", Font.BOLD, 18));
		_model.golfProBirthT.setBorder(new LineBorder(Color.black,1));
		
		_model.FourthLabel.setBounds(-2, 144, 650, 50);
		_model.FourthLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProAddrL.setBounds(10, 144, 100, 50);
		_model.golfProAddrL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProAddrT.setBounds(110, 154, 485, 30);
		_model.golfProAddrT.setFont(new Font("", Font.BOLD, 18));
		_model.golfProAddrT.setBorder(new LineBorder(Color.black,1));
		
		_model.FifthLabel.setBounds(-2, 192, 650, 120);
		_model.FifthLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProLicenseL.setBounds(10, 192, 100, 50);
		_model.golfProLicenseL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProLicenseT.setBounds(110, 202, 485, 100);
		_model.golfProLicenseT.setFont(new Font("", Font.BOLD, 18));
		_model.golfProLicenseT.setBorder(new LineBorder(Color.black,1));
		
		_model.golfProEnrollBtn.setBounds(430, 365, 200, 35);
		_model.golfProEnrollBtn.setFont(new Font("", Font.BOLD, 18));
		
		ButtonGroup genderG = new ButtonGroup();
		genderG.add(_model.golfProGenderT[0]);
		genderG.add(_model.golfProGenderT[1]);

		//패널에 추가
		center.add(_model.FirstLabel);
		center.add(_model.golfProNumL);
		center.add(_model.golfProNumT);
		center.add(_model.golfProOverlapTest);
		
		center.add(_model.SecondLabel);
		center.add(_model.golfProNameL);
		center.add(_model.golfProNameT);
		center.add(_model.golfProGenderL);
		center.add(_model.golfProGenderT[0]);
		center.add(_model.golfProGenderT[1]);
		
		center.add(_model.ThirdLabel);
		center.add(_model.golfProPhoneL);
		center.add(_model.golfProPhoneT);
		center.add(_model.golfProBirthL);
		center.add(_model.golfProBirthT);
		
		center.add(_model.FourthLabel);
		center.add(_model.golfProAddrL);
		center.add(_model.golfProAddrT);
		
		center.add(_model.FifthLabel);
		center.add(_model.golfProLicenseL);
		center.add(_model.golfProLicenseT);
		
		center.add(_model.golfProEnrollBtn);
		
		CMGE = true;
		
		if(GolfProEnrollflag){
			_model.golfProEnrollBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(_model.golfProGenderT[0].isSelected())
						_model.golfProGender = "남자";
					else
						_model.golfProGender = "여자";
					_control.setDBGolfpro();
				}
			});
			GolfProEnrollflag = false;
		}
		
		_control.setGolfProDBCheck();
		if(_model.Count != 0)
			_model.golfProNumT.setText(String.valueOf(Integer.parseInt(_model.golfProNumL_DB[_model.Count-1].getText()) + 1)); 
		
		if(GolfProOverlapflag){
			_model.golfProOverlapTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i< _model.Count; i++){
					System.out.println("확인 : "+_model.golfProNumL_DB[i].getText());
					if(_model.golfProNumT.getText().equals(_model.golfProNumL_DB[i].getText()))
						JOptionPane.showMessageDialog(pannel, "동일한 골프프로 코드가 있습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		GolfProOverlapflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//골프 프로 조회
	public void createGolfQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.golfProInfoCombo.setBounds(50, 15, 200, 30);
		_model.golfProInfoCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CMGQ){
			_model.golfProInfoCombo.addItem("프로 번호");
			_model.golfProInfoCombo.addItem("골프프로 명");
			_model.golfProInfoCombo.addItem("전화 번호");
			_model.golfProInfoCombo.addItem("전체 골프프로");
		}
		_model.golfProInfoComboT.setBounds(270, 15, 130, 30);
		_model.golfProInfoComboT.setFont(new Font("", Font.BOLD, 18));
		_model.golfProInfoComboT.setBorder(new LineBorder(Color.black,1));
		_model.golfProQueryBtn.setBounds(420, 15, 100, 30);
		_model.golfProQueryBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.FirstLabel.setBounds(-2, 58, 650, 50);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProNumL.setBounds(10, 58, 100, 50);
		_model.golfProNumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryGolfProNumL.setBounds(110, 68, 130, 30);
		_model.queryGolfProNumL.setFont(new Font("", Font.BOLD, 18));
		
		_model.SecondLabel.setBounds(-2, 106, 650, 50);
		_model.SecondLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProNameL.setBounds(10, 106, 100, 50);
		_model.golfProNameL.setFont(new Font("", Font.BOLD, 18));
		_model.queryGolfProNameL.setBounds(110, 116, 130, 30);
		_model.queryGolfProNameL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProGenderL.setBounds(370, 106, 100, 50);
		_model.golfProGenderL.setFont(new Font("", Font.BOLD, 18));
		_model.queryGolfProGenderL.setBounds(465, 116, 130, 30);
		_model.queryGolfProGenderL.setFont(new Font("", Font.BOLD, 18));
		
		_model.ThirdLabel.setBounds(-2, 154, 650, 50);
		_model.ThirdLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProPhoneL.setBounds(10, 154, 100, 50);
		_model.golfProPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.queryGolfProPhoneL.setBounds(110, 164, 130, 30);
		_model.queryGolfProPhoneL.setFont(new Font("", Font.BOLD, 18));
		_model.golfProBirthL.setBounds(370, 154, 100, 50);
		_model.golfProBirthL.setFont(new Font("", Font.BOLD, 18));
		_model.queryGolfProBirthL.setBounds(465, 164, 130, 30);
		_model.queryGolfProBirthL.setFont(new Font("", Font.BOLD, 18));
		
		_model.FourthLabel.setBounds(-2, 202, 650, 50);
		_model.FourthLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProAddrL.setBounds(10, 202, 100, 50);
		_model.golfProAddrL.setFont(new Font("", Font.BOLD, 18));
		_model.queryGolfProAddrL.setBounds(110, 212, 485, 30);
		_model.queryGolfProAddrL.setFont(new Font("", Font.BOLD, 18));
		
		_model.FifthLabel.setBounds(-2, 250, 650, 160);
		_model.FifthLabel.setBorder(new LineBorder(Color.black,2));
		_model.golfProLicenseL.setBounds(10, 250, 100, 50);
		_model.golfProLicenseL.setFont(new Font("", Font.BOLD, 18));
		_model.queryGolfProLicenseL.setBounds(110, 260, 485, 100);
		_model.queryGolfProLicenseL.setFont(new Font("", Font.BOLD, 18));
		
		ButtonGroup genderG = new ButtonGroup();
		genderG.add(_model.golfProGenderT[0]);
		genderG.add(_model.golfProGenderT[1]);

		//패널에 추가
		center.add(_model.golfProInfoCombo);
		center.add(_model.golfProInfoComboT);
		center.add(_model.golfProQueryBtn);
		
		center.add(_model.FirstLabel);
		center.add(_model.golfProNumL);
		center.add(_model.queryGolfProNumL);
		
		center.add(_model.SecondLabel);
		center.add(_model.golfProNameL);
		center.add(_model.queryGolfProNameL);
		center.add(_model.golfProGenderL);
		center.add(_model.queryGolfProGenderL);
				
		center.add(_model.ThirdLabel);
		center.add(_model.golfProPhoneL);
		center.add(_model.queryGolfProPhoneL);
		center.add(_model.golfProBirthL);
		center.add(_model.queryGolfProBirthL);
		
		center.add(_model.FourthLabel);
		center.add(_model.golfProAddrL);
		center.add(_model.queryGolfProAddrL);
		
		center.add(_model.FifthLabel);
		center.add(_model.golfProLicenseL);
		center.add(_model.queryGolfProLicenseL);	
				
		CMGQ = true;
		
		if(GolfProQBflag){
		//골프프로 조회 버튼을 눌렀을 때 
		_model.golfProQueryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_model.golfProInfoCombo.getSelectedItem().toString() == "전체 골프프로"){
					
					CMGAQ = true;
					createGolfProSub();
				}
				else
					_control.getDBGolfpro(_model.golfProInfoComboT.getText());
				
				for(int i=0; i<_model.Count; i++){
					System.out.println("gpnum :"+_model.gpnum+" NumL_DB : "+_model.golfProNumL_DB[i].getText());
					if(_model.gpnum.equals(_model.golfProNumL_DB[i].getText())){
						System.out.println("check");
						_control.setGolfProDBQuery(i);
						break;
					}
					else{
						_control.setGolfProDBQuery(0);
					}
				}
			}
		});
		GolfProQBflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//골프프로 전체회원 프레임 화면 구성
	public void createGolfProSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBGolfpro(_model.golfProInfoComboT.getText());
		
		golfProTable = new JTable(_model.GolfProData, _model.golfProColNames);
		scrollPane = new JScrollPane(golfProTable);
		golfProTable.setFillsViewportHeight(true);
		golfProTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		golfProTable.getColumn("골프프로 번호").setPreferredWidth(1);
		golfProTable.getColumn("골프프로 번호").setCellRenderer(celAlignCenter);
		golfProTable.getColumn("골프프로 번호").setResizable(false);
		golfProTable.getColumn("골프프로 이름").setPreferredWidth(1);
		golfProTable.getColumn("골프프로 이름").setCellRenderer(celAlignCenter);
		golfProTable.getColumn("생년월일").setPreferredWidth(1);
		golfProTable.getColumn("생년월일").setCellRenderer(celAlignCenter);
		golfProTable.getColumn("골프프로 성별").setPreferredWidth(1);
		golfProTable.getColumn("골프프로 성별").setCellRenderer(celAlignCenter);
		golfProTable.getColumn("전화번호").setPreferredWidth(50);
		golfProTable.getColumn("전화번호").setCellRenderer(celAlignCenter);
		golfProTable.getColumn("주소").setPreferredWidth(400);
		golfProTable.getColumn("주소").setCellRenderer(celAlignCenter);
		golfProTable.getColumn("자격증").setPreferredWidth(400);
		golfProTable.getColumn("자격증").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//우수회원 등록
	public void createEliteCustomerEnroll(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.FirstLabel.setBounds(15, 200, 610, 80);
		_model.FirstLabel.setBorder(new LineBorder(Color.black,5));

		_model.EliteQBtn.setBounds(25, 215, 130, 50);
		_model.EliteQBtn.setFont(new Font("", Font.BOLD, 18));
		_model.EliteL.setBounds(165, 215, 150, 50);
		_model.EliteL.setFont(new Font("", Font.BOLD, 30));
		_model.EliteT.setBounds(325, 215, 130, 50);
		_model.EliteT.setFont(new Font("", Font.BOLD, 30));
		_model.EliteT.setBorder(new LineBorder(Color.black,1));
		_model.EliteEBtn.setBounds(475, 215, 130, 50);
		_model.EliteEBtn.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.FirstLabel);
		center.add(_model.EliteQBtn);
		center.add(_model.EliteL);
		center.add(_model.EliteT);
		center.add(_model.EliteEBtn);
		
		CMEE = true;
		
		if(EliteCQueryflag){
		_model.EliteQBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CMCAQ = true;
				createEliteCSub();
			}
		});
		EliteCQueryflag = false;
		}
		
		if(EliteCEnrollflag){
			_model.EliteEBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					_control.setCustomerDBUpdate();
				}
			});
			EliteCEnrollflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		//frame.repaint();
		frame.setVisible(true);
	}
	
	//회원 전체회원 프레임 화면 구성
	public void createEliteCSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.setCustomerDBCheck();
		
		coustomerTable = new JTable(_model.CustomerData, _model.customerColNames);
		scrollPane = new JScrollPane(coustomerTable);
		coustomerTable.setFillsViewportHeight(true);
		coustomerTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		coustomerTable.getColumn("회원 번호").setPreferredWidth(1);
		coustomerTable.getColumn("회원 번호").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("회원 번호").setResizable(false);
		coustomerTable.getColumn("회원 이름").setPreferredWidth(1);
		coustomerTable.getColumn("회원 이름").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("생년월일").setPreferredWidth(1);
		coustomerTable.getColumn("생년월일").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("회원 성별").setPreferredWidth(1);
		coustomerTable.getColumn("회원 성별").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("전화번호").setPreferredWidth(50);
		coustomerTable.getColumn("전화번호").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("주소").setPreferredWidth(300);
		coustomerTable.getColumn("주소").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("방문 경로").setPreferredWidth(1);
		coustomerTable.getColumn("방문 경로").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("우수 회원").setPreferredWidth(1);
		coustomerTable.getColumn("우수 회원").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("시작일").setPreferredWidth(1);
		coustomerTable.getColumn("시작일").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("종료일").setPreferredWidth(1);
		coustomerTable.getColumn("종료일").setCellRenderer(celAlignCenter);
		coustomerTable.getColumn("비고").setPreferredWidth(300);
		coustomerTable.getColumn("비고").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	
	//lesson 생성
	public void createClass(){
		//서쪽 패널 생성
		west = new JPanel();
		west.setLayout(new GridLayout(8, 1));
		
		//패널에 버튼 추가
		west.add(_model.PTEnroll);
		west.add(_model.PTQuery);
		west.add(_model.PTManage);
		west.add(_model.PTManageQuery);
		west.add(_model.LessonEnroll);
		west.add(_model.LessonQuery);
		west.add(_model.LessonManage);
		west.add(_model.LessonManageQuery);
		
		
		//lesson 폰트 설정
		_model.PTEnroll.setFont(new Font("", Font.BOLD, 18));
		_model.PTQuery.setFont(new Font("", Font.BOLD, 18));
		_model.PTManage.setFont(new Font("", Font.BOLD, 18));
		_model.PTManageQuery.setFont(new Font("", Font.BOLD, 18));
		_model.LessonEnroll.setFont(new Font("", Font.BOLD, 18));
		_model.LessonQuery.setFont(new Font("", Font.BOLD, 18));
		_model.LessonManage.setFont(new Font("", Font.BOLD, 18));
		_model.LessonManageQuery.setFont(new Font("", Font.BOLD, 18));
		
		
		if(PEflag){
		//PT 등록 버튼을 눌렀을 때
		_model.PTEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				classRemoveCenter();
				
				classCheckBgcolor(clickBtn);
				clickBtn = e.getActionCommand();
				_model.PTEnroll.setBackground(Color.LIGHT_GRAY);
				
				CourseALLCLEAR();
				
				createPTEnroll();
			}
		});
		PEflag = false;
		}
		
		if(PQflag){
			//PT 조회 버튼을 눌렀을 때
			_model.PTQuery.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					classRemoveCenter();
					classRemoveScroll();

					classCheckBgcolor(clickBtn);
					clickBtn = e.getActionCommand();
					_model.PTQuery.setBackground(Color.LIGHT_GRAY);
					
					CourseALLCLEAR();
					
					createPTQuery();
				}
			});
			PQflag = false;
		}
		
		if(PMflag){
			//PT 관리 버튼을 눌렀을 때
			_model.PTManage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					classRemoveCenter();

					classCheckBgcolor(clickBtn);
					clickBtn = e.getActionCommand();
					_model.PTManage.setBackground(Color.LIGHT_GRAY);
					
					CourseALLCLEAR();
					
					createPTManage();
				}
			});
			PMflag = false;
		}
		
		if(PMQflag){
			//PT 관리 조회 버튼을 눌렀을 때
			_model.PTManageQuery.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					classRemoveCenter();
					classRemoveScroll();

					classCheckBgcolor(clickBtn);
					clickBtn = e.getActionCommand();
					_model.PTManageQuery.setBackground(Color.LIGHT_GRAY);
					
					CourseALLCLEAR();
					
					createPTManageQuery();
				}
			});
			PMQflag = false;
		}
		
		if(LEflag){
			//Lesson 등록 버튼을 눌렀을 때
			_model.LessonEnroll.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					classRemoveCenter();

					classCheckBgcolor(clickBtn);
					clickBtn = e.getActionCommand();
					_model.LessonEnroll.setBackground(Color.LIGHT_GRAY);
					
					CourseALLCLEAR();
					
					createLessonEnroll();
				}
			});
			LEflag = false;
		}
		
		if(LQflag){
			//Lesson 조회 버튼을 눌렀을 때
			_model.LessonQuery.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					classRemoveCenter();
					classRemoveScroll();

					classCheckBgcolor(clickBtn);
					clickBtn = e.getActionCommand();
					_model.LessonQuery.setBackground(Color.LIGHT_GRAY);
					
					CourseALLCLEAR();
					
					createLessonQuery();
				}
			});
			LQflag = false;
		}
		
		if(LMflag){
			//Lesson 관리 버튼을 눌렀을 때
			_model.LessonManage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					classRemoveCenter();

					classCheckBgcolor(clickBtn);
					clickBtn = e.getActionCommand();
					_model.LessonManage.setBackground(Color.LIGHT_GRAY);
					
					CourseALLCLEAR();
					
					createLessonManage();
				}
			});
			LMflag = false;
		}
		
		if(LMQflag){
			//Lesson 관리 조회 버튼을 눌렀을 때
			_model.LessonManageQuery.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					classRemoveCenter();
					classRemoveScroll();

					classCheckBgcolor(clickBtn);
					clickBtn = e.getActionCommand();
					_model.LessonManageQuery.setBackground(Color.LIGHT_GRAY);
					
					CourseALLCLEAR();
					
					createLessonManageQuery();
				}
			});
			LMQflag = false;
		}
		
		//컨테이너에 패널 추가			
		contentPane.add(west, BorderLayout.WEST);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//PT 등록
	public void createPTEnroll(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.PTFirstL.setBounds(-1, 0, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));

		_model.PTNumL.setBounds(10, 0, 100, 50);
		_model.PTNumL.setFont(new Font("", Font.BOLD, 18));
		_model.PTNumT.setBounds(100, 10, 130, 30);
		_model.PTNumT.setFont(new Font("", Font.BOLD, 18));
		_model.PTNumT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTSecondL.setBounds(-1, 48, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.PT_T_NickL.setBounds(10, 48, 100, 50);
		_model.PT_T_NickL.setFont(new Font("", Font.BOLD, 18));
		_model.PT_T_NickT.setBounds(100, 58, 130, 30);
		_model.PT_T_NickT.setFont(new Font("", Font.BOLD, 18));
		_model.PT_T_NickT.setBorder(new LineBorder(Color.black,1));
		_model.PT_M_NumL.setBounds(350, 48, 130, 50);
		_model.PT_M_NumL.setFont(new Font("", Font.BOLD, 18));
		_model.PT_M_NumT.setBounds(445, 58, 130, 30);
		_model.PT_M_NumT.setFont(new Font("", Font.BOLD, 18));
		_model.PT_M_NumT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTThirdL.setBounds(-1, 96, 690, 50);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.PTCountL.setBounds(10, 96, 100, 50);
		_model.PTCountL.setFont(new Font("", Font.BOLD, 18));
		_model.PTCountT.setBounds(100, 106, 130, 30);
		_model.PTCountT.setFont(new Font("", Font.BOLD, 18));
		_model.PTCountT.setBorder(new LineBorder(Color.black,1));
		_model.PTMoneyL.setBounds(350, 96, 100, 50);
		_model.PTMoneyL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMoneyT.setBounds(445, 106, 130, 30);
		_model.PTMoneyT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMoneyT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTFourthL.setBounds(-1, 144, 690, 50);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.PT_EPriceL.setBounds(10, 144, 100, 50);
		_model.PT_EPriceL.setFont(new Font("", Font.BOLD, 18));
		_model.PT_EPriceT.setBounds(100, 154, 130, 30);
		_model.PT_EPriceT.setFont(new Font("", Font.BOLD, 18));
		_model.PT_EPriceT.setBorder(new LineBorder(Color.black,1));
		_model.PTEnrollDayL.setBounds(350, 144, 100, 50);
		_model.PTEnrollDayL.setFont(new Font("", Font.BOLD, 18));
		_model.PTEnrollDayT.setBounds(445, 154, 130, 30);
		_model.PTEnrollDayT.setFont(new Font("", Font.BOLD, 18));
		_model.PTEnrollDayT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTFifthL.setBounds(-1, 192, 690, 50);
		_model.PTFifthL.setBorder(new LineBorder(Color.black,2));
		_model.PTStartDayL.setBounds(10, 192, 100, 50);
		_model.PTStartDayL.setFont(new Font("", Font.BOLD, 18));
		_model.PTStartDayT.setBounds(100, 202, 130, 30);
		_model.PTStartDayT.setFont(new Font("", Font.BOLD, 18));
		_model.PTStartDayT.setBorder(new LineBorder(Color.black,1));
		_model.PTLastDayL.setBounds(350, 192, 100, 50);
		_model.PTLastDayL.setFont(new Font("", Font.BOLD, 18));
		_model.PTLastDayT.setBounds(445, 202, 130, 30);
		_model.PTLastDayT.setFont(new Font("", Font.BOLD, 18));
		_model.PTLastDayT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTSixthL.setBounds(-1, 240, 690, 120);
		_model.PTSixthL.setBorder(new LineBorder(Color.black,2));
		_model.PTNoteL.setBounds(10, 240, 100, 50);
		_model.PTNoteL.setFont(new Font("", Font.BOLD, 18));
		_model.PTNoteT.setBounds(100, 250, 475, 100);
		_model.PTNoteT.setFont(new Font("", Font.BOLD, 18));
		_model.PTNoteT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTEnrollBtn.setBounds(430, 390, 200, 35);
		_model.PTEnrollBtn.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.PTFirstL);
		center.add(_model.PTNumL);
		center.add(_model.PTNumT);
		center.add(_model.PT_M_NumL);
		center.add(_model.PT_M_NumT);
		
		center.add(_model.PTSecondL);
		center.add(_model.PT_T_NickL);
		center.add(_model.PT_T_NickT);
		
		center.add(_model.PTCountT);
		
		center.add(_model.PTThirdL);
		center.add(_model.PTCountL);
		center.add(_model.PTCountT);
		center.add(_model.PTMoneyL);
		center.add(_model.PTMoneyT);	
		
		center.add(_model.PTFourthL);
		center.add(_model.PT_EPriceL);
		center.add(_model.PT_EPriceT);
		center.add(_model.PTEnrollDayL);
		center.add(_model.PTEnrollDayT);
		
		center.add(_model.PTFifthL);
		center.add(_model.PTStartDayL);
		center.add(_model.PTStartDayT);
		center.add(_model.PTLastDayL);
		center.add(_model.PTLastDayT);
		
		center.add(_model.PTSixthL);
		center.add(_model.PTNoteL);
		center.add(_model.PTNoteT);
		
		center.add(_model.PTEnrollBtn);
		
		CCPE = true;
		
		Calendar cal = Calendar.getInstance();
		_model.PTEnrollDayT.setText((cal.get(Calendar.YEAR)%2000)+""+(cal.get(Calendar.MONTH)+1)+""+cal.get(Calendar.DATE));
		
		if(PTEnrollflag){
			_model.PTEnrollBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					_control.setDBPT();
				}
			});
			PTEnrollflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//PT 조회
	public void createPTQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.PTInfoCombo.setBounds(50, 15, 200, 30);
		_model.PTInfoCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CCPQ){
			_model.PTInfoCombo.addItem("PT 번호");
			_model.PTInfoCombo.addItem("트레이너 닉네임");
			_model.PTInfoCombo.addItem("회원 번호");
			_model.PTInfoCombo.addItem("전체 PT");
		}
		_model.PTInfoComboT.setBounds(270, 15, 130, 30);
		_model.PTInfoComboT.setFont(new Font("", Font.BOLD, 18));
		_model.PTInfoComboT.setBorder(new LineBorder(Color.black,1));
		_model.PTQueryBtn.setBounds(420, 15, 100, 30);
		_model.PTQueryBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFirstL.setBounds(-2, 58, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));
		_model.PTNumL.setBounds(10, 58, 100, 50);
		_model.PTNumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTNumL.setBounds(100, 68, 130, 30);
		_model.queryPTNumL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTSecondL.setBounds(-2, 106, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.PT_T_NickL.setBounds(10, 106, 100, 50);
		_model.PT_T_NickL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPT_T_NickL.setBounds(100, 116, 130, 30);
		_model.queryPT_T_NickL.setFont(new Font("", Font.BOLD, 18));
		_model.PT_M_NumL.setBounds(350, 106, 130, 50);
		_model.PT_M_NumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPT_M_NumL.setBounds(445, 116, 130, 30);
		_model.queryPT_M_NumL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTThirdL.setBounds(-2, 154, 690, 50);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.PTCountL.setBounds(10, 154, 100, 50);
		_model.PTCountL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTCountL.setBounds(100, 164, 130, 30);
		_model.queryPTCountL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMoneyL.setBounds(350, 154, 100, 50);
		_model.PTMoneyL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMoneyL.setBounds(445, 164, 130, 30);
		_model.queryPTMoneyL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFourthL.setBounds(-2, 202, 690, 50);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.PT_EPriceL.setBounds(10, 202, 100, 50);
		_model.PT_EPriceL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPT_EPriceL.setBounds(100, 212, 130, 30);
		_model.queryPT_EPriceL.setFont(new Font("", Font.BOLD, 18));
		_model.PTEnrollDayL.setBounds(350, 202, 100, 50);
		_model.PTEnrollDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTEnrollDayL.setBounds(445, 212, 130, 30);
		_model.queryPTEnrollDayL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFifthL.setBounds(-2, 250, 690, 50);
		_model.PTFifthL.setBorder(new LineBorder(Color.black,2));
		_model.PTStartDayL.setBounds(10, 250, 100, 50);
		_model.PTStartDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTStartDayL.setBounds(100, 260, 130, 30);
		_model.queryPTStartDayL.setFont(new Font("", Font.BOLD, 18));
		_model.PTLastDayL.setBounds(350, 250, 100, 50);
		_model.PTLastDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTLastDayL.setBounds(445, 260, 130, 30);
		_model.queryPTLastDayL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTSixthL.setBounds(-2, 298, 690, 120);
		_model.PTSixthL.setBorder(new LineBorder(Color.black,2));
		_model.PTNoteL.setBounds(10, 298, 100, 50);
		_model.PTNoteL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTNoteL.setBounds(100, 308, 475, 100);
		_model.queryPTNoteL.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.PTInfoCombo);
		center.add(_model.PTInfoComboT);
		center.add(_model.PTQueryBtn);
		
		center.add(_model.PTFirstL);
		center.add(_model.PTNumL);
		center.add(_model.queryPTNumL);
		
		center.add(_model.PTSecondL);
		center.add(_model.PT_T_NickL);
		center.add(_model.queryPT_T_NickL);
		center.add(_model.PT_M_NumL);
		center.add(_model.queryPT_M_NumL );
		
		center.add(_model.PTThirdL);
		center.add(_model.PTCountL);
		center.add(_model.queryPTCountL);
		center.add(_model.PTMoneyL);
		center.add(_model.queryPTMoneyL);	
		
		center.add(_model.PTFourthL);
		center.add(_model.PT_EPriceL);
		center.add(_model.queryPT_EPriceL);
		center.add(_model.PTEnrollDayL);
		center.add(_model.queryPTEnrollDayL);
		
		center.add(_model.PTFifthL);
		center.add(_model.PTStartDayL);
		center.add(_model.queryPTStartDayL);
		center.add(_model.PTLastDayL);
		center.add(_model.queryPTLastDayL);
		
		center.add(_model.PTSixthL);
		center.add(_model.PTNoteL);
		center.add(_model.queryPTNoteL);
		
		CCPQ = true;
		
		if(PTQBflag){
			_model.PTQueryBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(_model.PTInfoCombo.getSelectedItem().toString() == "전체 PT"){
						
						CCPAQ = true;
						
						createPTSub();
					}
					else
						_control.getDBPT(_model.PTInfoComboT.getText());
					
					for(int i=0; i<_model.Count; i++){
						if(_model.PTInfoCombo.getSelectedItem().toString() == "트레이너 닉네임"){
							System.out.println("ptnick :"+_model.ptnick+" NumL_DB : "+_model.PT_T_NickL_DB[i].getText());
							try{
								if(_model.ptnick.equals(_model.PT_T_NickL_DB[i].getText())){
									System.out.println("check");
									_control.setPTDBQuery(i);
									break;
								}
							}
							catch(NullPointerException nullPointerException){
								_control.setPTDBQuery(0);
							}
						}
						else if(_model.PTInfoCombo.getSelectedItem().toString() == "회원 번호"){
							System.out.println("ptnum :"+_model.ptcnum+" NumL_DB : "+_model.PT_M_NumL_DB[i].getText());
							try{
								if(_model.ptcnum.equals(_model.PT_M_NumL_DB[i].getText())){
									System.out.println("check");
									_control.setPTDBQuery(i);
									break;
								}
							}
							catch(NullPointerException nullPointerException){
								_control.setPTDBQuery(0);
							}
						}
					}
					_control.setPTDBQuery(0);
					
				}
			});
			PTQBflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//PT 전체회원 프레임 화면 구성
	public void createPTSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBPT(_model.PTInfoComboT.getText());
		
		PTTable = new JTable(_model.PTData, _model.PTColNames);
		scrollPane = new JScrollPane(PTTable);
		PTTable.setFillsViewportHeight(true);
		PTTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		PTTable.getColumn("PT 번호").setPreferredWidth(1);
		PTTable.getColumn("PT 번호").setCellRenderer(celAlignCenter);
		PTTable.getColumn("PT 번호").setResizable(false);
		PTTable.getColumn("회원 번호").setPreferredWidth(1);
		PTTable.getColumn("회원 번호").setCellRenderer(celAlignCenter);
		PTTable.getColumn("트레이너 닉네임").setPreferredWidth(50);
		PTTable.getColumn("트레이너 닉네임").setCellRenderer(celAlignCenter);
		PTTable.getColumn("PT 횟수").setPreferredWidth(1);
		PTTable.getColumn("PT 횟수").setCellRenderer(celAlignCenter);
		PTTable.getColumn("PT 단가").setPreferredWidth(50);
		PTTable.getColumn("PT 단가").setCellRenderer(celAlignCenter);
		PTTable.getColumn("PT 총 금액").setPreferredWidth(50);
		PTTable.getColumn("PT 총 금액").setCellRenderer(celAlignCenter);
		PTTable.getColumn("PT 등록일").setPreferredWidth(1);
		PTTable.getColumn("PT 등록일").setCellRenderer(celAlignCenter);
		PTTable.getColumn("PT 시작일").setPreferredWidth(1);
		PTTable.getColumn("PT 시작일").setCellRenderer(celAlignCenter);
		PTTable.getColumn("PT 종료일").setPreferredWidth(1);
		PTTable.getColumn("PT 종료일").setCellRenderer(celAlignCenter);
		PTTable.getColumn("비고").setPreferredWidth(400);
		PTTable.getColumn("비고").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//PT 관리
	public void createPTManage(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.PTFirstL.setBounds(-2, 0, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));
		_model.PTMDayL.setBounds(10, 0, 100, 50);
		_model.PTMDayL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMDayT.setBounds(100, 10, 130, 30);
		_model.PTMDayT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMDayT.setBorder(new LineBorder(Color.black,1));
		_model.PTNumL.setBounds(350, 0, 100, 50);
		_model.PTNumL.setFont(new Font("", Font.BOLD, 18));
		_model.PTNumT.setBounds(445, 10, 130, 30);
		_model.PTNumT.setFont(new Font("", Font.BOLD, 18));
		_model.PTNumT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTSecondL.setBounds(-2, 48, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.PTMHeightL.setBounds(10, 48, 130, 50);
		_model.PTMHeightL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMHeightT.setBounds(100, 58, 130, 30);
		_model.PTMHeightT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMHeightT.setBorder(new LineBorder(Color.black,1));
		_model.PTMWeightL.setBounds(350, 48, 100, 50);
		_model.PTMWeightL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMWeightT.setBounds(445, 58, 130, 30);
		_model.PTMWeightT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMWeightT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTThirdL.setBounds(-2, 96, 690, 50);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.PTMBodyFatL.setBounds(10, 96, 100, 50);
		_model.PTMBodyFatL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMBodyFatT.setBounds(100, 106, 130, 30);
		_model.PTMBodyFatT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMBodyFatT.setBorder(new LineBorder(Color.black,1));
		_model.PTMMuscleL.setBounds(350, 96, 100, 50);
		_model.PTMMuscleL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMMuscleT.setBounds(445, 106, 130, 30);
		_model.PTMMuscleT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMMuscleT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTFourthL.setBounds(-2, 144, 690, 120);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.PTMExerciseL.setBounds(10, 144, 100, 50);
		_model.PTMExerciseL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMExerciseT.setBounds(100, 154, 475, 100);
		_model.PTMExerciseT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMExerciseT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTFifthL.setBounds(-2, 262, 690, 120);
		_model.PTFifthL.setBorder(new LineBorder(Color.black,2));
		_model.PTMImproveL.setBounds(10, 262, 100, 50);
		_model.PTMImproveL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMImproveT.setBounds(100, 272, 475, 100);
		_model.PTMImproveT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMImproveT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTMEnrollBtn.setBounds(430, 390, 200, 35);
		_model.PTMEnrollBtn.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.PTFirstL);
		center.add(_model.PTMDayL);
		center.add(_model.PTMDayT);
		center.add(_model.PTNumL);
		center.add(_model.PTNumT);
		
		center.add(_model.PTSecondL);
		center.add(_model.PTMHeightL);
		center.add(_model.PTMHeightT);
		center.add(_model.PTMWeightL);
		center.add(_model.PTMWeightT);
		
		center.add(_model.PTThirdL);
		center.add(_model.PTMBodyFatL);
		center.add(_model.PTMBodyFatT);
		center.add(_model.PTMMuscleL);
		center.add(_model.PTMMuscleT);	
		
		center.add(_model.PTFourthL);
		center.add(_model.PTMExerciseL);
		center.add(_model.PTMExerciseT);
		
		center.add(_model.PTFifthL);
		center.add(_model.PTMImproveL);
		center.add(_model.PTMImproveT);
		
		center.add(_model.PTMEnrollBtn);
		
		CCPM = true;
		
		Calendar cal = Calendar.getInstance();
		
		_model.PTMDayT.setText((cal.get(Calendar.YEAR)%2000)+""+(cal.get(Calendar.MONTH)+1)+""+cal.get(Calendar.DATE));
		
		if(PTMEnrollflag){
			_model.PTMEnrollBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					_control.setDBPTM();
				}
			});
			PTMEnrollflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}

	//PT 관리 조회
	public void createPTManageQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.PTMInfoCombo.setBounds(50, 15, 200, 30);
		_model.PTMInfoCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CCPMQ){
			_model.PTMInfoCombo.addItem("PT 일자");
			_model.PTMInfoCombo.addItem("PT 번호");
			_model.PTMInfoCombo.addItem("전체 PT");
		}
		_model.PTMInfoComboT.setBounds(270, 15, 130, 30);
		_model.PTMInfoComboT.setFont(new Font("", Font.BOLD, 18));
		_model.PTMInfoComboT.setBorder(new LineBorder(Color.black,1));
		_model.PTMQueryBtn.setBounds(420, 15, 100, 30);
		_model.PTMQueryBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFirstL.setBounds(-2, 58, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));
		_model.PTMDayL.setBounds(10, 58, 100, 50);
		_model.PTMDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMDayL.setBounds(100, 68, 130, 30);
		_model.queryPTMDayL.setFont(new Font("", Font.BOLD, 18));
		_model.PTNumL.setBounds(350, 58, 100, 50);
		_model.PTNumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMNumL.setBounds(445, 68, 130, 30);
		_model.queryPTMNumL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTSecondL.setBounds(-2, 106, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.PTMHeightL.setBounds(10, 106, 100, 50);
		_model.PTMHeightL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMHeightL.setBounds(100, 116, 130, 30);
		_model.queryPTMHeightL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMWeightL.setBounds(350, 106, 130, 50);
		_model.PTMWeightL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMWeightL.setBounds(445, 116, 130, 30);
		_model.queryPTMWeightL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTThirdL.setBounds(-2, 154, 690, 50);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.PTMBodyFatL.setBounds(10, 154, 100, 50);
		_model.PTMBodyFatL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMBodyFatL.setBounds(100, 164, 130, 30);
		_model.queryPTMBodyFatL.setFont(new Font("", Font.BOLD, 18));
		_model.PTMMuscleL.setBounds(350, 154, 100, 50);
		_model.PTMMuscleL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMMuscleL.setBounds(445, 164, 130, 30);
		_model.queryPTMMuscleL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFourthL.setBounds(-2, 202, 690, 120);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.PTMExerciseL.setBounds(10, 202, 100, 50);
		_model.PTMExerciseL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMExerciseL.setBounds(100, 212, 475, 100);
		_model.queryPTMExerciseL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFifthL.setBounds(-2, 320, 690, 120);
		_model.PTFifthL.setBorder(new LineBorder(Color.black,2));
		_model.PTMImproveL.setBounds(10, 320, 100, 50);
		_model.PTMImproveL.setFont(new Font("", Font.BOLD, 18));
		_model.queryPTMImproveL.setBounds(100, 330, 475, 100);
		_model.queryPTMImproveL.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.PTMInfoCombo);
		center.add(_model.PTMInfoComboT);
		center.add(_model.PTMQueryBtn);
		
		center.add(_model.PTFirstL);
		center.add(_model.PTMDayL);
		center.add(_model.queryPTMDayL);
		center.add(_model.PTNumL);
		center.add(_model.queryPTMNumL);
		
		center.add(_model.PTSecondL);
		center.add(_model.PTMHeightL);
		center.add(_model.queryPTMHeightL);
		center.add(_model.PTMWeightL);
		center.add(_model.queryPTMWeightL);
		
		center.add(_model.PTThirdL);
		center.add(_model.PTMBodyFatL);
		center.add(_model.queryPTMBodyFatL);
		center.add(_model.PTMMuscleL);
		center.add(_model.queryPTMMuscleL);	
		
		center.add(_model.PTFourthL);
		center.add(_model.PTMExerciseL);
		center.add(_model.queryPTMExerciseL);
		center.add(_model.PTFifthL);
		center.add(_model.PTMImproveL);
		center.add(_model.queryPTMImproveL);
		
		CCPMQ = true;
		
		if(PTMQBflag){
			_model.PTMQueryBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(_model.PTMInfoCombo.getSelectedItem().toString() == "전체 PT"){
						
						CCPMAQ = true;
						
						createPTMSub();
					}
					else
						_control.getDBPTM(_model.PTMInfoComboT.getText());
					
					for(int i=0; i<_model.Count; i++){
						if(_model.PTMInfoCombo.getSelectedItem().toString() == "PT 번호"){
							System.out.println("ptmnum :"+_model.ptmnum+" NumL_DB : "+_model.PTMNumL_DB[i].getText());
							try{
								if(_model.ptmnum.equals(_model.PTMNumL_DB[i].getText())){
									System.out.println("check");
									_control.setPTMDBQuery(i);
									break;
								}
							}
							catch(NullPointerException nullPointerException){
								_control.setPTMDBQuery(0);
							}
						}
					}

					_control.setPTMDBQuery(0);
				}
			});
			PTMQBflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//PT 전체회원 프레임 화면 구성
	public void createPTMSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBPTM(_model.PTMInfoComboT.getText());
		
		PTMTable = new JTable(_model.PTMData, _model.PTMColNames);
		scrollPane = new JScrollPane(PTMTable);
		PTMTable.setFillsViewportHeight(true);
		PTMTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		PTMTable.getColumn("PT 일자").setPreferredWidth(50);
		PTMTable.getColumn("PT 일자").setCellRenderer(celAlignCenter);
		PTMTable.getColumn("PT 일자").setResizable(false);
		PTMTable.getColumn("PT 번호").setPreferredWidth(1);
		PTMTable.getColumn("PT 번호").setCellRenderer(celAlignCenter);
		PTMTable.getColumn("키").setPreferredWidth(1);
		PTMTable.getColumn("키").setCellRenderer(celAlignCenter);
		PTMTable.getColumn("체중").setPreferredWidth(50);
		PTMTable.getColumn("체중").setCellRenderer(celAlignCenter);
		PTMTable.getColumn("체지방").setPreferredWidth(50);
		PTMTable.getColumn("체지방").setCellRenderer(celAlignCenter);
		PTMTable.getColumn("근육 량").setPreferredWidth(1);
		PTMTable.getColumn("근육 량").setCellRenderer(celAlignCenter);
		PTMTable.getColumn("PT 운동수행능력").setPreferredWidth(400);
		PTMTable.getColumn("PT 운동수행능력").setCellRenderer(celAlignCenter);
		PTMTable.getColumn("개선점").setPreferredWidth(400);
		PTMTable.getColumn("개선점").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//Lesson 등록
	public void createLessonEnroll(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.PTFirstL.setBounds(-1, 0, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));

		_model.LNumL.setBounds(10, 0, 100, 50);
		_model.LNumL.setFont(new Font("", Font.BOLD, 18));
		_model.LNumT.setBounds(100, 10, 130, 30);
		_model.LNumT.setFont(new Font("", Font.BOLD, 18));
		_model.LNumT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTSecondL.setBounds(-1, 48, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.L_GP_NumL.setBounds(10, 48, 100, 50);
		_model.L_GP_NumL.setFont(new Font("", Font.BOLD, 18));
		_model.L_GP_NumT.setBounds(100, 58, 130, 30);
		_model.L_GP_NumT.setFont(new Font("", Font.BOLD, 18));
		_model.L_GP_NumT.setBorder(new LineBorder(Color.black,1));
		_model.L_M_NumL.setBounds(350, 48, 130, 50);
		_model.L_M_NumL.setFont(new Font("", Font.BOLD, 18));
		_model.L_M_NumT.setBounds(445, 58, 130, 30);
		_model.L_M_NumT.setFont(new Font("", Font.BOLD, 18));
		_model.L_M_NumT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTThirdL.setBounds(-1, 96, 690, 50);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.LCountL.setBounds(10, 96, 100, 50);
		_model.LCountL.setFont(new Font("", Font.BOLD, 18));
		_model.LCountT.setBounds(100, 106, 130, 30);
		_model.LCountT.setFont(new Font("", Font.BOLD, 18));
		_model.LCountT.setBorder(new LineBorder(Color.black,1));
		_model.LMoneyL.setBounds(350, 96, 100, 50);
		_model.LMoneyL.setFont(new Font("", Font.BOLD, 18));
		_model.LMoneyT.setBounds(445, 106, 130, 30);
		_model.LMoneyT.setFont(new Font("", Font.BOLD, 18));
		_model.LMoneyT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTFourthL.setBounds(-1, 144, 690, 50);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.L_EPriceL.setBounds(10, 144, 100, 50);
		_model.L_EPriceL.setFont(new Font("", Font.BOLD, 18));
		_model.L_EPriceT.setBounds(100, 154, 130, 30);
		_model.L_EPriceT.setFont(new Font("", Font.BOLD, 18));
		_model.L_EPriceT.setBorder(new LineBorder(Color.black,1));
		_model.LEnrollDayL.setBounds(350, 144, 100, 50);
		_model.LEnrollDayL.setFont(new Font("", Font.BOLD, 18));
		_model.LEnrollDayT.setBounds(445, 154, 130, 30);
		_model.LEnrollDayT.setFont(new Font("", Font.BOLD, 18));
		_model.LEnrollDayT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTFifthL.setBounds(-1, 192, 690, 50);
		_model.PTFifthL.setBorder(new LineBorder(Color.black,2));
		_model.LStartDayL.setBounds(10, 192, 100, 50);
		_model.LStartDayL.setFont(new Font("", Font.BOLD, 18));
		_model.LStartDayT.setBounds(100, 202, 130, 30);
		_model.LStartDayT.setFont(new Font("", Font.BOLD, 18));
		_model.LStartDayT.setBorder(new LineBorder(Color.black,1));
		_model.LLastDayL.setBounds(350, 192, 100, 50);
		_model.LLastDayL.setFont(new Font("", Font.BOLD, 18));
		_model.LLastDayT.setBounds(445, 202, 130, 30);
		_model.LLastDayT.setFont(new Font("", Font.BOLD, 18));
		_model.LLastDayT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTSixthL.setBounds(-1, 240, 690, 120);
		_model.PTSixthL.setBorder(new LineBorder(Color.black,2));
		_model.LNoteL.setBounds(10, 240, 100, 50);
		_model.LNoteL.setFont(new Font("", Font.BOLD, 18));
		_model.LNoteT.setBounds(100, 250, 475, 100);
		_model.LNoteT.setFont(new Font("", Font.BOLD, 18));
		_model.LNoteT.setBorder(new LineBorder(Color.black,1));
		
		_model.LessonEnrollBtn.setBounds(430, 390, 200, 35);
		_model.LessonEnrollBtn.setFont(new Font("", Font.BOLD, 18));
		//패널에 추가
		center.add(_model.PTFirstL);
		center.add(_model.LNumL);
		center.add(_model.LNumT);
		center.add(_model.L_M_NumL);
		center.add(_model.L_M_NumT);
		
		center.add(_model.PTSecondL);
		center.add(_model.L_GP_NumL);
		center.add(_model.L_GP_NumT);
		
		center.add(_model.PTCountT);
		
		center.add(_model.PTThirdL);
		center.add(_model.LCountL);
		center.add(_model.LCountT);
		center.add(_model.LMoneyL);
		center.add(_model.LMoneyT);	
		
		center.add(_model.PTFourthL);
		center.add(_model.L_EPriceL);
		center.add(_model.L_EPriceT);
		center.add(_model.LEnrollDayL);
		center.add(_model.LEnrollDayT);
		
		center.add(_model.PTFifthL);
		center.add(_model.LStartDayL);
		center.add(_model.LStartDayT);
		center.add(_model.LLastDayL);
		center.add(_model.LLastDayT);
		
		center.add(_model.PTSixthL);
		center.add(_model.LNoteL);
		center.add(_model.LNoteT);
		
		center.add(_model.LessonEnrollBtn);
		
		CCLE = true;
		
		Calendar cal = Calendar.getInstance();
		_model.LEnrollDayT.setText((cal.get(Calendar.YEAR)%2000)+""+(cal.get(Calendar.MONTH)+1)+""+cal.get(Calendar.DATE));
		
		if(LessonEnrollflag){
			_model.LessonEnrollBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					_control.setDBLesson();
				}
			});
			LessonEnrollflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//Lesson 조회
	public void createLessonQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.LessonInfoCombo.setBounds(50, 15, 200, 30);
		_model.LessonInfoCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CCLQ){
			_model.LessonInfoCombo.addItem("Lesson 번호");
			_model.LessonInfoCombo.addItem("골프 프로 번호");
			_model.LessonInfoCombo.addItem("회원 번호");
			_model.LessonInfoCombo.addItem("전체 Lesson");
		}
		_model.LessonInfoComboT.setBounds(270, 15, 130, 30);
		_model.LessonInfoComboT.setFont(new Font("", Font.BOLD, 18));
		_model.LessonInfoComboT.setBorder(new LineBorder(Color.black,1));
		_model.LessonQueryBtn.setBounds(420, 15, 100, 30);
		_model.LessonQueryBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFirstL.setBounds(-2, 58, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));
		_model.LNumL.setBounds(10, 58, 100, 50);
		_model.LNumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLNumL.setBounds(100, 68, 130, 30);
		_model.queryLNumL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTSecondL.setBounds(-2, 106, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.L_GP_NumL.setBounds(10, 106, 100, 50);
		_model.L_GP_NumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryL_GP_NumL.setBounds(100, 116, 130, 30);
		_model.queryL_GP_NumL.setFont(new Font("", Font.BOLD, 18));
		_model.L_M_NumL.setBounds(350, 106, 130, 50);
		_model.L_M_NumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryL_M_NumL.setBounds(445, 116, 130, 30);
		_model.queryL_M_NumL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTThirdL.setBounds(-2, 154, 690, 50);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.LCountL.setBounds(10, 154, 100, 50);
		_model.LCountL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLCountL.setBounds(100, 164, 130, 30);
		_model.queryLCountL.setFont(new Font("", Font.BOLD, 18));
		_model.LMoneyL.setBounds(350, 154, 100, 50);
		_model.LMoneyL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLMoneyL.setBounds(445, 164, 130, 30);
		_model.queryLMoneyL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFourthL.setBounds(-2, 202, 690, 50);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.L_EPriceL.setBounds(10, 202, 100, 50);
		_model.L_EPriceL.setFont(new Font("", Font.BOLD, 18));
		_model.queryL_EPriceL.setBounds(100, 212, 130, 30);
		_model.queryL_EPriceL.setFont(new Font("", Font.BOLD, 18));
		_model.LEnrollDayL.setBounds(350, 202, 100, 50);
		_model.LEnrollDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLEnrollDayL.setBounds(445, 212, 130, 30);
		_model.queryLEnrollDayL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFifthL.setBounds(-2, 250, 690, 50);
		_model.PTFifthL.setBorder(new LineBorder(Color.black,2));
		_model.LStartDayL.setBounds(10, 250, 100, 50);
		_model.LStartDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLStartDayL.setBounds(100, 260, 130, 30);
		_model.queryLStartDayL.setFont(new Font("", Font.BOLD, 18));
		_model.LLastDayL.setBounds(350, 250, 100, 50);
		_model.LLastDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLLastDayL.setBounds(445, 260, 130, 30);
		_model.queryLLastDayL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTSixthL.setBounds(-2, 298, 690, 120);
		_model.PTSixthL.setBorder(new LineBorder(Color.black,2));
		_model.LNoteL.setBounds(10, 298, 100, 50);
		_model.LNoteL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLNoteL.setBounds(100, 308, 475, 100);
		_model.queryLNoteL.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.LessonInfoCombo);
		center.add(_model.LessonInfoComboT);
		center.add(_model.LessonQueryBtn);
		
		center.add(_model.PTFirstL);
		center.add(_model.LNumL);
		center.add(_model.queryLNumL);
		
		center.add(_model.PTSecondL);
		center.add(_model.L_GP_NumL);
		center.add(_model.queryL_GP_NumL);
		center.add(_model.L_M_NumL);
		center.add(_model.queryL_M_NumL );
		
		center.add(_model.PTThirdL);
		center.add(_model.LCountL);
		center.add(_model.queryLCountL);
		center.add(_model.LMoneyL);
		center.add(_model.queryLMoneyL);	
		
		center.add(_model.PTFourthL);
		center.add(_model.L_EPriceL);
		center.add(_model.queryL_EPriceL);
		center.add(_model.LEnrollDayL);
		center.add(_model.queryLEnrollDayL);
		
		center.add(_model.PTFifthL);
		center.add(_model.LStartDayL);
		center.add(_model.queryLStartDayL);
		center.add(_model.LLastDayL);
		center.add(_model.queryLLastDayL);
		
		center.add(_model.PTSixthL);
		center.add(_model.LNoteL);
		center.add(_model.queryLNoteL);
		
		CCLQ = true;
		
		if(LessonQBflag){
			_model.LessonQueryBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(_model.LessonInfoCombo.getSelectedItem().toString() == "전체 Lesson"){
						
						CCLAQ = true;
						
						createLessonSub();
					}
					else
						_control.getDBLesson(_model.LessonInfoComboT.getText());
					
					for(int i=0; i<_model.Count; i++){
						if(_model.LessonInfoCombo.getSelectedItem().toString() == "골프 프로 번호"){
							System.out.println("lnum :"+_model.lgnum+" NumL_DB : "+_model.L_GP_NumL_DB[i].getText());
							try{
								if(_model.lgnum.equals(_model.L_GP_NumL_DB[i].getText())){
									System.out.println("check");
									_control.setPTDBQuery(i);
									break;
								}
							}
							catch(NullPointerException nullPointerException){
								_control.setLessonDBQuery(0);
							}
						}
						else if(_model.LessonInfoCombo.getSelectedItem().toString() == "회원 번호"){
							System.out.println("lcnum :"+_model.lcnum+" NumL_DB : "+_model.L_M_NumL_DB[i].getText());
							try{
							if(_model.lcnum.equals(_model.L_M_NumL_DB[i].getText())){
								System.out.println("check");
								_control.setPTDBQuery(i);
								break;
							}
							}
							catch(NullPointerException nullPointerException){
								_control.setLessonDBQuery(0);
							}
						}
					}
					
					_control.setLessonDBQuery(0);

				}
			});
			LessonQBflag = false;
		}
		
		System.out.println(_model.queryLNumL.getText());
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//Lesson 전체회원 프레임 화면 구성
	public void createLessonSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBLesson(_model.LessonInfoComboT.getText());
		
		LessonTable = new JTable(_model.LessonData, _model.LessonColNames);
		scrollPane = new JScrollPane(LessonTable);
		LessonTable.setFillsViewportHeight(true);
		LessonTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		LessonTable.getColumn("Lesson 번호").setPreferredWidth(1);
		LessonTable.getColumn("Lesson 번호").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("Lesson 번호").setResizable(false);
		LessonTable.getColumn("회원 번호").setPreferredWidth(1);
		LessonTable.getColumn("회원 번호").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("골프프로 번호").setPreferredWidth(50);
		LessonTable.getColumn("골프프로 번호").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("Lesson 횟수").setPreferredWidth(1);
		LessonTable.getColumn("Lesson 횟수").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("Lesson 단가").setPreferredWidth(50);
		LessonTable.getColumn("Lesson 단가").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("Lesson 총 금액").setPreferredWidth(50);
		LessonTable.getColumn("Lesson 총 금액").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("Lesson 등록일").setPreferredWidth(1);
		LessonTable.getColumn("Lesson 등록일").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("Lesson 시작일").setPreferredWidth(1);
		LessonTable.getColumn("Lesson 시작일").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("Lesson 종료일").setPreferredWidth(1);
		LessonTable.getColumn("Lesson 종료일").setCellRenderer(celAlignCenter);
		LessonTable.getColumn("비고").setPreferredWidth(400);
		LessonTable.getColumn("비고").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//Lesson 관리
	public void createLessonManage(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.PTFirstL.setBounds(-2, 0, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));
		_model.LMDayL.setBounds(10, 0, 100, 50);
		_model.LMDayL.setFont(new Font("", Font.BOLD, 18));
		_model.LMDayT.setBounds(100, 10, 130, 30);
		_model.LMDayT.setFont(new Font("", Font.BOLD, 18));
		_model.LMDayT.setBorder(new LineBorder(Color.black,1));
		_model.LNumL.setBounds(350, 0, 100, 50);
		_model.LNumL.setFont(new Font("", Font.BOLD, 18));
		_model.LNumT.setBounds(445, 10, 130, 30);
		_model.LNumT.setFont(new Font("", Font.BOLD, 18));
		_model.LNumT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTSecondL.setBounds(-2, 48, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.LMDistanceL.setBounds(10, 48, 130, 50);
		_model.LMDistanceL.setFont(new Font("", Font.BOLD, 18));
		_model.LMDistanceT.setBounds(100, 58, 130, 30);
		_model.LMDistanceT.setFont(new Font("", Font.BOLD, 18));
		_model.LMDistanceT.setBorder(new LineBorder(Color.black,1));
		_model.LMBallSpeedL.setBounds(350, 48, 100, 50);
		_model.LMBallSpeedL.setFont(new Font("", Font.BOLD, 18));
		_model.LMBallSpeedT.setBounds(445, 58, 130, 30);
		_model.LMBallSpeedT.setFont(new Font("", Font.BOLD, 18));
		_model.LMBallSpeedT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTThirdL.setBounds(-2, 96, 690, 120);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.LMExerciseL.setBounds(10, 96, 100, 50);
		_model.LMExerciseL.setFont(new Font("", Font.BOLD, 18));
		_model.LMExerciseT.setBounds(100, 106, 475, 100);
		_model.LMExerciseT.setFont(new Font("", Font.BOLD, 18));
		_model.LMExerciseT.setBorder(new LineBorder(Color.black,1));
		
		_model.PTFourthL.setBounds(-2, 214, 690, 120);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.LMImproveL.setBounds(10, 214, 100, 50);
		_model.LMImproveL.setFont(new Font("", Font.BOLD, 18));
		_model.LMImproveT.setBounds(100, 224, 475, 100);
		_model.LMImproveT.setFont(new Font("", Font.BOLD, 18));
		_model.LMImproveT.setBorder(new LineBorder(Color.black,1));		
		
		_model.LessonMEnrollBtn.setBounds(430, 390, 200, 35);
		_model.LessonMEnrollBtn.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.PTFirstL);
		center.add(_model.LMDayL);
		center.add(_model.LMDayT);
		center.add(_model.LNumL);
		center.add(_model.LNumT);
		
		center.add(_model.PTSecondL);
		center.add(_model.LMDistanceL);
		center.add(_model.LMDistanceT);
		center.add(_model.LMBallSpeedL);
		center.add(_model.LMBallSpeedT);
		
		center.add(_model.PTThirdL);
		center.add(_model.LMExerciseL);
		center.add(_model.LMExerciseT);
		
		center.add(_model.PTFourthL);
		center.add(_model.LMImproveL);
		center.add(_model.LMImproveT);
		
		center.add(_model.LessonMEnrollBtn);
		
		CCLM = true;
		
		Calendar cal = Calendar.getInstance();
		_model.LMDayT.setText((cal.get(Calendar.YEAR)%2000)+""+(cal.get(Calendar.MONTH)+1)+""+cal.get(Calendar.DATE));
		
		if(LessonMEnrollflag){
			_model.LessonMEnrollBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					_control.setDBLessonM();
				}
			});
			LessonMEnrollflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//Lesson 관리 조회
	public void createLessonManageQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//패널에 레이블 & 버튼 & 텍스트 필드 & 라디오 버튼 & 콤보 박스 추가
		_model.LessonMInfoCombo.setBounds(50, 15, 200, 30);
		_model.LessonMInfoCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CCLMQ){
			_model.LessonMInfoCombo.addItem("Lesson 일자");
			_model.LessonMInfoCombo.addItem("Lesson 번호");
			_model.LessonMInfoCombo.addItem("전체 Lesson");
		}
		_model.LessonMInfoComboT.setBounds(270, 15, 130, 30);
		_model.LessonMInfoComboT.setFont(new Font("", Font.BOLD, 18));
		_model.LessonMInfoComboT.setBorder(new LineBorder(Color.black,1));
		_model.LessonMQueryBtn.setBounds(420, 15, 100, 30);
		_model.LessonMQueryBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFirstL.setBounds(-2, 58, 690, 50);
		_model.PTFirstL.setBorder(new LineBorder(Color.black,2));
		_model.LMDayL.setBounds(10, 58, 100, 50);
		_model.LMDayL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLMDayL.setBounds(100, 68, 130, 30);
		_model.queryLMDayL.setFont(new Font("", Font.BOLD, 18));
		_model.LNumL.setBounds(350, 58, 100, 50);
		_model.LNumL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLMNumL.setBounds(445, 68, 130, 30);
		_model.queryLMNumL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTSecondL.setBounds(-2, 106, 690, 50);
		_model.PTSecondL.setBorder(new LineBorder(Color.black,2));
		_model.LMDistanceL.setBounds(10, 106, 100, 50);
		_model.LMDistanceL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLMDistanceL.setBounds(100, 116, 130, 30);
		_model.queryLMDistanceL.setFont(new Font("", Font.BOLD, 18));
		_model.LMBallSpeedL.setBounds(350, 106, 130, 50);
		_model.LMBallSpeedL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLMBallSpeedL.setBounds(445, 116, 130, 30);
		_model.queryLMBallSpeedL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTThirdL.setBounds(-2, 154, 690, 120);
		_model.PTThirdL.setBorder(new LineBorder(Color.black,2));
		_model.LMExerciseL.setBounds(10, 154, 100, 50);
		_model.LMExerciseL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLMExerciseL.setBounds(100, 164, 475, 100);
		_model.queryLMExerciseL.setFont(new Font("", Font.BOLD, 18));
		
		_model.PTFourthL.setBounds(-2, 272, 690, 120);
		_model.PTFourthL.setBorder(new LineBorder(Color.black,2));
		_model.LMImproveL.setBounds(10, 272, 100, 50);
		_model.LMImproveL.setFont(new Font("", Font.BOLD, 18));
		_model.queryLMImproveL.setBounds(100, 282, 475, 100);
		_model.queryLMImproveL.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.LessonMInfoCombo);
		center.add(_model.LessonMInfoComboT);
		center.add(_model.LessonMQueryBtn);
		
		center.add(_model.PTFirstL);
		center.add(_model.LMDayL);
		center.add(_model.queryLMDayL);
		center.add(_model.LNumL);
		center.add(_model.queryLMNumL);
		
		center.add(_model.PTSecondL);
		center.add(_model.LMDistanceL);
		center.add(_model.queryLMDistanceL);
		center.add(_model.LMBallSpeedL);
		center.add(_model.queryLMBallSpeedL);
		
		center.add(_model.PTThirdL);
		center.add(_model.LMExerciseL);
		center.add(_model.queryLMExerciseL);
		
		center.add(_model.PTFourthL);
		center.add(_model.LMImproveL);
		center.add(_model.queryLMImproveL);
		
		CCLMQ = true;
		
		if(LessonMQBflag){
			_model.LessonMQueryBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(_model.LessonMInfoCombo.getSelectedItem().toString() == "전체 Lesson"){
						
						CCLMAQ = true;
						
						createLessonMSub();
					}
					else
						_control.getDBLessonM(_model.LessonMInfoComboT.getText());
					
					for(int i=0; i<_model.Count; i++){
						if(_model.LessonMInfoCombo.getSelectedItem().toString() == "Lesson 번호"){
							System.out.println("lmnum :"+_model.lmnum+" NumL_DB : "+_model.LMNumL_DB[i].getText());
							try{
								if(_model.lmnum.equals(_model.LMNumL_DB[i].getText())){
									System.out.println("check");
									_control.setPTDBQuery(i);
									break;
								}
							}
							catch(NullPointerException nullPointerException){
								_control.setLessonDBQuery(0);
							}
						}
					}
					
					_control.setLessonMDBQuery(0);

					
				}
			});
			LessonMQBflag = false;
		}
		
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//Lesson 전체회원 프레임 화면 구성
	public void createLessonMSub(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBLessonM(_model.LessonMInfoComboT.getText());
		
		LessonMTable = new JTable(_model.LessonMData, _model.LessonMColNames);
		scrollPane = new JScrollPane(LessonMTable);
		LessonMTable.setFillsViewportHeight(true);
		LessonMTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		LessonMTable.getColumn("Lesson 일자").setPreferredWidth(50);
		LessonMTable.getColumn("Lesson 일자").setCellRenderer(celAlignCenter);
		LessonMTable.getColumn("Lesson 일자").setResizable(false);
		LessonMTable.getColumn("Lesson 번호").setPreferredWidth(1);
		LessonMTable.getColumn("Lesson 번호").setCellRenderer(celAlignCenter);
		LessonMTable.getColumn("비거리").setPreferredWidth(1);
		LessonMTable.getColumn("비거리").setCellRenderer(celAlignCenter);
		LessonMTable.getColumn("볼 속도").setPreferredWidth(50);
		LessonMTable.getColumn("볼 속도").setCellRenderer(celAlignCenter);
		LessonMTable.getColumn("Lesson 운동수행능력").setPreferredWidth(400);
		LessonMTable.getColumn("Lesson 운동수행능력").setCellRenderer(celAlignCenter);
		LessonMTable.getColumn("개선점").setPreferredWidth(400);
		LessonMTable.getColumn("개선점").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	
	
	
	//profit 생성
	public void createProfit(){				
		//서쪽 패널 생성
		west = new JPanel();
		west.setLayout(new GridLayout(6, 1));
		
		//패널에 버튼 추가
		west.add(_model.salesEnroll);
		west.add(_model.salesQuery);
		west.add(blank[0] = new JLabel());
		west.add(blank[1] = new JLabel());
		west.add(blank[2] = new JLabel());
		west.add(blank[3] = new JLabel());
		
		//매출 폰트 설정
		_model.salesEnroll.setFont(new Font("", Font.BOLD, 18));
		_model.salesQuery.setFont(new Font("", Font.BOLD, 18));
		
		if(ProfitEnrollflag){
			//매출 등록 버튼을 눌렀을 때
			_model.salesEnroll.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					profitRemoveCenter();
	
					profitCheckBgcolor(clickBtn);
					_model.salesEnroll.setBackground(Color.LIGHT_GRAY);
					clickBtn = e.getActionCommand();
					
					ProfitALLCLEAR();
					
					createSalesEnroll();
				}
			});
			ProfitEnrollflag = false;
		}
		
		if(ProfitQueryflag){
			//매출 조회 버튼을 눌렀을 때
			_model.salesQuery.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					profitRemoveCenter();
					profitRemoveScroll();
	
					profitCheckBgcolor(clickBtn);
					_model.salesQuery.setBackground(Color.LIGHT_GRAY);
					clickBtn = e.getActionCommand();
					
					createSalesQuery();
				}
			});
			ProfitQueryflag = false;
		}
		
		//컨테이너에 패널 추가			
		contentPane.add(west, BorderLayout.WEST);
		frame.repaint();
		frame.setVisible(true);
	}
	
	//매출 등록
	public void createSalesEnroll(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//폰트 및 위치 설정
		_model.salesFirstL.setBounds(40, 100, 550, 50);
		_model.salesFirstL.setBorder(new LineBorder(Color.black,2));
		_model.salesEnrollMonthL.setBounds(50, 110, 100, 30);
		_model.salesEnrollMonthL.setFont(new Font("", Font.BOLD, 18));
		_model.salesEnrollMonthCombo.setBounds(150, 110, 130, 30);
		_model.salesEnrollMonthCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CPE){
			_model.salesEnrollMonthCombo.addItem("1 개월 권");
			_model.salesEnrollMonthCombo.addItem("3 개월 권");
			_model.salesEnrollMonthCombo.addItem("6 개월 권");
			_model.salesEnrollMonthCombo.addItem("12 개월 권");
		}
		_model.salesEnrollMonthT.setBounds(320, 110, 80, 30);
		_model.salesEnrollMonthT.setFont(new Font("", Font.BOLD, 18));
		_model.salesEnrollMonthT.setBorder(new LineBorder(Color.black,1));
		_model.salesEnrollMonthBtn.setBounds(440, 110, 130, 30);
		_model.salesEnrollMonthBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.salesSecondL.setBounds(40, 250, 550, 50);
		_model.salesSecondL.setBorder(new LineBorder(Color.black,2));
		_model.salesEnrollCafeL.setBounds(50, 260, 100, 30);
		_model.salesEnrollCafeL.setFont(new Font("", Font.BOLD, 18));
		_model.salesEnrollCafeCombo.setBounds(150, 260, 130, 30);
		_model.salesEnrollCafeCombo.setFont(new Font("", Font.BOLD, 18));
		if(!CPE){
			_model.salesEnrollCafeCombo.addItem("아메리카노");
			_model.salesEnrollCafeCombo.addItem("에스프레소");
			_model.salesEnrollCafeCombo.addItem("우유");
			_model.salesEnrollCafeCombo.addItem("포카리스웨트");
		}
		_model.salesEnrollCafeT.setBounds(320, 260, 80, 30);
		_model.salesEnrollCafeT.setFont(new Font("", Font.BOLD, 18));
		_model.salesEnrollCafeT.setBorder(new LineBorder(Color.black,1));
		_model.salesEnrollCafeBtn.setBounds(440, 260, 130, 30);
		_model.salesEnrollCafeBtn.setFont(new Font("", Font.BOLD, 18));
		
//		_model.salesThirdL.setBounds(40, 240, 550, 50);
//		_model.salesThirdL.setBorder(new LineBorder(Color.black,2));
//		_model.salesEnrollPTL.setBounds(50, 250, 100, 30);
//		_model.salesEnrollPTL.setFont(new Font("", Font.BOLD, 18));
//		_model.salesEnrollPTCombo.setBounds(150, 250, 130, 30);
//		_model.salesEnrollPTCombo.setFont(new Font("", Font.BOLD, 18));
//		if(!CPE){
//			_model.salesEnrollPTCombo.addItem("아메리카노");
//			_model.salesEnrollPTCombo.addItem("에스프레소");
//			_model.salesEnrollPTCombo.addItem("우유");
//			_model.salesEnrollPTCombo.addItem("포카리스웨트");
//		}
//		_model.salesEnrollPTT.setBounds(320, 250, 80, 30);
//		_model.salesEnrollPTT.setFont(new Font("", Font.BOLD, 18));
//		_model.salesEnrollPTT.setBorder(new LineBorder(Color.black,1));
//		_model.salesEnrollPTBtn.setBounds(440, 250, 130, 30);
//		_model.salesEnrollPTBtn.setFont(new Font("", Font.BOLD, 18));
//		
//		_model.salesFourthL.setBounds(40, 340, 550, 50);
//		_model.salesFourthL.setBorder(new LineBorder(Color.black,2));
//		_model.salesEnrollLessonL.setBounds(50, 350, 100, 30);
//		_model.salesEnrollLessonL.setFont(new Font("", Font.BOLD, 18));
//		_model.salesEnrollLessonCombo.setBounds(150, 350, 130, 30);
//		_model.salesEnrollLessonCombo.setFont(new Font("", Font.BOLD, 18));
//		if(!CPE){
//			_model.salesEnrollLessonCombo.addItem("아메리카노");
//			_model.salesEnrollLessonCombo.addItem("에스프레소");
//			_model.salesEnrollLessonCombo.addItem("우유");
//			_model.salesEnrollLessonCombo.addItem("포카리스웨트");
//		}
//		_model.salesEnrollLessonT.setBounds(320, 350, 80, 30);
//		_model.salesEnrollLessonT.setFont(new Font("", Font.BOLD, 18));
//		_model.salesEnrollLessonT.setBorder(new LineBorder(Color.black,1));
//		_model.salesEnrollLessonBtn.setBounds(440, 350, 130, 30);
//		_model.salesEnrollLessonBtn.setFont(new Font("", Font.BOLD, 18));
		
		_model.salesFifthL.setBounds(30, 90, 570, 225);
		_model.salesFifthL.setBorder(new LineBorder(Color.black,5));
		
		//패널에 추가
		center.add(_model.salesFirstL);
		center.add(_model.salesEnrollMonthL);
		center.add(_model.salesEnrollMonthCombo);
		center.add(_model.salesEnrollMonthT);
		center.add(_model.salesEnrollMonthBtn);
		
		center.add(_model.salesSecondL);
		center.add(_model.salesEnrollCafeL);
		center.add(_model.salesEnrollCafeCombo);
		center.add(_model.salesEnrollCafeT);
		center.add(_model.salesEnrollCafeBtn);
		
//		center.add(_model.salesThirdL);
//		center.add(_model.salesEnrollPTL);
//		center.add(_model.salesEnrollPTCombo);
//		center.add(_model.salesEnrollPTT);
//		center.add(_model.salesEnrollPTBtn);
//		
//		center.add(_model.salesFourthL);
//		center.add(_model.salesEnrollLessonL);
//		center.add(_model.salesEnrollLessonCombo);
//		center.add(_model.salesEnrollLessonT);
//		center.add(_model.salesEnrollLessonBtn);
		
		center.add(_model.salesFifthL);
		
		CPE = true;
		
		if(ProfitEnrollMflag){
			_model.salesEnrollMonthBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(_model.salesEnrollMonthCombo.getSelectedItem().toString().equals("1 개월 권") ){
						_model.salesEnrollMonthAllPrice = (Integer.parseInt(_model.salesEnrollMonthT.getText()) * 50000);
					}
					else if(_model.salesEnrollMonthCombo.getSelectedItem().toString().equals("3 개월 권") ){
						_model.salesEnrollMonthAllPrice = (Integer.parseInt(_model.salesEnrollMonthT.getText()) * 130000);
					}
					else if(_model.salesEnrollMonthCombo.getSelectedItem().toString().equals("6 개월 권") ){
						_model.salesEnrollMonthAllPrice = (Integer.parseInt(_model.salesEnrollMonthT.getText()) * 250000);
					}
					else if(_model.salesEnrollMonthCombo.getSelectedItem().toString().equals("12 개월 권") ){
						_model.salesEnrollMonthAllPrice = (Integer.parseInt(_model.salesEnrollMonthT.getText()) * 450000);
					}
					
					_control.setDBSalesMonth();
					
				}
			});
			ProfitEnrollMflag = false;
		}
		
		if(ProfitEnrollCflag){
			_model.salesEnrollCafeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(_model.salesEnrollCafeCombo.getSelectedItem().toString().equals("아메리카노") ){
						_model.salesEnrollCafeAllPrice = (Integer.parseInt(_model.salesEnrollCafeT.getText()) * 1500);
					}
					else if(_model.salesEnrollCafeCombo.getSelectedItem().toString().equals("에스프레소") ){
						_model.salesEnrollCafeAllPrice = (Integer.parseInt(_model.salesEnrollCafeT.getText()) * 1000);
					}
					else if(_model.salesEnrollCafeCombo.getSelectedItem().toString().equals("우유") ){
						_model.salesEnrollCafeAllPrice = (Integer.parseInt(_model.salesEnrollCafeT.getText()) * 1500);
					}
					else if(_model.salesEnrollCafeCombo.getSelectedItem().toString().equals("포카리스웨트") ){
						_model.salesEnrollCafeAllPrice = (Integer.parseInt(_model.salesEnrollCafeT.getText()) * 1000);
					}
					
					_control.setDBSalesCafe();
				}
			});
			ProfitEnrollCflag = false;
		}
		
		

		//컨테이너에 추가
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
		
	}
	
	//매출 조회
	public void createSalesQuery(){
		//중앙 패널 생성
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(Color.LIGHT_GRAY);
		
		//폰트 및 위치 설정
		_model.salesQueryMonthBtn.setBounds(50, 50, 200, 100);
		_model.salesQueryMonthBtn.setFont(new Font("", Font.BOLD, 18));
		_model.salesQueryCafeBtn.setBounds(400, 50, 200, 100);
		_model.salesQueryCafeBtn.setFont(new Font("", Font.BOLD, 18));
		_model.salesQueryPTBtn.setBounds(50, 250, 200, 100);
		_model.salesQueryPTBtn.setFont(new Font("", Font.BOLD, 18));
		_model.salesQueryLessonBtn.setBounds(400, 250, 200, 100);
		_model.salesQueryLessonBtn.setFont(new Font("", Font.BOLD, 18));
		
		//패널에 추가
		center.add(_model.salesQueryMonthBtn);
		center.add(_model.salesQueryCafeBtn);
		center.add(_model.salesQueryPTBtn);
		center.add(_model.salesQueryLessonBtn);
		
		CPQ = true;
		
		if(SaleQueryMflag){
			//개월권 매출 조회 버튼을 눌렀을 때
			_model.salesQueryMonthBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					profitRemoveScroll();
					
					CPQM = true;
					
					createSalesMonthQuery();
				}
			});
			SaleQueryMflag = false;
		}
		
		if(SaleQueryCflag){
			//카페 매출 조회 버튼을 눌렀을 때
			_model.salesQueryCafeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					profitRemoveScroll();
					
					CPQC = true;
					createSalesCafeQuery();
				}
			});
			SaleQueryCflag = false;
		}
		
		if(SaleQueryPflag){
			//PT 매출 조회 버튼을 눌렀을 때
			_model.salesQueryPTBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					profitRemoveScroll();
					
					CPQP = true;
					createSalesPTQuery();
				}
			});
			SaleQueryPflag = false;
		}
		
		if(SaleQueryLflag){
			//Lesson 매출 조회 버튼을 눌렀을 때
			_model.salesQueryLessonBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					profitRemoveScroll();
					
					CPQL = true;
					createSalesLessonQuery();
				}
			});
			SaleQueryLflag = false;
		}
		
		

		//컨테이너에 추가
		contentPane.add(center, BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
		
	}
	
	//개월권 전체 판매 확인
	public void createSalesMonthQuery(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(800,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBSalesMonth();
		
		SalesMTable = new JTable(_model.SalesMData, _model.SalesMColNames);
		scrollPane = new JScrollPane(SalesMTable);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		SalesMTable.getColumn("날짜").setPreferredWidth(10);
		SalesMTable.getColumn("날짜").setCellRenderer(celAlignCenter);
		SalesMTable.getColumn("항목").setPreferredWidth(1);
		SalesMTable.getColumn("항목").setCellRenderer(celAlignCenter);
		SalesMTable.getColumn("개수").setPreferredWidth(1);
		SalesMTable.getColumn("개수").setCellRenderer(celAlignCenter);
		SalesMTable.getColumn("단가").setPreferredWidth(1);
		SalesMTable.getColumn("단가").setCellRenderer(celAlignCenter);
		SalesMTable.getColumn("총 금액").setPreferredWidth(1);
		SalesMTable.getColumn("총 금액").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//카페 전체 판매 확인
	public void createSalesCafeQuery(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(800,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBSalesCafe();
		
		SalesCTable = new JTable(_model.SalesCData, _model.SalesCColNames);
		scrollPane = new JScrollPane(SalesCTable);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		SalesCTable.getColumn("날짜").setPreferredWidth(10);
		SalesCTable.getColumn("날짜").setCellRenderer(celAlignCenter);
		SalesCTable.getColumn("항목").setPreferredWidth(1);
		SalesCTable.getColumn("항목").setCellRenderer(celAlignCenter);
		SalesCTable.getColumn("개수").setPreferredWidth(1);
		SalesCTable.getColumn("개수").setCellRenderer(celAlignCenter);
		SalesCTable.getColumn("단가").setPreferredWidth(1);
		SalesCTable.getColumn("단가").setCellRenderer(celAlignCenter);
		SalesCTable.getColumn("총 금액").setPreferredWidth(1);
		SalesCTable.getColumn("총 금액").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//PT 전체 판매 확인
	public void createSalesPTQuery(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(800,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBSalesPT();
		
		SalesPTTable = new JTable(_model.SalesPData, _model.SalesPColNames);
		scrollPane = new JScrollPane(SalesPTTable);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		SalesPTTable.getColumn("날짜").setPreferredWidth(10);
		SalesPTTable.getColumn("날짜").setCellRenderer(celAlignCenter);
		SalesPTTable.getColumn("항목").setPreferredWidth(1);
		SalesPTTable.getColumn("항목").setCellRenderer(celAlignCenter);
		SalesPTTable.getColumn("PT 횟수").setPreferredWidth(1);
		SalesPTTable.getColumn("PT 횟수").setCellRenderer(celAlignCenter);
		SalesPTTable.getColumn("단가").setPreferredWidth(1);
		SalesPTTable.getColumn("단가").setCellRenderer(celAlignCenter);
		SalesPTTable.getColumn("총 금액").setPreferredWidth(1);
		SalesPTTable.getColumn("총 금액").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	//PT 전체 판매 확인
	public void createSalesLessonQuery(){
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(800,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBSalesLesson();
		
		SalesLessonTable = new JTable(_model.SalesLData, _model.SalesLColNames);
		scrollPane = new JScrollPane(SalesLessonTable);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		SalesLessonTable.getColumn("날짜").setPreferredWidth(10);
		SalesLessonTable.getColumn("날짜").setCellRenderer(celAlignCenter);
		SalesLessonTable.getColumn("항목").setPreferredWidth(1);
		SalesLessonTable.getColumn("항목").setCellRenderer(celAlignCenter);
		SalesLessonTable.getColumn("Lesson 횟수").setPreferredWidth(1);
		SalesLessonTable.getColumn("Lesson 횟수").setCellRenderer(celAlignCenter);
		SalesLessonTable.getColumn("단가").setPreferredWidth(1);
		SalesLessonTable.getColumn("단가").setCellRenderer(celAlignCenter);
		SalesLessonTable.getColumn("총 금액").setPreferredWidth(1);
		SalesLessonTable.getColumn("총 금액").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberALLCLEAR();
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}
	
	
	//버튼 클릭 확인
	public void memberCheckBgcolor(String str){
		switch(str){
		case "회원 등록" :
			_model.customerEnroll.setBackground(BtnColor);
		case "회원 조회" :
			_model.customerQuery.setBackground(BtnColor);
		case "트레이너 등록" :
			_model.healthTrainerEnroll.setBackground(BtnColor);
		case "트레이너 조회" :
			_model.healthTrainerQuery.setBackground(BtnColor);
		case "골프프로 등록" :
			_model.golfProEnroll.setBackground(BtnColor);
		case "골프프로 조회" :
			_model.golfProQuery.setBackground(BtnColor);
		case "우수회원 등록" :
			_model.EliteCustomerEnroll.setBackground(BtnColor);
		case "" :
			
		}
	}
	
	//버튼 클릭 확인
	public void classCheckBgcolor(String str){
		switch(str){
		case "PT 등록" :
			_model.PTEnroll.setBackground(BtnColor);
		case "PT 조회" :
			_model.PTQuery.setBackground(BtnColor);
		case "PT 관리" :
			_model.PTManage.setBackground(BtnColor);
		case "PT 관리조회" :
			_model.PTManageQuery.setBackground(BtnColor);
		case "Lesson 등록" :
			_model.LessonEnroll.setBackground(BtnColor);
		case "Lesson 조회" :
			_model.LessonQuery.setBackground(BtnColor);
		case "Lesson 관리" :
			_model.LessonManage.setBackground(BtnColor);
		case "Lesson 관리조회" :
			_model.LessonManageQuery.setBackground(BtnColor);
		case "" :
			
		}
	}
	
	public void profitCheckBgcolor(String str){
		switch(str){
		case "일일 판매 등록" :
			_model.salesEnroll.setBackground(BtnColor);
		case "일일 판매 조회" :
			_model.salesQuery.setBackground(BtnColor);
		case "" :
			
		}
	}
	
	//Center panel 제거
	public void memberRemoveCenter(){
		if(CMCE)
			contentPane.remove(center);
		else if(CMCQ)
			contentPane.remove(center); 
		else if(CMTE)
			contentPane.remove(center);
		else if(CMTQ)
			contentPane.remove(center);
		else if(CMGE)
			contentPane.remove(center);
		else if(CMGQ)
			contentPane.remove(center);
		else if(CMEE)
			contentPane.remove(center);
	}
	
	//Scroll panel 제거
	public void memberRemoveScroll(){
		if(CMCAQ)
			sub.remove(scrollPane);
		else if(CMTAQ)
			sub.remove(scrollPane);
		else if(CMGAQ)
			sub.remove(scrollPane);
	}
	
	
	//Center panel 제거
	public void classRemoveCenter(){
		if(CCPE)
			contentPane.remove(center);
		else if(CCPQ)
			contentPane.remove(center);
		else if(CCPM)
			contentPane.remove(center);
		else if(CCPMQ)
			contentPane.remove(center);
		else if(CCLE)
			contentPane.remove(center);
		else if(CCLQ)
			contentPane.remove(center);
		else if(CCLM)
			contentPane.remove(center);
		else if(CCLMQ)
			contentPane.remove(center);
	}
	
	//Scroll panel 제거
	public void classRemoveScroll(){
		if(CCPAQ)
			sub.remove(scrollPane);
		else if(CCLAQ)
			sub.remove(scrollPane);
		else if(CCPMAQ)
			sub.remove(scrollPane);
		else if(CCLMAQ)
			sub.remove(scrollPane);
	}
	
	//Center panel 제거
	public void profitRemoveCenter(){
		if(CPE)
			contentPane.remove(center);
		else if(CPQ)
			contentPane.remove(center);
	}
	
	//Scroll panel 제거
	public void profitRemoveScroll(){
		if(CPQM)
			sub.remove(scrollPane);
		else if(CPQC)
			sub.remove(scrollPane);
		else if(CPQP)
			sub.remove(scrollPane);
		else if(CPQL)
			sub.remove(scrollPane);
	}
	
	
	
	public void MemberALLCLEAR(){
		_model.queryCustomerNumL.setText("");
		_model.queryCustomerGenderL.setText("");
		_model.queryCustomerNameL.setText("");
		_model.queryCustomerBirthL.setText("");
		_model.queryCustomerPhoneL.setText("");
		_model.queryCustomerPathL.setText("");
		_model.queryCustomerAddrL.setText("");
		_model.queryCustomerEliteL.setText("");
		_model.queryCustomerFirstDayL.setText("");
		_model.queryCustomerLastDayL.setText("");
		_model.queryCustomerNoteL.setText("");
		
		_model.customerNumT.setText("");
		_model.customerNameT.setText("");
		_model.customerBirthT.setText("");
		_model.customerPhoneT.setText("");
		_model.customerAddrT.setText("");
		_model.customerFirstDayT.setText("");
		_model.customerLastDayT.setText("");
		OfficialNoteT.setText("");

		_model.queryTrainerNickL.setText("");
		_model.queryTrainerGenderL.setText("");
		_model.queryTrainerNameL.setText("");
		_model.queryTrainerBirthL.setText("");
		_model.queryTrainerPhoneL.setText("");
		_model.queryTrainerLicenseL.setText("");
		_model.queryTrainerAddrL.setText("");
		
		_model.trainerNickT.setText("");
		_model.trainerNameT.setText("");
		_model.trainerBirthT.setText("");
		_model.trainerPhoneT.setText("");
		_model.trainerLicenseT.setText("");
		_model.trainerAddrT.setText("");

		_model.queryGolfProNumL.setText("");
		_model.queryGolfProGenderL.setText("");
		_model.queryGolfProNameL.setText("");
		_model.queryGolfProBirthL.setText("");
		_model.queryGolfProPhoneL.setText("");
		_model.queryGolfProAddrL.setText("");
		_model.queryGolfProLicenseL.setText("");
		
		_model.golfProNumT.setText("");
		_model.golfProNameT.setText("");
		_model.golfProBirthT.setText("");
		_model.golfProPhoneT.setText("");
		_model.golfProLicenseT.setText("");
		_model.golfProAddrT.setText("");
		
		_model.EliteT.setText("");
	}
	
	public void CourseALLCLEAR(){
		_model.PTNumT.setText("");
		_model.PT_M_NumT.setText("");
		_model.PT_T_NickT.setText("");
		_model.PTCountT.setText("");
		_model.PTMoneyT.setText("");
		_model.PT_EPriceT.setText("");
		_model.PTEnrollDayT.setText("");
		_model.PTStartDayT.setText("");
		_model.PTLastDayT.setText("");
		_model.PTNoteT.setText("");
		
		_model.queryPTNumL.setText("");
		_model.queryPT_M_NumL.setText("");
		_model.queryPT_T_NickL.setText("");
		_model.queryPTCountL.setText("");
		_model.queryPTMoneyL.setText("");
		_model.queryPT_EPriceL.setText("");
		_model.queryPTEnrollDayL.setText("");
		_model.queryPTStartDayL.setText("");
		_model.queryPTLastDayL.setText("");
		_model.queryPTNoteL.setText("");
		
		_model.PTMDayT.setText("");
		_model.PTMHeightT.setText("");
		_model.PTMWeightT.setText("");
		_model.PTMBodyFatT.setText("");
		_model.PTMMuscleT.setText("");
		_model.PTMExerciseT.setText("");
		_model.PTMImproveT.setText("");
		
		_model.queryPTMDayL.setText("");
		_model.queryPTMNumL.setText("");
		_model.queryPTMHeightL.setText("");
		_model.queryPTMWeightL.setText("");
		_model.queryPTMBodyFatL.setText("");
		_model.queryPTMMuscleL.setText("");
		_model.queryPTMExerciseL.setText("");
		_model.queryPTMImproveL.setText("");
		
		_model.LNumT.setText("");
		_model.L_M_NumT.setText("");
		_model.L_GP_NumT.setText("");
		_model.LCountT.setText("");
		_model.LMoneyT.setText("");
		_model.L_EPriceT.setText("");
		_model.LEnrollDayT.setText("");
		_model.LStartDayT.setText("");
		_model.LLastDayT.setText("");
		_model.LNoteT.setText("");

		_model.queryLNumL.setText("");
		_model.queryL_M_NumL.setText("");
		_model.queryL_GP_NumL.setText("");
		_model.queryLCountL.setText("");
		_model.queryLMoneyL.setText("");
		_model.queryL_EPriceL.setText("");
		_model.queryLEnrollDayL.setText("");
		_model.queryLStartDayL.setText("");
		_model.queryLLastDayL.setText("");
		_model.queryLNoteL.setText("");
		
		_model.LMDayT.setText("");
		_model.LMDistanceT.setText("");
		_model.LMBallSpeedT.setText("");
		_model.LMExerciseT.setText("");
		_model.LMImproveT.setText("");
		
		_model.queryLMDayL.setText("");
		_model.queryLMNumL.setText("");
		_model.queryLMDistanceL.setText("");
		_model.queryLMBallSpeedL.setText("");
		_model.queryLMExerciseL.setText("");
		_model.queryLMImproveL.setText("");
	}
	
	public void ProfitALLCLEAR(){
		_model.salesEnrollMonthT.setText("");
		_model.salesEnrollCafeT.setText("");
	}
}
