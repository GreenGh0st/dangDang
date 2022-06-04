package servlet;

import Dao.FoodInfoDao;
import entity.FoodInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SaveUploadFile extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -2828206102350165653L;

	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        String headimg=request.getParameter("FoodsImg");
        System.out.println("SaveUploadFile!!!");
 
        System.out.println(headimg);
 
        //�����ͼ�������Ƿ���post��ʽ���Ƿ��Ƕ���������ʽ
        Boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return; //������ǾͲ����ϴ���
        }
 
        try {
 
            //����FileItemFactory����
            FileItemFactory factory=new DiskFileItemFactory();
            //�����ļ��ϴ��Ĵ�����
            ServletFileUpload upload=new ServletFileUpload(factory);
            //��������
            List<FileItem> items=upload.parseRequest(request);
            //������ÿһ��FileItem
            FoodInfo foods = new FoodInfo();
            FoodInfoDao fc = new FoodInfoDao();	
            ArrayList<String> strArray = new ArrayList<String> ();
            String RandomName = null;
            for (FileItem item : items) {
                  String fileName = item.getFieldName();
                if (item.isFormField()) {
                    //��ͨ�ı��ؼ�
                    String value = item.getString("utf-8");
                    System.out.println(fileName + "->" + value);
                    strArray.add(value);                
                } else {
                    //�ϴ��ļ��Ŀؼ�
                   // String RandomName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(item.getName());
                    RandomName = item.getName();
                    System.out.println(fileName + "->" + FilenameUtils.getName(item.getName())); //һ���ı�ǩ��name��һ�����ļ���name
                    String path=request.getServletContext().getRealPath("/upload");
                    System.out.println(path);
                    System.out.println(RandomName);
                    item.write(new File(path, RandomName)); //���ϴ����ļ����浽ĳ���ļ���
                    System.out.println(item.getName());
                    }
            	}
            
            for (String tmp : strArray) {
    			System.out.println(tmp);
    		}
            
            int foodID =Integer.parseInt(strArray.get(0));
    		String foodName = strArray.get(2);
    		String remark = strArray.get(2);
    		String foodAddr = strArray.get(3);
    		double foodPrice = Double.parseDouble(strArray.get(5));
    		String description = strArray.get(6);
    		String foodImage = "upload\\" + RandomName;
    		int foodCount =Integer.parseInt(strArray.get(4));
    		int foodtyid =Integer.parseInt(strArray.get(1));
    		
    		foods.setFoodID(foodID);
    		foods.setFoodName(foodName);
    		foods.setRemark(remark);
    		foods.setFoodAddr(foodAddr);
    		foods.setFoodPrice(foodPrice);
    		foods.setDescription(description);
    		foods.setFoodImage(foodImage);
    		foods.setFoodCount(foodCount);
    		foods.setSortID(foodtyid);

    		 int res =fc.addFood(foods);
    		 PrintWriter out = response.getWriter();	
				if(res>0){
    				out.print("<script>alert('�޸ĳɹ���');window.location.href='../admin/foods/foods_Manage.jsp';</script>");
    			}else{
    				out.print("<script>alert('�޸�ʧ�ܣ�');window.history.back();</script>");
    			}
              
            }
 
            catch (Exception e) {
                e.printStackTrace();
            }
      
       
    }
}