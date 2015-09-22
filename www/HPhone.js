/**
 * Created by ASC on 22/9/15.
 */


var cordova = require("cordova");

function P_Objeto() {
    this.detect = function(success) {
        var cb = success || function(){},
            er = function(e){alert("Error: " + e)};
        cordova.exec(cb,er,"CDVHPhone","detect",[]);
    };
}

module.exports = new P_Objeto();