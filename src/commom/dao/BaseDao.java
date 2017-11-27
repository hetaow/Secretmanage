package commom.dao;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
public class BaseDao {
	private static String driver="com.mysql.jdbc.Driver";  
	private static String url="jdbc:mysql://localhost:3306/secretmanage";   //�û�
	private static String user="root";	//�˺�
	private static String pwd="system";		//����
	
	public Connection conn=null;  		//�������ݿ�
	public ResultSet rs=null;			//��ѯ�����
	public PreparedStatement pstmt=null;
	/*
	static
	{
		init();
	}
	public static void init()
	{
		//����Properties����
		Properties params=new Properties();
		String confiles="database.properties";
		//�����
		InputStream input=BaseDao.class.getClassLoader().getResourceAsStream(confiles);
		try
		{
			//���������
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
	 * �������ݿ�
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
	 * �ر����ݿ�
	 * @param conn �������ݿ�
	 * @param ptmt ����PreparedStatement
	 * @param rs  //�����
	 */
	public void colseAll(Connection conn,PreparedStatement ptmt,ResultSet rs)
	{
		try
		{
			if(rs !=null)
			{
				//�رս��������
				rs.close();
			}
			if(ptmt !=null)
			{
				//�ر�PreparedStatement����
				ptmt.close();
			}if(conn !=null)
			{
				//�ر����ݿ�����
				conn.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	/**
	 * ִ����,ɾ,�Ĳ���
	 * @param sql 
	 * @param obje
	 * @return 
	 * 
	 */
	public int  exceuteUpdate(String sql,Object[] obje)
	{
		int count=0;
		//����PreparedStatement����
		try
		{
			//����������
			conn=this.getConnection();
			pstmt=conn.prepareStatement(sql);
			//�ж��Ƿ�Ϊ��
			if(obje !=null)
			{
				//����ѭ��
				for (int i = 0; i < obje.length; i++) {
					//ѭ�����
					pstmt.setObject(i+1,obje[i]);
				}
			}
			//ѭ������ ��ִ��sql���
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
	 * ��ѯ�����
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
