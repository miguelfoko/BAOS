function authenticationDoTabs(activeTab){jQuery("#mod_auth_tabs").tabs({fx:{opacity: 'toggle', duration: 'fast'}}); jQuery("#mod_auth_tabs").tabs('select', parseInt(activeTab, 10));
	jQuery(".auth_edit_profile_button").click(function(){/*jQuery(window).scrollTo();*/ jQuery("#mod_auth_tab_edit_profile_link").click(); return false;});
}
/*jQuery(document).ready(function(){jQuery(".mod_auth_scrollable").jScrollbar({allowMouseWheel : true, scrollStep : 10, showOnHover : false, position : 'right'});});*/