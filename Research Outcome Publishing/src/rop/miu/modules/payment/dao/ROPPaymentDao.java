package rop.miu.modules.payment.dao;

import rop.miu.beans.BaoAccessCoupon;
import rop.miu.beans.BaoCouponType;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.exceptions.ROPDaoException;

public class ROPPaymentDao {
	
	public void saveBaoCouponType(BaoCouponType couponType) throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(couponType);
	}
	
	public void saveBaoAccessCoupon(BaoAccessCoupon accessCoupon) throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(accessCoupon);
	}
	
	public void updateStatusOnBaoCouponType (short status, BaoCouponType couponType) throws ROPDaoException {
		String sql = "UPDATE BaoCouponType c set c.couponTypeState=? WHERE c.couponTypeId=?";
		ROPCrudDao.executeInsUpdDelCreQuery(sql, status, couponType.getCouponTypeId());
	}
	
	public void updateStatusOnBaoAccessCoupon (short status, BaoAccessCoupon accessCoupon) throws ROPDaoException {
		String sql = "UPDATE BaoAccessCoupon c set c.accessCouponState=? WHERE c.accessCouponId=?";
		ROPCrudDao.executeInsUpdDelCreQuery(sql, status, accessCoupon.getAccessCouponId());
	}
}
