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
 
        //解析和检查请求，是否是post方式，是否是二进制流格式
        Boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return; //如果不是就不用上传了
        }
 
        try {
 
            //创建FileItemFactory对象
            FileItemFactory factory=new DiskFileItemFactory();
            //创建文件上传的处理器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //解析请求
            List<FileItem> items=upload.parseRequest(request);
            //迭代出每一个FileItem
            FoodInfo foods = new FoodInfo();
            FoodInfoDao fc = new FoodInfoDao();	
            ArrayList<String> strArray = new ArrayList<String> ();
            String RandomName = null;
            for (FileItem item : items) {
                  String fileName = item.getFieldName();
                if (item.isFormField()) {
                    //普通的表单控件
                    String value = item.getString("utf-8");
                    System.out.println(fileName + "->" + value);
                    strArray.add(value);                
                } else {
                    //上传文件的控件
                   // String RandomName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(item.getName());
                    RandomName = item.getName();
                    System.out.println(fileName + "->" + FilenameUtils.getName(item.getName())); //一个的标签的name，一个是文件的name
                    String path=request.getServletContext().getRealPath("/upload");
                    System.out.println(path);
                    System.out.println(RandomName);
                    item.write(new File(path, RandomName)); //把上传的文件保存到某个文件中
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
    				out.print("<script>alert('修改成功！');window.location.href='../admin/foods/foods_Manage.jsp';</script>");
    			}else{
    				out.print("<script>alert('修改失败！');window.history.back();</script>");
    			}
              
            }
 
            catch (Exception e) {
                e.printStackTrace();
            }
      
       
    }
}