package Database.design.build;


public class Control {
	Pannel pannel;
	Model model;
	customerDB cDB;
	trainerDB tDB;
	golfProDB gpDB;
	ptDB ptDB;
	ptMDB ptmDB;
	LessonDB lDB;
	LessonMDB lmDB;
	salesMonthDB smDB;
	salesCafeDB scDB;
	salesPTDB spDB;
	salesLessonDB slDB;
	
	public Control(){
		model = new Model();
		pannel = new Pannel(this, model);
		tDB = new trainerDB(model, pannel);
		cDB = new customerDB(model, pannel);
		gpDB = new golfProDB(model, pannel);
		ptDB = new ptDB(model, pannel);
		ptmDB = new ptMDB(model, pannel);
		lDB = new LessonDB(model, pannel);
		lmDB = new LessonMDB(model, pannel);
		smDB = new salesMonthDB(model, pannel);
		scDB = new salesCafeDB(model, pannel);
		spDB = new salesPTDB(model, pannel);
		slDB = new salesLessonDB(model, pannel);
	}
	
	//시작 메인화면 보여줌
	public void start(){
		pannel.Login();
		//pannel.createMain();
	}
	
	public void setDBCustomer(){
		cDB.setDB();
	}
	
	public void getDBCustomer(String combo){
		cDB.getDB(combo);
	}
	
	public void setCustomerDBQuery(int count){
		model.setCustomerQueryData(count);
	}
	
	public void setCustomerDBCheck(){
		cDB.checkDB();
	}
	
	public void setCustomerDBUpdate(){
		cDB.updateDB();
	}
	
	public void setDBTrainer(){
		tDB.setDB();
	}
	
	public void getDBTrainer(String combo){
		tDB.getDB(combo);
	}
	
	public void setTrainerDBQuery(int count){
		model.setTrainerQueryData(count);
	}
	
	public void setTrainerDBCheck(){
		tDB.checkDB();
	}
	
	public void setDBGolfpro(){
		gpDB.setDB();
	}
	
	public void getDBGolfpro(String combo){
		gpDB.getDB(combo);
	}
	
	public void setGolfProDBQuery(int count){
		model.setGolfProQueryData(count);
	}
	
	public void setGolfProDBCheck(){
		gpDB.checkDB();
	}
	
	public void setDBPT(){
		ptDB.setDB();
	}
	
	public void getDBPT(String combo){
		ptDB.getDB(combo);
	}
	
	public void setPTDBQuery(int count){
		model.setPTQueryData(count);
	}
	
	public void setPTDBCheck(){
		ptDB.checkDB();
	}
	
	public void setDBPTM(){
		ptmDB.setDB();
	}
	
	public void getDBPTM(String combo){
		ptmDB.getDB(combo);
	}
	
	public void setPTMDBQuery(int count){
		model.setPTMQueryData(count);
	}
	
	
	public void setDBLesson(){
		lDB.setDB();
	}
	
	public void getDBLesson(String combo){
		lDB.getDB(combo);
	}
	
	public void setLessonDBQuery(int count){
		model.setLessonQueryData(count);
	}
	
	public void setLessonDBCheck(){
		lDB.checkDB();
	}
	
	public void setDBLessonM(){
		lmDB.setDB();
	}
	
	public void getDBLessonM(String combo){
		lmDB.getDB(combo);
	}
	
	public void setLessonMDBQuery(int count){
		model.setLessonMQueryData(count);
	}
	
	
	public void setDBSalesMonth(){
		smDB.setDB();
	}
	public void getDBSalesMonth(){
		smDB.getDB();
	}
	
	public void setDBSalesCafe(){
		scDB.setDB();
	}
	public void getDBSalesCafe(){
		scDB.getDB();
	}
	
	public void getDBSalesPT(){
		spDB.getDB();
	}
	
	public void getDBSalesLesson(){
		slDB.getDB();
	}
	
}
