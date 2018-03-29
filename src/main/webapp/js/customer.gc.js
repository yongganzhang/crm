$(function() {
	loadCustomerGc();
});

/**
 * 显示用户构成柱状图
 */
function loadCustomerGc() {
	$.ajax({
		type : "get",
		url : ctx + "/report/queryCustomersGc",
		dataType : "json",
		success : function(data) {
			if (data.code == '200') {
				var level = data.data.level;
				var count = data.data.count;
				myChartGC(level, count);
			} else {
				alert('暂无数据')
			}
		}
	});
}

/**
 * 生成 图表
 * 
 * @param {Object}
 *            level
 * @param {Object}
 *            count
 */
var myChartGC = function(level, count) {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	// 指定图表的配置项和数据
	var option = {
		title : {
			text : '客户构成分析'
		},
		tooltip : {},
		legend : {
			data : [ '数量' ]
		},
		xAxis : {
			data : level
		},
		yAxis : {},
		series : [ {
			name : '数量',
			type : 'bar',
			data : count
		} ]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}