package Database.design.build;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Model{
	int Count = 0;		//DB에서 몇개의 행을 가져왔는지
	
	Model(){
				for(int i = 0; i < 100; i++){
			customerNumL_DB[i] = new JLabel();
			customerGenderL_DB [i] = new JLabel();
			customerNameL_DB [i] = new JLabel();
			customerBirthL_DB [i] = new JLabel();
			customerPhoneL_DB [i] = new JLabel();
			customerPathL_DB [i] = new JLabel();
			customerAddrL_DB [i] = new JLabel();
			customerEliteL_DB [i] = new JLabel();
			customerFirstDayL_DB [i] = new JLabel();
			customerLastDayL_DB [i] = new JLabel();
			customerNoteL_DB [i] = new JLabel();
			
			trainerNickL_DB[i] = new JLabel();
			trainerGenderL_DB[i] = new JLabel();
			trainerNameL_DB[i] = new JLabel();
			trainerBirthL_DB[i] = new JLabel();
			trainerPhoneL_DB[i] = new JLabel();
			trainerLicenseL_DB[i] = new JLabel();
			trainerAddrL_DB[i] = new JLabel();
			
			golfProNumL_DB[i] = new JLabel();
			golfProGenderL_DB[i] = new JLabel();
			golfProNameL_DB[i] = new JLabel();
			golfProBirthL_DB[i] = new JLabel();
			golfProPhoneL_DB[i] = new JLabel();
			golfProLicenseL_DB[i] = new JLabel();
			golfProAddrL_DB[i] = new JLabel();
			
			PTNumL_DB[i] = new JLabel();
			PT_M_NumL_DB[i] = new JLabel();
			PT_T_NickL_DB[i] = new JLabel();
			PTCountL_DB[i] = new JLabel();
			PTMoneyL_DB[i] = new JLabel();
			PT_EPriceL_DB[i] = new JLabel();
			PTEnrollDayL_DB[i] = new JLabel();
			PTStartDayL_DB[i] = new JLabel();
			PTLastDayL_DB[i] = new JLabel();
			PTNoteL_DB[i] = new JLabel();
			
			LNumL_DB[i] = new JLabel();
			L_M_NumL_DB[i] = new JLabel();
			L_GP_NumL_DB[i] = new JLabel();
			LCountL_DB[i] = new JLabel();
			LMoneyL_DB[i] = new JLabel();
			L_EPriceL_DB[i] = new JLabel();
			LEnrollDayL_DB[i] = new JLabel();
			LStartDayL_DB[i] = new JLabel();
			LLastDayL_DB[i] = new JLabel();
			LNoteL_DB[i] = new JLabel();
			
			PTMDayL_DB[i] = new JLabel();
			PTMNumL_DB[i] = new JLabel();
			PTMHeightL_DB[i] = new JLabel();
			PTMWeightL_DB[i] = new JLabel();
			PTMBodyFatL_DB[i] = new JLabel();
			PTMMuscleL_DB[i] = new JLabel();
			PTMExerciseL_DB[i] = new JLabel();
			PTMImproveL_DB[i] = new JLabel();
			
			LMDayL_DB[i] = new JLabel();
			LMNumL_DB[i] = new JLabel();
			LMDistanceL_DB[i] = new JLabel();
			LMBallSpeedL_DB[i] = new JLabel();
			LMExerciseL_DB[i] = new JLabel();
			LMImproveL_DB[i] = new JLabel();
			
			SalesMDateL_DB[i] = new JLabel();
			SalesMNameL_DB[i] = new JLabel();
			SalesMAmountL_DB[i] = new JLabel();
			SalesMPriceL_DB[i] = new JLabel();
			SalesMAllPriceL_DB[i] = new JLabel();
			
			SalesCDateL_DB[i] = new JLabel();
			SalesCNameL_DB[i] = new JLabel();
			SalesCAmountL_DB[i] = new JLabel();
			SalesCPriceL_DB[i] = new JLabel();
			SalesCAllPriceL_DB[i] = new JLabel();
			
			SalesPDateL_DB[i] = new JLabel();
			SalesPNameL_DB[i] = new JLabel();
			SalesPAmountL_DB[i] = new JLabel();
			SalesPPriceL_DB[i] = new JLabel();
			SalesPAllPriceL_DB[i] = new JLabel();
			
			SalesLDateL_DB[i] = new JLabel();
			SalesLNameL_DB[i] = new JLabel();
			SalesLAmountL_DB[i] = new JLabel();
			SalesLPriceL_DB[i] = new JLabel();
			SalesLAllPriceL_DB[i] = new JLabel();
		}
		
	}
	//회원 버튼 정의
	JButton customerEnroll = new JButton("회원 등록");
	JButton customerQuery = new JButton("회원 조회");
	JButton healthTrainerEnroll = new JButton("트레이너 등록");
	JButton healthTrainerQuery = new JButton("트레이너 조회");
	JButton golfProEnroll = new JButton("골프프로 등록");
	JButton golfProQuery = new JButton("골프프로 조회");
	JButton EliteCustomerEnroll = new JButton("우수회원 등록");
	
	//틀 레이블 정의
	JLabel FirstLabel =new JLabel();
	JLabel SecondLabel =new JLabel();
	JLabel ThirdLabel =new JLabel();
	JLabel FourthLabel =new JLabel();
	JLabel FifthLabel =new JLabel();
	JLabel SixthLabel =new JLabel();
	
	//회원 레이블 & 텍스트 & 버튼 정의
	JLabel customerNumL = new JLabel("회원 번호 : ");
	JLabel customerGenderL = new JLabel("성별 : ");
	JLabel customerNameL = new JLabel("이름 : ");
	JLabel customerBirthL = new JLabel("생년월일 : ");
	JLabel customerPhoneL = new JLabel("전화번호 : ");
	JLabel customerPathL = new JLabel("방문경로 : ");
	JLabel customerAddrL = new JLabel("주소 : ");
	JLabel customerFirstDayL = new JLabel("시작일 : ");
	JLabel customerLastDayL = new JLabel("종료일 : ");
	
	//회원 등록
	JTextArea customerNumT = new JTextArea("1001");
	JRadioButton customerGenderT[] = new JRadioButton[2];
	JTextArea customerNameT = new JTextArea();
	JTextArea customerBirthT = new JTextArea();
	JTextArea customerPhoneT = new JTextArea();
	JComboBox customerPathT = new JComboBox();
	JTextArea customerAddrT = new JTextArea();
	JTextArea customerFirstDayT = new JTextArea();
	JTextArea customerLastDayT = new JTextArea();	
	String customerGender;
	JButton customerOverlapTest = new JButton("중복검사");
	JButton customerEnrollBtn = new JButton("등록");
	//회원 조회
	JComboBox customerInfoCombo = new JComboBox();
	JTextArea customerInfoComboT = new JTextArea();
	JLabel queryCustomerNumL = new JLabel("");
	JLabel queryCustomerGenderL = new JLabel("");
	JLabel queryCustomerNameL = new JLabel("");
	JLabel queryCustomerBirthL = new JLabel("");
	JLabel queryCustomerPhoneL = new JLabel("");
	JLabel queryCustomerPathL = new JLabel("");
	JLabel queryCustomerAddrL = new JLabel("");
	JLabel queryCustomerEliteL = new JLabel("");
	JLabel queryCustomerFirstDayL = new JLabel("");
	JLabel queryCustomerLastDayL = new JLabel("");
	JLabel queryCustomerNoteL = new JLabel("");
	String cnum;
	
	JLabel customerNumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel customerGenderL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerNameL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerBirthL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerPhoneL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerPathL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerAddrL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerEliteL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerFirstDayL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerLastDayL_DB [] = new JLabel[100];//= new JLabel("");
	JLabel customerNoteL_DB [] = new JLabel[100];//= new JLabel("");//;
	JButton customerQueryBtn = new JButton("조회");
	
	Object[][] CustomerData = new Object[100][11];
	String[] customerColNames = {"회원 번호",
			"회원 이름",
            "생년월일",
            "회원 성별",
            "전화번호",
            "주소",
            "방문 경로",
            "우수 회원",
            "시작일",
            "종료일",
            "비고"};
	
	public void setCustomerQueryData(int count){
		queryCustomerNumL.setText(customerNumL_DB[count].getText());
		queryCustomerGenderL.setText(customerGenderL_DB[count].getText());
		queryCustomerNameL.setText(customerNameL_DB[count].getText());
		queryCustomerBirthL.setText(customerBirthL_DB[count].getText());
		queryCustomerPhoneL.setText(customerPhoneL_DB[count].getText());
		queryCustomerPathL.setText(customerPathL_DB[count].getText());
		queryCustomerAddrL.setText(customerAddrL_DB[count].getText());
		queryCustomerEliteL.setText(customerEliteL_DB[count].getText());
		queryCustomerFirstDayL.setText(customerFirstDayL_DB[count].getText());
		queryCustomerLastDayL.setText(customerLastDayL_DB[count].getText());
		queryCustomerNoteL.setText(customerNoteL_DB[count].getText());
	}
	
	public void setDBCustomer(Integer cNum, String cGender,String cName, String cBirth, String cPhone,
			String cPath, String cAddr, String cElite, String cFirstDay, String cLastDay, String cNote, int count){
		customerNumL_DB[count].setText(cNum.toString());
//		customerNumL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerGenderL_DB[count].setText(cGender);
//		customerGenderL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerNameL_DB[count].setText(cName);
//		customerNameL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerBirthL_DB[count].setText(cBirth);
//		customerBirthL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerPhoneL_DB[count].setText(cPhone);
//		customerPhoneL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerPathL_DB[count].setText(cPath);
//		customerPathL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerAddrL_DB[count].setText(cAddr);
//		customerAddrL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerEliteL_DB[count].setText(cElite);
//		customerEliteL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerFirstDayL_DB[count].setText(cFirstDay);
//		customerFirstDayL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerLastDayL_DB[count].setText(cLastDay);
//		customerLastDayL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		customerNoteL_DB[count].setText(cNote);
//		customerNoteL_DB[count].setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void setDBCustomerALL(){
		for(int i = 0; i < Count; i++){
			CustomerData[i][0] = customerNumL_DB[i].getText();
			CustomerData[i][1] = customerNameL_DB[i].getText();
			CustomerData[i][2] = customerBirthL_DB[i].getText();
			CustomerData[i][3] = customerGenderL_DB[i].getText();
			CustomerData[i][4] = customerPhoneL_DB[i].getText();
			CustomerData[i][5] = customerAddrL_DB[i].getText();
			CustomerData[i][6] = customerPathL_DB[i].getText();
			CustomerData[i][7] = customerEliteL_DB[i].getText();
			CustomerData[i][8] = customerFirstDayL_DB[i].getText();
			CustomerData[i][9] = customerLastDayL_DB[i].getText();
			CustomerData[i][10] = customerNoteL_DB[i].getText();
		}
	}
	
	//트레이너 레이블 & 텍스트 & 버튼 정의
	JLabel trainerNickL = new JLabel("닉네임 : ");
	JLabel trainerGenderL = new JLabel("성별 : ");
	JLabel trainerNameL = new JLabel("이름 : ");
	JLabel trainerBirthL = new JLabel("생년월일 : ");
	JLabel trainerPhoneL = new JLabel("전화번호 : ");
	JLabel trainerLicenseL = new JLabel("자격증 : ");
	JLabel trainerAddrL = new JLabel("주소 : ");
	//트레이너 등록
	JTextArea trainerNickT = new JTextArea();
	JRadioButton trainerGenderT[] = new JRadioButton[2];
	JTextArea trainerNameT = new JTextArea();
	JTextArea trainerBirthT = new JTextArea();
	JTextArea trainerPhoneT = new JTextArea();
	JTextArea trainerLicenseT = new JTextArea();
	JTextArea trainerAddrT = new JTextArea();
	String trainerGender;
	JButton trainerOverlapTest = new JButton("중복검사");
	JButton trainerEnrollBtn = new JButton("등록");
	//트레이너 조회
	JComboBox trainerInfoCombo = new JComboBox();
	JTextArea trainerInfoComboT = new JTextArea();
	JLabel queryTrainerNickL = new JLabel("");
	JLabel queryTrainerGenderL = new JLabel("");
	JLabel queryTrainerNameL = new JLabel("");
	JLabel queryTrainerBirthL = new JLabel("");
	JLabel queryTrainerPhoneL = new JLabel("");
	JLabel queryTrainerLicenseL = new JLabel("");
	JLabel queryTrainerAddrL = new JLabel("");
	String tnick;
	
	JLabel trainerNickL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel trainerGenderL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel trainerNameL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel trainerBirthL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel trainerPhoneL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel trainerLicenseL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel trainerAddrL_DB[] = new JLabel[100]; //= new JLabel("");
	JButton trainerQueryBtn = new JButton("조회");
	
	Object[][] TrainerData = new Object[100][7];
	String[] trainerColNames = {"닉네임",
			"트레이너 이름",
            "생년월일",
            "트레이너 성별",
            "전화번호",
            "주소",
            "자격증"};
	
	
	public void setTrainerQueryData(int count){
		queryTrainerNickL.setText(trainerNickL_DB[count].getText());
		queryTrainerGenderL.setText(trainerGenderL_DB[count].getText());
		queryTrainerNameL.setText(trainerNameL_DB[count].getText());
		queryTrainerBirthL.setText(trainerBirthL_DB[count].getText());
		queryTrainerPhoneL.setText(trainerPhoneL_DB[count].getText());
		queryTrainerLicenseL.setText(trainerLicenseL_DB[count].getText());
		queryTrainerAddrL.setText(trainerAddrL_DB[count].getText());
	}
	
	public void setDBTrainer(String tNick, String tName,String tBirth, String tGender, String tPhone,
			String tAddr, String tLicense, int count){
		trainerNickL_DB[count].setText(tNick);
//		trainerNickL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		trainerGenderL_DB[count].setText(tGender);
//		trainerGenderL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		trainerNameL_DB[count].setText(tName);
//		trainerNameL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		trainerBirthL_DB[count].setText(tBirth);
//		trainerBirthL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		trainerPhoneL_DB[count].setText(tPhone);
//		trainerPhoneL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		trainerLicenseL_DB[count].setText(tLicense);
//		trainerLicenseL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		trainerAddrL_DB[count].setText(tAddr);
//		trainerAddrL_DB[count].setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void setDBTrainerALL(){
		for(int i = 0; i < Count; i++){
			TrainerData[i][0] = trainerNickL_DB[i].getText();
			TrainerData[i][1] = trainerNameL_DB[i].getText();
			TrainerData[i][2] = trainerBirthL_DB[i].getText();
			TrainerData[i][3] = trainerGenderL_DB[i].getText();
			TrainerData[i][4] = trainerPhoneL_DB[i].getText();
			TrainerData[i][5] = trainerAddrL_DB[i].getText();
			TrainerData[i][6] = trainerLicenseL_DB[i].getText();
		}
	}
	
	//골프 프로 레이블 & 텍스트 & 버튼 정의
	JLabel golfProNumL = new JLabel("프로 번호 : ");
	JLabel golfProGenderL = new JLabel("성별 : ");
	JLabel golfProNameL = new JLabel("이름 : ");
	JLabel golfProBirthL = new JLabel("생년월일 : ");
	JLabel golfProPhoneL = new JLabel("전화번호 : ");
	JLabel golfProLicenseL = new JLabel("자격증 : ");
	JLabel golfProAddrL = new JLabel("주소 : ");
	//골프 프로 등록
	JTextArea golfProNumT = new JTextArea("9001");
	JRadioButton golfProGenderT[] = new JRadioButton[2];
	JTextArea golfProNameT = new JTextArea();
	JTextArea golfProBirthT = new JTextArea();
	JTextArea golfProPhoneT = new JTextArea();
	JTextArea golfProLicenseT = new JTextArea();
	JTextArea golfProAddrT = new JTextArea();
	String golfProGender;
	JButton golfProOverlapTest = new JButton("중복검사");
	JButton golfProEnrollBtn = new JButton("등록");
	//골프 프로 조회
	JComboBox golfProInfoCombo = new JComboBox();
	JTextArea golfProInfoComboT = new JTextArea();
	JLabel queryGolfProNumL = new JLabel("");
	JLabel queryGolfProGenderL = new JLabel("");
	JLabel queryGolfProNameL = new JLabel("");
	JLabel queryGolfProBirthL = new JLabel("");
	JLabel queryGolfProPhoneL = new JLabel("");
	JLabel queryGolfProAddrL = new JLabel("");
	JLabel queryGolfProLicenseL = new JLabel("");
	String gpnum;
	
	JLabel golfProNumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel golfProGenderL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel golfProNameL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel golfProBirthL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel golfProPhoneL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel golfProLicenseL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel golfProAddrL_DB[] = new JLabel[100]; //= new JLabel("");
	JButton golfProQueryBtn = new JButton("조회");
	
	Object[][] GolfProData = new Object[100][7];
	String[] golfProColNames = {"골프프로 번호",
			"골프프로 이름",
            "생년월일",
            "골프프로 성별",
            "전화번호",
            "주소",
            "자격증"};
	
	public void setGolfProQueryData(int count){
		queryGolfProNumL.setText(golfProNumL_DB[count].getText());
		queryGolfProGenderL.setText(golfProGenderL_DB[count].getText());
		queryGolfProNameL.setText(golfProNameL_DB[count].getText());
		queryGolfProBirthL.setText(golfProBirthL_DB[count].getText());
		queryGolfProPhoneL.setText(golfProPhoneL_DB[count].getText());
		queryGolfProAddrL.setText(golfProAddrL_DB[count].getText());
		queryGolfProLicenseL.setText(golfProLicenseL_DB[count].getText());
	}
	
	public void setDBGolfPro(String gpNick, String gpName,String gpBirth, String gpGender, String gpPhone,
			String gpAddr, String gpLicense, int count){
		golfProNumL_DB[count].setText(gpNick);
//		golfNumL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		golfProGenderL_DB[count].setText(gpGender);
//		golfGenderL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		golfProNameL_DB[count].setText(gpName);
//		golfNameL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		golfProBirthL_DB[count].setText(gpBirth);
//		golfBirthL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		golfProPhoneL_DB[count].setText(gpPhone);
//		golfPhoneL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		golfProLicenseL_DB[count].setText(gpLicense);
//		golfLicenseL_DB[count].setHorizontalAlignment(JLabel.CENTER);
		golfProAddrL_DB[count].setText(gpAddr);
//		golfAddrL_DB[count].setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void setDBGolfProALL(){
		for(int i = 0; i < Count; i++){
			GolfProData[i][0] = golfProNumL_DB[i].getText();
			GolfProData[i][1] = golfProNameL_DB[i].getText();
			GolfProData[i][2] = golfProBirthL_DB[i].getText();
			GolfProData[i][3] = golfProGenderL_DB[i].getText();
			GolfProData[i][4] = golfProPhoneL_DB[i].getText();
			GolfProData[i][5] = golfProAddrL_DB[i].getText();
			GolfProData[i][6] = golfProLicenseL_DB[i].getText();
		}
	}
	
	JButton EliteQBtn = new JButton("회원 조회");
	JLabel EliteL =new JLabel("회원번호 :");
	JTextArea EliteT = new JTextArea();
	JButton EliteEBtn = new JButton("등록");
	
//----------------------------------------------------------------------
	
	//lesson 버튼 정의
	JButton PTEnroll = new JButton("PT 등록");
	JButton PTQuery = new JButton("PT 조회");
	JButton PTManage = new JButton("PT 관리");
	JButton PTManageQuery = new JButton("PT 관리조회");
	JButton LessonEnroll = new JButton("Lesson 등록");
	JButton LessonQuery = new JButton("Lesson 조회");
	JButton LessonManage = new JButton("Lesson 관리");
	JButton LessonManageQuery = new JButton("Lesson 관리조회");
	
	//틀 레이블 정의
	JLabel PTFirstL =new JLabel();
	JLabel PTSecondL =new JLabel();
	JLabel PTThirdL =new JLabel();
	JLabel PTFourthL =new JLabel();
	JLabel PTFifthL =new JLabel();
	JLabel PTSixthL =new JLabel();
	
	//PT 등록 레이블
	JLabel PTNumL = new JLabel("PT 번호 :");
	JLabel PT_M_NumL = new JLabel("회원번호 :");
	JLabel PT_T_NickL = new JLabel("트레이너 :");
	JLabel PTCountL = new JLabel("횟수 :");
	JLabel PTMoneyL = new JLabel("단가 :");
	JLabel PT_EPriceL = new JLabel("총 금액 :");
	JLabel PTEnrollDayL = new JLabel("등록일 :");
	JLabel PTStartDayL = new JLabel("시작일 :");
	JLabel PTLastDayL = new JLabel("종료일 :");
	JLabel PTNoteL = new JLabel("비고");
	
	//PT 등록
	JTextArea PTNumT = new JTextArea();
	JTextArea PT_M_NumT = new JTextArea();
	JTextArea PT_T_NickT = new JTextArea();
	JTextArea PTCountT = new JTextArea();
	JTextArea PTMoneyT = new JTextArea();
	JTextArea PT_EPriceT = new JTextArea();
	JTextArea PTEnrollDayT = new JTextArea();
	JTextArea PTStartDayT = new JTextArea();
	JTextArea PTLastDayT = new JTextArea();
	JTextArea PTNoteT = new JTextArea();
	JButton PTEnrollBtn = new JButton("등록");
	
	//PT 조회
	JComboBox PTInfoCombo = new JComboBox();
	JTextArea PTInfoComboT = new JTextArea();
	JLabel queryPTNumL = new JLabel("");
	JLabel queryPT_M_NumL = new JLabel("");
	JLabel queryPT_T_NickL = new JLabel("");
	JLabel queryPTCountL = new JLabel("");
	JLabel queryPTMoneyL = new JLabel("");
	JLabel queryPT_EPriceL = new JLabel("");
	JLabel queryPTEnrollDayL = new JLabel("");
	JLabel queryPTStartDayL = new JLabel("");
	JLabel queryPTLastDayL = new JLabel("");
	JLabel queryPTNoteL = new JLabel("");
	String ptnick, ptcnum;
	
	JLabel PTNumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PT_M_NumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PT_T_NickL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTCountL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMoneyL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PT_EPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTEnrollDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTStartDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTLastDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTNoteL_DB[] = new JLabel[100]; //= new JLabel("");
	JButton PTQueryBtn = new JButton("조회");
	
	Object[][] PTData = new Object[100][10];
	String[] PTColNames = {"PT 번호",
			"회원 번호",
            "트레이너 닉네임",
            "PT 횟수",
            "PT 단가",
            "PT 총 금액",
            "PT 등록일",
            "PT 시작일",
            "PT 종료일",
            "비고",};
	
	public void setPTQueryData(int count){
		queryPTNumL.setText(PTNumL_DB[count].getText());
		queryPT_M_NumL.setText(PT_M_NumL_DB[count].getText());
		queryPT_T_NickL.setText(PT_T_NickL_DB[count].getText());
		queryPTCountL.setText(PTCountL_DB[count].getText());
		queryPTMoneyL.setText(PTMoneyL_DB[count].getText());
		queryPT_EPriceL.setText(PT_EPriceL_DB[count].getText());
		queryPTEnrollDayL.setText(PTEnrollDayL_DB[count].getText());
		queryPTStartDayL.setText(PTStartDayL_DB[count].getText());
		queryPTLastDayL.setText(PTLastDayL_DB[count].getText());
		queryPTNoteL.setText(PTNoteL_DB[count].getText());
	}
	
	public void setDBPT(Integer pNum, Integer p_m_Num, String p_t_Nick, Integer pCount, String pMoney,
			String p_EPrice, String pEDay, String pSDay, String pLDay, String pNote, int count){
		PTNumL_DB[count].setText(pNum.toString());
		PT_M_NumL_DB[count].setText(p_m_Num.toString());
		PT_T_NickL_DB[count].setText(p_t_Nick);
		PTCountL_DB[count].setText(pCount.toString()+" 회");
		PTMoneyL_DB[count].setText(pMoney+" 원");
		PT_EPriceL_DB[count].setText(p_EPrice+" 원");
		PTEnrollDayL_DB[count].setText(pEDay);
		PTStartDayL_DB[count].setText(pSDay);
		PTLastDayL_DB[count].setText(pLDay);
		PTNoteL_DB[count].setText(pNote);
	}
	
	public void setDBPTALL(){
		for(int i = 0; i < Count; i++){
			PTData[i][0] = PTNumL_DB[i].getText();
			PTData[i][1] = PT_M_NumL_DB[i].getText();
			PTData[i][2] = PT_T_NickL_DB[i].getText();
			PTData[i][3] = PTCountL_DB[i].getText();
			PTData[i][4] = PTMoneyL_DB[i].getText();
			PTData[i][5] = PT_EPriceL_DB[i].getText();
			PTData[i][6] = PTEnrollDayL_DB[i].getText();
			PTData[i][7] = PTStartDayL_DB[i].getText();
			PTData[i][8] = PTLastDayL_DB[i].getText();
			PTData[i][9] = PTNoteL_DB[i].getText();
		}
	}
	
	//PT 관리 레이블
	JLabel PTMDayL = new JLabel("PT 일자 :");
	//PT 번호
	JLabel PTMHeightL = new JLabel("키 :");
	JLabel PTMWeightL = new JLabel("몸무게 :");
	JLabel PTMBodyFatL = new JLabel("체지방 :");
	JLabel PTMMuscleL = new JLabel("근육량 :");
	JLabel PTMExerciseL = new JLabel("운동능력 :");
	JLabel PTMImproveL = new JLabel("개선점 :");
	
	//PT 관리
	JTextArea PTMDayT = new JTextArea();
	//PT 번호
	JTextArea PTMHeightT = new JTextArea();
	JTextArea PTMWeightT = new JTextArea();
	JTextArea PTMBodyFatT = new JTextArea();
	JTextArea PTMMuscleT = new JTextArea();
	JTextArea PTMExerciseT = new JTextArea();
	JTextArea PTMImproveT = new JTextArea();
	JButton PTMEnrollBtn = new JButton("등록");
	
	//PT 관리 조회
	JComboBox PTMInfoCombo = new JComboBox();
	JTextArea PTMInfoComboT = new JTextArea();
	JLabel queryPTMDayL = new JLabel("");
	JLabel queryPTMNumL = new JLabel("");
	JLabel queryPTMHeightL = new JLabel("");
	JLabel queryPTMWeightL = new JLabel("");
	JLabel queryPTMBodyFatL = new JLabel("");
	JLabel queryPTMMuscleL = new JLabel("");
	JLabel queryPTMExerciseL = new JLabel("");
	JLabel queryPTMImproveL = new JLabel("");
	String ptmnum;
	
	JLabel PTMDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMNumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMHeightL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMWeightL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMBodyFatL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMMuscleL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMExerciseL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel PTMImproveL_DB[] = new JLabel[100]; //= new JLabel("");
	JButton PTMQueryBtn = new JButton("조회");
	
	Object[][] PTMData = new Object[100][8];
	String[] PTMColNames = {"PT 일자",
			"PT 번호",
            "키",
            "체중",
            "체지방",
            "근육 량",
            "PT 운동수행능력",
            "개선점",};
	
	public void setPTMQueryData(int count){
		queryPTMDayL.setText(PTMDayL_DB[count].getText());
		queryPTMNumL.setText(PTMNumL_DB[count].getText());
		queryPTMHeightL.setText(PTMHeightL_DB[count].getText());
		queryPTMWeightL.setText(PTMWeightL_DB[count].getText());
		queryPTMBodyFatL.setText(PTMBodyFatL_DB[count].getText());
		queryPTMMuscleL.setText(PTMMuscleL_DB[count].getText());
		queryPTMExerciseL.setText(PTMExerciseL_DB[count].getText());
		queryPTMImproveL.setText(PTMImproveL_DB[count].getText());
	}
	
	public void setDBPTM(String pmDay, Integer pmNum, Integer pmHeight, Integer pmWeight, Integer pmBodyfat,
			Integer pmMuscle, String pmExercise, String pmImprove, int count){
		PTMDayL_DB[count].setText(pmDay);
		PTMNumL_DB[count].setText(pmNum.toString());
		PTMHeightL_DB[count].setText(pmHeight.toString()+" cm");
		PTMWeightL_DB[count].setText(pmWeight.toString()+" kg");
		PTMBodyFatL_DB[count].setText(pmBodyfat.toString()+" %");
		PTMMuscleL_DB[count].setText(pmMuscle.toString()+" %");
		PTMExerciseL_DB[count].setText(pmExercise);
		PTMImproveL_DB[count].setText(pmImprove);
	}
	
	public void setDBPTMALL(){
		for(int i = 0; i < Count; i++){
			PTMData[i][0] = PTMDayL_DB[i].getText();
			PTMData[i][1] = PTMNumL_DB[i].getText();
			PTMData[i][2] = PTMHeightL_DB[i].getText();
			PTMData[i][3] = PTMWeightL_DB[i].getText();
			PTMData[i][4] = PTMBodyFatL_DB[i].getText();
			PTMData[i][5] = PTMMuscleL_DB[i].getText();
			PTMData[i][6] = PTMExerciseL_DB[i].getText();
			PTMData[i][7] = PTMImproveL_DB[i].getText();
		}
	}
	
	
	//Lesson 등록 레이블
	JLabel LNumL = new JLabel("레슨번호 :");
	JLabel L_M_NumL = new JLabel("회원번호 :");
	JLabel L_GP_NumL = new JLabel("프로번호 :");
	JLabel LCountL = new JLabel("횟수 :");
	JLabel LMoneyL = new JLabel("단가 :");
	JLabel L_EPriceL = new JLabel("총 금액 :");
	JLabel LEnrollDayL = new JLabel("등록일 :");
	JLabel LStartDayL = new JLabel("시작일 :");
	JLabel LLastDayL = new JLabel("종료일 :");
	JLabel LNoteL = new JLabel("비고");
	
	//Lesson 등록
	JTextArea LNumT = new JTextArea();
	JTextArea L_M_NumT = new JTextArea();
	JTextArea L_GP_NumT = new JTextArea();
	JTextArea LCountT = new JTextArea();
	JTextArea LMoneyT = new JTextArea();
	JTextArea L_EPriceT = new JTextArea();
	JTextArea LEnrollDayT = new JTextArea();
	JTextArea LStartDayT = new JTextArea();
	JTextArea LLastDayT = new JTextArea();
	JTextArea LNoteT = new JTextArea();
	JButton LessonEnrollBtn = new JButton("등록");
	
	//Lesson 조회
	JComboBox LessonInfoCombo = new JComboBox();
	JTextArea LessonInfoComboT = new JTextArea();
	JLabel queryLNumL = new JLabel("");
	JLabel queryL_M_NumL = new JLabel("");
	JLabel queryL_GP_NumL = new JLabel("");
	JLabel queryLCountL = new JLabel("");
	JLabel queryLMoneyL = new JLabel("");
	JLabel queryL_EPriceL = new JLabel("");
	JLabel queryLEnrollDayL = new JLabel("");
	JLabel queryLStartDayL = new JLabel("");
	JLabel queryLLastDayL = new JLabel("");
	JLabel queryLNoteL = new JLabel("");
	String lgnum, lcnum;
	
	JLabel LNumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel L_M_NumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel L_GP_NumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LCountL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LMoneyL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel L_EPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LEnrollDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LStartDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LLastDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LNoteL_DB[] = new JLabel[100]; //= new JLabel("");
	JButton LessonQueryBtn = new JButton("조회");
	
	Object[][] LessonData = new Object[100][10];
	String[] LessonColNames = {"Lesson 번호",
			"회원 번호",
            "골프프로 번호",
            "Lesson 횟수",
            "Lesson 단가",
            "Lesson 총 금액",
            "Lesson 등록일",
            "Lesson 시작일",
            "Lesson 종료일",
            "비고",};
	
	public void setLessonQueryData(int count){
		queryLNumL.setText(LNumL_DB[count].getText());
		queryL_M_NumL.setText(L_M_NumL_DB[count].getText());
		queryL_GP_NumL.setText(L_GP_NumL_DB[count].getText());
		queryLCountL.setText(LCountL_DB[count].getText());
		queryLMoneyL.setText(LMoneyL_DB[count].getText());
		queryL_EPriceL.setText(L_EPriceL_DB[count].getText());
		queryLEnrollDayL.setText(LEnrollDayL_DB[count].getText());
		queryLStartDayL.setText(LStartDayL_DB[count].getText());
		queryLLastDayL.setText(LLastDayL_DB[count].getText());
		queryLNoteL.setText(LNoteL_DB[count].getText());
	}
	
	public void setDBLesson(Integer lNum, Integer l_gp_Num,String l_m_Num, Integer lCount, String lMoney,
			String l_EPrice, String lEDay, String lSDay, String lLDay, String lNote, int count){
		LNumL_DB[count].setText(lNum.toString());
		L_M_NumL_DB[count].setText(l_gp_Num.toString());
		L_GP_NumL_DB[count].setText(l_m_Num);
		LCountL_DB[count].setText(lCount.toString()+" 회");
		LMoneyL_DB[count].setText(lMoney+" 원");
		L_EPriceL_DB[count].setText(l_EPrice+" 원");
		LEnrollDayL_DB[count].setText(lEDay);
		LStartDayL_DB[count].setText(lSDay);
		LLastDayL_DB[count].setText(lLDay);
		LNoteL_DB[count].setText(lNote);
	}
	
	public void setDBLessonALL(){
		for(int i = 0; i < Count; i++){
			LessonData[i][0] = LNumL_DB[i].getText();
			LessonData[i][1] = L_M_NumL_DB[i].getText();
			LessonData[i][2] = L_GP_NumL_DB[i].getText();
			LessonData[i][3] = LCountL_DB[i].getText();
			LessonData[i][4] = LMoneyL_DB[i].getText();
			LessonData[i][5] = L_EPriceL_DB[i].getText();
			LessonData[i][6] = LEnrollDayL_DB[i].getText();
			LessonData[i][7] = LStartDayL_DB[i].getText();
			LessonData[i][8] = LLastDayL_DB[i].getText();
			LessonData[i][9] = LNoteL_DB[i].getText();
		}
	}
	
	//Lesson 관리 레이블
	JLabel LMDayL = new JLabel("레슨일자 :");
	//Lesson 번호
	JLabel LMDistanceL = new JLabel("비거리 :");
	JLabel LMBallSpeedL = new JLabel("볼 속도 :");
	JLabel LMExerciseL = new JLabel("운동능력 :");
	JLabel LMImproveL = new JLabel("개선점 :");
	
	//Lesson 관리
	JTextArea LMDayT = new JTextArea();
	//Lesson 번호
	JTextArea LMDistanceT = new JTextArea();
	JTextArea LMBallSpeedT = new JTextArea();
	JTextArea LMExerciseT = new JTextArea();
	JTextArea LMImproveT = new JTextArea();
	JButton LessonMEnrollBtn = new JButton("등록");
	
	//Lesson 관리 조회
	JComboBox LessonMInfoCombo = new JComboBox();
	JTextArea LessonMInfoComboT = new JTextArea();
	JLabel queryLMDayL = new JLabel("");
	JLabel queryLMNumL = new JLabel("");
	JLabel queryLMDistanceL = new JLabel("");
	JLabel queryLMBallSpeedL = new JLabel("");
	JLabel queryLMExerciseL = new JLabel("");
	JLabel queryLMImproveL = new JLabel("");
	String lmnum;
	
	JLabel LMDayL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LMNumL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LMDistanceL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LMBallSpeedL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LMExerciseL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel LMImproveL_DB[] = new JLabel[100]; //= new JLabel("");
	JButton LessonMQueryBtn = new JButton("조회");
	
	Object[][] LessonMData = new Object[100][6];
	String[] LessonMColNames = {"Lesson 일자",
			"Lesson 번호",
            "비거리",
            "볼 속도",
            "Lesson 운동수행능력",
            "개선점",};
	
	public void setLessonMQueryData(int count){
		queryLMDayL.setText(LMDayL_DB[count].getText());
		queryLMNumL.setText(LMNumL_DB[count].getText());
		queryLMDistanceL.setText(LMDistanceL_DB[count].getText());
		queryLMBallSpeedL.setText(LMBallSpeedL_DB[count].getText());
		queryLMExerciseL.setText(LMExerciseL_DB[count].getText());
		queryLMImproveL.setText(LMImproveL_DB[count].getText());
	}
	
	public void setDBLessonM(String lmDay, Integer lmNum, Integer lmDistance, Integer lmBallSpeed,
			String lmExercise, String lmImprove, int count){
		LMDayL_DB[count].setText(lmDay);
		LMNumL_DB[count].setText(lmNum.toString());
		LMDistanceL_DB[count].setText(lmDistance.toString()+" Yd");
		LMBallSpeedL_DB[count].setText(lmBallSpeed.toString()+" m/s");
		LMExerciseL_DB[count].setText(lmExercise);
		LMImproveL_DB[count].setText(lmImprove);
	}
	
	public void setDBLessonMALL(){
		for(int i = 0; i < Count; i++){
			LessonMData[i][0] = LMDayL_DB[i].getText();
			LessonMData[i][1] = LMNumL_DB[i].getText();
			LessonMData[i][2] = LMDistanceL_DB[i].getText();
			LessonMData[i][3] = LMBallSpeedL_DB[i].getText();
			LessonMData[i][4] = LMExerciseL_DB[i].getText();
			LessonMData[i][5] = LMImproveL_DB[i].getText();
		}
	}
	
//----------------------------------------------------------------------
	
	//매출 버튼 정의
	JButton salesEnroll = new JButton("일일 판매 등록");
	JButton salesQuery = new JButton("일일 판매 조회");
	
	//틀 레이블 정의
	JLabel salesFirstL =new JLabel();
	JLabel salesSecondL =new JLabel();
	JLabel salesThirdL =new JLabel();
	JLabel salesFourthL =new JLabel();
	JLabel salesFifthL =new JLabel();
	
	//매출 버튼 정의
	JLabel salesEnrollMonthL = new JLabel("개월 권 : ");
	JComboBox salesEnrollMonthCombo = new JComboBox();
	JTextArea salesEnrollMonthT = new JTextArea();
	JButton salesEnrollMonthBtn = new JButton("입력");
	int salesEnrollMonthAllPrice = 0;
	
	JLabel salesEnrollCafeL = new JLabel("카 페 : ");
	JComboBox salesEnrollCafeCombo = new JComboBox();
	JTextArea salesEnrollCafeT = new JTextArea();
	JButton salesEnrollCafeBtn = new JButton("입력");
	int salesEnrollCafeAllPrice = 0;
	
//	JLabel salesEnrollPTL = new JLabel("P T : ");
//	JComboBox salesEnrollPTCombo = new JComboBox();
//	JTextArea salesEnrollPTT = new JTextArea();
//	JButton salesEnrollPTBtn = new JButton("입력");
//	
//	JLabel salesEnrollLessonL = new JLabel("Lesson : ");
//	JComboBox salesEnrollLessonCombo = new JComboBox();
//	JTextArea salesEnrollLessonT = new JTextArea();
//	JButton salesEnrollLessonBtn = new JButton("입력");
	
	JButton salesQueryMonthBtn = new JButton("개월 권");
	JButton salesQueryCafeBtn = new JButton("카 페");
	JButton salesQueryPTBtn = new JButton("P T");
	JButton salesQueryLessonBtn = new JButton("Lesson");
	
	Object[][] SalesMData = new Object[100][5];
	String[] SalesMColNames = {"날짜",
			"항목",
			"개수",
            "단가",
            "총 금액",};
	
	JLabel SalesMDateL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesMNameL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesMAmountL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesMPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesMAllPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	
	public void setDBSalesM(String smDate, String smName, Integer smAmount,Integer smPrice, Integer smAllPrice, int count){
		SalesMDateL_DB[count].setText(smDate);
		SalesMNameL_DB[count].setText(smName);
		SalesMAmountL_DB[count].setText(smAmount.toString());
		SalesMPriceL_DB[count].setText(smPrice.toString());
		SalesMAllPriceL_DB[count].setText(smAllPrice.toString());
	}
	
	public void setDBSalesMALL(){
		for(int i = 0; i < Count; i++){
			SalesMData[i][0] = SalesMDateL_DB[i].getText();
			SalesMData[i][1] = SalesMNameL_DB[i].getText();
			SalesMData[i][2] = SalesMAmountL_DB[i].getText();
			SalesMData[i][3] = SalesMPriceL_DB[i].getText();
			SalesMData[i][4] = SalesMAllPriceL_DB[i].getText();
		}
	}
	
	Object[][] SalesCData = new Object[100][5];
	String[] SalesCColNames = {"날짜",
			"항목",
			"개수",
            "단가",
            "총 금액",};
	
	JLabel SalesCDateL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesCNameL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesCAmountL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesCPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesCAllPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	
	public void setDBSalesC(String scDate, String scName, Integer scAmount,Integer scPrice, Integer scAllPrice, int count){
		SalesCDateL_DB[count].setText(scDate);
		SalesCNameL_DB[count].setText(scName);
		SalesCAmountL_DB[count].setText(scAmount.toString());
		SalesCPriceL_DB[count].setText(scPrice.toString());
		SalesCAllPriceL_DB[count].setText(scAllPrice.toString());
	}
	
	public void setDBSalesCALL(){
		for(int i = 0; i < Count; i++){
			SalesCData[i][0] = SalesCDateL_DB[i].getText();
			SalesCData[i][1] = SalesCNameL_DB[i].getText();
			SalesCData[i][2] = SalesCAmountL_DB[i].getText();
			SalesCData[i][3] = SalesCPriceL_DB[i].getText();
			SalesCData[i][4] = SalesCAllPriceL_DB[i].getText();
		}
	}
	
	Object[][] SalesPData = new Object[100][5];
	String[] SalesPColNames = {"날짜",
			"항목",
			"PT 횟수",
            "단가",
            "총 금액",};
	
	JLabel SalesPDateL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesPNameL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesPAmountL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesPPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesPAllPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	
	public void setDBSalesP(String spDate, String spNick, Integer spAmount, Integer scPrice, Integer scAllPrice,  int count){
		SalesPDateL_DB[count].setText(spDate);
		SalesPNameL_DB[count].setText(spNick);
		SalesPAmountL_DB[count].setText(spAmount.toString());
		SalesPPriceL_DB[count].setText(scPrice.toString());
		SalesPAllPriceL_DB[count].setText(scAllPrice.toString());
	}
	
	public void setDBSalesPALL(){
		for(int i = 0; i < Count; i++){
			SalesPData[i][0] = SalesPDateL_DB[i].getText();
			SalesPData[i][1] = SalesPNameL_DB[i].getText();
			SalesPData[i][2] = SalesPAmountL_DB[i].getText();
			SalesPData[i][3] = SalesPPriceL_DB[i].getText();
			SalesPData[i][4] = SalesPAllPriceL_DB[i].getText();
		}
	}
	
	Object[][] SalesLData = new Object[100][5];
	String[] SalesLColNames = {"날짜",
			"항목",
			"Lesson 횟수",
            "단가",
            "총 금액",};
	
	JLabel SalesLDateL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesLNameL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesLAmountL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesLPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	JLabel SalesLAllPriceL_DB[] = new JLabel[100]; //= new JLabel("");
	
	public void setDBSalesL(String slDate, String slNick, Integer slAmount, Integer slPrice, Integer slAllPrice,  int count){
		SalesLDateL_DB[count].setText(slDate);
		SalesLNameL_DB[count].setText(slNick);
		SalesLAmountL_DB[count].setText(slAmount.toString());
		SalesLPriceL_DB[count].setText(slPrice.toString());
		SalesLAllPriceL_DB[count].setText(slAllPrice.toString());
	}
	
	public void setDBSalesLALL(){
		for(int i = 0; i < Count; i++){
			SalesLData[i][0] = SalesLDateL_DB[i].getText();
			SalesLData[i][1] = SalesLNameL_DB[i].getText();
			SalesLData[i][2] = SalesLAmountL_DB[i].getText();
			SalesLData[i][3] = SalesLPriceL_DB[i].getText();
			SalesLData[i][4] = SalesLAllPriceL_DB[i].getText();
		}
	}
}
