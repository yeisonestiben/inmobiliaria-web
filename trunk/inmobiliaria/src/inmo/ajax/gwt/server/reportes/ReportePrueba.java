package inmo.ajax.gwt.server.reportes;

import java.io.File;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ReportePrueba
{
	public String generarReporte (String path)
	{
		String filename = "resources/reports/" + new Date().getTime() + ".jpg";
		String nombre = path + filename;
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("A", new Integer(75));
		pieDataset.setValue("B", new Integer(10));
		pieDataset.setValue("C", new Integer(10));
		pieDataset.setValue("D", new Integer(5));

		JFreeChart chart = ChartFactory.createPieChart
		("CSC408 Mark Distribution",// Title
				pieDataset,					// Dataset
				true,						// Show legend
				true,						// Use tooltips
				false						// Configure chart to generate URLs?
		);
		try {
			File file = new File(nombre);
			ChartUtilities.saveChartAsJPEG(file, chart, 500, 300);
		} catch (Exception e) {
			System.out.println("Problem occurred creating chart.");
		}

		return filename;
	}
}
