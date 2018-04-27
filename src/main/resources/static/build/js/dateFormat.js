/**
 * 毫秒数转yyyy-MM-dd格式字符串
 */
var longToDateStr = function(time){
	var dateTime = new Date(time);
	return dateToDateStr(dateTime);
}; 
/**
 * 毫秒数转yyyy-MM-dd hh:mm:dd格式字符串
 */
var longToTimeStr = function(time){
	if(time == "" || time == undefined || time == null) {
		return "";
	}
	var dateTime = new Date(time);
	return dateToTimeStr(dateTime);
};

/**
 * 当前时间 yyyy-MM-dd hh:mm:dd格式字符串
 */
var currentTime = function() {
	var dateTime = new Date();
	return dateToTimeStr(dateTime);
}

/**
 * 日期转yyyy-MM-dd格式字符串
 */
var dateToDateStr = function(dateTime) {
	var year = dateTime.getFullYear(); 
	var month = dateTime.getMonth()+1; 
	if (month< 10) {
		month = "0"+month;
	}
	var date = dateTime.getDate();
	if (date < 10) {
		date = "0"+date;
	}
	return year+"-"+month+"-"+date; 
}
/**
 * 日期转yyyy-MM-dd hh:mm:dd格式字符串
 */
var dateToTimeStr = function(dateTime) {
	var year = dateTime.getFullYear(); 
	var month = dateTime.getMonth()+1; 
	if (month< 10) {
		month = "0"+month;
	}
	var date = dateTime.getDate();
	if (date < 10) {
		date = "0"+date;
	}
	var hour = dateTime.getHours();
	if (hour < 10) {
		hour = "0"+hour;
	}
	var minute = dateTime.getMinutes();
	if (minute < 10) {
		minute = "0"+minute;
	}
	var second = dateTime.getSeconds();
	if (second < 10) {
		second = "0"+second;
	}
	return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
}