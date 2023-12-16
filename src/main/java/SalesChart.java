import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.Map;

public class SalesChart extends ApplicationFrame {

    ArrayList<Shop> shopList = new ArrayList<>();

    public SalesChart(String title, ArrayList<Shop> shopList) {
        super(title);
        this.shopList = shopList;
        JFreeChart chart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Map<String, Double>> salesActivity = SalesTracker.getInstance().getSalesActivity();
        int j;
        for (int i = 0; i<salesActivity.size(); i++){
            j = i/5 + 1;
            for (String shop : salesActivity.get(i).keySet()){

                int sales = (int) Math.round(salesActivity.get(i).get(shop));
                dataset.addValue(sales, shop, "Day "+j);
            }
        }
        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createLineChart(
                "Daily Sales Chart",
                "Day",
                "Sales ($)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }
}
