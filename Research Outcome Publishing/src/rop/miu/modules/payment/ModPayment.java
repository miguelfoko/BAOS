package rop.miu.modules.payment;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.modules.ServletModel;
import rop.miu.util.IncludeManager;

public class ModPayment extends ServletModel {
	private static final long serialVersionUID = 1L;
       
  
    public ModPayment() {
        super();
       
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		IncludeManager inclManager = getIncludeManager(request);
		String option = null;
		try{
			String parOpt = request.getParameter("o");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
		}
		if(option == null || option.equals("do-pay") || request.getSession().getAttribute("payment_access_coupon") != null){
			request.getSession().removeAttribute("payment_access_coupon");
			if(isConnected(request))
				setIncludesForPayment(request);
			else
				requestAuthentication(request, response, "payment");
			returnRequest(request, response);
			return;
		}
	}

	private void setIncludesForPayment(HttpServletRequest request) throws ServletException, IOException {
		IncludeManager inclManager = getIncludeManager(request);
    	inclManager.setTitle(request, languageManager.getLanguageValue("payment_title", getLangTag(request)));
		inclManager.addJSP(request, "/modules/payment/payment.jsp");
		inclManager.addCSS(request, "/modules/payment/css/style.css");
	}
	
	private void setIncludesForPaymentStatus(HttpServletRequest request) throws ServletException, IOException {
		IncludeManager inclManager = getIncludeManager(request);
    	inclManager.setTitle(request, languageManager.getLanguageValue("payment_status_title", getLangTag(request)));
		inclManager.addJSP(request, "/modules/payment/payment_status.jsp");
		inclManager.addCSS(request, "/modules/payment/css/style.css");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		IncludeManager inclManager = getIncludeManager(request);
		String option = null;
		try{
			String parOpt = request.getParameter("o");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
		}
		
		if(option == null || option.equals("do-pay") || request.getSession().getAttribute("payment_access_coupon") != null){
			request.getSession().removeAttribute("payment_access_coupon");
			if(isConnected(request))
				setIncludesForPayment(request);
			else
				requestAuthentication(request, response, "payment");
			returnRequest(request, response);
			return;
		}
		
		if(option != null && option.equals("pay_with_mtn")){
			int idbouton = new Integer(request.getParameter("idbouton"));
			String typebouton = request.getParameter("typebouton");
			int _amount = new Integer(request.getParameter("_amount"));
			int _tel = new Integer(request.getParameter("telNumber"));
			String _email=request.getParameter("_email");

			request.setAttribute("idbouton", idbouton);
			request.setAttribute("typebouton", typebouton);
			request.setAttribute("_amount", _amount);
			request.setAttribute("_tel", _tel);
			request.setAttribute("_email", _email);

			String var="https://developer.mtn.cm/OnlineMomoWeb/faces/transaction/transactionRequest.xhtml?idbouton="+idbouton+"&typebouton="+typebouton+"&_amount="+_amount+"&_tel="+_tel+"&_clP=&_email="+_email;
			URL url = new URL(var);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			DataOutputStream paramsWriter = new DataOutputStream(conn.getOutputStream());
			paramsWriter.flush();
			paramsWriter.close();
			InputStream remoteResponse = conn.getInputStream();
			OutputStream localResponder = new OutputStream() {
				private StringBuilder string = new StringBuilder();
				
				@Override
				public void write(int x) throws IOException {
					this.string.append((char) x );
				}

				public String toString(){
					return this.string.toString();
				}
			};//.getOutputStream.getOutputStream();
			int c;
			while((c = remoteResponse.read()) != -1){
				localResponder.write(c);
			}	
			//			localResponder.close();
			//			remoteResponse.close();
			conn.disconnect();
			request.setAttribute("statusDesc", localResponder.toString());
			request.setAttribute("idiot", "idiot");
			setIncludesForPaymentStatus(request);
			this.returnRequest(request, response);
			return;
		}
	}

}
