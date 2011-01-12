// commonJSfunctions.js

function printerFriendly(formname, heightsize, widthsize, pfParam)
{
	newwin = window.open('about:blank',	'pfWin',
		'height='+heightsize+',width='+widthsize+',toolbar=no,directories=no,status=no,menubar=yes,scrollbars=yes,resizable=yes');
	
	var prevAction = formname.action;
	
	formname.target="pfWin";
	formname.action = formname.action + "?" + pfParam;
	formname.submit();
	
	formname.target="_self";
	formname.action = prevAction;
	
	newwin.focus();
}

/******************************************************************************
 * Hides the area with the given contentID. This function handles if the content
 * only appears once or multiple times. If there are multiple content
 * areas with this name, all areas will be hidden.
 ******************************************************************************/
function hideContent(contentID)
{
	var content = document.all.item(contentID);
	if (!content) return;
	
	if (content.length == null)		// if there is only one content
	{
		content.style.display = "none";
	}
	else	// else there are multiple areas with this content name
	{
		for (var i=0; i < content.length; i++)
		{
			content[i].style.display = "none";
		}
	}
}

/******************************************************************************
 * Shows the area with the given contentID. This function handles if the content
 * only appears once or multiple times. If there are multiple content
 * areas with this name, all areas will be shown.
 ******************************************************************************/
function showContent(contentID)
{
	var content = document.all.item(contentID);
	if (!content) return;
	
	if (content.length == null)		// if there is only one content
	{
		content.style.display = "";
	}
	else	// else there are multiple areas with this content name
	{
		for (var i=0; i < content.length; i++)
		{
			content[i].style.display = "";
		}
	}
}
