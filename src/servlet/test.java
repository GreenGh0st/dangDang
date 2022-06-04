package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class test extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public test() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("֧���ɹ�,�����첽�ص�");
//		//��ȡ֧����POST����������Ϣ
//		Map<String,String> params = new HashMap<String,String>();
//		Map<String,String[]> requestParams = request.getParameterMap();
//		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//			String name = (String) iter.next();
//			String[] values = (String[]) requestParams.get(name);
//			String valueStr = "";
//			for (int i = 0; i < values.length; i++) {
//				valueStr = (i == values.length - 1) ? valueStr + values[i]
//						: valueStr + values[i] + ",";
//			}
//			//����������δ����ڳ�������ʱʹ��
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//			params.put(name, valueStr);
//		}
//		
//		boolean signVerified=false;
//		try {
//			signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
//		} catch (AlipayApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //����SDK��֤ǩ��
//
//		//�������������д���ĳ������´�������ο�������
//		
//		/* ʵ����֤���̽����̻�����������У�飺
//		1����Ҫ��֤��֪ͨ�����е�out_trade_no�Ƿ�Ϊ�̻�ϵͳ�д����Ķ����ţ�
//		2���ж�total_amount�Ƿ�ȷʵΪ�ö�����ʵ�ʽ����̻���������ʱ�Ľ���
//		3��У��֪ͨ�е�seller_id������seller_email) �Ƿ�Ϊout_trade_no��ʵ��ݵĶ�Ӧ�Ĳ��������е�ʱ��һ���̻������ж��seller_id/seller_email��
//		4����֤app_id�Ƿ�Ϊ���̻�����
//		*/
//		if(signVerified) {//��֤�ɹ�
//			//�̻�������
//			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//		
//			//֧�������׺�
//			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
//		
//			//����״̬
//			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
//			
//			if(trade_status.equals("TRADE_FINISHED")){
//				//�жϸñʶ����Ƿ����̻���վ���Ѿ���������
//				//���û�������������ݶ����ţ�out_trade_no�����̻���վ�Ķ���ϵͳ�в鵽�ñʶ�������ϸ����ִ���̻���ҵ�����
//				//���������������ִ���̻���ҵ�����
//				//ע�⣺
//				//�˿����ڳ������˿����޺��������¿��˿��֧����ϵͳ���͸ý���״̬֪ͨ
//				System.out.println("TRADE_FINISHED");
//			}else if (trade_status.equals("TRADE_SUCCESS")){
//				//�жϸñʶ����Ƿ����̻���վ���Ѿ���������
//				//���û�������������ݶ����ţ�out_trade_no�����̻���վ�Ķ���ϵͳ�в鵽�ñʶ�������ϸ����ִ���̻���ҵ�����
//				//���������������ִ���̻���ҵ�����
//				
//				//ע�⣺
//				//������ɺ�֧����ϵͳ���͸ý���״̬֪ͨ
//				System.out.println("TRADE_SUCCESS");
//			}
//			
//			out.println("success");
//			
//		}else {//��֤ʧ��
//			out.println("fail");
//		
//			//�����ã�д�ı�������¼������������Ƿ�����
//			//String sWord = AlipaySignature.getSignCheckContentV1(params);
//			//AlipayConfig.logResult(sWord);
//		}
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
