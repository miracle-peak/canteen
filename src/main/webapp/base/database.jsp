<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<%!public Connection getConn()throws Exception{
    Connection conn=null;
   try{
         String db_url="jdbc:mysql://127.0.0.1:3306/leavemanage?&useSSL=false";
		   String db_user="root";
		   String db_pwd="123456";
		   Class.forName("com.mysql.jdbc.Driver");
		  //2.2:DriverManager获得Connection 类型的连接对象conn
		    conn=DriverManager.getConnection(db_url, db_user, db_pwd);
		    return conn;
    }catch(Exception e){
      throw e;
    }
   
   }

  public void close(ResultSet rs,Statement stmt,Connection conn)throws SQLException{
    try{
      if(rs!=null){
     stmt.close();
  }
    if(stmt!=null){
     stmt.close();
  }
   if(conn!=null){
     conn.close();
  }
    }catch(SQLException e){
      throw e;
    }
  }
  
   public void close(Statement stmt,Connection conn)throws SQLException{
       close(null, stmt, conn);
   }
   
  public void close(ResultSet rs)throws SQLException{
       close(rs, null, null);
   }
    public void close(Statement stmt)throws SQLException{
       close(null, stmt, null);
   }
   public void close(Connection conn)throws SQLException{
       close(null, null, conn);
   }
  %>

