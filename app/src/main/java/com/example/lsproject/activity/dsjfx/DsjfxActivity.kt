package com.example.lsproject.activity.dsjfx

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View

import com.example.lsproject.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ViewPortHandler
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dsjfx.*
import java.util.ArrayList

class DsjfxActivity : BaseActivity() {

    private var type1 = ""
    private var type2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dsjfx)
        initView()
    }

    private fun initView() {
        setLeftBtn(true)
        type1 = intent.getStringExtra("type1")
        type2 = intent.getStringExtra("type2")
        when (type1) {
            "1" -> {
                when (type2) {
                    "1" -> {
                        setTextTitle("藏文优课上传量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.VISIBLE
                        tv_title1.text = "藏文优课上传前5名"
                        tv_title2.text = "藏文优课上传后5名"
                        setData(barChart1)
                        setData(barChart2)
                    }
                    "2" -> {
                        setTextTitle("藏文优课访问量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.GONE
                        tv_title1.text = "藏文优课访问前10名"
                        setData(barChart1)
                    }
                    "3" -> {
                        setTextTitle("藏文优课收藏量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.GONE
                        tv_title1.text = "藏文优课收藏前10名"
                        setData(barChart1)
                    }
                }
            }
            "2" -> {
                when (type2) {
                    "1" -> {
                        setTextTitle("本地资源上传量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.VISIBLE
                        tv_title1.text = "本地资源上传前5名"
                        tv_title2.text = "本地资源上传后5名"
                        setData(barChart1)
                        setData(barChart2)
                    }
                    "2" -> {
                        setTextTitle("本地资源访问量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.GONE
                        tv_title1.text = "本地资源访问前10名"
                        setData(barChart1)
                    }
                    "3" -> {
                        setTextTitle("本地资源收藏量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.GONE
                        tv_title1.text = "本地资源收藏前10名"
                        setData(barChart1)
                    }
                }
            }
            "3" -> {
                when (type2) {
                    "1" -> {
                        setTextTitle("全市资源上传量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.VISIBLE
                        tv_title1.text = "全市资源上传前5名"
                        tv_title2.text = "全市资源上传后5名"
                        setData(barChart1)
                        setData(barChart2)
                    }
                    "2" -> {
                        setTextTitle("全市资源访问量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.GONE
                        tv_title1.text = "全市资源访问前10名"
                        setData(barChart1)
                    }
                    "3" -> {
                        setTextTitle("全市资源收藏量")
                        ll_main1.visibility = View.VISIBLE
                        ll_main2.visibility = View.GONE
                        tv_title1.text = "全市资源收藏前10名"
                        setData(barChart1)
                    }
                }
            }
        }

    }

    fun setData(barChart: BarChart) {
        // 模拟数据
        val xAxisValue: ArrayList<String> = ArrayList()
        xAxisValue.add("第一名")
        xAxisValue.add("第二名")
        xAxisValue.add("第三名")
        xAxisValue.add("第四名")
        xAxisValue.add("第五名")
        val yAxisValue: ArrayList<Float> = ArrayList()
        yAxisValue.add(2f)
        yAxisValue.add(1f)
        yAxisValue.add(1f)
        yAxisValue.add(1f)
        yAxisValue.add(1f)
        setBarChart(barChart, xAxisValue, yAxisValue, "", 12f, Color.BLUE)
    }

    /**
     * 单数据集。设置柱状图样式，X轴为字符串，Y轴为数值
     *
     * @param barChart
     * @param xAxisValue
     * @param yAxisValue
     * @param title         图例文字
     * @param xAxisTextSize x轴标签字体大小
     * @param barColor
     */
    fun setBarChart(barChart: BarChart, xAxisValue: List<String>, yAxisValue: List<Float>, title: String, xAxisTextSize: Float, barColor: Int?) {
        barChart.description.isEnabled = false//设置描述
        barChart.setPinchZoom(true)//设置按比例放缩柱状图

        //x坐标轴设置
        val xAxisFormatter = StringAxisValueFormatter(xAxisValue)//设置自定义的x轴值格式化器
        val xAxis = barChart.xAxis//获取x轴
        xAxis.position = XAxis.XAxisPosition.BOTTOM//设置X轴标签显示位置
        xAxis.setDrawGridLines(false)//不绘制格网线
        xAxis.granularity = 1f//设置最小间隔，防止当放大时，出现重复标签。
        xAxis.valueFormatter = xAxisFormatter
        xAxis.textSize = xAxisTextSize//设置标签字体大小
        xAxis.labelCount = xAxisValue.size//设置标签显示的个数

        //y轴设置
        val leftAxis = barChart.axisLeft//获取左侧y轴
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)//设置y轴标签显示在外侧
        leftAxis.axisMinimum = 0f//设置Y轴最小值
        leftAxis.setDrawGridLines(true)
        leftAxis.setDrawLabels(true)//禁止绘制y轴标签
        leftAxis.setDrawAxisLine(true)//禁止绘制y轴

        barChart.axisRight.isEnabled = false//禁用右侧y轴

        //图例设置
        val legend = barChart.legend
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER//图例水平居中
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP//图例在图表上方
        legend.orientation = Legend.LegendOrientation.HORIZONTAL//图例的方向为水平
        legend.setDrawInside(false)//绘制在chart的外侧
        legend.direction = Legend.LegendDirection.LEFT_TO_RIGHT//图例中的文字方向

        legend.form = Legend.LegendForm.SQUARE//图例窗体的形状
        legend.formSize = 0f//图例窗体的大小
        legend.textSize = 16f//图例文字的大小
        //legend.setYOffset(-2f);

        //设置柱状图数据
        setBarChartData(barChart, yAxisValue, title, barColor)

        barChart.extraBottomOffset = 10f//距视图窗口底部的偏移，类似与paddingbottom
        barChart.extraTopOffset = 30f//距视图窗口顶部的偏移，类似与paddingtop
        barChart.setFitBars(true)//使两侧的柱图完全显示
        barChart.animateX(1500)//数据显示动画，从左往右依次显示
    }

    /**
     * 设置柱图
     *
     * @param barChart
     * @param yAxisValue
     * @param title
     * @param barColor
     */
    private fun setBarChartData(barChart: BarChart, yAxisValue: List<Float>, title: String, barColor: Int?) {

        val entries = ArrayList<BarEntry>()

        var i = 0
        val n = yAxisValue.size
        while (i < n) {
            entries.add(BarEntry(i.toFloat(), yAxisValue[i]))
            ++i
        }

        val set1: BarDataSet

        if (barChart.data != null && barChart.data.dataSetCount > 0) {
            set1 = barChart.data.getDataSetByIndex(0) as BarDataSet
            set1.values = entries
            barChart.data.notifyDataChanged()
            barChart.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(entries, title)
            if (barColor == null) {
                set1.color = ContextCompat.getColor(barChart.context, R.color.colorAccent)//设置set1的柱的颜色
            } else {
                set1.color = barColor
            }

            val dataSets = ArrayList<IBarDataSet>()
            dataSets.add(set1)

            val data = BarData(dataSets)
            data.setValueTextSize(10f)
            data.barWidth = 0.9f
            data.setValueFormatter(MyValueFormatter())

            barChart.data = data
        }
    }

    class MyValueFormatter : IValueFormatter {

        override fun getFormattedValue(value: Float, entry: Entry, dataSetIndex: Int, viewPortHandler: ViewPortHandler): String {
            return "" + value.toInt()
        }
    }

    /**
     * Created by Charlie on 2016/9/23.
     * 对字符串类型的坐标轴标记进行格式化
     */
    class StringAxisValueFormatter
    /**
     *     * 对字符串类型的坐标轴标记进行格式化
     *     * @param strs
     *    
     */
    (//区域值
            private val mStrs: List<String>) : IAxisValueFormatter {

        override fun getFormattedValue(v: Float, axisBase: AxisBase): String {
            return mStrs[v.toInt()]
        }
    }

}
