var mediaRefresh = {
	scanMedia : function(fileUri,successCallback,errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'MediaRefresher',
			'refresh',
			[fileUri]
		);
	}
}

module.exports = mediaRefresh;