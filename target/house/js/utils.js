/**分页提交*/
function search(p){
	if(IsNumber(p)){
		document.getElementById("index").value=p;
		document.getElementById("formId").submit();
	}else{
		alert('请正确输入页码。');		
	}
}

/*字符串不能为空 */
function IsEmpty(string){
	var str = string.replace(/\s+/g,"");
	if (str==''){
		return true;
	}else{
		return false;
	}
}
function trim(string){
	var str = string.replace(/\s+/g,"");
	if (str == ''){
		return false;	
	}else{
		return str;
	}
}
/*是否是用户名，前台注册是用到*/
function IsUserName(string){
	var number = trim(string);
	if (number == false) return false;
	if(/^[a-zA-Z]{1}[a-zA-Z0-9]{1,}$/.test(string)) return true;
	else return false;	
}
/*字符串是否是数字 */
function IsNumber(string){
	var number = trim(string);
	if (number!=0 &&number == false){
		return false;	
	}
	if(/^[0-9]+$/.test(number)){
		return true;	
	}else{
		return false;	
	}
}
/* 手机号码验证,无alert  */
function IsMobileNoAlert(string){
	var mobile = trim(string);
	if (mobile == false){
		return false;	
	}else if(/^(?:13\d|15[0-9]|18[0-9])-?\d{5}(\d{3}|\*{3})$/.test(mobile)){
		return true;
	}else{
	    return false;
	}
}
/*Email格式验证 */
function IsEmail(email){
	if (email == false) return false;
	var patrn = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	if(patrn.test(email) == false) return false;
	else return true;
}

/**日期验证，string1在string2之前*/
function ComDate (string1, string2){
	if (DateTime(string1) == false) return false;
	if (DateTime(string2) == false) return false;
	var date1 = string1.replace(/\s+/g,"");
	var date2 = string2.replace(/\s+/g,"");
	var tmp1 = date1.split("-");
	var tmp2 = date2.split("-");
	var t1 = new Date(tmp1[0], tmp1[1], tmp1[2]);
	var t2 = new Date(tmp2[0], tmp2[1], tmp2[2]);
	var ft = t1.getTime() - t2.getTime() ;
	if (ft < 0) return 1;
	else if (ft == 0) return 2;
	else return 3;
}

/**验证是否全部包含中文字符*/
function CheckAllCnStr(str){
    if (str == false) return false;
	var filter = /[^\u4e00-\u9fa5]/;
    if (!filter.test(str)) return true;
    return false;
}
function CheckEnStr(str){
	if (str == false) return false;
    var filter = /^[a-zA-Z\/]+$/;
    if (filter.test(str)) return true;
    return false;
}

function checkNumAndChar(str){
	if (str == false) return false;
    var filter = /^[a-zA-Z0-9\/]+$/;
    if (filter.test(str)) return true;
    return false;
}
function checkIDCard(P_type, number) {
	var P_num = number.replace(/\s+/g,"");
	if (P_type == "1") {
		if(P_num.length != 15 && P_num.length !=18){
			return false;
		}else{
			return DocumentNum(number);
		}
	}else if(P_type == "103" ||P_type == "104"){
		if (P_num.length < 8 || P_num.length >10) {
			return false;
		}
	}
	return true;
}
// 正则判断是否是电话或者手机
function IsTelephone(obj){ 
	var mobile = trim(obj);
	var pattern=/(^[0-9]{3,4}\-[0-9]{5,8}$)|(^[0-9]{5,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/; 
	if(pattern.test(mobile)) { 
		return true; 
	}else{ 
		return false; 
	} 
} 
/* 票价验证,无alert  */
function priceCheck(string){
	var pattern=/^((\d+)|(\d+\.5)|(\d+\.0))$/;
	var price = trim(string);
	if (price == false){
		return false;	
	}else if(pattern.test(price)){
		return true;
	}else{
	    return false;
	}
}

var LT = {};
		/**
		 * @class Number
		 */
		LT.Number = {
		  /**
		   * 对目标数字进行0补齐处理
		   * @name LT.Number.pad
		   * @function
		   * @grammar LT.Number.pad(source, length)
		   * @param {number} source 需要处理的数字
		   * @param {number} length 需要输出的长度
		   * 
		   * @returns {string} 对目标数字进行0补齐处理后的结果
		   */
		  pad : function (source, length) {
		      var pre = "",
		          negative = (source < 0),
		          string = String(Math.abs(source));
		      if (string.length < length) {
		          pre = (new Array(length - string.length + 1)).join('0');
		      }
		      return (negative ?  "-" : "") + pre + string;
		  }
		 };

	
var DateF = {
  isString: function( object ) {
    return typeof object == 'string';
  },
  /**
   * 对目标日期对象进行格式化
   * @name DateF.format
   * @function
   * @grammar DateF.format(source, pattern)
   * @param {Date} source 目标日期对象
   * @param {string} pattern 日期格式化规则
   * @remark
   * 
  格式表达式，变量含义：
  hh: 带 0 补齐的两位 12 进制时表示
  h: 不带 0 补齐的 12 进制时表示
  HH: 带 0 补齐的两位 24 进制时表示
  H: 不带 0 补齐的 24 进制时表示
  mm: 带 0 补齐两位分表示
  m: 不带 0 补齐分表示
  ss: 带 0 补齐两位秒表示
  s: 不带 0 补齐秒表示
  yyyy: 带 0 补齐的四位年表示
  yy: 带 0 补齐的两位年表示
  MM: 带 0 补齐的两位月表示
  M: 不带 0 补齐的月表示
  dd: 带 0 补齐的两位日表示
  d: 不带 0 补齐的日表示
   * 
   * @returns {string} 格式化后的字符串
   */
	format : function (source, pattern) {
	      if (DateF.isString(source)) {
	        pattern = source;
	        source = null;
	      }
	      source = source || new Date();
	      pattern = pattern || "yyyy-MM-dd HH:mm:ss";
	      
	      function replacer(patternPart, result) {
	        pattern = pattern.replace(patternPart, result);
	      }
	      var pad = LT.Number.pad,
	        year = source.getFullYear(),
	        month = source.getMonth() + 1,
	        date2 = source.getDate(),
	        hours = source.getHours(),
	        minutes = source.getMinutes(),
	        seconds = source.getSeconds();
	      replacer(/yyyy/g, pad(year, 4));
	      replacer(/yy/g, pad(parseInt(year.toString().slice(2), 10), 2));
	      replacer(/MM/g, pad(month, 2));
	      replacer(/M/g, month);
	      replacer(/dd/g, pad(date2, 2));
	      replacer(/d/g, date2);
	      replacer(/HH/g, pad(hours, 2));
	      replacer(/H/g, hours);
	      replacer(/hh/g, pad(hours % 12, 2));
	      replacer(/h/g, hours % 12);
	      replacer(/mm/g, pad(minutes, 2));
	      replacer(/m/g, minutes);
	      replacer(/ss/g, pad(seconds, 2));
	      replacer(/s/g, seconds);
	      return pattern;
	}
};

//正则判断网站
function IsURL(str_url){
        var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
        + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
        + "[a-z]{2,6})" // first level domain- .com or .museum
        + "(:[0-9]{1,4})?" // 端口- :80
        + "((/?)|" // a slash isn't required if there is no file name
        + "(.+)+/?)$";
        var re=new RegExp(strRegex);
        //re.test()
        if (re.test(str_url)){
            return (true);
        }else{
            return (false);
        }
}