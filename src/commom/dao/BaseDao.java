package commom.dao;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
public class BaseDao {
	private static String driver="com.mysql.jdbc.Driver";  
	private static String url="jdbc:mysql://localhost:3306/secretmanage";   //用户
	private static String user="root";	//账号
	private static String pwd="system";		//密码
	
	public Connection conn=null;  		//连接数据库
	public ResultSet rs=null;			//查询结果集
	public PreparedStatement pstmt=null;
	/*
	static
	{
		init();
	}
	public static void init()
	{
		//创建Properties对象
		Properties params=new Properties();
		String confiles="database.properties";
		//输出流
		InputStream input=BaseDao.class.getClassLoader().getResourceAsStream(confiles);
		try
		{
			//加载输出流
			params.load(input);
			driver=params.getProperty("driver");
			url=params.getProperty("url");
			user=params.getProperty("user");
			pwd=params.getProperty("password");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 连接数据库
	 * @return
	 */
	public Connection getConnection()
	{
		try{
		if(conn ==null){
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pwd);
		}else if(conn.isClosed() == true){
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pwd);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库
	 * @param conn 连接数据库
	 * @param ptmt 连接PreparedStatement
	 * @param rs  //结果集
	 */
	public void colseAll(Connection conn,PreparedStatement ptmt,ResultSet rs)
	{
		try
		{
			if(rs !=null)
			{
				//关闭结果集连接
				rs.close();
			}
			if(ptmt !=null)
			{
				//关闭PreparedStatement连接
				ptmt.close();
			}if(conn !=null)
			{
				//关闭数据库连接
				conn.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	/**
	 * 执行增,删,改操作
	 * @param sql 
	 * @param obje
	 * @return 
	 * 
	 */
	public int  exceuteUpdate(String sql,Object[] obje)
	{
		int count=0;
		//创建PreparedStatement对象
		try
		{
			//打开数据连接
			conn=this.getConnection();
			pstmt=conn.prepareStatement(sql);
			//判断是否为空
			if(obje !=null)
			{
				//遍历循环
				for (int i = 0; i < obje.length; i++) {
					//循环输出
					pstmt.setObject(i+1,obje[i]);
				}
			}
			//循环出后 在执行sql语句
			count=pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			this.colseAll(conn, pstmt, rs);
		}
		return count;
	}
	/**
	 * 查询结果集
	 * @param sql
	 * @param objPara
	 * @return
	 */
	public ResultSet executeFind(String sql,Object[] objPara)
	{
		PreparedStatement pstmt=null;
		try
		{
			conn=this.getConnection();
			pstmt=conn.prepareStatement(sql);
			if(objPara !=null)
			{
				for (int i = 0; i < objPara.length; i++) {
					pstmt.setObject(i+1, objPara[i]);
				}
			}
			rs=pstmt.executeQuery();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
