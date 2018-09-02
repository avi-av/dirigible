var request = require("http/v3/request");
var response = require("http/v3/response");
var upload = require('http/v3/upload');
var documentLib = require("ide-documents/api/lib/document");
var folderLib = require("ide-documents/api/lib/folder");
var requestHandler = require("ide-documents/api/lib/request-handler");

var imageLib = require("ide-documents/api/lib/image");

requestHandler.handleRequest({
	handlers : {
		POST: handlePost
	},
});

function handlePost(){
	if (upload.isMultipartContent()) {
		var path = request.getParameter('path');
		if (path) { path = unescapePath(path); }
		var documents = upload.parseRequest();
		var result = [];
		var overwrite = request.getParameter('overwrite');
		var width = request.getParameter('width');
        var height = request.getParameter('height');
        
		
		for (var i = 0 ; i < documents.size(); i ++) {
			var folder = folderLib.getFolder(path);
            var name = documents.get(i).getName();
            if (width && height && name){
            	result.push(imageLib.uploadImageWithResize(folder, name, documents.get(i), parseInt(width), parseInt(height)));
            } else {
                result.push(documentLib.uploadDocument(folder, documents.get(i)));
            }
		}
	} else {
		printError(response.BAD_REQUEST, 4, "The request's content must be 'multipart'");
	}
	
	response.println(JSON.stringify(result));
}

function unescapePath(path){
	return path.replace(/\\/g, '');
}

function printError(httpCode, errCode, errMessage, errContext) {
    var body = {'err': {'code': errCode, 'message': errMessage}};
    response.setStatus(httpCode);
    response.print(JSON.stringify(body));
    console.error(JSON.stringify(body));
    if (errContext !== null) {
    	console.error(JSON.stringify(errContext));
    }
}
