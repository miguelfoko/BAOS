<div class="row">
	<div class="col-md-12">
		<fieldset class="row">
			<legend><c:out value="${applicationScope.languageManager.getLanguageValue('pay_choose_solution', sessionScope.tag)}" /></legend>
			<div class="row">
				<div class="col-md-3">
					<div class="col-md-12">
						<button data-toggle="modal" href="#paySolutionBox" class="btn btn-sm btn-success" title="<c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_to_box', sessionScope.tag)}" />"><span class="glyphicon glyphicon-hand-right"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_to_box', sessionScope.tag)}" /></button>
					</div>
					<div id="paySolutionBox" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">x</button>
									<h4 class="modal-title"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_referee', sessionScope.tag)}" /></h4>
								</div>
								<div class="modal-body">
									<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('edit_excluded_referee')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subEditRefereeForm<c:out value="${referee.refereeId}" />" class="form">
										
									</form>
								</div>
								<div class="modal-footer" style="clear:both;">
									<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_referee', sessionScope.tag)}" />" class="auth_button btn btn-success" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="col-md-12">
						<button data-toggle="modal" href="#paySolutionMTN" class="btn btn-sm btn-success" title="<c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_with_mtn', sessionScope.tag)}" />"><span class="glyphicon glyphicon-transfer"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_with_mtn', sessionScope.tag)}" /></button>
					</div>
					<div id="paySolutionMTN" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">x</button>
									<h4 class="modal-title"><c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_with_mtn', sessionScope.tag)}" /></h4>
								</div>
								<div class="modal-body">
									<form id="formmomo" target="_top" method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('payment')}" />&o=${applicationScope.encryptor.encrypt('pay_with_mtn')}" class="form">
										<input type="hidden" name="o" value="1">
										<input type="hidden" name="idbouton" value="2" autocomplete="off">
										<input type="hidden" name="typebouton" value="PAIE" autocomplete="off">
										<input class="momo mount" type="hidden" placeholder="" name="_amount" value="500" id="montant" autocomplete="off">
									    <input class="momo pwd" placeholder="" name="_clP" value="" autocomplete="off" type="hidden">
										<input type="hidden" name="_email" value="miguelfoko@gmail.com" autocomplete="off">
										<div id="form-tel-group" class="form-group">
											<label class="auth_label control-label" for="telNumber"><c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_with_mtn_tel_number', sessionScope.tag)}" /><span class="required">*</span></label>
											<input type="text" name="telNumber" id="telNumber" autocomplete="off" value="<c:out value="${param.telNumber}" />" required class="auth_text_zone form-control momo host" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_with_mtn_tel_number_holder', sessionScope.tag)}" />" />
											<span class="help-block" id="telNumberError"></span>
											<input type="hidden" id="paySolutionMTNTelNumberError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_with_mtn_tel_number_error', sessionScope.tag)}" />" />
										</div>
									    <input type="image" id="Button_Image" src="https://developer.mtn.cm/OnlineMomoWeb/console/uses/itg_img/buttons/MOMO_buy_now_VF.jpg" border="1" name="submit" alt="" height="100" width="200" autocomplete="off">      
								    	<div class="form-group pull-right" style="clear:both;">
											<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pay_pay_now_with_mtn', sessionScope.tag)}" />" class="auth_button btn btn-success" />
										</div>
								    </form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</fieldset>
	</div>
</div>