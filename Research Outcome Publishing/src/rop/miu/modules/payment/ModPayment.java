package rop.miu.modules.payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoAccessCoupon;
import rop.miu.beans.BaoUser;
import rop.miu.modules.ServletModel;
import rop.miu.modules.payment.dao.ROPPaymentDao;
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		ROPEncryptor encryptor = new ROPEncryptor();
    	String action="";
    	ROPPaymentDao dao = new ROPPaymentDao();
    	if(request.getParameter("a") != null){
    		try {
	    		action = encryptor.decrypt(request.getParameter("a"));
	    	} catch (ROPCryptographyException e) {
				
			}
    		if (action.equalsIgnoreCase("")) {
    			BaoUser user = (BaoUser)request.getSession();
    			BaoAccessCoupon accessCoupon = new BaoAccessCoupon();
    			accessCoupon.setAccessCouponState((short)0);
    			//accessCoupon.setAccessCouponValidityEnd(request.getParameter(""));
    			accessCoupon.setUserId(user);
    			try {
					dao.saveBaoAccessCoupon(accessCoupon);
					//Envoyer le coupon en session et faire le retour de la requete
					includeManager.addJSP(request, "/modules/payment/payment.jsp");
					returnRequest(request, response);
				} catch (ROPDaoException e) {
				}
    		}
    		if (action.equalsIgnoreCase("")) {
    			BaoAccessCoupon accessCoupon = (BaoAccessCoupon)request.getSession();
    			accessCoupon.setAccessCouponState(Short.parseShort(request.getParameter("")));
    			try {
					dao.updateStatusOnBaoAccessCoupon(accessCoupon.getAccessCouponState(), accessCoupon);
					includeManager.addJSP(request, "/modules/payment/payment.jsp");
					returnRequest(request, response);
				} catch (ROPDaoException e) {
				}
    		}
    	}
	}

}
