package servlet;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ��ȡ��֤��
 */
public class SendSmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//����ƽ̨��ز���
	private String apiUrl = "https://sms_developer.zhenzikj.com";
	private String appId = "106044";
	private String appSecret = "5e1a9a1f-a5ba-4999-87d4-1bb527c8c43b";
       
    public SendSmsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ����ƽ̨ʹ�õ�������ƶ���(smsow.zhenzikj.com)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String mobile = request.getParameter("phone");
			System.out.println("�ֻ��ţ�"+mobile);
			JSONObject json = null;
			//����6λ��֤��
			String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
			System.out.println("��֤�룺"+verifyCode);
			
			//���Ͷ���
			ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
			Map<String, Object> params = new HashMap<String, Object>();
		    params.put("number", mobile);
		    params.put("templateId", 591);
		    String[] templateParams = new String[2];
		    templateParams[0] = verifyCode;
		    templateParams[1] = "120����";
		    params.put("templateParams", templateParams);
		    String result = client.send(params);
			json = JSONObject.parseObject(result);
			
			System.out.println("result��"+result);
			System.out.println("json��"+json);
			if(json.getIntValue("code") != 0){//���Ͷ���ʧ��
				System.out.print("������ʾ:"+json.getString("data"));
				renderData(response, "��ȡʧ��:"+json.getString("data"));
				return; 
			}
			//����֤��浽session��,ͬʱ���봴��ʱ��
			//��json��ţ�����ʹ�õ��ǰ����fastjson
			HttpSession session = request.getSession();
			json = new JSONObject();
			json.put("mobile", mobile);
			json.put("verifyCode", verifyCode);
			json.put("createTime", System.currentTimeMillis());
			// ����֤�����SESSION
			request.getSession().setAttribute("verifyCode", json);
			renderData(response, "success");
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		renderData(response, "fail");
	}
	
	protected void renderData(HttpServletResponse response, String data){
		try {
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().print(data);
			response.getWriter().flush();
			response.getWriter().close();  //������ǹؼ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

