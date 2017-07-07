package productdeals;

import java.io.*;
import java.sql.*;
import oracle.jdbc.*;


/**
 * PS: Use the SQL script file provided in this folder to create a NEW (slightly different) 
 * version of the ProductDeals database on Oracle and insert data into all tables. The 
 * script also creates an SQL function.
 */
public class Customer implements Serializable {
  /**
   * The following fields correspond to the fields in Table ProductDeals_CUSTOMER in your
   * PRODUCTDEALS Oracle database
   */
  private String customerNumber;
  private String last;
  private String first;
  private String street;
  private String city;
  private String state;
  private String zipCode;
  private double balance;
  private double creditLimit;
  private String slsRepNumber;
  /**
   * The following stores whether or not the customer has successfully logged
   * to the System
   */    
  private boolean loggedIn = false;
  
  /**
   * A getter for class field customerNumber
   * @return the customerNumber
   */
  public String getCustomerNumber() {
    return customerNumber;
  }
  
  /**
   * A setter for class field customerNumber
   * @param customerNumber the customerNumber to set
   */
  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }
  
  /**
   * A getter for class field last
   * @return the last
   */
  public String getLast() {
    return last;
  }
  
  /**
   * A setter for class field last
   * @param last the last to set
   */
  public void setLast(String last) {
    this.last = last;
  }
  
  /**
   * A getter for class field first
   * @return the first
   */
  public String getFirst() {
    return first;
  }
  
  /**
   * A setter for class field first
   * @param first the first to set
   */
  public void setFirst(String first) {
    this.first = first;
  }
  
  /**
   * A getter for class field street
   * @return the street
   */
  public String getStreet() {
    return street;
  }
  
  /**
   * A setter for class field street
   * @param street the street to set
   */
  public void setStreet(String street) {
    this.street = street;
  }
  
  /**
   * A getter for class field city
   * @return the city
   */
  public String getCity() {
    return city;
  }
  
  /**
   * A setter for class field city
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }
  
  /**
   * A getter for class field state
   * @return the state
   */
  public String getState() {
    return state;
  }
  
  /**
   * A setter for class field state
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }
  
  /**
   * A getter for class field zipCode
   * @return the zipCode
   */
  public String getZipCode() {
    return zipCode;
  }
  
  /**
   * A setter for class field zipCode
   * @param zipCode the zipCode to set
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  
  /**
   * A getter for class field balance
   * @return the balance
   */
  public double getBalance() {
    return balance;
  }
  
  /**
   * A setter for class field balance
   * @param balance the balance to set
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  /**
   * A getter for class field creditLimit
   * @return the creditLimit
   */
  public double getCreditLimit() {
    return creditLimit;
  }
  
  /**
   * A setter for class field creditLimit
   * @param creditLimit the creditLimit to set
   */
  public void setCreditLimit(double creditLimit) {
    this.creditLimit = creditLimit;
  }
  
  /**
   * A getter for class field slsRepNumber
   * @return the slsRepNumber
   */
  public String getSlsRepNumber() {
    return slsRepNumber;
  }
  
  /**
   * A setter for class field slsRepNumber 
   * @param slsRepNumber the slsRepNumber to set
   */
  public void setSlsRepNumber(String slsRepNumber) {
    this.slsRepNumber = slsRepNumber;
  }
  
  /**
   * A default constructor ... no need for other constructors
   */
  public Customer() {
  }
  
  /**
   * This method and creates and returns a Connection object to the database. 
   * All other methods that need database access should call this method.
   * @return a Connection object to Oracle
   */
  public Connection openDBConnection() {
    try {
      // Load driver and link to driver manager
      Class.forName("oracle.jdbc.OracleDriver");
      // Create a connection to the specified database
      Connection myConnection = DriverManager.getConnection("jdbc:oracle:thin:@//cscioraclesrv.ad.csbsju.edu:1521/" +
                                                            "csci.cscioraclesrv.ad.csbsju.edu","slin", "900209402");
      return myConnection;
    } catch (Exception E) {
      E.printStackTrace();
    }
    return null;
  }
  
  /**
   * A getter for class field loggedIn
   * @return whether the Customer is logged in or not
   */
  public Boolean isLoggedIn() {
    return this.loggedIn;
  }
  
  /**
   * When called, this method uses a Statement object to query table ProductDeals_CUSTOMER 
   * for the customer whose last name and customer number are stored in class instance
   * fields last and customerNumber, respectively.
   * If a match is found, the method sets loggedIn class field to true and 
   * returns true; otherwise, loggedIn class field is set to false and false is returned 
   * @return true or false based on whether the login information of the customer
   * stored in class fields last and customerNumber exist in Table ProductDeals_CUSTOMER
   */
  public boolean login() {

    try{
      Connection con = openDBConnection();
      String queryString = "SELECT COUNT(*) FROM slin.ProductDeals_CUSTOMER C WHERE C.CUSTOMER_NUMBER ='"
        + this.getCustomerNumber() + "'And C.LAST = '" + this.getLast() + "'";
      Statement stmt = con.createStatement();
      ResultSet result = stmt.executeQuery(queryString);      
      while (result.next()){
        if(result.getInt(1) == 1) this.loggedIn = true;
        else this.loggedIn = false;
      }
      result.close();
      stmt.close();
      
    }catch(SQLException e){
      e.printStackTrace();
    }
    return this.loggedIn;
  }
  
  /**
   * sets loggedIn class field to false
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public void logout() throws IllegalStateException {
    if(! isLoggedIn())
      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
    
    this.loggedIn = false;
  }
  
  /**
   * This method uses a Statement object to query the ProductDeals_CUSTOMER table
   * for the customer whose customer number is stored in class field 
   * customerNumber.
   * @return a ResultSet object containing the record for the matching customer from 
   * the ProductDeals_CUSTOMER table
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public ResultSet getCustomerInfo() throws IllegalStateException{
    if (!isLoggedIn()) 
      throw new IllegalStateException();
    try{
      Connection con = openDBConnection();
      String queryString = "SELECT * FROM slin.ProductDeals_CUSTOMER C WHERE C.CUSTOMER_NUMBER ='"
        + this.getCustomerNumber() + "'";
      Statement stmt = con.createStatement();
      ResultSet result = stmt.executeQuery(queryString);      

//      result.close();
//      stmt.close();
      return result;
      
    }catch(SQLException e){
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * This method uses a PreparedStatement object to update the LAST, FIRST,
   * STREET, CITY,  STATE, and ZIP_CODE table fields in the ProductDeals_CUSTOMER table to the values 
   * in the corresponding class fields (i.e. set table field LAST to the value 
   * of class field last, etc ...) for the customer whose customer number is 
   * stored in class field customerNumber.
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public void editCustomerInfo()  throws IllegalStateException{
    if (!isLoggedIn()) 
      throw new IllegalStateException();
    try{
      Connection con = openDBConnection();
      String queryString = "Update slin.ProductDeals_CUSTOMER C SET C.LAST = ?, C.FIRST = ?, C.STREET = ?, "
        + "C.CITY = ?, C.STATE = ?, C. ZIP_CODE = ? WHERE C.CUSTOMER_NUMBER = ?";
      
      PreparedStatement preparedStmt = con.prepareStatement(queryString);
    
      //Clear all parameters
      preparedStmt.clearParameters();
      //Specify values for all ? in the query string
      preparedStmt.setString(1,getLast());
      preparedStmt.setString(2,getFirst());
      preparedStmt.setString(3,getStreet());
      preparedStmt.setString(4,getCity());
      preparedStmt.setString(5,getState());
      preparedStmt.setString(6,getZipCode());
      preparedStmt.setString(7,getCustomerNumber());
      //Execute the query and save resulting table/relation in the ResultSet object
      //int result = 
      preparedStmt.executeQuery();
      //Loop thru the ResultSet object printing each tuple 
      System.out.println(queryString);
      
    }catch(SQLException e){
      e.printStackTrace();
    }
  }
 
  
  /**
   * This method uses a Statement object to query the ProductDeals_TRANS table
   * for all transactions made by the customer whose customer number is 
   * stored in class field customerNumber.
   * @return a ResultSet containing all transactions made by the customer 
   * whose customer number is stored in class field customerNumber.
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public ResultSet getAllTransactions()  throws IllegalStateException{
    if (!isLoggedIn()) 
      throw new IllegalStateException(); 
    try{
      Connection con = openDBConnection();
      String queryString = "SELECT * FROM slin.ProductDeals_TRANS C WHERE C.CUSTOMER_NUMBER ='"
        + this.getCustomerNumber() + "'";
      Statement stmt = con.createStatement();
      ResultSet result = stmt.executeQuery(queryString);      
      
      return result;
    }catch(SQLException e){
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * This method uses a Statement object to query the ProductDeals_TRANSPART table
   * for all transaction parts that belong to the transaction whose number 
   * is specified as a parameter.
   * @param transNumber the transaction number for which we need all the 
   * transaction parts from table ProductDeals_TRANSPART
   * @return a ResultSet containing all transaction parts that belong to the 
   * transaction whose number is specified as a parameter.
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public ResultSet getTransactionParts(String transNumber) throws IllegalStateException{
    if (!isLoggedIn()) 
      throw new IllegalStateException();
    try{
      Connection con = openDBConnection();
      String queryString = "SELECT * FROM ProductDeals_TRANSPART P WHERE P.TRANS_NUMBER ='" + transNumber +"'";
      Statement stmt = con.createStatement();
      ResultSet result = stmt.executeQuery(queryString);      
      
      return result;
    }catch(SQLException e){
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * This method uses a Statement object to query the ProductDeals_PART table
   * for part that belong to the part whose number is specified as a parameter.
   * @param partNumber the part number for part from table ProductDeals_PART
   * @return a ResultSet containing the part whose number is specified as a parameter.
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public ResultSet getParts(String partNumber) throws IllegalStateException{
    if (!isLoggedIn()) 
      throw new IllegalStateException();
    try{
      Connection con = openDBConnection();
      String queryString = "SELECT * FROM ProductDeals_PART P WHERE P.PART_NUMBER ='" + partNumber +"'";
      Statement stmt = con.createStatement();
      ResultSet result = stmt.executeQuery(queryString);      
      
      return result;
    }catch(SQLException e){
      e.printStackTrace();
    }
    return null;
  }
  
  
  /**
   ***************************************COMPLETE ME***************************************
   * This method uses a PreparedStatement object to call an SQL stored function 
   * Function ProductDeals_getTransVal(transNum varchar) to get the total $ value for
   * a given transaction whose number is specified as a parameter.
   * @param transNumber the transaction number for which we need the total $ value
   * @return the total $ value for the transaction whose number is specified 
   * as a parameter.
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public double getTransactionTotalValue(String transNumber) throws IllegalStateException {
    if (!isLoggedIn()) 
      throw new IllegalStateException();
    try{
      Connection con = openDBConnection();
      String queryString = "select ProductDeals_getTransVal(?) from dual";
      
      PreparedStatement preparedStmt = con.prepareStatement(queryString);
    
     //Clear all parameters
      preparedStmt.clearParameters(); 
      preparedStmt.setString(1,transNumber);
      ResultSet result =  preparedStmt.executeQuery();
      while (result.next())
        return result.getDouble(1);
      System.out.println(queryString);
      
    }catch(SQLException e){
      e.printStackTrace();
    }
    
    return -1;
  }
  
  public static void main(String[] args) throws SQLException{
      Customer cus = new Customer();
      cus.setCustomerNumber("124");
      cus.setLast("Adams");
      cus.login();
      System.out.println(cus.isLoggedIn());
      ResultSet rs = cus.getCustomerInfo();
      if(rs.next()){
        System.out.println(rs.getString("FIRST").equals("Sally"));
        System.out.println(rs.getString("STREET").equals("481 Oak"));            
        System.out.println(rs.getString("CITY").equals("Lansing"));
        System.out.println(rs.getString("STATE").equals("MI"));
        System.out.println(rs.getString("ZIP_CODE").equals("49224"));
        System.out.println(rs.getDouble("BALANCE")==818.75);
        System.out.println(rs.getDouble("CREDIT_LIMIT")==1000.00);
        System.out.println(rs.getString("SLSREP_NUMBER").equals("03"));
      }
  }
}
