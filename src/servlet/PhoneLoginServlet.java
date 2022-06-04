package servlet;

import Dao.UserCtrl;
import com.alibaba.fastjson.JSONObject;
import entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ע��
 */
public class PhoneLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PhoneLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mobile = request.getParameter("userName");
		String verifyCode = request.getParameter("userPwd");
		
		UserCtrl uc = new UserCtrl();
		int flag = uc.SelectPhone(mobile);
		
		System.out.println("�ֻ��ţ�"+mobile);
		System.out.println("��֤�룺"+verifyCode);
		request.getSession().setAttribute("phone", mobile);
		JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
		if(json == null){
			renderData(response, "��֤�����");
			return ;
		}
		if(!json.getString("mobile").equals(mobile)){
			renderData(response, "�ֻ��Ŵ���");
			return ;
		}
		if(!json.getString("verifyCode").equals(verifyCode)){
			renderData(response, "��֤�����");
			return ;
		}
		if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
			renderData(response, "��֤���ѹ���");
			return ;
		}
		if(flag == 0) {
			renderData(response, "fail");
			return ;
		}
		//����ҵ�����
		renderData(response, "success");
		UserCtrl ac = new UserCtrl();
		UserInfo ui = ac.PhoneLogin(mobile);
		if(ui!=null){
			HttpSession session =request.getSession();
			session.setAttribute("ui",ui);
		}
	}
	protected void renderData(HttpServletResponse response, String data){
		try {
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(data);
			response.getWriter().flush();
			response.getWriter().close();  //������ǹؼ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
