/**自定义模块*/
layui.define(['layer','element'], function (exports) {
	var $ = layui.jquery,
	layer = layui.layer,
	_doc = $(document),
	element = layui.element;

	var common = {
			/**
			 * 绑定特定的点击事件
			 */
			bind: function(callback, params) {
				var that = this,
				_config = that.config;
				var defaults = {
					target: undefined,
					showTips: true
				};
				$.extend(true, defaults, params);
				var _target = defaults.target === undefined ? _doc : $(defaults.target);
				_target.find('[data-operation]').each(function() {
					var _that = $(this);
					_that.off('click').on('click', function() {
						var options = _that.data('options');
						var data;
						if (options !== undefined) {
							try {
								data = new Function('return ' + options)();
							} catch (e) {
								layui.hint().error('Navbar 组件a[data-options]配置项存在语法错误：' + options)
							}
						} else {
							data = {
								type: _that.data('type'),
								icon: _that.data('icon'),
								skin: _that.data('skin'),
								title: _that.data('title'),
								url: _that.data('url'),
								width: _that.data('width'),
								height: _that.data('height'),
								resize:_that.data('resize'),
								anim:_that.data('anim'),
								maxmin:_that.data('maxmin'),
								object: _that.data('object'),
								remind: _that.data('remind'),
								cancel: _that.data('cancel'),
							};
						}
						if(data.type=="edit") {
							that.layerOpen2(data);
						}
						if(data.type=="delete") {
							that.ajaxConfirm(data.url,data.object,data.remind);
						}
						if(data.type=="set") {
							that.getAjax(null,data.url,data.object);
						}
						typeof callback === 'function' && callback(data);
					});
				});
			},
			/**
			 * 渲染
			 */
			render: function(callback) {
				var that = this;
				//绑定a标签的点击事件
				that.bind(function(data) {
					typeof callback === 'function' && callback(data);
				});
				return that;
			},	

			/**错误msg提示 哭脸*/
			layerErrorMsg:function (text) {
				layer.msg(text, {icon: 5});
			},
			/**成功 msg提示 笑脸*/
			layerSucMsg:function (text) {
				layer.msg(text, {icon: 6});
			},
			/**黑色背景提示*/
			layerMsg:function (text) {
				layer.msg(text);
			},
			/**右边提示**/
			layerTips:function(text,obj){
				layer.tips(text, obj);
			},
			/**ajax Confirm 对话框  obj 为搜索框对象*/
			ajaxConfirm: function (url,obj,remind) {
				var that = this;
				layer.confirm(remind, {
					title: "提示",
					resize: false,
					btn: ['确定', '取消'],
					btnAlign: 'c',
					anim:0,
					icon: 3
				}, function (index) {
					layer.close(index);
					that.getAjax(null,url,obj);
				}, function () {

				})
			},
			/**get ajax bj 为搜索框对象*/
			getAjax: function (index,url,obj) {
				var layerLoad  = common.layerLoad();
				$.ajax({
					url : url,
					type : 'post',
					async: true,
					cache:false,
					success : function(data) {
						layer.close(layerLoad);
						if(data.success){
							layer.msg("操作成功", {icon: 6});
							if(obj!=null){ //刷新
								if (obj == "reload") { //刷新当前页
									setTimeout(function() {
										location.reload();  //刷新父页面
									}, 1000);
								}else if (obj.indexOf("load") > 0) { //ajaxLink
									$(obj).sendByAjax(); //刷新模块
									setTimeout(function(){
										this.allRender();
									}, 500);
								}else {
									//搜索按钮
									$(obj).click();
								}
							}
						}else{
							layer.msg(data.message,{icon: 5});
						}
						if(index!=null){ //关闭弹出层
							layer.close(index);
						}
					},error:function(data){
						layer.close(layerLoad);
					}
				});
			},
			/**form post ajax 搜索框对象*/
			fromPostAjax: function (url,data) {
				var layerLoad  = common.layerLoad();
				
				$.ajax({
					url : url,
					type : 'post',
					async: true,
					data : data,
					cache:false,
					success : function(data) {
						//关闭加载
						layer.close(layerLoad);
						// 操作成功
						if(data.success){
							common.layerSucMsg("操作成功")
							if(typeof(parent.layer) != 'undefined') {
								setTimeout(function() {
									parent.location.reload();  //刷新父页面
									var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index); //再执行关闭
								}, 1000);
							}else {
								window.location.reload();
							}
						} else {
							common.layerErrorMsg(data.message);
						}
					},error:function(data){
						layer.close(layerLoad);
						common.layerErrorMsg("请求失败");
					}
				});
			},
			//异步提交更新自己
			fromPostAjaxRefresh: function (url,data) {
				var layerLoad  = common.layerLoad();
				$.ajax({
					url : url,
					type : 'post',
					async: true,
					data : data,
					cache:false,
					success : function(data) {
						//关闭加载
						layer.close(layerLoad);
						if(typeof(data.code)=='undefined'){
							common.layerErrorMsg("处理成功，但是返回的结果未知");
						} else if (data.code == 200) {
							common.layerSucMsg(data.message)
							setTimeout(function() {
								window.location.reload();
							}, 2000);
						} else {
							common.layerErrorMsg(data.message);
						}
					},error:function(data){
						layer.close(layerLoad);
						common.layerErrorMsg(data);
					}
				});
			},
			/**form post 不刷新父页面*/
			fromPostAjaxNoRefresh: function (url,data) {
				var layerLoad  = common.layerLoad();
				$.ajax({
					url : url,
					type : 'post',
					async: true,
					data : data,
					cache:false,
					success : function(data) {
						//关闭加载
						layer.close(layerLoad);
						if(typeof(data.code)=='undefined'){
							common.layerErrorMsg("处理成功，但是返回的结果未知");
						}else if (data.code == 200) {
							common.layerSucMsg(data.message)
							if(typeof(parent.layer) != 'undefined') {
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index); //再执行关闭 
							}
						} else {
							common.layerErrorMsg(data.message);
						}
					},error:function(data){
						layer.close(layerLoad);
						common.layerErrorMsg(data);
					}
				});
			},
			/**form post ajax*/
			fromPostAjax2: function (url,data,obj) {
				var layerLoad  = common.layerLoad();
				$.ajax({
					url : url,
					type : 'post',
					async: true,
					data : data,
					cache:false,
					success : function(data) {
						//关闭加载
						layer.close(layerLoad);
						if (data.code == 200) {
							common.layerSucMsg(data.message)
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							$(obj,parent.document).sendByAjax(); //刷新模块
							setTimeout(function(){
								parent.allRender();
								parent.layer.close(index); //再执行关闭 
							}, 500);
						} else {
							common.layerErrorMsg(data.message);
						}
					},error:function(data){
						layer.close(layerLoad);
						common.layerErrorMsg(data);
					}
				});
			},
			/**form post ajax*/
			fromPostAjaxReturn: function (url,data,obj) {
				var flag = false;
				var layerLoad  = common.layerLoad();
				$.ajax({
					url : url,
					type : 'post',
					async: false,
					data : data,
					cache:false,
					success : function(data) {
						//关闭加载
						layer.close(layerLoad);
						if (data.code == 200) {
							common.layerSucMsg(data.message);
							flag = true;
						} else {
							common.layerErrorMsg(data.message);
						}
					},error:function(data){
						layer.close(layerLoad);
						common.layerErrorMsg(data);
					}
				});
				return flag;
			},
			fromPostByAjaxLink: function (url,data,obj) {
				var layerLoad  = common.layerLoad();
				$.ajax({
					url : url,
					type : 'post',
					async: false,
					data : data,
					cache:false,
					success : function(data) {
						//关闭加载
						layer.close(layerLoad);
						if (data.code == 200) {
							common.layerSucMsg(data.message);
						} else {
							common.layerErrorMsg(data.message);
						}
						setTimeout(function(){
							 $(obj).sendByAjax();
						}, 1000);
					},
					error:function(data){
						layer.close(layerLoad);
						common.layerErrorMsg(data);
						
						setTimeout(function(){
							 $(obj).sendByAjax();
						}, 1000);
					}
				});
			},
			/**弹出层*/
			layerOpen:function (title,url,width,height) {
				var index = layer.open({
					title : '<i class="layui-icon">&#xe63c;</i>'+title,
					type : 2,
					skin : 'layui-layer-molv',
					content : url,
					area: [width, height],
					resize:false,
					anim:1,
					success : function(layero, index){

					}
				});
			},
			/**弹出层*/
			layerOpen2:function (data) {
				var icon=data.icon,
				title=data.title,
				skin=data.skin,
				url=data.url,
				width=data.width,
				height=data.height,
				resize=data.resize,
				anim=data.anim,
				maxmin=data.maxmin,
				full=data.full,
				cancel=data.cancel;
				object=data.object;
				var index = layer.open({
					title : '<i class="layui-icon">'+icon+'</i>'+title,
					type : 2,
					skin : skin,
					content : url,
					area: [width, height],
					resize:resize,
					anim:anim,
					maxmin: maxmin,
					success : function(layero, index){

					},cancel: function(){ 
						if (cancel) {
							if(object!=null){ //刷新
								if (object.indexOf("load") > 0) { //ajaxLink
									$(object).sendByAjax(); //刷新模块
									setTimeout(function(){
										this.allRender();
									}, 500);
								}
							}else {
								window.parent.cancel();
							}
						}
					}
				});
				if(full) {
					layer.full(index);
				}
			},
			/**弹出层-tip*/
			layerOpenTip:function (title,url,width,height) {
				var index = layer.open({
					title : '<i class="layui-icon">&#xe63c;</i>'+title,
					type : 2,
					skin : 'layui-layer-molv',
					content : url,
					area: [width, height],
					resize:false,
					anim:1,
					success : function(layero, index){
						setTimeout(function(){
							layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
								tips: [3, '#009f95']
							});
						},500)
					}
				});
			},
			/**退出*/
			logOut: function (title, text, url, type, dataType, data, callback) {
				parent.layer.confirm(text, {
					title: title,
					resize: false,
					btn: ['确定退出系统', '不，我点错了！'],
					btnAlign: 'c',
					icon: 3
				}, function () {
					location.href = url
				}, function () {

				})
			},
			/**load*/
			layerLoad: function () {
				return layer.load();
			},
			/**重置表格宽度*/
			resizeGrid:function (){
				$(".layui-table-view .layui-table").css("width", "100%");
				$(window).resize(function(){
					$(".layui-table-view .layui-table").css("width", "100%");
				});
			},
			//展示图片
			showImg:function (obj) {
				layer.photos({
				  photos: obj,
				  anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
				});
			},
			//重新渲染
			allRender:function (imgUrl) {
				element.init();
	    		this.render();
			},
			//关闭所有弹窗（按类型）
			closeAll:function(type) {
				layer.closeAll(type);
			}
	};
	exports('common', common)
})



