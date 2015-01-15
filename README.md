# Cordova Media Refresher 

# Description

This is a `Cordova plugin` to run a `Media Scan` on Android devices. After a successfull Media Scan all `media files (images,vidoes etc.)` shows up in the device gallery. By default media files downloaded from `file plugin` doesn't show up in gallery. 

### Version
1.0.0

Install using **Cordoda CLI**:

  

>  $  cordova plugin add https://github.com/saurabhgupta050890/Media-Refresher-Cordova.git

   
 **Install using Plugman:** 
 
   

> $ plugman --platform android --project /path/to/project --plugin https://github.com/saurabhgupta050890/Media-Refresher-Cordova.git


## Usage ##

This plugin takes one argument and two callbacks 
    
    

> filepURI: Local Path of the media file on device to be added in media gallery.

    var onSuccess = function(result) {
        //Gets the server response object in the form of a string.
        var serverResponse = JSON.parse(result);
    }
    
    var onFailure = function(errorMsg) {
        console.log("Media Refresh failed:" + errorMsg);
    }
    
    mediaRefresh.scanMedia(filepURI,onSuccess,onFailure);
    
    


