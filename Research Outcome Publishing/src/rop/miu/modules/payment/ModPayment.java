package rop.miu.modules.payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoAccessCoupon;
import rop.miu.beans.BaoUser;
import rop.miu.modules.ServletModel;
import rop.miu.modules.payment.dao.ROPPaymentDao;
import rop.miu.util.IncludeManager;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.exceptions.ROPCryptographyException;
import rop.miu.util.exceptions.ROPDaoException;

public class ModPayment extends ServletModel {
	private static final long serialVersionUID = 1L;
       
  
    public ModPayment() {
        super();
       
    }

	
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
		
		if(option == null || option.equals("do-pay") || request.getAttribute("payment_access_coupon") != null){
			if(isConnected(request))
				setIncludesForPayment(request);
			else
				requestAuthentication(request, response, "payment");
			returnRequest(request, response);
			return;
		}
	}

}
