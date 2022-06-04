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
 * 获取验证码
 */
public class SendSmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//短信平台相关参数
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
	 * 短信平台使用的是榛子云短信(smsow.zhenzikj.com)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String mobile = request.getParameter("phone");
			System.out.println("手机号："+mobile);
			JSONObject json = null;
			//生成6位验证码
			String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
			System.out.println("验证码："+verifyCode);
			
			//发送短信
			ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
			Map<String, Object> params = new HashMap<String, Object>();
		    params.put("number", mobile);
		    params.put("templateId", 591);
		    String[] templateParams = new String[2];
		    templateParams[0] = verifyCode;
		    templateParams[1] = "120分钟";
		    params.put("templateParams", templateParams);
		    String result = client.send(params);
			json = JSONObject.parseObject(result);
			
			System.out.println("result："+result);
			System.out.println("json："+json);
			if(json.getIntValue("code") != 0){//发送短信失败
				System.out.print("错误提示:"+json.getString("data"));
				renderData(response, "获取失败:"+json.getString("data"));
				return; 
			}
			//将验证码存到session中,同时存入创建时间
			//以json存放，这里使用的是阿里的fastjson
			HttpSession session = request.getSession();
			json = new JSONObject();
			json.put("mobile", mobile);
			json.put("verifyCode", verifyCode);
			json.put("createTime", System.currentTimeMillis());
			// 将认证码存入SESSION
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
			response.getWriter().close();  //这里就是关键
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

