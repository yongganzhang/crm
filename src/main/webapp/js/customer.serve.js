$(function() {
	loadCustomerServeData();
});

function loadCustomerServeData() {
	$.ajax({
		type : "GET",
		url : ctx + "/report/queryCustomersServerAnalysis",
		success : function(data) {
			if (data.code == '200') {
				var Legend = data.data.nameList;
				var customerServer = data.data.servers;
				myChartGC(Legend, customerServer);
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
var myChartGC = function(Legend, customerServer) {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	// 构建option对象
	var option = {
		title : {
			text : '客户服务分析',
			subtext : '来源真实',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			left : 'left',
			data : Legend
		},
		series : [ {
			name : '服务类别',
			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : customerServer,
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}