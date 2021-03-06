package com.dsp.helloworld;
import android.app.Activity;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import com.androidplot.util.PixelUtils;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.*;
import java.util.Arrays;

public class SimpleXYPlotActivity extends Activity
{

    private XYPlot plot;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xy_plot_example);
        // initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.plot);

        // create a couple arrays of y-values to plot:
        //Number[] series1Numbers = {1, 4, 2, 8, 4, 16, 8, 32, 16, 64};
        Number[] series2Numbers = main_2.graph_var;

        // turn the above arrays into XYSeries':
        // (Y_VALS_ONLY means use the element index as the x value)
        //XYSeries series1 = new SimpleXYSeries(Arrays.asList(series1Numbers),
        //        SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");

        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        //LineAndPointFormatter series1Format = new LineAndPointFormatter();
        //series1Format.setPointLabelFormatter(new PointLabelFormatter());
        //series1Format.configure(getApplicationContext(),
        //        R.xml.line_point_formatter_with_labels);

        LineAndPointFormatter series2Format = new LineAndPointFormatter();
        //series2Format.setPointLabelFormatter(new PointLabelFormatter());
        //series2Format.configure(getApplicationContext(),
        //        R.xml.line_point_formatter_with_labels_2);

        // add an "dash" effect to the series2 line:
        series2Format.getLinePaint().setPathEffect(
                new DashPathEffect(new float[] {

                        // always use DP when specifying pixel sizes, to keep things consistent across devices:
                        PixelUtils.dpToPix(20),
                        PixelUtils.dpToPix(15)}, 0));

        // just for fun, add some smoothing to the lines:
        // see: http://androidplot.com/smooth-curves-and-androidplot/
//        series1Format.setInterpolationParams(
//                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        //series2Format.setInterpolationParams(
        //        new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        // add a new series' to the xyplot:
//        plot.addSeries(series1, series1Format);
        plot.addSeries(series2, series2Format);

        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);

        // rotate domain labels 45 degrees to make them more compact horizontally:
        plot.getGraphWidget().setDomainLabelOrientation(-45);

    }
}