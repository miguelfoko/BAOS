<c:if test="${action == 'indexPubli' }">
	<div id="pub_journal_title"><h4><c:out value="${applicationScope.languageManager.getLanguageValue('pub_journal_title', sessionScope.tag)}" /></h4> </div>
	<div id="accordeon">
	
		<c:forEach items="${Attr_journalList}" var="journal" begin="0">
			<h6><a href="#"><c:out value="${journal['journalOrConfName']}"/></a></h6>
				<div>
					<c:out value="${journal['journalOrConfLogo']}"/><br />
					<c:out value="${journal['journalOrConfType']}"/><br />
					<c:out value="${journal['journalOrConfShortDesc']}"/><br />
					<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('articlesOfAJournal')}&id_journal=${journal['journalOrConfId']}">Details</a><br />
				</div>
		</c:forEach>
	</div>
</c:if>

<c:if test="${action == 'submitPaper' }">
	<div id="form">
		<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}" name="paperSubmission" id="registerPaper" class="formPubli" enctype="multipart/form-data">
			
				<fieldset id="listOfJournals" onChange="activateAuthorManagement()">
					<legend>aaaaa</legend>
						<ol id="olPubli">
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_list_of_journal', sessionScope.tag)}" /></label> <select name="journalList" id="listOfJournals">
																							<option value='modPublicationDefaultJournal'><c:out value="${applicationScope.languageManager.getLanguageValue('pub_select_journal', sessionScope.tag)}" /></option>
															  	    						<c:forEach items="${Attr_journalList}" var="journal" begin="0">
															  	     							<option value='<c:out value="${journal['journalOrConfName']}"/>'> <c:out value="${journal['journalOrConfName']}"/></option>
															  	    						</c:forEach>
															  							</select></li> 
						</ol>
				</fieldset>
				
				<fieldset id="authorManagement">
					<legend ><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_management', sessionScope.tag)}" /></legend>
						<ol id="olPubli">
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name', sessionScope.tag)}" /></label><input type="text"  name="AuthorName"/></li> 
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution', sessionScope.tag)}" /></label><input type="text"  name="AuthorInstitution" /></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail', sessionScope.tag)}" /></label><input type="email"  name="Authormail" /></li>
							<!--  <li id="liPubli"><label id="labelPubli">Select if it is the com... author</label></li> -->
							<li id="liPubli"><button type=submit class="authorManagement"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_another_author', sessionScope.tag)}" /></button></li>
						</ol>
				</fieldset>
				
				<fieldset id="guideForAuthors">
					<legend><c:out value="${applicationScope.languageManager.getLanguageValue('pub_gide_for_authors', sessionScope.tag)}" /></legend>
						<ol id="olPubli">
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_confirm', sessionScope.tag)}" /></label></li> 
						</ol>
				</fieldset>
				
				
				<fieldset id="suggestReviewer">
					<legend><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_suggest_reviewer', sessionScope.tag)}" /></legend>
						<ol id="olPubli">
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_rev_first_name', sessionScope.tag)}" /></label><input type="text"  name="reviewer1Name" /></li> 
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_rev_last_name', sessionScope.tag)}" /></label><input type="text"  name="reviewer1LastName" /></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_rev_academic_degree', sessionScope.tag)}" /></label><input type="email"  name="reviewer1AcademicDegree" /></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_rev_institution', sessionScope.tag)}" /></label><input type="email"  name="reviewer1Institution" /></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_rev_email', sessionScope.tag)}" /></label><input type="email"  name="reviewer1Email" /></li>
							<!--  <li><input type="hidden" value="<c:out value="${applicationScope.encryptor.encrypt('publications')}"/>" id="modEncryptedName" /></li>-->
							<!--<li><input type="hidden" value="<c:out value="${applicationScope.encryptor.encrypt('paperSubmission')}"/>" id="actionEncryptedName" /></li>-->
							<li id="liPubli"><button type=submit class="reviewerManagement"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_reviewer', sessionScope.tag)}" /></button></li> 
						</ol>
				</fieldset>
				<fieldset id="requestEditor">
					<legend><c:out value="${applicationScope.languageManager.getLanguageValue('pub_request_editor', sessionScope.tag)}" /></legend>
						<ol id="olPubli">
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_choose_editor', sessionScope.tag)}" /></label></li> 
						</ol>
				</fieldset>
				
				<fieldset id="paperInformations">
					<legend><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_informations', sessionScope.tag)}" /></legend>
					<ol id="olPubli">
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_highlight', sessionScope.tag)}" /></label><textarea id="textareaPubli" name="paperHightlight" rows="2" cols="80" ></textarea></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_title', sessionScope.tag)}" /></label><textarea id="textareaPubli" name="paperTitle" rows="2" cols="80" ></textarea></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_abstract', sessionScope.tag)}" /></label><textarea id="textareaPubli" name="abstract" rows="2" cols="80" ></textarea> </li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_keywords', sessionScope.tag)}" /></label><textarea id="textareaPubli" name="keywords" rows="2" cols="80" tabindex="40"></textarea> </li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_pdf_file', sessionScope.tag)}" /></label><input id="inputPubli" type="file" name="attachments" /></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_latex_file', sessionScope.tag)}" /></label><input id="inputPubli" type="file" name="latexFile" value="Upload File"/></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_bibliography_file', sessionScope.tag)}" /></label><input id="inputPubli" type="file" name="biblioFile" /></li>
							<li id="liPubli"><label id="labelPubli"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_other_mentions', sessionScope.tag)}" /></label><textarea id="textareaPubli" name="otherMentions" rows="2" cols="80" tabindex="40"></textarea></li>
													
							<li id="liPubli"><input id="inputPubli" type="hidden" name="volumeID" value="<c:out value="${volume_ID}" />" /></li>
							<li id="liPubli"><button type=submit ><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_submit_paper', sessionScope.tag)}" /></button></li>
					</ol>
			</fieldset>
		
		</form>
	</div>
</c:if>


<c:if test="${action == 'printvolumes' }">
	<c:forEach items="${ATTR_volumeList}" var="volume" begin="0">
		<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&id_volume=${volume['volumeOrIssueId']}"><c:out value="${volume['volumeOrIssueIdentifier']}"/></a>
	</c:forEach>

</c:if>

<c:if test="${action == 'addTopic' }">
	<div id="form">
		<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('registerTopic')}" name="registerTopic" class="formPubli">
			<fieldset id="fieldsetPubli">
				<legend id="legendPubli">Ajouter un thème</legend>
					<ol id="olPubli">
							<li id="liPubli"><label id="labelPubli">topic parent</label><select name="parentTopic">
															  	    <c:forEach items="${Attr_topicList}" var="topic" begin="0">
															  	     <option value='<c:out value="${topic['topicName']}"/>'> <c:out value="${topic['topicName']}"/></option>
															  	    </c:forEach>
															  </select></li>
							<li id="liPubli"><label id="labelPubli">nom du topic</label><input type="text" name="topicName" /> </li>
							<li id="liPubli"><label id="labelPubli">description du topic</label><input type="text" name="topicDesc" /></li>
							<li id="liPubli"><button type=submit >Envoyer</button></li>
					</ol>
			</fieldset>
		</form>
	</div>
</c:if>

<c:if test="${action == 'articlesOfAJournal' }">
	<c:out value="${ATTR_messagePubli }"/>
	<div id="ongletsJournal">
		<ul>
			<li><a href="#homeJournal">Submit paper</a></li>
			<li><a href="#viewArticles">View articles</a></li>
			<li><a href="#guideForAuthors">Guide for authors</a></li>
			<li><a href="#abstracting">Abstracting</a></li>
			<li><a href="#track">Track your paper</a></li>
		</ul>
	
	
		<div id="homeJournal">
			<c:out value="${journal['journalOrConfLongDesc']}"/><br />
			<button type=submit><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&journalID=<c:out value="${journalID}"/>">Submit your paper</a></button><br />
			<button type=submit><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('userDashboard')}&id_journal=<c:out value="${journalID}"/>">View my Dashboard</a></button> 
		</div>
	
		<div id="viewArticles">
			<c:forEach items="${ATTR_paperList}" var="paper" begin="0">
				<p>Paper Title : </p><c:out value="${paper['paperTitle']}"/>
				<p>Paper Abstract : </p><c:out value="${paper['paperAbstract']}"/>
				<p>Paper Keywords : </p><c:out value="${paper['paperKeywords']}"/>
				<p>Paper Submission Date : </p><c:out value="${paper['paperSubmissionDate']}"/>
				<p>Paper Validation Date : </p><c:out value="${paper['paperValidationDate']}"/>
			</c:forEach>
	     </div>
	
		<div id="guideForAuthors">
			Guide for authors
		</div>
	
		<div id="abstracting">
			Abstracting/indexing
		</div>
	
		<div id="track">
			Track your paper
		</div>
	
	</div>
	
</c:if>

<c:if test="${action == 'userDashboard' }">
	<c:out value="${message}" />
	<div id="ongletsPubli">
		<ul>
			<li><a href="#editorialBoard">Editorial board</a></li>
			<li><a href="#paperWaitingForValidation">Papers waiting for validation</a></li>
			<li><a href="#reviewersList">Reviewer List</a></li>
			<li><a href="#Retired">Retired</a></li>
			<li><a href="#volumeList">Volume list</a></li>
		</ul>
		<div id="editorialBoard">
			
		</div>	
		<div id="reviewersList">
			<table class="tablePubli" border="1">
                            <thead class="theadPubli">
                                <tr class="trPubli">
                                    <th class="thPubli">First name</th>
                                    <th class="thPubli">Last name</th>
                                    <th class="thPubli">Academic degree</th>
                                    <th class="thPubli">Institution</th>
                                    <th class="thPubli">Contact</th>
                                </tr>
                            </thead>
                            <tbody class="tbodyPubli">
                            	<c:forEach items="${ATTR_reviewersList}" var="reviewer" begin="0">
                                <tr class="trPubli">
                                    <th class="thPubli"><c:out value="${reviewer['userName']}"/></th>
                                    <th class="thPubli"><c:out value="${reviewer['userSurname']}"/></th>
                                    <th class="thPubli"></th>
                                    <th class="thPubli"><c:out value="${reviewer['additionalInfoId']['userCurrentInstitution']}"/></th>
                                    <th class="thPubli"><c:out value="${reviewer['userEmail']}"/></th>
                                </tr>
                                 </c:forEach>
                            </tbody>
                        </table>
		</div>		
		<div id="paperWaitingForValidation">
			<c:out value="${message}" />
			<ol id="olPubli">
				<c:forEach items="${ATTR_unreadPapers}" var="paper" begin="0">
					 <li id="liPubli"> <c:out value="${paper['paperTitle']}"/> <p>Submitted on: <c:out value="${paper['paperSubmissionDate']}"/></p><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('validationPaper1')}&id_journal=<c:out value="${journalID}"/>&id_papier=<c:out value="${paper['paperId']}"/>">Send for validation</a></li>
				</c:forEach>
			</ol>
		</div>
		<div id="Retired">
			<table class="tablePubli" border="1">
                            <thead class="theadPubli">
                                <tr class="trPubli">
                                    <th class="thPubli">First name</th>
                                    <th class="thPubli">Last name</th>
                                    <th class="thPubli">Academic degree</th>
                                    <th class="thPubli">Institution</th>
                                    <th class="thPubli">Contact</th>
                                </tr>
                            </thead>
                            <tbody class="tbodyPubli">
                            	<c:forEach items="${ATTR_reviewersList}" var="reviewer" begin="0">
                                <tr class="trPubli">
                                    <th class="thPubli"><c:out value="${reviewer['userName']}"/></th>
                                    <th class="thPubli"><c:out value="${reviewer['userSurname']}"/></th>
                                    <th class="thPubli"></th>
                                    <th class="thPubli"><c:out value="${reviewer['additionalInfoId']['userCurrentInstitution']}"/></th>
                                    <th class="thPubli"><c:out value="${reviewer['userEmail']}"/></th>
                                </tr>
                                 </c:forEach>
                            </tbody>
                        </table>
		</div>
		<div id="volumeList">
			<ol id="olPubli">
				<c:forEach items="${ATTR_volumeOfJournal}" var="volume" begin="0">
					 <li id="liPubli"> <c:out value="${volume['volumeOrIssueIdentifier']}"/></li>
				</c:forEach>
			</ol>
		</div>
	</div>
</c:if>

<c:if test="${action == 'printreviewersforvalidation' }">
	<div id="form">
		<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('sendMailForValidation')}" name="sendMailForValidation" id="registerPaper" class="formPubli" enctype="multipart/form-data">
			<fieldset id="fieldsetPubli">
				<legend id="legendPubli">Select reviewers</legend>
					<ol id="olPubli">
						<li id="liPubli"><label id="labelPubli">First reviewer</label><select name="firstReviewer" >
																							<option value='default'></option>
															  	    						<c:forEach items="${ATTR_reviewersList}" var="reviewer" begin="0">
															  	     							<option value='<c:out value="${reviewer['userName']}"/>'> <c:out value="${reviewer['userName']}"/></option>
															  	    						</c:forEach>
															  							</select></li>
															  						
                        <li id="liPubli"><label id="labelPubli">Second reviewer</label><select name="secondReviewer">
                        																		<option value='default'></option>
															  	    							<c:forEach items="${ATTR_reviewersList}" var="reviewer" begin="0">
															  	     								<option value='<c:out value="${reviewer['userName']}"/>'> <c:out value="${reviewer['userName']}"/></option>
															  	    							</c:forEach>
															  								</select></li>
															  								
															  								
						<li id="liPubli"><label id="labelPubli">Third reviewer</label><select name="thirdReviewer">
																								<option value='default'></option>
															  	    							<c:forEach items="${ATTR_reviewersList}" var="reviewer" begin="0">
															  	     								<option value='<c:out value="${reviewer['userName']}"/>'> <c:out value="${reviewer['userName']}"/></option>
															  	    							</c:forEach>
															  								</select></li>
															  							
						<li id="liPubli"><label id="labelPubli">Fourth reviewer</label><select name="fourthReviewer">
																								<option value='default'></option>
															  	    							<c:forEach items="${ATTR_reviewersList}" var="reviewer" begin="0">
															  	     								<option value='<c:out value="${reviewer['userName']}"/>'> <c:out value="${reviewer['userName']}"/></option>
															  	    							</c:forEach>
															  								</select></li>
						<li id="liPubli"><label id="labelPubli">Message to send to reviewers</label> <br />
							<textarea id="textareaPubli" name="messageForReviewers" rows="2" cols="80" ></textarea></li>
						<li id="liPubli"><input id="inputPubli" type="hidden" name="id_papier" value="<c:out value="${id_papier}" />" /></li>
						<li id="liPubli"><button type=submit >Send For Validation</button></li>
					</ol>
			</fieldset>
		</form>
	</div>
</c:if>

<c:if test="${action == 'reviewArticle' }">
	<form>
		<fieldset>
			<legend></legend>
			<ol>
				<li id="liPubli"><label id="labelPubli">Message to send to reviewers</label> <br />							<textarea id="textareaPubli" name="messageForReviewers" rows="2" cols="80" ></textarea></li>
			</ol>
		</fieldset>
	</form>
</c:if>